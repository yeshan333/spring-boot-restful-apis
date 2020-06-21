package com.example.bodymanagement.Controller;


import com.alibaba.fastjson.JSON;


import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.util.TypeUtils;
import com.example.bodymanagement.Service.InformationService;
import com.example.bodymanagement.Service.UserService;
import com.example.bodymanagement.entity.InformationEntity;
import com.example.bodymanagement.entity.UserEntity;
//import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FindController {
    @Autowired
    @Qualifier("UserService")
    private UserService userService;
    @Autowired
    @Qualifier("InformationService")
    private InformationService informationService;
    @RequestMapping("/api/findalluser")
    public List<UserEntity> findalluser(){
        return userService.findAllUser();
    }

    /**
     * 模糊查找用户
     * @Author Mu_hui
     * @param result
     * @return
     */
    @RequestMapping("/api/findone1")

    public String info3(@RequestParam(name="callback",required = false) String callBack){
        JSONObject map = new JSONObject();
        map.put("msg","请求成功!");
        map.put("code","0000");
        map.put("data","获取到后端数据!");
        String result = map.toString();
        if(!StringUtils.isEmpty(callBack)){
            //如果是json请求，则包裹上回调函数
            return callBack + "(" + result + ")";
        }
        return result;
    }
    @RequestMapping("/api/findone")
    @ResponseBody
    public List<UserEntity> findone(@RequestBody String result){
        JSONObject jsonResult=(JSONObject) JSON.parse(result);
        String Id=(String) jsonResult.get("id");
        String Student_code=(String) jsonResult.get("student_code");
        String Student_name=(String) jsonResult.get("student_name");
        return userService.findUser(Id,Student_code,Student_name);
    }

    @RequestMapping("/api/user/findLatestInf")
    @ResponseBody
    public String findLatestInf(){

//        return jsonArray.toString();
        String  result= JSON.toJSONString(informationService.findLatestInf());
        return result;
    }
}
