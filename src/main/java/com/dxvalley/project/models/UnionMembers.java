package com.dxvalley.project.models;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import jakarta.persistence.Column;
import jakarta.persistence.Entity; 
import jakarta.persistence.GeneratedValue; 
import jakarta.persistence.GenerationType; 
import jakarta.persistence.Id; 
import jakarta.persistence.JoinColumn; 
import jakarta.persistence.ManyToOne; 
import lombok.Getter; 
import lombok.RequiredArgsConstructor; 
import lombok.Setter; 
 
@Getter 
@Setter 
@RequiredArgsConstructor 
@Entity
public class UnionMembers {
    @Id 
    @GeneratedValue(strategy= GenerationType.AUTO) 
    private Long prCooperativesMemberId;

    @JsonFormat(pattern="yyyy-MM-dd",shape = Shape.STRING)
    @Column(name="joinedAt")
    private String  joinedAt;
    
    private Boolean isActive;

    @ManyToOne 
    @JoinColumn(name = "memberId") 
    Member member; 
 
    @ManyToOne 
    @JoinColumn(name = "unionId") 
    Unions union; 
}
