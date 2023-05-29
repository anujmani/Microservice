package com.example.employee_service;

import java.util.Optional;

public interface EmpolyeeService {
    public EmployeeResponse getEmployeeById(int id);
    public Employee save(Employee employee);
}
