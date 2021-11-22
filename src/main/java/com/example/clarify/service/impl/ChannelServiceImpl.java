package com.example.clarify.service.impl;

import com.example.clarify.model.Channel;
import com.example.clarify.repository.ChannelRepository;
import com.example.clarify.service.ChannelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChannelServiceImpl implements ChannelService {
    private final ChannelRepository channelRepository;

    @Override
    public Channel save(Channel channel) {
        return channelRepository.save(channel);
    }

    @Override
    public void deleteById(String cid) {
        channelRepository.deleteById(cid);
    }

    @Override
    public Optional<Channel> findByTitle(String title) {
        return channelRepository.findByTitle(title);
    }

    @Override
    public Optional<Channel> findByCid(String cid) {
        return channelRepository.findByCid(cid);
    }

    @Override
    public List<Channel> findAllChannels() {
        return channelRepository.findAll();
    }
}
