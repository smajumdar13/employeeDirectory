package com.practice.employeeDirectory.repository;

import com.practice.employeeDirectory.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query(value = "SELECT e.empNo, e.firstName, e.lastName, e.gender, d.deptName, e.hireDate" +
            " from dept_emp de inner join department d" +
            " inner join employee e limit 10", nativeQuery = true)
    List<Employee> findEmployeesWithDepartments();

//    @Query(value = "SELECT e FROM employee e WHERE e.firstName = :firstName AND e.birthDate = :birthDate")
    Employee findByFirstNameAndBirthDate(String firstName, LocalDate birthDate);
}
