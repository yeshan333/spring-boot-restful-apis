package com.example.bodymanagement.Controller;


import com.alibaba.fastjson.JSON;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.util.TypeUtils;
import com.example.bodymanagement.Service.InformationService;
import com.example.bodymanagement.Service.UserService;
import com.example.bodymanagement.Unit.CSVWrite;
import com.example.bodymanagement.Unit.UserNameFormJwtUtils;
import com.example.bodymanagement.entity.InformationEntity;
import com.example.bodymanagement.entity.UserEntity;
//import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@RestController
public class FindController {
    @Autowired
    @Qualifier("UserService")
    private UserService userService;
    @Autowired
    @Qualifier("InformationService")
    private InformationService informationService;

    /**
     *查询所有用户
     * @return
     */
    @RequestMapping(value = "/api/admin/findalluser",produces = {"application/json;charset=UTF-8"})
    public String findalluser() {
        String json=JSON.toJSONString(userService.findAllUser());
        return json;
    }

    /**
     * 模糊查找用户
     *
     * @param result
     * @return
     * @Author Mu_hui
     */
    @RequestMapping(value ="/api/admin/findone",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String findone(@RequestBody String result) {
        JSONObject jsonResult = (JSONObject) JSON.parse(result);
        String User_name = (String) jsonResult.get("user_name");
        String Student_code = (String) jsonResult.get("student_code");
        String Student_name = (String) jsonResult.get("student_name");
        String res=JSON.toJSONString(userService.findUser(User_name,Student_code,Student_name));
        return res;
    }

    /**
     * 查找最新插入的信息
     * @return
     */
    @RequestMapping(value = "/api/findLatestInf/{user_name}",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String findLatestInf(@PathVariable("user_name") String user_name) {

        return informationService.findLatestInf(user_name);
    }

    /**
<<<<<<< HEAD
     * 查询某个人的所以实验信息
=======
     * 查询个人的所以实验信息
>>>>>>> 68ad2bd... "修复部分bug"
     * @param request
     * @return
     */
    @RequestMapping(value = "/api/user/findselfInf",produces ={"application/json;charset=UTF-8"} )
    @ResponseBody
    public String findselfInf(HttpServletRequest request){
        String userName= UserNameFormJwtUtils.GetUserName(request);
        return informationService.findOneAll(userName);
    }

    /**
     * 根据用户锁定表，在根据时间模糊查询
     * @param request
     * @param result
     * @return
     */
    @RequestMapping(value = "/api/user/findselfInfOne",produces ={"application/json;charset=UTF-8"} )
    @ResponseBody
    public String findselfInfOne(HttpServletRequest request,@RequestBody String result){
        String userName= UserNameFormJwtUtils.GetUserName(request);
        JSONObject jsonResult = (JSONObject) JSON.parse(result);
        String dataTime = (String) jsonResult.get("DateTime");
        return informationService.findselfInfOne(userName,dataTime);
    }



    @RequestMapping(value = "/api/admin/finduserinf",produces ={"application/json;charset=UTF-8"} )
    @ResponseBody
    public String finduserinf(@RequestBody String result){

        JSONObject jsonResult = (JSONObject) JSON.parse(result);
        String userName = (String) jsonResult.get("user_name");
        return informationService.Adminfinduser(userName);
    }

}
