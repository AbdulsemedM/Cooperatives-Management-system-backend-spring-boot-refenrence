package com.dxvalley.project.models;
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
public class Account {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long accountId;
    private String accountNumber;
    private String accountType;
    private String branch;
    private String district;

    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "union_id")
	private Unions union;

    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "prCooperative_id")
	private PrCooperative prCooperative;
}
