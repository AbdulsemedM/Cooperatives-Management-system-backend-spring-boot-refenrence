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
import com.dxvalley.project.models.Liabilty;
import com.dxvalley.project.models.PrCooperative;
import com.dxvalley.project.models.Unions;
import com.dxvalley.project.services.LiabilityService;
import com.dxvalley.project.services.PrCooperativeService;
import com.dxvalley.project.services.UnionService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/liability")
public class LiabilityController {
    @Autowired
    private final LiabilityService liabilityService;
    private final UnionService unionService;
    private final PrCooperativeService prCooperativeService;

    @GetMapping("/getLiabilities")
    List<Liabilty> getLiabilities() {
        return this.liabilityService.getLiabilties();
    }

    @GetMapping("getByUnionId/{unionId}")
    List<Liabilty> getLiabiltyByUnionId(@PathVariable Long unionId) {
        Unions union=unionService.getUnionById(unionId);
        return liabilityService.getLiabiltyByUnion(union);
    }

    @GetMapping("getByPrCooperativeId/{prCooperativeId}")
    List<Liabilty> getLiabiltyByPrCooperativeId(@PathVariable Long prCooperativeId) {
        PrCooperative prCooperative=prCooperativeService.getPrCooperativeById(prCooperativeId);
        return liabilityService.getLiabiltyByPrCooperative(prCooperative);
    }

    @GetMapping("/{liabilityId}")
    Liabilty getLiabilty(@PathVariable Long liabilityId) {
        return liabilityService.getLiabiltyById(liabilityId);
    }

    @PostMapping("/add")
    public ResponseEntity<CreateResponse> addMember(@RequestBody Liabilty liabilty) {
        liabilityService.addLiabilty(liabilty);
        CreateResponse response = new CreateResponse("success", "liability added successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @PutMapping("/edit/{liabilityId}")
    Liabilty editLiabilty(@RequestBody Liabilty tempLiabilty, @PathVariable Long liabilityId) {
        Liabilty liabilty = this.liabilityService.getLiabiltyById(liabilityId);
        liabilty.setDateGenerated(tempLiabilty.getDateGenerated());
        liabilty.setLiabilityValue(tempLiabilty.getLiabilityValue());
        liabilty.setPrCooperative(tempLiabilty.getPrCooperative());
        liabilty.setUnion(tempLiabilty.getUnion());

        return liabilityService.editLiabilty(liabilty);
    }

    // @DeleteMapping("/delete/{sectorId}")
    // void deleteSector(@PathVariable Long sectorId) {
    // sectorService.deleteSector(sectorId);
    // }
}
