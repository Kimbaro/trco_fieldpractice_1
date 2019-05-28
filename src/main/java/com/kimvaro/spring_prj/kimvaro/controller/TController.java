package com.kimvaro.spring_prj.kimvaro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Mono;

@Controller
public class TController {
    @GetMapping(value = "/")
    public Mono<String> deleteAll(Model model) {
        return Mono.just("index");
    }
}
