package model;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by Abanoub Wagdy on 9/2/2015.
 */
public class Registration_Amendments__c {

    @JsonProperty("Id")
    String Id;
    @JsonProperty("Name")
    String name;
    @JsonProperty("Address__c")
    String address;
    @JsonProperty("Address_Before_Amendment__c")
    String addressBeforeAmendment;
    @JsonProperty("Application_Status__c")
    String applicationStatus;
    @JsonProperty("City__c")
    String city;
    @JsonProperty("City_Before_Change__c")
    String cityBeforeChange;
    @JsonProperty("Company_Name__c")
    String companyName;
    @JsonProperty("Company_Name_Before_Registration__c")
    String companyNameBeforeRegistration;
    @JsonProperty("Company_Arabic_Name_Before_Registration__c")
    String companyArabicNameBeforeRegistration;
    @JsonProperty("Country_Before_Change__c")
    String countryBeforeChange;
    @JsonProperty("E_Mail__c")
    String email;
    @JsonProperty("Email_Before_Change__c")
    String emailBeforeChange;
    @JsonProperty("Fax__c")
    String fax;
    @JsonProperty("Fax_Before_Change__c")
    String faxBeforeChange;
    @JsonProperty("Mobile__c")
    String mobile;
    @JsonProperty("Mobile_Before_Change__c")
    String mobileBeforeChange;
    @JsonProperty("Amendment_Effective_Date__c")
    String amendmentEffectiveDate;
    @JsonProperty("Service_Identifier__c")
    String service_Identifier__c;
    @JsonProperty("Require_Fees__c")
    boolean require_Fees__c;

    public String getService_Identifier__c() {
        return service_Identifier__c;
    }

    public void setService_Identifier__c(String service_Identifier__c) {
        this.service_Identifier__c = service_Identifier__c;
    }

    public boolean isRequire_Fees__c() {
        return require_Fees__c;
    }

    public void setRequire_Fees__c(boolean require_Fees__c) {
        this.require_Fees__c = require_Fees__c;
    }

    String Company;
    String country;
    RecordType recordType;

    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        Company = company;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public RecordType getRecordType() {
        return recordType;
    }

    public void setRecordType(RecordType recordType) {
        this.recordType = recordType;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressBeforeAmendment() {
        return addressBeforeAmendment;
    }

    public void setAddressBeforeAmendment(String addressBeforeAmendment) {
        this.addressBeforeAmendment = addressBeforeAmendment;
    }

    public String getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityBeforeChange() {
        return cityBeforeChange;
    }

    public void setCityBeforeChange(String cityBeforeChange) {
        this.cityBeforeChange = cityBeforeChange;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyNameBeforeRegistration() {
        return companyNameBeforeRegistration;
    }

    public void setCompanyNameBeforeRegistration(String companyNameBeforeRegistration) {
        this.companyNameBeforeRegistration = companyNameBeforeRegistration;
    }

    public String getCompanyArabicNameBeforeRegistration() {
        return companyArabicNameBeforeRegistration;
    }

    public void setCompanyArabicNameBeforeRegistration(String companyArabicNameBeforeRegistration) {
        this.companyArabicNameBeforeRegistration = companyArabicNameBeforeRegistration;
    }

    public String getCountryBeforeChange() {
        return countryBeforeChange;
    }

    public void setCountryBeforeChange(String countryBeforeChange) {
        this.countryBeforeChange = countryBeforeChange;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailBeforeChange() {
        return emailBeforeChange;
    }

    public void setEmailBeforeChange(String emailBeforeChange) {
        this.emailBeforeChange = emailBeforeChange;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getFaxBeforeChange() {
        return faxBeforeChange;
    }

    public void setFaxBeforeChange(String faxBeforeChange) {
        this.faxBeforeChange = faxBeforeChange;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMobileBeforeChange() {
        return mobileBeforeChange;
    }

    public void setMobileBeforeChange(String mobileBeforeChange) {
        this.mobileBeforeChange = mobileBeforeChange;
    }

    public String getAmendmentEffectiveDate() {
        return amendmentEffectiveDate;
    }

    public void setAmendmentEffectiveDate(String amendmentEffectiveDate) {
        this.amendmentEffectiveDate = amendmentEffectiveDate;
    }
}
