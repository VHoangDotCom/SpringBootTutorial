package com.exam.service;

import com.exam.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    Employee updateEmployee(Employee employee, long id);

    //Queries in Repository
    List<Employee> findNameByKeyword(String name);
}
