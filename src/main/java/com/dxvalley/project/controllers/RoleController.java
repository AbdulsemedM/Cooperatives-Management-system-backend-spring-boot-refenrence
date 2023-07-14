package com.dxvalley.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dxvalley.project.models.Role;
import com.dxvalley.project.services.RoleService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/role")
public class RoleController {
    @Autowired
    private final RoleService roleService;
    @GetMapping("/getRoles")
    List<Role> getRoles() {
    return this.roleService.getRoles();
  }
}
