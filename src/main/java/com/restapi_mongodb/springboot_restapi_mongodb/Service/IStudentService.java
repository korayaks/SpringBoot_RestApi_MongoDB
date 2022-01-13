package com.restapi_mongodb.springboot_restapi_mongodb.Service;

import com.restapi_mongodb.springboot_restapi_mongodb.Dtos.StudentCreateDto;
import com.restapi_mongodb.springboot_restapi_mongodb.Dtos.StudentReadDto;
import com.restapi_mongodb.springboot_restapi_mongodb.Dtos.StudentUpdateDto;
import com.restapi_mongodb.springboot_restapi_mongodb.Models.Student;

import java.util.List;

public interface IStudentService {
    List<Student> getAllStudents();

    StudentReadDto getStudent(String email);

    StudentCreateDto createStudent(StudentCreateDto student);

    Student updateStudent(String email, StudentUpdateDto student);
}
