package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @Id
    private UUID id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = true)
    private OffsetDateTime created;

}
