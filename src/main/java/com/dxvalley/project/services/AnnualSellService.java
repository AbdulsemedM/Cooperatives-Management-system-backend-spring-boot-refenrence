package com.dxvalley.project.services;

import java.util.List;

import com.dxvalley.project.models.AnnualSell;
import com.dxvalley.project.models.PrCooperative;

public interface AnnualSellService {
       
    AnnualSell addAnnualSell(AnnualSell annualSell);
    AnnualSell editAnnualSell (AnnualSell annualSell);
    List<AnnualSell> getAnnualSells ();
    AnnualSell getAnnualSellById(Long annualSellId);
    List<AnnualSell> getAnnualSellByPrCooperative(PrCooperative prCooperative);
    void deleteAnnuualSell( Long annualSellId);


}
