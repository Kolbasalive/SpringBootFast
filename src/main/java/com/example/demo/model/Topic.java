package com.example.demo.model;

import com.example.demo.model.BaseEntity;
import com.example.demo.model.Message;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Table(name = "TOPIC")
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Topic extends BaseEntity {

    private String topicName;

    @OneToMany(mappedBy = "topic", cascade = CascadeType.MERGE)
    private List<Message> messages;

    public Topic(String topicName) {
        this.topicName = topicName;
    }

}