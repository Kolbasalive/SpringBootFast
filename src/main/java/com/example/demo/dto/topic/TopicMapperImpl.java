package com.example.demo.dto.topic;

import com.example.demo.dto.TopicMapper;
import com.example.demo.model.Topic;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TopicMapperImpl implements TopicMapper {
    private final ModelMapper mapper;

    @Override
    public GetTopicsDto toDto(Topic topic) {
        return mapper.map(topic, GetTopicsDto.class);
    }

    @Override
    public Topic toModel(TopicDto topicDto) {
        return mapper.map(topicDto, Topic.class);
    }
}
