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

import com.dxvalley.project.models.AccountBalance;
import com.dxvalley.project.models.CreateResponse;
import com.dxvalley.project.services.AccountBalanceService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/accountBalance")
public class AccountBalanceController {
    @Autowired
    private final AccountBalanceService accountBalanceService;
    
    @GetMapping("/getaccountBalances")
    List<AccountBalance> getAccountBalances() {
        return this.accountBalanceService.getAccountBalances();
    }

    @GetMapping("byId/{accountBalanceId}")
    AccountBalance getAccountBalanceById(@PathVariable Long accountBalanceId) {
        return accountBalanceService.getAccountBalanceById(accountBalanceId);
    }

    @GetMapping("byDate/{dateGenerated}")
    AccountBalance getAccountBalanceByDateGenerated(@PathVariable String dateGenerated) {
        return accountBalanceService.getAccountBalanceByDateGenerated(dateGenerated);
    }

    @PostMapping("/add")
    public ResponseEntity<CreateResponse> addAccount(@RequestBody AccountBalance accountBalance) {
            accountBalanceService.addAccountBalance(accountBalance);
            CreateResponse response = new CreateResponse("success", "account balance added successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/edit/{accountBalanceId}")
    AccountBalance editMember(@RequestBody AccountBalance tempAccountBalance, @PathVariable Long accountBalanceId) {
        AccountBalance accountBalance = this.accountBalanceService.getAccountBalanceById(accountBalanceId);
       accountBalance.setAccountBalance(tempAccountBalance.getAccountBalance());
       accountBalance.setAccount(tempAccountBalance.getAccount());
       accountBalance.setDateGenerated(tempAccountBalance.getDateGenerated());
       return accountBalanceService.editAccountBalance(accountBalance);
    }

    // @DeleteMapping("/delete/{sectorId}")
    // void deleteSector(@PathVariable Long sectorId) {
    // sectorService.deleteSector(sectorId);
    // }
}
