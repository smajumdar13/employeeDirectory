package com.practice.employeeDirectory.dao;

import com.practice.employeeDirectory.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDAO extends JpaRepository<Employee, Integer> {
    @Query(value = "SELECT e.empNo, e.firstName, e.lastName, e.gender, d.deptName, e.hireDate" +
            " from dept_emp de inner join department d" +
            " inner join employee e limit 10", nativeQuery = true)
    List<Employee> getEmployeesWithDepartments();
}
