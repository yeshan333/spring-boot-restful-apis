package com.example.bodymanagement.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.util.TypeUtils;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document(value = "Data")

@NoArgsConstructor
public class InformationEntity implements Serializable {

    @Id
    @JSONField(name = "ID")
    private String ID;
    @JSONField(name = "Height")
    private String Height;
    @JSONField(name = "Gender")
    private String Gender;

    @JSONField(name = "Age")
    private String Age;
    @JSONField(name = "DateTime")
    private String DateTime;
    @JSONField(name = "Weight")
    private String Weight;
    @JSONField(name = "Lower_Limit_Weight")
    private String Lower_Limit_Weight;
    @JSONField(name = "Upper_Limit_Weight")
    private String Upper_Limit_Weight;
    @JSONField(name = "TBW")
    private String TBW;
    @JSONField(name = "Lower_Limit_TBW")
    private String Lower_Limit_TBW;
    @JSONField(name = "Upper_Limit_TBW")
    private String Upper_Limit_TBW;      //11
    @JSONField(name = "ICW")
    private String ICW;
    @JSONField(name = "Lower_Limit_ICW")
    private String Lower_Limit_ICW;
    @JSONField(name = "Upper_Limit_ICW")
    private String Upper_Limit_ICW;
    @JSONField(name = "ECW")
    private String ECW;
    @JSONField(name = "Lower_Limit_ECW")
    private String Lower_Limit_ECW;
    @JSONField(name = "Upper_Limit_ECW")
    private String Upper_Limit_ECW;
    @JSONField(name = "Protein")
    private String Protein;
    @JSONField(name = "Lower_Limit_Protein")
    private String Lower_Limit_Protein;
    @JSONField(name = "Upper_Limit_Protein")
    private String Upper_Limit_Protein;   //20
    @JSONField(name = "Mineral")
    private String Mineral;
    @JSONField(name = "Lower_Limit_Mineral")
    private String Lower_Limit_Mineral;
    @JSONField(name = "Upper_Limit_Mineral")
    private String Upper_Limit_Mineral;
    @JSONField(name = "BFM")
    private String BFM;
    @JSONField(name = "Lower_Limit_BFM")
    private String Lower_Limit_BFM;
    @JSONField(name = "Upper_Limit_BFM")
    private String Upper_Limit_BFM;
    @JSONField(name = "SLM")
    private String SLM;
    @JSONField(name = "Lower_Limit_SLM")
    private String Lower_Limit_SLM;
    @JSONField(name = "Upper_Limit_SLM")
    private String Upper_Limit_SLM;
    @JSONField(name = "FFM")
    private String FFM;
    @JSONField(name = "Lower_Limit_FFM")
    private String Lower_Limit_FFM;
    @JSONField(name = "Upper_Limit_FFM")
    private String Upper_Limit_FFM;
    @JSONField(name = "SMM")

    private String SMM;
    @JSONField(name = "Lower_Limit_SMM")
    private String Lower_Limit_SMM;
    @JSONField(name = "Upper_Limit_SMM")
    private String Upper_Limit_SMM;
    @JSONField(name = "BMI")
    private String BMI;
    @JSONField(name = "Lower_Limit_BMI")
    private String Lower_Limit_BMI;
    @JSONField(name = "Upper_Limit_BMI")
    private String Upper_Limit_BMI;
    @JSONField(name = "Percent_Body_Fat")
    private String Percent_Body_Fat;
    @JSONField(name = "Lower_Limit_Percent_Body_Fat")
    private String Lower_Limit_Percent_Body_Fat;
    @JSONField(name = "Upper_Limit_Percent_Body_Fat")
    private String Upper_Limit_Percent_Body_Fat;
    @JSONField(name = "FFM_of_Right_Arm")
    private String FFM_of_Right_Arm;
    @JSONField(name = "Lower_Limit_FFM_of_Right_Arm")
    private String Lower_Limit_FFM_of_Right_Arm;
    @JSONField(name = "Upper_Limit_FFM_of_Right_Arm")
    private String Upper_Limit_FFM_of_Right_Arm;
    @JSONField(name = "FFM_Persents_of_Right_Arm")
    private String FFM_Persents_of_Right_Arm;
    @JSONField(name = "FFM_of_Left_Arm")
    private String FFM_of_Left_Arm;
    @JSONField(name = "Lower_Limit_FFM_of_Left_Arm")
    private String Lower_Limit_FFM_of_Left_Arm;
    @JSONField(name = "Upper_Limit_FFM_of_Left_Arm")
    private String Upper_Limit_FFM_of_Left_Arm;
    @JSONField(name = "FFM_Persents_of_Left_Arm")
    private String FFM_Persents_of_Left_Arm;
    @JSONField(name = "FFM_of_Trunk")
    private String FFM_of_Trunk;
    @JSONField(name = "Lower_Limit_FFM_of_Trunk")
    private String Lower_Limit_FFM_of_Trunk;
    @JSONField(name = "Upper_Limit_FFM_of_Trunk")
    private String Upper_Limit_FFM_of_Trunk;   //52
    @JSONField(name = "FFM_Persents_of_Trunk")
    private String FFM_Persents_of_Trunk;
    @JSONField(name = "FFM_of_Right_Leg")
    private String FFM_of_Right_Leg;
    @JSONField(name = "Lower_Limit_FFM_of_Right_Leg")
    private String Lower_Limit_FFM_of_Right_Leg;
    @JSONField(name = "Upper_Limit_FFM_of_Right_Leg")
    private String Upper_Limit_FFM_of_Right_Leg;
    @JSONField(name = "FFM_Persents_of_Right_Leg")
    private String FFM_Persents_of_Right_Leg;
    @JSONField(name = "Upper_Limit_FFM_of_Left_Leg")
    private String Upper_Limit_FFM_of_Left_Leg;
    @JSONField(name = "Lower_Limit_Upper_Limit_FFM_of_Left_Leg")
    private String Lower_Limit_Upper_Limit_FFM_of_Left_Leg;
    @JSONField(name = "Upper_Limit_Upper_Limit_FFM_of_Left_Leg")
    private String Upper_Limit_Upper_Limit_FFM_of_Left_Leg;
    @JSONField(name = "FFM_Persents_of_Left_Leg")
    private String FFM_Persents_of_Left_Leg;
    @JSONField(name = "ECW_TBW")
    private String ECW_TBW;
    @JSONField(name = "BFM_of_Right_Arm")
    private String BFM_of_Right_Arm;
    @JSONField(name = "BFM_Persents_of_Right_Arm")
    private String BFM_Persents_of_Right_Arm;
    @JSONField(name = "BFM_of_Left_Arm")
    private String BFM_of_Left_Arm;
    @JSONField(name = "BFM_Persents_of_Left_Arm")
    private String BFM_Persents_of_Left_Arm;
    @JSONField(name = "BFM_of_Trunk")
    private String BFM_of_Trunk;
    @JSONField(name = "BFM_Persents_of_Trunk")
    private String BFM_Persents_of_Trunk;
    @JSONField(name = "BFM_of_Right_Leg")
    private String BFM_of_Right_Leg;
    @JSONField(name = "BFM_Persents_of_Right_Leg")
    private String BFM_Persents_of_Right_Leg;     //70
    @JSONField(name = "BFM_of_Left_Leg")
    private String BFM_of_Left_Leg;
    @JSONField(name = "BFM_Persents_of_Left_Leg")

