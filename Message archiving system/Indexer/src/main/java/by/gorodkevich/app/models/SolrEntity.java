package by.gorodkevich.app.models;

import by.gorodkevich.models.Status;
import org.apache.solr.client.solrj.beans.Field;


import org.springframework.data.solr.core.mapping.SolrDocument;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;

@SolrDocument(solrCoreName = "EmailLetter")
public class SolrEntity {
    @Field("id")
    private String id;
    @Field("sendDateTime")
    private LocalDateTime sendDateTime;
    @Field("from")
    private String from;
    @Field("to")
    private Collection<String> to;
    @Field("body")
    private String body;
    @Field("subject")
    private String subject;
    @Field("size")
    private Long size;
    @Field("status")
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
                "SolrEntity[" +
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
