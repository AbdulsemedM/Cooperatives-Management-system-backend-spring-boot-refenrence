package com.dxvalley.project.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxvalley.project.models.Commodity;
import com.dxvalley.project.models.PrCooperative;
import com.dxvalley.project.models.Unions;
import com.dxvalley.project.repositories.CommodityRespository;
import com.dxvalley.project.services.CommodityService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CommodityServiceImpl implements CommodityService{
    @Autowired
    private final CommodityRespository commodityRespository;
    @Override
    public Commodity addCommodity(Commodity commodity) {
        return commodityRespository.save(commodity);
    }

    @Override
    public Commodity editCommodity(Commodity commodity) {
       return commodityRespository.save(commodity);
    }

    @Override
    public List<Commodity> getCommodities() {
      return commodityRespository.findAll();
    }

    @Override
    public Commodity getCommodityById(Long commodityId) {
        return commodityRespository.findCommodityByCommodityId(commodityId);
    }

    @Override
    public void deleteCommodity(Long commodityId) {
       commodityRespository.deleteById(commodityId);
    }

    @Override
    public List<Commodity> getCommodityByUnion(Unions union) {
       return commodityRespository.findCommodityByUnion(union);
    }

    @Override
    public List<Commodity> getCommodityByPrCooperative(PrCooperative prCooperative) {
       return commodityRespository.findCommodityByPrCooperative(prCooperative);
    }
    
}
