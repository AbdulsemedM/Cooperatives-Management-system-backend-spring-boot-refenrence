package com.dxvalley.project.services;

import java.util.List;

import com.dxvalley.project.models.Address;


public interface AddressService {
    

    Address addAddress (Address address);
    Address editAddress (Address address);
    List<Address> getAddress ();
    Address getAddressById(Long addressId);
    // List<Address> getAddressByUnion(Unions union);
    // List<Address> getAddressByPrCooperative(PrCooperative prCooperative);
    
    Address getAddressByPhoneNumber(String phoneNumber);
    void deleteAddress( Long addressId);
}
