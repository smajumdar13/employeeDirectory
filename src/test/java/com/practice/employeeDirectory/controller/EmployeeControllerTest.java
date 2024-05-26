package com.practice.employeeDirectory.controller;

import com.practice.employeeDirectory.domain.Employee;
import com.practice.employeeDirectory.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import static com.practice.employeeDirectory.factories.EmployeeFactory.createEmployee;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class EmployeeControllerTest {
    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private EmployeeController employeeController;

    @Test
    public void shouldReturnListOfEmployees() {
        //Given
        List<Employee> expectedList = singletonList(createEmployee());
        when(employeeService.getAllEmployees()).thenReturn(expectedList);

        //When
        ResponseEntity<List<Employee>> actualList = employeeController.getAllEmployees();

        //Then
        assertThat(actualList.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(actualList.getBody()).isEqualTo(expectedList);
    }

    @Test
    public void shouldReturnAnEmployeeByEmployeeId() {
        // Given
        Employee expectedEmployee = createEmployee();
        int empId = expectedEmployee.getEmpNo();
        when(employeeService.getEmployeeById(empId)).thenReturn(Optional.of(expectedEmployee));

        // When
        ResponseEntity<Optional<Employee>> actualEmployee = employeeController.getEmployee(empId);

        // Then
        assertThat(actualEmployee.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(actualEmployee.getBody().get()).isEqualTo(expectedEmployee);
    }

}