package com.example.clarify.service;

import com.example.clarify.model.Tag;

import java.util.List;

public interface TagService {
    Tag save(Tag tag);
    void delete(Tag tag);
    List<Tag> findByTitleLikeOrderByTitleAsc(String pattern);
    List<Tag> findAllTags();
}
