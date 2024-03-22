package com.example.demo.dto;

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
    private String id;
    private String name;
    private String created;
    private List<MessageDto> messages;
}
