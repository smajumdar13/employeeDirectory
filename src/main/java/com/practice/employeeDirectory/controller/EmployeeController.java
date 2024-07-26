package com.practice.employeeDirectory.controller;

import com.practice.employeeDirectory.domain.Employee;
import com.practice.employeeDirectory.mapper.EmployeeMapper;
import com.practice.employeeDirectory.service.EmployeeService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("db/employees")
class EmployeeController {

    private EmployeeService employeeService;
    private EmployeeMapper employeeMapper;

    @Autowired
    public EmployeeController(EmployeeService employeeService, EmployeeMapper employeeMapper) {
        this.employeeService = employeeService;
        this.employeeMapper = employeeMapper;
    }

    @GetMapping("")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }


    @GetMapping("{empId}")
    public Employee getEmployee(@PathVariable Integer empId) {
        return employeeService.getEmployeeById(empId);
    }

    @PostMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
    }

    @DeleteMapping("{empId}")
    public void deleteEmployee(@PathVariable Integer empId) {
        employeeService.deleteEmployee(empId);
    }

    @PutMapping("")
    public void updateEmployee(@RequestBody Employee employee) {
        employeeService.updateEmployee(employee);
    }

    @GetMapping("dept")
    public ResponseEntity<List<Employee>> getEmployeesWithDept(@RequestParam(value = "id", required = true) String dept) {
        return new ResponseEntity<>(employeeService.getEmployeesWithDept(dept), HttpStatus.FOUND);
    }

    @PutMapping("{empId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateEmployee(@PathVariable Integer empId, @RequestBody Employee update) {
        Employee empFromDb = employeeService.getEmployeeById(empId);
        employeeMapper.updateEmployee(empFromDb, update);
        employeeService.updateEmployee(empFromDb);
    }

    @PostConstruct
    public void ready() {
        System.out.println("Rest Controller is ready.");
    }
}
