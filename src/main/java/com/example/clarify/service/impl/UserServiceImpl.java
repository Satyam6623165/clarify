package com.example.clarify.service.impl;

import com.example.clarify.model.User;
import com.example.clarify.repository.UserRepository;
import com.example.clarify.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.insert(user);
    }

    @Override
    public void deleteAllUsers() {
        userRepository.deleteAll();
    }
}
