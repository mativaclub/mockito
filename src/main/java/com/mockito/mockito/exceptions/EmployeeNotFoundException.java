package com.mockito.mockito.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeNotFoundException extends RuntimeException {

    public static final String DEFAULT_MESSAGE = "Employee Not Found";

    public EmployeeNotFoundException() {
        this(DEFAULT_MESSAGE);
    }
    public EmployeeNotFoundException(String message) {
        super(message);
    }


}
