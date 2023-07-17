package com.facebook.facebookmini.service;

import com.facebook.facebookmini.entity.AppUser;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<AppUser> getUser(Long id);
    void SignUpAppUser (AppUser appUser);
    Optional<AppUser> LoginAppUser(String email, String password);
    List<AppUser> getAllUsers();

}
