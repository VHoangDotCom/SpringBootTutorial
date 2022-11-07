package com.vh.jpa_relational.service;

import com.vh.jpa_relational.entity.Student;
import com.vh.jpa_relational.exception.BadRequestException;
import com.vh.jpa_relational.exception.StudentNotFoundException;
import com.vh.jpa_relational.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        Boolean existsEmail = studentRepository
                .selectExistsEmail(student.getEmailId());
        if (existsEmail) {
            throw new BadRequestException(
                    "Email " + student.getEmailId() + " taken");
        }

        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        if(!studentRepository.existsById(studentId)) {
            throw new StudentNotFoundException(
                    "Student with id " + studentId + " does not exists");
        }
        studentRepository.deleteById(studentId);
    }
}
