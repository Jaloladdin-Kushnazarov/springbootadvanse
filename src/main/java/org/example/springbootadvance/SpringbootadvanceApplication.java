package org.example.springbootadvance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.Duration;

@SpringBootApplication
@EnableFeignClients
public class SpringbootadvanceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootadvanceApplication.class, args);
    }

}
