package by.gorodkevich.models;

import java.util.Map;

public class ClientUpdateRequest {

    private String id;
    private Map<String, Object> fieldsToUpdates;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public Map<String, Object> getFieldsToUpdates() {
        return fieldsToUpdates;
    }

    public void setFieldsToUpdates(Map<String, Object> fieldsToUpdates) {
        this.fieldsToUpdates = fieldsToUpdates;
    }

    @Override
    public String toString() {
        return String.format("ClientUpdateRequest[id=%s, fieldsToUpdates='%s']", id, fieldsToUpdates);
    }
}
