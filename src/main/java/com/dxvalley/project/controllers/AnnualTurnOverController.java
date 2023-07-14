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

import com.dxvalley.project.models.AnnualTurnOver;
import com.dxvalley.project.models.CreateResponse;
import com.dxvalley.project.models.Unions;
import com.dxvalley.project.services.AnnualTurnOverService;
import com.dxvalley.project.services.UnionService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/annualTurnOver")

public class AnnualTurnOverController {

    @Autowired
    private final AnnualTurnOverService annualTurnOverService;
    private final UnionService UnionnService;


    @GetMapping("/getAnnualTurnOver")
    List<AnnualTurnOver> getAnnualTurnOvers() {
    return this.annualTurnOverService.getAnnualTurnOvers();
  }

  @GetMapping("/{annualTurnOverId}")
  AnnualTurnOver getAnnualTurnOver(@PathVariable Long annualTurnOverId) {
    return annualTurnOverService.getAnnualTurnOverById(annualTurnOverId);
  }

  @GetMapping("/union/{unionId}")
  List<AnnualTurnOver> getAnnualTurnOverByUnionId(@PathVariable Long unionId)  {
  Unions  union=UnionnService.getUnionById(unionId); 
  return annualTurnOverService.getAnnualTurnOverByUnion(union); 
}

  @PostMapping("/add")
  public ResponseEntity<CreateResponse> addCommodity(@RequestBody AnnualTurnOver annualTurnOver) {
    annualTurnOverService.addAnnualTurnOver(annualTurnOver);
      CreateResponse response = new CreateResponse("success", "AnnualTurnOver created successfully");
      return new ResponseEntity<>(response, HttpStatus.OK);

  }

  @PutMapping("/edit/{annualTurnOverId}")
  AnnualTurnOver editAnnualTurnOver(@RequestBody AnnualTurnOver tempAnnualTurnOver, @PathVariable Long annualTurnOverId) {
    AnnualTurnOver annualTurnOver = this.annualTurnOverService.getAnnualTurnOverById(annualTurnOverId);
    annualTurnOver.setAnnualTurnOverValue(tempAnnualTurnOver.getAnnualTurnOverValue());
    annualTurnOver.setDateGenerated(tempAnnualTurnOver.getDateGenerated());
    annualTurnOver.setUnion(tempAnnualTurnOver.getUnion());
    return annualTurnOverService.editAnnualTurnOver(annualTurnOver);
  }
    
    
}
