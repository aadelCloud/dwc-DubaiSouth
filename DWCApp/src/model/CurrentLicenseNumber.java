package model;

import com.google.gson.annotations.SerializedName;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by Abanoub on 6/14/2015.
 */
public class CurrentLicenseNumber {

    public model.attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(model.attributes attributes) {
        this.attributes = attributes;
    }

    @JsonProperty("attributes")
    attributes attributes;

    @JsonProperty("Id")
    String Id;

    @JsonProperty("License_Issue_Date__c")
    String License_Issue_Date;

    @JsonProperty("License_Expiry_Date__c")
    String License_Expiry_Date;

    @JsonProperty("Commercial_Name__c")
    String Commercial_Name;

    @JsonProperty("Commercial_Name_Arabic__c")
    String Commercial_Name_Arabic;

    @JsonProperty("License_Number_Value__c")
    String License_Number_Value;

    @JsonProperty("Validity_Status__c")
    String Validity_Status;
@JsonProperty("RecordType")
    RecordType _recordType;



    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getLicense_Issue_Date() {
        return License_Issue_Date;
    }

    public void setLicense_Issue_Date(String license_Issue_Date) {
        License_Issue_Date = license_Issue_Date;
    }

    public String getLicense_Expiry_Date() {
        return License_Expiry_Date;
    }

    public void setLicense_Expiry_Date(String license_Expiry_Date) {
        License_Expiry_Date = license_Expiry_Date;
    }

    public String getCommercial_Name() {
        return Commercial_Name;
    }

    public void setCommercial_Name(String commercial_Name) {
        Commercial_Name = commercial_Name;
    }

    public String getCommercial_Name_Arabic() {
        return Commercial_Name_Arabic;
    }

    public void setCommercial_Name_Arabic(String commercial_Name_Arabic) {
        Commercial_Name_Arabic = commercial_Name_Arabic;
    }

    public String getLicense_Number_Value() {
        return License_Number_Value;
    }

    public void setLicense_Number_Value(String license_Number_Value) {
        License_Number_Value = license_Number_Value;
    }

    public String getValidity_Status() {
        return Validity_Status;
    }

    public void setValidity_Status(String validity_Status) {
        Validity_Status = validity_Status;
    }

    public RecordType get_recordType() {
        return _recordType;
    }

    public void set_recordType(RecordType _recordType) {
        this._recordType = _recordType;
    }
}