package com.example.address_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {
    @Autowired
    private AddressService addressService;
    @GetMapping("/address/{id}")
    public AddressResponse getAddressById(@PathVariable("id") int id){

        return  addressService.getAddress(id);
    }
}
