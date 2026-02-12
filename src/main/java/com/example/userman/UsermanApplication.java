package com.example.userman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class UsermanApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsermanApplication.class, args);
    }

}
