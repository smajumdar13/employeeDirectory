package com.practice.employeeDirectory.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Entity
@Table(name = "department")
@Component
public class Department {
    @Id
    @Column(name = "dept_no")
    @JsonIgnore
    private String deptNo;
    private String deptName;

    @ManyToMany
    @JoinTable(name = "dept_emp",
            joinColumns = @JoinColumn(name = "dept_no"),
            inverseJoinColumns = @JoinColumn(name = "emp_no"))
    @JsonBackReference
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "empNo" )
    private List<Employee> employees;

}
