package com.practice.employeeDirectory.service;

import com.practice.employeeDirectory.dao.DepartmentDAO;
import com.practice.employeeDirectory.domain.Department;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static com.practice.employeeDirectory.factories.DepartmentFactory.createDepartment;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class DepartmentServiceTest {
    @Mock
    private DepartmentDAO departmentDAO;

    @InjectMocks
    private DepartmentService departmentService;

    @Test
    public void shouldReturnListOfDepartments() {
        // Given
        List<Department> expectedList = Collections.singletonList(createDepartment());
        when(departmentDAO.findAll()).thenReturn(expectedList);

        // When
        List<Department> actualList = departmentService.getAllDepartments();

        // Then
        assertThat(actualList).isEqualTo(expectedList);
    }

    @Test
    public void shouldReturnADepartment() {
        // Given
        Department expected = createDepartment();
        String deptNo = expected.getDeptNo();
        when(departmentDAO.findByDeptNo(deptNo)).thenReturn(Optional.of(expected));

        // When
        Optional<Department> actual = departmentDAO.findByDeptNo(deptNo);

        // Then
        assertThat(actual.get()).isEqualTo(expected);
    }

    @Test
    public void shouldReturnNullWhenDepartmentDoesNotExist() {
        // Given
        String deptNo = randomAlphabetic(4);
        when(departmentDAO.findByDeptNo(deptNo)).thenReturn(null);

        // When
        Optional<Department> actual = departmentDAO.findByDeptNo(deptNo);

        // Then
        assertThat(actual).isNull();
    }

}