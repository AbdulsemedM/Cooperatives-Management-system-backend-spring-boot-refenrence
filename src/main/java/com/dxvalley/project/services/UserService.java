package com.dxvalley.project.services;

import java.util.List;

import com.dxvalley.project.models.Users;

public interface UserService {
    Users getUsersByName(String username);
    List<Users> getUsers ();
}
