package com.example.demo.serivces.impl;

import com.example.demo.model.Message;
import com.example.demo.repository.MessageRepository;
import com.example.demo.serivces.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;

    @Override
    public Boolean deleteMessage(String messageId) {
        Optional<Message> optionalMessage = messageRepository.findById(UUID.fromString(messageId));
        if (optionalMessage.isPresent()){
            Message message = optionalMessage.get();
            messageRepository.delete(message);

            return true;
        }else{
            return false;
        }
    }

}
