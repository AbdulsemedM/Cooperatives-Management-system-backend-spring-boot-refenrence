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

import com.dxvalley.project.models.AnnualSell;
import com.dxvalley.project.models.CreateResponse;
import com.dxvalley.project.models.PrCooperative;
import com.dxvalley.project.services.AnnualSellService;
import com.dxvalley.project.services.PrCooperativeService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/annualSell")

public class AnnualSellController {
    
    @Autowired
    private final AnnualSellService annualSellService;
    private final PrCooperativeService prcCooperativeService;

    @GetMapping("/getAnnualSell")
    List<AnnualSell> getAnnualSell () {
    return this.annualSellService.getAnnualSells();
  }

  @GetMapping("/{annualSellId}")
  AnnualSell getAnnualSell(@PathVariable Long annualSellId) {
    return annualSellService.getAnnualSellById(annualSellId);  
  }

  @GetMapping("/prCooperative/{prCooperativeId}")
    List<AnnualSell> getAnnualSellByPrCooperativeId(@PathVariable Long prCooperativeId) {
    PrCooperative prCooperative=prcCooperativeService.getPrCooperativeById(prCooperativeId);
    return annualSellService.getAnnualSellByPrCooperative(prCooperative); 
  }


  @PostMapping("/add")
  public ResponseEntity<CreateResponse> addCommodity(@RequestBody AnnualSell annualSell) {
    annualSellService.addAnnualSell(annualSell);
      CreateResponse response = new CreateResponse("success", "AnnualSell created successfully");
      return new ResponseEntity<>(response, HttpStatus.OK);

  }

  @PutMapping("/edit/{annualSellId}")
  AnnualSell editAnnualSell(@RequestBody AnnualSell tempAnnualSell, @PathVariable Long annualSellId) {
    AnnualSell annualSell = this.annualSellService.getAnnualSellById(annualSellId); 
    annualSell.setAnnualSellValue(tempAnnualSell.getAnnualSellValue());
    annualSell.setDateGenerated(tempAnnualSell.getDateGenerated());
    annualSell.setPrCooperative(tempAnnualSell.getPrCooperative());
    return annualSellService.editAnnualSell(annualSell);
  }

}
