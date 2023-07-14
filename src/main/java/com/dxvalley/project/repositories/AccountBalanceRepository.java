package com.dxvalley.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxvalley.project.models.Account;
import com.dxvalley.project.models.AccountBalance;

public interface AccountBalanceRepository extends JpaRepository<AccountBalance,Long> {
    AccountBalance findAccountBalanceByAccountBalanceId(Long accountBalanceId);
    AccountBalance findAccountBalanceBydateGenerated(String dateGenerated);
    List<AccountBalance> findAccountBalanceByAccount(Account account);
}
