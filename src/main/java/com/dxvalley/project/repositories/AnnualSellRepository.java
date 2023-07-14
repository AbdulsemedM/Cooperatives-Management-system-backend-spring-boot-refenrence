package com.dxvalley.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxvalley.project.models.AnnualSell;
import com.dxvalley.project.models.PrCooperative;

public interface AnnualSellRepository extends JpaRepository<AnnualSell, Long> {

    AnnualSell findAnnualSellByAnnualSellId(Long annualSellId);
    List<AnnualSell> findAnnualSellByPrCooperative( PrCooperative prCooperative);
    
}
