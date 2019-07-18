package com.kimvaro.spring_prj.kimvaro.controller;

import com.kimvaro.spring_prj.kimvaro.domain.DB_Object;
import com.kimvaro.spring_prj.kimvaro.repo.Test_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin("http://localhost:63344")
@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired(required = true)
    @Qualifier(value = "repo")
    Test_Repo test_repo;

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
    public Disposable update(@RequestParam("device") String device, @RequestParam("name") String name, @RequestParam("age") String age, @RequestParam("heart") String heart, @RequestParam("stableHeart") String stableHeart, @RequestParam("maximumHeart") String maximumHeart, @RequestParam("exerciseIntensity") String exerciseIntensity, @RequestParam("carbonenRate") String carbonenRate) {
        return Mono.just(new DB_Object(device, name, age, heart, stableHeart, maximumHeart, exerciseIntensity, carbonenRate)).flatMap(test_repo::save).subscribe(db_object ->
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
            return test_repo.save(db_object);
        }).subscribe(System.out::println).toString();
    }

    @GetMapping(value = "/updateByUserInfo")
    public boolean updateByUserInfo(@RequestParam("id") String id, @RequestParam("device") String device, @RequestParam("name") String name, @RequestParam("age") String age, @RequestParam("heart") String heart, @RequestParam("stableHeart") String stableHeart, @RequestParam("maximumHeart") String maximumHeart, @RequestParam("exerciseIntensity") String exerciseIntensity, @RequestParam("carbonenRate") String carbonenRate) {
        return test_repo.findById(id).flatMap(db_object -> {
            db_object.setHeart(heart);
            db_object.setDevice(device);
            db_object.setName(name);
            db_object.setAge(age);
            db_object.setCarbonenRate(carbonenRate);
            db_object.setExerciseIntensity(exerciseIntensity);
            db_object.setMaximumHeart(maximumHeart);
            db_object.setStableHeart(stableHeart);
            return test_repo.save(db_object);
        }).subscribe(System.out::println).isDisposed();
    }


    @GetMapping(value = "/test")
    public String test(@RequestParam("id") String id, @RequestParam("heart") String heart) {
        System.out.println("===== test request success ===== Param : " + id + "||" + heart);
        return "test request success";
    }
}
