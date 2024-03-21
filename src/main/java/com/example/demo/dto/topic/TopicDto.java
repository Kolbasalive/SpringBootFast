package com.example.demo.dto.topic;

import com.example.demo.dto.message.MessageDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class TopicDto {
    private String topicName;
    private MessageDto message;

}
