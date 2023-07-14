package com.dxvalley.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxvalley.project.models.AnnualTurnOver;
import com.dxvalley.project.models.Unions;

public interface AnnualTurnOverRepository extends JpaRepository<AnnualTurnOver, Long>  { 

    AnnualTurnOver findAnnualTurnOverByAnnualTurnOverId(Long annualTurnOverId);
    List<AnnualTurnOver> findAnnualTurnOverByUnion(Unions union);
    
}
