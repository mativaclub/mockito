package com.mockito.mockito.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeInvalidNameException extends RuntimeException {

    public static final String DEFAULT_MESSAGE = "Invalid name";

    public EmployeeInvalidNameException() {
        this(DEFAULT_MESSAGE);
    }
    public EmployeeInvalidNameException(String message) {
        super(message);
    }
}
