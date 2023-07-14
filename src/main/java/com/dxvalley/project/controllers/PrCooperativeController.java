package com.dxvalley.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.dxvalley.project.models.PrCooperative;
import com.dxvalley.project.models.Unions;
import com.dxvalley.project.services.PrCooperativeService;
import com.dxvalley.project.services.UnionService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/prCooperatives")


public class PrCooperativeController {
    @Autowired 
    private final PrCooperativeService prCooperativeService;
    private final UnionService UnnionService;
  
  @GetMapping("/getPrCooperatives")
  List<PrCooperative> getPrCooperative() {
      return this.prCooperativeService.getPrCooperative();
  }

  @GetMapping("/{prCooperativeId}")
  PrCooperative getPrCooperative(@PathVariable Long prCooperativeId) {
    return prCooperativeService.getPrCooperativeById(prCooperativeId);
  }

  @GetMapping("/union/{unionId}")
  List<PrCooperative> getPrCooperativeByUnionId(@PathVariable Long unionId)  {
  Unions  union=UnnionService.getUnionById(unionId); 
  return prCooperativeService.getPrCooperativeByUnion(union); 
}

  @PostMapping("/add")
  public ResponseEntity<CreateResponse>  addPrCooperative(@RequestBody PrCooperative prCooperative) {
    PrCooperative prCooperativeToBeChecked=prCooperativeService.getPrCooperativeByName(prCooperative.getName());
    if(prCooperativeToBeChecked!=null)
    {
        
        CreateResponse response = new CreateResponse("error","existing prCooperative name");
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    else
    {
        prCooperativeService.addPrCooperative(prCooperative); 
        CreateResponse response = new CreateResponse("success","prCooperative created successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
 
  }

  @PutMapping("/edit/{prCooperativeId}")
  PrCooperative editPrCooperative(@RequestBody PrCooperative tempPrCooperative, @PathVariable Long prCooperativeId) {
    PrCooperative prCooperative = this.prCooperativeService.getPrCooperativeById(prCooperativeId);
    prCooperative.setName(tempPrCooperative.getName());
    prCooperative.setDateOfEstablishmnet(tempPrCooperative.getDateOfEstablishmnet());
    prCooperative.setShareCapitalUponEstablishmnet(tempPrCooperative.getShareCapitalUponEstablishmnet());
    prCooperative.setIsActive(tempPrCooperative.getIsActive());
    prCooperative.setAddress(tempPrCooperative.getAddress());
    prCooperative.setType(tempPrCooperative.getType());
   // prCooperative.setLicensingOrgan(tempPrCooperative.getLicensingOrgan());
    prCooperative.setNo_Of_MaleMembers(tempPrCooperative.getNo_Of_MaleMembers());
    prCooperative.setNo_Of_FemaleMembers(tempPrCooperative.getNo_Of_FemaleMembers());
    prCooperative.setFemaleMembersUpOnEstablishement(tempPrCooperative.getFemaleMembersUpOnEstablishement());
    prCooperative.setMaleMembersUpOnEstablishement(tempPrCooperative.getMaleMembersUpOnEstablishement());
    prCooperative.setJobOpportunityCreated(tempPrCooperative.getJobOpportunityCreated());
    
    prCooperative.setSector(tempPrCooperative.getSector());
    prCooperative.setUnion(tempPrCooperative.getUnion());
    prCooperative.setFederations(tempPrCooperative.getFederations());
    return prCooperativeService.editPrCooperative(prCooperative);
  }



}
