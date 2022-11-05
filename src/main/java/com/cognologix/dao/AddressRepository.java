package com.cognologix.dao;
import com.cognologix.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface AddressRepository extends JpaRepository<Address,Integer> {
    public Address findByHouseNumber(int houseNumber);
}
