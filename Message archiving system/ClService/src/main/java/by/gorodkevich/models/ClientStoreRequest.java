package by.gorodkevich.models;


import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Collection;


public class ClientStoreRequest {
    private LocalDateTime sendDateTime;
    private String from;
    private Collection<String> to;
    private String body;
    private String subject;
    private Long size;

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

    @Override
    public String toString() {
        return String.format(
                "MongoEntity[sendDateTime='%s'," +
                        "from='%s'," +
                        "to='%s'," +
                        "body='%s'," +
                        "subject='%s'," +
                        "size='%s']",
                sendDateTime, from, to, body, subject, size);
    }
}
