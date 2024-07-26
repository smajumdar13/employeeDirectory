package com.practice.employeeDirectory.service;

import com.practice.employeeDirectory.domain.Employee;
import com.practice.employeeDirectory.exception.EmployeeNotFoundException;
import com.practice.employeeDirectory.mapper.EmployeeMapper;
import com.practice.employeeDirectory.repository.EmployeeRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMapper employeeMapper;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Integer empId) {
        if (employeeRepository.findById(empId).isEmpty()) {
            throw new EmployeeNotFoundException("Employee with the id: " + empId + " does not exist!");
        }
        return employeeRepository.findById(empId).get();
    }

    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void deleteEmployee(Integer empId) {
        Employee employee = getEmployeeById(empId);
        employeeRepository.delete(employee);
    }

    // replace the whole employee object
    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @PostConstruct
    public void ready() {
        System.out.println("Employee Service is ready.");
    }

    public List<Employee> getEmployeesWithDept(String dept) {
        return employeeRepository.findEmployeesWithDept(dept);
    }

//    public Employee findEmployeeByEmpNo(Integer empNo) {
//        return employeeRepository.findByEmpNo(empNo);
//    }

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
