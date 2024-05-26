package com.practice.employeeDirectory.dao;

import com.practice.employeeDirectory.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentDAO extends JpaRepository<Department, Integer> {
    Optional<Department> findByDeptNo(String deptNo);
}
