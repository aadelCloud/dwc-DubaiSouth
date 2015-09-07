/**
 * NOC__c.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package model;

import org.codehaus.jackson.annotate.JsonProperty;

public class NOC__c  extends SObject  implements java.io.Serializable {

    @JsonProperty("Account_License_Approval_Status__c")
    public String account_License_Approval_Status__c;
    @JsonProperty("ActivityHistories")
    public QueryResult activityHistories;
    @JsonProperty("Application_Status__c")
    public String application_Status__c;
    @JsonProperty("Application_Tracking__r")
    public QueryResult application_Tracking__r;
    @JsonProperty("Aramex_Shipping_Details__r")
    public QueryResult aramex_Shipping_Details__r;
    @JsonProperty("AttachedContentDocuments")
    public QueryResult attachedContentDocuments;
    @JsonProperty("Attachments")
    public QueryResult attachments;
    @JsonProperty("Authority_Address__c")
    public String authority_Address__c;
    @JsonProperty("Authority_Details__c")
    public String authority_Details__c;
    @JsonProperty("Authority__c")
    public String authority__c;
    @JsonProperty("Bank__c")
    public String bank__c;
    @JsonProperty("Cases__r")
    public QueryResult cases__r;
    @JsonProperty("Collected_By__c")
    public String collected_By__c;
    @JsonProperty("Collection_Date__c")
    public java.util.Date collection_Date__c;
    @JsonProperty("CombinedAttachments")
    public QueryResult combinedAttachments;
    @JsonProperty("Company_Documents__r")
    public QueryResult company_Documents__r;
    @JsonProperty("Company_License_Number__c")
    public String company_License_Number__c;
    @JsonProperty("Consulate__c")
    public String consulate__c;
    @JsonProperty("CreatedBy")
    public User createdBy;
    @JsonProperty("CreatedById")
    public String createdById;
    @JsonProperty("CreatedDate")
    public java.util.Calendar createdDate;
    @JsonProperty("CurrencyIsoCode")
    public String currencyIsoCode;
    @JsonProperty("Current_Full_Name_Arabic__c")
    public String current_Full_Name_Arabic__c;
    @JsonProperty("Current_Sponsor__c")
    public String current_Sponsor__c;
    @JsonProperty("Current_Sponsor__r")
    public Account current_Sponsor__r;
    @JsonProperty("Current_Visa__c")
    public String current_Visa__c;
    @JsonProperty("Current_Visa__r")
    public Visa current_Visa__r;
    @JsonProperty("Customer_Transactions__r")
    public QueryResult customer_Transactions__r;
    @JsonProperty("Date_of_Joining__c")
    public java.util.Date date_of_Joining__c;
    @JsonProperty("Deployment_ID__c")
    public String deployment_ID__c;
    @JsonProperty("Document_Name__c")
    public String document_Name__c;
    @JsonProperty("Drawloop_Next2__c")
    public String drawloop_Next2__c;
    @JsonProperty("Drawloop_Next__c")
    public String drawloop_Next__c;
    @JsonProperty("DuplicateRecordItems")
    public QueryResult duplicateRecordItems;
    @JsonProperty("Embassy__c")
    public String embassy__c;
    @JsonProperty("Establishment_Card_Number__c")
    public String establishment_Card_Number__c;
    @JsonProperty("Events")
    public QueryResult events;
    @JsonProperty("Expiry_Date__c")
    public java.util.Date expiry_Date__c;
    @JsonProperty("FeedSubscriptionsForEntity")
    public QueryResult feedSubscriptionsForEntity;
    @JsonProperty("Full_Name_Arabic__c")
    public String full_Name_Arabic__c;
    @JsonProperty("Full_Name__c")
    public String full_Name__c;
    @JsonProperty("Gender__c")
    public String gender__c;
    @JsonProperty("Histories")
    public QueryResult histories;
    @JsonProperty("Invoices__r")
    public QueryResult invoices__r;
    @JsonProperty("isDeleted")
    public boolean isDeleted;
    @JsonProperty("Issue_Date__c")
    public java.util.Date issue_Date__c;
    @JsonProperty("Job_Title_Arabic__c")
    public String job_Title_Arabic__c;



    @JsonProperty("Job_Title__c")
    public String job_Title__c;
    @JsonProperty("LastActivityDate")
    public java.util.Date lastActivityDate;
    @JsonProperty("LastModifiedBy")
    public User lastModifiedBy;
    @JsonProperty("LastModifiedById")
    public String lastModifiedById;
    @JsonProperty("LastModifiedDate")
    public java.util.Calendar lastModifiedDate;
    @JsonProperty("LookedUpFromActivities")
    public QueryResult lookedUpFromActivities;
    @JsonProperty("loop_Generated__c")
    public boolean loop_Generated__c;

    @JsonProperty("Loop_ID__c")
    public String loop_ID__c;
    @JsonProperty("Monthly_Allowances_in_AED__c")
    public double monthly_Allowances_in_AED__c;
    @JsonProperty("Monthly_Basic_Salary_in_AED__c")
    public double monthly_Basic_Salary_in_AED__c;
    @JsonProperty("NOC_Approval_Date__c")
    public java.util.Date NOC_Approval_Date__c;
    @JsonProperty("NOC_Approval_Status__c")
    public String NOC_Approval_Status__c;
    @JsonProperty("NOC_Authority_Address__c")
    public String NOC_Authority_Address__c;
    @JsonProperty("NOC_Authority__c")
    public String NOC_Authority__c;
    @JsonProperty("NOC_Date__c")
    public String NOC_Date__c;
    @JsonProperty("NOC_Language__c")
    public String NOC_Language__c;
    @JsonProperty("NOC_Receiver_Email__c")
    public String NOC_Receiver_Email__c;
    @JsonProperty("NOC_Template__c")
    public String NOC_Template__c;
    @JsonProperty("NOC_Type__c")
    public String NOC_Type__c;
    @JsonProperty("NOC_Vehicle_Type__c")
    public String NOC_Vehicle_Type__c;
    @JsonProperty("name")
    public String name;
    @JsonProperty("Nationality_Arabic__c")
    public String nationality_Arabic__c;
    @JsonProperty("need_a_Stamp_Copy__c")
    public boolean need_a_Stamp_Copy__c;
    @JsonProperty("New_First_Name_Arabic__c")
    public String new_First_Name_Arabic__c;
    @JsonProperty("New_First_Name__c")
    public String new_First_Name__c;
    @JsonProperty("New_Job_Title_Arabic__c")
    public String new_Job_Title_Arabic__c;
    @JsonProperty("New_Job_Title__c")
    public String new_Job_Title__c;
    @JsonProperty("New_Last_Name_Arabic__c")
    public String new_Last_Name_Arabic__c;
    @JsonProperty("New_Last_Name__c")
    public String new_Last_Name__c;
    @JsonProperty("New_Middle_Name_Arabic__c")
    public String new_Middle_Name_Arabic__c;
    @JsonProperty("New_Middle_Name__c")
    public String new_Middle_Name__c;
    @JsonProperty("New_Nationality_Arabic__c")
    public String new_Nationality_Arabic__c;
    @JsonProperty("New_Nationality__c")
    public String new_Nationality__c;
    @JsonProperty("New_Nationality__r")
    public CurrentNationality new_Nationality__r;
    @JsonProperty("New_Passport_Number__c")
    public String new_Passport_Number__c;

    public QueryResult notes;
    @JsonProperty("notesAndAttachments")
    public QueryResult notesAndAttachments;
    @JsonProperty("Old_Company_Name__c")
    public String old_Company_Name__c;

    public QueryResult openActivities;


    @JsonProperty("ownerId")
    public String ownerId;
    @JsonProperty("Passport_Country_Arabic__c")
    public String passport_Country_Arabic__c;
    @JsonProperty("Passport_Country__c")
    public String passport_Country__c;
    @JsonProperty("Passport_Number__c")
    public String passport_Number__c;
    @JsonProperty("Person_Job_Title__c")
    public String person_Job_Title__c;
    @JsonProperty("Person_Name__c")
    public String person_Name__c;
    @JsonProperty("Person_Nationality__c")
    public String person_Nationality__c;
    @JsonProperty("Person_Passport__c")
    public String person_Passport__c;
    @JsonProperty("Person_Sponsor_Company_Name__c")
    public String person_Sponsor_Company_Name__c;
    @JsonProperty("Person__c")
    public String person__c;
    @JsonProperty("Person__r")
    public Account person__r;

    public QueryResult processInstances;

    public QueryResult processSteps;
    @JsonProperty("QR_Code__c")
    public String QR_Code__c;

    public QueryResult receipts__r;

    public QueryResult recordAssociatedGroups;
    @JsonProperty("RecordType")
    public RecordType recordType;
    @JsonProperty("recordTypeId")
    public String recordTypeId;
    @JsonProperty("Record_Type_Name__c")
    public String record_Type_Name__c;
    @JsonProperty("Request__c")
    public String request__c;
    @JsonProperty("Request__r")
    public Case request__r;
    @JsonProperty("Residency_File_Number__c")
    public String residency_File_Number__c;
    @JsonProperty("Salary_Certificate_Authority__c")
    public String salary_Certificate_Authority__c;
    @JsonProperty("Service_ID__c")
    public String service_ID__c;
    @JsonProperty("Service_Name__c")
    public String service_Name__c;
    @JsonProperty("Short_Company_Name__c")
    public String short_Company_Name__c;
    @JsonProperty("Signature_Arabic_Department__c")
    public String signature_Arabic_Department__c;
    @JsonProperty("Signature_Arabic_Name__c")
    public String signature_Arabic_Name__c;
    @JsonProperty("Signature_Arabic_Title__c")
    public String signature_Arabic_Title__c;
    @JsonProperty("Signature_English_Department__c")
    public String signature_English_Department__c;

    @JsonProperty("Signature_English_Name__c")
    public String signature_English_Name__c;

    @JsonProperty("Signature_English_Title__c")
    public String signature_English_Title__c;

    @JsonProperty("Sponsor_Name_Arabic__c")
    public String sponsor_Name_Arabic__c;

    @JsonProperty("Sponsor_Name__c")
    public String sponsor_Name__c;

    @JsonProperty("stamp_Copy_issued_on_NOC__c")
    public boolean stamp_Copy_issued_on_NOC__c;

    @JsonProperty("standing_Invoices_Allowed__c")
    public boolean standing_Invoices_Allowed__c;

    @JsonProperty("SystemModstamp")
    public java.util.Calendar systemModstamp;

    public QueryResult tasks;
    @JsonProperty("To_Embassy_Of_Formula__c")
    public String to_Embassy_Of_Formula__c;
    @JsonProperty("To_Embassy_Of__c")
    public String to_Embassy_Of__c;

    @JsonProperty("TopicAssignments")
    public QueryResult topicAssignments;
    @JsonProperty("Total_Monthly_Salary_in_AED__c")
    public double total_Monthly_Salary_in_AED__c;
    @JsonProperty("Travel_Country_Arabic__c")
    public String travel_Country_Arabic__c;
    @JsonProperty("Travel_End_Date__c")
    public java.util.Date travel_End_Date__c;
    @JsonProperty("Travel_Start_Date__c")
    public java.util.Date travel_Start_Date__c;
    @JsonProperty("Travel_To__c")
    public String travel_To__c;

    @JsonProperty("Umrah_Hajj__c")
    public String umrah_Hajj__c;

    @JsonProperty("Vehicle_Chassis_Number__c")
    public String vehicle_Chassis_Number__c;
    @JsonProperty("Vehicle_Color__c")
    public String vehicle_Color__c;
    @JsonProperty("Vehicle_Country_of_Origin__c")
    public String vehicle_Country_of_Origin__c;
    @JsonProperty("Vehicle_Engine_Number__c")
    public String vehicle_Engine_Number__c;
    @JsonProperty("Vehicle_Sub_Service__c")
    public String vehicle_Sub_Service__c;
    @JsonProperty("Vehicle_Type__c")
    public String vehicle_Type__c;
    @JsonProperty("Vehicle_Year_of_Manufacture__c")
    public double vehicle_Year_of_Manufacture__c;
    @JsonProperty("Verification_Message_with_URL__c")
    public String verification_Message_with_URL__c;
    @JsonProperty("Visa_Number__c")
    public String visa_Number__c;
    @JsonProperty("Web_Form__c")
    public String web_Form__c;
    @JsonProperty("Web_Form__r")
    public Web_Form__c web_Form__r;
    @JsonProperty("EService_Type__c")
    public String eService_Type__c;
    @JsonProperty("isCollected__c")
    public boolean isCollected__c;
    @JsonProperty("isCourierRequired__c")
    public boolean isCourierRequired__c;
    @JsonProperty("SelectedServicesID__c")
    public String selectedServicesID__c;

    public NOC__c() {
    }



    /**
     * Gets the account_License_Approval_Status__c value for this NOC__c.
     * 
     * @return account_License_Approval_Status__c
     */
    public String getAccount_License_Approval_Status__c() {
        return account_License_Approval_Status__c;
    }


    /**
     * Sets the account_License_Approval_Status__c value for this NOC__c.
     * 
     * @param account_License_Approval_Status__c
     */
    public void setAccount_License_Approval_Status__c(String account_License_Approval_Status__c) {
        this.account_License_Approval_Status__c = account_License_Approval_Status__c;
    }


    /**
     * Gets the activityHistories value for this NOC__c.
     * 
     * @return activityHistories
     */
    public QueryResult getActivityHistories() {
        return activityHistories;
    }


    /**
     * Sets the activityHistories value for this NOC__c.
     * 
     * @param activityHistories
     */
    public void setActivityHistories(QueryResult activityHistories) {
        this.activityHistories = activityHistories;
    }


    /**
     * Gets the application_Status__c value for this NOC__c.
     * 
     * @return application_Status__c
     */
    public String getApplication_Status__c() {
        return application_Status__c;
    }


    /**
     * Sets the application_Status__c value for this NOC__c.
     * 
     * @param application_Status__c
     */
    public void setApplication_Status__c(String application_Status__c) {
        this.application_Status__c = application_Status__c;
    }


    /**
     * Gets the application_Tracking__r value for this NOC__c.
     * 
     * @return application_Tracking__r
     */
    public QueryResult getApplication_Tracking__r() {
        return application_Tracking__r;
    }


    /**
     * Sets the application_Tracking__r value for this NOC__c.
     * 
     * @param application_Tracking__r
     */
    public void setApplication_Tracking__r(QueryResult application_Tracking__r) {
        this.application_Tracking__r = application_Tracking__r;
    }


    /**
     * Gets the aramex_Shipping_Details__r value for this NOC__c.
     * 
     * @return aramex_Shipping_Details__r
     */
    public QueryResult getAramex_Shipping_Details__r() {
        return aramex_Shipping_Details__r;
    }


    /**
     * Sets the aramex_Shipping_Details__r value for this NOC__c.
     * 
     * @param aramex_Shipping_Details__r
     */
    public void setAramex_Shipping_Details__r(QueryResult aramex_Shipping_Details__r) {
        this.aramex_Shipping_Details__r = aramex_Shipping_Details__r;
    }


    /**
     * Gets the attachedContentDocuments value for this NOC__c.
     * 
     * @return attachedContentDocuments
     */
    public QueryResult getAttachedContentDocuments() {
        return attachedContentDocuments;
    }


    /**
     * Sets the attachedContentDocuments value for this NOC__c.
     * 
     * @param attachedContentDocuments
     */
    public void setAttachedContentDocuments(QueryResult attachedContentDocuments) {
        this.attachedContentDocuments = attachedContentDocuments;
    }


    /**
     * Gets the attachments value for this NOC__c.
     * 
     * @return attachments
     */
    public QueryResult getAttachments() {
        return attachments;
    }


    /**
     * Sets the attachments value for this NOC__c.
     * 
     * @param attachments
     */
    public void setAttachments(QueryResult attachments) {
        this.attachments = attachments;
    }


    /**
     * Gets the authority_Address__c value for this NOC__c.
     * 
     * @return authority_Address__c
     */
    public String getAuthority_Address__c() {
        return authority_Address__c;
    }


    /**
     * Sets the authority_Address__c value for this NOC__c.
     * 
     * @param authority_Address__c
     */
    public void setAuthority_Address__c(String authority_Address__c) {
        this.authority_Address__c = authority_Address__c;
    }


    /**
     * Gets the authority_Details__c value for this NOC__c.
     * 
     * @return authority_Details__c
     */
    public String getAuthority_Details__c() {
        return authority_Details__c;
    }


    /**
     * Sets the authority_Details__c value for this NOC__c.
     * 
     * @param authority_Details__c
     */
    public void setAuthority_Details__c(String authority_Details__c) {
        this.authority_Details__c = authority_Details__c;
    }


    /**
     * Gets the authority__c value for this NOC__c.
     * 
     * @return authority__c
     */
    public String getAuthority__c() {
        return authority__c;
    }


    /**
     * Sets the authority__c value for this NOC__c.
     * 
     * @param authority__c
     */
    public void setAuthority__c(String authority__c) {
        this.authority__c = authority__c;
    }


    /**
     * Gets the bank__c value for this NOC__c.
     * 
     * @return bank__c
     */
    public String getBank__c() {
        return bank__c;
    }


    /**
     * Sets the bank__c value for this NOC__c.
     * 
     * @param bank__c
     */
    public void setBank__c(String bank__c) {
        this.bank__c = bank__c;
    }


    /**
     * Gets the cases__r value for this NOC__c.
     * 
     * @return cases__r
     */
    public QueryResult getCases__r() {
        return cases__r;
    }


    /**
     * Sets the cases__r value for this NOC__c.
     * 
     * @param cases__r
     */
    public void setCases__r(QueryResult cases__r) {
        this.cases__r = cases__r;
    }


    /**
     * Gets the collected_By__c value for this NOC__c.
     * 
     * @return collected_By__c
     */
    public String getCollected_By__c() {
        return collected_By__c;
    }


    /**
     * Sets the collected_By__c value for this NOC__c.
     * 
     * @param collected_By__c
     */
    public void setCollected_By__c(String collected_By__c) {
        this.collected_By__c = collected_By__c;
    }


    /**
     * Gets the collection_Date__c value for this NOC__c.
     * 
     * @return collection_Date__c
     */
    public java.util.Date getCollection_Date__c() {
        return collection_Date__c;
    }


    /**
     * Sets the collection_Date__c value for this NOC__c.
     * 
     * @param collection_Date__c
     */
    public void setCollection_Date__c(java.util.Date collection_Date__c) {
        this.collection_Date__c = collection_Date__c;
    }


    /**
     * Gets the combinedAttachments value for this NOC__c.
     * 
     * @return combinedAttachments
     */
    public QueryResult getCombinedAttachments() {
        return combinedAttachments;
    }


    /**
     * Sets the combinedAttachments value for this NOC__c.
     * 
     * @param combinedAttachments
     */
    public void setCombinedAttachments(QueryResult combinedAttachments) {
        this.combinedAttachments = combinedAttachments;
    }


    /**
     * Gets the company_Documents__r value for this NOC__c.
     * 
     * @return company_Documents__r
     */
    public QueryResult getCompany_Documents__r() {
        return company_Documents__r;
    }


    /**
     * Sets the company_Documents__r value for this NOC__c.
     * 
     * @param company_Documents__r
     */
    public void setCompany_Documents__r(QueryResult company_Documents__r) {
        this.company_Documents__r = company_Documents__r;
    }


    /**
     * Gets the company_License_Number__c value for this NOC__c.
     * 
     * @return company_License_Number__c
     */
    public String getCompany_License_Number__c() {
        return company_License_Number__c;
    }


    /**
     * Sets the company_License_Number__c value for this NOC__c.
     * 
     * @param company_License_Number__c
     */
    public void setCompany_License_Number__c(String company_License_Number__c) {
        this.company_License_Number__c = company_License_Number__c;
    }


    /**
     * Gets the consulate__c value for this NOC__c.
     * 
     * @return consulate__c
     */
    public String getConsulate__c() {
        return consulate__c;
    }


    /**
     * Sets the consulate__c value for this NOC__c.
     * 
     * @param consulate__c
     */
    public void setConsulate__c(String consulate__c) {
        this.consulate__c = consulate__c;
    }


    /**
     * Gets the createdBy value for this NOC__c.
     * 
     * @return createdBy
     */
    public User getCreatedBy() {
        return createdBy;
    }


    /**
     * Sets the createdBy value for this NOC__c.
     * 
     * @param createdBy
     */
    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }


    /**
     * Gets the createdById value for this NOC__c.
     * 
     * @return createdById
     */
    public String getCreatedById() {
        return createdById;
    }


    /**
     * Sets the createdById value for this NOC__c.
     * 
     * @param createdById
     */
    public void setCreatedById(String createdById) {
        this.createdById = createdById;
    }


    /**
     * Gets the createdDate value for this NOC__c.
     * 
     * @return createdDate
     */
    public java.util.Calendar getCreatedDate() {
        return createdDate;
    }


    /**
     * Sets the createdDate value for this NOC__c.
     * 
     * @param createdDate
     */
    public void setCreatedDate(java.util.Calendar createdDate) {
        this.createdDate = createdDate;
    }


    /**
     * Gets the currencyIsoCode value for this NOC__c.
     * 
     * @return currencyIsoCode
     */
    public String getCurrencyIsoCode() {
        return currencyIsoCode;
    }


    /**
     * Sets the currencyIsoCode value for this NOC__c.
     * 
     * @param currencyIsoCode
     */
    public void setCurrencyIsoCode(String currencyIsoCode) {
        this.currencyIsoCode = currencyIsoCode;
    }


    /**
     * Gets the current_Full_Name_Arabic__c value for this NOC__c.
     * 
     * @return current_Full_Name_Arabic__c
     */
    public String getCurrent_Full_Name_Arabic__c() {
        return current_Full_Name_Arabic__c;
    }


    /**
     * Sets the current_Full_Name_Arabic__c value for this NOC__c.
     * 
     * @param current_Full_Name_Arabic__c
     */
    public void setCurrent_Full_Name_Arabic__c(String current_Full_Name_Arabic__c) {
        this.current_Full_Name_Arabic__c = current_Full_Name_Arabic__c;
    }


    /**
     * Gets the current_Sponsor__c value for this NOC__c.
     * 
     * @return current_Sponsor__c
     */
    public String getCurrent_Sponsor__c() {
        return current_Sponsor__c;
    }


    /**
     * Sets the current_Sponsor__c value for this NOC__c.
     * 
     * @param current_Sponsor__c
     */
    public void setCurrent_Sponsor__c(String current_Sponsor__c) {
        this.current_Sponsor__c = current_Sponsor__c;
    }


    /**
     * Gets the current_Sponsor__r value for this NOC__c.
     * 
     * @return current_Sponsor__r
     */
    public Account getCurrent_Sponsor__r() {
        return current_Sponsor__r;
    }


    /**
     * Sets the current_Sponsor__r value for this NOC__c.
     * 
     * @param current_Sponsor__r
     */
    public void setCurrent_Sponsor__r(Account current_Sponsor__r) {
        this.current_Sponsor__r = current_Sponsor__r;
    }


    /**
     * Gets the current_Visa__c value for this NOC__c.
     * 
     * @return current_Visa__c
     */
    public String getCurrent_Visa__c() {
        return current_Visa__c;
    }


    /**
     * Sets the current_Visa__c value for this NOC__c.
     * 
     * @param current_Visa__c
     */
    public void setCurrent_Visa__c(String current_Visa__c) {
        this.current_Visa__c = current_Visa__c;
    }


    /**
     * Gets the current_Visa__r value for this NOC__c.
     * 
     * @return current_Visa__r
     */
    public Visa getCurrent_Visa__r() {
        return current_Visa__r;
    }


    /**
     * Sets the current_Visa__r value for this NOC__c.
     * 
     * @param current_Visa__r
     */
    public void setCurrent_Visa__r(Visa current_Visa__r) {
        this.current_Visa__r = current_Visa__r;
    }


    /**
     * Gets the customer_Transactions__r value for this NOC__c.
     * 
     * @return customer_Transactions__r
     */
    public QueryResult getCustomer_Transactions__r() {
        return customer_Transactions__r;
    }


    /**
     * Sets the customer_Transactions__r value for this NOC__c.
     * 
     * @param customer_Transactions__r
     */
    public void setCustomer_Transactions__r(QueryResult customer_Transactions__r) {
        this.customer_Transactions__r = customer_Transactions__r;
    }


    /**
     * Gets the date_of_Joining__c value for this NOC__c.
     * 
     * @return date_of_Joining__c
     */
    public java.util.Date getDate_of_Joining__c() {
        return date_of_Joining__c;
    }


    /**
     * Sets the date_of_Joining__c value for this NOC__c.
     * 
     * @param date_of_Joining__c
     */
    public void setDate_of_Joining__c(java.util.Date date_of_Joining__c) {
        this.date_of_Joining__c = date_of_Joining__c;
    }


    /**
     * Gets the deployment_ID__c value for this NOC__c.
     * 
     * @return deployment_ID__c
     */
    public String getDeployment_ID__c() {
        return deployment_ID__c;
    }


    /**
     * Sets the deployment_ID__c value for this NOC__c.
     * 
     * @param deployment_ID__c
     */
    public void setDeployment_ID__c(String deployment_ID__c) {
        this.deployment_ID__c = deployment_ID__c;
    }


    /**
     * Gets the document_Name__c value for this NOC__c.
     * 
     * @return document_Name__c
     */
    public String getDocument_Name__c() {
        return document_Name__c;
    }


    /**
     * Sets the document_Name__c value for this NOC__c.
     * 
     * @param document_Name__c
     */
    public void setDocument_Name__c(String document_Name__c) {
        this.document_Name__c = document_Name__c;
    }


    /**
     * Gets the drawloop_Next2__c value for this NOC__c.
     * 
     * @return drawloop_Next2__c
     */
    public String getDrawloop_Next2__c() {
        return drawloop_Next2__c;
    }


    /**
     * Sets the drawloop_Next2__c value for this NOC__c.
     * 
     * @param drawloop_Next2__c
     */
    public void setDrawloop_Next2__c(String drawloop_Next2__c) {
        this.drawloop_Next2__c = drawloop_Next2__c;
    }


    /**
     * Gets the drawloop_Next__c value for this NOC__c.
     * 
     * @return drawloop_Next__c
     */
    public String getDrawloop_Next__c() {
        return drawloop_Next__c;
    }


    /**
     * Sets the drawloop_Next__c value for this NOC__c.
     * 
     * @param drawloop_Next__c
     */
    public void setDrawloop_Next__c(String drawloop_Next__c) {
        this.drawloop_Next__c = drawloop_Next__c;
    }


    /**
     * Gets the duplicateRecordItems value for this NOC__c.
     * 
     * @return duplicateRecordItems
     */
    public QueryResult getDuplicateRecordItems() {
        return duplicateRecordItems;
    }


    /**
     * Sets the duplicateRecordItems value for this NOC__c.
     * 
     * @param duplicateRecordItems
     */
    public void setDuplicateRecordItems(QueryResult duplicateRecordItems) {
        this.duplicateRecordItems = duplicateRecordItems;
    }


    /**
     * Gets the embassy__c value for this NOC__c.
     * 
     * @return embassy__c
     */
    public String getEmbassy__c() {
        return embassy__c;
    }


    /**
     * Sets the embassy__c value for this NOC__c.
     * 
     * @param embassy__c
     */
    public void setEmbassy__c(String embassy__c) {
        this.embassy__c = embassy__c;
    }


    /**
     * Gets the establishment_Card_Number__c value for this NOC__c.
     * 
     * @return establishment_Card_Number__c
     */
    public String getEstablishment_Card_Number__c() {
        return establishment_Card_Number__c;
    }


    /**
     * Sets the establishment_Card_Number__c value for this NOC__c.
     * 
     * @param establishment_Card_Number__c
     */
    public void setEstablishment_Card_Number__c(String establishment_Card_Number__c) {
        this.establishment_Card_Number__c = establishment_Card_Number__c;
    }


    /**
     * Gets the events value for this NOC__c.
     * 
     * @return events
     */
    public QueryResult getEvents() {
        return events;
    }


    /**
     * Sets the events value for this NOC__c.
     * 
     * @param events
     */
    public void setEvents(QueryResult events) {
        this.events = events;
    }


    /**
     * Gets the expiry_Date__c value for this NOC__c.
     * 
     * @return expiry_Date__c
     */
    public java.util.Date getExpiry_Date__c() {
        return expiry_Date__c;
    }


    /**
     * Sets the expiry_Date__c value for this NOC__c.
     * 
     * @param expiry_Date__c
     */
    public void setExpiry_Date__c(java.util.Date expiry_Date__c) {
        this.expiry_Date__c = expiry_Date__c;
    }


    /**
     * Gets the feedSubscriptionsForEntity value for this NOC__c.
     * 
     * @return feedSubscriptionsForEntity
     */
    public QueryResult getFeedSubscriptionsForEntity() {
        return feedSubscriptionsForEntity;
    }


    /**
     * Sets the feedSubscriptionsForEntity value for this NOC__c.
     * 
     * @param feedSubscriptionsForEntity
     */
    public void setFeedSubscriptionsForEntity(QueryResult feedSubscriptionsForEntity) {
        this.feedSubscriptionsForEntity = feedSubscriptionsForEntity;
    }


    /**
     * Gets the full_Name_Arabic__c value for this NOC__c.
     * 
     * @return full_Name_Arabic__c
     */
    public String getFull_Name_Arabic__c() {
        return full_Name_Arabic__c;
    }


    /**
     * Sets the full_Name_Arabic__c value for this NOC__c.
     * 
     * @param full_Name_Arabic__c
     */
    public void setFull_Name_Arabic__c(String full_Name_Arabic__c) {
        this.full_Name_Arabic__c = full_Name_Arabic__c;
    }


    /**
     * Gets the full_Name__c value for this NOC__c.
     * 
     * @return full_Name__c
     */
    public String getFull_Name__c() {
        return full_Name__c;
    }


    /**
     * Sets the full_Name__c value for this NOC__c.
     * 
     * @param full_Name__c
     */
    public void setFull_Name__c(String full_Name__c) {
        this.full_Name__c = full_Name__c;
    }


    /**
     * Gets the gender__c value for this NOC__c.
     * 
     * @return gender__c
     */
    public String getGender__c() {
        return gender__c;
    }


    /**
     * Sets the gender__c value for this NOC__c.
     * 
     * @param gender__c
     */
    public void setGender__c(String gender__c) {
        this.gender__c = gender__c;
    }


    /**
     * Gets the histories value for this NOC__c.
     * 
     * @return histories
     */
    public QueryResult getHistories() {
        return histories;
    }


    /**
     * Sets the histories value for this NOC__c.
     * 
     * @param histories
     */
    public void setHistories(QueryResult histories) {
        this.histories = histories;
    }


    /**
     * Gets the invoices__r value for this NOC__c.
     * 
     * @return invoices__r
     */
    public QueryResult getInvoices__r() {
        return invoices__r;
    }


    /**
     * Sets the invoices__r value for this NOC__c.
     * 
     * @param invoices__r
     */
    public void setInvoices__r(QueryResult invoices__r) {
        this.invoices__r = invoices__r;
    }


    /**
     * Gets the isDeleted value for this NOC__c.
     * 
     * @return isDeleted
     */
    public boolean getIsDeleted() {
        return isDeleted;
    }


    /**
     * Sets the isDeleted value for this NOC__c.
     * 
     * @param isDeleted
     */
    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }


    /**
     * Gets the issue_Date__c value for this NOC__c.
     * 
     * @return issue_Date__c
     */
    public java.util.Date getIssue_Date__c() {
        return issue_Date__c;
    }


    /**
     * Sets the issue_Date__c value for this NOC__c.
     * 
     * @param issue_Date__c
     */
    public void setIssue_Date__c(java.util.Date issue_Date__c) {
        this.issue_Date__c = issue_Date__c;
    }


    /**
     * Gets the job_Title_Arabic__c value for this NOC__c.
     * 
     * @return job_Title_Arabic__c
     */
    public String getJob_Title_Arabic__c() {
        return job_Title_Arabic__c;
    }


    /**
     * Sets the job_Title_Arabic__c value for this NOC__c.
     * 
     * @param job_Title_Arabic__c
     */
    public void setJob_Title_Arabic__c(String job_Title_Arabic__c) {
        this.job_Title_Arabic__c = job_Title_Arabic__c;
    }


    /**
     * Gets the job_Title__c value for this NOC__c.
     * 
     * @return job_Title__c
     */
    public String getJob_Title__c() {
        return job_Title__c;
    }


    /**
     * Sets the job_Title__c value for this NOC__c.
     * 
     * @param job_Title__c
     */
    public void setJob_Title__c(String job_Title__c) {
        this.job_Title__c = job_Title__c;
    }


    /**
     * Gets the lastActivityDate value for this NOC__c.
     * 
     * @return lastActivityDate
     */
    public java.util.Date getLastActivityDate() {
        return lastActivityDate;
    }


    /**
     * Sets the lastActivityDate value for this NOC__c.
     * 
     * @param lastActivityDate
     */
    public void setLastActivityDate(java.util.Date lastActivityDate) {
        this.lastActivityDate = lastActivityDate;
    }


    /**
     * Gets the lastModifiedBy value for this NOC__c.
     * 
     * @return lastModifiedBy
     */
    public User getLastModifiedBy() {
        return lastModifiedBy;
    }


    /**
     * Sets the lastModifiedBy value for this NOC__c.
     * 
     * @param lastModifiedBy
     */
    public void setLastModifiedBy(User lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }


    /**
     * Gets the lastModifiedById value for this NOC__c.
     * 
     * @return lastModifiedById
     */
    public String getLastModifiedById() {
        return lastModifiedById;
    }


    /**
     * Sets the lastModifiedById value for this NOC__c.
     * 
     * @param lastModifiedById
     */
    public void setLastModifiedById(String lastModifiedById) {
        this.lastModifiedById = lastModifiedById;
    }


    /**
     * Gets the lastModifiedDate value for this NOC__c.
     * 
     * @return lastModifiedDate
     */
    public java.util.Calendar getLastModifiedDate() {
        return lastModifiedDate;
    }


    /**
     * Sets the lastModifiedDate value for this NOC__c.
     * 
     * @param lastModifiedDate
     */
    public void setLastModifiedDate(java.util.Calendar lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }


    /**
     * Gets the lookedUpFromActivities value for this NOC__c.
     * 
     * @return lookedUpFromActivities
     */
    public QueryResult getLookedUpFromActivities() {
        return lookedUpFromActivities;
    }


    /**
     * Sets the lookedUpFromActivities value for this NOC__c.
     * 
     * @param lookedUpFromActivities
     */
    public void setLookedUpFromActivities(QueryResult lookedUpFromActivities) {
        this.lookedUpFromActivities = lookedUpFromActivities;
    }


    /**
     * Gets the loop_Generated__c value for this NOC__c.
     * 
     * @return loop_Generated__c
     */
    public boolean getLoop_Generated__c() {
        return loop_Generated__c;
    }


    /**
     * Sets the loop_Generated__c value for this NOC__c.
     * 
     * @param loop_Generated__c
     */
    public void setLoop_Generated__c(boolean loop_Generated__c) {
        this.loop_Generated__c = loop_Generated__c;
    }


    /**
     * Gets the loop_ID__c value for this NOC__c.
     * 
     * @return loop_ID__c
     */
    public String getLoop_ID__c() {
        return loop_ID__c;
    }


    /**
     * Sets the loop_ID__c value for this NOC__c.
     * 
     * @param loop_ID__c
     */
    public void setLoop_ID__c(String loop_ID__c) {
        this.loop_ID__c = loop_ID__c;
    }


    /**
     * Gets the monthly_Allowances_in_AED__c value for this NOC__c.
     * 
     * @return monthly_Allowances_in_AED__c
     */
    public double getMonthly_Allowances_in_AED__c() {
        return monthly_Allowances_in_AED__c;
    }


    /**
     * Sets the monthly_Allowances_in_AED__c value for this NOC__c.
     * 
     * @param monthly_Allowances_in_AED__c
     */
    public void setMonthly_Allowances_in_AED__c(double monthly_Allowances_in_AED__c) {
        this.monthly_Allowances_in_AED__c = monthly_Allowances_in_AED__c;
    }


    /**
     * Gets the monthly_Basic_Salary_in_AED__c value for this NOC__c.
     * 
     * @return monthly_Basic_Salary_in_AED__c
     */
    public double getMonthly_Basic_Salary_in_AED__c() {
        return monthly_Basic_Salary_in_AED__c;
    }


    /**
     * Sets the monthly_Basic_Salary_in_AED__c value for this NOC__c.
     * 
     * @param monthly_Basic_Salary_in_AED__c
     */
    public void setMonthly_Basic_Salary_in_AED__c(double monthly_Basic_Salary_in_AED__c) {
        this.monthly_Basic_Salary_in_AED__c = monthly_Basic_Salary_in_AED__c;
    }


    /**
     * Gets the NOC_Approval_Date__c value for this NOC__c.
     * 
     * @return NOC_Approval_Date__c
     */
    public java.util.Date getNOC_Approval_Date__c() {
        return NOC_Approval_Date__c;
    }


    /**
     * Sets the NOC_Approval_Date__c value for this NOC__c.
     * 
     * @param NOC_Approval_Date__c
     */
    public void setNOC_Approval_Date__c(java.util.Date NOC_Approval_Date__c) {
        this.NOC_Approval_Date__c = NOC_Approval_Date__c;
    }


    /**
     * Gets the NOC_Approval_Status__c value for this NOC__c.
     * 
     * @return NOC_Approval_Status__c
     */
    public String getNOC_Approval_Status__c() {
        return NOC_Approval_Status__c;
    }


    /**
     * Sets the NOC_Approval_Status__c value for this NOC__c.
     * 
     * @param NOC_Approval_Status__c
     */
    public void setNOC_Approval_Status__c(String NOC_Approval_Status__c) {
        this.NOC_Approval_Status__c = NOC_Approval_Status__c;
    }


    /**
     * Gets the NOC_Authority_Address__c value for this NOC__c.
     * 
     * @return NOC_Authority_Address__c
     */
    public String getNOC_Authority_Address__c() {
        return NOC_Authority_Address__c;
    }


    /**
     * Sets the NOC_Authority_Address__c value for this NOC__c.
     * 
     * @param NOC_Authority_Address__c
     */
    public void setNOC_Authority_Address__c(String NOC_Authority_Address__c) {
        this.NOC_Authority_Address__c = NOC_Authority_Address__c;
    }


    /**
     * Gets the NOC_Authority__c value for this NOC__c.
     * 
     * @return NOC_Authority__c
     */
    public String getNOC_Authority__c() {
        return NOC_Authority__c;
    }


    /**
     * Sets the NOC_Authority__c value for this NOC__c.
     * 
     * @param NOC_Authority__c
     */
    public void setNOC_Authority__c(String NOC_Authority__c) {
        this.NOC_Authority__c = NOC_Authority__c;
    }


    /**
     * Gets the NOC_Date__c value for this NOC__c.
     * 
     * @return NOC_Date__c
     */
    public String getNOC_Date__c() {
        return NOC_Date__c;
    }


    /**
     * Sets the NOC_Date__c value for this NOC__c.
     * 
     * @param NOC_Date__c
     */
    public void setNOC_Date__c(String NOC_Date__c) {
        this.NOC_Date__c = NOC_Date__c;
    }


    /**
     * Gets the NOC_Language__c value for this NOC__c.
     * 
     * @return NOC_Language__c
     */
    public String getNOC_Language__c() {
        return NOC_Language__c;
    }


    /**
     * Sets the NOC_Language__c value for this NOC__c.
     * 
     * @param NOC_Language__c
     */
    public void setNOC_Language__c(String NOC_Language__c) {
        this.NOC_Language__c = NOC_Language__c;
    }


    /**
     * Gets the NOC_Receiver_Email__c value for this NOC__c.
     * 
     * @return NOC_Receiver_Email__c
     */
    public String getNOC_Receiver_Email__c() {
        return NOC_Receiver_Email__c;
    }


    /**
     * Sets the NOC_Receiver_Email__c value for this NOC__c.
     * 
     * @param NOC_Receiver_Email__c
     */
    public void setNOC_Receiver_Email__c(String NOC_Receiver_Email__c) {
        this.NOC_Receiver_Email__c = NOC_Receiver_Email__c;
    }


    /**
     * Gets the NOC_Template__c value for this NOC__c.
     * 
     * @return NOC_Template__c
     */
    public String getNOC_Template__c() {
        return NOC_Template__c;
    }


    /**
     * Sets the NOC_Template__c value for this NOC__c.
     * 
     * @param NOC_Template__c
     */
    public void setNOC_Template__c(String NOC_Template__c) {
        this.NOC_Template__c = NOC_Template__c;
    }


    /**
     * Gets the NOC_Type__c value for this NOC__c.
     * 
     * @return NOC_Type__c
     */
    public String getNOC_Type__c() {
        return NOC_Type__c;
    }


    /**
     * Sets the NOC_Type__c value for this NOC__c.
     * 
     * @param NOC_Type__c
     */
    public void setNOC_Type__c(String NOC_Type__c) {
        this.NOC_Type__c = NOC_Type__c;
    }


    /**
     * Gets the NOC_Vehicle_Type__c value for this NOC__c.
     * 
     * @return NOC_Vehicle_Type__c
     */
    public String getNOC_Vehicle_Type__c() {
        return NOC_Vehicle_Type__c;
    }


    /**
     * Sets the NOC_Vehicle_Type__c value for this NOC__c.
     * 
     * @param NOC_Vehicle_Type__c
     */
    public void setNOC_Vehicle_Type__c(String NOC_Vehicle_Type__c) {
        this.NOC_Vehicle_Type__c = NOC_Vehicle_Type__c;
    }


    /**
     * Gets the name value for this NOC__c.
     * 
     * @return name
     */
    public String getName() {
        return name;
    }


    /**
     * Sets the name value for this NOC__c.
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * Gets the nationality_Arabic__c value for this NOC__c.
     * 
     * @return nationality_Arabic__c
     */
    public String getNationality_Arabic__c() {
        return nationality_Arabic__c;
    }


    /**
     * Sets the nationality_Arabic__c value for this NOC__c.
     * 
     * @param nationality_Arabic__c
     */
    public void setNationality_Arabic__c(String nationality_Arabic__c) {
        this.nationality_Arabic__c = nationality_Arabic__c;
    }


    /**
     * Gets the need_a_Stamp_Copy__c value for this NOC__c.
     * 
     * @return need_a_Stamp_Copy__c
     */
    public boolean getNeed_a_Stamp_Copy__c() {
        return need_a_Stamp_Copy__c;
    }


    /**
     * Sets the need_a_Stamp_Copy__c value for this NOC__c.
     * 
     * @param need_a_Stamp_Copy__c
     */
    public void setNeed_a_Stamp_Copy__c(boolean need_a_Stamp_Copy__c) {
        this.need_a_Stamp_Copy__c = need_a_Stamp_Copy__c;
    }


    /**
     * Gets the new_First_Name_Arabic__c value for this NOC__c.
     * 
     * @return new_First_Name_Arabic__c
     */
    public String getNew_First_Name_Arabic__c() {
        return new_First_Name_Arabic__c;
    }


    /**
     * Sets the new_First_Name_Arabic__c value for this NOC__c.
     * 
     * @param new_First_Name_Arabic__c
     */
    public void setNew_First_Name_Arabic__c(String new_First_Name_Arabic__c) {
        this.new_First_Name_Arabic__c = new_First_Name_Arabic__c;
    }


    /**
     * Gets the new_First_Name__c value for this NOC__c.
     * 
     * @return new_First_Name__c
     */
    public String getNew_First_Name__c() {
        return new_First_Name__c;
    }


    /**
     * Sets the new_First_Name__c value for this NOC__c.
     * 
     * @param new_First_Name__c
     */
    public void setNew_First_Name__c(String new_First_Name__c) {
        this.new_First_Name__c = new_First_Name__c;
    }


    /**
     * Gets the new_Job_Title_Arabic__c value for this NOC__c.
     * 
     * @return new_Job_Title_Arabic__c
     */
    public String getNew_Job_Title_Arabic__c() {
        return new_Job_Title_Arabic__c;
    }


    /**
     * Sets the new_Job_Title_Arabic__c value for this NOC__c.
     * 
     * @param new_Job_Title_Arabic__c
     */
    public void setNew_Job_Title_Arabic__c(String new_Job_Title_Arabic__c) {
        this.new_Job_Title_Arabic__c = new_Job_Title_Arabic__c;
    }


    /**
     * Gets the new_Job_Title__c value for this NOC__c.
     * 
     * @return new_Job_Title__c
     */
    public String getNew_Job_Title__c() {
        return new_Job_Title__c;
    }


    /**
     * Sets the new_Job_Title__c value for this NOC__c.
     * 
     * @param new_Job_Title__c
     */
    public void setNew_Job_Title__c(String new_Job_Title__c) {
        this.new_Job_Title__c = new_Job_Title__c;
    }


    /**
     * Gets the new_Last_Name_Arabic__c value for this NOC__c.
     * 
     * @return new_Last_Name_Arabic__c
     */
    public String getNew_Last_Name_Arabic__c() {
        return new_Last_Name_Arabic__c;
    }


    /**
     * Sets the new_Last_Name_Arabic__c value for this NOC__c.
     * 
     * @param new_Last_Name_Arabic__c
     */
    public void setNew_Last_Name_Arabic__c(String new_Last_Name_Arabic__c) {
        this.new_Last_Name_Arabic__c = new_Last_Name_Arabic__c;
    }


    /**
     * Gets the new_Last_Name__c value for this NOC__c.
     * 
     * @return new_Last_Name__c
     */
    public String getNew_Last_Name__c() {
        return new_Last_Name__c;
    }


    /**
     * Sets the new_Last_Name__c value for this NOC__c.
     * 
     * @param new_Last_Name__c
     */
    public void setNew_Last_Name__c(String new_Last_Name__c) {
        this.new_Last_Name__c = new_Last_Name__c;
    }


    /**
     * Gets the new_Middle_Name_Arabic__c value for this NOC__c.
     * 
     * @return new_Middle_Name_Arabic__c
     */
    public String getNew_Middle_Name_Arabic__c() {
        return new_Middle_Name_Arabic__c;
    }


    /**
     * Sets the new_Middle_Name_Arabic__c value for this NOC__c.
     * 
     * @param new_Middle_Name_Arabic__c
     */
    public void setNew_Middle_Name_Arabic__c(String new_Middle_Name_Arabic__c) {
        this.new_Middle_Name_Arabic__c = new_Middle_Name_Arabic__c;
    }


    /**
     * Gets the new_Middle_Name__c value for this NOC__c.
     * 
     * @return new_Middle_Name__c
     */
    public String getNew_Middle_Name__c() {
        return new_Middle_Name__c;
    }


    /**
     * Sets the new_Middle_Name__c value for this NOC__c.
     * 
     * @param new_Middle_Name__c
     */
    public void setNew_Middle_Name__c(String new_Middle_Name__c) {
        this.new_Middle_Name__c = new_Middle_Name__c;
    }


    /**
     * Gets the new_Nationality_Arabic__c value for this NOC__c.
     * 
     * @return new_Nationality_Arabic__c
     */
    public String getNew_Nationality_Arabic__c() {
        return new_Nationality_Arabic__c;
    }


    /**
     * Sets the new_Nationality_Arabic__c value for this NOC__c.
     * 
     * @param new_Nationality_Arabic__c
     */
    public void setNew_Nationality_Arabic__c(String new_Nationality_Arabic__c) {
        this.new_Nationality_Arabic__c = new_Nationality_Arabic__c;
    }


    /**
     * Gets the new_Nationality__c value for this NOC__c.
     * 
     * @return new_Nationality__c
     */
    public String getNew_Nationality__c() {
        return new_Nationality__c;
    }


    /**
     * Sets the new_Nationality__c value for this NOC__c.
     * 
     * @param new_Nationality__c
     */
    public void setNew_Nationality__c(String new_Nationality__c) {
        this.new_Nationality__c = new_Nationality__c;
    }


    /**
     * Gets the new_Nationality__r value for this NOC__c.
     * 
     * @return new_Nationality__r
     */
    public CurrentNationality getNew_Nationality__r() {
        return new_Nationality__r;
    }


    /**
     * Sets the new_Nationality__r value for this NOC__c.
     * 
     * @param new_Nationality__r
     */
    public void setNew_Nationality__r(CurrentNationality new_Nationality__r) {
        this.new_Nationality__r = new_Nationality__r;
    }


    /**
     * Gets the new_Passport_Number__c value for this NOC__c.
     * 
     * @return new_Passport_Number__c
     */
    public String getNew_Passport_Number__c() {
        return new_Passport_Number__c;
    }


    /**
     * Sets the new_Passport_Number__c value for this NOC__c.
     * 
     * @param new_Passport_Number__c
     */
    public void setNew_Passport_Number__c(String new_Passport_Number__c) {
        this.new_Passport_Number__c = new_Passport_Number__c;
    }


    /**
     * Gets the notes value for this NOC__c.
     * 
     * @return notes
     */
    public QueryResult getNotes() {
        return notes;
    }


    /**
     * Sets the notes value for this NOC__c.
     * 
     * @param notes
     */
    public void setNotes(QueryResult notes) {
        this.notes = notes;
    }


    /**
     * Gets the notesAndAttachments value for this NOC__c.
     * 
     * @return notesAndAttachments
     */
    public QueryResult getNotesAndAttachments() {
        return notesAndAttachments;
    }


    /**
     * Sets the notesAndAttachments value for this NOC__c.
     * 
     * @param notesAndAttachments
     */
    public void setNotesAndAttachments(QueryResult notesAndAttachments) {
        this.notesAndAttachments = notesAndAttachments;
    }


    /**
     * Gets the old_Company_Name__c value for this NOC__c.
     * 
     * @return old_Company_Name__c
     */
    public String getOld_Company_Name__c() {
        return old_Company_Name__c;
    }


    /**
     * Sets the old_Company_Name__c value for this NOC__c.
     * 
     * @param old_Company_Name__c
     */
    public void setOld_Company_Name__c(String old_Company_Name__c) {
        this.old_Company_Name__c = old_Company_Name__c;
    }


    /**
     * Gets the openActivities value for this NOC__c.
     * 
     * @return openActivities
     */
    public QueryResult getOpenActivities() {
        return openActivities;
    }


    /**
     * Sets the openActivities value for this NOC__c.
     * 
     * @param openActivities
     */
    public void setOpenActivities(QueryResult openActivities) {
        this.openActivities = openActivities;
    }




    /**
     * Gets the ownerId value for this NOC__c.
     * 
     * @return ownerId
     */
    public String getOwnerId() {
        return ownerId;
    }


    /**
     * Sets the ownerId value for this NOC__c.
     * 
     * @param ownerId
     */
    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }


    /**
     * Gets the passport_Country_Arabic__c value for this NOC__c.
     * 
     * @return passport_Country_Arabic__c
     */
    public String getPassport_Country_Arabic__c() {
        return passport_Country_Arabic__c;
    }


    /**
     * Sets the passport_Country_Arabic__c value for this NOC__c.
     * 
     * @param passport_Country_Arabic__c
     */
    public void setPassport_Country_Arabic__c(String passport_Country_Arabic__c) {
        this.passport_Country_Arabic__c = passport_Country_Arabic__c;
    }


    /**
     * Gets the passport_Country__c value for this NOC__c.
     * 
     * @return passport_Country__c
     */
    public String getPassport_Country__c() {
        return passport_Country__c;
    }


    /**
     * Sets the passport_Country__c value for this NOC__c.
     * 
     * @param passport_Country__c
     */
    public void setPassport_Country__c(String passport_Country__c) {
        this.passport_Country__c = passport_Country__c;
    }


    /**
     * Gets the passport_Number__c value for this NOC__c.
     * 
     * @return passport_Number__c
     */
    public String getPassport_Number__c() {
        return passport_Number__c;
    }


    /**
     * Sets the passport_Number__c value for this NOC__c.
     * 
     * @param passport_Number__c
     */
    public void setPassport_Number__c(String passport_Number__c) {
        this.passport_Number__c = passport_Number__c;
    }


    /**
     * Gets the person_Job_Title__c value for this NOC__c.
     * 
     * @return person_Job_Title__c
     */
    public String getPerson_Job_Title__c() {
        return person_Job_Title__c;
    }


    /**
     * Sets the person_Job_Title__c value for this NOC__c.
     * 
     * @param person_Job_Title__c
     */
    public void setPerson_Job_Title__c(String person_Job_Title__c) {
        this.person_Job_Title__c = person_Job_Title__c;
    }


    /**
     * Gets the person_Name__c value for this NOC__c.
     * 
     * @return person_Name__c
     */
    public String getPerson_Name__c() {
        return person_Name__c;
    }


    /**
     * Sets the person_Name__c value for this NOC__c.
     * 
     * @param person_Name__c
     */
    public void setPerson_Name__c(String person_Name__c) {
        this.person_Name__c = person_Name__c;
    }


    /**
     * Gets the person_Nationality__c value for this NOC__c.
     * 
     * @return person_Nationality__c
     */
    public String getPerson_Nationality__c() {
        return person_Nationality__c;
    }


    /**
     * Sets the person_Nationality__c value for this NOC__c.
     * 
     * @param person_Nationality__c
     */
    public void setPerson_Nationality__c(String person_Nationality__c) {
        this.person_Nationality__c = person_Nationality__c;
    }


    /**
     * Gets the person_Passport__c value for this NOC__c.
     * 
     * @return person_Passport__c
     */
    public String getPerson_Passport__c() {
        return person_Passport__c;
    }


    /**
     * Sets the person_Passport__c value for this NOC__c.
     * 
     * @param person_Passport__c
     */
    public void setPerson_Passport__c(String person_Passport__c) {
        this.person_Passport__c = person_Passport__c;
    }


    /**
     * Gets the person_Sponsor_Company_Name__c value for this NOC__c.
     * 
     * @return person_Sponsor_Company_Name__c
     */
    public String getPerson_Sponsor_Company_Name__c() {
        return person_Sponsor_Company_Name__c;
    }


    /**
     * Sets the person_Sponsor_Company_Name__c value for this NOC__c.
     * 
     * @param person_Sponsor_Company_Name__c
     */
    public void setPerson_Sponsor_Company_Name__c(String person_Sponsor_Company_Name__c) {
        this.person_Sponsor_Company_Name__c = person_Sponsor_Company_Name__c;
    }


    /**
     * Gets the person__c value for this NOC__c.
     * 
     * @return person__c
     */
    public String getPerson__c() {
        return person__c;
    }


    /**
     * Sets the person__c value for this NOC__c.
     * 
     * @param person__c
     */
    public void setPerson__c(String person__c) {
        this.person__c = person__c;
    }


    /**
     * Gets the person__r value for this NOC__c.
     * 
     * @return person__r
     */
    public Account getPerson__r() {
        return person__r;
    }


    /**
     * Sets the person__r value for this NOC__c.
     * 
     * @param person__r
     */
    public void setPerson__r(Account person__r) {
        this.person__r = person__r;
    }


    /**
     * Gets the processInstances value for this NOC__c.
     * 
     * @return processInstances
     */
    public QueryResult getProcessInstances() {
        return processInstances;
    }


    /**
     * Sets the processInstances value for this NOC__c.
     * 
     * @param processInstances
     */
    public void setProcessInstances(QueryResult processInstances) {
        this.processInstances = processInstances;
    }


    /**
     * Gets the processSteps value for this NOC__c.
     * 
     * @return processSteps
     */
    public QueryResult getProcessSteps() {
        return processSteps;
    }


    /**
     * Sets the processSteps value for this NOC__c.
     * 
     * @param processSteps
     */
    public void setProcessSteps(QueryResult processSteps) {
        this.processSteps = processSteps;
    }


    /**
     * Gets the QR_Code__c value for this NOC__c.
     * 
     * @return QR_Code__c
     */
    public String getQR_Code__c() {
        return QR_Code__c;
    }


    /**
     * Sets the QR_Code__c value for this NOC__c.
     * 
     * @param QR_Code__c
     */
    public void setQR_Code__c(String QR_Code__c) {
        this.QR_Code__c = QR_Code__c;
    }


    /**
     * Gets the receipts__r value for this NOC__c.
     * 
     * @return receipts__r
     */
    public QueryResult getReceipts__r() {
        return receipts__r;
    }


    /**
     * Sets the receipts__r value for this NOC__c.
     * 
     * @param receipts__r
     */
    public void setReceipts__r(QueryResult receipts__r) {
        this.receipts__r = receipts__r;
    }


    /**
     * Gets the recordAssociatedGroups value for this NOC__c.
     * 
     * @return recordAssociatedGroups
     */
    public QueryResult getRecordAssociatedGroups() {
        return recordAssociatedGroups;
    }


    /**
     * Sets the recordAssociatedGroups value for this NOC__c.
     * 
     * @param recordAssociatedGroups
     */
    public void setRecordAssociatedGroups(QueryResult recordAssociatedGroups) {
        this.recordAssociatedGroups = recordAssociatedGroups;
    }


    /**
     * Gets the recordType value for this NOC__c.
     * 
     * @return recordType
     */
    public RecordType getRecordType() {
        return recordType;
    }


    /**
     * Sets the recordType value for this NOC__c.
     * 
     * @param recordType
     */
    public void setRecordType(RecordType recordType) {
        this.recordType = recordType;
    }


    /**
     * Gets the recordTypeId value for this NOC__c.
     * 
     * @return recordTypeId
     */
    public String getRecordTypeId() {
        return recordTypeId;
    }


    /**
     * Sets the recordTypeId value for this NOC__c.
     * 
     * @param recordTypeId
     */
    public void setRecordTypeId(String recordTypeId) {
        this.recordTypeId = recordTypeId;
    }


    /**
     * Gets the record_Type_Name__c value for this NOC__c.
     * 
     * @return record_Type_Name__c
     */
    public String getRecord_Type_Name__c() {
        return record_Type_Name__c;
    }


    /**
     * Sets the record_Type_Name__c value for this NOC__c.
     * 
     * @param record_Type_Name__c
     */
    public void setRecord_Type_Name__c(String record_Type_Name__c) {
        this.record_Type_Name__c = record_Type_Name__c;
    }


    /**
     * Gets the request__c value for this NOC__c.
     * 
     * @return request__c
     */
    public String getRequest__c() {
        return request__c;
    }


    /**
     * Sets the request__c value for this NOC__c.
     * 
     * @param request__c
     */
    public void setRequest__c(String request__c) {
        this.request__c = request__c;
    }


    /**
     * Gets the request__r value for this NOC__c.
     * 
     * @return request__r
     */
    public Case getRequest__r() {
        return request__r;
    }


    /**
     * Sets the request__r value for this NOC__c.
     * 
     * @param request__r
     */
    public void setRequest__r(Case request__r) {
        this.request__r = request__r;
    }


    /**
     * Gets the residency_File_Number__c value for this NOC__c.
     * 
     * @return residency_File_Number__c
     */
    public String getResidency_File_Number__c() {
        return residency_File_Number__c;
    }


    /**
     * Sets the residency_File_Number__c value for this NOC__c.
     * 
     * @param residency_File_Number__c
     */
    public void setResidency_File_Number__c(String residency_File_Number__c) {
        this.residency_File_Number__c = residency_File_Number__c;
    }


    /**
     * Gets the salary_Certificate_Authority__c value for this NOC__c.
     * 
     * @return salary_Certificate_Authority__c
     */
    public String getSalary_Certificate_Authority__c() {
        return salary_Certificate_Authority__c;
    }


    /**
     * Sets the salary_Certificate_Authority__c value for this NOC__c.
     * 
     * @param salary_Certificate_Authority__c
     */
    public void setSalary_Certificate_Authority__c(String salary_Certificate_Authority__c) {
        this.salary_Certificate_Authority__c = salary_Certificate_Authority__c;
    }


    /**
     * Gets the service_ID__c value for this NOC__c.
     * 
     * @return service_ID__c
     */
    public String getService_ID__c() {
        return service_ID__c;
    }


    /**
     * Sets the service_ID__c value for this NOC__c.
     * 
     * @param service_ID__c
     */
    public void setService_ID__c(String service_ID__c) {
        this.service_ID__c = service_ID__c;
    }


    /**
     * Gets the service_Name__c value for this NOC__c.
     * 
     * @return service_Name__c
     */
    public String getService_Name__c() {
        return service_Name__c;
    }


    /**
     * Sets the service_Name__c value for this NOC__c.
     * 
     * @param service_Name__c
     */
    public void setService_Name__c(String service_Name__c) {
        this.service_Name__c = service_Name__c;
    }


    /**
     * Gets the short_Company_Name__c value for this NOC__c.
     * 
     * @return short_Company_Name__c
     */
    public String getShort_Company_Name__c() {
        return short_Company_Name__c;
    }


    /**
     * Sets the short_Company_Name__c value for this NOC__c.
     * 
     * @param short_Company_Name__c
     */
    public void setShort_Company_Name__c(String short_Company_Name__c) {
        this.short_Company_Name__c = short_Company_Name__c;
    }


    /**
     * Gets the signature_Arabic_Department__c value for this NOC__c.
     * 
     * @return signature_Arabic_Department__c
     */
    public String getSignature_Arabic_Department__c() {
        return signature_Arabic_Department__c;
    }


    /**
     * Sets the signature_Arabic_Department__c value for this NOC__c.
     * 
     * @param signature_Arabic_Department__c
     */
    public void setSignature_Arabic_Department__c(String signature_Arabic_Department__c) {
        this.signature_Arabic_Department__c = signature_Arabic_Department__c;
    }


    /**
     * Gets the signature_Arabic_Name__c value for this NOC__c.
     * 
     * @return signature_Arabic_Name__c
     */
    public String getSignature_Arabic_Name__c() {
        return signature_Arabic_Name__c;
    }


    /**
     * Sets the signature_Arabic_Name__c value for this NOC__c.
     * 
     * @param signature_Arabic_Name__c
     */
    public void setSignature_Arabic_Name__c(String signature_Arabic_Name__c) {
        this.signature_Arabic_Name__c = signature_Arabic_Name__c;
    }


    /**
     * Gets the signature_Arabic_Title__c value for this NOC__c.
     * 
     * @return signature_Arabic_Title__c
     */
    public String getSignature_Arabic_Title__c() {
        return signature_Arabic_Title__c;
    }


    /**
     * Sets the signature_Arabic_Title__c value for this NOC__c.
     * 
     * @param signature_Arabic_Title__c
     */
    public void setSignature_Arabic_Title__c(String signature_Arabic_Title__c) {
        this.signature_Arabic_Title__c = signature_Arabic_Title__c;
    }


    /**
     * Gets the signature_English_Department__c value for this NOC__c.
     * 
     * @return signature_English_Department__c
     */
    public String getSignature_English_Department__c() {
        return signature_English_Department__c;
    }


    /**
     * Sets the signature_English_Department__c value for this NOC__c.
     * 
     * @param signature_English_Department__c
     */
    public void setSignature_English_Department__c(String signature_English_Department__c) {
        this.signature_English_Department__c = signature_English_Department__c;
    }


    /**
     * Gets the signature_English_Name__c value for this NOC__c.
     * 
     * @return signature_English_Name__c
     */
    public String getSignature_English_Name__c() {
        return signature_English_Name__c;
    }


    /**
     * Sets the signature_English_Name__c value for this NOC__c.
     * 
     * @param signature_English_Name__c
     */
    public void setSignature_English_Name__c(String signature_English_Name__c) {
        this.signature_English_Name__c = signature_English_Name__c;
    }


    /**
     * Gets the signature_English_Title__c value for this NOC__c.
     * 
     * @return signature_English_Title__c
     */
    public String getSignature_English_Title__c() {
        return signature_English_Title__c;
    }


    /**
     * Sets the signature_English_Title__c value for this NOC__c.
     * 
     * @param signature_English_Title__c
     */
    public void setSignature_English_Title__c(String signature_English_Title__c) {
        this.signature_English_Title__c = signature_English_Title__c;
    }


    /**
     * Gets the sponsor_Name_Arabic__c value for this NOC__c.
     * 
     * @return sponsor_Name_Arabic__c
     */
    public String getSponsor_Name_Arabic__c() {
        return sponsor_Name_Arabic__c;
    }


    /**
     * Sets the sponsor_Name_Arabic__c value for this NOC__c.
     * 
     * @param sponsor_Name_Arabic__c
     */
    public void setSponsor_Name_Arabic__c(String sponsor_Name_Arabic__c) {
        this.sponsor_Name_Arabic__c = sponsor_Name_Arabic__c;
    }


    /**
     * Gets the sponsor_Name__c value for this NOC__c.
     * 
     * @return sponsor_Name__c
     */
    public String getSponsor_Name__c() {
        return sponsor_Name__c;
    }


    /**
     * Sets the sponsor_Name__c value for this NOC__c.
     * 
     * @param sponsor_Name__c
     */
    public void setSponsor_Name__c(String sponsor_Name__c) {
        this.sponsor_Name__c = sponsor_Name__c;
    }


    /**
     * Gets the stamp_Copy_issued_on_NOC__c value for this NOC__c.
     * 
     * @return stamp_Copy_issued_on_NOC__c
     */
    public boolean getStamp_Copy_issued_on_NOC__c() {
        return stamp_Copy_issued_on_NOC__c;
    }


    /**
     * Sets the stamp_Copy_issued_on_NOC__c value for this NOC__c.
     * 
     * @param stamp_Copy_issued_on_NOC__c
     */
    public void setStamp_Copy_issued_on_NOC__c(boolean stamp_Copy_issued_on_NOC__c) {
        this.stamp_Copy_issued_on_NOC__c = stamp_Copy_issued_on_NOC__c;
    }


    /**
     * Gets the standing_Invoices_Allowed__c value for this NOC__c.
     * 
     * @return standing_Invoices_Allowed__c
     */
    public boolean getStanding_Invoices_Allowed__c() {
        return standing_Invoices_Allowed__c;
    }


    /**
     * Sets the standing_Invoices_Allowed__c value for this NOC__c.
     * 
     * @param standing_Invoices_Allowed__c
     */
    public void setStanding_Invoices_Allowed__c(boolean standing_Invoices_Allowed__c) {
        this.standing_Invoices_Allowed__c = standing_Invoices_Allowed__c;
    }


    /**
     * Gets the systemModstamp value for this NOC__c.
     * 
     * @return systemModstamp
     */
    public java.util.Calendar getSystemModstamp() {
        return systemModstamp;
    }


    /**
     * Sets the systemModstamp value for this NOC__c.
     * 
     * @param systemModstamp
     */
    public void setSystemModstamp(java.util.Calendar systemModstamp) {
        this.systemModstamp = systemModstamp;
    }


    /**
     * Gets the tasks value for this NOC__c.
     * 
     * @return tasks
     */
    public QueryResult getTasks() {
        return tasks;
    }


    /**
     * Sets the tasks value for this NOC__c.
     * 
     * @param tasks
     */
    public void setTasks(QueryResult tasks) {
        this.tasks = tasks;
    }


    /**
     * Gets the to_Embassy_Of_Formula__c value for this NOC__c.
     * 
     * @return to_Embassy_Of_Formula__c
     */
    public String getTo_Embassy_Of_Formula__c() {
        return to_Embassy_Of_Formula__c;
    }


    /**
     * Sets the to_Embassy_Of_Formula__c value for this NOC__c.
     * 
     * @param to_Embassy_Of_Formula__c
     */
    public void setTo_Embassy_Of_Formula__c(String to_Embassy_Of_Formula__c) {
        this.to_Embassy_Of_Formula__c = to_Embassy_Of_Formula__c;
    }


    /**
     * Gets the to_Embassy_Of__c value for this NOC__c.
     * 
     * @return to_Embassy_Of__c
     */
    public String getTo_Embassy_Of__c() {
        return to_Embassy_Of__c;
    }


    /**
     * Sets the to_Embassy_Of__c value for this NOC__c.
     * 
     * @param to_Embassy_Of__c
     */
    public void setTo_Embassy_Of__c(String to_Embassy_Of__c) {
        this.to_Embassy_Of__c = to_Embassy_Of__c;
    }




    /**
     * Gets the topicAssignments value for this NOC__c.
     * 
     * @return topicAssignments
     */
    public QueryResult getTopicAssignments() {
        return topicAssignments;
    }


    /**
     * Sets the topicAssignments value for this NOC__c.
     * 
     * @param topicAssignments
     */
    public void setTopicAssignments(QueryResult topicAssignments) {
        this.topicAssignments = topicAssignments;
    }


    /**
     * Gets the total_Monthly_Salary_in_AED__c value for this NOC__c.
     * 
     * @return total_Monthly_Salary_in_AED__c
     */
    public double getTotal_Monthly_Salary_in_AED__c() {
        return total_Monthly_Salary_in_AED__c;
    }


    /**
     * Sets the total_Monthly_Salary_in_AED__c value for this NOC__c.
     * 
     * @param total_Monthly_Salary_in_AED__c
     */
    public void setTotal_Monthly_Salary_in_AED__c(double total_Monthly_Salary_in_AED__c) {
        this.total_Monthly_Salary_in_AED__c = total_Monthly_Salary_in_AED__c;
    }


    /**
     * Gets the travel_Country_Arabic__c value for this NOC__c.
     * 
     * @return travel_Country_Arabic__c
     */
    public String getTravel_Country_Arabic__c() {
        return travel_Country_Arabic__c;
    }


    /**
     * Sets the travel_Country_Arabic__c value for this NOC__c.
     * 
     * @param travel_Country_Arabic__c
     */
    public void setTravel_Country_Arabic__c(String travel_Country_Arabic__c) {
        this.travel_Country_Arabic__c = travel_Country_Arabic__c;
    }


    /**
     * Gets the travel_End_Date__c value for this NOC__c.
     * 
     * @return travel_End_Date__c
     */
    public java.util.Date getTravel_End_Date__c() {
        return travel_End_Date__c;
    }


    /**
     * Sets the travel_End_Date__c value for this NOC__c.
     * 
     * @param travel_End_Date__c
     */
    public void setTravel_End_Date__c(java.util.Date travel_End_Date__c) {
        this.travel_End_Date__c = travel_End_Date__c;
    }


    /**
     * Gets the travel_Start_Date__c value for this NOC__c.
     * 
     * @return travel_Start_Date__c
     */
    public java.util.Date getTravel_Start_Date__c() {
        return travel_Start_Date__c;
    }


    /**
     * Sets the travel_Start_Date__c value for this NOC__c.
     * 
     * @param travel_Start_Date__c
     */
    public void setTravel_Start_Date__c(java.util.Date travel_Start_Date__c) {
        this.travel_Start_Date__c = travel_Start_Date__c;
    }


    /**
     * Gets the travel_To__c value for this NOC__c.
     * 
     * @return travel_To__c
     */
    public String getTravel_To__c() {
        return travel_To__c;
    }


    /**
     * Sets the travel_To__c value for this NOC__c.
     * 
     * @param travel_To__c
     */
    public void setTravel_To__c(String travel_To__c) {
        this.travel_To__c = travel_To__c;
    }




    /**
     * Gets the umrah_Hajj__c value for this NOC__c.
     * 
     * @return umrah_Hajj__c
     */
    public String getUmrah_Hajj__c() {
        return umrah_Hajj__c;
    }


    /**
     * Sets the umrah_Hajj__c value for this NOC__c.
     * 
     * @param umrah_Hajj__c
     */
    public void setUmrah_Hajj__c(String umrah_Hajj__c) {
        this.umrah_Hajj__c = umrah_Hajj__c;
    }



    /**
     * Gets the vehicle_Chassis_Number__c value for this NOC__c.
     * 
     * @return vehicle_Chassis_Number__c
     */
    public String getVehicle_Chassis_Number__c() {
        return vehicle_Chassis_Number__c;
    }


    /**
     * Sets the vehicle_Chassis_Number__c value for this NOC__c.
     * 
     * @param vehicle_Chassis_Number__c
     */
    public void setVehicle_Chassis_Number__c(String vehicle_Chassis_Number__c) {
        this.vehicle_Chassis_Number__c = vehicle_Chassis_Number__c;
    }


    /**
     * Gets the vehicle_Color__c value for this NOC__c.
     * 
     * @return vehicle_Color__c
     */
    public String getVehicle_Color__c() {
        return vehicle_Color__c;
    }


    /**
     * Sets the vehicle_Color__c value for this NOC__c.
     * 
     * @param vehicle_Color__c
     */
    public void setVehicle_Color__c(String vehicle_Color__c) {
        this.vehicle_Color__c = vehicle_Color__c;
    }


    /**
     * Gets the vehicle_Country_of_Origin__c value for this NOC__c.
     * 
     * @return vehicle_Country_of_Origin__c
     */
    public String getVehicle_Country_of_Origin__c() {
        return vehicle_Country_of_Origin__c;
    }


    /**
     * Sets the vehicle_Country_of_Origin__c value for this NOC__c.
     * 
     * @param vehicle_Country_of_Origin__c
     */
    public void setVehicle_Country_of_Origin__c(String vehicle_Country_of_Origin__c) {
        this.vehicle_Country_of_Origin__c = vehicle_Country_of_Origin__c;
    }


    /**
     * Gets the vehicle_Engine_Number__c value for this NOC__c.
     * 
     * @return vehicle_Engine_Number__c
     */
    public String getVehicle_Engine_Number__c() {
        return vehicle_Engine_Number__c;
    }


    /**
     * Sets the vehicle_Engine_Number__c value for this NOC__c.
     * 
     * @param vehicle_Engine_Number__c
     */
    public void setVehicle_Engine_Number__c(String vehicle_Engine_Number__c) {
        this.vehicle_Engine_Number__c = vehicle_Engine_Number__c;
    }


    /**
     * Gets the vehicle_Sub_Service__c value for this NOC__c.
     * 
     * @return vehicle_Sub_Service__c
     */
    public String getVehicle_Sub_Service__c() {
        return vehicle_Sub_Service__c;
    }


    /**
     * Sets the vehicle_Sub_Service__c value for this NOC__c.
     * 
     * @param vehicle_Sub_Service__c
     */
    public void setVehicle_Sub_Service__c(String vehicle_Sub_Service__c) {
        this.vehicle_Sub_Service__c = vehicle_Sub_Service__c;
    }


    /**
     * Gets the vehicle_Type__c value for this NOC__c.
     * 
     * @return vehicle_Type__c
     */
    public String getVehicle_Type__c() {
        return vehicle_Type__c;
    }


    /**
     * Sets the vehicle_Type__c value for this NOC__c.
     * 
     * @param vehicle_Type__c
     */
    public void setVehicle_Type__c(String vehicle_Type__c) {
        this.vehicle_Type__c = vehicle_Type__c;
    }


    /**
     * Gets the vehicle_Year_of_Manufacture__c value for this NOC__c.
     * 
     * @return vehicle_Year_of_Manufacture__c
     */
    public double getVehicle_Year_of_Manufacture__c() {
        return vehicle_Year_of_Manufacture__c;
    }


    /**
     * Sets the vehicle_Year_of_Manufacture__c value for this NOC__c.
     * 
     * @param vehicle_Year_of_Manufacture__c
     */
    public void setVehicle_Year_of_Manufacture__c(double vehicle_Year_of_Manufacture__c) {
        this.vehicle_Year_of_Manufacture__c = vehicle_Year_of_Manufacture__c;
    }


    /**
     * Gets the verification_Message_with_URL__c value for this NOC__c.
     * 
     * @return verification_Message_with_URL__c
     */
    public String getVerification_Message_with_URL__c() {
        return verification_Message_with_URL__c;
    }


    /**
     * Sets the verification_Message_with_URL__c value for this NOC__c.
     * 
     * @param verification_Message_with_URL__c
     */
    public void setVerification_Message_with_URL__c(String verification_Message_with_URL__c) {
        this.verification_Message_with_URL__c = verification_Message_with_URL__c;
    }


    /**
     * Gets the visa_Number__c value for this NOC__c.
     * 
     * @return visa_Number__c
     */
    public String getVisa_Number__c() {
        return visa_Number__c;
    }


    /**
     * Sets the visa_Number__c value for this NOC__c.
     * 
     * @param visa_Number__c
     */
    public void setVisa_Number__c(String visa_Number__c) {
        this.visa_Number__c = visa_Number__c;
    }


    /**
     * Gets the web_Form__c value for this NOC__c.
     * 
     * @return web_Form__c
     */
    public String getWeb_Form__c() {
        return web_Form__c;
    }


    /**
     * Sets the web_Form__c value for this NOC__c.
     * 
     * @param web_Form__c
     */
    public void setWeb_Form__c(String web_Form__c) {
        this.web_Form__c = web_Form__c;
    }


    /**
     * Gets the web_Form__r value for this NOC__c.
     * 
     * @return web_Form__r
     */
    public Web_Form__c getWeb_Form__r() {
        return web_Form__r;
    }


    /**
     * Sets the web_Form__r value for this NOC__c.
     * 
     * @param web_Form__r
     */
    public void setWeb_Form__r(Web_Form__c web_Form__r) {
        this.web_Form__r = web_Form__r;
    }


    /**
     * Gets the eService_Type__c value for this NOC__c.
     * 
     * @return eService_Type__c
     */
    public String getEService_Type__c() {
        return eService_Type__c;
    }


    /**
     * Sets the eService_Type__c value for this NOC__c.
     * 
     * @param eService_Type__c
     */
    public void setEService_Type__c(String eService_Type__c) {
        this.eService_Type__c = eService_Type__c;
    }


    /**
     * Gets the isCollected__c value for this NOC__c.
     * 
     * @return isCollected__c
     */
    public boolean getIsCollected__c() {
        return isCollected__c;
    }


    /**
     * Sets the isCollected__c value for this NOC__c.
     * 
     * @param isCollected__c
     */
    public void setIsCollected__c(boolean isCollected__c) {
        this.isCollected__c = isCollected__c;
    }


    /**
     * Gets the isCourierRequired__c value for this NOC__c.
     * 
     * @return isCourierRequired__c
     */
    public boolean getIsCourierRequired__c() {
        return isCourierRequired__c;
    }


    /**
     * Sets the isCourierRequired__c value for this NOC__c.
     * 
     * @param isCourierRequired__c
     */
    public void setIsCourierRequired__c(boolean isCourierRequired__c) {
        this.isCourierRequired__c = isCourierRequired__c;
    }


    /**
     * Gets the selectedServicesID__c value for this NOC__c.
     * 
     * @return selectedServicesID__c
     */
    public String getSelectedServicesID__c() {
        return selectedServicesID__c;
    }


    /**
     * Sets the selectedServicesID__c value for this NOC__c.
     * 
     * @param selectedServicesID__c
     */
    public void setSelectedServicesID__c(String selectedServicesID__c) {
        this.selectedServicesID__c = selectedServicesID__c;
    }

    }