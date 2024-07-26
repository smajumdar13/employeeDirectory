package com.practice.employeeDirectory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeDirectoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeDirectoryApplication.class, args);
		System.out.println("App Initialized and Running!");
		System.out.println("Run API tests via: http://localhost:8080/swagger-ui/index.html");
	}

}
