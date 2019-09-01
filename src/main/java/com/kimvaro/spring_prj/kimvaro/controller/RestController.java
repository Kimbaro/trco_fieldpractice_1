package com.kimvaro.spring_prj.kimvaro.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kimvaro.spring_prj.kimvaro.domain.DB_Object;
import com.kimvaro.spring_prj.kimvaro.repo.Test_Repo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin("http://localhost:63344")
@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired(required = true)
    @Qualifier(value = "repo")
    Test_Repo test_repo;
    @Qualifier(value = "logset")

    Logger log = LoggerFactory.getLogger("trco");

    //DBMS SQL Query :: SELECT * FROM <TABLE_NAME>
    @GetMapping(value = "/findAll")
    public Flux<DB_Object> findAll() {
        return test_repo.findAll();
    }

    //DBMS SQL Query :: SELECT * FROM <TABLE_NAME> WHERE name = <VALUE>
    @GetMapping(value = "/findByName")
    public Mono<DB_Object> findByName(@RequestParam("name") String name) {
        return test_repo.findByName(name);
    }

    @GetMapping(value = "/findAllByName")
    public Flux<DB_Object> findAllByName(@RequestParam("name") String name) {
        return test_repo.findAllByName(name);
    }

    @GetMapping(value = "/findById")
    public Mono<DB_Object> findAllById(@RequestParam("id") String id) {

        System.out.println("접근");
        return test_repo.findById(id);
    }

    @GetMapping(value = "/findByDevice")
    public Mono<DB_Object> findByDevice(@RequestParam("device") String device) {
        System.out.println("응답 : " + device);
        return test_repo.findByDevice(device);
    }


    //DBMS SQL Query :: DELETE FROM <TABLE_NAME>
    @GetMapping(value = "/deleteAll")
    public Mono<Void> deleteAll() {
        //몽고디비 특성상 DB.Collection에 데이터 없으면 안되니까..
        return test_repo.deleteAll().then(Mono.just("").then());
    }

    //DBMS SQL Query :: INSERT INTO <TABLE_NAME> VALUES(name = <VALUE> , value = <VALUE>)
    @GetMapping(value = "/insert")
    public Disposable update(@RequestParam("device") String device, @RequestParam("name") String name, @RequestParam("age") String age, @RequestParam("heart") String heart, @RequestParam("stableHeart") String stableHeart, @RequestParam("maximumHeart") String maximumHeart, @RequestParam("exerciseIntensity_max") String exerciseIntensity_max, @RequestParam("exerciseIntensity_min") String exerciseIntensity_min, @RequestParam("carbonenRate_min") String carbonenRate_min, @RequestParam("carbonenRate_max") String carbonenRate_max)

    {
        return Mono.just(new DB_Object(device, name, age, heart, stableHeart, maximumHeart, exerciseIntensity_max, exerciseIntensity_min, carbonenRate_min, carbonenRate_max)).flatMap(test_repo::save).subscribe(db_object ->
                test_repo.findById(db_object.getId())
        );
    }

    //DBMS SQL Query :: DELETE FROM <TABLE_NAME> WHERE name = <VALUE>
    @GetMapping(value = "/deleteByName")
    public Mono<Boolean> deleteByName(@RequestParam("name") String name) {
        return test_repo.deleteByName(name);
    }

    @GetMapping(value = "/update")
    public void updateById(@RequestParam("id") String id, @RequestParam("heart") String heart) {
        //  return null;
        test_repo.findById(id).flatMap(db_object -> {
            db_object.setHeart(heart);
            log.info("*{" + "'name':'" + db_object.getName() + "'," + "'device':'" + db_object.getDevice() + "','heart':'" + db_object.getHeart() + "'}");
            return test_repo.save(db_object);
        }).subscribe().toString();
    }


    @GetMapping(value = "/updateByUserInfo")
    public boolean updateByUserInfo(@RequestParam("id") String id, @RequestParam("device") String device, @RequestParam("name") String name, @RequestParam("age") String age, @RequestParam("heart") String heart, @RequestParam("stableHeart") String stableHeart, @RequestParam("maximumHeart") String maximumHeart, @RequestParam("exerciseIntensity_max") String exerciseIntensity_max, @RequestParam("exerciseIntensity_min") String exerciseIntensity_min, @RequestParam("carbonenRate_min") String carbonenRate_min, @RequestParam("carbonenRate_max") String carbonenRate_max) {
        return test_repo.findById(id).flatMap(db_object -> {
            db_object.setHeart(heart);
            db_object.setDevice(device);
            db_object.setName(name);
            db_object.setAge(age);
            db_object.setMaximumHeart(maximumHeart);
            db_object.setStableHeart(stableHeart);
            db_object.setExerciseIntensity_max(exerciseIntensity_max);
            db_object.setExerciseIntensity_min(exerciseIntensity_min);
            db_object.setCarbonenRate_max(carbonenRate_max);
            db_object.setCarbonenRate_min(carbonenRate_min);
            return test_repo.save(db_object);
        }).subscribe(
                db_object -> {
                    System.out.println("{'device':'" + db_object.getDevice() + "','heart':'" + db_object.getHeart() + "'}");
                }
        ).isDisposed();
    }

//    @GetMapping(value = "/refreshByUserInfo")
//    public void refreshByUserInfo() {
//        test_repo.findAll().flatMap(db_object -> {
//            db_object.setHeart("0");
//            db_object.setName("-");
//            db_object.setAge("0");
//            db_object.setMaximumHeart("0");
//            db_object.setStableHeart("0");
//            db_object.setExerciseIntensity_max("0");
//            db_object.setExerciseIntensity_min("0");
//            db_object.setCarbonenRate_max("0");
//            db_object.setCarbonenRate_min("0");
//            return test_repo.save(db_object);
//        }).subscribe(System.out::println);
//    }

//    @GetMapping(value = "/test")
//    public String test(@RequestParam("id") String id, @RequestParam("heart") String heart) {
//        System.out.println("===== test request success ===== Param : " + id + "||" + heart);
//        return "test request success";
//    }
}
