package com.dxvalley.project.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dxvalley.project.models.Federations;
import com.dxvalley.project.repositories.FederationsRepository;
import com.dxvalley.project.services.FederationService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FederationServiceImpl implements FederationService{

    private final FederationsRepository federationRepository;

    @Override
    public Federations addFederation(Federations federation) {
     return federationRepository.save(federation);
    }

    @Override
    public Federations editFederation(Federations federation) {
     return federationRepository.save(federation);
    }

    @Override
    public List<Federations> getFederation() {
      return federationRepository.findAll();
    }

    @Override
    public Federations getFederationByFederationId(Long federationId) {
       return federationRepository.findFederationsByFederationId(federationId);
    }

    @Override
    public Federations getFederationByName(String name) {
       return federationRepository.findFederationsByName(name);
    }

}
