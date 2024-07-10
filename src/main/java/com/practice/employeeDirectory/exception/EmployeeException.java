package com.practice.employeeDirectory.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public class EmployeeException {
    private final String message;
    private final Throwable throwable;
    private final HttpStatus status;
}
