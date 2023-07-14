package com.dxvalley.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dxvalley.project.models.Address;
import com.dxvalley.project.models.CreateResponse;
// import com.dxvalley.project.models.PrCooperative;
// import com.dxvalley.project.models.Unions;
import com.dxvalley.project.services.AddressService;
// import com.dxvalley.project.services.PrCooperativeService;
// import com.dxvalley.project.services.UnionService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/address")

public class AddressController {

    @Autowired
    private final AddressService addressService;
    // private final UnionService uniionService;
    // private final PrCooperativeService prCoopperativeService;

    @GetMapping("/getAddresses")
    List<Address> getAddress() {
    return this.addressService.getAddress();  }
        
            
    @GetMapping("/{addressId}")
    Address getAddress(@PathVariable Long addressId){
    return addressService.getAddressById(addressId);  }
    
    // @GetMapping("/getByUnionId/{unionId}")
    // List<Address> getAddressByUnionId(@PathVariable Long unionId) {
    //     Unions union = uniionService.getUnionById(unionId);
    //     return addressService.getAddressByUnion(union);}

    
    // @GetMapping("/prCooperative/{prCooperativeId}")
    // List<Address> getAddressByPrCooperativeId(@PathVariable Long prCooperativeId)  {
    // PrCooperative prCooperative =prCoopperativeService.getPrCooperativeById(prCooperativeId);
    // return addressService.getAddressByPrCooperative(prCooperative); }

    @PostMapping("/add")
    public ResponseEntity<CreateResponse> addAddress(@RequestBody Address address) {
      addressService.addAddress(address);
    CreateResponse response = new CreateResponse("Success", "Address created successfully");
    return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/edit/{addressId}")
    Address editAddress(@RequestBody Address tempAddress, @PathVariable Long addressId){
        Address address =  this.addressService.getAddressById(addressId);
        address.setEmail(tempAddress.getEmail());
        address.setCountry(tempAddress.getCountry());
        address.setRegion(tempAddress.getRegion());
        address.setZone(tempAddress.getZone());
        address.setWoreda(tempAddress.getWoreda());
        address.setTown(tempAddress.getTown());
        address.setKebele(tempAddress.getKebele());
        address.setPhoneNumber(tempAddress.getPhoneNumber());
        return addressService.editAddress(address);
    }
       

}


  
