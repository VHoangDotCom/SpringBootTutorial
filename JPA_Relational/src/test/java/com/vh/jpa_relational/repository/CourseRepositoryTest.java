package com.vh.jpa_relational.repository;

import com.vh.jpa_relational.entity.Course;
import com.vh.jpa_relational.entity.Student;
import com.vh.jpa_relational.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourse() {
        List<Course> courses =
                courseRepository.findAll();
        System.out.println("course = "+courses);
    }

    @Test
    public void saveCourseWithTeacher() {

        Teacher teacher = Teacher.builder()
                .firstName("Priyanka")
                .lastName("Singh")
                .build();

        Course course = Course
                .builder()
                .title("python")
                .credit(6)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

    @Test
    public void findAllPagination() {
        Pageable firstPageWithThreeRecords =
                PageRequest.of(0, 3);
        Pageable secondPageWithTwoRecords =
                PageRequest.of(1, 2);

        List<Course> courses =
                courseRepository.findAll(firstPageWithThreeRecords)
                        .getContent();

        long totalElements =
                courseRepository.findAll(firstPageWithThreeRecords)
                                .getTotalElements();

        long totalPages =
                courseRepository.findAll(firstPageWithThreeRecords)
                                .getTotalPages();

        System.out.println("course = "+courses);
        System.out.println("totalElements = " + totalElements);
        System.out.println("totalPages = " + totalPages);
    }

    @Test
    public void findAllSorting() {
        Pageable sortByTitle =
                PageRequest.of(
                        0,
                        2,
                        Sort.by("title")
                );
        Pageable sortByCreditDesc =
                PageRequest.of(
                        0,
                        2,
                        Sort.by("credit").descending()
                );

        Pageable sortByTitleAndCreditDesc =
                PageRequest.of(
                        0,
                        2,
                        Sort.by("title")
                                .descending()
                                .and(Sort.by("credit"))
                );

        List<Course> courses
                = courseRepository.findAll(sortByTitle).getContent();

        System.out.println("courses = " + courses);
    }

    @Test
    public void printFindByTitleContaining() {
        Pageable firstPageTenRecords =
                PageRequest.of(0,10);

        List<Course> courses =
                courseRepository.findByTitleContaining(
                        "D",
                        firstPageTenRecords).getContent();

        System.out.println("courses = " + courses);
    }

    @Test
    public void saveCourseWithStudentAndTeacher() {

        Teacher teacher = Teacher.builder()
                .firstName("Lizze")
                .lastName("Morgan")
                .build();

        Student student = Student.builder()
                .firstName("Abhishek")
                .lastName("Singh")
                .emailId("abhishek@gmail.com")
                .build();

        Course course = Course
                .builder()
                .title("AI")
                .credit(12)
                .teacher(teacher)
                .build();

        course.addStudents(student);

        courseRepository.save(course);
    }
}