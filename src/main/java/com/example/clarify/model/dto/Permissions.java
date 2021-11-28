package com.example.clarify.model.dto;

import com.example.clarify.enums.Permission;
import lombok.Data;

@Data
public class Permissions {
    private Permission student;
    private Permission faculty;
    private Permission moderator;

    public Permissions() {
        this.student = Permission.CanReadWrite;
        this.faculty = Permission.CanReadWrite;
        this.moderator = Permission.CanReadWrite;
    }
}
