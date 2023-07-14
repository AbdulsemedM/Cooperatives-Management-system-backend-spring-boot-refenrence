package com.dxvalley.project.services;

import java.util.List;

import com.dxvalley.project.models.Asset;
import com.dxvalley.project.models.PrCooperative;
import com.dxvalley.project.models.Unions;

public interface AssetService {
    Asset addAsset (Asset asset);
    Asset editAsset (Asset asset);
    List<Asset> getAssets ();
    Asset getAssetById(Long assetId);
    List<Asset> getAssetByUnion(Unions union);
    List<Asset> getAssetByPrCooperative(PrCooperative prCooperative);
    
    Asset getAssetByAssetName(String assetName);
    void deleteAsset( Long assetId);
    
    
}
