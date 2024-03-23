package com.example.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
public class GetTopicsDto {
    private UUID id;
    private String name;
    private OffsetDateTime created;
}
