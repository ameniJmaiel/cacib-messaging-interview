package com.cacib.interview.demo.repository;

import com.cacib.interview.demo.entity.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<MessageEntity, Long> {
}