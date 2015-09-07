package model;


import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;

/**
 * Created by Abanoub on 6/25/2015.
 */
public class Visa implements Serializable {

    public model.attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(model.attributes attributes) {
        this.attributes = attributes;
    }

    @JsonProperty("attributes")
    attributes attributes;


    @JsonProperty("Passport__r")
    private CurrentPassport Passport__r;

    @JsonProperty("Id")
    String ID;


    @JsonProperty("Applicant_Full_Name_Arabic__c")
    String Applicant_Full_Name_Arabic__c;
    @JsonProperty("Employee_ID__c")
    String Employee_ID__c;

    @JsonProperty("Personal_Photo__c")
    String Personal_Photo__c;

    @JsonProperty("Salutation_Arabic__c")
    String Salutation_Arabic__c;

    @JsonProperty("Applicant_Last_Name_Arabic__c")
    String Applicant_Last_Name_Arabic__c;

    @JsonProperty("Applicant_Middle_Name_Arabic__c")
    String Applicant_Middle_Name_Arabic__c;

    @JsonProperty("Applicant_First_Name_Arabic__c")
    String Applicant_First_Name_Arabic__c;

    @JsonProperty("Name")
    String Name;

    @JsonProperty("Religion__c")
    String Religion__c;

    @JsonProperty("Applicant_Email__c")
    String Applicant_Email__c;
    @JsonProperty("Current_Nationality__c")
    public String Current_Nationality__c;

    public String getCurrent_Nationality__c() {
        return Current_Nationality__c;
    }

    public void setCurrent_Nationality__c(String current_Nationality__c) {
        Current_Nationality__c = current_Nationality__c;
    }

    @JsonProperty("Applicant_Mobile_Number__c")
    String Applicant_Mobile_Number__c;

    @JsonProperty("Applicant_Gender__c")
    String Applicant_Gender__c;

    public CurrentNationality getPassport_Place_of_Issue__r() {
        return Passport_Place_of_Issue__r;
    }

    public void setPassport_Place_of_Issue__r(CurrentNationality passport_Place_of_Issue__r) {
        Passport_Place_of_Issue__r = passport_Place_of_Issue__r;
    }

    @JsonProperty("Passport_Place_of_Issue__r")
    public CurrentNationality Passport_Place_of_Issue__r;
    @JsonProperty("Passport_Country__c")
    String Passport_Country__c;

    @JsonProperty("Passport_Number__c")
    String Passport_Number__c;

    @JsonProperty("Passport_Expiry__c")
    String Passport_Expiry__c;

    @JsonProperty("Date_of_Birth__c")
    String Date_of_Birth__c;

    @JsonProperty("Salutation__c")
    String Salutation__c;

    @JsonProperty("Visa_Type__c")
    String Visa_Type__c;

    @JsonProperty("Visa_Expiry_Date__c")
    String Visa_Expiry_Date__c;

    @JsonProperty("Applicant_Full_Name__c")
    String Applicant_Full_Name__c;

    @JsonProperty("Visa_Validity_Status__c")
    String Visa_Validity_Status__c;

    @JsonProperty("Accompanied_By__c")
    String Accompanied_By__c;

    @JsonProperty("Visit_Visa_Duration__c")
    String Visit_Visa_Duration__c;

    @JsonProperty("Sponsoring_Company__c")
    String Sponsoring_Company__c;
    @JsonProperty("Urgent_Processing_Paid__c")
    public boolean urgent_Processing_Paid__c;
    @JsonProperty("Qualification__c")
    public String Qualification__c;
    @JsonProperty("Visa_Holder__c")
    String Visa_Holder__c;

    public JobTitleAtImmigration getQualification__r() {
        return qualification__r;
    }

    public void setQualification__r(JobTitleAtImmigration qualification__r) {
        this.qualification__r = qualification__r;
    }

    @JsonProperty("Qualification__r")
    public JobTitleAtImmigration qualification__r;
    @JsonProperty("Renewal_for_Visa__c")
    public String Renewal_for_Visa__c;
    @JsonProperty("Previous_Nationality__c")
    public String previous_Nationality__c;
    @JsonProperty("Place_of_Birth__c")
    public String place_of_Birth__c;
    @JsonProperty("Passport_Place_of_Issue__c")
    public String Passport_Place_of_Issue__c;
    @JsonProperty("Marital_Status__c")
    public String Marital_Status__c;
    @JsonProperty("Country_of_Birth__c")
    public String Country_of_Birth__c;

