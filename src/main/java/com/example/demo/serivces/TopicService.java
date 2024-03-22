package com.example.demo.serivces;

import com.example.demo.dto.GetTopicWithMessagesDto;
import com.example.demo.dto.message.MessageDto;
import com.example.demo.dto.topic.GetTopicsDto;
import com.example.demo.dto.topic.TopicDto;
import com.example.demo.model.Topic;

import java.util.ArrayList;
import java.util.List;

public interface TopicService {
    List<GetTopicsDto> getTopics();

    Topic createTopic(TopicDto topicDto);

    ArrayList<GetTopicWithMessagesDto> updateTopic(GetTopicsDto getTopicsDto);

    GetTopicWithMessagesDto getTopicWithMessages(String id);

    GetTopicWithMessagesDto createMessageInTopic(MessageDto messageDto, String topicId);
}
