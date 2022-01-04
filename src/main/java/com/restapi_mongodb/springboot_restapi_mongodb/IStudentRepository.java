package com.restapi_mongodb.springboot_restapi_mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface IStudentRepository extends MongoRepository<Student, String> {

}
