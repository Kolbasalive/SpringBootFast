package com.example.demo.serivces.impl;

import com.example.demo.model.Message;
<<<<<<< HEAD
import com.example.demo.repository.MessageRepository;
=======
import com.example.demo.model.Topic;
import com.example.demo.repository.MessageRepository;
import com.example.demo.repository.TopicRepository;
>>>>>>> origin/master
import com.example.demo.serivces.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
=======
import java.util.List;
>>>>>>> origin/master
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;

    @Override
    public boolean deleteMessage(String messageId) {
<<<<<<< HEAD
=======
        //messageRepository.deleteById(UUID.fromString(messageId));
>>>>>>> origin/master
        Optional<Message> optionalMessage = messageRepository.findById(UUID.fromString(messageId));
        if (optionalMessage.isPresent()){
            Message message = optionalMessage.get();
            messageRepository.delete(message);
<<<<<<< HEAD

=======
>>>>>>> origin/master
            return true;
        }else{
            return false;
        }
    }
<<<<<<< HEAD

=======
>>>>>>> origin/master
}
