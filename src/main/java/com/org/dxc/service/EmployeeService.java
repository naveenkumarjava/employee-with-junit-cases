package com.org.dxc.service;

import com.org.dxc.model.Employee;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    public void createController(Employee s);
    public List<Employee> getAll();
    public void updateEmployee( Employee e);
    public String deleteById(Integer id);
    public Optional<Employee> getById(Integer id);


}
