package com.example.demo.dto;

import com.example.demo.dto.message.MessageDto;
import com.example.demo.dto.topic.GetTopicsDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class GetTopicWithMessagesDto {
    //private GetTopicsDto topicDto;
    private String id;
    private String name;
    private String created;
    private List<MessageDto> messages;
}
