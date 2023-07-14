package com.dxvalley.project.services;

import java.util.List;

import com.dxvalley.project.models.Federations;

public interface FederationService {
    
    Federations addFederation (Federations federation);
    Federations editFederation (Federations federation);
    List<Federations> getFederation ();
    Federations getFederationByFederationId(Long federationId);
    Federations getFederationByName(String name);
}

