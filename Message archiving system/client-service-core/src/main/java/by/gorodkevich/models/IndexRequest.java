package by.gorodkevich.models;


import java.time.LocalDateTime;
import java.util.Collection;

public class IndexRequest {
    private String id;
    private Collection<String> fieldList;
    private LocalDateTime dateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Collection<String> getFieldList() {
        return fieldList;
    }

    public void setFieldList(Collection<String> fieldList) {
        this.fieldList = fieldList;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return String.format("IndexRequest[id=%s,fieldList='%s', dataTime='%s']", id, fieldList, dateTime);
    }
}
