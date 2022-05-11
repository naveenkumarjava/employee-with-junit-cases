package com.org.dxc.controller;

import com.org.dxc.model.Employee;
import com.org.dxc.service.EmployeeService;
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
class EmployeeControllerTest {
    @InjectMocks
  private  EmployeeController employeeController;
    @Mock
   private EmployeeService employeeService;
    @Test
    void createController() {
        Employee employee= new Employee();
        employee.setId(100);
        employee.setName("naveen");
        employee.setSalary(10000.0);
        employeeController.createController(employee);
        Mockito.verify(employeeService,Mockito.times(1)).createController(employee);
    }

    @Test
    void getAll() {
        List<Employee>list= new ArrayList<>();
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
        Mockito.when(employeeService.getAll()).thenReturn(list);
        List<Employee> list1= employeeController.getAll();
        Assertions.assertEquals(list.size(),list1.size());
    }

    @Test
    void updateEmployee() {
        Employee employee= new Employee();
        employee.setId(100);
        employee.setName("naveen");
        employee.setSalary(10000.0);
        employeeController.updateEmployee(employee);
        Mockito.verify(employeeService,Mockito.times(1)).updateEmployee(employee);
    }

    @Test
    void deleteById() {
        int id =100;
        String value = "success";
       String value2= employeeController.deleteById(100);
       Assertions.assertEquals(value,value2);
       Mockito.verify(employeeService,Mockito.times(1)).deleteById(100);
    }

    @Test
    void getById() {
        int id=100;
        Employee employee = new Employee();
        employee.setId(100);
        employee.setName("naveen");
        employee.setSalary(100000.00);
        Optional<Employee>optional=Optional.of(employee);
        Mockito.when(employeeService.getById(id)).thenReturn(Optional.of(employee));
        Optional<Employee> optional1 = employeeController.getById(id);
        Assertions.assertEquals(optional,optional1);
    }
}