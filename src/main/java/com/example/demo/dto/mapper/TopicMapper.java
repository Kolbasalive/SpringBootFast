package com.example.demo.dto.mapper;

import com.example.demo.dto.GetTopicWithMessagesDto;
import com.example.demo.dto.GetTopicsDto;
import com.example.demo.dto.TopicDto;
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
