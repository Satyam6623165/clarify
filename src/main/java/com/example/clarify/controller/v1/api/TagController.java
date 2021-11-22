package com.example.clarify.controller.v1.api;

import com.example.clarify.model.Tag;
import com.example.clarify.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tags")
@RequiredArgsConstructor
public class TagController {
    private final TagService tagService;

    @GetMapping
    public ResponseEntity<List<Tag>> findAllTags() {
        try {
            List<Tag> tags = tagService.findAllTags();
            return new ResponseEntity<>(tags, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Tag> save(@RequestBody Tag tag) {
        try {
            Tag savedTag = tagService.save(tag);
            return new ResponseEntity<>(savedTag, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{pattern}")
    public ResponseEntity<List<Tag>> findByTitleLikeOrderByTitleAsc(@PathVariable String pattern) {
        try {
            List<Tag> tags = tagService.findByTitleLikeOrderByTitleAsc(pattern);
            return new ResponseEntity<>(tags, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestBody Tag tag) {
        try {
            tagService.delete(tag);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
