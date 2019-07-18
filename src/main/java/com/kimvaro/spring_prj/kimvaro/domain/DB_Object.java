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
    //안정심박수
    private String stableHeart;
    @Indexed
    //최대심박수
    private String maximumHeart;
    @Indexed
    //운동강도
    private String exerciseIntensity;
    @Indexed
    //카르보넨심박수
    private String carbonenRate;

    public DB_Object(String device, String name, String age, String heart, String stableHeart, String maximumHeart, String exerciseIntensity, String carbonenRate) {
        this.device = device;
        this.name = name;
        this.age = age;
        this.heart = heart;
        this.stableHeart = stableHeart;
        this.maximumHeart = maximumHeart;
        this.exerciseIntensity = exerciseIntensity;
        this.carbonenRate = carbonenRate;
    }

}
