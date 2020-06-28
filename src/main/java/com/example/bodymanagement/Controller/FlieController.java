package com.example.bodymanagement.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.bodymanagement.Service.CSVService;
import com.example.bodymanagement.Service.InformationService;
import com.example.bodymanagement.Unit.JwtTokenUtils;
import com.example.bodymanagement.Unit.UserNameFormJwtUtils;
import org.apache.poi.ss.usermodel.Header;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

@RestController
public class FlieController {
    @Autowired
    @Qualifier("CSVService")
    private CSVService csvService;
    @Autowired
    @Qualifier("InformationService")
    private InformationService informationService;
//    @RequestMapping("/upload")
//    //文件上传
//    public void Upload(@RequestParam(name = "file") MultipartFile file) throws Exception {
//        //未指定目录保存到项目的根目录下面
//        String Filepath=file.getOriginalFilename();
//        BufferedOutputStream outputStream=new BufferedOutputStream(new FileOutputStream(Filepath));
//        outputStream.write(Filepath.getBytes());
//        outputStream.flush();
//        outputStream.close();
//
//    }

    /**
     * 导出mongodb数据到csv
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/api/user/download",produces = {"application/json;charset=UTF-8"})
    public ResponseEntity Download(HttpServletRequest request)throws Exception{
        //获取token中的username
        String userName=UserNameFormJwtUtils.GetUserName(request);
        String json= JSON.toJSONString(informationService.findOneAll(userName));
        JSONArray jsonArray= JSONObject.parseArray(json);
        //生成文件
        csvService.CSVDown(jsonArray,userName);

        FileSystemResource file=new FileSystemResource(userName+".CSV");
        HttpHeaders headers=new HttpHeaders();
        //在响应头中添加如下，设置下载文件的默认名称
        headers.add("Content-Disposition","attachment; filename=test.csv");
        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(file.contentLength())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(new InputStreamResource(file.getInputStream()));
    }

}
