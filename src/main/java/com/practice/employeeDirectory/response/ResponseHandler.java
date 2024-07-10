package com.practice.employeeDirectory.response;

import com.practice.employeeDirectory.domain.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    public static ResponseEntity<Object> employeeResponse(String message, HttpStatus httpStatus, Employee employee) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", message);
        response.put("httpStatus", httpStatus);
        response.put("data", employee);
        return new ResponseEntity<>(response, httpStatus);
    }
}
