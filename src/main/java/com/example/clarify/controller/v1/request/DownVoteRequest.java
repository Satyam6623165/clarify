package com.example.clarify.controller.v1.request;

import lombok.Data;

@Data
public class DownVoteRequest {
    private String pid;
    private String uid;
}
