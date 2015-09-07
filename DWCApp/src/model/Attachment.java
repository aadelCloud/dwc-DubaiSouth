package model;

import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;

/**
 * Created by Abanoub on 7/6/2015.
 */
public class Attachment  extends SObject implements Serializable {

    @JsonProperty("Id")
    private String ID;

    public String getBodyLength() {
        return BodyLength;
    }

    public void setBodyLength(String bodyLength) {
        BodyLength = bodyLength;
    }

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

    @JsonProperty("Body")
    private String Body;
    @JsonProperty("BodyLength")
    private String BodyLength;
    @JsonProperty("Name")
    private String Name;

    private model.attributes attributes;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getBody() {
        return Body;
    }

    public void setBody(String body) {
        Body = body;
    }
}
