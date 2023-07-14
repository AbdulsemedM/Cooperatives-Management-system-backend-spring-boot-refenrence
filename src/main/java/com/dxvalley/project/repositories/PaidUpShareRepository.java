package com.dxvalley.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxvalley.project.models.PaidUpShare;
import com.dxvalley.project.models.PrCooperative;
import com.dxvalley.project.models.Unions;

public interface PaidUpShareRepository extends JpaRepository<PaidUpShare, Long>{
    PaidUpShare findPaidUpShareByPaidUpId(Long paidUpShareId); 
    List<PaidUpShare> findPaidUpShareByUnion(Unions union);
    List<PaidUpShare> findPaidUpShareByPrCooperative(PrCooperative prCooperative);
    

}

