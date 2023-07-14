package com.dxvalley.project.services;

import java.util.List;

import com.dxvalley.project.models.OsLoan;
import com.dxvalley.project.models.PrCooperative;
import com.dxvalley.project.models.Unions;

public interface OsLoanService {
    OsLoan addOsLoan (OsLoan osLoan);
    OsLoan editOsLoan (OsLoan osLoan);
    List<OsLoan> getOsLoans ();
    OsLoan getOsLoanById(Long osLoanId);
    List<OsLoan> getOsLoansByUnion(Unions union);
    List<OsLoan> getOsLoanByPrCooperative(PrCooperative prCooperative);
    //TotalCapital getTotalCapitalByName(String typeName);
    void deleteOsLoan( Long osLoanId);
}
