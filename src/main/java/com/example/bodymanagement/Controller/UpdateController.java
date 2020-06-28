package com.example.bodymanagement.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.bodymanagement.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
public class UpdateController {
    @Autowired
    @Qualifier("UserService")
    private UserService userService;

    @RequestMapping("/api/admin/updateuser")
    @ResponseBody
    public String updateuser(@RequestBody String result){
        return userService.UpdateUserById(result);
    }
}
