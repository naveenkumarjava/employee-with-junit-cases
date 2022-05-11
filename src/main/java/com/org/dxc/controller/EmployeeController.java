package com.org.dxc.controller;

import com.org.dxc.model.Employee;
import com.org.dxc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/cretae")
    public void createController(@RequestBody Employee s){
        employeeService.createController(s);
    }
    @GetMapping("/getAll")
    public List<Employee>getAll(){
        List<Employee> list=employeeService.getAll();
        return list;
    }
    @PutMapping("/update")
    public void updateEmployee(@RequestBody Employee e){
        employeeService.updateEmployee(e);
    }
    @DeleteMapping("/deleteById")
    public String deleteById(@PathVariable Integer id){
       String rr= employeeService.deleteById(id);
       return "success";

    }
    @GetMapping("/getById")
    public Optional<Employee> getById(@PathVariable Integer id){
        Optional<Employee>optional=employeeService.getById(id);
        return optional;
    }
}
