package com.example.demo.serivces.impl;

import com.example.demo.dto.TopicMapper;
import com.example.demo.dto.topic.GetTopicsDto;
import com.example.demo.dto.topic.TopicDto;
import com.example.demo.model.Message;
import com.example.demo.model.Topic;
import com.example.demo.repository.TopicRepository;
import com.example.demo.serivces.TopicService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TopicServiceImpl implements TopicService {
    private final TopicRepository topicRepository;
    private final TopicMapper topicMapper;
    private final ModelMapper mapper;

    @Override
    public List<GetTopicsDto> getTopics() {
        return topicRepository.findAll().stream()
                .map(topicMapper::toDto)
                .toList();
    }

    @Override
    public Topic saveTopic(TopicDto topicDto) {
        System.out.println(topicDto);
        var c = topicMapper.toModel(topicDto);
        c.setMessages(List.of(mapper.map(topicDto.getMessage(), Message.class)));
        System.out.println(c);
        return topicRepository.save(c);
    }
}
