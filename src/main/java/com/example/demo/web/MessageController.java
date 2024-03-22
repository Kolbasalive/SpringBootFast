package com.example.demo.web;

import com.example.demo.serivces.MessageService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @DeleteMapping("/{messageId}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Successful operation"),
    })
    public ResponseEntity<String> deleteMessage(@PathVariable String messageId){
        if (messageService.deleteMessage(messageId)){
            return ResponseEntity.status(HttpStatus.OK).body("Successful operation");
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid ID supplied");
        }
    }

}
