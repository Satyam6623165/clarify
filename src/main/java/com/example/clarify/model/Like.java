package com.example.clarify.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "likes")
@CompoundIndex(def = "{pid : 1, uid : 1}", name = "pid_uid_index", unique = true)
public class Like {
    @Id
    private String id;

    private String pid;

    private String uid;
}

