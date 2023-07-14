package com.dxvalley.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxvalley.project.models.PrCooperative;
import com.dxvalley.project.models.TotalCapital;

public interface TotalCapitalRepository extends JpaRepository<TotalCapital,Long>{
    TotalCapital findTotalCapitalByTotalCapitalId(Long totalCapitalId);
    List<TotalCapital> findTotalCapitalByPrCooperative(PrCooperative prCooperative);
}
