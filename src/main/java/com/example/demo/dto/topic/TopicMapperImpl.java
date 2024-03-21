package com.example.demo.dto.topic;

import com.example.demo.dto.GetTopicWithMessagesDto;
import com.example.demo.dto.MessageMapper;
import com.example.demo.dto.TopicMapper;
import com.example.demo.dto.message.MessageDto;
import com.example.demo.model.Message;
import com.example.demo.model.Topic;
import lombok.RequiredArgsConstructor;
import org.hibernate.mapping.List;
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
        Message m = new Message();
        m.setText(topicDto.getMessage().getText());
        m.setAuthor(topicDto.getMessage().getAuthor());
        m.setCreated(OffsetDateTime.parse(topicDto.getMessage().getCreated()));
        m.setId(topicDto.getMessage().getId());
        return m;
    }

    @Override
    public Topic toTopic(TopicDto topicDto) {
        Topic t = new Topic();
        t.setTopicName(topicDto.getTopicName());
        return t;
    }

    /*@Override
    public Topic toTopic(TopicDto topicDto) {
        Topic t = new Topic();
        t.setTopicName(topicDto.getTopicName());
        return t;
    }*/

    @Override
    public GetTopicWithMessagesDto toTopicWithMessage(Topic topic) {
        GetTopicWithMessagesDto topicWithMessagesDto = new GetTopicWithMessagesDto();
        //GetTopicsDto getTopicDto = toDto(topic);
        //topicWithMessagesDto.setTopicDto(getTopicDto);

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
    public ArrayList<GetTopicWithMessagesDto> toGetTopicsDto(Topic topic) {
        ArrayList<GetTopicWithMessagesDto> arrayList = new ArrayList<>();
        arrayList.add(toTopicWithMessage(topic));
        return arrayList;
    }

}
