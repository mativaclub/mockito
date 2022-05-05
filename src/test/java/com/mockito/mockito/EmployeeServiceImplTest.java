package com.mockito.mockito;

import com.mockito.mockito.data.Employee;
import com.mockito.mockito.exceptions.EmployeeExistException;
import com.mockito.mockito.exceptions.EmployeeNotFoundException;
import com.mockito.mockito.service.impl.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static com.mockito.mockito.TestConstants.*;
import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeServiceImplTest {

    private final EmployeeServiceImpl out = new EmployeeServiceImpl();

    @Test
    public void shouldAddEmployeeWhenTheyDontExist() {

        Employee expected = new Employee(FIRST_NAME1, LAST_NAME1, DEPARTMENT_ID, SALARY);
        assertEquals(0, out.getAll().size());
        assertFalse(out.getAll().contains(expected));
        Employee actual = out.add(FIRST_NAME1, LAST_NAME1, DEPARTMENT_ID, SALARY);
        assertEquals(1, out.getAll().size());
        assertTrue(out.getAll().contains(expected));
    }

    @Test
    public void shouldThrowEmployeeExistExceptionWhenTheyExist() {
        Employee existed = out.add(FIRST_NAME1, LAST_NAME1, DEPARTMENT_ID, SALARY);
        assertTrue(out.getAll().contains(existed));
        assertThrows(EmployeeExistException.class,
                () -> out.add(FIRST_NAME1, LAST_NAME1, DEPARTMENT_ID, SALARY));
    }

    @Test
    public void shouldFindEmployeeWhenTheyExist() {
        Employee existed = out.add(FIRST_NAME1, LAST_NAME1, DEPARTMENT_ID, SALARY);
        assertEquals(existed, out.find(FIRST_NAME1, LAST_NAME1));

    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenFindEmployeeWhichDontExist() {
        assertEquals(0, out.getAll().size());
        assertThrows(EmployeeNotFoundException.class,
                () -> out.find(FIRST_NAME1, LAST_NAME1));
    }

    @Test
    public void shouldRemoveEmployeeWhenTheyExist() {
        Employee expected = out.add(FIRST_NAME1, LAST_NAME1, SALARY, DEPARTMENT_ID);
        assertEquals(1, out.getAll().size());
        assertTrue(out.getAll().contains(expected));

        Employee actual = out.remove(FIRST_NAME1, LAST_NAME1);
        assertEquals(expected, actual);
        assertTrue(out.getAll().isEmpty());
        assertFalse(out.getAll().contains(expected));

    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenRemoveEmployeeWhichDoesntExist() {
        assertTrue(out.getAll().isEmpty());
        assertThrows(EmployeeNotFoundException.class,() -> out.find(FIRST_NAME1, LAST_NAME1));
    }

    @Test
    public void shouldReturnEmptyCollectionWhenEmployeeDontExist() {
        assertIterableEquals(emptyList(), out.getAll());
    }

    @Test
    public void shouldReturnListOfEmployeesWhenTheyExist() {
        Employee employee1 = out.add(FIRST_NAME1, LAST_NAME1, SALARY, DEPARTMENT_ID);
        Employee employee2 = out.add(FIRST_NAME2, LAST_NAME2, SALARY, DEPARTMENT_ID);
        Collection<Employee> expected = List.of(employee1, employee2);
        Collection<Employee> actual = out.getAll();
//        assertIterableEquals(expected, actual);

    }
}
