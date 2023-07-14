package com.dxvalley.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxvalley.project.models.Commodity;
import com.dxvalley.project.models.PrCooperative;
import com.dxvalley.project.models.Unions;

public interface CommodityRespository extends JpaRepository<Commodity,Long>{
    Commodity findCommodityByCommodityId(Long commodityId);
    List<Commodity> findCommodityByUnion(Unions union);
    List<Commodity> findCommodityByPrCooperative(PrCooperative prCooperative);
}
