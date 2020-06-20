package com.example.bodymanagement.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.util.TypeUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(value = "Data")

public class InformationEntity {

    @Id
    @JsonProperty
    private String ID;
    @JsonProperty
    private String Height;
    @JsonProperty
    private String Gender;
    @JsonProperty
    private String Age;
    @JsonProperty
    private String DateTime;
    @JsonProperty
    private String Weight;
    @JsonProperty
    private String Lower_Limit_Weight;
    @JsonProperty
    private String Upper_Limit_Weight;
    @JsonProperty
    private String TBW;
    @JsonProperty
    private String Lower_Limit_TBW;
    @JsonProperty
    private String Upper_Limit_TBW;      //11
    @JsonProperty
    private String ICW;
    @JsonProperty
    private String Lower_Limit_ICW;
    @JsonProperty
    private String Upper_Limit_ICW;
    @JsonProperty
    private String ECW;
    @JsonProperty
    private String Lower_Limit_ECW;
    @JsonProperty
    private String Upper_Limit_ECW;
    @JsonProperty
    private String Protein;
    @JsonProperty
    private String Lower_Limit_Protein;
    @JsonProperty
    private String Upper_Limit_Protein;   //20
    @JsonProperty
    private String Mineral;
    @JsonProperty
    private String Lower_Limit_Mineral;
    @JsonProperty
    private String Upper_Limit_Mineral;
    @JsonProperty
    private String BFM;
    @JsonProperty
    private String Lower_Limit_BFM;
    @JsonProperty
    private String Upper_Limit_BFM;
    @JsonProperty
    private String SLM;
    @JsonProperty
    private String Lower_Limit_SLM;
    @JsonProperty
    private String Upper_Limit_SLM;
    @JsonProperty
    private String FFM;
    @JsonProperty
    private String Lower_Limit_FFM;
    @JsonProperty
    private String Upper_Limit_FFM;
    @JsonProperty

    private String SMM;
    @JsonProperty
    private String Lower_Limit_SMM;
    @JsonProperty
    private String Upper_Limit_SMM;
    @JsonProperty
    private String BMI;
    @JsonProperty
    private String Lower_Limit_BMI;
    @JsonProperty
    private String Upper_Limit_BMI;
    @JsonProperty//38
    private String Percent_Body_Fat;
    @JsonProperty
    private String Lower_Limit_Percent_Body_Fat;
    @JsonProperty
    private String Upper_Limit_Percent_Body_Fat;
    @JsonProperty
    private String FFM_of_Right_Arm;
    @JsonProperty
    private String Lower_Limit_FFM_of_Right_Arm;
    @JsonProperty
    private String Upper_Limit_FFM_of_Right_Arm;
    @JsonProperty
    private String FFM_Persents_of_Right_Arm;
    @JsonProperty
    private String FFM_of_Left_Arm;
    @JsonProperty
    private String Lower_Limit_FFM_of_Left_Arm;
    @JsonProperty
    private String Upper_Limit_FFM_of_Left_Arm;
    @JsonProperty
    private String FFM_Persents_of_Left_Arm;
    @JsonProperty
    private String FFM_of_Trunk;
    @JsonProperty
    private String Lower_Limit_FFM_of_Trunk;
    @JsonProperty
    private String Upper_Limit_FFM_of_Trunk;   //52
    @JsonProperty
    private String FFM_Persents_of_Trunk;
    @JsonProperty
    private String FFM_of_Right_Leg;
    @JsonProperty
    private String Lower_Limit_FFM_of_Right_Leg;
    @JsonProperty
    private String Upper_Limit_FFM_of_Right_Leg;
    @JsonProperty
    private String FFM_Persents_of_Right_Leg;
    @JsonProperty
    private String Upper_Limit_FFM_of_Left_Leg;
    @JsonProperty
    private String Lower_Limit_Upper_Limit_FFM_of_Left_Leg;
    @JsonProperty
    private String Upper_Limit_Upper_Limit_FFM_of_Left_Leg;
    @JsonProperty
    private String FFM_Persents_of_Left_Leg;
    @JsonProperty
    private String ECW_TBW;
    @JsonProperty
    private String BFM_of_Right_Arm;
    @JsonProperty
    private String BFM_Persents_of_Right_Arm;
    @JsonProperty
    private String BFM_of_Left_Arm;
    @JsonProperty
    private String BFM_Persents_of_Left_Arm;
    @JsonProperty
    private String BFM_of_Trunk;
    @JsonProperty
    private String BFM_Persents_of_Trunk;
    @JsonProperty
    private String BFM_of_Right_Leg;
    @JsonProperty
    private String BFM_Persents_of_Right_Leg;     //70
    @JsonProperty
    private String BFM_of_Left_Leg;
    @JsonProperty

    private String BFM_Persents_of_Left_Leg;
    @JsonProperty
    private String Inbody_Score;
    @JsonProperty
    private String Target_Weight;
    @JsonProperty
    private String Weight_Control;
    @JsonProperty
    private String BFM_Control;
    @JsonProperty
    private String FFM_Control;
    @JsonProperty
    private String Basal_Metabolic_Rate;
    @JsonProperty
    private String Waist_Hip_Ratio;
    @JsonProperty
    private String Lower_Limit_Waist_Hip_Ratio;
    @JsonProperty
    private String Upper_Limit_Waist_Hip_Ratio;   //81
    @JsonProperty
    private String Visceral_Fat_Level;
    @JsonProperty
    private String Obesity_Degree;
    @JsonProperty
    private String Lower_Limit_Obesity_Degree;
    @JsonProperty
    private String Upper_Limit_Obesity_Degree;
    @JsonProperty
    private String Body_Cell_Mass;
    @JsonProperty
    private String Lower_Limit_Body_Cell_Mass;
    @JsonProperty
    private String Upper_Limit_Body_Cell_Mass;
    @JsonProperty
    private String Arm_Circumference;
    @JsonProperty
    private String Arm_Muscle_Circumference;
    @JsonProperty
    private String Bone_Mineral_Content;
    @JsonProperty
    private String Lower_Limit_Bone_Mineral_Content;
    @JsonProperty
    private String Upper_Limit_Bone_Mineral_Content;   //93
    @JsonProperty
    private String RA_5K;
    @JsonProperty
    private String LA_5K;
    @JsonProperty
    private String TR_5K;
    @JsonProperty
    private String RL_5K;
    @JsonProperty
    private String LL_5K;
    @JsonProperty
    private String RA_50K;
    @JsonProperty
    private String LA_50K;
    @JsonProperty
    private String TR_50K;
    @JsonProperty
    private String RL_50K;
    @JsonProperty
    private String LL_50K;
    @JsonProperty
    private String RA_500K;
    @JsonProperty
    private String LA_500K;
    @JsonProperty
    private String TR_500K;
    @JsonProperty
    private String RL_500K;     //107
    @JsonProperty
    private String LL_500K;
    @JsonProperty
    private String Gestational_Period;
    @JsonProperty
    private String Waist; //
    @JsonProperty
    private String hipshot;
    @JsonProperty
    private String PrePregnancy_Weight;


}
