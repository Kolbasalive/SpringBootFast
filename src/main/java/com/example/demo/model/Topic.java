package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Table(name = "TOPIC")
@Getter
@Setter
@Entity
@AllArgsConstructor
@ToString
public class Topic extends BaseEntity {
    private String topicName;

    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE}, fetch = FetchType.LAZY, mappedBy = "topic")
    private List<Message> messages;

    public Topic() {
        super.setId(UUID.randomUUID());
    }

}
