package com.restapi_mongodb.springboot_restapi_mongodb.Repo;

import com.restapi_mongodb.springboot_restapi_mongodb.Models.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IStudentRepository extends MongoRepository<Student, String> {
    Student findStudentByEmail(String email);

}
