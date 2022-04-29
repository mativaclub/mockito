package com.mockito.mockito.service.impl;

import com.mockito.mockito.data.Employee;
import com.mockito.mockito.exceptions.EmployeeNotFoundException;
import com.mockito.mockito.service.DepartmentService;
import com.mockito.mockito.service.EmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/minSalary")
    public Employee employeeWithMinSalary(int departmentId) {
        return employeeService.getAll().stream()
                .filter(employee -> employee.getDepartmentId() == departmentId)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException());
    }

    @GetMapping("/maxSalary")
    public Employee employeeWithMaxSalary(int departmentId) {
        return employeeService.getAll().stream()
                .filter(employee -> employee.getDepartmentId() == departmentId)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException());
    }

    @GetMapping("/find")
    public Collection<Employee> findEmployeeByDepartment(int departmentId) {
        return employeeService.getAll().stream()
                .filter(employee -> employee.getDepartmentId() == departmentId)
                .collect(Collectors.toList());

    }

  @Override
    public  Map<Integer, List<Employee>> getAllEmployeesByDepartment() {
        return employeeService.getAll().stream()
                .collect(Collectors.groupingBy(Employee::getDepartmentId));

    }




}
