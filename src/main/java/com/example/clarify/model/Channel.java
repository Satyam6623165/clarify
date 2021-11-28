package com.example.clarify.model;

import com.example.clarify.enums.Permission;
import com.example.clarify.model.dto.Permissions;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Data
@Document(collection = "channels")
public class Channel {
    @Id
    private String cid;

    @Indexed(unique = true)
    @NotNull(message = "Channel Title cannot be null")
    private String title;

    private Permissions permissions;

    Channel() {
        this.permissions = new Permissions();
    }
}
