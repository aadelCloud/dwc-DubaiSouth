/**
 * SObject.java
 * <p/>
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package model;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

public class SObject implements java.io.Serializable {
    @JsonProperty("FieldsToNull")
    @JsonIgnore
    private String[] fieldsToNull;
    @JsonProperty("Id")
    @JsonIgnore
    private String id;


    public SObject() {
    }


    /**
     * Gets the fieldsToNull value for this SObject.
     *
     * @return fieldsToNull
     */
    public String[] getFieldsToNull() {
        return fieldsToNull;
    }


    /**
     * Sets the fieldsToNull value for this SObject.
     *
     * @param fieldsToNull
     */
    public void setFieldsToNull(String[] fieldsToNull) {
        this.fieldsToNull = fieldsToNull;
    }

    public String getFieldsToNull(int i) {
        return this.fieldsToNull[i];
    }

    public void setFieldsToNull(int i, String _value) {
        this.fieldsToNull[i] = _value;
    }


    /**
     * Gets the id value for this SObject.
     *
     * @return id
     */
    public String getId() {
        return id;
    }


    /**
     * Sets the id value for this SObject.
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

}