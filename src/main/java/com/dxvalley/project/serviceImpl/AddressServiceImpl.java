package com.dxvalley.project.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxvalley.project.models.Address;
import com.dxvalley.project.repositories.AddressRepository;
import com.dxvalley.project.services.AddressService;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private final AddressRepository addressRepository;
    @Override
    public Address addAddress(Address address) {
      return addressRepository .save(address);
    }

    @Override
    public Address editAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public List<Address> getAddress() {
       return addressRepository.findAll();
    }

    @Override
    public Address getAddressById(Long addressId) {
        return addressRepository.findByAddressId(addressId);
    }

    // @Override
    // public List<Address> getAddressByUnion(Unions union) {
    //   return addressRepository.findAddressByUnion(union);
    // }

    // @Override
    // public List<Address> getAddressByPrCooperative(PrCooperative prCooperative) {
    //    return addressRepository.findAddressByPrCooperative(prCooperative);
    // }

    @Override
    public Address getAddressByPhoneNumber(String phoneNumber) {
        return addressRepository.findAddressByPhoneNumber(phoneNumber);
    }

    @Override
    public void deleteAddress(Long addressId) {
       addressRepository.deleteById(addressId);
    }
    
}
