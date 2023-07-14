package com.dxvalley.project.services;

import java.util.List;

import com.dxvalley.project.models.Account;
import com.dxvalley.project.models.PrCooperative;
import com.dxvalley.project.models.Unions;

public interface AccountService {
    Account addAccount(Account account);
    Account editAccount (Account account);
    List<Account> getAccounts ();
    Account getAccountById(Long accountId);
    List<Account> getAccountByUnion(Unions union);
    List<Account> getAccountByPrCooperative(PrCooperative prCooperative);
    Account getAccountByAccountNumber(String accountNumber);
    void deleteAccount( Long accountId);
}
