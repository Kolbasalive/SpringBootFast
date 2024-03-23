package com.example.demo.dto;

import com.example.demo.model.Message;


public interface MessageMapper {

    MessageDto toMessageDto(Message message);

    Message toDtoInMessage(MessageDto messageDto);

}
