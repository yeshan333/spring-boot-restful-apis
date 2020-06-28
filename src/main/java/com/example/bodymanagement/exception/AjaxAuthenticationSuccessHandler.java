package com.example.bodymanagement.exception;

import com.alibaba.fastjson.JSON;
import com.example.bodymanagement.Enum.ResultEnum;
import com.example.bodymanagement.Enum.VO.ResultVO;
import com.example.bodymanagement.Unit.JwtTokenUtils;
import com.example.bodymanagement.entity.JwtUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

public class AjaxAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        JwtUser userDetails = (JwtUser) authentication.getPrincipal();
        JwtUser jwtUser=new JwtUser();
        String role = "";
        Collection<? extends GrantedAuthority> authorities = jwtUser.getAuthorities();
        for (GrantedAuthority authority : authorities){
            role = authority.getAuthority();
        }
        String jwtToken = JwtTokenUtils.createToken(userDetails.getUsername(), role,true);

        httpServletResponse.getWriter().write(JSON.toJSONString(ResultVO.result(ResultEnum.USER_LOGIN_SUCCESS,jwtToken,true)));
    }


}
