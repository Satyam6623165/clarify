package com.example.clarify.service.impl;

import com.example.clarify.model.Vote;
import com.example.clarify.repository.VoteRepository;
import com.example.clarify.service.VoteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class VoteServiceImpl implements VoteService {
    private final VoteRepository voteRepository;

    @Override
    public Vote save(Vote like) {
        return voteRepository.save(like);
    }

    @Override
    public void deleteByPidAndUid(String pid, String uid) {
        Optional<Vote> vote = findByPidAndUid(pid, uid);
        if(vote.isPresent()) {
            voteRepository.deleteById(vote.get().getId());
        }
    }

    @Override
    public Optional<Vote> findByPidAndUid(String pid, String uid) {
        return voteRepository.findByPidAndUid(pid, uid);
    }
}
