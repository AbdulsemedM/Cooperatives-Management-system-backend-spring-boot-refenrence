package com.dxvalley.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxvalley.project.models.Type;

public interface TypeRepository extends JpaRepository<Type,Long> {
    Type findTypeByTypeId(Long typeId);
    Type findTypeByTypeName(String tyepName);
}
