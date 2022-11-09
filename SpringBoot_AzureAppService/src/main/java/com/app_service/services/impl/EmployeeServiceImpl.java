package com.app_service.services.impl;
import org.springframework.stereotype.Service;

import com.app_service.exceptions.ResourceNotFoundException;
import com.app_service.models.Employee;
import com.app_service.repositories.EmployeeRepository;
import com.app_service.services.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
        //      Optional<Employee> employee = employeeRepository.findById(id);
//       if (employee.isPresent()) {
//           return employee.get();
//       }else {
//           throw new ResourceNotFoundException("Employee", "Id", id);
//       }

        return employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee", "Id", id));
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
        // check whether employee with given id is existed or not
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "Id", id));

        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());

        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }

    @Override
    public void deleteEmployee(long id) {
        // check whether employee with given id is existed or not
        employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "Id", id));

        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> findByEmail(String email) {
        // check whether employee with given email is existed or not
        List<Employee> employees = employeeRepository.findByEmailAddress(email);
        if (employees.size() > 0) {
            return employees;
        }else {
            throw new ResourceNotFoundException("Employee", "Email", email);
        }
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