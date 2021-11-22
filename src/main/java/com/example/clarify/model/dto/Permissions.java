package com.example.clarify.model.dto;

import com.example.clarify.enums.Permission;
import lombok.Data;

@Data
public class Permissions {
    private Permission student;
    private Permission faculty;
    private Permission moderator;

    Permissions() {
        this.student = Permission.HasNoAccess;
        this.faculty = Permission.HasNoAccess;
        this.moderator = Permission.HasNoAccess;
    }
}
