package com.example.demo.web;

import com.example.demo.dto.GetTopicWithMessagesDto;
import com.example.demo.dto.message.MessageDto;
import com.example.demo.dto.topic.GetTopicsDto;
import com.example.demo.dto.topic.TopicDto;
import com.example.demo.repository.TopicRepository;
import com.example.demo.serivces.TopicService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @GetMapping("/{topicId}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description ="Invalid topic ID")
    })
    public ResponseEntity<GetTopicWithMessagesDto> getTopicWithMessages(@PathVariable String topicId) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(topicService.getTopicWithMessages(topicId));
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
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
            @ApiResponse(responseCode = "422", description = "Validation exception")
    })
    public ResponseEntity<ArrayList<GetTopicWithMessagesDto>> updateTopic(@RequestBody GetTopicsDto getTopicsDto){
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(topicService.updateTopic(getTopicsDto));
        }catch(NullPointerException e){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(new ArrayList<>());
        }

    }


    @PostMapping("/{topiId}/message")
    public ResponseEntity<GetTopicWithMessagesDto> createMessageInTopic(
            @RequestBody MessageDto messageDto,
            @PathVariable String topiId){
        return ResponseEntity.status(HttpStatus.OK)
                .body(topicService.createMessageInTopic(messageDto, topiId));

    }


    @PutMapping("/{topiId}/message")
    public ResponseEntity<ArrayList<GetTopicWithMessagesDto>> updateMessageInTopic(
            @RequestBody MessageDto messageDto,
            @PathVariable String topiId){
        return ResponseEntity.status(HttpStatus.OK)
                .body(topicService.updateMessageInTopic(messageDto, topiId));
    }


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
