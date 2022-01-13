package com.restapi_mongodb.springboot_restapi_mongodb.Service;

import com.restapi_mongodb.springboot_restapi_mongodb.Config.MapperConfig;
import com.restapi_mongodb.springboot_restapi_mongodb.Dtos.StudentCreateDto;
import com.restapi_mongodb.springboot_restapi_mongodb.Dtos.StudentReadDto;
import com.restapi_mongodb.springboot_restapi_mongodb.Dtos.StudentUpdateDto;
import com.restapi_mongodb.springboot_restapi_mongodb.Models.Student;
import com.restapi_mongodb.springboot_restapi_mongodb.Repo.IStudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;

@AllArgsConstructor
@Service
public class StudentService implements IStudentService {

    @Autowired
    ModelMapper modelMapper;

    private final IStudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public StudentReadDto getStudent(String email) {
        return modelMapper.map(studentRepository.findStudentByEmail(email), StudentReadDto.class);
    }

    public StudentCreateDto createStudent(StudentCreateDto student) {
        Student createdStudent = modelMapper.map(student, Student.class);
        studentRepository.save(createdStudent);
        return student;
    }

    public Student updateStudent(String email, StudentUpdateDto student) {
        Student selectedStudent = studentRepository.findStudentByEmail(email);
        if (selectedStudent != null) {
            selectedStudent.setAddress(student.getAddress());
            selectedStudent.setEmail(student.getEmail());
            selectedStudent.setFavouriteSubjects(student.getFavouriteSubjects());
            selectedStudent.setGender(student.getGender());
            selectedStudent.setFirstName(student.getFirstName());
            selectedStudent.setLastName(student.getLastName());
            selectedStudent.setTotalSpentInBooks(student.getTotalSpentInBooks());
            return studentRepository.save(selectedStudent);

        } else {
            return null;
        }
    }
}
