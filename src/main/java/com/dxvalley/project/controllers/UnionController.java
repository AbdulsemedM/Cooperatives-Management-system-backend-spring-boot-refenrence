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
import com.dxvalley.project.models.Unions;
import com.dxvalley.project.services.UnionService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/union")
public class UnionController {

    @Autowired
    private final UnionService unionService;

    @GetMapping("/getUnions")
    List<Unions> getUnions() {
    return this.unionService.getUnion();
  }

  @GetMapping("/{unionId}")
  Unions getUnions(@PathVariable Long unionId) {
    return unionService.getUnionById(unionId);
  }

  @PostMapping("/add")
  public ResponseEntity<CreateResponse>  addUnion(@RequestBody Unions union) {
    Unions unionToBeChecked=unionService.getUnionByName(union.getName());
    if(unionToBeChecked!=null)
    {
        
        CreateResponse response = new CreateResponse("error","existing union name");
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    else
    {
        unionService.addUnion(union);
        CreateResponse response = new CreateResponse("success","union created successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
 
  }

  @PutMapping("/edit/{unionId}")
  Unions editUnions(@RequestBody Unions tempUnion, @PathVariable Long unionId) {
    Unions union = this.unionService.getUnionById(unionId);
    union.setName(tempUnion.getName());
    union.setDateOfEstablishmnet(tempUnion.getDateOfEstablishmnet());
    union.setShareCapitalUponEstablishmnet(tempUnion.getShareCapitalUponEstablishmnet());
    union.setIsActive(tempUnion.getIsActive());
    union.setAddress(tempUnion.getAddress());
    //union.setLicensingOrgan(tempUnion.getLicensingOrgan());
    union.setSector(tempUnion.getSector());
    union.setType(tempUnion.getType());
    union.setFederations(tempUnion.getFederations());
    return unionService.editUnion(union);
  }
}
