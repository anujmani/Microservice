package com.example.employee_service;

import com.example.employee_service.feignclient.AddressClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
@Service
public class EmployeeServiceImpl implements EmpolyeeService{
    @Autowired
    private EmployeeRepo employeeRepo;
    //@Autowired
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private AddressClient addressClient;
//    @Autowired
//    private LoadBalancerClient loadBalancerClient;
//    public EmployeeServiceImpl( @Value ("${addressservice.base.url}")String addressBaseURL,RestTemplateBuilder builder){
//        this. restTemplate=builder
//                .rootUri(addressBaseURL)
//                .build();
//    }


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
//        AddressResponse addressResponse= restTemplate.getForObject("/address/{id}", AddressResponse.class,id);
//        AddressResponse addressResponse= callToAddressServiceUsingRestTemplate(id);
        AddressResponse addressResponse= addressClient.getAddressById(id).getBody();
        employeeResponse.setAddressResponse(addressResponse);
        return employeeResponse;
    }

    @Override
    public Employee save(Employee employee) {
        employeeRepo.save(employee);
        return employee;
    }
    private AddressResponse callToAddressServiceUsingRestTemplate(int id){
//        List<ServiceInstance> instances= discoveryClient.getInstances("application-server");

//        ServiceInstance serviceInstance= loadBalancerClient.choose("application-server");;
//        String uri =serviceInstance.getUri().toString();
        return restTemplate.getForObject("http://application-server/address/{id}", AddressResponse.class,id);
    }
}
