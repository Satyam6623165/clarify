package com.example.clarify.service.impl;

import com.example.clarify.model.Tag;
import com.example.clarify.repository.TagRepository;
import com.example.clarify.service.TagService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {
    private final TagRepository tagRepository;

    @Override
    public Tag save(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    public void deleteById(String tid) {
        tagRepository.deleteById(tid);
    }

    @Override
    public List<Tag> findByTitleLikeOrderByTitleAsc(String pattern) {
        return tagRepository.findByTitleLikeOrderByTitleAsc(pattern);
    }

    @Override
    public List<Tag> findAllTags() {
        return tagRepository.findAll();
    }
}
