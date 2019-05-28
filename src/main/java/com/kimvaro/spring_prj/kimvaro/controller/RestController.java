package com.kimvaro.spring_prj.kimvaro.controller;

import com.kimvaro.spring_prj.kimvaro.domain.DB_Object;
import com.kimvaro.spring_prj.kimvaro.repo.Test_Repo;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Predicate;

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
    public Mono<DB_Object> findAllByName(@RequestParam("name") String name) {
        return test_repo.findByName(name);
    }

    //DBMS SQL Query :: DELETE FROM <TABLE_NAME>
    @GetMapping(value = "/deleteAll")
    public Mono<Void> deleteAll() {
        //몽고디비 특성상 DB.Collection에 데이터 없으면 안되니까..
        return test_repo.deleteAll().then(Mono.just("").then());
    }

    //DBMS SQL Query :: INSERT INTO <TABLE_NAME> VALUES(name = <VALUE> , value = <VALUE>)
    @GetMapping(value = "/insert")
    public String update(@RequestParam("name") String name, @RequestParam("value") String value) {
        return Flux.just(new DB_Object(name, value)).flatMap(test_repo::save).subscribe(System.out::println).toString();
    }

    //DBMS SQL Query :: DELETE FROM <TABLE_NAME> WHERE name = <VALUE>
    @GetMapping(value = "/deleteByName")
    public Mono<Boolean> deleteByName(@RequestParam("name") String name) {
        return test_repo.deleteByName(name);
    }
}
