package com.org.dxc.service;

import com.org.dxc.model.Employee;
import com.org.dxc.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
@Autowired
    EmployeeRepo employeeRepo;
    @Override
    public void createController(Employee s) {
        employeeRepo.save(s);

    }

    @Override
    public List<Employee> getAll() {
        List<Employee> list=employeeRepo.findAll();
        return list;
    }

    @Override
    public void updateEmployee(Employee e) {
        employeeRepo.save(e);
    }

    @Override
    public String deleteById(Integer id) {
        employeeRepo.deleteById(id);
        return "success";
    }
    @Override
    public Optional<Employee> getById(Integer id) {
        Optional<Employee> optional=Optional.of(employeeRepo.getById(id));
        return optional;

    }
}
