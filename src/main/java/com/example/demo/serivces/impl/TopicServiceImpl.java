package com.example.demo.serivces.impl;

import com.example.demo.dto.GetTopicWithMessagesDto;
import com.example.demo.dto.TopicMapper;
import com.example.demo.dto.topic.GetTopicsDto;
import com.example.demo.dto.topic.TopicDto;
import com.example.demo.model.Topic;
import com.example.demo.repository.MessageRepository;
import com.example.demo.repository.TopicRepository;
import com.example.demo.serivces.TopicService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TopicServiceImpl implements TopicService {
    private final TopicRepository topicRepository;
    private final MessageRepository messageRepository;
    private final TopicMapper topicMapper;

    @Override
    public List<GetTopicsDto> getTopics() {
        return topicRepository.findAll().stream()
                .map(topicMapper::toDto)
                .toList();
    }

    @Override
    public Topic createTopic(TopicDto topicDto) {
        var t = topicMapper.toTopic(topicDto);
        var m = topicMapper.toMessage(topicDto);
        m.setTopic(t);
        messageRepository.save(m);

        t.setCreated(OffsetDateTime.parse(topicDto.getMessage().getCreated()));
        t.setMessages(List.of(m));
        topicRepository.save(t);

        return topicRepository.save(t);
    }

    @Override
    public GetTopicWithMessagesDto getTopicWithMessages(String id) {
        Topic topic = topicRepository.findById(UUID.fromString(id)).orElse(null);
        return topicMapper.toTopicWithMessage(topic);
    }

    @Override
    public ArrayList<GetTopicWithMessagesDto> updateTopic(GetTopicsDto getTopicsDto) {
        Topic topic = new Topic();
        if (topicRepository.existsById(getTopicsDto.getId())){
            topic = topicRepository.findById(UUID.fromString(String.valueOf(getTopicsDto.getId()))).orElse(null);
            assert topic != null;
            topic.setTopicName(getTopicsDto.getName());
            topic.setCreated(getTopicsDto.getCreated());
            topicRepository.save(topic);
            return topicMapper.toGetTopicsDto(topic);
        }else {
            return topicMapper.toGetTopicsDto(topic);
        }
    }

/*    @Override
    public Topic saveTopic(TopicDto topicDto) {
        System.out.println(topicDto);

        System.out.println("topicDto.getMessage() " + topicDto.getMessage());
        System.out.println("topicDto.getMessage().getCreated() " + topicDto.getMessage().getCreated());
*//*        Topic topic = new Topic(topicDto.getTopicName(),
                List.of(new Message()));
        topic.setCreationDate(topicDto.getMessage().getCreated());*//*

        var m = mapper.map(topicDto.getMessage(), Message.class);
        m.setCreated(OffsetDateTime.parse(topicDto.getMessage().getCreated()));
        m.setId(topicDto.getMessage().getId());
        System.out.println("Id m: " + topicDto.getMessage().getId());
        System.out.println("m " + m.getCreated()
        +" " + m.getText() + " " + m.getAuthor() + " " + m.getId());

        var t = topicMapper.toTopicWithMessage(topicDto);
        m.setTopic(t);
        messageRepository.save(m);

        t.setMessages(List.of(m));
        t.setCreated(OffsetDateTime.parse(topicDto.getMessage().getCreated()));
        System.out.println("C: " + t.getMessages().getFirst().getId());
        System.out.println("M: " + m.getId());
        return topicRepository.save(t);
    }*/
}
