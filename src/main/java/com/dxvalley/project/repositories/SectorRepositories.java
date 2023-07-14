package com.dxvalley.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxvalley.project.models.Sector;

public interface SectorRepositories extends JpaRepository<Sector,Long>{
    Sector findSectorBySectorId(Long sectorId);
    Sector findSectorByName(String name);
}
