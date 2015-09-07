package model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Abanoub on 6/25/2015.
 */
public class MyVisa {

    @SerializedName("url")
    String url;

    @SerializedName("Id")
    String ID;

    @SerializedName("Employee_ID__c")
    String EmployeeID;

    @SerializedName("Personal_Photo__c")
    String PersonalPhoto;

    @SerializedName("Salutation_Arabic__c")
    String SalutationArabic;

    @SerializedName("Applicant_Middle_Name_Arabic__c")
    String Applicant_Middle_Name_Arabic_;

    @SerializedName("Applicant_First_Name_Arabic__c")
    String Applicant_First_Name_Arabic;

    @SerializedName("Religion__c")
    String Religion;

    @SerializedName("Applicant_Email__c")
    String Email;

    @SerializedName("Applicant_Mobile_Number__c")
    String MobileNumber;

    @SerializedName("Applicant_Gender__c")
    String Gender;

    @SerializedName("Passport_Country__c")
    String Country;

    @SerializedName("Passport_Number__c")
    String PassportNumber;

    @SerializedName("Passport_Expiry__c")
    String PassportExpiry;

    @SerializedName("Date_of_Birth__c")
    String DateOfBirth;

    @SerializedName("Salutation__c")
    String Salutation;

    @SerializedName("Visa_Type__c")
    String VisaType;

    @SerializedName("Visa_Expiry_Date__c")
    String VisaExpiryDate;

    @SerializedName("Applicant_Full_Name__c")
    String ApplicationFullName;

    @SerializedName("Visa_Validity_Status__c")
    String VisaValidityStatus;

    @SerializedName("Accompanied_By__c")
    String Accompanied_By;

    @SerializedName("Visit_Visa_Duration__c")
    String Visit_Visa_Duration;

    @SerializedName("Sponsoring_Company__c")
    String Sponsoring_Company;

    @SerializedName("Visa_Holder__c")
    String VisaHolder;

    CountryofBirth _countryOfBirth;
    CurrentNationality _currentNationality;
    JobTitleAtImmigration _jobTitleImigration;
    SponsoringCompany _sponsoringCompany;
    VisaHolder _visaHolder;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(String employeeID) {
        EmployeeID = employeeID;
    }

    public String getPersonalPhoto() {
        return PersonalPhoto;
    }

    public void setPersonalPhoto(String personalPhoto) {
        PersonalPhoto = personalPhoto;
    }

    public String getSalutationArabic() {
        return SalutationArabic;
    }

    public void setSalutationArabic(String salutationArabic) {
        SalutationArabic = salutationArabic;
    }

    public String getApplicant_Middle_Name_Arabic_() {
        return Applicant_Middle_Name_Arabic_;
    }

    public void setApplicant_Middle_Name_Arabic_(String applicant_Middle_Name_Arabic_) {
        Applicant_Middle_Name_Arabic_ = applicant_Middle_Name_Arabic_;
    }

    public String getApplicant_First_Name_Arabic() {
        return Applicant_First_Name_Arabic;
    }

    public void setApplicant_First_Name_Arabic(String applicant_First_Name_Arabic) {
        Applicant_First_Name_Arabic = applicant_First_Name_Arabic;
    }

    public String getReligion() {
        return Religion;
    }

    public void setReligion(String religion) {
        Religion = religion;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getMobileNumber() {
        return MobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        MobileNumber = mobileNumber;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getPassportNumber() {
        return PassportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        PassportNumber = passportNumber;
    }

    public String getPassportExpiry() {
        return PassportExpiry;
    }

    public void setPassportExpiry(String passportExpiry) {
        PassportExpiry = passportExpiry;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public String getSalutation() {
        return Salutation;
    }

    public void setSalutation(String salutation) {
        Salutation = salutation;
    }

    public String getVisaType() {
        return VisaType;
    }

    public void setVisaType(String visaType) {
        VisaType = visaType;
    }

    public String getVisaExpiryDate() {
        return VisaExpiryDate;
    }

    public void setVisaExpiryDate(String visaExpiryDate) {
        VisaExpiryDate = visaExpiryDate;
    }

    public String getApplicationFullName() {
        return ApplicationFullName;
    }

    public void setApplicationFullName(String applicationFullName) {
        ApplicationFullName = applicationFullName;
    }

    public String getVisaValidityStatus() {
        return VisaValidityStatus;
    }

    public void setVisaValidityStatus(String visaValidityStatus) {
        VisaValidityStatus = visaValidityStatus;
    }

    public String getAccompanied_By() {
        return Accompanied_By;
    }

    public void setAccompanied_By(String accompanied_By) {
        Accompanied_By = accompanied_By;
    }

    public String getVisit_Visa_Duration() {
        return Visit_Visa_Duration;
    }

    public void setVisit_Visa_Duration(String visit_Visa_Duration) {
        Visit_Visa_Duration = visit_Visa_Duration;
    }

    public String getSponsoring_Company() {
        return Sponsoring_Company;
    }

    public void setSponsoring_Company(String sponsoring_Company) {
        Sponsoring_Company = sponsoring_Company;
    }

    public String getVisaHolder() {
        return VisaHolder;
    }

    public void setVisaHolder(String visaHolder) {
        VisaHolder = visaHolder;
    }

    public CountryofBirth get_countryOfBirth() {
        return _countryOfBirth;
    }

    public void set_countryOfBirth(CountryofBirth _countryOfBirth) {
        this._countryOfBirth = _countryOfBirth;
    }

    public CurrentNationality get_currentNationality() {
        return _currentNationality;
    }

    public void set_currentNationality(CurrentNationality _currentNationality) {
        this._currentNationality = _currentNationality;
    }

    public JobTitleAtImmigration get_jobTitleImigration() {
        return _jobTitleImigration;
    }

    public void set_jobTitleImigration(JobTitleAtImmigration _jobTitleImigration) {
        this._jobTitleImigration = _jobTitleImigration;
    }

    public SponsoringCompany get_sponsoringCompany() {
        return _sponsoringCompany;
    }

    public void set_sponsoringCompany(SponsoringCompany _sponsoringCompany) {
        this._sponsoringCompany = _sponsoringCompany;
    }

    public model.VisaHolder get_visaHolder() {
        return _visaHolder;
    }

    public void set_visaHolder(model.VisaHolder _visaHolder) {
        this._visaHolder = _visaHolder;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
