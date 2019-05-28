package com.kimvaro.spring_prj.kimvaro.repo;

import com.kimvaro.spring_prj.kimvaro.domain.DB_Object;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Qualifier("repo")
public interface Test_Repo extends ReactiveCrudRepository<DB_Object, String> {
    Mono<DB_Object> findByName(String name);

    Mono<Boolean> deleteByName(String name);

}
