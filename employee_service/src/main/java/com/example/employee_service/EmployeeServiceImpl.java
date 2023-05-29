package com.example.employee_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;
@Service
public class EmployeeServiceImpl implements EmpolyeeService{
    @Autowired
    private EmployeeRepo employeeRepo;
    //@Autowired
    private RestTemplate restTemplate;
    public EmployeeServiceImpl( @Value ("${addressservice.base.url}")String addressBaseURL,RestTemplateBuilder builder){
        this. restTemplate=builder
                .rootUri(addressBaseURL)
                .build();
    }


//    @Value ("${addressservice.base.url}")
//    private String addressBaseURL;
    @Override
    public EmployeeResponse getEmployeeById(int id) {

        Employee employee=employeeRepo.findById(id).get();
        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setId(employee.getId());
        employeeResponse.setName(employee.getName());
        employeeResponse.setEmail(employee.getEmail());
        employeeResponse.setBloodGroup(employee.getBloodGroup());
        AddressResponse addressResponse= restTemplate.getForObject("/address/{id}", AddressResponse.class,id);
        employeeResponse.setAddressResponse(addressResponse);
        return employeeResponse;
    }

    @Override
    public Employee save(Employee employee) {
        employeeRepo.save(employee);
        return employee;
    }
}
