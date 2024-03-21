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

    public Message(String text, String author) {
        this.text = text;
        this.author = author;
    }

    @ManyToOne(cascade = CascadeType.MERGE)
    //@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "topic_id")
    private Topic topic;

}
