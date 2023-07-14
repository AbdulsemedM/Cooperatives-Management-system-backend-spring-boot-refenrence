package com.dxvalley.project.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;
    private String country;
    private String region;
    private String zone;
    private String woreda;
    private String town;
    private String kebele;
    private String email;
    private String phoneNumber;

    public Address(String phoneNumber, String email, String country, String region, String zone, String woreda, String town, String kebele){
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.country =country;
        this.region = region;
        this.zone= zone;
        this.woreda= woreda;
        this.town=town;
        this.kebele=kebele;
    }
    public Address(String phoneNumber, String email, String region, String zone, String woreda, String town,String kebele) {
        this(phoneNumber,email, "Ethiopia", region, zone, woreda, town,kebele);
    }
}

