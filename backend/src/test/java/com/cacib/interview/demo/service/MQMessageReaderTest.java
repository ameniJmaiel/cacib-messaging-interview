package com.cacib.interview.demo.service;

import com.cacib.interview.demo.entity.MessageEntity;
import com.cacib.interview.demo.repository.MessageRepository;
import jakarta.jms.TextMessage;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MQMessageReaderTest {

    @Mock
    private JmsTemplate jmsTemplate;

    @Mock
    private MessageRepository messageRepository;

    @InjectMocks
    private MQMessageReader mqMessageReader;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testReadMessage_Success() throws Exception {

        String queueName = "testQueue";
        String expectedMessage = "Hello, MQ!";
        TextMessage textMessage = mock(TextMessage.class);
        when(textMessage.getText()).thenReturn(expectedMessage);
        when(jmsTemplate.receive(queueName)).thenReturn(textMessage);

        String actualMessage = mqMessageReader.readMessage(queueName);

        assertNotNull(actualMessage);
        assertEquals(expectedMessage, actualMessage);
        verify(jmsTemplate, times(1)).receive(queueName);
    }


    @Test
    public void testReadMessage_UnsupportedMessageType() throws Exception {

        String queueName = "testQueue";
        when(jmsTemplate.receive(queueName)).thenReturn(mock(jakarta.jms.Message.class));

        String actualMessage = mqMessageReader.readMessage(queueName);

        assertEquals("Unsupported message type!", actualMessage);
        verify(jmsTemplate, times(1)).receive(queueName);
    }


    @Test
    public void testReadMessage_Exception() {

        String queueName = "testQueue";
        when(jmsTemplate.receive(queueName)).thenThrow(new RuntimeException("Test exception"));

        String actualMessage = mqMessageReader.readMessage(queueName);

        assertTrue(actualMessage.startsWith("Error reading message:"));
        verify(jmsTemplate, times(1)).receive(queueName);
    }


    @Test
    public void testSaveMessage() {

        String message = "Test message";
        MessageEntity mockEntity = new MessageEntity();
        mockEntity.setMessageBody(message);
        mockEntity.setTimestamp("2024-11-27T10:00:00");
        when(messageRepository.save(any(MessageEntity.class))).thenReturn(mockEntity);

        mqMessageReader.saveMessage(message);

        verify(messageRepository, times(1)).save(any(MessageEntity.class));
        System.out.println("Message saved successfully");
    }
}


