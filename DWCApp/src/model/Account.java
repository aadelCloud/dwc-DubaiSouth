package model;



import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;

/**
 * Created by Abanoub on 6/14/2015.
 */
public class Account implements Serializable {

    public model.attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(model.attributes attributes) {
        this.attributes = attributes;
    }

    @JsonProperty("attributes")
    attributes attributes;


    @JsonProperty("Id")
    public String Id;

    @JsonProperty("Account_Balance__c")
    private String accountBalance;

    @JsonProperty("Portal_Balance__c")
    private String portalBalance;

    @JsonProperty("Name")
    private String Name;

    @JsonProperty("Contact.Name")
    private String name;

    @JsonProperty("Arabic_Account_Name__c")
    private String arabicAccountName;

    @JsonProperty("License_Number_Formula__c")
    private String licenseNumberFormula;

    @JsonProperty("BillingCity")
    private String billingCity;

    @JsonProperty("Company_Registration_Date__c")
    private String companyRegistrationDate;

    @JsonProperty("Legal_Form__c")
    private String legalForm;

    @JsonProperty("Registration_Number_Value__c")
    private String registrationNumberValue;

    @JsonProperty("Phone")
    private String Phone;

    @JsonProperty("Fax")
    private String Fax;

    @JsonProperty("Email__c")
    private String Email;

    @JsonProperty("Mobile__c")
    private String Mobile;

    @JsonProperty("PRO_Email__c")
    private String proEmail;

    @JsonProperty("PRO_Mobile_Number__c")
    private String ProMobileNumber;

    @JsonProperty("BillingStreet")
    private String BillingStreet;

    @JsonProperty("BillingPostalCode")
    private String BillingPostalCode;

    @JsonProperty("BillingCountry")
    private String BillingCountry;

    @JsonProperty("BillingState")
    private String BillingState;

    @JsonProperty("Company_Logo__c")
    private String Company_Logo;

    public String getCompany_Logo() {
        return Company_Logo;
    }

    public void setCompany_Logo(String company_Logo) {
        Company_Logo = company_Logo;
    }
    @JsonProperty("Current_License_Number__r")
    private CurrentLicenseNumber _currentLicenseNumber;

    public String getID() {
        return Id;
    }

    public void setID(String Id) {
        this.Id = Id;
    }

    public String getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(String accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getPortalBalance() {
        return portalBalance;
    }

    public void setPortalBalance(String portalBalance) {
        this.portalBalance = portalBalance;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getArabicAccountName() {
        return arabicAccountName;
    }

    public void setArabicAccountName(String arabicAccountName) {
        this.arabicAccountName = arabicAccountName;
    }

    public String getLicenseNumberFormula() {
        return licenseNumberFormula;
    }

    public void setLicenseNumberFormula(String licenseNumberFormula) {
        this.licenseNumberFormula = licenseNumberFormula;
    }

    public String getBillingCity() {
        return billingCity;
    }

    public void setBillingCity(String billingCity) {
        this.billingCity = billingCity;
    }

    public String getCompanyRegistrationDate() {
        return companyRegistrationDate;
    }

    public void setCompanyRegistrationDate(String companyRegistrationDate) {
        this.companyRegistrationDate = companyRegistrationDate;
    }

    public String getLegalForm() {
        return legalForm;
    }

    public void setLegalForm(String legalForm) {
        this.legalForm = legalForm;
    }

    public String getRegistrationNumberValue() {
        return registrationNumberValue;
    }

    public void setRegistrationNumberValue(String registrationNumberValue) {
        this.registrationNumberValue = registrationNumberValue;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getFax() {
        return Fax;
    }

    public void setFax(String fax) {
        Fax = fax;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public String getProEmail() {
        return proEmail;
    }

    public void setProEmail(String proEmail) {
        this.proEmail = proEmail;
    }

    public String getProMobileNumber() {
        return ProMobileNumber;
    }

    public void setProMobileNumber(String mobileNumber) {
        ProMobileNumber = mobileNumber;
    }

    public String getBillingStreet() {
        return BillingStreet;
    }

    public void setBillingStreet(String billingStreet) {
        BillingStreet = billingStreet;
    }

    public String getBillingPostalCode() {
        return BillingPostalCode;
    }

    public void setBillingPostalCode(String billingPostalCode) {
        BillingPostalCode = billingPostalCode;
    }

    public String getBillingCountry() {
        return BillingCountry;
    }

    public void setBillingCountry(String billingCountry) {
        BillingCountry = billingCountry;
    }

    public String getBillingState() {
        return BillingState;
    }

    public void setBillingState(String billingState) {
        BillingState = billingState;
    }

    public CurrentLicenseNumber get_currentLicenseNumber() {
        return _currentLicenseNumber;
    }

    public void set_currentLicenseNumber(CurrentLicenseNumber _currentLicenseNumber) {
        this._currentLicenseNumber = _currentLicenseNumber;
    }
}