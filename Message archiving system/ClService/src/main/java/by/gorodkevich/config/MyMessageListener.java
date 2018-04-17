package by.gorodkevich.config;

import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.MessageListener;
@Component
public class MyMessageListener implements javax.jms.MessageListener {
    @Override
    public void onMessage(Message message) {

    }
}
