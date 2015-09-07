package model;

import com.google.gson.annotations.SerializedName;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by Bibo on 7/28/2015.
 */
public class Case {

    @SerializedName("url")
    String url;
    @SerializedName("Id")
    String Id;
    @SerializedName("CaseNumber")
    String CaseNumber;
    @SerializedName("Case_Rting_Score__c")
    String Case_Rating_Score;
    @SerializedName("Web_Form__c")
    String Web_Form;
    @SerializedName("Status")
    String Status;
    @SerializedName("CreatedDate")
    String CreatedDate;
    @JsonProperty("Service_Requested__c")
    @SerializedName("Service_Requested__c")
    String service_Requested__c;
    @JsonProperty("Registration_Amendment__r")
    @SerializedName("Registration_Amendment__r")
    Registration_Amendments__c registration_amendments__c;
    @JsonProperty("Registration_Amendment__c")
    @SerializedName("Registration_Amendment__c")
    String registration_Amendment__c;
    @JsonProperty("Invoice__c")
    @SerializedName("Invoice__c")
    String invoice__c;

    public String getService_Requested__c() {
        return service_Requested__c;
    }

    public void setService_Requested__c(String service_Requested__c) {
        this.service_Requested__c = service_Requested__c;
    }

    public Registration_Amendments__c getRegistration_amendments__c() {
        return registration_amendments__c;
    }

    public void setRegistration_amendments__c(Registration_Amendments__c registration_amendments__c) {
        this.registration_amendments__c = registration_amendments__c;
    }

    public String getRegistration_Amendment__c() {
        return registration_Amendment__c;
    }

    public void setRegistration_Amendment__c(String registration_Amendment__c) {
        this.registration_Amendment__c = registration_Amendment__c;
    }

    public String getInvoice__c() {
        return invoice__c;
    }

    public void setInvoice__c(String invoice__c) {
        this.invoice__c = invoice__c;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }

    String Amount;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getCaseNumber() {
        return CaseNumber;
    }

    public void setCaseNumber(String caseNumber) {
        CaseNumber = caseNumber;
    }

    public String getCase_Rating_Score() {
        return Case_Rating_Score;
    }

    public void setCase_Rating_Score(String case_Rating_Score) {
        Case_Rating_Score = case_Rating_Score;
    }

    public String getWeb_Form() {
        return Web_Form;
    }

    public void setWeb_Form(String web_Form) {
        Web_Form = web_Form;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getCreatedDate() {
        return CreatedDate;
    }

    public void setCreatedDate(String createdDate) {
        CreatedDate = createdDate;
    }
}
