package com.dxvalley.project.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxvalley.project.models.AnnualTurnOver;
import com.dxvalley.project.models.Unions;
import com.dxvalley.project.repositories.AnnualTurnOverRepository;
import com.dxvalley.project.services.AnnualTurnOverService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service

public class AnnualTurnOverImpl implements AnnualTurnOverService {

    @Autowired
    private final AnnualTurnOverRepository annualTurnOverRepositories;

    @Override
    public AnnualTurnOver addAnnualTurnOver(AnnualTurnOver annualTurnOver) {
        return annualTurnOverRepositories.save(annualTurnOver);
       
    }

    @Override
    public AnnualTurnOver editAnnualTurnOver(AnnualTurnOver annualTurnOver) {
        return annualTurnOverRepositories.save(annualTurnOver);
      
    }

    @Override
    public List<AnnualTurnOver> getAnnualTurnOvers() {
         return annualTurnOverRepositories.findAll();
    }

    @Override
    public AnnualTurnOver getAnnualTurnOverById(Long annualTurnOverId) {
        return annualTurnOverRepositories.findAnnualTurnOverByAnnualTurnOverId(annualTurnOverId);
    }

   

    @Override
    public void deleteAnnualTurnOver(Long annualTurnOverId) {
        annualTurnOverRepositories.deleteById(annualTurnOverId);
    }

    @Override
    public List<AnnualTurnOver> getAnnualTurnOverByUnion(Unions union) {
      return annualTurnOverRepositories.findAnnualTurnOverByUnion(union);
    }

    }
    

