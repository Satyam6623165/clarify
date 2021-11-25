package com.example.clarify.controller.v1.api;

import com.example.clarify.model.User;
import com.example.clarify.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/{email}")
    public ResponseEntity<User> findByEmail(@PathVariable String email) {
        log.info("Fetching user by email: {}", email);
        Optional<User> user = userService.findByEmail(email);
        if(user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        }
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user) {
        log.info("Saving user: {}", user);
        try {
            User savedUser = userService.save(user);
            return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
