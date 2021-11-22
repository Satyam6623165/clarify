package com.example.clarify.repository;

import com.example.clarify.model.Channel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ChannelRepository extends MongoRepository<Channel, String> {
    Optional<Channel> findByTitle(String title);
    Optional<Channel> findByCid(String cid);
}
