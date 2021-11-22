package com.example.clarify.service.impl;

import com.example.clarify.model.Like;
import com.example.clarify.repository.LikeRepository;
import com.example.clarify.service.LikeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class LikeServiceImpl implements LikeService {
    private final LikeRepository likesRepository;

    @Override
    public Like save(Like like) {
        return likesRepository.insert(like);
    }

    @Override
    public List<Like> findByPid(String pid) {
        return likesRepository.findByPid(pid);
    }

    @Override
    public void deleteById(String id) {
        likesRepository.deleteById(id);
    }

    @Override
    public Optional<Like> findByPidAndUid(String pid, String uid) {
        return likesRepository.findByPidAndUid(pid, uid);
    }
}
