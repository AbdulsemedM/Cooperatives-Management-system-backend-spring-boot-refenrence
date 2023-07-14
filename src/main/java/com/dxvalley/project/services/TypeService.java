package com.dxvalley.project.services;

import java.util.List;

import com.dxvalley.project.models.Type;

public interface TypeService {
    Type addType (Type type);
    Type editType (Type type);
    List<Type> getTypes ();
    Type getTypeById(Long typeId);
    Type getTypeByName(String typeName);
    void deleteType( Long typeId);
}
