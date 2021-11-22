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

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
       log.info("Fetching all users from db");
       try {
           List<User> users = userService.findAllUsers();
           return new ResponseEntity<>(users, HttpStatus.OK);
       } catch(Exception e) {
           return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        log.info("Saving user: {}", user);
        try {
            User userSaved = userService.save(user);
            return new ResponseEntity<>(userSaved, HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAll() {
        log.info("Deleting all users from db");
        try {
            userService.deleteAllUsers();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
