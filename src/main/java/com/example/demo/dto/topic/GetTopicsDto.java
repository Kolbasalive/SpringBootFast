package com.example.demo.dto.topic;

import com.example.demo.dto.message.MessageDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
public class GetTopicsDto {
    private UUID id;
    private String name;
    private OffsetDateTime created;
}