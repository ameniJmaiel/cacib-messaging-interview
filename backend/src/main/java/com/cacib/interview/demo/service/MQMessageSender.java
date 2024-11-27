package com.cacib.interview.demo.service;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class MQMessageSender {

    private final JmsTemplate jmsTemplate;

    public MQMessageSender(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendMessage(String queueName, String message) {
        jmsTemplate.convertAndSend(queueName, message);
        System.out.println("Message sent to queue: " + queueName);
    }
}
