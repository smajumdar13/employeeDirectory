package com.practice.employeeDirectory.mapper;

import com.practice.employeeDirectory.domain.Employee;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeMapper {
    public Employee updateEmployee(Employee current, Employee update) {

        current.setFirstName(update.getFirstName() != null ? update.getFirstName() : current.getFirstName());
        current.setLastName(update.getLastName() != null ? update.getLastName() : current.getLastName());
        current.setBirthDate(update.getBirthDate() != null ? update.getBirthDate() : current.getBirthDate());
        current.setGender(update.getGender() != null ? update.getGender() : current.getGender());
        current.setHireDate(update.getHireDate() != null ? update.getHireDate() : current.getHireDate());

        return current;
    }
}
