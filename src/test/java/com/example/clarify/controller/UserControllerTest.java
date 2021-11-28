package com.example.clarify.controller;

import com.example.clarify.controller.v1.api.UserController;
import com.example.clarify.model.User;
import com.example.clarify.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {
    @InjectMocks private UserController userController;

    @Mock
    private UserService userService;

    @Test
    public void findByEmailSuccessCase() {
        String email = "test@gmail.com";
        User user = new User();
        user.setEmail(email);
        Optional<User> userData = Optional.of(user);
        Mockito.when(userService.findByEmail(email)).thenReturn(userData);
        ResponseEntity<User> response = userController.findByEmail(email);
        Assert.assertEquals(user, response.getBody());
    }

    @Test
    public void findByEmailFailureCase() {
        String email = "test@gmail.com";
        Optional<User> user = Optional.empty();
        Mockito.when(userService.findByEmail(email)).thenReturn(user);
        ResponseEntity<User> response = userController.findByEmail(email);
        Assert.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void saveUserSuccessCase() {
        User user = new User();
        user.setEmail("sk@gmail.com");
        Mockito.when(userService.save(user)).thenReturn(user);
        ResponseEntity<User> response = userController.save(user);
        Assert.assertEquals(user, response.getBody());
    }

    @Test
    public void saveUserFailureCase() {
        User user = new User();
        user.setEmail("sk@gmail.com");
        Mockito.when(userService.save(user)).thenThrow(new RuntimeException());
        ResponseEntity<User> response = null;
        try {
            response = userController.save(user);
        } catch (RuntimeException e) {
            Assert.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        }
    }
}
