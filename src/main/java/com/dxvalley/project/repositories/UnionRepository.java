package com.dxvalley.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxvalley.project.models.Unions;

public interface UnionRepository extends JpaRepository<Unions,Long> {
    Unions findUnionsByUnionId(Long unionId);
    Unions findUnionsByName(String name);
}
