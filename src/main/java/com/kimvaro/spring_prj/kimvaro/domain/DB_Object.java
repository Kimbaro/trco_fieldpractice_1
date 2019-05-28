package com.kimvaro.spring_prj.kimvaro.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "testDB")
public class DB_Object {
    @Id
    private String id;
    @Indexed
    private String name;
    @Indexed
    private String value;

    public DB_Object(String name, String value) {
        this.name = name;
        this.value = value;
    }
}
