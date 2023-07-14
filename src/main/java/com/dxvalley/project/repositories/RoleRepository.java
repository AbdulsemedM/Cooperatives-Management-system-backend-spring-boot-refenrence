package com.dxvalley.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.dxvalley.project.models.Role;


public interface RoleRepository extends JpaRepository <Role, Integer> {
    Role findByRoleName (String roleName);
}
