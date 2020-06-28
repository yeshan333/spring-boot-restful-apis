package com.example.bodymanagement.Unit;

import com.example.bodymanagement.exception.TokenIsExpiredException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;

public class UserNameFormJwtUtils {
    public static String GetUserName(HttpServletRequest request){
        String tokenHeader = request.getHeader(JwtTokenUtils.TOKEN_HEADER);
        // 如果请求头中没有Authorization信息则直接放行了
        if (tokenHeader == null || !tokenHeader.startsWith(JwtTokenUtils.TOKEN_PREFIX)) {
            return "false";
        }
        String token = tokenHeader.replace(JwtTokenUtils.TOKEN_PREFIX, "");
        boolean expiration = JwtTokenUtils.isExpiration(token);
        if (expiration) {
            try {
                throw new TokenIsExpiredException("token超时了");
            } catch (TokenIsExpiredException e) {
                e.printStackTrace();
            }
        } else {
            String username = JwtTokenUtils.getUsername(token);
            return username;
        }

     return null;
    }
}
