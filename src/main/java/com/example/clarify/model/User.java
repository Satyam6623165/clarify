package com.example.clarify.model;

import com.example.clarify.enums.Role;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Data
@Document(collection = "users")
public class User {
    @Id
    private String uid;

    @Indexed(unique = true)
    private String email;

    private String firstName;

    private String lastName;

    private String imageUrl;

    private Set<Role> roles;
}
