package com.mockito.mockito.service;

import com.mockito.mockito.data.Employee;

import java.util.List;

public interface EmployeeService {

    Employee add(String firstName, String lastName, int departmentId, int salary);
    Employee remove(String firstName, String lastName);
    Employee find(String firstName, String lastName);
    List<Employee> getAll();
    String getKey(String firstName, String lastName);
    void validateNames(String... names);

}
