package com.example.bookapi.config;

import com.example.bookapi.entity.User;
import com.example.bookapi.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initUsers(UserRepository userRepository) {
        return args -> {

            if (userRepository.count() == 0) {

                userRepository.save(new User("admin", "admin123", "ADMIN"));
                userRepository.save(new User("user", "user123", "USER"));

            }
        };
    }
}