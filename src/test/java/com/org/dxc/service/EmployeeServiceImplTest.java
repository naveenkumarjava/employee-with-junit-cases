package com.org.dxc.service;

import com.org.dxc.model.Employee;
import com.org.dxc.repository.EmployeeRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EmployeeServiceImplTest {
    @InjectMocks
    private EmployeeServiceImpl employeeServiceImpl;
    @Mock
    private EmployeeRepo employeeRepo;

    @Test
    void createController() {
        Employee employee= new Employee();
        employee.setId(100);
        employee.setName("naveen");
        employee.setSalary(10000.0);
        employeeServiceImpl.createController(employee);
        Mockito.verify(employeeRepo,Mockito.times(1)).save(employee);
    }

    @Test
    void getAll() {
        List<Employee> list= new ArrayList<>();
        Employee employee= new Employee();
        employee.setId(100);
        employee.setName("harsha");
        employee.setSalary(100000.00);
        list.add(employee);
        Employee employee1= new Employee();
        employee1.setId(101);
        employee1.setName("harsha");
        employee1.setSalary(100000.00);
        list.add(employee1);
        Mockito.when(employeeRepo.findAll()).thenReturn(list);
        List<Employee> list1= employeeServiceImpl.getAll();
        Assertions.assertEquals(list.size(),list1.size());

    }

    @Test
    void updateEmployee() {
        Employee employee= new Employee();
        employee.setId(100);
        employee.setName("naveen");
        employee.setSalary(10000.0);
        employeeServiceImpl.updateEmployee(employee);
        Mockito.verify(employeeRepo,Mockito.times(1)).save(employee);
    }


    @Test
    void deleteById() {
        int id =100;
        String value = "success";
        String value2= employeeServiceImpl.deleteById(100);
        Assertions.assertEquals(value,value2);
        Mockito.verify(employeeRepo,Mockito.times(1)).deleteById(100);

    }


    @Test
    void getById() {
        int id=100;
        Employee employee = new Employee();
        employee.setId(100);
        employee.setName("naveen");
        employee.setSalary(100000.00);
        Optional<Employee> optional=Optional.of(employee);
        Mockito.when(employeeRepo.getById(id)).thenReturn(employee);
        Optional<Employee> optional1 = employeeServiceImpl.getById(id);
        Assertions.assertEquals(optional,optional1);
    }
}