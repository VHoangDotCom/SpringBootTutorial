package com.exam.service.impl;

import com.exam.exception.ResourceNotFoundException;
import com.exam.model.Employee;
import com.exam.repository.EmployeeRepository;
import com.exam.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
        // check whether employee with given id is existed or not
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "Id", id));

        existingEmployee.setName(employee.getName());
        existingEmployee.setDateOfBirth(employee.getDateOfBirth());
        existingEmployee.setWage(employee.getWage());

        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }

    @Override
    public List<Employee> findNameByKeyword(String name) {
        // check whether employee with given email is existed or not
        List<Employee> employees = employeeRepository.findByName(name);
        if (employees.size() > 0) {
            return employees;
        }else {
            throw new ResourceNotFoundException("Employee", "Name", name);
        }
    }
}
