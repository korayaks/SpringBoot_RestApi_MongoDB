package com.restapi_mongodb.springboot_restapi_mongodb.Controller;

import com.restapi_mongodb.springboot_restapi_mongodb.Models.Student;
import com.restapi_mongodb.springboot_restapi_mongodb.Models.Service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
@AllArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public List<Student> fetchAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/byEmail/{email}")
    public Student fetchStudent(@PathVariable("email") String email) {
        return studentService.getStudent(email);
    }

    @PostMapping("/createStudent")
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

}