    public String getCountry_of_Birth__c() {
        return Country_of_Birth__c;
    }

    public void setCountry_of_Birth__c(String country_of_Birth__c) {
        Country_of_Birth__c = country_of_Birth__c;
    }

    public String getPassport_Issue_Country__c() {
        return passport_Issue_Country__c;
    }

    public void setPassport_Issue_Country__c(String passport_Issue_Country__c) {
        this.passport_Issue_Country__c = passport_Issue_Country__c;
    }

    @JsonProperty("Passport_Issue_Country__c")
    public String passport_Issue_Country__c;

    public String getPrevious_Nationality__c() {
        return previous_Nationality__c;
    }


    public void setPrevious_Nationality__c(String previous_Nationality__c) {
        this.previous_Nationality__c = previous_Nationality__c;
    }

    public String getPlace_of_Birth__c() {
        return place_of_Birth__c;
    }

    public void setPlace_of_Birth__c(String place_of_Birth__c) {
        this.place_of_Birth__c = place_of_Birth__c;
    }
    public String oldPass;

    public String getOldPass() {
        return oldPass;
    }

    public void setOldPass(String oldPass) {
        this.oldPass = oldPass;
    }

    @JsonProperty("Urgent_Stamping_Paid__c")
    public boolean Urgent_Stamping_Paid__c=false;
    @JsonProperty("Monthly_Allowances_in_AED__c")
    public double monthly_Allowances_in_AED__c;
    @JsonProperty("Monthly_Basic_Salary_in_AED__c")
    public double monthly_Basic_Salary_in_AED__c;
    @JsonProperty("Mother_Name__c")
    public String Mother_Name__c;
    @JsonProperty("Country_of_Birth__r")
    CountryofBirth Country_of_Birth__r;
    @JsonProperty("Local_Amendment_Paid__c")
    public boolean Local_Amendment_Paid__c;

    public String getLanguages__c() {
        return languages__c;
    }

    public void setLanguages__c(String languages__c) {
        this.languages__c = languages__c;
    }

    public String getMother_Name__c() {
        return Mother_Name__c;
    }

    public void setMother_Name__c(String mother_Name__c) {
        Mother_Name__c = mother_Name__c;
    }

    public double getMonthly_Basic_Salary_in_AED__c() {
        return monthly_Basic_Salary_in_AED__c;
    }

    public void setMonthly_Basic_Salary_in_AED__c(double monthly_Basic_Salary_in_AED__c) {
        this.monthly_Basic_Salary_in_AED__c = monthly_Basic_Salary_in_AED__c;
    }

    public double getMonthly_Allowances_in_AED__c() {
        return monthly_Allowances_in_AED__c;
    }

    public void setMonthly_Allowances_in_AED__c(double monthly_Allowances_in_AED__c) {
        this.monthly_Allowances_in_AED__c = monthly_Allowances_in_AED__c;
    }

    public String getMarital_Status__c() {
        return Marital_Status__c;
    }

    public void setMarital_Status__c(String marital_Status__c) {
        Marital_Status__c = marital_Status__c;
    }

    public String getPassport_Place_of_Issue__c() {
        return Passport_Place_of_Issue__c;
    }

    public void setPassport_Place_of_Issue__c(String passport_Place_of_Issue__c) {
        Passport_Place_of_Issue__c = passport_Place_of_Issue__c;
    }

    public String getQualification__c() {
        return Qualification__c;
    }

    public void setQualification__c(String qualification__c) {
        Qualification__c = qualification__c;
    }

    public String getRenewal_for_Visa__c() {
        return Renewal_for_Visa__c;
    }

    public void setRenewal_for_Visa__c(String renewal_for_Visa__c) {
        Renewal_for_Visa__c = renewal_for_Visa__c;
    }

    @JsonProperty("Current_Nationality__r")
    CurrentNationality Current_Nationality__r;

    public CurrentNationality getPassport_Issue_Country__r() {
        return Passport_Issue_Country__r;
    }

    public void setPassport_Issue_Country__r(CurrentNationality passport_Issue_Country__r) {
        Passport_Issue_Country__r = passport_Issue_Country__r;
    }

    public String getRecord_Type_Name__c() {
        return Record_Type_Name__c;
    }

