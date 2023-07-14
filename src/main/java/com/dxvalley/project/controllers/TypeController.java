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
import com.dxvalley.project.models.Type;
import com.dxvalley.project.services.TypeService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/type")
public class TypeController {
    @Autowired
    private final TypeService typeService;

    @GetMapping("/getTypes")
    List<Type> getType() {
    return this.typeService.getTypes();
  }

  @GetMapping("/{typeId}")
  Type getType(@PathVariable Long typeId) {
    return typeService.getTypeById(typeId);
  }

  @PostMapping("/add")
  public ResponseEntity<CreateResponse> addType(@RequestBody Type type) {
    Type typeToBeChecked = typeService.getTypeByName(type.getTypeName());
    if(typeToBeChecked!=null)
    {
        CreateResponse response = new CreateResponse("error","existing type name");
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    else
    {
        typeService.addType(type);
        CreateResponse response = new CreateResponse("success","type created successfully");
    return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
  }

  @PutMapping("/edit/{typeId}")
  Type editSector(@RequestBody Type tempType, @PathVariable Long typeId) {
    Type type = this.typeService.getTypeById(typeId);
    type.setType(tempType.getType());
    type.setTypeName(tempType.getTypeName());
    return typeService.editType(type);
  }
}
