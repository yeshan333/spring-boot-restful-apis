package com.example.bodymanagement.Service.Impl;

import com.alibaba.fastjson.JSONArray;
import com.example.bodymanagement.Service.CSVService;
import com.example.bodymanagement.Unit.CSVWrite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service("CSVService")
public class CSVServiceImpl implements CSVService {
    @Autowired
    private CSVWrite csvWrite;

    @Override
    public void CSVDown(JSONArray jsonArray,String userName) throws IOException {
        csvWrite.write(jsonArray,userName);
    }
}
