/**
 * Card_Management__c.java
 * <p>
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package model;

import com.google.gson.annotations.SerializedName;

import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;


public class Card_Management__c implements Serializable {

    public model.attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(model.attributes attributes) {
        this.attributes = attributes;
    }

    @JsonProperty("attributes")
    attributes attributes;

    @SerializedName("Id")
    @JsonProperty("Id")
    public String id;
    @JsonProperty("Account_Name__c")
    @SerializedName("Account_Name__c")
    public String account_Name__c;

    public Account getAccount__r() {
        return account__r;
    }

    public void setAccount__r(Account account__r) {
        this.account__r = account__r;
    }

    @JsonProperty("Account__r")
    public Account account__r;
    @JsonProperty("Account__c")
    @SerializedName("Account__c")
    public String account__c;
    @JsonProperty("ActivityHistories")
    @SerializedName("ActivityHistories")
    public QueryResult activityHistories;
    @JsonProperty("Applicant_Email__c")
    @SerializedName("Applicant_Email__c")
    public String applicant_Email__c;
    @JsonProperty("Arabic_Name__c")
    @SerializedName("Arabic_Name__c")
    public String arabic_Name__c;
    @JsonProperty("AttachedContentDocuments")
    @SerializedName("AttachedContentDocuments")
    public QueryResult attachedContentDocuments;
    @JsonProperty("Attachments")
    @SerializedName("Attachments")
    public QueryResult attachments;
    @JsonProperty("Barcode_Image__c")
    @SerializedName("Barcode_Image__c")
    public String barcode_Image__c;
    @JsonProperty("Cancellation_Date__c")
    @SerializedName("Cancellation_Date__c")
    public String cancellation_Date__c;
    @JsonProperty("Card_Expiry_Date__c")
    @SerializedName("Card_Expiry_Date__c")
    public String card_Expiry_Date__c;
    @JsonProperty("Card_Expiry_Months__c")
    @SerializedName("Card_Expiry_Months__c")
    public double card_Expiry_Months__c;
    @JsonProperty("Card_Issue_Date__c")
    @SerializedName("Card_Issue_Date__c")
    public String card_Issue_Date__c;
    @JsonProperty("Card_Number__c")
    @SerializedName("Card_Number__c")
    public String card_Number__c;
    @JsonProperty("Card_Type__c")
    @SerializedName("Card_Type__c")
    public String card_Type__c;
    @JsonProperty("Collected_Date_Time__c")
    @SerializedName("Collected_Date_Time__c")
    public String collected_Date_Time__c;
    @JsonProperty("Collected__c")
    @SerializedName("Collected__c")
    public boolean collected__c;
    @JsonProperty("Collected_and_Dispose__c")
    @SerializedName("Collected_and_Dispose__c")
    public boolean collected_and_Dispose__c;
    @JsonProperty("Collected_by__c")
    @SerializedName("Collected_by__c")
    public String collected_by__c;
    @JsonProperty("CombinedAttachments")
    @SerializedName("CombinedAttachments")
    public QueryResult combinedAttachments;
    @JsonProperty("Company_Name__c")
    @SerializedName("Company_Name__c")
    public String company_Name__c;
    @JsonProperty("CreatedBy")
    @SerializedName("CreatedBy")
    public User createdBy;
    @JsonProperty("CreatedById")
    @SerializedName("CreatedById")
    public String createdById;
    @JsonProperty("CreatedDate")
    @SerializedName("CreatedDate")
    public String createdDate;
    @JsonProperty("CurrencyIsoCode")
    @SerializedName("CurrencyIsoCode")
    public String currencyIsoCode;
    @JsonProperty("Designation__c")
    @SerializedName("Designation__c")
    public String designation__c;
    @JsonProperty("DuplicateRecordItems")
    @SerializedName("DuplicateRecordItems")
    public QueryResult duplicateRecordItems;
    @JsonProperty("Duration__c")
    @SerializedName("Duration__c")
    public String duration__c;
    @JsonProperty("Events")
    @SerializedName("Events")
    public QueryResult events;
    @JsonProperty("FeedSubscriptionsForEntity")
    @SerializedName("FeedSubscriptionsForEntity")
    public QueryResult feedSubscriptionsForEntity;
    @JsonProperty("Full_Name__c")
    @SerializedName("Full_Name__c")
    public String full_Name__c;
    @JsonProperty("Histories")
    @SerializedName("Histories")
    public QueryResult histories;
    @JsonProperty("IsDeleted")
    @SerializedName("IsDeleted")
    public boolean isDeleted;
    @JsonProperty("LastActivityDate")
    @SerializedName("LastActivityDate")
    public String lastActivityDate;
    @JsonProperty("LastModifiedBy")
    @SerializedName("LastModifiedBy")
    public User lastModifiedBy;
    @JsonProperty("LastModifiedById")
    @SerializedName("LastModifiedById")
    public String lastModifiedById;
    @JsonProperty("LastModifiedDate")
    @SerializedName("LastModifiedDate")
    public String lastModifiedDate;
    @JsonProperty("LastReferencedDate")
    @SerializedName("LastReferencedDate")
    public String lastReferencedDate;
    @JsonProperty("LastViewedDate")
    @SerializedName("LastViewedDate")
    public String lastViewedDate;
    @JsonProperty("LookedUpFromActivities")
    @SerializedName("LookedUpFromActivities")
    public QueryResult lookedUpFromActivities;
    @JsonProperty("Lost_Card__c")
    @SerializedName("Lost_Card__c")
    public String lost_Card__c;
    @JsonProperty("Mobile_No__c")
    @SerializedName("Mobile_No__c")
    public String mobile_No__c;
    @JsonProperty("Name")
    @SerializedName("Name")
    public String name;
    @JsonProperty("Nationality__c")
    @SerializedName("Nationality__c")
    public String nationality__c;
    @JsonProperty("Notes")
    @SerializedName("Notes")
    public QueryResult notes;
    @JsonProperty("NotesAndAttachments")
    @SerializedName("NotesAndAttachments")
    public QueryResult notesAndAttachments;
    @JsonProperty("Number_of_Printing__c")
    @SerializedName("Number_of_Printing__c")
    public double number_of_Printing__c;
    @JsonProperty("Online_Form__c")
    @SerializedName("Online_Form__c")
    public boolean online_Form__c;
    @JsonProperty("OpenActivities")
    @SerializedName("OpenActivities")
    public QueryResult openActivities;
    @JsonProperty("Passport_Country_of_Issue__c")
    @SerializedName("Passport_Country_of_Issue__c")
    public String passport_Country_of_Issue__c;
    @JsonProperty("Passport_Number__c")
    @SerializedName("Passport_Number__c")
    public String passport_Number__c;
    @JsonProperty("Permanent_Address__c")
    @SerializedName("Permanent_Address__c")
    public String permanent_Address__c;
    @JsonProperty("Personal_Photo__c")
    @SerializedName("Personal_Photo__c")
    public String personal_Photo__c;
    @JsonProperty("Photo__c")
    @SerializedName("Photo__c")
    public String photo__c;
    @JsonProperty("ProcessInstances")
    @SerializedName("ProcessInstances")
    public QueryResult processInstances;
    @JsonProperty("ProcessSteps")
    @SerializedName("ProcessSteps")
    public QueryResult processSteps;
    @JsonProperty("Ready_for_Collection__c")
    @SerializedName("Ready_for_Collection__c")
    public boolean ready_for_Collection__c;
    @JsonProperty("RecordAssociatedGroups")
    @SerializedName("RecordAssociatedGroups")
    public QueryResult recordAssociatedGroups;
    @JsonProperty("RecordType")
    @SerializedName("RecordType")
    public RecordType recordType;
    @JsonProperty("RecordTypeId")
    @SerializedName("RecordTypeId")
    public String recordTypeId;
    @JsonProperty("Renewal_For__c")
    @SerializedName("Renewal_For__c")
    public String renewal_For__c;
    @JsonProperty("Renewed_Card__c")
    @SerializedName("Renewed_Card__c")
    public String renewed_Card__c;
    @JsonProperty("Request__c")
    @SerializedName("Request__c")
    public String request__c;

    public Nationality getNationality__r() {
        return nationality__r;
    }

    public void setNationality__r(Nationality nationality__r) {
        this.nationality__r = nationality__r;
    }

    @JsonProperty("Nationality__r")
public Nationality nationality__r;
    @JsonProperty("Requested_From__c")
    @SerializedName("Requested_From__c")
    public String requested_From__c;
    @JsonProperty("Salutation__c")
    @SerializedName("Salutation__c")
    public String salutation__c;
    @JsonProperty("Service_Identifier__c")
    @SerializedName("Service_Identifier__c")
    public String service_Identifier__c;
    @JsonProperty("Sponsor_Mobile_No__c")
    @SerializedName("Sponsor_Mobile_No__c")
    public String sponsor_Mobile_No__c;
    @JsonProperty("Sponsor_Relationship__c")
    @SerializedName("Sponsor_Relationship__c")
    public String sponsor_Relationship__c;
    @JsonProperty("Sponsor_Tel__c")
    @SerializedName("Sponsor_Tel__c")
    public String sponsor_Tel__c;
    @JsonProperty("Sponsor__c")
    @SerializedName("Sponsor__c")
    public String sponsor__c;
    @JsonProperty("Standing_Invoices_Allowed__c")
    @SerializedName("Standing_Invoices_Allowed__c")
    public boolean standing_Invoices_Allowed__c;
    @JsonProperty("Status__c")
    @SerializedName("Status__c")
    public String status__c;
    @JsonProperty("SystemModstamp")
    @SerializedName("SystemModstamp")
    public String systemModstamp;
    @JsonProperty("Tasks")
    @SerializedName("Tasks")
    public QueryResult tasks;
    @JsonProperty("TopicAssignments")
    @SerializedName("TopicAssignments")
    public QueryResult topicAssignments;
    @JsonProperty("Visa__c")
    @SerializedName("Visa__c")
    public String visa__c;
    @JsonProperty("Web_Form__c")
    @SerializedName("Web_Form__c")
    public String web_Form__c;
    @JsonProperty("AccLength__c")
    @SerializedName("AccLength__c")
    public double accLength__c;
    @JsonProperty("IsCourierRequired__c")
    @SerializedName("IsCourierRequired__c")
    public boolean isCourierRequired__c;

    public String getAccount_Name__c() {
        return account_Name__c;
    }

    public void setAccount_Name__c(String account_Name__c) {
        this.account_Name__c = account_Name__c;
    }

    public String getAccount__c() {
        return account__c;
    }

    public void setAccount__c(String account__c) {
        this.account__c = account__c;
    }

    public QueryResult getActivityHistories() {
        return activityHistories;
    }

    public void setActivityHistories(QueryResult activityHistories) {
        this.activityHistories = activityHistories;
    }

    public String getApplicant_Email__c() {
        return applicant_Email__c;
    }

    public void setApplicant_Email__c(String applicant_Email__c) {
        this.applicant_Email__c = applicant_Email__c;
    }

    public String getArabic_Name__c() {
        return arabic_Name__c;
    }

    public void setArabic_Name__c(String arabic_Name__c) {
        this.arabic_Name__c = arabic_Name__c;
    }

    public QueryResult getAttachedContentDocuments() {
        return attachedContentDocuments;
    }

    public void setAttachedContentDocuments(QueryResult attachedContentDocuments) {
        this.attachedContentDocuments = attachedContentDocuments;
    }

    public QueryResult getAttachments() {
        return attachments;
    }

    public void setAttachments(QueryResult attachments) {
        this.attachments = attachments;
    }

    public String getBarcode_Image__c() {
        return barcode_Image__c;
    }

    public void setBarcode_Image__c(String barcode_Image__c) {
        this.barcode_Image__c = barcode_Image__c;
    }

    public String getCancellation_Date__c() {
        return cancellation_Date__c;
    }

    public void setCancellation_Date__c(String cancellation_Date__c) {
        this.cancellation_Date__c = cancellation_Date__c;
    }

    public String getCard_Expiry_Date__c() {
        return card_Expiry_Date__c;
    }

    public void setCard_Expiry_Date__c(String card_Expiry_Date__c) {
        this.card_Expiry_Date__c = card_Expiry_Date__c;
    }

    public double getCard_Expiry_Months__c() {
        return card_Expiry_Months__c;
    }

    public void setCard_Expiry_Months__c(double card_Expiry_Months__c) {
        this.card_Expiry_Months__c = card_Expiry_Months__c;
    }

    public String getCard_Issue_Date__c() {
        return card_Issue_Date__c;
    }

    public void setCard_Issue_Date__c(String card_Issue_Date__c) {
        this.card_Issue_Date__c = card_Issue_Date__c;
    }

    public String getCard_Number__c() {
        return card_Number__c;
    }

    public void setCard_Number__c(String card_Number__c) {
        this.card_Number__c = card_Number__c;
    }

    public String getCard_Type__c() {
        return card_Type__c;
    }

    public void setCard_Type__c(String card_Type__c) {
        this.card_Type__c = card_Type__c;
    }

    public String getCollected_Date_Time__c() {
        return collected_Date_Time__c;
    }

    public void setCollected_Date_Time__c(String collected_Date_Time__c) {
        this.collected_Date_Time__c = collected_Date_Time__c;
    }

    public String getCollected_by__c() {
        return collected_by__c;
    }

    public void setCollected_by__c(String collected_by__c) {
        this.collected_by__c = collected_by__c;
    }

    public QueryResult getCombinedAttachments() {
        return combinedAttachments;
    }

    public void setCombinedAttachments(QueryResult combinedAttachments) {
        this.combinedAttachments = combinedAttachments;
    }

    public String getCompany_Name__c() {
        return company_Name__c;
    }

    public void setCompany_Name__c(String company_Name__c) {
        this.company_Name__c = company_Name__c;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedById() {
        return createdById;
    }

    public void setCreatedById(String createdById) {
        this.createdById = createdById;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getCurrencyIsoCode() {
        return currencyIsoCode;
    }

    public void setCurrencyIsoCode(String currencyIsoCode) {
        this.currencyIsoCode = currencyIsoCode;
    }

    public String getDesignation__c() {
        return designation__c;
    }

    public void setDesignation__c(String designation__c) {
        this.designation__c = designation__c;
    }

    public QueryResult getDuplicateRecordItems() {
        return duplicateRecordItems;
    }

    public void setDuplicateRecordItems(QueryResult duplicateRecordItems) {
        this.duplicateRecordItems = duplicateRecordItems;
    }

    public String getDuration__c() {
        return duration__c;
    }

    public void setDuration__c(String duration__c) {
        this.duration__c = duration__c;
    }

    public QueryResult getEvents() {
        return events;
    }

    public void setEvents(QueryResult events) {
        this.events = events;
    }

    public QueryResult getFeedSubscriptionsForEntity() {
        return feedSubscriptionsForEntity;
    }

    public void setFeedSubscriptionsForEntity(QueryResult feedSubscriptionsForEntity) {
        this.feedSubscriptionsForEntity = feedSubscriptionsForEntity;
    }

    public String getFull_Name__c() {
        return full_Name__c;
    }

    public void setFull_Name__c(String full_Name__c) {
        this.full_Name__c = full_Name__c;
    }

    public QueryResult getHistories() {
        return histories;
    }

    public void setHistories(QueryResult histories) {
        this.histories = histories;
    }


    public String getLastActivityDate() {
        return lastActivityDate;
    }

    public void setLastActivityDate(String lastActivityDate) {
        this.lastActivityDate = lastActivityDate;
    }

    public User getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(User lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public String getLastModifiedById() {
        return lastModifiedById;
    }

    public void setLastModifiedById(String lastModifiedById) {
        this.lastModifiedById = lastModifiedById;
    }

    public String getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(String lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getLastReferencedDate() {
        return lastReferencedDate;
    }

    public void setLastReferencedDate(String lastReferencedDate) {
        this.lastReferencedDate = lastReferencedDate;
    }

    public String getLastViewedDate() {
        return lastViewedDate;
    }

    public void setLastViewedDate(String lastViewedDate) {
        this.lastViewedDate = lastViewedDate;
    }

    public QueryResult getLookedUpFromActivities() {
        return lookedUpFromActivities;
    }

    public void setLookedUpFromActivities(QueryResult lookedUpFromActivities) {
        this.lookedUpFromActivities = lookedUpFromActivities;
    }

    public String getLost_Card__c() {
        return lost_Card__c;
    }

    public void setLost_Card__c(String lost_Card__c) {
        this.lost_Card__c = lost_Card__c;
    }

    public String getMobile_No__c() {
        return mobile_No__c;
    }

    public void setMobile_No__c(String mobile_No__c) {
        this.mobile_No__c = mobile_No__c;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality__c() {
        return nationality__c;
    }

    public void setNationality__c(String nationality__c) {
        this.nationality__c = nationality__c;
    }

    public QueryResult getNotes() {
        return notes;
    }

    public void setNotes(QueryResult notes) {
        this.notes = notes;
    }

    public QueryResult getNotesAndAttachments() {
        return notesAndAttachments;
    }

    public void setNotesAndAttachments(QueryResult notesAndAttachments) {
        this.notesAndAttachments = notesAndAttachments;
    }

    public double getNumber_of_Printing__c() {
        return number_of_Printing__c;
    }

    public void setNumber_of_Printing__c(double number_of_Printing__c) {
        this.number_of_Printing__c = number_of_Printing__c;
    }


    public QueryResult getOpenActivities() {
        return openActivities;
    }

    public void setOpenActivities(QueryResult openActivities) {
        this.openActivities = openActivities;
    }

    public String getPassport_Country_of_Issue__c() {
        return passport_Country_of_Issue__c;
    }

    public void setPassport_Country_of_Issue__c(String passport_Country_of_Issue__c) {
        this.passport_Country_of_Issue__c = passport_Country_of_Issue__c;
    }

    public String getPassport_Number__c() {
        return passport_Number__c;
    }

    public void setPassport_Number__c(String passport_Number__c) {
        this.passport_Number__c = passport_Number__c;
    }

    public String getPermanent_Address__c() {
        return permanent_Address__c;
    }

    public void setPermanent_Address__c(String permanent_Address__c) {
        this.permanent_Address__c = permanent_Address__c;
    }

    public String getPersonal_Photo__c() {
        return personal_Photo__c;
    }

    public void setPersonal_Photo__c(String personal_Photo__c) {
        this.personal_Photo__c = personal_Photo__c;
    }

    public String getPhoto__c() {
        return photo__c;
    }

    public void setPhoto__c(String photo__c) {
        this.photo__c = photo__c;
    }

    public QueryResult getProcessInstances() {
        return processInstances;
    }

    public void setProcessInstances(QueryResult processInstances) {
        this.processInstances = processInstances;
    }

    public QueryResult getProcessSteps() {
        return processSteps;
    }

    public void setProcessSteps(QueryResult processSteps) {
        this.processSteps = processSteps;
    }


    public QueryResult getRecordAssociatedGroups() {
        return recordAssociatedGroups;
    }

    public void setRecordAssociatedGroups(QueryResult recordAssociatedGroups) {
        this.recordAssociatedGroups = recordAssociatedGroups;
    }

    public RecordType getRecordType() {
        return recordType;
    }

    public void setRecordType(RecordType recordType) {
        this.recordType = recordType;
    }

    public String getRecordTypeId() {
        return recordTypeId;
    }

    public void setRecordTypeId(String recordTypeId) {
        this.recordTypeId = recordTypeId;
    }

    public String getRenewal_For__c() {
        return renewal_For__c;
    }

    public void setRenewal_For__c(String renewal_For__c) {
        this.renewal_For__c = renewal_For__c;
    }

    public String getRenewed_Card__c() {
        return renewed_Card__c;
    }

    public void setRenewed_Card__c(String renewed_Card__c) {
        this.renewed_Card__c = renewed_Card__c;
    }

    public String getRequest__c() {
        return request__c;
    }

    public void setRequest__c(String request__c) {
        this.request__c = request__c;
    }

    public String getRequested_From__c() {
        return requested_From__c;
    }

    public void setRequested_From__c(String requested_From__c) {
        this.requested_From__c = requested_From__c;
    }

    public String getSalutation__c() {
        return salutation__c;
    }

    public void setSalutation__c(String salutation__c) {
        this.salutation__c = salutation__c;
    }

    public String getService_Identifier__c() {
        return service_Identifier__c;
    }

    public void setService_Identifier__c(String service_Identifier__c) {
        this.service_Identifier__c = service_Identifier__c;
    }

    public String getSponsor_Mobile_No__c() {
        return sponsor_Mobile_No__c;
    }

    public void setSponsor_Mobile_No__c(String sponsor_Mobile_No__c) {
        this.sponsor_Mobile_No__c = sponsor_Mobile_No__c;
    }

    public String getSponsor_Relationship__c() {
        return sponsor_Relationship__c;
    }

    public void setSponsor_Relationship__c(String sponsor_Relationship__c) {
        this.sponsor_Relationship__c = sponsor_Relationship__c;
    }

    public String getSponsor_Tel__c() {
        return sponsor_Tel__c;
    }

    public void setSponsor_Tel__c(String sponsor_Tel__c) {
        this.sponsor_Tel__c = sponsor_Tel__c;
    }

    public String getSponsor__c() {
        return sponsor__c;
    }

    public void setSponsor__c(String sponsor__c) {
        this.sponsor__c = sponsor__c;
    }

    public String getStatus__c() {
        return status__c;
    }

    public void setStatus__c(String status__c) {
        this.status__c = status__c;
    }

    public String getSystemModstamp() {
        return systemModstamp;
    }

    public void setSystemModstamp(String systemModstamp) {
        this.systemModstamp = systemModstamp;
    }

    public QueryResult getTasks() {
        return tasks;
    }

    public void setTasks(QueryResult tasks) {
        this.tasks = tasks;
    }

    public QueryResult getTopicAssignments() {
        return topicAssignments;
    }

    public void setTopicAssignments(QueryResult topicAssignments) {
        this.topicAssignments = topicAssignments;
    }

    public String getVisa__c() {
        return visa__c;
    }

    public void setVisa__c(String visa__c) {
        this.visa__c = visa__c;
    }

    public String getWeb_Form__c() {
        return web_Form__c;
    }

    public void setWeb_Form__c(String web_Form__c) {
        this.web_Form__c = web_Form__c;
    }

    public double getAccLength__c() {
        return accLength__c;
    }

    public void setAccLength__c(double accLength__c) {
        this.accLength__c = accLength__c;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}