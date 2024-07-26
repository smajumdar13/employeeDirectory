package com.practice.employeeDirectory.repository;

import com.practice.employeeDirectory.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query(value = "SELECT e.*, d.* from dept_emp de inner join department d on de.dept_no = d.dept_no" +
                   " inner join employee e on de.emp_no = e.emp_no where de.dept_no = :dept", nativeQuery = true)
    List<Employee> findEmployeesWithDept(@Param("dept") String dept);

//    @Query(value = "SELECT e FROM employee e WHERE e.firstName = :firstName AND e.birthDate = :birthDate")
    Employee findByFirstNameAndBirthDate(String firstName, LocalDate birthDate);
}
