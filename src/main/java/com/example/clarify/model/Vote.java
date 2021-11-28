package com.example.clarify.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Data
@Document(collection = "likes")
@CompoundIndex(def = "{pid : 1, uid : 1}", name = "pid_uid_index", unique = true)
public class Vote {
    @Id
    private String id;

    @NotNull(message = "Post id cannot be null")
    private String pid;

    @NotNull(message = "User id cannot be null")
    private String uid;
}

