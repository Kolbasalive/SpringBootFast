package com.example.demo.dto.mapper;

import com.example.demo.dto.*;
import com.example.demo.model.Message;
import com.example.demo.model.Topic;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class TopicMapperImpl implements TopicMapper, MessageMapper {

    @Override
    public GetTopicsDto toDto(Topic topic) {
        GetTopicsDto getTopicsDto = new GetTopicsDto();
        getTopicsDto.setId(topic.getId());
        getTopicsDto.setName(topic.getTopicName());
        getTopicsDto.setCreated(topic.getCreated());

        return getTopicsDto;
    }

    @Override
    public Message toMessage(TopicDto topicDto) {
        Message message = new Message();
        message.setText(topicDto.getMessage().getText());
        message.setAuthor(topicDto.getMessage().getAuthor());
        message.setCreated(OffsetDateTime.parse(topicDto.getMessage().getCreated()));
        message.setId(topicDto.getMessage().getId());

        return message;
    }

    @Override
    public Topic toTopic(TopicDto topicDto) {
        Topic topic = new Topic();
        topic.setTopicName(topicDto.getTopicName());

        return topic;
    }

    @Override
    public GetTopicWithMessagesDto toTopicWithMessage(Topic topic) {
        GetTopicWithMessagesDto topicWithMessagesDto = new GetTopicWithMessagesDto();
        topicWithMessagesDto.setName(topic.getTopicName());
        topicWithMessagesDto.setId(String.valueOf(topic.getId()));
        topicWithMessagesDto.setCreated(String.valueOf(topic.getCreated()));
        topicWithMessagesDto.setMessages(
               topic.getMessages().stream()
                .map(this::toMessageDto)
                .toList());

        return topicWithMessagesDto;
    }

    @Override
    public MessageDto toMessageDto(Message message) {
        MessageDto messageDto = new MessageDto();
        messageDto.setText(message.getText());
        messageDto.setAuthor(message.getAuthor());
        messageDto.setId(message.getId());
        messageDto.setCreated(String.valueOf(message.getCreated()));

        return messageDto;
    }

    @Override
    public Message toDtoInMessage(MessageDto messageDto) {
        Message message = new Message();
        message.setText(messageDto.getText());
        message.setAuthor(messageDto.getAuthor());
        message.setId(messageDto.getId());
        message.setCreated(OffsetDateTime.parse(messageDto.getCreated()));

        return message;
    }

    @Override
    public ArrayList<GetTopicWithMessagesDto> toGetTopicsDto(Topic topic) {
        ArrayList<GetTopicWithMessagesDto> arrayList = new ArrayList<>();
        arrayList.add(toTopicWithMessage(topic));

        return arrayList;
    }

}
