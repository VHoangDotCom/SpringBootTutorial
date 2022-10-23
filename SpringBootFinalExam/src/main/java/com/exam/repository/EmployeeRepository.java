package com.exam.repository;

import com.exam.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Find Employee by Name with keyword
    @Query(value = "SELECT * FROM employees u WHERE u.name like %:name% ", nativeQuery = true)
    List<Employee> findByName(String name);
}
