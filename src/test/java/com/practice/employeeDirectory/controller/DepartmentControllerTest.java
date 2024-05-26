package com.practice.employeeDirectory.controller;

import com.practice.employeeDirectory.domain.Department;
import com.practice.employeeDirectory.service.DepartmentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class DepartmentControllerTest {
    @Mock
    private DepartmentService departmentService;

    @InjectMocks
    private DepartmentController departmentController;

    @Test
    public void shouldReturnListOfDepartments() {
        // Given
        List<Department> expectedList = new ArrayList<>();
        when(departmentService.getAllDepartments()).thenReturn(expectedList);

        // When
        List<Department> actualList = departmentController.getAllDepartments();

        // Then
        assertThat(actualList).isEqualTo(expectedList);
    }

    @Test
    public void shouldGetDepartmentByDeptNo() {
        // Given
        Department expectedDepartment = new Department();
        when(departmentService.getDepartmentByDeptNo(any(String.class))).thenReturn(Optional.of(expectedDepartment));

        // When
        Optional<Department> actualDepartment = departmentController.getDepartmentByDeptNo(randomAlphabetic(4));

        // Then
        assertThat(actualDepartment.get()).isEqualTo(expectedDepartment);
    }

    @Test
    public void shouldReturnNullWhenDepartmentIsNotFound() {
        // Given
        when(departmentService.getDepartmentByDeptNo(any(String.class))).thenReturn(null);

        // When
        Optional<Department> actual = departmentController.getDepartmentByDeptNo(randomAlphabetic(4));

        // Then
        assertThat(actual).isNull();
    }
}