package com.dxvalley.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dxvalley.project.models.CreateResponse;
import com.dxvalley.project.models.Sector;
import com.dxvalley.project.services.SectorService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/sector")
public class SectorController {
    @Autowired
    private final SectorService sectorService;
    
    @GetMapping("/getSectors")
    List<Sector> getSector() {
    return this.sectorService.getSectors();
  }

  @GetMapping("/{sectorId}")
  Sector getSector(@PathVariable Long sectorId) {
    return sectorService.getSectorById(sectorId);
  }

  @PostMapping("/add")
  public ResponseEntity<CreateResponse> addSector (@RequestBody Sector sector) {
    Sector sectorToBeChecked= sectorService.getSectorByName(sector.getName());
    if(sectorToBeChecked!=null)
    {
        CreateResponse response = new CreateResponse("error","existing sector name");
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    else if(sector.getName().equals(""))
    {
            
        CreateResponse response = new CreateResponse("error","name cannot be null");
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    else
    {
        sectorService.addSector(sector);
        CreateResponse response = new CreateResponse("success","sector created successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

  }

  @PutMapping("/edit/{sectorId}")
  Sector editSector(@RequestBody Sector tempSector, @PathVariable Long sectorId) {
    Sector sector = this.sectorService.getSectorById(sectorId);
    sector.setName(tempSector.getName());
    sector.setSectorDescription(tempSector.getSectorDescription());
    return sectorService.editsector(sector);
  }

//   @DeleteMapping("/delete/{sectorId}")
//   void deleteSector(@PathVariable Long sectorId) {
//     sectorService.deleteSector(sectorId);
//   }
}
