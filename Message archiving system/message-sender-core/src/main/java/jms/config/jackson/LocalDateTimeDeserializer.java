package jms.config.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {

    public LocalDateTimeDeserializer(String DESERIALIZER_FORMATTER) {
        this.DESERIALIZER_FORMATTER = DESERIALIZER_FORMATTER;
    }

    private String DESERIALIZER_FORMATTER;

    @Override
    public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String json = p.getValueAsString();
        return LocalDateTime.parse(p.getValueAsString(), DateTimeFormatter.ofPattern(DESERIALIZER_FORMATTER));

    }
}
