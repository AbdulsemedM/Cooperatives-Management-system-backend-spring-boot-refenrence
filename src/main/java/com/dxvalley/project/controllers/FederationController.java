package com.dxvalley.project.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dxvalley.project.models.CreateResponse;
import com.dxvalley.project.models.Federations;
import com.dxvalley.project.services.FederationService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/federation")

public class FederationController {

    private final FederationService federationService;

    @GetMapping("/getFederations")
    List<Federations> getFederations() {
    return this.federationService.getFederation();
  }

  @GetMapping("/{federationId}")
  Federations getFederations(@PathVariable Long federationId) {
    return federationService.getFederationByFederationId(federationId);
  }

  @PostMapping("/add")
  public ResponseEntity<CreateResponse>  addFederation(@RequestBody Federations federation) {
    Federations federationsToBeChecked=federationService.getFederationByName(federation.getName());
    if(federationsToBeChecked!=null)
    {
        
        CreateResponse response = new CreateResponse("error","existing federation name");
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    else
    {
        federationService.addFederation(federation);
        CreateResponse response = new CreateResponse("success","federation created successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
 
  }

  @PutMapping("/edit/{federationId}")
  Federations editFederations(@RequestBody Federations tempFederation, @PathVariable Long federationId) {
    Federations federation = this.federationService.getFederationByFederationId(federationId);
    federation.setName(tempFederation.getName());
    federation.setYearOfEstablishmnet(tempFederation.getYearOfEstablishmnet());
    federation.setShareCapitalUpOnEstablishement(tempFederation.getShareCapitalUpOnEstablishement());
    federation.setSector(tempFederation.getSector());
    return federationService.editFederation(federation);
  }



    
}
