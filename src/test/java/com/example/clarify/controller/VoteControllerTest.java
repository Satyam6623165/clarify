package com.example.clarify.controller;

import com.example.clarify.controller.v1.api.VoteController;
import com.example.clarify.controller.v1.request.DownVoteRequest;
import com.example.clarify.model.Post;
import com.example.clarify.model.Vote;
import com.example.clarify.service.PostService;
import com.example.clarify.service.VoteService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RunWith(MockitoJUnitRunner.class)
public class VoteControllerTest {
    @InjectMocks private VoteController voteController;

    @Mock private VoteService voteService;

    @Mock private PostService postService;

    @Test
    public void upVoteSuccessCase() {
        Vote vote = new Vote();
        vote.setId("1");
        vote.setPid("1");
        Mockito.when(voteService.save(vote)).thenReturn(vote);
        Post post = new Post();
        post.setPid("1");
        post.setVoteCount(0L);
        Mockito.when(postService.findByPid("1")).thenReturn(post);
        Mockito.when(postService.save(post)).thenReturn(post);
        ResponseEntity<Vote> response = voteController.upVote(vote);
        Assert.assertEquals(vote, response.getBody());
    }

    @Test
    public void upVoteFailureCase() {
        Vote vote = new Vote();
        vote.setId("1");
        vote.setPid("1");
        Mockito.when(voteService.save(vote)).thenThrow(new RuntimeException());
        ResponseEntity<Vote> response = null;
        try {
            response = voteController.upVote(vote);
        } catch (RuntimeException e) {
            Assert.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        }
    }

    @Test
    public void downVoteSuccessCase() {
        DownVoteRequest downVoteRequest = new DownVoteRequest();
        downVoteRequest.setPid("1");
        downVoteRequest.setUid("1");

        Mockito.doNothing().when(voteService).deleteByPidAndUid("1", "1");

        Post post = new Post();
        post.setPid("1");
        post.setVoteCount(0L);

        Mockito.when(postService.findByPid(downVoteRequest.getPid())).thenReturn(post);
        Mockito.when(postService.save(post)).thenReturn(post);

        ResponseEntity<Void> response = voteController.downVote(downVoteRequest);
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void downVoteFailureCase() {
        DownVoteRequest downVoteRequest = new DownVoteRequest();
        downVoteRequest.setPid("1");
        downVoteRequest.setUid("1");

        Mockito.doThrow(new RuntimeException()).when(voteService).deleteByPidAndUid("1", "1");
        ResponseEntity<Void> response = null;
        try {
            response = voteController.downVote(downVoteRequest);
        } catch (RuntimeException e) {
            Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        }
    }
}
