package com.practice.employeeDirectory;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;


class ParameterizedTestingTest {
    private ParameterizedTesting testing = new ParameterizedTesting();

    @ParameterizedTest
    @ValueSource(strings = {"John", "Sam", "Mike", "Greg", "Sarah", "Meena", "Lily"})
    void createsMessage(String name) {
        assertEquals("Hello " + name, testing.messageHello(name));
    }

}