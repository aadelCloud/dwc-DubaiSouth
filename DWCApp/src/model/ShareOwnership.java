package model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Abanoub on 7/7/2015.
 */
public class ShareOwnership implements Serializable{

    String url;
    @SerializedName("Id")
    String ID;
    @SerializedName("No_of_Shares__c")
    String No_of_Shares__c;
    @SerializedName("Ownership_of_Share__c")
    String Ownership_of_Share__c;
    @SerializedName("Shareholder_Status__c")
    String Shareholder_Status__c;
    @SerializedName("Ownership_End_Date__c")
    String Ownership_End_Date__c;
    @SerializedName("Ownership_Start_Date__c")
    String Ownership_Start_Date__c;

    Shareholder _shareholder;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNo_of_Shares__c() {
        return No_of_Shares__c;
    }

    public void setNo_of_Shares__c(String no_of_Shares__c) {
        No_of_Shares__c = no_of_Shares__c;
    }

    public String getOwnership_of_Share__c() {
        return Ownership_of_Share__c;
    }

    public void setOwnership_of_Share__c(String ownership_of_Share__c) {
        Ownership_of_Share__c = ownership_of_Share__c;
    }

    public String getShareholder_Status__c() {
        return Shareholder_Status__c;
    }

    public void setShareholder_Status__c(String shareholder_Status__c) {
        Shareholder_Status__c = shareholder_Status__c;
    }

    public String getOwnership_End_Date__c() {
        return Ownership_End_Date__c;
    }

    public void setOwnership_End_Date__c(String ownership_End_Date__c) {
        Ownership_End_Date__c = ownership_End_Date__c;
    }

    public String getOwnership_Start_Date__c() {
        return Ownership_Start_Date__c;
    }

    public void setOwnership_Start_Date__c(String ownership_Start_Date__c) {
        Ownership_Start_Date__c = ownership_Start_Date__c;
    }

    public Shareholder get_shareholder() {
        return _shareholder;
    }

    public void set_shareholder(Shareholder _shareholder) {
        this._shareholder = _shareholder;
    }
}
