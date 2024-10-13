package org.example.springdatahazelcast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringDataHazelcastApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataHazelcastApplication.class, args);
    }

}
