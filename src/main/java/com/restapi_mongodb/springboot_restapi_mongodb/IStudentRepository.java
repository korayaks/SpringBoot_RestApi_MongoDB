package com.restapi_mongodb.springboot_restapi_mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface IStudentRepository extends MongoRepository<Student, String> {
    Optional<Student> findStudentByEmail(String email);

}
