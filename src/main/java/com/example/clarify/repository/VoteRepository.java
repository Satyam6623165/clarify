package com.example.clarify.repository;

import com.example.clarify.model.Vote;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface VoteRepository extends MongoRepository<Vote, String> {
    Optional<Vote> findByPidAndUid(String pid, String uid);
}
