package com.dxvalley.project.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxvalley.project.models.Asset;
import com.dxvalley.project.models.PrCooperative;
import com.dxvalley.project.models.Unions;
import com.dxvalley.project.repositories.AssetRepository;
import com.dxvalley.project.services.AssetService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class AssetServiceImpl  implements AssetService{

    @Autowired
    private final AssetRepository assetRepositories;

    @Override
    public Asset addAsset(Asset asset) {
       return assetRepositories.save(asset);
    }

    @Override
    public Asset editAsset(Asset asset) {
      return assetRepositories.save(asset);
    }

    @Override
    public List<Asset> getAssets() {
        return assetRepositories.findAll();
    }

    @Override
    public Asset getAssetById(Long assetId) {
       return assetRepositories.findAssetByAssetId(assetId);
    }
    

    @Override
    public Asset getAssetByAssetName(String assetName) {
      return assetRepositories.findAssetByAssetName(assetName);
    }

    @Override
    public void deleteAsset(Long assetId) {
        assetRepositories.deleteById(assetId);
    }

    @Override
    public List<Asset> getAssetByUnion(Unions union) {
     return assetRepositories.findAssetByUnion(union);
    }

    @Override
    public List<Asset> getAssetByPrCooperative(PrCooperative prCooperative) {
      return assetRepositories.findAssetByPrCooperative(prCooperative);
    }
    
}
