package com.example.clarify.controller.v1.api;

import com.example.clarify.controller.v1.request.DownVoteRequest;
import com.example.clarify.model.Vote;
import com.example.clarify.model.Post;
import com.example.clarify.service.VoteService;
import com.example.clarify.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/posts/{pid}/likes")
public class VoteController {
    private final VoteService voteService;
    private final PostService postService;

    @PostMapping
    public ResponseEntity<Vote> upVote(@RequestBody Vote vote) {
        log.info("Saving vote : {}", vote);
        try {
            Vote savedLike = voteService.save(vote);
            Post post = postService.findByPid(savedLike.getPid());
            post.setVoteCount(post.getVoteCount() + 1);
            post = postService.save(post);
            return new ResponseEntity<>(savedLike, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping
    public ResponseEntity<Void> downVote(@RequestBody DownVoteRequest downVoteRequest) {
        log.info("Deleting vote : {}", downVoteRequest);
        try {
            voteService.deleteByPidAndUid(downVoteRequest.getPid(), downVoteRequest.getUid());
            Post post = postService.findByPid(downVoteRequest.getPid());
            post.setVoteCount(post.getVoteCount() - 1);
            post = postService.save(post);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
