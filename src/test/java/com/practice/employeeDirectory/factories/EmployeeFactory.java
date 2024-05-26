package com.practice.employeeDirectory.factories;

import com.practice.employeeDirectory.domain.Employee;

import java.time.LocalDate;

import static org.apache.commons.lang3.RandomStringUtils.*;
import static org.apache.commons.lang3.RandomUtils.nextInt;
import static org.apache.commons.lang3.RandomUtils.nextLong;

public class EmployeeFactory {
    public static Employee createEmployee() {
        Employee employee = new Employee();
        employee.setEmpNo(nextInt(0, 100000));
        employee.setFirstName(randomAlphabetic(10));
        employee.setLastName(randomAlphabetic(10));
        employee.setGender(random(1, 'M', 'F'));
        employee.setBirthDate(LocalDate.now().minusYears(nextInt(30, 40)).minusDays(nextLong(0,365)));
        employee.setHireDate(LocalDate.now().minusYears(nextInt(3, 10)).minusDays(nextLong(0, 365)));

        return employee;
    }


}
