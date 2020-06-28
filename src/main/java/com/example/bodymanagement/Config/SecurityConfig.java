package com.example.bodymanagement.Config;

import com.example.bodymanagement.Filter.JWTAuthenticationFilter;
import com.example.bodymanagement.Filter.JWTAuthorizationFilter;
import com.example.bodymanagement.exception.AjaxLogoutSuccessHandler;
import com.example.bodymanagement.exception.JWTAccessDeniedHandler;
import com.example.bodymanagement.exception.JWTAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.annotation.Resource;


/**
 * SpringSecurity的配置
 * 通过SpringSecurity的配置，将JWTLoginFilter，JWTAuthenticationFilter组合在一起
 */

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    @Qualifier("UserDetailImple")
    private UserDetailsService userDetailsService;
    @Autowired
    AjaxLogoutSuccessHandler logoutSuccessHandler;
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers( "/api/admin/**","/api/user/**").hasAnyRole("Role_ADMIN")
                .antMatchers("/api/user/**").hasAnyRole("Role_USER")
                // 测试用资源，需要验证了的用户才能访问
                .antMatchers("/api/admin/**","/api/user/**").authenticated()
                // 其他都放行了
                .anyRequest().permitAll()
                .and()
                .logout()

                .logoutUrl("/logout")
                .logoutSuccessHandler(logoutSuccessHandler)
                .and()
                .addFilter(new JWTAuthenticationFilter(authenticationManager()))
                .addFilter(new JWTAuthorizationFilter(authenticationManager()))
                // 不需要session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .exceptionHandling().authenticationEntryPoint(new JWTAuthenticationEntryPoint())
                .accessDeniedHandler(new JWTAccessDeniedHandler());      //添加无权限时的处理
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/api/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }
}
