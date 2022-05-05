package com.mockito.mockito;

import com.mockito.mockito.exceptions.EmployeeNotFoundException;
import com.mockito.mockito.service.EmployeeService;
import com.mockito.mockito.service.impl.DepartmentServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.mockito.mockito.TestConstants.*;
import static java.util.Collections.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceImplTest {

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private DepartmentServiceImpl out;

    @Test
    public void shouldFindEmployeeWithMaxSalaryByDepartmentId() {
        when(employeeService.getAll()).thenReturn(EMPLOYEES);
        assertEquals(MAX_SALARY_EMPLOYEE, out.employeeWithMaxSalary(DEPARTMENT_ID));
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenFindMAxSalaryInEmptyEmployeeList() {
        when(employeeService.getAll()).thenReturn(emptyList());
        assertThrows(EmployeeNotFoundException.class, () -> out.employeeWithMaxSalary(DEPARTMENT_ID));
    }


    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenFindMaxSalaryInEmptyDepartment() {
        when(employeeService.getAll()).thenReturn(EMPLOYEES);
        assertThrows(EmployeeNotFoundException.class, () -> out.employeeWithMaxSalary(BAD_DEPARTMENT_ID));
    }

    @Test
    public void shouldFindEmployeeWithMinSalaryByDepartmentId() {
        when(employeeService.getAll()).thenReturn(EMPLOYEES);
        assertEquals(MIN_SALARY_EMPLOYEE, out.employeeWithMinSalary(DEPARTMENT_ID));
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenFindMinSalaryInEmptyEmployeeList() {
        when(employeeService.getAll()).thenReturn(emptyList());
        assertThrows(EmployeeNotFoundException.class, () -> out.employeeWithMinSalary(DEPARTMENT_ID));
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenFindMinSalaryInEmptyDepartment() {
        when(employeeService.getAll()).thenReturn(EMPLOYEES);
        assertThrows(EmployeeNotFoundException.class, () -> out.employeeWithMinSalary(BAD_DEPARTMENT_ID));
    }

    @Test
    public void shouldReturnAllEmployeesByDepartmentWhenEmployeeExist() {
        when(employeeService.getAll()).thenReturn(DIFF_DEPARTMENT_EMPLOYEES);
        assertEquals(DEPARTMENT_MAP.get(1), out.findEmployeeByDepartment(DEPARTMENT_ID));
    }

    @Test
    public void shouldReturnEmptyMapWhenEmployeeDontExist() {
        when(employeeService.getAll()).thenReturn(emptyList());
        assertEquals(emptyMap(), out.getAllEmployeesByDepartment());
    }

    @Test
    public void shouldReturnEmployeeDepartmentsWhenDepartmentIsCorrectAndEmployeeExistThere() {
        when(employeeService.getAll()).thenReturn(DIFF_DEPARTMENT_EMPLOYEES);
        assertEquals(singletonList(MIN_SALARY_EMPLOYEE), out.findEmployeeByDepartment(DEPARTMENT_ID));
        assertEquals(singletonList(DIFFERENT_DEPARTMENT_EMPLOYEE), out.findEmployeeByDepartment(BAD_DEPARTMENT_ID));

    }

    @Test
    public void shouldReturnEmptyListWhenEmployeeDontFoundInDepartment() {
        when(employeeService.getAll()).thenReturn(EMPLOYEES);
        assertEquals(emptyList(), out.findEmployeeByDepartment(BAD_DEPARTMENT_ID));

    }



}
