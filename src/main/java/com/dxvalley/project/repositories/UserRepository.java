package com.dxvalley.project.repositories;
import org.springframework.data.jpa.repository.JpaRepository;


import com.dxvalley.project.models.Users;

public interface UserRepository extends JpaRepository<Users,Long>{
    Users findByUsername(String username);
    Users findByUserId (Long userId);
}
