package com.gizwits.swagger2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableCustomSwagger2
@SpringBootApplication
public class SpringBootSwagger2ExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSwagger2ExampleApplication.class,args);
    }
}
