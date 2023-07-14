package com.dxvalley.project.services;

import java.util.List;

import com.dxvalley.project.models.Unions;

public interface UnionService {
    Unions addUnion (Unions union);
    Unions editUnion (Unions union);
    List<Unions> getUnion ();
    Unions getUnionById(Long unionId);
    void deleteUnion( Long uniodId);
    Unions getUnionByName(String name);
}
