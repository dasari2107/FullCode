package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repository.AddressRepository;
import com.twilio.rest.api.v2010.account.Address;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    // Method to save an address
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    // Method to find addresses by user ID
    public List<Address> findByUserId(Long userId) {
        return addressRepository.findByUserId(userId);
    }
}
