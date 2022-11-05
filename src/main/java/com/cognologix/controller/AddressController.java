package com.cognologix.controller;

import com.cognologix.dao.AddressRepository;
import com.cognologix.model.Address;
import com.cognologix.services.AddressServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AddressController {
    @Autowired
    private AddressServices addressServices;

    @GetMapping("/address/get")
    public ResponseEntity<List<Address>> getAddress() {
        List<Address> list1 = null;
        try {
            list1 = this.addressServices.getAllDetails();
            if (list1.size() <= 0) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.of(Optional.of(list1));
    }

    @PostMapping("/address/post")
    public ResponseEntity<Address> postAddress(@RequestBody Address address) {
        Address add = null;
        try {
            add = this.addressServices.addDetailsOfAddress(address);
            return ResponseEntity.of(Optional.of(add));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("address/delete/{houseNumber}")
    public ResponseEntity<String> deleteAddress(@PathVariable("houseNumber") Integer houseNumber) {
        try {
            this.addressServices.deleteAddress(houseNumber);
            return ResponseEntity.status(HttpStatus.OK).body("Data Deleted......");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @PutMapping("/address/put/{houseNumber}")
    public ResponseEntity<Address> updateAddress(@RequestBody Address address, @PathVariable("houseNumber") Integer houseNumber) {
        try {
            this.addressServices.updateAddressDetails(address, houseNumber);
            return ResponseEntity.of(Optional.of(address));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

    }
}
