package com.example.demo.dto.topic;

import com.example.demo.dto.message.MessageDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class GetTopicsDto {
    private String topicName;
    private List<MessageDto> messages;
}