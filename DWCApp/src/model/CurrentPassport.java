package model;


import com.google.gson.annotations.SerializedName;

import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;

/**
 * Created by Abanoub on 7/7/2015.
 */
public class CurrentPassport implements Serializable {

    public model.attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(model.attributes attributes) {
        this.attributes = attributes;
    }

    @SerializedName("attributes")
    @JsonProperty("attributes")

    attributes attributes;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPassport_Issue_Country__c() {
        return Passport_Issue_Country__c;
    }

    public void setPassport_Issue_Country__c(String passport_Issue_Country__c) {
        Passport_Issue_Country__c = passport_Issue_Country__c;
    }

    public CurrentNationality getPassport_Issue_Country__r() {
        return passport_Issue_Country__r;
    }

    public void setPassport_Issue_Country__r(CurrentNationality passport_Issue_Country__r) {
        this.passport_Issue_Country__r = passport_Issue_Country__r;
    }

    @JsonProperty("Passport_Issue_Country__r")
    public CurrentNationality passport_Issue_Country__r;
    @SerializedName("Passport_Issue_Country__c")
    @JsonProperty("Passport_Issue_Country__c")
    public String Passport_Issue_Country__c;
    String url;
    @SerializedName("Id")
    @JsonProperty("Id")
    String ID;
    @SerializedName("Name")
    @JsonProperty("Name")
    String Name;
    @SerializedName("Passport_Expiry_Date__c")
    @JsonProperty("Passport_Expiry_Date__c")
    String Passport_Expiry_Date__c;

    @SerializedName("Passport_Issue_Date__c")
    @JsonProperty("Passport_Issue_Date__c")
    String Passport_Issue_Date__c;

    @SerializedName("Passport_Type__c")
    @JsonProperty("Passport_Type__c")
    String Passport_Type__c;

    public String getPassport_Holder__c() {
        return Passport_Holder__c;
    }

    public void setPassport_Holder__c(String passport_Holder__c) {
        Passport_Holder__c = passport_Holder__c;
    }

    @SerializedName("Passport_Holder__c")
    @JsonProperty("Passport_Holder__c")
    String Passport_Holder__c;

    public Account getPassport_Holder__r() {
        return passport_Holder__r;
    }

    public void setPassport_Holder__r(Account passport_Holder__r) {
        this.passport_Holder__r = passport_Holder__r;
    }

    @JsonProperty("Passport_Holder__r")
public Account passport_Holder__r;

    @SerializedName("Passport_Place_of_Issue__c")
    @JsonProperty("Passport_Place_of_Issue__c")
    String Passport_Place_of_Issue__c;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassport_Expiry_Date__c() {
        return Passport_Expiry_Date__c;
    }

    public void setPassport_Expiry_Date__c(String passport_Expiry_Date__c) {
        Passport_Expiry_Date__c = passport_Expiry_Date__c;
    }

    public String getPassport_Issue_Date__c() {
        return Passport_Issue_Date__c;
    }

    public void setPassport_Issue_Date__c(String passport_Issue_Date__c) {
        Passport_Issue_Date__c = passport_Issue_Date__c;
    }

    public String getPassport_Type__c() {
        return Passport_Type__c;
    }

    public void setPassport_Type__c(String passport_Type__c) {
        Passport_Type__c = passport_Type__c;
    }

    public String getPassport_Place_of_Issue__c() {
        return Passport_Place_of_Issue__c;
    }

    public void setPassport_Place_of_Issue__c(String passport_Place_of_Issue__c) {
        Passport_Place_of_Issue__c = passport_Place_of_Issue__c;
    }
}
