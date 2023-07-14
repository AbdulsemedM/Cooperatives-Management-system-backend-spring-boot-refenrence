package com.dxvalley.project.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxvalley.project.models.Account;
import com.dxvalley.project.models.AccountBalance;
import com.dxvalley.project.repositories.AccountBalanceRepository;
import com.dxvalley.project.services.AccountBalanceService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AccoutBalanceServiceImpl implements AccountBalanceService{
    @Autowired
    private final AccountBalanceRepository accountBalanceRepository;
    @Override
    public AccountBalance addAccountBalance(AccountBalance accountBalance) {
       return accountBalanceRepository.save(accountBalance);
    }

    @Override
    public AccountBalance editAccountBalance(AccountBalance accountBalance) {
        return accountBalanceRepository.save(accountBalance);
    }

    @Override
    public List<AccountBalance> getAccountBalances() {
        return accountBalanceRepository.findAll();
    }

    @Override
    public AccountBalance getAccountBalanceById(Long accountBalanceId) {
    return accountBalanceRepository.findAccountBalanceByAccountBalanceId(accountBalanceId);
    }

    @Override
    public AccountBalance getAccountBalanceByDateGenerated(String dateGenerated) {
       return accountBalanceRepository.findAccountBalanceBydateGenerated(dateGenerated);
    }

    @Override
    public void deleteAccountBalance(Long accountBalanceId) {
        accountBalanceRepository.deleteById(accountBalanceId);
    }

    @Override
    public List<AccountBalance> getAccountBalancesByAccount(Account acount) {
        return accountBalanceRepository.findAccountBalanceByAccount(acount);
    }
    
}
