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

import com.dxvalley.project.models.Commodity;
import com.dxvalley.project.models.CreateResponse;
import com.dxvalley.project.models.PrCooperative;
import com.dxvalley.project.models.Unions;
import com.dxvalley.project.services.CommodityService;
import com.dxvalley.project.services.PrCooperativeService;
import com.dxvalley.project.services.UnionService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/commodity")
public class CommodityController {
    @Autowired
    private final CommodityService commodityService;
    private final UnionService unionService;
    private final PrCooperativeService prCooperativeService;
    @GetMapping("/getcommodities")
    List<Commodity> getCommodities() {
        return this.commodityService.getCommodities();
    }

    @GetMapping("getByUnionId/{unionId}")
    List<Commodity> getCommodityByUnionId(@PathVariable Long unionId) {
        Unions union=unionService.getUnionById(unionId);
        return commodityService.getCommodityByUnion(union);
    }

    @GetMapping("getByPrCooperativeId/{prCooperativeId}")
    List<Commodity> getLiabiltyByPrCooperativeId(@PathVariable Long prCooperativeId) {
        PrCooperative prCooperative=prCooperativeService.getPrCooperativeById(prCooperativeId);
        return commodityService.getCommodityByPrCooperative(prCooperative);
    }

    @GetMapping("/{commodityId}")
    Commodity getCommodity(@PathVariable Long commodityId) {
        return commodityService.getCommodityById(commodityId);
    }

    @PostMapping("/add")
    public ResponseEntity<CreateResponse> addCommodity(@RequestBody Commodity commodity) {
        commodityService.addCommodity(commodity);
        CreateResponse response = new CreateResponse("success", "commodity created successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @PutMapping("/edit/{commodityId}")
    Commodity editMember(@RequestBody Commodity tempCommodity, @PathVariable Long commodityId) {
        Commodity commodity = this.commodityService.getCommodityById(commodityId);
       commodity.setCommodityName(tempCommodity.getCommodityName());
       commodity.setCommodityValue(tempCommodity.getCommodityValue()); 
       commodity.setPrCooperative(tempCommodity.getPrCooperative());
       commodity.setDateGenerated(tempCommodity.getDateGenerated());
       commodity.setUnion(tempCommodity.getUnion());
       commodity.setType(tempCommodity.getType());
        return commodityService.editCommodity(commodity);
    }

    // @DeleteMapping("/delete/{sectorId}")
    // void deleteSector(@PathVariable Long sectorId) {
    // sectorService.deleteSector(sectorId);
    // }

}
