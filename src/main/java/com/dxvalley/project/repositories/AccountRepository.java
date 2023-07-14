package com.dxvalley.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxvalley.project.models.Account;
import com.dxvalley.project.models.PrCooperative;
import com.dxvalley.project.models.Unions;

public interface AccountRepository extends JpaRepository<Account,Long>{
    Account findAccountByAccountId(Long accountId);
    Account findAccountyByAccountNumber(String accountNumber);
    List<Account> findAccountByUnion(Unions union);
    List<Account> findAccountByPrCooperative(PrCooperative prCooperative);
}
