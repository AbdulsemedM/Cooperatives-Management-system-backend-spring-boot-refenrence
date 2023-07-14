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
public class Unions {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long unionId;
    private String name;
    @JsonFormat(pattern="yyyy-MM-dd",shape = Shape.STRING)
    @Column(name="date_of_establishment")
    private String dateOfEstablishmnet;
    private Double shareCapitalUponEstablishmnet;
    private Boolean isActive;
    //private String licensingOrgan;

    //union address
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    //union type
    @ManyToOne
    private Type type;

    //union sector
    @ManyToOne
    private Sector sector;

    @ManyToOne
    private Federations federations;


    



}
