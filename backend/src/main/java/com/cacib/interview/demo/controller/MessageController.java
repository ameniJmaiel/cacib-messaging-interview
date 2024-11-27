package com.cacib.interview.demo.controller;

import com.cacib.interview.demo.entity.MessageEntity;
import com.cacib.interview.demo.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;

    @GetMapping("/all")
    public List<MessageEntity> getAllMessages() {
        return messageRepository.findAll();
    }
}