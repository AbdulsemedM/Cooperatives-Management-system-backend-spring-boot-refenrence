package com.dxvalley.project.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxvalley.project.models.Users;
import com.dxvalley.project.repositories.UserRepository;
import com.dxvalley.project.services.UserService;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class UsersServiceImpl implements UserService {

    @Autowired
    private final UserRepository userRepository;
    @Override
    public Users getUsersByName(String username) {
       return userRepository.findByUsername(username);
    }

    
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    public Users getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }


    @Override
    public List<Users> getUsers() {
        return userRepository.findAll();
    }
    
}
