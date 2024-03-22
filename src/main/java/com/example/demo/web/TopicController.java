package com.example.demo.web;

import com.example.demo.dto.GetTopicWithMessagesDto;
import com.example.demo.dto.MessageDto;
import com.example.demo.dto.GetTopicsDto;
import com.example.demo.dto.TopicDto;
import com.example.demo.serivces.TopicService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping("/topic")
@RequiredArgsConstructor
public class TopicController {
    private final TopicService topicService;

    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "422", description = "Validation exception",
                    content = @Content(schema = @Schema(implementation = Error.class)))
    })
    public ResponseEntity<GetTopicWithMessagesDto> createTopic(@RequestBody TopicDto topicDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(topicService.createTopic(topicDto));

    }

    @PutMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
            @ApiResponse(responseCode = "404", description = "Topic not found"),
            @ApiResponse(responseCode = "422", description = "Validation exception",
                    content = @Content(schema = @Schema(implementation = Error.class)))
    })
    public ResponseEntity<ArrayList<GetTopicWithMessagesDto>> updateTopic(@RequestBody GetTopicsDto getTopicsDto) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(topicService.updateTopic(getTopicsDto));
        } catch (NullPointerException e) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(new ArrayList<>());
        }

    }

    @GetMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation")
    })
    Iterable<GetTopicsDto> getTopics() {
        return topicService.getTopics();
    }

    @GetMapping("/{topicId}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "400", description = "Invalid topic ID")
    })
    public ResponseEntity<GetTopicWithMessagesDto> getTopicWithMessages(@PathVariable String topicId) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(topicService.getTopicWithMessages(topicId));
    }

    @PostMapping("/{topiId}/message")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "422", description = "Validation exception",
                    content = @Content(schema = @Schema(implementation = Error.class)))
    })
    public ResponseEntity<GetTopicWithMessagesDto> createMessageInTopic(
            @RequestBody MessageDto messageDto,
            @PathVariable String topiId) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(topicService.createMessageInTopic(messageDto, topiId));
    }

    @PutMapping("/{topiId}/message")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
            @ApiResponse(responseCode = "404", description = "Topic not found"),
            @ApiResponse(responseCode = "422", description = "Validation exception",
                    content = @Content(schema = @Schema(implementation = Error.class)))
    })
    public ResponseEntity<ArrayList<GetTopicWithMessagesDto>> updateMessageInTopic(
            @RequestBody MessageDto messageDto,
            @PathVariable String topiId) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(topicService.updateMessageInTopic(messageDto, topiId));
    }

}
