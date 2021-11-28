package com.example.clarify.model;

import com.example.clarify.enums.Role;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@Document(collection = "users")
public class User {
    @Id
    private String uid;

    @Indexed(unique = true)
    @NotNull(message = "User email cannot be null")
    private String email;

    @NotNull(message = "User first name cannot be null")
    private String firstName;

    @NotNull(message = "User last name cannot be null")
    private String lastName;

    private String imageUrl;

    @NotNull(message = "User should have at least one associated role")
    private Set<Role> roles;
}
