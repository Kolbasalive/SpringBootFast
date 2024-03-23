package com.example.demo.dto;

import com.example.demo.model.Message;
import com.example.demo.model.Topic;

import java.util.ArrayList;

public interface TopicMapper {
    GetTopicsDto toDto(Topic topic);

    Message toMessage(TopicDto topicDto);

    Topic toTopic(TopicDto topicDto);

    GetTopicWithMessagesDto toTopicWithMessage(Topic topic);

    ArrayList<GetTopicWithMessagesDto> toGetTopicsDto(Topic topic);


}
