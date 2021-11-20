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
    public void findByEmailTest() {
        String email = "test@gmail.com";
        Optional<User> user = Optional.empty();
        Mockito.when(userService.findByEmail(email))
                .thenReturn(user);
        ResponseEntity<User> response = userController.findByEmail(email);
        Assert.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
