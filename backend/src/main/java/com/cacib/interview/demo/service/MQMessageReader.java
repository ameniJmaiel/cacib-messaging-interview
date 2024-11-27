package com.cacib.interview.demo.service;

import com.cacib.interview.demo.entity.MessageEntity;
import com.cacib.interview.demo.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import jakarta.jms.Message;
import jakarta.jms.TextMessage;

@Service
public class MQMessageReader {

    private final JmsTemplate jmsTemplate;

    @Autowired
    private MessageRepository messageRepository;

    public MQMessageReader(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public String readMessage(String queueName) {
        try {
            Message message = jmsTemplate.receive(queueName);
            if (message instanceof TextMessage) {
                return ((TextMessage) message).getText();
            } else {
                return "Unsupported message type!";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error reading message: " + e.getMessage();
        }
    }

    public void saveMessage(String message) {
        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setMessageBody(message);
        messageEntity.setTimestamp(java.time.LocalDateTime.now().toString());
        messageRepository.save(messageEntity);
        System.out.println("Message saved to the database: " + message);
    }
}
