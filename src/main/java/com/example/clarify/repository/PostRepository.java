package com.example.clarify.repository;

import com.example.clarify.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PostRepository extends MongoRepository<Post, String> {
    List<Post> findByCid(String cid);
}
