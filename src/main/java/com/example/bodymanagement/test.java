package com.example.bodymanagement;

import junit.framework.TestCase;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.List;

public class test extends TestCase {
    public static final String ENCODE = "UTF-8";
    public void testApp(){
        try {
            System.out.println("开始读取csv");
            FileReader filereader = new FileReader("../Users/l/Desktop/新建 XLS 工作表.csv");
            System.out.println("文件名:"+filereader);
            BufferedReader bufferedReader = new BufferedReader(filereader);
            bufferedReader.readLine();// try-catch omitted
            CSVFormat format = CSVFormat.DEFAULT.withDelimiter(',');
            CSVParser parser = new CSVParser(bufferedReader, format);
            List<CSVRecord> records = parser.getRecords();//跳过第一行所有行的记录
            for(int i=0;i<records.size();i++){
                double[] temp=new double[records.get(i).size()];
                for(int j=0;j<records.get(i).size();j++){
                    temp[j]=Double.parseDouble(records.get(i).get(j));
                    System.out.print(temp[j]+" ");
                }
                for(int ii=0;ii<temp.length;ii++){
                    System.out.print(temp[ii]+"  ");
                }
                System.out.println();
            }
        }catch (Exception e){
            System.out.println("please check your upload");
        }

    }
    public void read() throws Exception
    {
        Reader reader = new InputStreamReader(new FileInputStream("C:\\Users\\l\\Desktop\\inbody570_data - 副本.csv"),"UTF-8");
//        Reader reader = new FileReader("C:\\Users\\l\\Desktop\\inbody570_data - 副本.csv","g","utf-8");
//        FileReader reader = new FileReader("C:\\Users\\l\\Desktop\\inbody570_data - 副本.csv");
        CSVParser parser = CSVFormat.DEFAULT.withHeader("ID","Age")
                .parse(reader);

        for (CSVRecord record : parser)
        {
            System.out
                    .println(record.get("ID")+":"+record.get("Age"));
        }
        reader.close();
    }

    public static void main(String[] args) throws Exception {
        test test=new test();
        test.read();
    }
}
