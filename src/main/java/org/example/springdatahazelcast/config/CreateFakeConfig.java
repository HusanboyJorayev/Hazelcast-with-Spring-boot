package org.example.springdatahazelcast.config;

import org.example.springdatahazelcast.entity.User;
import org.example.springdatahazelcast.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreateFakeConfig {

    @Bean
    public CommandLineRunner runner(UserRepository userRepository) {
        return args -> {
            for (int i = 0; i < 100; i++) {
                User user = User.builder()
                        .age(i + 1)
                        .password("password_" + i)
                        .username("username_" + i)
                        .build();
                userRepository.save(user);
            }
        };
    }
}
