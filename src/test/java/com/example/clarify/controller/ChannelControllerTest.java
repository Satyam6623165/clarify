package com.example.clarify.controller;

import com.example.clarify.controller.v1.api.ChannelController;
import com.example.clarify.model.Channel;
import com.example.clarify.service.ChannelService;
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
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class ChannelControllerTest {
    @InjectMocks
    private ChannelController channelController;

    @Mock private ChannelService channelService;

    @Test
    public void getAllTestSuccessCase() {
        Channel channel = new Channel();
        channel.setCid("1");
        channel.setTitle("Test");
        List<Channel> channelList = new ArrayList<>();
        channelList.add(channel);

        Mockito.when(channelService.findAll()).thenReturn(channelList);

        ResponseEntity<List<Channel>> response = channelController.getAll();
        Assert.assertEquals(channelList, response.getBody());
    }

    @Test
    public void getAllTestFailureCase() {
        Mockito.when(channelService.findAll()).thenThrow(new RuntimeException());
        ResponseEntity<List<Channel>> response = null;
        try {
            response = channelController.getAll();
        } catch (RuntimeException e) {
            Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        }
    }

    @Test
    public void saveSuccessCase() {
        Channel channel = new Channel();
        channel.setCid("1");
        channel.setTitle("Test");
        Mockito.when(channelService.save(channel)).thenReturn(channel);

        ResponseEntity<Channel> response = channelController.save(channel);
        Assert.assertEquals(channel, response.getBody());
    }

    @Test
    public void saveFailureCase() {
        Channel channel = new Channel();
        channel.setCid("1");
        channel.setTitle("Test");
        Mockito.when(channelService.save(channel)).thenThrow(new RuntimeException());
        ResponseEntity<Channel> response = null;
        try {
            response = channelController.save(channel);
        } catch (RuntimeException e) {
            Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        }
    }

    @Test
    public void deleteByIdSuccessCase() {
        Mockito.doNothing().when(channelService).deleteById("1");
        ResponseEntity<Void> response = channelController.deleteById("1");
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void deleteByIdFailureCase() {
        Mockito.doThrow(new RuntimeException()).when(channelService).deleteById("1");
        ResponseEntity<Void> response = null;
        try {
            response = channelController.deleteById("1");
        } catch (RuntimeException e) {
            Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        }
    }

    @Test
    public void findByTitleSuccessCase() {
        Channel channel = new Channel();
        channel.setCid("1");
        channel.setTitle("Test");
        Optional<Channel> channelData = Optional.of(channel);
        Mockito.when(channelService.findByTitle("Test")).thenReturn(channelData);
        ResponseEntity<Channel> response = channelController.findByTitle("Test");
        Assert.assertEquals(channel, response.getBody());
    }

    @Test
    public void findByTitleFailureCase() {
        Channel channel = new Channel();
        channel.setCid("1");
        channel.setTitle("Test");
        Optional<Channel> channelData = Optional.empty();
        Mockito.when(channelService.findByTitle("Test")).thenReturn(channelData);
        ResponseEntity<Channel> response = channelController.findByTitle("Test");
        Assert.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void findByCidSuccessCase() {
        Channel channel = new Channel();
        channel.setCid("1");
        channel.setTitle("Test");
        Optional<Channel> channelData = Optional.of(channel);
        Mockito.when(channelService.findByCid("1")).thenReturn(channelData);
        ResponseEntity<Channel> response = channelController.findByCid("1");
        Assert.assertEquals(channel, response.getBody());
    }

    @Test
    public void findByCidFailureCase() {
        Channel channel = new Channel();
        channel.setCid("1");
        channel.setTitle("Test");
        Optional<Channel> channelData = Optional.empty();
        Mockito.when(channelService.findByCid("1")).thenReturn(channelData);
        ResponseEntity<Channel> response = channelController.findByCid("1");
        Assert.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
