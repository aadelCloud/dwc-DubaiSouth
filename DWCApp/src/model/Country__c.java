package model;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by M_Ghareeb on 8/25/2015.
 */
public class Country__c {
    public model.attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(model.attributes attributes) {
        this.attributes = attributes;
    }

    @JsonProperty("attributes")
    attributes attributes;
    @JsonProperty("Aramex_Country_Code__c")
    private String aramex_Country_Code__c;
    @JsonProperty("Country_Name_Arabic__c")
    private String Country_Name_Arabic__c;
    @JsonProperty("eDNRD_Name__c")
    private String eDNRD_Name__c;
    @JsonProperty("eForm_Code__c")
    private String eForm_Code__c;
    @JsonProperty("Is_Active__c")
    private String Is_Active__c;
    @JsonProperty("Nationality_Name__c")
    private String Nationality_Name__c;
    @JsonProperty("Nationality_Name_Arabic__c")
    private String Nationality_Name_Arabic__c;
    @JsonProperty("Id")
    private String id;

    public String getAramex_Country_Code__c() {
        return aramex_Country_Code__c;
    }

    public void setAramex_Country_Code__c(String aramex_Country_Code__c) {
        this.aramex_Country_Code__c = aramex_Country_Code__c;
    }

    public String getCountry_Name_Arabic__c() {
        return Country_Name_Arabic__c;
    }

    public void setCountry_Name_Arabic__c(String country_Name_Arabic__c) {
        Country_Name_Arabic__c = country_Name_Arabic__c;
    }

    public String geteDNRD_Name__c() {
        return eDNRD_Name__c;
    }

    public void seteDNRD_Name__c(String eDNRD_Name__c) {
        this.eDNRD_Name__c = eDNRD_Name__c;
    }

    public String geteForm_Code__c() {
        return eForm_Code__c;
    }

    public void seteForm_Code__c(String eForm_Code__c) {
        this.eForm_Code__c = eForm_Code__c;
    }

    public String getIs_Active__c() {
        return Is_Active__c;
    }

    public void setIs_Active__c(String is_Active__c) {
        Is_Active__c = is_Active__c;
    }

    public String getNationality_Name__c() {
        return Nationality_Name__c;
    }

    public void setNationality_Name__c(String nationality_Name__c) {
        Nationality_Name__c = nationality_Name__c;
    }

    public String getNationality_Name_Arabic__c() {
        return Nationality_Name_Arabic__c;
    }

    public void setNationality_Name_Arabic__c(String nationality_Name_Arabic__c) {
        Nationality_Name_Arabic__c = nationality_Name_Arabic__c;
    }

    public String getId() {
        return id;
    }

    public void setId(String ID) {
        this.id = ID;
    }
}
