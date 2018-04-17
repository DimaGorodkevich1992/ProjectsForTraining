package by.gorodkevich.models;


import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Collection;

@Document
public class MongoEntity {
    private String id;
    private LocalDateTime sendDateTime;
    private String from;
    private Collection<String> to;
    private String body;
    private String subject;
    private Long size;
    private Status status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getSendDateTime() {
        return sendDateTime;
    }

    public void setSendDateTime(LocalDateTime sendDateTime) {
        this.sendDateTime = sendDateTime;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public Collection<String> getTo() {
        return to;
    }

    public void setTo(Collection<String> to) {
        this.to = to;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format(
                "MongoEntity[" +
                        "id=%s," +
                        "sendDateTime='%s'," +
                        "from='%s'," +
                        "to='%s'," +
                        "body='%s'," +
                        "subject='%s'," +
                        "size='%s'," +
                        "status='%s']",
                id, sendDateTime, from, to, body, subject, size, status);
    }
}
