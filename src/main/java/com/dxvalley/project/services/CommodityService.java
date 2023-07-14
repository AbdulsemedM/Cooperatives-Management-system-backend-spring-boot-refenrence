package com.dxvalley.project.services;

import java.util.List;

import com.dxvalley.project.models.Commodity;
import com.dxvalley.project.models.PrCooperative;
import com.dxvalley.project.models.Unions;

public interface CommodityService {
    Commodity addCommodity (Commodity commodity);
    Commodity editCommodity (Commodity commodity);
    List<Commodity> getCommodities ();
    Commodity getCommodityById(Long commodityId);
    List<Commodity> getCommodityByUnion(Unions union);
    List<Commodity> getCommodityByPrCooperative(PrCooperative prCooperative);
    //Member getTypeByName(String typeName);
    void deleteCommodity( Long commodityId);
}
