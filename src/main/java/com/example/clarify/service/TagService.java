package com.example.clarify.service;

import com.example.clarify.model.Tag;

import java.util.List;

public interface TagService {
    Tag save(Tag tag);
    void deleteById(String tid);
    List<Tag> findByTitleLikeOrderByTitleAsc(String pattern);
    List<Tag> findAll();
}
