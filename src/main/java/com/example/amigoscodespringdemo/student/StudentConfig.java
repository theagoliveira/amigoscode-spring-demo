package com.example.amigoscodespringdemo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.JANUARY;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student thiago = new Student(
                    "Thiago",
                    "thiago@example.com",
                    LocalDate.of(1872, JANUARY, 1)
            );

            Student alex = new Student(
                    "Alex",
                    "alex@example.com",
                    LocalDate.of(1754, JANUARY, 1)
            );

            studentRepository.saveAll(List.of(thiago, alex));
        };
    }
}
