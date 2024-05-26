package com.practice.employeeDirectory.controller;

import com.practice.employeeDirectory.domain.Department;
import com.practice.employeeDirectory.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("db/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("{deptNo}")
    public Optional<Department> getDepartmentByDeptNo(@PathVariable("deptNo") String deptNo) {
        return departmentService.getDepartmentByDeptNo(deptNo);
    }


}
