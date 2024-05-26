package com.practice.employeeDirectory.factories;

import com.practice.employeeDirectory.domain.Department;

import static org.apache.commons.lang3.RandomStringUtils.random;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomUtils.nextInt;

public class DepartmentFactory {
    public static Department createDepartment() {

        Department department = new Department();
        department.setDeptNo("d" + nextInt(100, 1000));
        department.setDeptName(randomAlphabetic(10));

        return department;
    }
}
