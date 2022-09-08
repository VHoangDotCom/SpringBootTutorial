package com.crud.crud_basic.repositories;

import com.crud.crud_basic.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
