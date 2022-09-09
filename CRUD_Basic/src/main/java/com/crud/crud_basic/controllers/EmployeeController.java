package com.crud.crud_basic.controllers;

import com.crud.crud_basic.models.Employee;
import com.crud.crud_basic.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }

    //build create employee REST API
    @PostMapping()
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    //build get all employees REST API
    @GetMapping()
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    //build get employee by id REST API
    //http://localhost:8080/api/employees/1
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long id) {
        return new ResponseEntity<Employee>(employeeService.getEmployeeById(id), HttpStatus.OK);
    }

    //build update employee REST API
    //http://localhost:8080/api/employees/1
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id,
                                                   @RequestBody Employee employee) {
        return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
    }

    //build delete employee REST API
    //http://localhost:8080/api/employees/1
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){
        employeeService.deleteEmployee(id);

        return new ResponseEntity<String>("Employee deleted successfully!",HttpStatus.OK);
    }

    //build find employee by email REST API
    //http://localhost:8080/api/employees/findByEmail/vh@gmail.com
    @GetMapping("/findByEmail/{email}")
    public List<Employee> findByEmail(@PathVariable("email") String email) {
        return employeeService.findByEmail(email);
    }

    //build find employee by keyword REST API
    //http://localhost:8080/api/employees/search?keyword=vi
    @GetMapping("/search")
    public ResponseEntity<?> findNameByKeyword(@RequestParam(name = "keyword", required = false, defaultValue = "") String name) {
        List<Employee> employeeList = employeeService.findNameByKeyword(name);
        return ResponseEntity.ok(employeeList);
    }


}
