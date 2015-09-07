package model;

import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;

/**
 * Created by Abanoub Wagdy on 8/31/2015.
 */
public class Product_Type__r implements Serializable {

//    public model.attributes getAttributes() {
//        return attributes;
//    }
//
//    public void setAttributes(model.attributes attributes) {
//
//        this.attributes = attributes;
//    }

//    @JsonProperty("attributes")
//    attributes attributes;
    @JsonProperty("Id")
    private String id;
    @JsonProperty("Name")
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
