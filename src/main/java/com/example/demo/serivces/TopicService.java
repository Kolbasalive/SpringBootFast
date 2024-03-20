package com.example.demo.serivces;

import com.example.demo.dto.topic.GetTopicsDto;
import com.example.demo.dto.topic.TopicDto;
import com.example.demo.model.Topic;

import java.util.List;

public interface TopicService {
    List<GetTopicsDto> getTopics();

    Topic saveTopic(TopicDto topicDto);
}
