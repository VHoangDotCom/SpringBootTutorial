package com.crud.crud_basic.services;

import com.crud.crud_basic.models.Employee;

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
