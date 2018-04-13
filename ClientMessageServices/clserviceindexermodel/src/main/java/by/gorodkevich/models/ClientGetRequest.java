package by.gorodkevich.models;

import java.util.Collection;

public class ClientGetRequest {
    private String id;
    private Collection<String> fieldList;

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


    @Override
    public String toString() {
        return String.format("IndexGetRequest[id=%s,fieldList='%s']", id, fieldList);
    }
}
