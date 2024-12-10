package com.relatenest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class RelateNestApplication {

    public static void main(String[] args) {
        SpringApplication.run(RelateNestApplication.class, args);
    }

}
