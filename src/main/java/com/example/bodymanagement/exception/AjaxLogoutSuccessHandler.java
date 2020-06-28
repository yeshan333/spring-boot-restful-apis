package com.example.bodymanagement.exception;

import com.alibaba.fastjson.JSON;
import com.example.bodymanagement.Enum.ResultEnum;
import com.example.bodymanagement.Enum.VO.ResultVO;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Service("AjaxLogoutSuccessHandler")
public class AjaxLogoutSuccessHandler implements LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json; charset=utf-8");
        httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
//        TokenBasedRememberMeServices tokenBasedRememberMeServices=new TokenBasedRememberMeServices();
        httpServletResponse.getWriter().write(JSON.toJSONString(ResultVO.result(ResultEnum.USER_LOGOUT_SUCCESS,true)));
    }
}
