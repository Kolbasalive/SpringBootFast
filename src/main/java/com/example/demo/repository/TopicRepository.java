package com.example.demo.repository;

import com.example.demo.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TopicRepository extends JpaRepository<Topic, UUID> {
    Topic findByTopicName(String topicName);
}
