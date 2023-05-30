package com.example.employee_service.feignclient;

import com.example.employee_service.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "application-server", path = "/address-api/api")
public interface AddressClient {
    @GetMapping("/address/{id}")
    ResponseEntity<AddressResponse> getAddressById(@PathVariable("id") int id);

}
