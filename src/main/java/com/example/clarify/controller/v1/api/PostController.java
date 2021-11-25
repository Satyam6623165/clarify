package com.example.clarify.controller.v1.api;

import com.example.clarify.enums.Type;
import com.example.clarify.model.Post;
import com.example.clarify.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/channels/{cid}/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping
    public ResponseEntity<List<Post>> findByCid(@PathVariable String cid) {
        try {
            List<Post> posts = postService.findByCid(cid);
            return new ResponseEntity<>(posts, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Post> save(@RequestBody Post post) {
        try {
            Post savedPost = postService.save(post);
            if(savedPost.getPostType() == Type.Reply) {
                Post question = postService.findByPid(savedPost.getReplyTo());
                question.setReplyCount(question.getReplyCount() + 1);
            }
            return new ResponseEntity<>(savedPost, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{pid}")
    public ResponseEntity<Void> deleteById(@PathVariable String pid) {
        try {
            postService.deleteById(pid);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
