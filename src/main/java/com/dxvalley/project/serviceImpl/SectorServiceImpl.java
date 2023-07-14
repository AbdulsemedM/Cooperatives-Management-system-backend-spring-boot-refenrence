package com.dxvalley.project.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxvalley.project.models.Sector;
import com.dxvalley.project.repositories.SectorRepositories;
import com.dxvalley.project.services.SectorService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SectorServiceImpl implements SectorService {
    @Autowired
    private final SectorRepositories sectorRepositories;
    @Override
    public Sector addSector(Sector sector) {
       return sectorRepositories.save(sector);
    }

    @Override
    public Sector editsector(Sector sector) {
        return sectorRepositories.save(sector);
    }

    @Override
    public List<Sector> getSectors() {
       return sectorRepositories.findAll();
    }

    @Override
    public Sector getSectorById(Long sectorId) {
        return sectorRepositories.findSectorBySectorId(sectorId);
    }

    @Override
    public void deleteSector(Long sectorId) {
       sectorRepositories.deleteById(sectorId);
    }

    @Override
    public Sector getSectorByName(String name) {
        return sectorRepositories.findSectorByName(name);
    }
    
}
