package com.example.bodymanagement.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.bodymanagement.Service.UserService;
import com.example.bodymanagement.entity.UserEntity;
import com.mongodb.client.result.DeleteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeleteController {
    @Autowired
    @Qualifier("UserService")
    private UserService userService;

//    @RequestMapping("/api/delete")
//    @ResponseBody
//    public List<UserEntity> DeleteUser(@RequestBody String id){
//         JSONObject jsonObject = (JSONObject) JSON.parse(id);
//         String object = (String) jsonObject.get("id");
//        return  userService.findUser(object);
//    }
    @RequestMapping("/api/deleteMulUser")
    @ResponseBody
    public void DeleteMulUser(@RequestBody String results){
         JSONObject jsonObject = (JSONObject) JSON.parse(results);
        JSONArray jsonArray =(JSONArray) jsonObject.getJSONArray("id");
        int size = jsonArray.size();
        String[] id_array = new String[size];
        for (int i = 0; i != size; ++i) {
            id_array[i] = jsonArray.getObject(i, String.class);
        }
        userService.deleteMulUserById(id_array);
    }
}
