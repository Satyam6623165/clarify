package com.example.clarify.controller.v1.api;

import com.example.clarify.model.Channel;
import com.example.clarify.service.ChannelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/v1/channels")
@RequiredArgsConstructor
public class ChannelController {
    private final ChannelService channelService;

    @GetMapping
    public ResponseEntity<List<Channel>> getAll() {
        log.info("Fetching all channels");
        try {
            List<Channel> channels = channelService.findAll();
            return new ResponseEntity<>(channels, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Channel> save(@RequestBody Channel channel) {
        log.info("Saving channel : {}", channel);
        try {
            Channel savedChannel = channelService.save(channel);
            return new ResponseEntity<>(savedChannel, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{cid}")
    public ResponseEntity<Void> deleteById(@PathVariable String cid) {
        log.info("Deleting channel with id : {}", cid);
        try {
            channelService.deleteById(cid);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{title}")
    public ResponseEntity<Channel> findByTitle(@PathVariable String title) {
        log.info("Fetching channel with title : {}", title);
        Optional<Channel> channel = channelService.findByTitle(title);
        if(channel.isPresent()) {
            return new ResponseEntity<>(channel.get(), HttpStatus.OK);
        }
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{cid}")
    public ResponseEntity<Channel> findByCid(@PathVariable String cid) {
        log.info("Fetching channel with id : {}", cid);
        Optional<Channel> channel = channelService.findByCid(cid);
        if(channel.isPresent()) {
            return new ResponseEntity<>(channel.get(), HttpStatus.OK);
        }
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
