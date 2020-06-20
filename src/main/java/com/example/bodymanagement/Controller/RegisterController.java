package com.example.bodymanagement.Controller;

import com.example.bodymanagement.Service.UserService;
import com.example.bodymanagement.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;


@RestController
public class RegisterController {
    @Autowired
    @Qualifier("UserService")
    private UserService userService;
    @RequestMapping(value = "/api/register" ,method = RequestMethod.POST)
    @ResponseBody
    public String Register(@RequestBody UserEntity userEntity){
        String result=userService.insertone(userEntity);
        return result;
    }
}
