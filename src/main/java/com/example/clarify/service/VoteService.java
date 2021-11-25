package com.example.clarify.service;

import com.example.clarify.model.Vote;

import java.util.Optional;

public interface VoteService {
    Vote save(Vote like);
    Optional<Vote> findByPidAndUid(String pid, String uid);
    void deleteByPidAndUid(String pid, String uid);
}
