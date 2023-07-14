package com.dxvalley.project.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxvalley.project.models.PrCooperative;
import com.dxvalley.project.models.TotalCapital;
import com.dxvalley.project.repositories.TotalCapitalRepository;
import com.dxvalley.project.services.TotalCapitalService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TotalCapitalServiceImpl implements TotalCapitalService {
    @Autowired
    private final TotalCapitalRepository totalCapitalRepository;
    @Override
    public TotalCapital addTotalCapital(TotalCapital totalCapital) {
       return totalCapitalRepository.save(totalCapital);
    }

    @Override
    public TotalCapital editTotalCapital(TotalCapital totalCapital) {
       return totalCapitalRepository.save(totalCapital);
    }

    @Override
    public List<TotalCapital> getTotalCapitals() {
       return totalCapitalRepository.findAll();
    }

    @Override
    public TotalCapital getTotalCapitalById(Long totalCapitalId) {
    return totalCapitalRepository.findTotalCapitalByTotalCapitalId(totalCapitalId);
    }

    @Override
    public void deleteTotalCapital(Long totalCapitalId) {
        totalCapitalRepository.deleteById(totalCapitalId);
    }

   @Override
   public List<TotalCapital> getTotalCapitalByPrCooperative(PrCooperative prCooperative) {
      return totalCapitalRepository.findTotalCapitalByPrCooperative(prCooperative);
   }

  


    
    
}
