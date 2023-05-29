package com.example.employee_service.feignclient;

import com.example.employee_service.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "Address", url = "http://localhost:8081/")
public interface AddressClient {
    @GetMapping("/address/{id}")
    AddressResponse getAddressById(@PathVariable("id") int id);

}
