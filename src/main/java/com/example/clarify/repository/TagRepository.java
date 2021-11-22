package com.example.clarify.repository;

import com.example.clarify.model.Tag;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TagRepository extends MongoRepository<Tag, String> {
    List<Tag> findByTitleLikeOrderByTitleAsc(String pattern);
}
