package com.example.bodymanagement.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.bodymanagement.Service.UserService;
import com.example.bodymanagement.Unit.JwtTokenUtils;
import com.example.bodymanagement.Unit.UserNameFormJwtUtils;
import com.example.bodymanagement.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;


@RestController
public class RegisterController {
    @Autowired
    @Qualifier("UserService")
    private UserService userService;


    /**
     * 注册用户接口
     * @param result
     * @return
     */
    @RequestMapping(value = "/api/admin/register" ,method = RequestMethod.POST,produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String Register(@RequestBody String result){
        return userService.insertone(result);
    }
}
