package com.example.clarify.service.impl;

import com.example.clarify.model.Post;
import com.example.clarify.repository.PostRepository;
import com.example.clarify.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    @Override
    public Post save(Post post) {
        return postRepository.save(post);
    }

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public List<Post> findByCid(String cid) {
        return postRepository.findByCid(cid);
    }

    @Override
    public void deleteById(String pid) {
        postRepository.deleteById(pid);
    }
}
