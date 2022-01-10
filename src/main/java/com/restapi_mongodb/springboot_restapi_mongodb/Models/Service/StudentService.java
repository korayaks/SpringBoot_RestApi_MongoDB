package com.restapi_mongodb.springboot_restapi_mongodb.Models.Service;

import com.restapi_mongodb.springboot_restapi_mongodb.Models.Student;
import com.restapi_mongodb.springboot_restapi_mongodb.Repo.IStudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class StudentService {

    private final IStudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudent(String email) {
        return studentRepository.findStudentByEmail(email);
    }

    public Student createStudent(Student student) {
        studentRepository.insert(student);
        return student;
    }

    public Student updateStudent(String email, Student student) {
        Student selectedStudent = studentRepository.findStudentByEmail(email);
        if(selectedStudent != null){
            selectedStudent.setAddress(student.getAddress());
            selectedStudent.setEmail(student.getEmail());
            selectedStudent.setFavouriteSubjects(student.getFavouriteSubjects());
            selectedStudent.setGender(student.getGender());
            selectedStudent.setFirstName(student.getFirstName());
            selectedStudent.setLastName(student.getLastName());
            selectedStudent.setTotalSpentInBooks(student.getTotalSpentInBooks());
            return studentRepository.save(selectedStudent);

        }else{
            return null;
        }
    }
}
