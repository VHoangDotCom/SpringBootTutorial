package com.vh.jpa_relational.repository;

import com.vh.jpa_relational.entity.Course;
import com.vh.jpa_relational.entity.CourseMaterial;
import javafx.scene.paint.Material;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository repository;

    @Test
    public void SaveCourseMaterial() {
        Course course =
                Course.builder()
                        .title(".net")
                        .credit(6)
                        .build();

        CourseMaterial courseMaterial =
                CourseMaterial.builder()
                        .url("www.viethoang.com")
                        .course(course)
                        .build();

        repository.save(courseMaterial);
    }

    @Test
    public void printAllCourseMaterial() {
        List<CourseMaterial> courseMaterialList =
                repository.findAll();
        System.out.println("courseMaterials = " + courseMaterialList);
    }
}