package com.dxvalley.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxvalley.project.models.Asset;
import com.dxvalley.project.models.PrCooperative;
import com.dxvalley.project.models.Unions;

public interface AssetRepository extends JpaRepository <Asset, Long> {
    Asset findAssetByAssetId(Long assetId);
    Asset findAssetByAssetName(String assetName);
    List<Asset> findAssetByUnion(Unions union);
    List<Asset> findAssetByPrCooperative(PrCooperative prCooperative);
     
}
