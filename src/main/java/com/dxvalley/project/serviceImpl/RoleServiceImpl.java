package com.dxvalley.project.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxvalley.project.models.Role;
import com.dxvalley.project.repositories.RoleRepository;
import com.dxvalley.project.services.RoleService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    private final RoleRepository repository;

    @Override
    public List<Role> getRoles() {
        return repository.findAll();
    }
    
}
