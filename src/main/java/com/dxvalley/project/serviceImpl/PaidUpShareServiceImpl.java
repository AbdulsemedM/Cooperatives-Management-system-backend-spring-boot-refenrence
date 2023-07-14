package com.dxvalley.project.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.dxvalley.project.models.PaidUpShare;
import com.dxvalley.project.models.PrCooperative;
import com.dxvalley.project.models.Unions;
import com.dxvalley.project.repositories.PaidUpShareRepository;
import com.dxvalley.project.services.PaidUpShareService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service

public class PaidUpShareServiceImpl implements PaidUpShareService {

    @Autowired
    private final PaidUpShareRepository paidUpShareRepository;
    @Override
    public PaidUpShare addPaidUpShare(PaidUpShare paidUpShare) {
       return paidUpShareRepository.save(paidUpShare);
    }

    @Override
    public PaidUpShare editPaidUpShare(PaidUpShare paidUpShare) {
        return paidUpShareRepository.save(paidUpShare);
    }

    @Override
    public List<PaidUpShare> getPaidUpShare() {
      return paidUpShareRepository.findAll();
    }

    @Override
    public PaidUpShare getPaidUpShareById(Long paidUpShareId) {
        return paidUpShareRepository.findPaidUpShareByPaidUpId(paidUpShareId);
    }

    @Override
    public void deletegetPaidUpShare(Long PaidUpShareId) {
        paidUpShareRepository.deleteById(PaidUpShareId);
    }

    @Override
    public List<PaidUpShare> getPaidUpShareByUnion(Unions union) {
        return paidUpShareRepository.findPaidUpShareByUnion(union);
    }

    @Override
    public List<PaidUpShare> getPaidUpShareByPrCooperative(PrCooperative prCooperative) {
       return paidUpShareRepository.findPaidUpShareByPrCooperative(prCooperative);
    }
    
}
