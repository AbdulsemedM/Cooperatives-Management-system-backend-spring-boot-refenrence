package com.dxvalley.project.services;

import java.util.List;
import com.dxvalley.project.models.PaidUpShare;
import com.dxvalley.project.models.PrCooperative;
import com.dxvalley.project.models.Unions;

public interface PaidUpShareService {
    PaidUpShare addPaidUpShare (PaidUpShare paidUpShare);
    PaidUpShare editPaidUpShare (PaidUpShare paidUpShare);
    List<PaidUpShare> getPaidUpShare ();
    PaidUpShare getPaidUpShareById(Long paidUpShareId);
    List<PaidUpShare> getPaidUpShareByUnion(Unions union);
    List<PaidUpShare> getPaidUpShareByPrCooperative(PrCooperative prCooperative);
    void deletegetPaidUpShare( Long PaidUpShareId);
    
}
