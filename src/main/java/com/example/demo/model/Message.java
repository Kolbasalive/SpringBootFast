package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "MESSAGE")
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Message extends BaseEntity {
    private String text;
    private String author;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "topic_id")
    private Topic topic;

}
