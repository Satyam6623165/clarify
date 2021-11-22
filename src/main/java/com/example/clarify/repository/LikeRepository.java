package com.example.clarify.repository;

import com.example.clarify.model.Like;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface LikeRepository extends MongoRepository<Like, String> {
    List<Like> findByPid(String pid);
    Optional<Like> findByPidAndUid(String pid, String uid);
}
