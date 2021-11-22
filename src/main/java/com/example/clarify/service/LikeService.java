package com.example.clarify.service;

import com.example.clarify.model.Like;

import java.util.List;
import java.util.Optional;

public interface LikeService {
    Like save(Like like);
    List<Like> findByPid(String pid);
    Optional<Like> findByPidAndUid(String pid, String uid);
    void deleteById(String id);
}
