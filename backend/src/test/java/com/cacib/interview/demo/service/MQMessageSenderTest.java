package com.cacib.interview.demo.service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jms.core.JmsTemplate;

import static org.mockito.Mockito.*;


public class MQMessageSenderTest {

    @Mock
    private JmsTemplate jmsTemplate; // Mock the JmsTemplate

    @InjectMocks
    private MQMessageSender mqMessageSender; // Inject mock into the MQMessageSender

    @BeforeEach
    public void setUp() {
        // Initialize the mocks
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSendMessage() {

        String queueName = "TestQueue";
        String message = "Test Message";

        mqMessageSender.sendMessage(queueName, message);

        verify(jmsTemplate, times(1)).convertAndSend(queueName, message);
    }
}



