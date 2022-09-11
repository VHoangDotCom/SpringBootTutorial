package com.vh.jpa_relational.repository;

import com.vh.jpa_relational.entity.Guardian;
import com.vh.jpa_relational.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("vh@gmail.com")
                .firstName("Shabbit")
                .lastName("Dawoodi")
//                .guardianName("Nikhil")
//                .guardianEmail("nikki@gmail.com")
//                .guardianMobile("032434234")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {

        Guardian guardian = Guardian.builder()
                .email("nikki@gmail.com")
                .name("Nikki")
                .mobile("324234324")
                .build();

        Student student = Student.builder()
                .firstName("viet")
                .emailId("vh@gmail.com")
                .lastName("hoang")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent() {
        List<Student> studentList =
                studentRepository.findAll();
        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printStudentByFirstName() {

        List<Student> students =
                studentRepository.findByFirstName("shivam");

        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByFirstNameContaining() {

        List<Student> students =
                studentRepository.findByFirstNameContaining("sh");

        System.out.println("students = " + students);
    }

    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> students =
                studentRepository.findByGuardianName("Nikhil");
        System.out.println("students = " + students);
    }

    @Test
    public void printGetStudentByEmailAddress() {
        Student student =
                studentRepository.getStudentByEmailAddress(
                        "shabbir@gmail.com"
                );

        System.out.println("student = " + student);
    }

    @Test
    public void printgetStudentFirstNameByEmailAddress() {
        String firstName =
                studentRepository.getStudentFirstNameByEmailAddress(
                        "shivam@gmail.com"
                );
        System.out.println("firstName = " + firstName);
    }

    @Test
    public void printgetStudentByEmailAddressNative(){
        Student student =
                studentRepository.getStudentByEmailAddressNative(
                        "shivam@gmail.com"
                );

        System.out.println("student = " + student);
    }

    @Test
    public void printgetStudentByEmailAddressNativeNamedParam() {
        Student student =
                studentRepository.getStudentByEmailAddressNativeNamedParam(
                        "shivam@gmail.com"
                );

        System.out.println("student = " + student);
    }

    @Test
    public void updateStudentNameByEmailIdTest() {
        studentRepository.updateStudentNameByEmailId(
                "shabbir dawoodi",
                "shabbir@gmail.com");
    }


}