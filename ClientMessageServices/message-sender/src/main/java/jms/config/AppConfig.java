package jms.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.listener.DefaultMessageListenerContainer;


import javax.jms.ConnectionFactory;

@Configuration
@EnableJms
public class AppConfig {

    public static final String QUEUE_NAME = "example.queue";

    @Bean
    public ConnectionFactory connectionFactory() {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        return connectionFactory;
    }

 /*   @Bean
    public JmsListenerContainerFactory jmsListenerContainerFactory() {
        DefaultMessageListenerContainer factory = new DefaultMessageListenerContainer;
        factory.setConnectionFactory(connectionFactory());
        factory.setConcurrency("3");
        factory.setConcurrentConsumers(3);

        return factory;
    }*/

    @Bean
    public DefaultMessageListenerContainer defaultMessageListenerContainer() {
        DefaultMessageListenerContainer factory = new DefaultMessageListenerContainer();
        factory.setConnectionFactory(connectionFactory());
        factory.setConcurrency("3");
        factory.setConcurrentConsumers(3);
        factory.setDestinationName(QUEUE_NAME);

        return factory;
    }

}
