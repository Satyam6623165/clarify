package com.example.clarify.model;

import com.example.clarify.enums.Type;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@Document(collection = "posts")
public class Post {
    @Id
    private String pid;

    private String cid;

    private String uid;

    private Type postType;

    private Date createdAt;

    private Date ModifiedAt;

    private String content;

    private List<String> tags;
}
