package com.mockito.mockito.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeExistException extends RuntimeException {
    public static final String DEFAULT_MESSAGE = "Employee exist";

    public EmployeeExistException() {
        this(DEFAULT_MESSAGE);
    }
    public EmployeeExistException(String message) {
        super(message);
    }
}
