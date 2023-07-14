package com.dxvalley.project.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxvalley.project.models.PrCooperative;
import com.dxvalley.project.models.Unions;
import com.dxvalley.project.repositories.PrCooperativeRepository;
import com.dxvalley.project.services.PrCooperativeService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PrCooperativeServiceImpl implements PrCooperativeService{
    @Autowired
    private final PrCooperativeRepository prCooperativeRepository;
    @Override
    public PrCooperative addPrCooperative(PrCooperative prCooperative) {
        return prCooperativeRepository.save(prCooperative);
    }

    @Override
    public PrCooperative editPrCooperative(PrCooperative prCooperative) {
       return prCooperativeRepository.save(prCooperative);
    }

    @Override
    public List<PrCooperative> getPrCooperative() {
       return prCooperativeRepository.findAll();
    }

    @Override
    public PrCooperative getPrCooperativeById(Long prCooperativeId) {
       return prCooperativeRepository.findPrCooperativeByPrCooperativeId(prCooperativeId);
    }

    @Override
    public PrCooperative getPrCooperativeByName(String name) {
        return prCooperativeRepository.findPrCooperativeByName(name);
    }

    @Override
    public void deletePrCooperative(Long prCooperativeId) {
       prCooperativeRepository.deleteById(prCooperativeId);
    }

   @Override
   public List<PrCooperative> getPrCooperativeByUnion(Unions union) {
      return prCooperativeRepository.findPrCooperativeByUnion(union);
   }

   @Override
   public List<PrCooperative> getPrCooperativeByUnionAndIsActive(Unions union, Boolean isActive) {
     return prCooperativeRepository.findPrCooperativeByUnionAndIsActive(union, isActive);
   }

    
    
}
