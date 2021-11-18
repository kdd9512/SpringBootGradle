package com.springbootgradle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@ComponentScan("com.springbootgradle.controller")
public class SpringBootGradleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootGradleApplication.class, args);
        System.out.println("Initializing...");
    }

}
