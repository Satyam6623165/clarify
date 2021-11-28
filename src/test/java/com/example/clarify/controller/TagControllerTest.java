package com.example.clarify.controller;

import com.example.clarify.controller.v1.api.TagController;
import com.example.clarify.model.Tag;
import com.example.clarify.service.TagService;
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
public class TagControllerTest {
    @InjectMocks private TagController tagController;

    @Mock private TagService tagService;

    @Test
    public void getAllSuccessCase() {
        Tag tag = new Tag();
        tag.setTid("1");
        tag.setTitle("Maths");
        List<Tag> tagList = new ArrayList<>();
        tagList.add(tag);

        Mockito.when(tagService.findAll()).thenReturn(tagList);

        ResponseEntity<List<Tag>> response = tagController.getAll();
        Assert.assertEquals(tagList, response.getBody());
    }

    @Test
    public void getAllFailureCase() {
        Tag tag = new Tag();
        tag.setTid("1");
        tag.setTitle("Maths");
        List<Tag> tagList = new ArrayList<>();
        tagList.add(tag);

        Mockito.when(tagService.findAll()).thenThrow(new RuntimeException());
        ResponseEntity<List<Tag>> response = null;
        try {
            response = tagController.getAll();
        } catch (RuntimeException e) {
            Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        }
    }

    @Test
    public void saveSuccessCase() {
        Tag tag = new Tag();
        tag.setTid("1");
        tag.setTitle("Maths");

        Mockito.when(tagService.save(tag)).thenReturn(tag);
        ResponseEntity<Tag> response = tagController.save(tag);
        Assert.assertEquals(tag, response.getBody());
    }

    @Test
    public void saveFailureCase() {
        Tag tag = new Tag();
        tag.setTid("1");
        tag.setTitle("Maths");

        Mockito.when(tagService.save(tag)).thenThrow(new RuntimeException());
        ResponseEntity<Tag> response = null;
        try {
            response = tagController.save(tag);
        } catch (RuntimeException e) {
            Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        }
    }

    @Test
    public void findByTitleLikeOrderByTitleAscSuccessCase() {
        Tag tag = new Tag();
        tag.setTid("1");
        tag.setTitle("Maths");
        List<Tag> tagList = new ArrayList<>();
        tagList.add(tag);

        Mockito.when(tagService.findByTitleLikeOrderByTitleAsc("Maths")).thenReturn(tagList);
        ResponseEntity<List<Tag>> response = tagController.findByTitleLikeOrderByTitleAsc("Maths");
        Assert.assertEquals(tagList, response.getBody());
    }

    @Test
    public void findByTitleLikeOrderByTitleAscFailureCase() {
        Mockito.when(tagService.findByTitleLikeOrderByTitleAsc("Maths")).thenThrow(new RuntimeException());
        ResponseEntity<List<Tag>> response = null;
        try {
            response = tagController.findByTitleLikeOrderByTitleAsc("Maths");
        } catch (RuntimeException e) {
            Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        }
    }

    @Test
    public void deleteByIdSuccessCase() {
        Mockito.doNothing().when(tagService).deleteById("1");
        ResponseEntity<Void> response = tagController.deleteById("1");
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void deleteByIdFailureCase() {
        Mockito.doThrow(new RuntimeException()).when(tagService).deleteById("1");
        ResponseEntity<Void> response = null;
        try {
            response = tagController.deleteById("1");
        } catch (RuntimeException e) {
            Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        }
    }
}
