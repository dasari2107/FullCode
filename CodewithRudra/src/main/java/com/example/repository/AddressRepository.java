package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.twilio.rest.api.v2010.account.Address;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findByUserId(Long userId);
}
