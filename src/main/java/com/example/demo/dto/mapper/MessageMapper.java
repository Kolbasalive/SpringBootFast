package com.example.demo.dto.mapper;

import com.example.demo.dto.MessageDto;
import com.example.demo.model.Message;

public interface MessageMapper {

    MessageDto toMessageDto(Message message);

    Message toDtoInMessage(MessageDto messageDto);

}
