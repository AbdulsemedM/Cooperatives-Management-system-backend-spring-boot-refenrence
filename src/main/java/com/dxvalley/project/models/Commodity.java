package com.dxvalley.project.models;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
public class Commodity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long commodityId;
    private String commodityName;
    private String type;
    private Double commodityValue;
    @JsonFormat(pattern="yyyy-MM-dd",shape = Shape.STRING)
    @Column(name="date_generated")
    private String dateGenerated;

    //commodity union
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "union_id")
	private Unions union;

     //commodity union
     @ManyToOne(fetch = FetchType.EAGER)
     @JoinColumn(name = "prcooperative_id")
     private PrCooperative prCooperative;
}
