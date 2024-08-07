package com.practice.employeeDirectory.service;

import com.practice.employeeDirectory.domain.Department;
import com.practice.employeeDirectory.repository.DepartmentRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Optional<Department> getDepartmentByDeptNo(String deptId) {
        return departmentRepository.findByDeptNo(deptId);
    }


    @PostConstruct
    public void ready() {
        System.out.println("Department Service is ready.");
    }
}
