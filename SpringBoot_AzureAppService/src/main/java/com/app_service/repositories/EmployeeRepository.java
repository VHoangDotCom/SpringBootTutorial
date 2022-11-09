package com.app_service.repositories;

import com.app_service.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // Find employee by Email
    @Query(value = "SELECT * FROM employees u WHERE u.email = :emailAddress", nativeQuery = true)
    List<Employee> findByEmailAddress(String emailAddress);

    // Find Employee by FirstName and Lastname with keyword
    @Query(value = "SELECT * FROM employees u WHERE concat(u.first_name, ' ', u.last_name) like %:name% ", nativeQuery = true)
    List<Employee> findByName(String name);

}
