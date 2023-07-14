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

@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class PrCooperative {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long prCooperativeId;
    private String name;
    @JsonFormat(pattern="yyyy-MM-dd",shape = Shape.STRING)
    @Column(name="date_of_establishment")
    private String dateOfEstablishmnet;
    private Double shareCapitalUponEstablishmnet;
    private Boolean isActive;
    //private String licensingOrgan;
    private Integer no_Of_MaleMembers;
    private Integer no_Of_FemaleMembers;
    private Integer maleMembersUpOnEstablishement;
    private Integer femaleMembersUpOnEstablishement;
    private Integer jobOpportunityCreated;

     //prCooperative address
     @OneToOne(cascade = CascadeType.ALL)
     private Address address;
 
     //prCooperative type
     @ManyToOne
     private Type type;
     

     //prCooperative sector
     @ManyToOne
     private Sector sector;

     //prCooperative union
     @ManyToOne
     private Unions union;

     @ManyToOne
     private Federations federations;
}
