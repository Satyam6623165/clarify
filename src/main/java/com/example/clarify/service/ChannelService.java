package com.example.clarify.service;

import com.example.clarify.model.Channel;

import java.util.List;
import java.util.Optional;

public interface ChannelService {
    Channel save(Channel channel);
    void deleteById(String cid);
    Optional<Channel> findByTitle(String title);
    Optional<Channel> findByCid(String cid);
    List<Channel> findAllChannels();
}
