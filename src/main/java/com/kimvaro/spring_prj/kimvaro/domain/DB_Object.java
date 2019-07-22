package com.kimvaro.spring_prj.kimvaro.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "data")
public class DB_Object {
    @Id
    private String id;
    @Indexed
    private String device;
    @Indexed
    private String name;
    @Indexed
    private String age;
    @Indexed
    private String heart;
    @Indexed
    private String stableHeart;
    @Indexed
    private String maximumHeart;
    @Indexed
    private String exerciseIntensity_max;
    @Indexed
    private String exerciseIntensity_min;
    @Indexed
    private String carbonenRate_min;
    @Indexed
    private String carbonenRate_max;


    public DB_Object(String device, String name, String age, String heart, String stableHeart, String maximumHeart, String exerciseIntensity_max, String exerciseIntensity_min, String carbonenRate_min, String carbonenRate_max) {
        this.device = device;
        this.name = name;
        this.age = age;
        this.heart = heart;
        this.stableHeart = stableHeart;
        this.maximumHeart = maximumHeart;
        this.exerciseIntensity_max = exerciseIntensity_max;
        this.exerciseIntensity_min = exerciseIntensity_min;
        this.carbonenRate_min = carbonenRate_min;
        this.carbonenRate_max = carbonenRate_max;

    }

}
