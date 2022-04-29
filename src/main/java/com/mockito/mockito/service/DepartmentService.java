package com.mockito.mockito.service;

import com.mockito.mockito.data.Employee;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentService {

    Employee employeeWithMinSalary(int departmentId);
    Employee employeeWithMaxSalary(int departmentId);
    Collection<Employee> findEmployeeByDepartment(int departmentId);
    Map <Integer, List<Employee>> getAllEmployeesByDepartment();

}
