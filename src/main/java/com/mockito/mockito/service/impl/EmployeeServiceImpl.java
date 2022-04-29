package com.mockito.mockito.service.impl;

import com.mockito.mockito.data.Employee;
import com.mockito.mockito.exceptions.EmployeeExistException;
import com.mockito.mockito.exceptions.EmployeeNotFoundException;
import com.mockito.mockito.service.EmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employees = new HashMap<>();

    public Employee add(String firstName, String lastName, int departmentId, int salary) {
        String key = getKey(firstName, lastName);
        StringUtils.capitalize(firstName);
        StringUtils.capitalize(lastName);
        Employee add = new Employee(firstName, lastName, departmentId, salary);
        if (employees.containsKey(key)) {
            throw new EmployeeExistException();
        }
        employees.put(key, add);
        return add;
    }

    public Employee remove(String firstName, String lastName) {
        String key = getKey(firstName, lastName);
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException();
        }
        return employees.remove(key);
    }

    public Employee find(String firstName, String lastName) {
        String key = getKey(firstName, lastName);
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException();
        }
        return employees.get(key);
    }

    @Override
    public List<Employee> getAll() {

        return new ArrayList<>(employees.values());
    }


//    public void validateNames(String... names) {
//        for (String name : names) {
//            if (!isAlpha(name)) {
//                throw new EmployeeInvalidNameException(name);
//            }
//        }
//    }

//    Override
    public String getKey(String firstName, String lastName) {
        return firstName + lastName;
    }

}
