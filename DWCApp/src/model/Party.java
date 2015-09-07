package model;

import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;

/**
 * Created by Abanoub Wagdy on 8/18/2015.
 */
public class Party extends SObject implements Serializable {

    @JsonProperty("Name")
    private String Name;
    @JsonProperty("Id")
    private String Id;
    @JsonProperty("attributes")
    attributes attributes;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public model.attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(model.attributes attributes) {
        this.attributes = attributes;
    }

    @Override
    public String getId() {
        return Id;
    }

    @Override
    public void setId(String id) {
        Id = id;
    }
}
