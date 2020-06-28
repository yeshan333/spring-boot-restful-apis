package com.example.bodymanagement.Unit;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
@Component
public class CSVWrite {
    public void write(JSONArray JsonArray,String userName) throws IOException {
        File file = new File(".");
        if (!file.exists()) {
            file.mkdirs();
        }
        Appendable printWriter = new PrintWriter(file + "/"+userName+".CSV", "GBK");//指定GBK,解决Microsoft不兼容
        CSVPrinter csvPrinter = CSVFormat.EXCEL.withHeader("ID","Height", "Gender", "Age", "DateTime", "Weight", "Lower_Limit_Weight", "Upper_Limit_Weight", "TBW", "Lower_Limit_TBW", "Upper_Limit_TBW", "ICW", "Lower_Limit_ICW", "Upper_Limit_ICW", "ECW", "Lower_Limit_ECW", "Upper_Limit_ECW",
                "Protein","Lower_Limit_Protein", "Upper_Limit_Protein", "Mineral", "Lower_Limit_Mineral", "Upper_Limit_Mineral", "BFM", "Lower_Limit_BFM", "Upper_Limit_BFM", "SLM", "Lower_Limit_SLM", "Upper_Limit_SLM", "FFM", "Lower_Limit_FFM", "Upper_Limit_FFM", "SMM", "Lower_Limit_SMM",
                "Upper_Limit_SMM", "BMI", "Lower_Limit_BMI", "Upper_Limit_BMI", "Percent_Body_Fat", "Lower_Limit_Percent_Body_Fat", "Upper_Limit_Percent_Body_Fat", "FFM_of_Right_Arm", "Lower_Limit_FFM_of_Right_Arm", "Upper_Limit_FFM_of_Right_Arm", "FFM_Persents_of_Right_Arm", "FFM_of_Left_Arm",
                "Lower_Limit_FFM_of_Left_Arm", "Upper_Limit_FFM_of_Left_Arm", "FFM_Persents_of_Left_Arm", "FFM_of_Trunk", "Lower_Limit_FFM_of_Trunk", "Upper_Limit_FFM_of_Trunk", "FFM_Persents_of_Trunk", "FFM_of_Right_Leg", "Lower_Limit_FFM_of_Right_Leg", "Upper_Limit_FFM_of_Right_Leg", "FFM_Persents_of_Right_Leg", "Upper_Limit_FFM_of_Left_Leg", "Lower_Limit_Upper_Limit_FFM_of_Left_Leg", "Upper_Limit_Upper_Limit_FFM_of_Left_Leg", "FFM_Persents_of_Left_Leg", "ECW_TBW", "BFM_of_Right_Arm", "BFM_Persents_of_Right_Arm", "BFM_of_Left_Arm", "BFM_Persents_of_Left_Arm", "BFM_of_Trunk",
                "BFM_Persents_of_Trunk", "BFM_of_Right_Leg", "BFM_Persents_of_Right_Leg", "BFM_of_Left_Leg", "BFM_Persents_of_Left_Leg", "Inbody_Score", "Target_Weight", "Weight_Control", "BFM_Control", "FFM_Control", "Basal_Metabolic_Rate", "Waist_Hip_Ratio", "Lower_Limit_Waist_Hip_Ratio", "Upper_Limit_Waist_Hip_Ratio", "Visceral_Fat_Level", "Obesity_Degree", "Lower_Limit_Obesity_Degree", "Upper_Limit_Obesity_Degree", "Body_Cell_Mass", "Lower_Limit_Body_Cell_Mass", "Upper_Limit_Body_Cell_Mass",
                "Arm_Circumference", "Arm_Muscle_Circumference", "Bone_Mineral_Content", "Lower_Limit_Bone_Mineral_Content", "Upper_Limit_Bone_Mineral_Content", "RA_5K", "LA_5K", "TR_5K", "RL_5K", "LL_5K", "RA_50K", "LA_50K", "TR_50K", "RL_50K", "LL_50K", "RA_500K", "LA_500K", "TR_500K",
                "RL_500K", "LL_500K", "Gestational_Period", "Waist", "hipshot", "PrePregnancy_Weight").print(printWriter);
        for (int i = 0; i <JsonArray.size(); i++) {
            JSONObject job = JsonArray.getJSONObject(i);
            System.out.println(job.get("ID"));
            csvPrinter.printRecord(job.get("ID"),job.get("Height"), job.get("Gender"),job.get("Age"),job.get( "DateTime"),job.get( "Weight"), job.get("Lower_Limit_Weight"), job.get("Upper_Limit_Weight"),job.get( "TBW"), job.get("Lower_Limit_TBW"), job.get("Upper_Limit_TBW"), job.get("ICW"),job.get( "Lower_Limit_ICW"), job.get("Upper_Limit_ICW"), job.get("ECW"), job.get("Lower_Limit_ECW"),job.get( "Upper_Limit_ECW"),
                    job.get( "Protein"),job.get("Lower_Limit_Protein"), job.get("Upper_Limit_Protein"), job.get("Mineral"), job.get("Lower_Limit_Mineral"), job.get("Upper_Limit_Mineral"),job.get( "BFM"),job.get( "Lower_Limit_BFM"),job.get( "Upper_Limit_BFM"), job.get("SLM"), job.get("Lower_Limit_SLM"), job.get("Upper_Limit_SLM"), job.get("FFM"), job.get("Lower_Limit_FFM"), job.get("Upper_Limit_FFM"), job.get("SMM"),job.get( "Lower_Limit_SMM"),
                            job.get( "Upper_Limit_SMM"), job.get("BMI"), job.get("Lower_Limit_BMI"), job.get( "Upper_Limit_BMI"), job.get("Percent_Body_Fat"), job.get("Lower_Limit_Percent_Body_Fat"), job.get("Upper_Limit_Percent_Body_Fat"), job.get("FFM_of_Right_Arm"), job.get("Lower_Limit_FFM_of_Right_Arm"), job.get("Upper_Limit_FFM_of_Right_Arm"), job.get("FFM_Persents_of_Right_Arm"), job.get("FFM_of_Left_Arm"),
                            job.get( "Lower_Limit_FFM_of_Left_Arm"), job.get("Upper_Limit_FFM_of_Left_Arm"), job.get("FFM_Persents_of_Left_Arm"), job.get("FFM_of_Trunk"), job.get("Lower_Limit_FFM_of_Trunk"),job.get( "Upper_Limit_FFM_of_Trunk"), job.get("FFM_Persents_of_Trunk"), job.get("FFM_of_Right_Leg"), job.get("Lower_Limit_FFM_of_Right_Leg"), job.get("Upper_Limit_FFM_of_Right_Leg"),job.get( "FFM_Persents_of_Right_Leg"),job.get("Upper_Limit_FFM_of_Left_Leg"),job.get( "Lower_Limit_Upper_Limit_FFM_of_Left_Leg"), job.get("Upper_Limit_Upper_Limit_FFM_of_Left_Leg"), job.get("FFM_Persents_of_Left_Leg"), job.get("ECW_TBW"), job.get("BFM_of_Right_Arm"), job.get("BFM_Persents_of_Right_Arm"), job.get("BFM_of_Left_Arm"),job.get( "BFM_Persents_of_Left_Arm"), job.get("BFM_of_Trunk"),
                                    job.get("BFM_Persents_of_Trunk"), job.get("BFM_of_Right_Leg"),job.get( "BFM_Persents_of_Right_Leg"), job.get("BFM_of_Left_Leg"), job.get("BFM_Persents_of_Left_Leg"),job.get("Inbody_Score"),job.get( "Target_Weight"), job.get("Weight_Control"), job.get("BFM_Control"),job.get( "FFM_Control"),job.get( "Basal_Metabolic_Rate"), job.get("Waist_Hip_Ratio"), job.get("Lower_Limit_Waist_Hip_Ratio"),job.get( "Upper_Limit_Waist_Hip_Ratio"),job.get( "Visceral_Fat_Level"), job.get("Obesity_Degree"),job.get( "Lower_Limit_Obesity_Degree"), job.get("Upper_Limit_Obesity_Degree"),job.get( "Body_Cell_Mass"), job.get("Lower_Limit_Body_Cell_Mass"), job.get("Upper_Limit_Body_Cell_Mass"),
                                    job.get( "Arm_Circumference"), job.get("Arm_Muscle_Circumference"), job.get("Bone_Mineral_Content"), job.get("Lower_Limit_Bone_Mineral_Content"), job.get("Upper_Limit_Bone_Mineral_Content"),job.get( "RA_5K"),job.get( "LA_5K"),job.get( "TR_5K"), job.get("RL_5K"), job.get("LL_5K"), job.get("RA_50K"), job.get("LA_50K"), job.get("TR_50K"), job.get("RL_50K"),job.get( "LL_50K"), job.get("RA_500K"), job.get("LA_500K"), job.get("TR_500K"),
                                    job.get(  "RL_500K"), job.get("LL_500K"),job.get("Gestational_Period"),job.get( "Waist"), job.get("hipshot"), job.get("PrePregnancy_Weight"));
        }
        csvPrinter.flush();
        csvPrinter.close();
    }

//    public static void main(String[] args) throws IOException {
//        CSVWrite csvWrite=new CSVWrite();
//        csvWrite.write();
//    }
}
