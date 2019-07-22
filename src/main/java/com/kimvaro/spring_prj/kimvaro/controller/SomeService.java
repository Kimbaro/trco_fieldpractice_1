package com.kimvaro.spring_prj.kimvaro.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Qualifier("logset")
public class SomeService {
    public void setLog(String values) {
        log.debug(values);
    }
}
