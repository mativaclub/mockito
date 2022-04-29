package com.mockito.mockito.controller;

import com.mockito.mockito.data.Employee;
import com.mockito.mockito.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/minSalary")
    public Employee employeeWithMinSalary(@RequestParam int departmentId) {
        return departmentService.employeeWithMinSalary(departmentId);
    }

    @GetMapping("/maxSalary")
    public Employee employeeWithMaxSalary(@RequestParam int departmentId) {
        return departmentService.employeeWithMaxSalary(departmentId);
    }

    @GetMapping("/employeeByDepartmentId")
    public Collection<Employee> findEmployeeByDepartment(@RequestParam int departmentId) {
        return departmentService.findEmployeeByDepartment(departmentId);
    }

    @GetMapping("/all")
    public  Map<Integer, List<Employee>> getAllEmployees() {
        return departmentService.getAllEmployeesByDepartment();
    }

}
