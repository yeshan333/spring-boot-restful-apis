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
    @RequestMapping(value = "/api/user/insertone/{student_code}",method = RequestMethod.POST)
    @ResponseBody
    public String insertone(@RequestBody String result){
        informationService.insertInfOne(result);
        return "ok";
    }
//    @RequestMapping(value = "/api/user/insertone",method = RequestMethod.POST)
//    @ResponseBody
//    public String insertone(@RequestBody String result){
//        informationService.insertInfOne(result);
//        return "ok";
//    }
}
