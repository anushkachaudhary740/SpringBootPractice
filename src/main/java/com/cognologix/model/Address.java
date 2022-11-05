package com.cognologix.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer houseNumber;
    private String pincode;
    private String city;
    private String state;

    public Address(Integer houseNumber,String pincode, String city, String state) {
        this.houseNumber=houseNumber;
        this.pincode = pincode;
        this.city = city;
        this.state = state;
    }

    public Address() {
    }

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return java.text.MessageFormat.format("PinCode: {0}/t City: {1}/t State: {2}/t HouseNumber: {3}/n",pincode,city,state,houseNumber);
    }
}
