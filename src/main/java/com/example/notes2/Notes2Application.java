package com.example.notes2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.notes2.domain.*")
public class Notes2Application {
    public static void main(String[] args) {
        SpringApplication.run(Notes2Application.class, args);
    }

}
