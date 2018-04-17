package jms.config.queue;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;

import javax.jms.MessageListener;


@EnableJms
@Configuration
public class QueueConfig {
    @Autowired
    private QueueServiceConfig queueServiceConfigImpl;

    @Autowired
    private MessageListener myMessageListener;



    @Bean
    public ActiveMQConnectionFactory activeMQConnectionFactory() {
        return new ActiveMQConnectionFactory(queueServiceConfigImpl.getUrl());
    }

    @Bean
    public JmsTemplate jmsTemplate() {
        JmsTemplate jmsTemplate = new JmsTemplate(activeMQConnectionFactory());
        jmsTemplate.setDefaultDestinationName(queueServiceConfigImpl.getQueueName());
        return jmsTemplate;
    }

    @Bean
    public DefaultMessageListenerContainer messageListenerContainer() {
        DefaultMessageListenerContainer factory = new DefaultMessageListenerContainer();
        factory.setConnectionFactory(activeMQConnectionFactory());
        factory.setMessageListener(myMessageListener);
        factory.setConcurrentConsumers(queueServiceConfigImpl.getNumberConsumers());
        factory.setDestinationName(queueServiceConfigImpl.getQueueName());
        return factory;
    }

}

