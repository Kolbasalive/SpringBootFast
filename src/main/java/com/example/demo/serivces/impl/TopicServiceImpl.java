package com.example.demo.serivces.impl;

import com.example.demo.dto.GetTopicWithMessagesDto;
import com.example.demo.dto.MessageMapper;
import com.example.demo.dto.TopicMapper;
import com.example.demo.dto.MessageDto;
import com.example.demo.dto.GetTopicsDto;
import com.example.demo.dto.TopicDto;
import com.example.demo.model.Message;
import com.example.demo.model.Topic;
import com.example.demo.repository.MessageRepository;

import com.example.demo.repository.TopicRepository;
import com.example.demo.serivces.TopicService;
import lombok.RequiredArgsConstructor;
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
    private final MessageMapper messageMapper;

    @Override
    public List<GetTopicsDto> getTopics() {
        return topicRepository.findAll().stream()
                .map(topicMapper::toDto)
                .toList();
    }

    @Override
    public GetTopicWithMessagesDto createTopic(TopicDto topicDto) {
        Topic topic = topicMapper.toTopic(topicDto);
        Message message = topicMapper.toMessage(topicDto);
        message.setTopic(topic);
        messageRepository.save(message);
        topic.setCreated(OffsetDateTime.parse(topicDto.getMessage().getCreated()));
        topic.setMessages(List.of(message));
        topicRepository.save(topic);

        return getTopicWithMessages(String.valueOf(topic.getId()));
    }

    @Override
    public GetTopicWithMessagesDto getTopicWithMessages(String topicId) {
        Topic topic = topicRepository.findById(UUID.fromString(topicId)).orElse(null);
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

    @Override
    public GetTopicWithMessagesDto createMessageInTopic(MessageDto messageDto, String topicId) {
        Optional<Topic> optionalTopic = topicRepository.findById(UUID.fromString(topicId));
        if (optionalTopic.isPresent()) {
            Message message = messageMapper.toDtoInMessage(messageDto);
            Topic topic = optionalTopic.get();
            message.setTopic(topic);
            messageRepository.save(message);
            topic.getMessages().add(message);
            topicRepository.save(topic);
        }
        return getTopicWithMessages(topicId);
    }

    @Override
    public ArrayList<GetTopicWithMessagesDto> updateMessageInTopic(MessageDto messageDto, String topicId) {
        Optional<Topic> optionalTopic = topicRepository.findById(UUID.fromString(topicId));
        if (optionalTopic.isPresent()){
            Topic topic = optionalTopic.get();
            Optional<Message> optionalMessage = topic.getMessages().stream()
                    .filter(message -> message.getId().equals(messageDto.getId()))
                    .findFirst();
            if (optionalMessage.isPresent()){
                Message message = optionalMessage.get();
                message.setText(messageDto.getText());
                message.setAuthor(messageDto.getAuthor());
                message.setCreated(OffsetDateTime.parse(messageDto.getCreated()));
                messageRepository.save(message);
            }
        }
        ArrayList<GetTopicWithMessagesDto> arrayList = new ArrayList<>();
        arrayList.add(getTopicWithMessages(topicId));

        return arrayList;
    }

}
