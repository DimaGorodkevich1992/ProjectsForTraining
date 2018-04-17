package jms.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.util.Collection;

@Component
public class MessageSender implements Sender {
    @Autowired
    private JmsTemplate jmsTemplate;
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void send(Object message) throws JsonProcessingException {

        String jsonInString = objectMapper.writeValueAsString(message);
        jmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(jsonInString);
            }
        });
    }

    @Override
    public void sendCollection(Collection<?> messages) {
        for (Object o : messages) {
            try {

                String jsonInString = objectMapper.writeValueAsString(o);
                jmsTemplate.send(new MessageCreator() {
                    @Override
                    public Message createMessage(Session session) throws JMSException {
                        return session.createTextMessage(jsonInString);
                    }
                });
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

        }

    }
}

