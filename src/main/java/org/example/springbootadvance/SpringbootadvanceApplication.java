package org.example.springbootadvance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.cdi.Eager;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;

@SpringBootApplication
public class SpringbootadvanceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootadvanceApplication.class, args);
    }


   @Bean
    public WebClient webClient() {
        return WebClient.create();
   }

}
