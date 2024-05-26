package com.practice.employeeDirectory.service;

import com.practice.employeeDirectory.domain.Employee;
import com.practice.employeeDirectory.dao.EmployeeDAO;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    public List<Employee> getAllEmployees() {
        return employeeDAO.findAll();
    }

    public Optional<Employee> getEmployeeById(int empId) {
        return employeeDAO.findById(empId);
    }

    public void addEmployee(Employee employee) {
        employeeDAO.save(employee);
    }

    public void deleteEmployee(int empId) {
        Optional<Employee> employee = getEmployeeById(empId);
        employeeDAO.delete(employee.get());
    }

    // replace the whole employee object
    public void updateEmployee(Employee employee) {
        employeeDAO.save(employee);
    }

    @PostConstruct
    public void ready() {
        System.out.println("Employee Service is ready.");
    }

    public List<Employee> getEmployeesWithDepartments() {
        return employeeDAO.getEmployeesWithDepartments();
    }

    // update all parameters(using the map function) except id, and replace
//    public void updateEmployee(int empId, Employee employee) {
//        Optional<Employee> dbEmployee = getEmployeeById(empId);
//        employeeDAO.save(map(dbEmployee.get(), employee));
//    }

//    private Employee map(Employee dbEmployee, Employee updatedEmployee) {
//        dbEmployee.setFirstName(updatedEmployee.getFirstName());
//        dbEmployee.setLastName(updatedEmployee.getLastName());
//        dbEmployee.setGender(updatedEmployee.getGender());
//        dbEmployee.setBirthDate(updatedEmployee.getBirthDate());
//        dbEmployee.setHireDate(updatedEmployee.getHireDate());
//
//        return dbEmployee;
//    }
}