    public void setRecord_Type_Name__c(String record_Type_Name__c) {
        Record_Type_Name__c = record_Type_Name__c;
    }

    @JsonProperty("Record_Type_Name__c")
    public String Record_Type_Name__c;

    public String getResidency_File_Number__c() {
        return Residency_File_Number__c;
    }

    public void setResidency_File_Number__c(String residency_File_Number__c) {
        Residency_File_Number__c = residency_File_Number__c;
    }

    @JsonProperty("Residency_File_Number__c")
    String Residency_File_Number__c;
    @JsonProperty("Passport_Issue_Country__r")
    CurrentNationality Passport_Issue_Country__r;
    public CurrentNationality getPrevious_Nationality__r() {
        return previous_Nationality__r;
    }

    public void setPrevious_Nationality__r(CurrentNationality previous_Nationality__r) {
        this.previous_Nationality__r = previous_Nationality__r;
    }

    @JsonProperty("Previous_Nationality__r")
    CurrentNationality previous_Nationality__r;
    @JsonProperty("Languages__c")
    public String languages__c;
    @JsonProperty("Job_Title_at_Immigration__r")
    JobTitleAtImmigration Job_Title_at_Immigration__r;
    @JsonProperty("In_Country_Paid__c")
    public boolean in_Country_Paid__c;
    @JsonProperty("Sponsoring_Company__r")
    SponsoringCompany Sponsoring_Company__r;

    @JsonProperty("Visa_Holder__r")
    VisaHolder Visa_Holder__r;

    public CurrentPassport getPassport__r() {
        return Passport__r;
    }

