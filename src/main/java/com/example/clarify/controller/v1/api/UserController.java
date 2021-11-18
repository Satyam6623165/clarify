package com.example.clarify.controller.v1.api;

import com.example.clarify.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
   @Autowired
   private UserService userService;
}
