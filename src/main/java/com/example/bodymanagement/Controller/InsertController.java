package com.example.bodymanagement.Controller;

import com.example.bodymanagement.Service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@RestController
public class InsertController {
    @Autowired
    @Qualifier("InformationService")
    private InformationService informationService;


    /**
     * 根据student_name查询是否存在，存在则创建/插入student_name 表
     * @param result
     * @param student_name
     * @return
     */
    /**
     *个人表示疑似有问题
     */
    @RequestMapping(value = "/insertone/{student_name}",method = RequestMethod.POST,produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String insertone(@RequestBody String result,@PathVariable("student_name")String student_name){
        return informationService.insertInfOne(result,student_name);
    }
}
