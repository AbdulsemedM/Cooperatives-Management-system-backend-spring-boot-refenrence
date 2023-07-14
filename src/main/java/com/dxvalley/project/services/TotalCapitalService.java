package com.dxvalley.project.services;

import java.util.List;

import com.dxvalley.project.models.PrCooperative;
import com.dxvalley.project.models.TotalCapital;

public interface TotalCapitalService {
    TotalCapital addTotalCapital (TotalCapital totalCapital);
    TotalCapital editTotalCapital (TotalCapital totalCapital);
    List<TotalCapital> getTotalCapitals ();
    TotalCapital getTotalCapitalById(Long totalCapitalId);
   List<TotalCapital> getTotalCapitalByPrCooperative(PrCooperative prCooperative);
    //TotalCapital getTotalCapitalByName(String typeName);
    void deleteTotalCapital( Long totalCapitalId);
}
