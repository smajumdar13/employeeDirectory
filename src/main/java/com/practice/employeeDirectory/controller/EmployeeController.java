package com.practice.employeeDirectory.controller;

import com.practice.employeeDirectory.domain.Employee;
import com.practice.employeeDirectory.service.EmployeeService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("db/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    @GetMapping("{empId}")
    public ResponseEntity<Optional<Employee>> getEmployee(@PathVariable int empId) {
        return new ResponseEntity<>(employeeService.getEmployeeById(empId), HttpStatus.OK);
    }

    @PostMapping("")
    public void addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
    }

    @DeleteMapping("{empId}")
    public void deleteEmployee(@PathVariable int empId) {
        employeeService.deleteEmployee(empId);
    }

    @PutMapping("")
    public void updateEmployee(@RequestBody Employee employee) {
        employeeService.updateEmployee( employee);
    }

    @GetMapping("dept")
    public ResponseEntity<List<Employee>> getEmployeesWithDepartments() {
        return new ResponseEntity<>(employeeService.getEmployeesWithDepartments(), HttpStatus.FOUND);
    }

    @PostConstruct
    public void ready() {
        System.out.println("Rest Controller is ready.");
    }

//    @PutMapping("employees/{empId}")
//    public void updateEmployee(@PathVariable int empId, @RequestBody Employee employee) {
//        employeeService.updateEmployee(empId, employee);
//    }
}
