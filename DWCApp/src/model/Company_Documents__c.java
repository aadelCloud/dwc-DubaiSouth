/**
 * Company_Documents__c.java
 * <p/>
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package model;

import com.google.gson.annotations.SerializedName;

import org.codehaus.jackson.annotate.JsonProperty;

import model.QueryResult;

public class Company_Documents__c  implements java.io.Serializable {

    private QueryResult attachedContentDocuments;

    public model.attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(model.attributes attributes) {
        this.attributes = attributes;
    }

    @JsonProperty("attributes")
    attributes attributes;

    @JsonProperty("Attachment_Id__c")
    @SerializedName("Attachment_Id__c")
    private String attachment_Id__c;

    private QueryResult attachments;

    private String card_Management__c;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    @JsonProperty("Id")
    @SerializedName("Id")
    private String Id;

    private Card_Management__c card_Management__r;

    private String collected_By__c;

    private User collected_By__r;

    private java.util.Calendar collection_Date_Time__c;

    private QueryResult combinedAttachments;

    private String company__c;

    private Account company__r;

    @JsonProperty("Party__r")
    @SerializedName("Party__r")
    Party party;


    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }

    private User createdBy;

    private String createdById;

    @JsonProperty("CreatedDate")
    @SerializedName("CreatedDate")
    private java.util.Calendar createdDate;

    private String currencyIsoCode;

    @JsonProperty("Customer_Document__c")
    @SerializedName("Customer_Document__c")
    private Boolean customer_Document__c;

    @JsonProperty("Document_Type__c")
    @SerializedName("Document_Type__c")
    private String document_Type__c;

    private QueryResult duplicateRecordItems;

    private QueryResult feedSubscriptionsForEntity;
    @JsonProperty("file_Name__c")
    @SerializedName("file_Name__c")
    private String file_Name__c;

    private QueryResult histories;

    private Boolean isDeleted;

    private User lastModifiedBy;

    private String lastModifiedById;

    private java.util.Calendar lastModifiedDate;

    private java.util.Calendar lastReferencedDate;

    private java.util.Calendar lastViewedDate;

    private String license_Amendment__c;

    private String license__c;

    private QueryResult lookedUpFromActivities;

    private String NOC__c;

    private NOC__c NOC__r;

    @JsonProperty("Name")
    @SerializedName("Name")
    private String name;

    private QueryResult notes;

    private QueryResult notesAndAttachments;

    private String opportunity__c;

    @JsonProperty("Original_Collected__c")
    @SerializedName("Original_Collected__c")
    private Boolean original_Collected__c;

    @JsonProperty("Original_Verified__c")
    @SerializedName("Original_Verified__c")
    private Boolean original_Verified__c;

    @JsonProperty("Party__c")
    @SerializedName("Party__c")
    private String party__c;

    private Account party__r;

    private String passport__c;

    private QueryResult processInstances;

    private QueryResult processSteps;

    private QueryResult recordAssociatedGroups;

    @JsonProperty("RecordType")
    @SerializedName("RecordType")
    private RecordType recordType;

    private String recordTypeId;

    private String registration_Amendment__c;

    private String request__c;

    private Request request__r;

    @JsonProperty("Required_Original__c")
    @SerializedName("Required_Original__c")
    private Boolean required_Original__c;

    @JsonProperty("Required_Scan_copy__c")
    @SerializedName("Required_Scan_copy__c")
    private Boolean required_Scan_copy__c;

    private Boolean required_Template_from_DWC__c;

    private java.util.Calendar systemModstamp;

    private String template_Name_Link__c;

    private String tenancy_Contract__c;

    private QueryResult topicAssignments;

    @JsonProperty("Uploaded__c")
    @SerializedName("Uploaded__c")
    private Boolean uploaded__c;

    private java.util.Calendar verification_Date_Time__c;

    private String verified_By__c;

    private User verified_By__r;

    @JsonProperty("Verified_Scan_Copy__c")
    @SerializedName("Verified_Scan_Copy__c")
    private Boolean verified_Scan_Copy__c;

    @JsonProperty("Version__c")
    @SerializedName("Version__c")
    private Double version__c;

    private String view_Attachment__c;

    private String visa_Ref__c;

    private Visa visa_Ref__r;

    private String eServices_Document__c;

    private EServices_Document_Checklist__c eServices_Document__r;

    private Boolean hasAttachment;

    private Boolean hasAttachmentBefore;

    public Boolean getHasAttachmentBefore() {
        return hasAttachmentBefore;
    }

    public void setHasAttachmentBefore(Boolean hasAttachmentBefore) {
        this.hasAttachmentBefore = hasAttachmentBefore;
    }

    public Company_Documents__c() {
    }

    /**
     * Gets the attachedContentDocuments value for this Company_Documents__c.
     *
     * @return attachedContentDocuments
     */
    public QueryResult getAttachedContentDocuments() {
        return attachedContentDocuments;
    }


    /**
     * Sets the attachedContentDocuments value for this Company_Documents__c.
     *
     * @param attachedContentDocuments
     */
    public void setAttachedContentDocuments(QueryResult attachedContentDocuments) {
        this.attachedContentDocuments = attachedContentDocuments;
    }


    /**
     * Gets the attachment_Id__c value for this Company_Documents__c.
     *
     * @return attachment_Id__c
     */
    public String getAttachment_Id__c() {
        return attachment_Id__c;
    }


    /**
     * Sets the attachment_Id__c value for this Company_Documents__c.
     *
     * @param attachment_Id__c
     */
    public void setAttachment_Id__c(String attachment_Id__c) {
        this.attachment_Id__c = attachment_Id__c;
    }


    /**
     * Gets the attachments value for this Company_Documents__c.
     *
     * @return attachments
     */
    public QueryResult getAttachments() {
        return attachments;
    }


    /**
     * Sets the attachments value for this Company_Documents__c.
     *
     * @param attachments
     */
    public void setAttachments(QueryResult attachments) {
        this.attachments = attachments;
    }


    /**
     * Gets the card_Management__c value for this Company_Documents__c.
     *
     * @return card_Management__c
     */
    public String getCard_Management__c() {
        return card_Management__c;
    }


    /**
     * Sets the card_Management__c value for this Company_Documents__c.
     *
     * @param card_Management__c
     */
    public void setCard_Management__c(String card_Management__c) {
        this.card_Management__c = card_Management__c;
    }


    /**
     * Gets the card_Management__r value for this Company_Documents__c.
     *
     * @return card_Management__r
     */
    public Card_Management__c getCard_Management__r() {
        return card_Management__r;
    }


    /**
     * Sets the card_Management__r value for this Company_Documents__c.
     *
     * @param card_Management__r
     */
    public void setCard_Management__r(Card_Management__c card_Management__r) {
        this.card_Management__r = card_Management__r;
    }


    /**
     * Gets the collected_By__c value for this Company_Documents__c.
     *
     * @return collected_By__c
     */
    public String getCollected_By__c() {
        return collected_By__c;
    }


    /**
     * Sets the collected_By__c value for this Company_Documents__c.
     *
     * @param collected_By__c
     */
    public void setCollected_By__c(String collected_By__c) {
        this.collected_By__c = collected_By__c;
    }


    /**
     * Gets the collected_By__r value for this Company_Documents__c.
     *
     * @return collected_By__r
     */
    public User getCollected_By__r() {
        return collected_By__r;
    }


    /**
     * Sets the collected_By__r value for this Company_Documents__c.
     *
     * @param collected_By__r
     */
    public void setCollected_By__r(User collected_By__r) {
        this.collected_By__r = collected_By__r;
    }


    /**
     * Gets the collection_Date_Time__c value for this Company_Documents__c.
     *
     * @return collection_Date_Time__c
     */
    public java.util.Calendar getCollection_Date_Time__c() {
        return collection_Date_Time__c;
    }


    /**
     * Sets the collection_Date_Time__c value for this Company_Documents__c.
     *
     * @param collection_Date_Time__c
     */
    public void setCollection_Date_Time__c(java.util.Calendar collection_Date_Time__c) {
        this.collection_Date_Time__c = collection_Date_Time__c;
    }


    /**
     * Gets the combinedAttachments value for this Company_Documents__c.
     *
     * @return combinedAttachments
     */
    public QueryResult getCombinedAttachments() {
        return combinedAttachments;
    }


    /**
     * Sets the combinedAttachments value for this Company_Documents__c.
     *
     * @param combinedAttachments
     */
    public void setCombinedAttachments(QueryResult combinedAttachments) {
        this.combinedAttachments = combinedAttachments;
    }


    /**
     * Gets the company__c value for this Company_Documents__c.
     *
     * @return company__c
     */
    public String getCompany__c() {
        return company__c;
    }


    /**
     * Sets the company__c value for this Company_Documents__c.
     *
     * @param company__c
     */
    public void setCompany__c(String company__c) {
        this.company__c = company__c;
    }


    /**
     * Gets the company__r value for this Company_Documents__c.
     *
     * @return company__r
     */
    public Account getCompany__r() {
        return company__r;
    }


    /**
     * Sets the company__r value for this Company_Documents__c.
     *
     * @param company__r
     */
    public void setCompany__r(Account company__r) {
        this.company__r = company__r;
    }


    /**
     * Gets the createdBy value for this Company_Documents__c.
     *
     * @return createdBy
     */
    public User getCreatedBy() {
        return createdBy;
    }


    /**
     * Sets the createdBy value for this Company_Documents__c.
     *
     * @param createdBy
     */
    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }


    /**
     * Gets the createdById value for this Company_Documents__c.
     *
     * @return createdById
     */
    public String getCreatedById() {
        return createdById;
    }


    /**
     * Sets the createdById value for this Company_Documents__c.
     *
     * @param createdById
     */
    public void setCreatedById(String createdById) {
        this.createdById = createdById;
    }


    /**
     * Gets the createdDate value for this Company_Documents__c.
     *
     * @return createdDate
     */
    public java.util.Calendar getCreatedDate() {
        return createdDate;
    }


    /**
     * Sets the createdDate value for this Company_Documents__c.
     *
     * @param createdDate
     */
    public void setCreatedDate(java.util.Calendar createdDate) {
        this.createdDate = createdDate;
    }


    /**
     * Gets the currencyIsoCode value for this Company_Documents__c.
     *
     * @return currencyIsoCode
     */
    public String getCurrencyIsoCode() {
        return currencyIsoCode;
    }


    /**
     * Sets the currencyIsoCode value for this Company_Documents__c.
     *
     * @param currencyIsoCode
     */
    public void setCurrencyIsoCode(String currencyIsoCode) {
        this.currencyIsoCode = currencyIsoCode;
    }


    /**
     * Gets the customer_Document__c value for this Company_Documents__c.
     *
     * @return customer_Document__c
     */
    public Boolean getCustomer_Document__c() {
        return customer_Document__c;
    }


    /**
     * Sets the customer_Document__c value for this Company_Documents__c.
     *
     * @param customer_Document__c
     */
    public void setCustomer_Document__c(Boolean customer_Document__c) {
        this.customer_Document__c = customer_Document__c;
    }


    /**
     * Gets the document_Type__c value for this Company_Documents__c.
     *
     * @return document_Type__c
     */
    public String getDocument_Type__c() {
        return document_Type__c;
    }


    /**
     * Sets the document_Type__c value for this Company_Documents__c.
     *
     * @param document_Type__c
     */
    public void setDocument_Type__c(String document_Type__c) {
        this.document_Type__c = document_Type__c;
    }


    /**
     * Gets the duplicateRecordItems value for this Company_Documents__c.
     *
     * @return duplicateRecordItems
     */
    public QueryResult getDuplicateRecordItems() {
        return duplicateRecordItems;
    }


    /**
     * Sets the duplicateRecordItems value for this Company_Documents__c.
     *
     * @param duplicateRecordItems
     */
    public void setDuplicateRecordItems(QueryResult duplicateRecordItems) {
        this.duplicateRecordItems = duplicateRecordItems;
    }


    /**
     * Gets the feedSubscriptionsForEntity value for this Company_Documents__c.
     *
     * @return feedSubscriptionsForEntity
     */
    public QueryResult getFeedSubscriptionsForEntity() {
        return feedSubscriptionsForEntity;
    }


    /**
     * Sets the feedSubscriptionsForEntity value for this Company_Documents__c.
     *
     * @param feedSubscriptionsForEntity
     */
    public void setFeedSubscriptionsForEntity(QueryResult feedSubscriptionsForEntity) {
        this.feedSubscriptionsForEntity = feedSubscriptionsForEntity;
    }


    /**
     * Gets the file_Name__c value for this Company_Documents__c.
     *
     * @return file_Name__c
     */
    public String getFile_Name__c() {
        return file_Name__c;
    }


    /**
     * Sets the file_Name__c value for this Company_Documents__c.
     *
     * @param file_Name__c
     */
    public void setFile_Name__c(String file_Name__c) {
        this.file_Name__c = file_Name__c;
    }


    /**
     * Gets the histories value for this Company_Documents__c.
     *
     * @return histories
     */
    public QueryResult getHistories() {
        return histories;
    }


    /**
     * Sets the histories value for this Company_Documents__c.
     *
     * @param histories
     */
    public void setHistories(QueryResult histories) {
        this.histories = histories;
    }


    /**
     * Gets the isDeleted value for this Company_Documents__c.
     *
     * @return isDeleted
     */
    public Boolean getIsDeleted() {
        return isDeleted;
    }


    /**
     * Sets the isDeleted value for this Company_Documents__c.
     *
     * @param isDeleted
     */
    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }


    /**
     * Gets the lastModifiedBy value for this Company_Documents__c.
     *
     * @return lastModifiedBy
     */
    public User getLastModifiedBy() {
        return lastModifiedBy;
    }


    /**
     * Sets the lastModifiedBy value for this Company_Documents__c.
     *
     * @param lastModifiedBy
     */
    public void setLastModifiedBy(User lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }


    /**
     * Gets the lastModifiedById value for this Company_Documents__c.
     *
     * @return lastModifiedById
     */
    public String getLastModifiedById() {
        return lastModifiedById;
    }


    /**
     * Sets the lastModifiedById value for this Company_Documents__c.
     *
     * @param lastModifiedById
     */
    public void setLastModifiedById(String lastModifiedById) {
        this.lastModifiedById = lastModifiedById;
    }


    /**
     * Gets the lastModifiedDate value for this Company_Documents__c.
     *
     * @return lastModifiedDate
     */
    public java.util.Calendar getLastModifiedDate() {
        return lastModifiedDate;
    }


    /**
     * Sets the lastModifiedDate value for this Company_Documents__c.
     *
     * @param lastModifiedDate
     */
    public void setLastModifiedDate(java.util.Calendar lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }


    /**
     * Gets the lastReferencedDate value for this Company_Documents__c.
     *
     * @return lastReferencedDate
     */
    public java.util.Calendar getLastReferencedDate() {
        return lastReferencedDate;
    }


    /**
     * Sets the lastReferencedDate value for this Company_Documents__c.
     *
     * @param lastReferencedDate
     */
    public void setLastReferencedDate(java.util.Calendar lastReferencedDate) {
        this.lastReferencedDate = lastReferencedDate;
    }


    /**
     * Gets the lastViewedDate value for this Company_Documents__c.
     *
     * @return lastViewedDate
     */
    public java.util.Calendar getLastViewedDate() {
        return lastViewedDate;
    }


    /**
     * Sets the lastViewedDate value for this Company_Documents__c.
     *
     * @param lastViewedDate
     */
    public void setLastViewedDate(java.util.Calendar lastViewedDate) {
        this.lastViewedDate = lastViewedDate;
    }


    /**
     * Gets the license_Amendment__c value for this Company_Documents__c.
     *
     * @return license_Amendment__c
     */
    public String getLicense_Amendment__c() {
        return license_Amendment__c;
    }


    /**
     * Sets the license_Amendment__c value for this Company_Documents__c.
     *
     * @param license_Amendment__c
     */
    public void setLicense_Amendment__c(String license_Amendment__c) {
        this.license_Amendment__c = license_Amendment__c;
    }


    /**
     * Gets the license__c value for this Company_Documents__c.
     *
     * @return license__c
     */
    public String getLicense__c() {
        return license__c;
    }


    /**
     * Sets the license__c value for this Company_Documents__c.
     *
     * @param license__c
     */
    public void setLicense__c(String license__c) {
        this.license__c = license__c;
    }


    /**
     * Gets the lookedUpFromActivities value for this Company_Documents__c.
     *
     * @return lookedUpFromActivities
     */
    public QueryResult getLookedUpFromActivities() {
        return lookedUpFromActivities;
    }


    /**
     * Sets the lookedUpFromActivities value for this Company_Documents__c.
     *
     * @param lookedUpFromActivities
     */
    public void setLookedUpFromActivities(QueryResult lookedUpFromActivities) {
        this.lookedUpFromActivities = lookedUpFromActivities;
    }


    /**
     * Gets the NOC__c value for this Company_Documents__c.
     *
     * @return NOC__c
     */
    public String getNOC__c() {
        return NOC__c;
    }


    /**
     * Sets the NOC__c value for this Company_Documents__c.
     *
     * @param NOC__c
     */
    public void setNOC__c(String NOC__c) {
        this.NOC__c = NOC__c;
    }


    /**
     * Gets the NOC__r value for this Company_Documents__c.
     *
     * @return NOC__r
     */
    public NOC__c getNOC__r() {
        return NOC__r;
    }


    /**
     * Sets the NOC__r value for this Company_Documents__c.
     *
     * @param NOC__r
     */
    public void setNOC__r(NOC__c NOC__r) {
        this.NOC__r = NOC__r;
    }


    /**
     * Gets the name value for this Company_Documents__c.
     *
     * @return name
     */
    public String getName() {
        return name;
    }


    /**
     * Sets the name value for this Company_Documents__c.
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * Gets the notes value for this Company_Documents__c.
     *
     * @return notes
     */
    public QueryResult getNotes() {
        return notes;
    }


    /**
     * Sets the notes value for this Company_Documents__c.
     *
     * @param notes
     */
    public void setNotes(QueryResult notes) {
        this.notes = notes;
    }


    /**
     * Gets the notesAndAttachments value for this Company_Documents__c.
     *
     * @return notesAndAttachments
     */
    public QueryResult getNotesAndAttachments() {
        return notesAndAttachments;
    }


    /**
     * Sets the notesAndAttachments value for this Company_Documents__c.
     *
     * @param notesAndAttachments
     */
    public void setNotesAndAttachments(QueryResult notesAndAttachments) {
        this.notesAndAttachments = notesAndAttachments;
    }


    /**
     * Gets the opportunity__c value for this Company_Documents__c.
     *
     * @return opportunity__c
     */
    public String getOpportunity__c() {
        return opportunity__c;
    }


    /**
     * Sets the opportunity__c value for this Company_Documents__c.
     *
     * @param opportunity__c
     */
    public void setOpportunity__c(String opportunity__c) {
        this.opportunity__c = opportunity__c;
    }


    /**
     * Gets the original_Collected__c value for this Company_Documents__c.
     *
     * @return original_Collected__c
     */
    public Boolean getOriginal_Collected__c() {
        return original_Collected__c;
    }


    /**
     * Sets the original_Collected__c value for this Company_Documents__c.
     *
     * @param original_Collected__c
     */
    public void setOriginal_Collected__c(Boolean original_Collected__c) {
        this.original_Collected__c = original_Collected__c;
    }


    /**
     * Gets the original_Verified__c value for this Company_Documents__c.
     *
     * @return original_Verified__c
     */
    public Boolean getOriginal_Verified__c() {
        return original_Verified__c;
    }


    /**
     * Sets the original_Verified__c value for this Company_Documents__c.
     *
     * @param original_Verified__c
     */
    public void setOriginal_Verified__c(Boolean original_Verified__c) {
        this.original_Verified__c = original_Verified__c;
    }


    /**
     * Gets the party__c value for this Company_Documents__c.
     *
     * @return party__c
     */
    public String getParty__c() {
        return party__c;
    }


    /**
     * Sets the party__c value for this Company_Documents__c.
     *
     * @param party__c
     */
    public void setParty__c(String party__c) {
        this.party__c = party__c;
    }


    /**
     * Gets the party__r value for this Company_Documents__c.
     *
     * @return party__r
     */
    public Account getParty__r() {
        return party__r;
    }


    /**
     * Sets the party__r value for this Company_Documents__c.
     *
     * @param party__r
     */
    public void setParty__r(Account party__r) {
        this.party__r = party__r;
    }


    /**
     * Gets the passport__c value for this Company_Documents__c.
     *
     * @return passport__c
     */
    public String getPassport__c() {
        return passport__c;
    }


    /**
     * Sets the passport__c value for this Company_Documents__c.
     *
     * @param passport__c
     */
    public void setPassport__c(String passport__c) {
        this.passport__c = passport__c;
    }

    /**
     * Gets the processInstances value for this Company_Documents__c.
     *
     * @return processInstances
     */
    public QueryResult getProcessInstances() {
        return processInstances;
    }


    /**
     * Sets the processInstances value for this Company_Documents__c.
     *
     * @param processInstances
     */
    public void setProcessInstances(QueryResult processInstances) {
        this.processInstances = processInstances;
    }


    /**
     * Gets the processSteps value for this Company_Documents__c.
     *
     * @return processSteps
     */
    public QueryResult getProcessSteps() {
        return processSteps;
    }


    /**
     * Sets the processSteps value for this Company_Documents__c.
     *
     * @param processSteps
     */
    public void setProcessSteps(QueryResult processSteps) {
        this.processSteps = processSteps;
    }


    /**
     * Gets the recordAssociatedGroups value for this Company_Documents__c.
     *
     * @return recordAssociatedGroups
     */
    public QueryResult getRecordAssociatedGroups() {
        return recordAssociatedGroups;
    }


    /**
     * Sets the recordAssociatedGroups value for this Company_Documents__c.
     *
     * @param recordAssociatedGroups
     */
    public void setRecordAssociatedGroups(QueryResult recordAssociatedGroups) {
        this.recordAssociatedGroups = recordAssociatedGroups;
    }


    /**
     * Gets the recordType value for this Company_Documents__c.
     *
     * @return recordType
     */
    public RecordType getRecordType() {
        return recordType;
    }


    /**
     * Sets the recordType value for this Company_Documents__c.
     *
     * @param recordType
     */
    public void setRecordType(RecordType recordType) {
        this.recordType = recordType;
    }


    /**
     * Gets the recordTypeId value for this Company_Documents__c.
     *
     * @return recordTypeId
     */
    public String getRecordTypeId() {
        return recordTypeId;
    }


    /**
     * Sets the recordTypeId value for this Company_Documents__c.
     *
     * @param recordTypeId
     */
    public void setRecordTypeId(String recordTypeId) {
        this.recordTypeId = recordTypeId;
    }


    /**
     * Gets the registration_Amendment__c value for this Company_Documents__c.
     *
     * @return registration_Amendment__c
     */
    public String getRegistration_Amendment__c() {
        return registration_Amendment__c;
    }


    /**
     * Sets the registration_Amendment__c value for this Company_Documents__c.
     *
     * @param registration_Amendment__c
     */
    public void setRegistration_Amendment__c(String registration_Amendment__c) {
        this.registration_Amendment__c = registration_Amendment__c;
    }

    /**
     * Gets the request__c value for this Company_Documents__c.
     *
     * @return request__c
     */
    public String getRequest__c() {
        return request__c;
    }


    /**
     * Sets the request__c value for this Company_Documents__c.
     *
     * @param request__c
     */
    public void setRequest__c(String request__c) {
        this.request__c = request__c;
    }


    /**
     * Gets the request__r value for this Company_Documents__c.
     *
     * @return request__r
     */
    public Request getRequest__r() {
        return request__r;
    }


    /**
     * Sets the request__r value for this Company_Documents__c.
     *
     * @param request__r
     */
    public void setRequest__r(Request request__r) {
        this.request__r = request__r;
    }


    /**
     * Gets the required_Original__c value for this Company_Documents__c.
     *
     * @return required_Original__c
     */
    public Boolean getRequired_Original__c() {
        return required_Original__c;
    }


    /**
     * Sets the required_Original__c value for this Company_Documents__c.
     *
     * @param required_Original__c
     */
    public void setRequired_Original__c(Boolean required_Original__c) {
        this.required_Original__c = required_Original__c;
    }


    /**
     * Gets the required_Scan_copy__c value for this Company_Documents__c.
     *
     * @return required_Scan_copy__c
     */
    public Boolean getRequired_Scan_copy__c() {
        return required_Scan_copy__c;
    }


    /**
     * Sets the required_Scan_copy__c value for this Company_Documents__c.
     *
     * @param required_Scan_copy__c
     */
    public void setRequired_Scan_copy__c(Boolean required_Scan_copy__c) {
        this.required_Scan_copy__c = required_Scan_copy__c;
    }


    /**
     * Gets the required_Template_from_DWC__c value for this Company_Documents__c.
     *
     * @return required_Template_from_DWC__c
     */
    public Boolean getRequired_Template_from_DWC__c() {
        return required_Template_from_DWC__c;
    }


    /**
     * Sets the required_Template_from_DWC__c value for this Company_Documents__c.
     *
     * @param required_Template_from_DWC__c
     */
    public void setRequired_Template_from_DWC__c(Boolean required_Template_from_DWC__c) {
        this.required_Template_from_DWC__c = required_Template_from_DWC__c;
    }


    /**
     * Gets the systemModstamp value for this Company_Documents__c.
     *
     * @return systemModstamp
     */
    public java.util.Calendar getSystemModstamp() {
        return systemModstamp;
    }


    /**
     * Sets the systemModstamp value for this Company_Documents__c.
     *
     * @param systemModstamp
     */
    public void setSystemModstamp(java.util.Calendar systemModstamp) {
        this.systemModstamp = systemModstamp;
    }


    /**
     * Gets the template_Name_Link__c value for this Company_Documents__c.
     *
     * @return template_Name_Link__c
     */
    public String getTemplate_Name_Link__c() {
        return template_Name_Link__c;
    }


    /**
     * Sets the template_Name_Link__c value for this Company_Documents__c.
     *
     * @param template_Name_Link__c
     */
    public void setTemplate_Name_Link__c(String template_Name_Link__c) {
        this.template_Name_Link__c = template_Name_Link__c;
    }


    /**
     * Gets the tenancy_Contract__c value for this Company_Documents__c.
     *
     * @return tenancy_Contract__c
     */
    public String getTenancy_Contract__c() {
        return tenancy_Contract__c;
    }


    /**
     * Sets the tenancy_Contract__c value for this Company_Documents__c.
     *
     * @param tenancy_Contract__c
     */
    public void setTenancy_Contract__c(String tenancy_Contract__c) {
        this.tenancy_Contract__c = tenancy_Contract__c;
    }

    /**
     * Gets the topicAssignments value for this Company_Documents__c.
     *
     * @return topicAssignments
     */
    public QueryResult getTopicAssignments() {
        return topicAssignments;
    }


    /**
     * Sets the topicAssignments value for this Company_Documents__c.
     *
     * @param topicAssignments
     */
    public void setTopicAssignments(QueryResult topicAssignments) {
        this.topicAssignments = topicAssignments;
    }


    /**
     * Gets the uploaded__c value for this Company_Documents__c.
     *
     * @return uploaded__c
     */
    public Boolean getUploaded__c() {
        return uploaded__c;
    }


    /**
     * Sets the uploaded__c value for this Company_Documents__c.
     *
     * @param uploaded__c
     */
    public void setUploaded__c(Boolean uploaded__c) {
        this.uploaded__c = uploaded__c;
    }

    /**
     * Gets the verification_Date_Time__c value for this Company_Documents__c.
     *
     * @return verification_Date_Time__c
     */
    public java.util.Calendar getVerification_Date_Time__c() {
        return verification_Date_Time__c;
    }


    /**
     * Sets the verification_Date_Time__c value for this Company_Documents__c.
     *
     * @param verification_Date_Time__c
     */
    public void setVerification_Date_Time__c(java.util.Calendar verification_Date_Time__c) {
        this.verification_Date_Time__c = verification_Date_Time__c;
    }


    /**
     * Gets the verified_By__c value for this Company_Documents__c.
     *
     * @return verified_By__c
     */
    public String getVerified_By__c() {
        return verified_By__c;
    }


    /**
     * Sets the verified_By__c value for this Company_Documents__c.
     *
     * @param verified_By__c
     */
    public void setVerified_By__c(String verified_By__c) {
        this.verified_By__c = verified_By__c;
    }


    /**
     * Gets the verified_By__r value for this Company_Documents__c.
     *
     * @return verified_By__r
     */
    public User getVerified_By__r() {
        return verified_By__r;
    }


    /**
     * Sets the verified_By__r value for this Company_Documents__c.
     *
     * @param verified_By__r
     */
    public void setVerified_By__r(User verified_By__r) {
        this.verified_By__r = verified_By__r;
    }


    /**
     * Gets the verified_Scan_Copy__c value for this Company_Documents__c.
     *
     * @return verified_Scan_Copy__c
     */
    public Boolean getVerified_Scan_Copy__c() {
        return verified_Scan_Copy__c;
    }


    /**
     * Sets the verified_Scan_Copy__c value for this Company_Documents__c.
     *
     * @param verified_Scan_Copy__c
     */
    public void setVerified_Scan_Copy__c(Boolean verified_Scan_Copy__c) {
        this.verified_Scan_Copy__c = verified_Scan_Copy__c;
    }


    /**
     * Gets the version__c value for this Company_Documents__c.
     *
     * @return version__c
     */
    public Double getVersion__c() {
        return version__c;
    }


    /**
     * Sets the version__c value for this Company_Documents__c.
     *
     * @param version__c
     */
    public void setVersion__c(Double version__c) {
        this.version__c = version__c;
    }


    /**
     * Gets the view_Attachment__c value for this Company_Documents__c.
     *
     * @return view_Attachment__c
     */
    public String getView_Attachment__c() {
        return view_Attachment__c;
    }


    /**
     * Sets the view_Attachment__c value for this Company_Documents__c.
     *
     * @param view_Attachment__c
     */
    public void setView_Attachment__c(String view_Attachment__c) {
        this.view_Attachment__c = view_Attachment__c;
    }


    /**
     * Gets the visa_Ref__c value for this Company_Documents__c.
     *
     * @return visa_Ref__c
     */
    public String getVisa_Ref__c() {
        return visa_Ref__c;
    }


    /**
     * Sets the visa_Ref__c value for this Company_Documents__c.
     *
     * @param visa_Ref__c
     */
    public void setVisa_Ref__c(String visa_Ref__c) {
        this.visa_Ref__c = visa_Ref__c;
    }


    /**
     * Gets the visa_Ref__r value for this Company_Documents__c.
     *
     * @return visa_Ref__r
     */
    public Visa getVisa_Ref__r() {
        return visa_Ref__r;
    }


    /**
     * Sets the visa_Ref__r value for this Company_Documents__c.
     *
     * @param visa_Ref__r
     */
    public void setVisa_Ref__r(Visa visa_Ref__r) {
        this.visa_Ref__r = visa_Ref__r;
    }


    /**
     * Gets the eServices_Document__c value for this Company_Documents__c.
     *
     * @return eServices_Document__c
     */
    public String getEServices_Document__c() {
        return eServices_Document__c;
    }


    /**
     * Sets the eServices_Document__c value for this Company_Documents__c.
     *
     * @param eServices_Document__c
     */
    public void setEServices_Document__c(String eServices_Document__c) {
        this.eServices_Document__c = eServices_Document__c;
    }


    /**
     * Gets the eServices_Document__r value for this Company_Documents__c.
     *
     * @return eServices_Document__r
     */
    public EServices_Document_Checklist__c getEServices_Document__r() {
        return eServices_Document__r;
    }


    /**
     * Sets the eServices_Document__r value for this Company_Documents__c.
     *
     * @param eServices_Document__r
     */
    public void setEServices_Document__r(EServices_Document_Checklist__c eServices_Document__r) {
        this.eServices_Document__r = eServices_Document__r;
    }

    public Boolean getHasAttachment() {
        return hasAttachment;
    }

    public void setHasAttachment(Boolean hasAttachment) {
        this.hasAttachment = hasAttachment;
    }
}