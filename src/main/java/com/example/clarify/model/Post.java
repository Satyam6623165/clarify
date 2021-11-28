package com.example.clarify.model;

import com.example.clarify.enums.Type;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
@Document(collection = "posts")
public class Post {
    @Id
    private String pid;

    @NotNull(message = "Channel id cannot be null")
    private String cid;

    @NotNull(message = "User id cannot be null")
    private String uid;

    @NotNull(message = "Post type cannot be null")
    private Type postType;

    @NotNull(message = "ReplyTo(of type post id) cannot be null")
    private String replyTo;

    private Date createdAt;

    private Date ModifiedAt;

    @NotNull(message = "Post Title cannot be null")
    private String title;

    private String description;

    private Long voteCount;

    private long replyCount;

    @NotNull(message = "Post should contain at least one associated tag")
    private List<String> tags;
}
