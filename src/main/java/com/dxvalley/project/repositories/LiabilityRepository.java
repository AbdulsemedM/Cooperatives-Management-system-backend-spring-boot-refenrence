package com.dxvalley.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxvalley.project.models.Liabilty;
import com.dxvalley.project.models.PrCooperative;
import com.dxvalley.project.models.Unions;

public interface LiabilityRepository extends JpaRepository<Liabilty,Long>{
    Liabilty findLiabiltyByLiabilityId(Long liabilityId);
    List<Liabilty> findLiabiltyByUnion(Unions union);
    List<Liabilty> findLiabiltyByPrCooperative(PrCooperative prCooperative);
}
