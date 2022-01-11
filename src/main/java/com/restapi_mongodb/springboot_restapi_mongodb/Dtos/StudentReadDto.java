package com.restapi_mongodb.springboot_restapi_mongodb.Dtos;

import com.restapi_mongodb.springboot_restapi_mongodb.Models.Address;
import com.restapi_mongodb.springboot_restapi_mongodb.Models.Gender;
import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class StudentReadDto {
    private String firstName;
    private String lastName;
    private String email;
    private Gender gender;
    private Address address;
    private List<String> favouriteSubjects;
    private BigDecimal totalSpentInBooks;
    private LocalDateTime created;
}
