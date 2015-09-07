package model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Abanoub on 7/5/2015.
 */
public class OriginalBusinessActivity {

    private String url;
    @SerializedName("Id")
    private String ID;
    @SerializedName("Name")
    private String Name;
    @SerializedName("License_Type__c")
    private String LicenseType;
    @SerializedName("Business_Activity_Name__c")
    private String BusinessActivityName;
    @SerializedName("Business_Activity_Name_Arabic__c")
    private String BusinessActivityArabicName;
    @SerializedName("Business_Activity_Description__c")
    private String BusinessActivityDescription;
    @SerializedName("Status__c")
    private String Status;

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getBusinessActivityDescription() {
        return BusinessActivityDescription;
    }

    public void setBusinessActivityDescription(String businessActivityDescription) {
        BusinessActivityDescription = businessActivityDescription;
    }

    public String getBusinessActivityArabicName() {
        return BusinessActivityArabicName;
    }

    public void setBusinessActivityArabicName(String businessActivityArabicName) {
        BusinessActivityArabicName = businessActivityArabicName;
    }

    public String getBusinessActivityName() {
        return BusinessActivityName;
    }

    public void setBusinessActivityName(String businessActivityName) {
        BusinessActivityName = businessActivityName;
    }

    public String getLicenseType() {
        return LicenseType;
    }

    public void setLicenseType(String licenseType) {
        LicenseType = licenseType;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
