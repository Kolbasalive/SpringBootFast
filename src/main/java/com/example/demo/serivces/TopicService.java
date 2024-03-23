package com.example.demo.serivces;

import com.example.demo.dto.GetTopicWithMessagesDto;
import com.example.demo.dto.MessageDto;
import com.example.demo.dto.GetTopicsDto;
import com.example.demo.dto.TopicDto;

import java.util.ArrayList;
import java.util.List;

public interface TopicService {
    List<GetTopicsDto> getTopics();

    GetTopicWithMessagesDto createTopic(TopicDto topicDto);

    ArrayList<GetTopicWithMessagesDto> updateTopic(GetTopicsDto getTopicsDto);

    GetTopicWithMessagesDto getTopicWithMessages(String id);

    GetTopicWithMessagesDto createMessageInTopic(MessageDto messageDto, String topicId);

    ArrayList<GetTopicWithMessagesDto> updateMessageInTopic(MessageDto messageDto, String topicId);

}
