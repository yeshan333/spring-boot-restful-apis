package com.example.bodymanagement.Service;

import com.alibaba.fastjson.JSONArray;

import java.io.IOException;

public interface CSVService {
    void CSVDown(JSONArray jsonArray,String userName) throws IOException;
}
