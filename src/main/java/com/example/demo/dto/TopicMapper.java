package com.example.demo.dto;

import com.example.demo.dto.topic.GetTopicsDto;
import com.example.demo.dto.topic.TopicDto;
import com.example.demo.model.Message;
import com.example.demo.model.Topic;

public interface TopicMapper {
    GetTopicsDto toDto(Topic topic);

    Message toMessage(TopicDto topicDto);
    Topic toTopic(TopicDto topicDto);
}
