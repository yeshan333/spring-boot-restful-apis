package com.example.bodymanagement.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.bodymanagement.Service.InformationService;
import com.example.bodymanagement.Service.UserService;
import com.example.bodymanagement.Unit.UserNameFormJwtUtils;
import com.example.bodymanagement.entity.UserEntity;
import com.mongodb.client.result.DeleteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class DeleteController {
    @Autowired
    @Qualifier("UserService")
    private UserService userService;
    @Autowired
    @Qualifier("InformationService")
    private InformationService informationService;
    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    @RequestMapping(value = "/api/admin/deleteUser",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String DeleteUser(@RequestBody String id){
         JSONObject jsonObject = (JSONObject) JSON.parse(id);
         String object = (String) jsonObject.get("id");
        return  userService.deleteOneUserById(object);
    }

    /**
     * 管理员删除某个成员信息
     * @param result
     * @return
     */
    @RequestMapping(value = "/api/admin/deleteInfOne",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String deleteInfOne(@RequestBody String result){
        JSONObject jsonObject = (JSONObject) JSON.parse(result);
        String objectId = (String) jsonObject.get("id");
        String objectUserName = (String) jsonObject.get("user_name");
        return  informationService.deleteInfByid(objectId,objectUserName);
    }

    /**
     * 用户删除某条记录
     * @param result
     * @return
     */
    @RequestMapping(value = "/api/user/deleteInfOne",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String UserdeleteInfOner(HttpServletRequest request, @RequestBody String result){
        String userName= UserNameFormJwtUtils.GetUserName(request);
        JSONObject jsonObject = (JSONObject) JSON.parse(result);
        String objectId = (String) jsonObject.get("id");
        return  informationService.deleteInfByid(objectId,userName);
    }
    /**
     * 暂不不启用
     * @param results
     */
//    @RequestMapping(value = "/api/deleteMulUser",produces = {"application/json;charset=UTF-8"})
//    @ResponseBody
//    public void DeleteMulUser(@RequestBody String results){
//         JSONObject jsonObject = (JSONObject) JSON.parse(results);
//        JSONArray jsonArray =(JSONArray) jsonObject.getJSONArray("id");
//        int size = jsonArray.size();
//        String[] id_array = new String[size];
//        for (int i = 0; i != size; ++i) {
//            id_array[i] = jsonArray.getObject(i, String.class);
//        }
//        userService.deleteMulUserById(id_array);
//    }
}
