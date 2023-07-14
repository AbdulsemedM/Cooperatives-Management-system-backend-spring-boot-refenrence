package com.dxvalley.project.services;

import java.util.List;

import com.dxvalley.project.models.PrCooperative;
import com.dxvalley.project.models.Unions;

public interface PrCooperativeService {
    PrCooperative addPrCooperative(PrCooperative prCooperative);
    PrCooperative editPrCooperative(PrCooperative prCooperative);
    List<PrCooperative> getPrCooperative ();
    PrCooperative getPrCooperativeById (Long prCooperativeId);
    List<PrCooperative> getPrCooperativeByUnion(Unions union);
    List<PrCooperative> getPrCooperativeByUnionAndIsActive(Unions union,Boolean isActive);
    PrCooperative getPrCooperativeByName(String name);
    void deletePrCooperative(Long prCooperativeId);

}


