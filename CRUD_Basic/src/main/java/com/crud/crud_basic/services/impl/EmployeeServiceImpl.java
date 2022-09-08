package com.crud.crud_basic.services.impl;

import com.crud.crud_basic.exceptions.ResourceNotFoundException;
import com.crud.crud_basic.models.Employee;
import com.crud.crud_basic.repositories.EmployeeRepository;
import com.crud.crud_basic.services.EmployeeService;
import org.springframework.stereotype.Service;

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
//       Optional<Employee> employee = employeeRepository.findById(id);
//       if (employee.isPresent()) {
//           return employee.get();
//       }else {
//           throw new ResourceNotFoundException("Employee", "Id", id);
//       }

       return  employeeRepository.findById(id).orElseThrow(() ->
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

}
