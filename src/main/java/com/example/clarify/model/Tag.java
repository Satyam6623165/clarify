package com.example.clarify.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Data
@Document(collection = "tags")
public class Tag {
    @Id
    private String tid;

    @Indexed(unique = true)
    @NotNull(message = "Tag title cannot be null")
    private String title;

    private String description;
}
