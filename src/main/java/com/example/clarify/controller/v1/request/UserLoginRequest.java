package com.example.clarify.controller.v1.request;

import com.example.clarify.model.enums.Role;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserLoginRequest {
    @NotEmpty(message = "{constraints.NotEmpty.message}")
    private String email;

    @NotEmpty(message = "{constraints.NotEmpty.message}")
    private String firstName;

    @NotEmpty(message = "{constraints.NotEmpty.message}")
    private String lastName;

    @NotEmpty(message = "{constraints.NotEmpty.message}")
    private String imageUrl;

    @NotEmpty(message = "{constraints.NotEmpty.message}")
    private Set<Role> roles;
}
