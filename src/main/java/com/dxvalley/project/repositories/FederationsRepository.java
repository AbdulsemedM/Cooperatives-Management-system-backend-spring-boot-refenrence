package com.dxvalley.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxvalley.project.models.Federations;

public interface FederationsRepository extends JpaRepository<Federations, Long> {
    Federations findFederationsByFederationId(Long federationId);
   // Federations findFederationsById(Long federationId);
    Federations findFederationsByName(String name);
    
    
}
