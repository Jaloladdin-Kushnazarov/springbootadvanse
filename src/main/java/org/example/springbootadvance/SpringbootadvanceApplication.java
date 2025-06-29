package org.example.springbootadvance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootadvanceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootadvanceApplication.class, args);

        System.out.println("finished DB migration tools learning (FlyWay and Liquibase)");
    }
}
