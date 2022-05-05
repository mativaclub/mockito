package com.mockito.mockito;

import com.mockito.mockito.data.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestConstants {

    public static final String FIRST_NAME1 = "Maria";
    public static final String FIRST_NAME2 = "Anna";
    public static final String LAST_NAME1 = "Gabriel";
    public static final String LAST_NAME2 = "Yan";

    public static final int SALARY = 50000;
    public static final int MIN_SALARY = 30000;

    public static final int DEPARTMENT_ID = 1;
    public static final int BAD_DEPARTMENT_ID = 2;

    public static final Employee MAX_SALARY_EMPLOYEE = new Employee(FIRST_NAME1, LAST_NAME1, DEPARTMENT_ID, SALARY);
    public static final Employee MIN_SALARY_EMPLOYEE = new Employee(FIRST_NAME2, LAST_NAME2, DEPARTMENT_ID, MIN_SALARY);
    public static final Employee DIFFERENT_DEPARTMENT_EMPLOYEE = new Employee(FIRST_NAME2, LAST_NAME2, BAD_DEPARTMENT_ID, SALARY);

    public static final List<Employee> EMPLOYEES = List.of(MAX_SALARY_EMPLOYEE, MIN_SALARY_EMPLOYEE);
    public static final List<Employee> DIFF_DEPARTMENT_EMPLOYEES = List.of(MIN_SALARY_EMPLOYEE, DIFFERENT_DEPARTMENT_EMPLOYEE);

    public static final Map<Integer, List<Employee>> DEPARTMENT_MAP = DIFF_DEPARTMENT_EMPLOYEES.stream()
            .collect(Collectors.groupingBy(Employee::getDepartmentId));
}
