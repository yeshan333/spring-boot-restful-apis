package com.example.bodymanagement.Unit;

import com.example.bodymanagement.entity.InformationEntity;
import jxl.Workbook;
import jxl.WorkbookSettings;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelRead {

    public List<InformationEntity> readExcel(MultipartFile uploadFile, HttpServletRequest request){
        List<InformationEntity> informationEntitys = new ArrayList<InformationEntity>();
        HSSFWorkbook wb = null;
        InputStream ins = null;
        try {
            ins = uploadFile.getInputStream();
            wb = new HSSFWorkbook(ins);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally{
            try {
                ins.close();
                wb.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        HSSFSheet sheetAt = wb.getSheetAt(0);

        if(sheetAt!=null){
            for(int rowNum=1;rowNum<=sheetAt.getLastRowNum();rowNum++){
                HSSFRow xRow = sheetAt.getRow(rowNum);
                if(xRow==null){
                    continue;
                }
                InformationEntity informationEntity = new InformationEntity();
                informationEntity.setID(xRow.getCell(0).toString());
                informationEntity.setHeight(xRow.getCell(1).toString());
                informationEntity.setGender(xRow.getCell(2).toString());
                informationEntity.setAge(xRow.getCell(3).toString());
                informationEntity.setDateTime(xRow.getCell(4).toString());
                informationEntity.setWeight(xRow.getCell(5).toString());
                informationEntity.setLower_Limit_Weight(xRow.getCell(6).toString());
                informationEntity.setUpper_Limit_Weight(xRow.getCell(7).toString());
                informationEntity.setTBW(xRow.getCell(8).toString());
                informationEntity.setLower_Limit_TBW(xRow.getCell(9).toString());
                informationEntity.setUpper_Limit_TBW(xRow.getCell(10).toString());
                informationEntity.setICW(xRow.getCell(11).toString());
                informationEntity.setLower_Limit_ICW(xRow.getCell(12).toString());
                informationEntity.setUpper_Limit_ICW(xRow.getCell(13).toString());
                informationEntity.setECW(xRow.getCell(14).toString());
                informationEntity.setLower_Limit_ECW(xRow.getCell(15).toString());
                informationEntity.setUpper_Limit_ECW(xRow.getCell(16).toString());
                informationEntity.setProtein(xRow.getCell(17).toString());
                informationEntity.setLower_Limit_Protein(xRow.getCell(18).toString());
                informationEntity.setUpper_Limit_Protein(xRow.getCell(19).toString());
                informationEntity.setMineral(xRow.getCell(20).toString());
                informationEntity.setLower_Limit_Mineral(xRow.getCell(21).toString());
                informationEntity.setUpper_Limit_Mineral(xRow.getCell(22).toString());
                informationEntity.setBFM(xRow.getCell(23).toString());
                informationEntity.setLower_Limit_BFM(xRow.getCell(24).toString());
                informationEntity.setUpper_Limit_BFM(xRow.getCell(25).toString());
                informationEntity.setSLM(xRow.getCell(26).toString());
                informationEntity.setLower_Limit_SLM(xRow.getCell(27).toString());
                informationEntity.setUpper_Limit_SLM(xRow.getCell(28).toString());
                informationEntity.setFFM(xRow.getCell(29).toString());
                informationEntity.setLower_Limit_FFM(xRow.getCell(30).toString());
                informationEntity.setUpper_Limit_FFM(xRow.getCell(31).toString());
                informationEntity.setSMM(xRow.getCell(32).toString());
                informationEntity.setLower_Limit_SMM(xRow.getCell(33).toString());
                informationEntity.setUpper_Limit_SMM(xRow.getCell(34).toString());
                informationEntity.setBMI(xRow.getCell(35).toString());
                informationEntity.setLower_Limit_BMI(xRow.getCell(36).toString());
                informationEntity.setUpper_Limit_BMI(xRow.getCell(37).toString());
                informationEntity.setPercent_Body_Fat(xRow.getCell(38).toString());
                informationEntity.setLower_Limit_Percent_Body_Fat(xRow.getCell(39).toString());
                informationEntity.setUpper_Limit_Percent_Body_Fat(xRow.getCell(40).toString());
                informationEntity.setFFM_of_Right_Arm(xRow.getCell(41).toString());
                informationEntity.setLower_Limit_FFM_of_Right_Arm(xRow.getCell(42).toString());
                informationEntity.setUpper_Limit_FFM_of_Right_Arm(xRow.getCell(43).toString());
                informationEntity.setFFM_Persents_of_Right_Arm(xRow.getCell(44).toString());
                informationEntity.setFFM_of_Left_Arm(xRow.getCell(45).toString());
                informationEntity.setLower_Limit_FFM_of_Left_Arm(xRow.getCell(46).toString());
                informationEntity.setUpper_Limit_FFM_of_Left_Arm(xRow.getCell(47).toString());
                informationEntity.setFFM_Persents_of_Left_Arm(xRow.getCell(48).toString());
                informationEntity.setFFM_of_Trunk(xRow.getCell(49).toString());
                informationEntity.setLower_Limit_FFM_of_Trunk(xRow.getCell(50).toString());
                informationEntity.setUpper_Limit_FFM_of_Trunk(xRow.getCell(51).toString());
                informationEntity.setFFM_Persents_of_Trunk(xRow.getCell(52).toString());
                informationEntity.setFFM_of_Right_Leg(xRow.getCell(53).toString());
                informationEntity.setLower_Limit_FFM_of_Right_Leg(xRow.getCell(54).toString());
                informationEntity.setUpper_Limit_FFM_of_Right_Leg(xRow.getCell(55).toString());
                informationEntity.setFFM_Persents_of_Right_Leg(xRow.getCell(56).toString());
                informationEntity.setUpper_Limit_FFM_of_Left_Leg(xRow.getCell(57).toString());
                informationEntity.setLower_Limit_Upper_Limit_FFM_of_Left_Leg(xRow.getCell(58).toString());
                informationEntity.setUpper_Limit_Upper_Limit_FFM_of_Left_Leg(xRow.getCell(59).toString());
                informationEntity.setFFM_Persents_of_Left_Leg(xRow.getCell(60).toString());
                informationEntity.setECW_TBW(xRow.getCell(61).toString());
                informationEntity.setBFM_of_Right_Arm(xRow.getCell(62).toString());
                informationEntity.setBFM_Persents_of_Right_Arm(xRow.getCell(63).toString());
                informationEntity.setBFM_of_Left_Arm(xRow.getCell(64).toString());
                informationEntity.setBFM_Persents_of_Left_Arm(xRow.getCell(65).toString());
                informationEntity.setBFM_of_Trunk(xRow.getCell(66).toString());
                informationEntity.setBFM_Persents_of_Trunk(xRow.getCell(67).toString());
                informationEntity.setBFM_of_Right_Leg(xRow.getCell(68).toString());
                informationEntity.setBFM_Persents_of_Right_Leg(xRow.getCell(69).toString());
                informationEntity.setBFM_of_Left_Leg(xRow.getCell(70).toString());
                informationEntity.setBFM_Persents_of_Left_Leg(xRow.getCell(71).toString());
                informationEntity.setInbody_Score(xRow.getCell(72).toString());
                informationEntity.setTarget_Weight(xRow.getCell(73).toString());
                informationEntity.setWeight_Control(xRow.getCell(74).toString());
                informationEntity.setBFM_Control(xRow.getCell(75).toString());
                informationEntity.setFFM_Control(xRow.getCell(76).toString());
                informationEntity.setBasal_Metabolic_Rate(xRow.getCell(77).toString());
                informationEntity.setWaist_Hip_Ratio(xRow.getCell(78).toString());
                informationEntity.setLower_Limit_Waist_Hip_Ratio(xRow.getCell(79).toString());
                informationEntity.setUpper_Limit_Waist_Hip_Ratio(xRow.getCell(80).toString());
                informationEntity.setVisceral_Fat_Level(xRow.getCell(81).toString());
                informationEntity.setObesity_Degree(xRow.getCell(82).toString());
                informationEntity.setLower_Limit_Obesity_Degree(xRow.getCell(83).toString());
                informationEntity.setUpper_Limit_Obesity_Degree(xRow.getCell(84).toString());
                informationEntity.setBody_Cell_Mass(xRow.getCell(85).toString());
                informationEntity.setLower_Limit_Body_Cell_Mass(xRow.getCell(86).toString());
                informationEntity.setUpper_Limit_Body_Cell_Mass(xRow.getCell(87).toString());
                informationEntity.setArm_Circumference(xRow.getCell(88).toString());
                informationEntity.setArm_Muscle_Circumference(xRow.getCell(89).toString());
                informationEntity.setBone_Mineral_Content(xRow.getCell(90).toString());
                informationEntity.setLower_Limit_Bone_Mineral_Content(xRow.getCell(91).toString());
                informationEntity.setUpper_Limit_Bone_Mineral_Content(xRow.getCell(92).toString());
                informationEntity.setRA_5K(xRow.getCell(93).toString());
                informationEntity.setLA_5K(xRow.getCell(94).toString());
                informationEntity.setTR_5K(xRow.getCell(95).toString());
                informationEntity.setRL_5K(xRow.getCell(96).toString());
                informationEntity.setLL_5K(xRow.getCell(97).toString());
                informationEntity.setRA_50K(xRow.getCell(98).toString());
                informationEntity.setLA_50K(xRow.getCell(99).toString());
                informationEntity.setTR_50K(xRow.getCell(100).toString());
                informationEntity.setRL_50K(xRow.getCell(101).toString());
                informationEntity.setLL_50K(xRow.getCell(102).toString());
                informationEntity.setRA_500K(xRow.getCell(103).toString());
                informationEntity.setLA_500K(xRow.getCell(104).toString());
                informationEntity.setTR_500K(xRow.getCell(105).toString());
                informationEntity.setRL_500K(xRow.getCell(106).toString());
                informationEntity.setLL_500K(xRow.getCell(107).toString());
                informationEntity.setGestational_Period(xRow.getCell(108).toString());
                informationEntity.setWaist(xRow.getCell(109).toString());
                informationEntity.setHipshot(xRow.getCell(110).toString());
                informationEntity.setPrePregnancy_Weight(xRow.getCell(111).toString());
                informationEntitys.add(informationEntity);

            }
        }
        return informationEntitys;
    }

    public List<InformationEntity> readExcel2(MultipartFile uploadFile,HttpServletRequest request){
        List<InformationEntity> users = new ArrayList<InformationEntity>();
        WorkbookSettings setEncode = new WorkbookSettings();
        setEncode.setEncoding("UTF-8");
        XSSFWorkbook wb = null;
        InputStream ins = null;
        try {
            //此时的Workbook应该是从 客户端浏览器上传过来的 uploadFile了,其实跟读取本地磁盘的一个样
            ins = uploadFile.getInputStream();

            wb = new XSSFWorkbook(ins);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally{
            try {
                ins.close();
                wb.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        XSSFSheet sheetAt = wb.getSheetAt(0);

        if(sheetAt!=null){
            //遍历excel,从第二行开始 即 rowNum=1,逐个获取单元格的内容,然后进行格式处理,最后插入数据库
            for(int rowNum=1;rowNum<=sheetAt.getLastRowNum();rowNum++){
                XSSFRow xRow = sheetAt.getRow(rowNum);
                if(xRow==null){
                    continue;
                }
                InformationEntity informationEntity = new InformationEntity();
                informationEntity.setID(xRow.getCell(0).toString());
                informationEntity.setHeight(xRow.getCell(1).toString());
                informationEntity.setGender(xRow.getCell(2).toString());
                informationEntity.setAge(xRow.getCell(3).toString());
                informationEntity.setDateTime(xRow.getCell(4).toString());
                informationEntity.setWeight(xRow.getCell(5).toString());
                informationEntity.setLower_Limit_Weight(xRow.getCell(6).toString());
                informationEntity.setUpper_Limit_Weight(xRow.getCell(7).toString());
                informationEntity.setTBW(xRow.getCell(8).toString());
                informationEntity.setLower_Limit_TBW(xRow.getCell(9).toString());
                informationEntity.setUpper_Limit_TBW(xRow.getCell(10).toString());
                informationEntity.setICW(xRow.getCell(11).toString());
                informationEntity.setLower_Limit_ICW(xRow.getCell(12).toString());
                informationEntity.setUpper_Limit_ICW(xRow.getCell(13).toString());
                informationEntity.setECW(xRow.getCell(14).toString());
                informationEntity.setLower_Limit_ECW(xRow.getCell(15).toString());
                informationEntity.setUpper_Limit_ECW(xRow.getCell(16).toString());
                informationEntity.setProtein(xRow.getCell(17).toString());
                informationEntity.setLower_Limit_Protein(xRow.getCell(18).toString());
                informationEntity.setUpper_Limit_Protein(xRow.getCell(19).toString());
                informationEntity.setMineral(xRow.getCell(20).toString());
                informationEntity.setLower_Limit_Mineral(xRow.getCell(21).toString());
                informationEntity.setUpper_Limit_Mineral(xRow.getCell(22).toString());
                informationEntity.setBFM(xRow.getCell(23).toString());
                informationEntity.setLower_Limit_BFM(xRow.getCell(24).toString());
                informationEntity.setUpper_Limit_BFM(xRow.getCell(25).toString());
                informationEntity.setSLM(xRow.getCell(26).toString());
                informationEntity.setLower_Limit_SLM(xRow.getCell(27).toString());
                informationEntity.setUpper_Limit_SLM(xRow.getCell(28).toString());
                informationEntity.setFFM(xRow.getCell(29).toString());
                informationEntity.setLower_Limit_FFM(xRow.getCell(30).toString());
                informationEntity.setUpper_Limit_FFM(xRow.getCell(31).toString());
                informationEntity.setSMM(xRow.getCell(32).toString());
                informationEntity.setLower_Limit_SMM(xRow.getCell(33).toString());
                informationEntity.setUpper_Limit_SMM(xRow.getCell(34).toString());
                informationEntity.setBMI(xRow.getCell(35).toString());
                informationEntity.setLower_Limit_BMI(xRow.getCell(36).toString());
                informationEntity.setUpper_Limit_BMI(xRow.getCell(37).toString());
                informationEntity.setPercent_Body_Fat(xRow.getCell(38).toString());
                informationEntity.setLower_Limit_Percent_Body_Fat(xRow.getCell(39).toString());
                informationEntity.setUpper_Limit_Percent_Body_Fat(xRow.getCell(40).toString());
                informationEntity.setFFM_of_Right_Arm(xRow.getCell(41).toString());
                informationEntity.setLower_Limit_FFM_of_Right_Arm(xRow.getCell(42).toString());
                informationEntity.setUpper_Limit_FFM_of_Right_Arm(xRow.getCell(43).toString());
                informationEntity.setFFM_Persents_of_Right_Arm(xRow.getCell(44).toString());
                informationEntity.setFFM_of_Left_Arm(xRow.getCell(45).toString());
                informationEntity.setLower_Limit_FFM_of_Left_Arm(xRow.getCell(46).toString());
                informationEntity.setUpper_Limit_FFM_of_Left_Arm(xRow.getCell(47).toString());
                informationEntity.setFFM_Persents_of_Left_Arm(xRow.getCell(48).toString());
                informationEntity.setFFM_of_Trunk(xRow.getCell(49).toString());
                informationEntity.setLower_Limit_FFM_of_Trunk(xRow.getCell(50).toString());
                informationEntity.setUpper_Limit_FFM_of_Trunk(xRow.getCell(51).toString());
                informationEntity.setFFM_Persents_of_Trunk(xRow.getCell(52).toString());
                informationEntity.setFFM_of_Right_Leg(xRow.getCell(53).toString());
                informationEntity.setLower_Limit_FFM_of_Right_Leg(xRow.getCell(54).toString());
                informationEntity.setUpper_Limit_FFM_of_Right_Leg(xRow.getCell(55).toString());
                informationEntity.setFFM_Persents_of_Right_Leg(xRow.getCell(56).toString());
                informationEntity.setUpper_Limit_FFM_of_Left_Leg(xRow.getCell(57).toString());
                informationEntity.setLower_Limit_Upper_Limit_FFM_of_Left_Leg(xRow.getCell(58).toString());
                informationEntity.setUpper_Limit_Upper_Limit_FFM_of_Left_Leg(xRow.getCell(59).toString());
                informationEntity.setFFM_Persents_of_Left_Leg(xRow.getCell(60).toString());
                informationEntity.setECW_TBW(xRow.getCell(61).toString());
                informationEntity.setBFM_of_Right_Arm(xRow.getCell(62).toString());
                informationEntity.setBFM_Persents_of_Right_Arm(xRow.getCell(63).toString());
                informationEntity.setBFM_of_Left_Arm(xRow.getCell(64).toString());
                informationEntity.setBFM_Persents_of_Left_Arm(xRow.getCell(65).toString());
                informationEntity.setBFM_of_Trunk(xRow.getCell(66).toString());
                informationEntity.setBFM_Persents_of_Trunk(xRow.getCell(67).toString());
                informationEntity.setBFM_of_Right_Leg(xRow.getCell(68).toString());
                informationEntity.setBFM_Persents_of_Right_Leg(xRow.getCell(69).toString());
                informationEntity.setBFM_of_Left_Leg(xRow.getCell(70).toString());
                informationEntity.setBFM_Persents_of_Left_Leg(xRow.getCell(71).toString());
                informationEntity.setInbody_Score(xRow.getCell(72).toString());
                informationEntity.setTarget_Weight(xRow.getCell(73).toString());
                informationEntity.setWeight_Control(xRow.getCell(74).toString());
                informationEntity.setBFM_Control(xRow.getCell(75).toString());
                informationEntity.setFFM_Control(xRow.getCell(76).toString());
                informationEntity.setBasal_Metabolic_Rate(xRow.getCell(77).toString());
                informationEntity.setWaist_Hip_Ratio(xRow.getCell(78).toString());
                informationEntity.setLower_Limit_Waist_Hip_Ratio(xRow.getCell(79).toString());
                informationEntity.setUpper_Limit_Waist_Hip_Ratio(xRow.getCell(80).toString());
                informationEntity.setVisceral_Fat_Level(xRow.getCell(81).toString());
                informationEntity.setObesity_Degree(xRow.getCell(82).toString());
                informationEntity.setLower_Limit_Obesity_Degree(xRow.getCell(83).toString());
                informationEntity.setUpper_Limit_Obesity_Degree(xRow.getCell(84).toString());
                informationEntity.setBody_Cell_Mass(xRow.getCell(85).toString());
                informationEntity.setLower_Limit_Body_Cell_Mass(xRow.getCell(86).toString());
                informationEntity.setUpper_Limit_Body_Cell_Mass(xRow.getCell(87).toString());
                informationEntity.setArm_Circumference(xRow.getCell(88).toString());
                informationEntity.setArm_Muscle_Circumference(xRow.getCell(89).toString());
                informationEntity.setBone_Mineral_Content(xRow.getCell(90).toString());
                informationEntity.setLower_Limit_Bone_Mineral_Content(xRow.getCell(91).toString());
                informationEntity.setUpper_Limit_Bone_Mineral_Content(xRow.getCell(92).toString());
                informationEntity.setRA_5K(xRow.getCell(93).toString());
                informationEntity.setLA_5K(xRow.getCell(94).toString());
                informationEntity.setTR_5K(xRow.getCell(95).toString());
                informationEntity.setRL_5K(xRow.getCell(96).toString());
                informationEntity.setLL_5K(xRow.getCell(97).toString());
                informationEntity.setRA_50K(xRow.getCell(98).toString());
                informationEntity.setLA_50K(xRow.getCell(99).toString());
                informationEntity.setTR_50K(xRow.getCell(100).toString());
                informationEntity.setRL_50K(xRow.getCell(101).toString());
                informationEntity.setLL_50K(xRow.getCell(102).toString());
                informationEntity.setRA_500K(xRow.getCell(103).toString());
                informationEntity.setLA_500K(xRow.getCell(104).toString());
                informationEntity.setTR_500K(xRow.getCell(105).toString());
                informationEntity.setRL_500K(xRow.getCell(106).toString());
                informationEntity.setLL_500K(xRow.getCell(107).toString());
                informationEntity.setGestational_Period(xRow.getCell(108).toString());
                informationEntity.setWaist(xRow.getCell(109).toString());
                informationEntity.setHipshot(xRow.getCell(110).toString());
                informationEntity.setPrePregnancy_Weight(xRow.getCell(111).toString());
                users.add(informationEntity);

            }
        }
        return users;
    }


}
