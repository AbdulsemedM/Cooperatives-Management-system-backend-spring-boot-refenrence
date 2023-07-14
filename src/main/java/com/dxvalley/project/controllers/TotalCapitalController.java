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
import com.dxvalley.project.models.TotalCapital;
import com.dxvalley.project.services.PrCooperativeService;
import com.dxvalley.project.services.TotalCapitalService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/totalCapital")
public class TotalCapitalController {
    @Autowired
    private final TotalCapitalService totalCapitalService;
    private final PrCooperativeService prCooperrativeService;


    @GetMapping("/totalCapitals")
    List<TotalCapital> getTotalCapitals() {
        return this.totalCapitalService.getTotalCapitals();
    }

    @GetMapping("/{totalCapitalId}")
    TotalCapital getTotalCapital(@PathVariable Long totalCapitalId) {
        return totalCapitalService.getTotalCapitalById(totalCapitalId);
    }

    @GetMapping("/prCooperative/{prCooperativeId}")
    List<TotalCapital> getTotalCapitalByPrCooperativeId(@PathVariable Long prCooperativeId)  {
    PrCooperative prCooperative =prCooperrativeService.getPrCooperativeById(prCooperativeId);
    return totalCapitalService.getTotalCapitalByPrCooperative(prCooperative);
    }


    @PostMapping("/add")
    public ResponseEntity<CreateResponse> addTotalCapital(@RequestBody TotalCapital totalCapital) {
        totalCapitalService.addTotalCapital(totalCapital);
        CreateResponse response = new CreateResponse("success", "totalCapital created successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @PutMapping("/edit/{totalCapitalId}")
    TotalCapital editMember(@RequestBody TotalCapital tempTotalCapital, @PathVariable Long totalCapitalId) {
        TotalCapital totalCapital = this.totalCapitalService.getTotalCapitalById(totalCapitalId);
        totalCapital.setDateGenerated(tempTotalCapital.getDateGenerated());
        totalCapital.setTotalCapitalValue(tempTotalCapital.getTotalCapitalValue());
        totalCapital.setPrCooperative(tempTotalCapital.getPrCooperative());
        
        return totalCapitalService.editTotalCapital(totalCapital);
    }

    // @DeleteMapping("/delete/{sectorId}")
    // void deleteSector(@PathVariable Long sectorId) {
    // sectorService.deleteSector(sectorId);
    // }
}
