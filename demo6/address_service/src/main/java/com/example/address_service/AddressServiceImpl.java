package com.example.address_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService{
    @Autowired
    private AddressRepo addressRepo;

    @Override
    public AddressResponse getAddress(int id) {

        Address address=addressRepo.findAddressByEmployeeId(id);
        AddressResponse addressResponse= new AddressResponse();
        addressResponse.setId(address.getId());
        addressResponse.setZip(address.getZip());
        addressResponse.setState(address.getState());
        addressResponse.setLane1(address.getLane1());
        addressResponse.setLane2(address.getLane2());
        return addressResponse;
    }
}
