package com.example.demo.web;

import com.example.demo.dto.topic.TopicDto;
import com.example.demo.model.Topic;
import com.example.demo.repository.TopicRepository;
import com.example.demo.serivces.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/topic")
@RequiredArgsConstructor
public class TopicController {
    private final TopicService topicService;

    private final TopicRepository topicRepository;

/*    @GetMapping
    Iterable<GetTopicsDto> getTopics(){
        return topicService.getTopics();
    }*/

    @GetMapping
    Iterable<Topic> getTopic(){
        return topicRepository.findAll();
    }

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


    @PostMapping
    public ResponseEntity<String> createTopic(@RequestBody TopicDto topicDto){
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(topicService.createTopic(topicDto)
                            .getId().toString());
    }
}
