package com.example.clarify.service;

import com.example.clarify.model.Post;

import java.util.List;

public interface PostService {
    Post save(Post post);
    List<Post> findAll();
    List<Post> findByCid(String cid);
    void deleteById(String pid);
}
