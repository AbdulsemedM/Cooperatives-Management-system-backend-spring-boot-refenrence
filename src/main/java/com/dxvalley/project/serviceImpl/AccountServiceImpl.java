package com.dxvalley.project.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxvalley.project.models.Account;
import com.dxvalley.project.models.PrCooperative;
import com.dxvalley.project.models.Unions;
import com.dxvalley.project.repositories.AccountRepository;
import com.dxvalley.project.services.AccountService;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class AccountServiceImpl implements AccountService{
    @Autowired
    private final AccountRepository accountRepository;

    @Override
    public Account addAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account editAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Account getAccountById(Long accountId) {
       return accountRepository.findAccountByAccountId(accountId);
    }

    @Override
    public void deleteAccount(Long accountId) {
        accountRepository.deleteById(accountId);
    }

    @Override
    public Account getAccountByAccountNumber(String accountNumber) {
        return accountRepository.findAccountyByAccountNumber(accountNumber);
    }

    @Override
    public List<Account> getAccountByUnion(Unions union) {
        return accountRepository.findAccountByUnion(union);
    }

    @Override
    public List<Account> getAccountByPrCooperative(PrCooperative prCooperative) {
        return accountRepository.findAccountByPrCooperative(prCooperative);
    }
    
}
