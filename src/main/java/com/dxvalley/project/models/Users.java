package com.dxvalley.project.models;

import java.util.ArrayList;
import java.util.Collection;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long userId;
    private String username;
    private String password;
    private String fullName;
    private String email;
    private Boolean emailConfirmed;
    private String gender;
    private String birthDate;
    private String imageUrl;
    private String ip;
    private String createdAt;
    private String deletedAt;
    private Integer languageCode;
    private Integer accessFailedCount;
    private Boolean twoFactorEnabled;
    private Boolean isEnabled;
    //private String verificationCode;
    //private boolean verificationCodeCreatedAt;

    //user address
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
    //user roles
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles = new ArrayList<>();

    
    //asset with union
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "union_Id")
	private Unions union;

    //asset with prCooperative
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "prCooperative_Id")
	private PrCooperative prCooperative;
    
   //user accounts
   


    public Users(String username, String password, String fullName, String email, Boolean emailConfirmed,String gender,String birthDate,String imageUrl,String ip,String createdAt, String deletedAt,Integer languageCode,  Integer accessFailedCount,  Boolean twoFactorEnabled,Boolean isEnabled) {
        this.username = username;
        this.password = new BCryptPasswordEncoder().encode(password);
        this.fullName = fullName;
        this.email= email;
        this.emailConfirmed= emailConfirmed;
        this.gender=gender;
        this.birthDate=birthDate;
        this.imageUrl=imageUrl;
        this.ip=ip;
        this.createdAt=createdAt;
        this.deletedAt=deletedAt;
        this.languageCode=languageCode;
        this.accessFailedCount=accessFailedCount;
        this.twoFactorEnabled=twoFactorEnabled;
        this.isEnabled=isEnabled;
        //this.verificationCode=verificationCode;
       // this.verificationCodeCreatedAt=verificationCodeCreatedAt;
    }


    public Users orElseThrow(Object object) {
        return null;
    }
    
}
