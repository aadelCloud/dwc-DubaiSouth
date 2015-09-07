/**
 * Location.java
 * <p/>
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package model;

import org.codehaus.jackson.annotate.JsonProperty;

public class Location implements java.io.Serializable {

    public model.attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(model.attributes attributes) {
        this.attributes = attributes;
    }

    @JsonProperty("attributes")
    attributes attributes;
    @JsonProperty("Latitude")
    private Double latitude;
    @JsonProperty("Longitude")
    private Double longitude;

    public Location() {
    }

    /**
     * Gets the latitude value for this Location.
     *
     * @return latitude
     */
    public Double getLatitude() {
        return latitude;
    }


    /**
     * Sets the latitude value for this Location.
     *
     * @param latitude
     */
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }


    /**
     * Gets the longitude value for this Location.
     *
     * @return longitude
     */
    public Double getLongitude() {
        return longitude;
    }


    /**
     * Sets the longitude value for this Location.
     *
     * @param longitude
     */
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

}