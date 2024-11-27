package com.cacib.interview.demo.controller;

import com.cacib.interview.demo.service.MQMessageReader;
import com.cacib.interview.demo.service.MQMessageSender;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mq")
public class MQController {

    private final MQMessageSender mqMessageSender;
    private final MQMessageReader mqMessageReader;

    public MQController(MQMessageSender mqMessageSender, MQMessageReader mqMessageReader) {
        this.mqMessageSender = mqMessageSender;
        this.mqMessageReader = mqMessageReader;
    }

    @GetMapping("/read")
    public String readMessage(@RequestParam String queueName) {
        String message = mqMessageReader.readMessage(queueName);
        mqMessageReader.saveMessage(message);
        return message != null ? "Received message: " + message : "No message found in the queue!";
    }

    @PostMapping("/send")
    public String sendMessage(@RequestParam String message) {
        String queueName = "DEV.QUEUE.1";
        mqMessageSender.sendMessage(queueName, message);
        return "Message sent to queue!";
    }
}