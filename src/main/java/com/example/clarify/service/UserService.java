package com.example.clarify.service;

import com.example.clarify.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAllUsers();
    Optional<User> findByEmail(String email);
    User save(User user);
    void deleteAllUsers();
}
