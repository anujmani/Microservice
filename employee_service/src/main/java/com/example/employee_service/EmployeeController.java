package com.example.employee_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {
    @Autowired
    private EmpolyeeService employeeService;
    @GetMapping("/employees/{id}")
    public EmployeeResponse getEmployeeDetails(@PathVariable ("id") int id){
        EmployeeResponse employeeResponse= employeeService.getEmployeeById(id);
    return  employeeResponse;
    }
    @PostMapping("/saveEmp")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        return ResponseEntity.ok(employeeService.save(employee));
    }
}
