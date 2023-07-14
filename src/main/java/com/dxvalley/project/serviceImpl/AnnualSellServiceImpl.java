package com.dxvalley.project.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.dxvalley.project.models.AnnualSell;
import com.dxvalley.project.models.PrCooperative;
import com.dxvalley.project.repositories.AnnualSellRepository;
import com.dxvalley.project.services.AnnualSellService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service

public class AnnualSellServiceImpl implements AnnualSellService {

    @Autowired
    private final AnnualSellRepository annualSellRepositories;

    @Override
    public AnnualSell addAnnualSell(AnnualSell annualSell) {
        return annualSellRepositories.save(annualSell);
    }

    @Override
    public AnnualSell editAnnualSell(AnnualSell annualSell) {
        return annualSellRepositories.save(annualSell);
       
    }

    @Override
    public List<AnnualSell> getAnnualSells() {
       return annualSellRepositories.findAll();
    }

    @Override
    public AnnualSell getAnnualSellById(Long annualSellId) {
     return annualSellRepositories.findAnnualSellByAnnualSellId(annualSellId);
    }

    @Override
    public void deleteAnnuualSell(Long annualSellId) {
        annualSellRepositories.deleteById(annualSellId);
    }

    @Override
    public List<AnnualSell> getAnnualSellByPrCooperative(PrCooperative prCooperative) {
       return annualSellRepositories.findAnnualSellByPrCooperative(prCooperative);
    }

   

    
}
