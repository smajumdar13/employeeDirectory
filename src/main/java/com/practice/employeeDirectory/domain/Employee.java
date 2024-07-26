package com.practice.employeeDirectory.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@Data
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @Column(name = "emp_no")
    private int empNo;
    @JsonIgnore
    private LocalDate birthDate;
    private String firstName;
    private String lastName;
    @JsonIgnore
    private String gender;
    private LocalDate hireDate;

    @ManyToMany
    @JoinTable(name = "dept_emp",
            joinColumns = @JoinColumn(name = "emp_no"),
            inverseJoinColumns = @JoinColumn(name = "dept_no"))
    @JsonManagedReference
//    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "deptNo")
    private List<Department> departments;

    @OneToMany(mappedBy = "employee")
    @JsonManagedReference
//    @JoinColumn(name = "emp_no")
    private List<Salary> salaries;
}
