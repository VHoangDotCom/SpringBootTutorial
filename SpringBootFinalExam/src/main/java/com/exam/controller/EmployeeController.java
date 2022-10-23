package com.exam.controller;

import com.exam.model.Employee;
import com.exam.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    //build create employee REST API
    @PostMapping()
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    //build update employee REST API
    //http://localhost:8080/api/employees/1
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id,
                                                   @RequestBody Employee employee) {
        return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
    }

    //build find employee by keyword REST API
    //http://localhost:8080/api/employees/search?keyword=vi
    @GetMapping("/search")
    public ResponseEntity<?> findNameByKeyword(@RequestParam(name = "keyword", required = false, defaultValue = "") String name) {
        List<Employee> employeeList = employeeService.findNameByKeyword(name);
        return ResponseEntity.ok(employeeList);
    }
}
