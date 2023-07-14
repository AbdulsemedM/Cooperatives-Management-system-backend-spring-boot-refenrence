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
public class Type {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long typeId;
    private String typeName;
    private String type;
}
