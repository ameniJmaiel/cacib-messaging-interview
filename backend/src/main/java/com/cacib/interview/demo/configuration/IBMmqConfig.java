package com.cacib.interview.demo.configuration;

import com.ibm.mq.jakarta.jms.MQConnectionFactory;
import com.ibm.msg.client.jakarta.wmq.common.CommonConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

import jakarta.jms.JMSException;

@Configuration
@EnableJms
public class IBMmqConfig {

    @Bean
    public MQConnectionFactory mqConnectionFactory() throws JMSException {
        MQConnectionFactory factory = new MQConnectionFactory();
        factory.setHostName(System.getenv("MQ_HOSTNAME"));
        factory.setPort(Integer.parseInt(System.getenv("MQ_PORT")));
        factory.setQueueManager(System.getenv("MQ_QM"));
        factory.setChannel(System.getenv("MQ_CHANNEL"));
        factory.setTransportType(1);
        factory.setStringProperty(CommonConstants.USERID, System.getenv("MQ_USERNAME"));
        factory.setStringProperty(CommonConstants.PASSWORD, System.getenv("MQ_USER_PASSWORD"));
        return factory;
    }

    @Bean
    public JmsTemplate jmsTemplate(MQConnectionFactory mqConnectionFactory) {
        return new JmsTemplate(mqConnectionFactory);
    }
}
