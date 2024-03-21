package com.example.demo.dto.topic;

import com.example.demo.dto.TopicMapper;
import com.example.demo.dto.message.MessageDto;
import com.example.demo.model.Message;
import com.example.demo.model.Topic;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class TopicMapperImpl implements TopicMapper {
    private final ModelMapper mapper;

    @Override
    public GetTopicsDto toDto(Topic topic) {
        GetTopicsDto getTopicsDto = new GetTopicsDto();
        getTopicsDto.setId(topic.getId());
        getTopicsDto.setName(topic.getTopicName());
        getTopicsDto.setCreated(topic.getCreated());
        return getTopicsDto;
        //return mapper.map(topic, GetTopicsDto.class);
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
        //t.setCreated(OffsetDateTime.parse(topicDto.getMessage().getCreated()));
        //m.setTopic(t);
        //t.setMessages(List.of(m));
        return t;
    }

}
