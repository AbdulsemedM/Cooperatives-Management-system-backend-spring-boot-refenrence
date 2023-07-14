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
import com.dxvalley.project.models.OsLoan;
import com.dxvalley.project.models.PrCooperative;
import com.dxvalley.project.models.Unions;
import com.dxvalley.project.services.OsLoanService;
import com.dxvalley.project.services.PrCooperativeService;
import com.dxvalley.project.services.UnionService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/osLoan")
public class OsLoanController {
    @Autowired
    private final OsLoanService osLoanService;
    private final UnionService unionService;
    private final PrCooperativeService prCooperativeService;

    @GetMapping("/getosLoans")
    List<OsLoan> getosLoans() {
        return this.osLoanService.getOsLoans();
    }

    @GetMapping("getByUnionId/{unionId}")
    List<OsLoan> getOsLoanByUnionId(@PathVariable Long unionId) {
        Unions union=unionService.getUnionById(unionId);
        return osLoanService.getOsLoansByUnion(union);
    }
    @GetMapping("getByPrCooperativeId/{prCooperativeId}")
    List<OsLoan> getOsLoanByPrCooperativeId(@PathVariable Long prCooperativeId) {
        PrCooperative prCooperative=prCooperativeService.getPrCooperativeById(prCooperativeId);
        return osLoanService.getOsLoanByPrCooperative(prCooperative);
    }

    @GetMapping("/{osLoanId}")
    OsLoan getMember(@PathVariable Long osLoanId) {
        return osLoanService.getOsLoanById(osLoanId);
    }

    @PostMapping("/add")
    public ResponseEntity<CreateResponse> addMember(@RequestBody OsLoan osLoan) {
        osLoanService.addOsLoan(osLoan);
        CreateResponse response = new CreateResponse("success", "osLoan created successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @PutMapping("/edit/{osLoanId}")
    OsLoan editOsLoan(@RequestBody OsLoan tempOsLoan, @PathVariable Long osLoanId) {
        OsLoan osLoan = this.osLoanService.getOsLoanById(osLoanId);
        osLoan.setDateGenerated(tempOsLoan.getDateGenerated());
        osLoan.setOsLoanValue(tempOsLoan.getOsLoanValue());
        osLoan.setPrCooperative(tempOsLoan.getPrCooperative());
        osLoan.setUnion(tempOsLoan.getUnion());

        return osLoanService.editOsLoan(osLoan);
    }

    // @DeleteMapping("/delete/{sectorId}")
    // void deleteSector(@PathVariable Long sectorId) {
    // sectorService.deleteSector(sectorId);
    // }
}
