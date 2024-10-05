package com.example.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.AddressService;
import com.twilio.rest.api.v2010.account.Address;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping("/add")
    public String addAddress(@RequestBody Address address) {
        addressService.save(address);
        return "Address added!";
    }

    @GetMapping("/list/{userId}")
    public List<Address> getUserAddresses(@PathVariable Long userId) {
        return addressService.findByUserId(userId);
    }
}
