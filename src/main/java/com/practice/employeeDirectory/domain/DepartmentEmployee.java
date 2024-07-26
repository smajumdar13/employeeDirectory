package com.practice.employeeDirectory.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "dept_emp")
public class DepartmentEmployee {
    @Id
    private Integer id;

    @Column(name = "emp_no")
    private Integer empNo;

    @Column(name = "dept_no")
    private String deptNo;

    private LocalDate fromDate;

    private LocalDate toDate;
}
