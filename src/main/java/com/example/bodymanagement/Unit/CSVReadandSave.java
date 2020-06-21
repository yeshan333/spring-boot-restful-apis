package com.example.bodymanagement.Unit;


import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class CSVReadandSave {
    public void read(String path) throws Exception
    {
        Reader reader = new InputStreamReader(new FileInputStream(path),"gbk");

        CSVParser parser = CSVFormat.DEFAULT
                .parse(reader);
        int flag=1;
        for (CSVRecord record : parser)
        {
            if (flag==1){
                flag=0;
                continue;
            }
            System.out
                    .println(record.get(0)+":"+record.get(1)+":"+record.get(2));

        }
        reader.close();
    }


}
