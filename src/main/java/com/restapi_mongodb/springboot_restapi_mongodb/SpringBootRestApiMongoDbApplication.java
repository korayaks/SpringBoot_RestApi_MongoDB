package com.restapi_mongodb.springboot_restapi_mongodb;

import com.restapi_mongodb.springboot_restapi_mongodb.Models.Address;
import com.restapi_mongodb.springboot_restapi_mongodb.Models.Gender;
import com.restapi_mongodb.springboot_restapi_mongodb.Models.Student;
import com.restapi_mongodb.springboot_restapi_mongodb.Repo.IStudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class SpringBootRestApiMongoDbApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRestApiMongoDbApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(IStudentRepository repository) {
        return args -> {
            Address address = new Address(
                    "Turkey",
                    "Istanbul",
                    "34370"
            );
            Student student = new Student(
                    "Koray",
                    "Aksoy",
                    "burakkorayaksoy@hotmail.com",
                    Gender.MALE,
                    address,
                    List.of("Computer Science", "Maths"),
                    BigDecimal.TEN,
                    LocalDateTime.now()
            );

        };
    }
}
