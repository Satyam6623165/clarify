package com.example.clarify.controller;

import com.example.clarify.controller.v1.api.PostController;
import com.example.clarify.enums.Type;
import com.example.clarify.model.Post;
import com.example.clarify.service.PostService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class PostControllerTest {
    @InjectMocks
    private PostController postController;

    @Mock private PostService postService;

    @Test
    public void findByCidSuccessCase() {
        Post post = new Post();
        post.setCid("1");
        List<Post> postList = new ArrayList<>();
        Mockito.when(postService.findByCid("1")).thenReturn(postList);
        ResponseEntity<List<Post>> response = postController.findByCid("1");
        Assert.assertEquals(postList, response.getBody());
    }

    @Test
    public void findByCidFailureCase() {
        Post post = new Post();
        post.setCid("1");
        List<Post> postList = new ArrayList<>();
        Mockito.when(postService.findByCid("1")).thenThrow(new RuntimeException());
        ResponseEntity<List<Post>> response = null;
        try {
            response = postController.findByCid("1");
        } catch (RuntimeException e) {
            Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        }
    }

    @Test
    public void saveSuccessCase() {
        Post post = new Post();
        post.setCid("1");
        post.setPostType(Type.Reply);
        post.setReplyTo("Test Question");
        Mockito.when(postService.save(post)).thenReturn(post);
        Mockito.when(postService.findByPid("Test Question")).thenReturn(post);
        ResponseEntity<Post> response = postController.save(post);
        Assert.assertEquals(post, response.getBody());
    }

    @Test
    public void saveFailureCase() {
        Post post = new Post();
        post.setCid("1");
        post.setPostType(Type.Reply);
        Mockito.when(postService.save(post)).thenThrow(new RuntimeException());
        ResponseEntity<Post> response = null;
        try {
            response = postController.save(post);
        } catch (RuntimeException e) {
            Assert.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        }
    }

    @Test
    public void deleteByIdSuccessCase() {
        Mockito.doNothing().when(postService).deleteById("1");
        ResponseEntity<Void> response = postController.deleteById("1");
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void deleteByIdFailureCase() {
        Mockito.doThrow(new RuntimeException()).when(postService).deleteById("1");
        ResponseEntity<Void> response = null;
        try {
            response = postController.deleteById("1");
        } catch (RuntimeException e) {
            Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        }
    }
}
