package com.example.demo.web;

import com.example.demo.dto.GetTopicWithMessagesDto;
import com.example.demo.dto.message.MessageDto;
import com.example.demo.dto.topic.GetTopicsDto;
import com.example.demo.dto.topic.TopicDto;
import com.example.demo.model.Topic;
import com.example.demo.repository.TopicRepository;
import com.example.demo.serivces.TopicService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping("/topic")
@RequiredArgsConstructor
public class TopicController {
    private final TopicService topicService;

    private final TopicRepository topicRepository;

    @GetMapping
    Iterable<GetTopicsDto> getTopics(){
        return topicService.getTopics();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetTopicWithMessagesDto> getTopicWithMessages(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(topicService.getTopicWithMessages(id));
    }

    @PostMapping
    public ResponseEntity<String> createTopic(@RequestBody TopicDto topicDto){
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(topicService.createTopic(topicDto)
                            .getId().toString());
        } catch (ValidationException e) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Validation exception: " + e.getMessage());
        } /*catch (InvalidInputException e) {
            return ResponseEntity.badRequest().body("Invalid input: " + e.getMessage());
        }*/

    }

    @PutMapping
    public ResponseEntity<ArrayList<GetTopicWithMessagesDto>> updateTopic(@RequestBody GetTopicsDto getTopicsDto){
        return ResponseEntity.status(HttpStatus.OK)
                .body(topicService.updateTopic(getTopicsDto));
    }


/*    @PostMapping("/{id}/message")
    public ResponseEntity<GetTopicWithMessagesDto> createMessageInTopic(
            @RequestBody MessageDto messageDto,
            @PathVariable String id
            ){

    }*/




    /*    @GetMapping
    Iterable<Topic> getTopic(){
        return topicRepository.findAll();
    }*/

//   @PostMapping
//    public ResponseEntity<String> createTopic() {
//        try {
//            Message message = new Message("Theme 1", "KoK0");
//            Topic topic = new Topic("title 1", List.of(message));
//            topicRepository.save(topic);
//            return ResponseEntity.status(HttpStatus.CREATED).body("Topic created successfully");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create topic");
//        }
//    }
}