    private String BFM_Persents_of_Left_Leg;
    @JSONField(name = "Inbody_Score")
    private String Inbody_Score;
    @JSONField(name = "Target_Weight")
    private String Target_Weight;
    @JSONField(name = "Weight_Control")
    private String Weight_Control;
    @JSONField(name = "BFM_Control")
    private String BFM_Control;
    @JSONField(name = "FFM_Control")
    private String FFM_Control;
    @JSONField(name = "Basal_Metabolic_Rate")
    private String Basal_Metabolic_Rate;
    @JSONField(name = "Waist_Hip_Ratio")
    private String Waist_Hip_Ratio;
    @JSONField(name = "Lower_Limit_Waist_Hip_Ratio")
    private String Lower_Limit_Waist_Hip_Ratio;
    @JSONField(name = "Upper_Limit_Waist_Hip_Ratio")
    private String Upper_Limit_Waist_Hip_Ratio;   //81
    @JSONField(name = "Visceral_Fat_Level")
    private String Visceral_Fat_Level;
    @JSONField(name = "Obesity_Degree")
    private String Obesity_Degree;
    @JSONField(name = "Lower_Limit_Obesity_Degree")
    private String Lower_Limit_Obesity_Degree;
    @JSONField(name = "Upper_Limit_Obesity_Degree")
    private String Upper_Limit_Obesity_Degree;
    @JSONField(name = "Body_Cell_Mass")
    private String Body_Cell_Mass;
    @JSONField(name = "Lower_Limit_Body_Cell_Mass")
    private String Lower_Limit_Body_Cell_Mass;
    @JSONField(name = "Upper_Limit_Body_Cell_Mass")
    private String Upper_Limit_Body_Cell_Mass;
    @JSONField(name = "Arm_Circumference")
    private String Arm_Circumference;
    @JSONField(name = "Arm_Muscle_Circumference")
    private String Arm_Muscle_Circumference;
    @JSONField(name = "Bone_Mineral_Content")
    private String Bone_Mineral_Content;
    @JSONField(name = "Lower_Limit_Bone_Mineral_Content")
    private String Lower_Limit_Bone_Mineral_Content;
    @JSONField(name = "Upper_Limit_Bone_Mineral_Content")
    private String Upper_Limit_Bone_Mineral_Content;   //93
    @JSONField(name = "RA_5K")
    private String RA_5K;
    @JSONField(name = "LA_5K")
    private String LA_5K;
    @JSONField(name = "TR_5K")
    private String TR_5K;
    @JSONField(name = "RL_5K")
    private String RL_5K;
    @JSONField(name = "LL_5K")
    private String LL_5K;
    @JSONField(name = "RA_50K")
    private String RA_50K;
    @JSONField(name = "LA_50K")
    private String LA_50K;
    @JSONField(name = "TR_50K")
    private String TR_50K;
    @JSONField(name = "RL_50K")
    private String RL_50K;
    @JSONField(name = "LL_50K")
    private String LL_50K;
    @JSONField(name = "RA_500K")
    private String RA_500K;
    @JSONField(name = "LA_500K")
    private String LA_500K;
    @JSONField(name = "TR_500K")
    private String TR_500K;
    @JSONField(name = "RL_500K")
    private String RL_500K;     //107
    @JSONField(name = "LL_500K")
    private String LL_500K;
    @JSONField(name = "Gestational_Period")
    private String Gestational_Period;
    @JSONField(name = "Waist")
    private String Waist; //
    @JSONField(name = "hipshot")
    private String hipshot;
    @JSONField(name = "PrePregnancy_Weight")
    private String PrePregnancy_Weight;

}
