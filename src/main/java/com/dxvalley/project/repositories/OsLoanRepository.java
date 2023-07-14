package com.dxvalley.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxvalley.project.models.OsLoan;
import com.dxvalley.project.models.PrCooperative;
import com.dxvalley.project.models.Unions;

public interface OsLoanRepository extends JpaRepository<OsLoan,Long> {
    OsLoan findOsLoanByOsLoanId(Long osLoanId);
    List<OsLoan> findOsLoanByUnion(Unions union);
    List<OsLoan> findOsLoanByPrCooperative(PrCooperative prCooperative);
}
