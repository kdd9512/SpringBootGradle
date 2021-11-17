package com.springbootgradle.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/t1")
    public String[] test1() {
        return new String[]{
                "Spring Boot",
                "Using Gradle"
        };
    }
}
