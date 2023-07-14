package com.dxvalley.project.services;

import java.util.List;

import com.dxvalley.project.models.Liabilty;
import com.dxvalley.project.models.PrCooperative;
import com.dxvalley.project.models.Unions;

public interface LiabilityService {
    Liabilty addLiabilty(Liabilty liabilty);
    Liabilty editLiabilty (Liabilty liabilty);
    List<Liabilty> getLiabilties ();
    Liabilty getLiabiltyById(Long liabiltyId);
    List<Liabilty> getLiabiltyByUnion(Unions union);
    List<Liabilty> getLiabiltyByPrCooperative(PrCooperative prCooperative);
    //Member getTypeByName(String typeName);
    void deleteLiabilty( Long liabiltyId);
}
