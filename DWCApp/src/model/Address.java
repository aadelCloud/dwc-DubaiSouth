/**
 * Address.java
 * <p/>
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package model;

import org.codehaus.jackson.annotate.JsonProperty;

public class Address extends Location implements java.io.Serializable {

    public model.attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(model.attributes attributes) {
        this.attributes = attributes;
    }

    @JsonProperty("attributes")
    attributes attributes;

    @JsonProperty("City")
    private String city;
    @JsonProperty("Country")
    private String country;
    @JsonProperty("CountryCode")
    private String countryCode;
    @JsonProperty("PostalCode")
    private String postalCode;
    @JsonProperty("State")
    private String state;
    @JsonProperty("StateCode")
    private String stateCode;
    @JsonProperty("Street")
    private String street;

    public Address() {
    }


    /**
     * Gets the city value for this Address.
     *
     * @return city
     */
    public String getCity() {
        return city;
    }


    /**
     * Sets the city value for this Address.
     *
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }


    /**
     * Gets the country value for this Address.
     *
     * @return country
     */
    public String getCountry() {
        return country;
    }


    /**
     * Sets the country value for this Address.
     *
     * @param country
     */
    public void setCountry(String country) {
        this.country = country;
    }


    /**
     * Gets the countryCode value for this Address.
     *
     * @return countryCode
     */
    public String getCountryCode() {
        return countryCode;
    }


    /**
     * Sets the countryCode value for this Address.
     *
     * @param countryCode
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }


    /**
     * Gets the postalCode value for this Address.
     *
     * @return postalCode
     */
    public String getPostalCode() {
        return postalCode;
    }


    /**
     * Sets the postalCode value for this Address.
     *
     * @param postalCode
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }


    /**
     * Gets the state value for this Address.
     *
     * @return state
     */
    public String getState() {
        return state;
    }


    /**
     * Sets the state value for this Address.
     *
     * @param state
     */
    public void setState(String state) {
        this.state = state;
    }


    /**
     * Gets the stateCode value for this Address.
     *
     * @return stateCode
     */
    public String getStateCode() {
        return stateCode;
    }


    /**
     * Sets the stateCode value for this Address.
     *
     * @param stateCode
     */
    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }


    /**
     * Gets the street value for this Address.
     *
     * @return street
     */
    public String getStreet() {
        return street;
    }


    /**
     * Sets the street value for this Address.
     *
     * @param street
     */
    public void setStreet(String street) {
        this.street = street;
    }

}