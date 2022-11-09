package com.app_service.services;

import com.app_service.models.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(long id);
    Employee updateEmployee(Employee employee, long id);
    void deleteEmployee(long id);

    //Queries in Repository
    List<Employee> findByEmail(String email);
    List<Employee> findNameByKeyword(String name);

}