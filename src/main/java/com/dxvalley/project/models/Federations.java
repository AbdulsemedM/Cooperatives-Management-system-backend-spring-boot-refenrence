package com.dxvalley.project.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@RequiredArgsConstructor
@Setter

public class Federations {
        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long federationId;
        //private Long federationId;
        private String name;
        @JsonFormat(pattern="yyyy-MM-dd",shape = Shape.STRING)
        @Column(name="year_of_establishment")
        private String yearOfEstablishmnet;
        private Double shareCapitalUpOnEstablishement;
        
        
    
        @OneToOne(cascade = CascadeType.ALL)
        private Address address;
    
        
        @ManyToOne
        private Sector sector;
    
}
