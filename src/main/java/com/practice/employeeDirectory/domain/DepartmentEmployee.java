package com.practice.employeeDirectory.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "dept_emp")
public class DepartmentEmployee {
    @Id
    private Integer empNo;
    private String deptNo;
    private LocalDate fromDate;
    private LocalDate toDate;
}
