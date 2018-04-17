package jms;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    @Autowired
    public ObjectMapper serializingObjectMapper;


    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        String now = mapper.writeValueAsString(LocalDateTime.now());
        System.out.println(now);
        String now1 = "2018-04-16T20:32:14.001Z";
        System.out.println(now1);


        LocalDateTime formatDateTime = LocalDateTime.parse(now1,DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX"));
        System.out.println(formatDateTime
        .toString());


    }
}
