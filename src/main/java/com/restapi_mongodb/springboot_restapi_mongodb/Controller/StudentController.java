package com.restapi_mongodb.springboot_restapi_mongodb.Controller;

import com.restapi_mongodb.springboot_restapi_mongodb.Dtos.StudentCreateDto;
import com.restapi_mongodb.springboot_restapi_mongodb.Dtos.StudentReadDto;
import com.restapi_mongodb.springboot_restapi_mongodb.Dtos.StudentUpdateDto;
import com.restapi_mongodb.springboot_restapi_mongodb.Models.Student;
import com.restapi_mongodb.springboot_restapi_mongodb.Service.IStudentService;
import com.restapi_mongodb.springboot_restapi_mongodb.Service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
@AllArgsConstructor
public class StudentController {

    @Autowired
    IStudentService studentService;

    @GetMapping
    public List<Student> fetchAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/byEmail/{email}")
    public StudentReadDto fetchStudent(@PathVariable("email") String email) {
        return studentService.getStudent(email);
    }

    @PostMapping("/createStudent")
    public StudentCreateDto createStudent(@RequestBody StudentCreateDto student) {
        if (studentService.getStudent(student.getEmail()) == null) {
            return studentService.createStudent(student);
        }
        return null;
    }

    @PutMapping("/updateStudent/{email}")
    public Student updateStudent(@PathVariable("email") String email, @RequestBody StudentUpdateDto student) {
        if (studentService.getStudent(email) != null) {
            return studentService.updateStudent(email, student);
        }
        return null;
    }
}
