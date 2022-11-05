package com.cognologix.services;

import com.cognologix.dao.AddressRepository;
import com.cognologix.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class AddressServices {
    @Autowired
    private AddressRepository addressRepository;
    public List<Address> getAllDetails(){
        List<Address>list=this.addressRepository.findAll();
        return list;
    }

    public Address addDetailsOfAddress(Address address) {
        return this.addressRepository.save(address);
    }

    public void deleteAddress(Integer houseNumber) {
        this.addressRepository.deleteById(houseNumber);
    }

    public Address updateAddressDetails(Address address, Integer houseNumber) {
        address.setHouseNumber(houseNumber);
        return this.addressRepository.save(address);
    }
}
