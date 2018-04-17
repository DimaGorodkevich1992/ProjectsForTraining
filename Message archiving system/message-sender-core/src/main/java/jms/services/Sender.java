package jms.services;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Collection;
import java.util.Objects;

public interface Sender {

    void send(Object message) throws JsonProcessingException;

    void sendCollection(Collection<?> messages);
}
