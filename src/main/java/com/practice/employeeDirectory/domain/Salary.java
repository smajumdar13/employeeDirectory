package com.practice.employeeDirectory.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "salary")
@Component
public class Salary {
    @Id
    @Column(name = "emp_no", insertable = false, updatable = false)
//    @JsonIgnore
    private Integer empNo;
    private Integer amount;
//    @JsonIgnore
    private LocalDate from_date;
//    @JsonIgnore
    private LocalDate to_date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emp_no")
    @JsonBackReference
    private Employee employee;

}
