package com.dxvalley.project.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxvalley.project.models.OsLoan;
import com.dxvalley.project.models.PrCooperative;
import com.dxvalley.project.models.Unions;
import com.dxvalley.project.repositories.OsLoanRepository;
import com.dxvalley.project.services.OsLoanService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class OsLoanServiceImpl implements OsLoanService {
    @Autowired
    private final OsLoanRepository osLoanRepository;
    @Override
    public OsLoan addOsLoan(OsLoan osLoan) {
       return osLoanRepository.save(osLoan);
    }

    @Override
    public OsLoan editOsLoan(OsLoan osLoan) {
       return osLoanRepository.save(osLoan);
    }

    @Override
    public List<OsLoan> getOsLoans() {
      return osLoanRepository.findAll();
    }

    @Override
    public OsLoan getOsLoanById(Long osLoanId) {
       return osLoanRepository.findOsLoanByOsLoanId(osLoanId);
    }

    @Override
    public void deleteOsLoan(Long osLoanId) {
         osLoanRepository.deleteById(osLoanId);
    }

   @Override
   public List<OsLoan> getOsLoansByUnion(Unions union) {
      return osLoanRepository.findOsLoanByUnion(union);
   }

   @Override
   public List<OsLoan> getOsLoanByPrCooperative(PrCooperative prCooperative) {
      return osLoanRepository.findOsLoanByPrCooperative(prCooperative);
   }

   
    
}