    public void setPassport__r(CurrentPassport passport__r) {
        Passport__r = passport__r;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getApplicant_Full_Name_Arabic__c() {
        return Applicant_Full_Name_Arabic__c;
    }

    public void setApplicant_Full_Name_Arabic__c(String applicant_Full_Name_Arabic__c) {
        Applicant_Full_Name_Arabic__c = applicant_Full_Name_Arabic__c;
    }

    public String getEmployee_ID__c() {
        return Employee_ID__c;
    }

    public void setEmployee_ID__c(String employee_ID__c) {
        Employee_ID__c = employee_ID__c;
    }

    public String getPersonal_Photo__c() {
        return Personal_Photo__c;
    }

    public void setPersonal_Photo__c(String personal_Photo__c) {
        Personal_Photo__c = personal_Photo__c;
    }

    public String getSalutation_Arabic__c() {
        return Salutation_Arabic__c;
    }

    public void setSalutation_Arabic__c(String salutation_Arabic__c) {
        Salutation_Arabic__c = salutation_Arabic__c;
    }

    public String getApplicant_Last_Name_Arabic__c() {
        return Applicant_Last_Name_Arabic__c;
    }

    public void setApplicant_Last_Name_Arabic__c(String applicant_Last_Name_Arabic__c) {
        Applicant_Last_Name_Arabic__c = applicant_Last_Name_Arabic__c;
    }

    public String getApplicant_Middle_Name_Arabic__c() {
        return Applicant_Middle_Name_Arabic__c;
    }

    public void setApplicant_Middle_Name_Arabic__c(String applicant_Middle_Name_Arabic__c) {
        Applicant_Middle_Name_Arabic__c = applicant_Middle_Name_Arabic__c;
    }

    public String getApplicant_First_Name_Arabic__c() {
        return Applicant_First_Name_Arabic__c;
    }

    public void setApplicant_First_Name_Arabic__c(String applicant_First_Name_Arabic__c) {
        Applicant_First_Name_Arabic__c = applicant_First_Name_Arabic__c;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getReligion__c() {
        return Religion__c;
    }

    public void setReligion__c(String religion__c) {
        Religion__c = religion__c;
    }

    public String getApplicant_Email__c() {
        return Applicant_Email__c;
    }

    public void setApplicant_Email__c(String applicant_Email__c) {
        Applicant_Email__c = applicant_Email__c;
    }

    public String getApplicant_Mobile_Number__c() {
        return Applicant_Mobile_Number__c;
    }

    public void setApplicant_Mobile_Number__c(String applicant_Mobile_Number__c) {
        Applicant_Mobile_Number__c = applicant_Mobile_Number__c;
    }

    public String getApplicant_Gender__c() {
        return Applicant_Gender__c;
    }

    public void setApplicant_Gender__c(String applicant_Gender__c) {
        Applicant_Gender__c = applicant_Gender__c;
    }

    public String getPassport_Country__c() {
        return Passport_Country__c;
    }

    public void setPassport_Country__c(String passport_Country__c) {
        Passport_Country__c = passport_Country__c;
    }

    public String getPassport_Number__c() {
        return Passport_Number__c;
    }

    public void setPassport_Number__c(String passport_Number__c) {
        Passport_Number__c = passport_Number__c;
    }

    public String getPassport_Expiry__c() {
        return Passport_Expiry__c;
    }

    public void setPassport_Expiry__c(String passport_Expiry__c) {
        Passport_Expiry__c = passport_Expiry__c;
    }

    public String getDate_of_Birth__c() {
        return Date_of_Birth__c;
    }

    public void setDate_of_Birth__c(String date_of_Birth__c) {
        Date_of_Birth__c = date_of_Birth__c;
    }

    public String getSalutation__c() {
        return Salutation__c;
    }

    public void setSalutation__c(String salutation__c) {
        Salutation__c = salutation__c;
    }

    public String getVisa_Type__c() {
        return Visa_Type__c;
    }

    public void setVisa_Type__c(String visa_Type__c) {
        Visa_Type__c = visa_Type__c;
    }

    public String getVisa_Expiry_Date__c() {
        return Visa_Expiry_Date__c;
    }

    public void setVisa_Expiry_Date__c(String visa_Expiry_Date__c) {
        Visa_Expiry_Date__c = visa_Expiry_Date__c;
    }

    public String getApplicant_Full_Name__c() {
        return Applicant_Full_Name__c;
    }

    public void setApplicant_Full_Name__c(String applicant_Full_Name__c) {
        Applicant_Full_Name__c = applicant_Full_Name__c;
    }

    public String getVisa_Validity_Status__c() {
        return Visa_Validity_Status__c;
    }

    public void setVisa_Validity_Status__c(String visa_Validity_Status__c) {
        Visa_Validity_Status__c = visa_Validity_Status__c;
    }

    public String getAccompanied_By__c() {
        return Accompanied_By__c;
    }

    public void setAccompanied_By__c(String accompanied_By__c) {
        Accompanied_By__c = accompanied_By__c;
    }

    public String getVisit_Visa_Duration__c() {
        return Visit_Visa_Duration__c;
    }

    public void setVisit_Visa_Duration__c(String visit_Visa_Duration__c) {
        Visit_Visa_Duration__c = visit_Visa_Duration__c;
    }

    public String getSponsoring_Company__c() {
        return Sponsoring_Company__c;
    }

    public void setSponsoring_Company__c(String sponsoring_Company__c) {
        Sponsoring_Company__c = sponsoring_Company__c;
    }

    public String getVisa_Holder__c() {
        return Visa_Holder__c;
    }

    public void setVisa_Holder__c(String visa_Holder__c) {
        Visa_Holder__c = visa_Holder__c;
    }

    public CountryofBirth getCountry_of_Birth__r() {
        return Country_of_Birth__r;
    }

    public void setCountry_of_Birth__r(CountryofBirth country_of_Birth__r) {
        Country_of_Birth__r = country_of_Birth__r;
    }

    public CurrentNationality getCurrent_Nationality__r() {
        return Current_Nationality__r;
    }

    public void setCurrent_Nationality__r(CurrentNationality current_Nationality__r) {
        Current_Nationality__r = current_Nationality__r;
    }

    public JobTitleAtImmigration getJob_Title_at_Immigration__r() {
        return Job_Title_at_Immigration__r;
    }

    public void setJob_Title_at_Immigration__r(JobTitleAtImmigration job_Title_at_Immigration__r) {
        Job_Title_at_Immigration__r = job_Title_at_Immigration__r;
    }

    public SponsoringCompany getSponsoring_Company__r() {
        return Sponsoring_Company__r;
    }

    public void setSponsoring_Company__r(SponsoringCompany sponsoring_Company__r) {
        Sponsoring_Company__r = sponsoring_Company__r;
    }

    public VisaHolder getVisa_Holder__r() {
        return Visa_Holder__r;
    }

    public void setVisa_Holder__r(VisaHolder visa_Holder__r) {
        Visa_Holder__r = visa_Holder__r;
    }
}