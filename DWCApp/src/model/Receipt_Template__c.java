/**
 * Receipt_Template__c.java
 * <p/>
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package model;

import com.google.gson.annotations.SerializedName;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.ArrayList;

public class Receipt_Template__c extends SObject implements java.io.Serializable {

    public model.attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(model.attributes attributes) {
        this.attributes = attributes;
    }

    @JsonProperty("attributes")
    attributes attributes;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    @SerializedName("Id")
    @JsonProperty("Id")
    String ID;

    private Double active_Fee_Management_Fee__c;

    private Double amount__c;

    private String approval_Process_Name__c;

    private Boolean approval_Required__c;

    @JsonProperty("attachedContentDocuments")
    @SerializedName("attachedContentDocuments")
    private QueryResult attachedContentDocuments;

    @JsonProperty("attachments")
    @SerializedName("attachments")
    private QueryResult attachments;

    private String authority__c;

    private Boolean auto_Populated__c;

    private String available_for_Profiles__c;

    private String cancel_Page_Link__c;

    @JsonProperty("Cancel_VF_Generator__c")
    @SerializedName("Cancel_VF_Generator__c")
    private String cancel_VF_Generator__c;

    public String getDocument_Type() {
        return Document_Type;
    }

    public void setDocument_Type(String document_Type) {
        Document_Type = document_Type;
    }

    @SerializedName("Document_Type__c")
    @JsonProperty("Document_Type__c")
    private String Document_Type;
    @JsonProperty("Type__c")
    private String type;

    private Web_Form__c cancel_VF_Generator__r;

    private QueryResult cases__r;

    private String category__c;

    private QueryResult combinedAttachments;

    private User createdBy;

    private String createdById;

    private java.util.Calendar createdDate;

    private String currencyIsoCode;

    private Double default_Processing_Fee__c;

    private String detail_View_P__c;

    @SerializedName("Display_Name__c")
    @JsonProperty("Display_Name__c")
    private String display_Name__c;

    private Boolean document_Required__c;

    private Double document_Upload_Count__c;

    private QueryResult duplicateRecordItems;

    private String duration__c;

    private String ERP_Name__c;

    private String ERP_Service_Name__c;

    private String external_ID__c;

    private QueryResult fee_Management__r;

    private QueryResult feedSubscriptionsForEntity;

    private Boolean internal_Use__c;

    private QueryResult inventory_Units__r;

    private QueryResult invoice_Line_Items__r;

    private Boolean isDeleted;

    private Boolean is_Active__c;
    @SerializedName("Knowledge_Fee__c")
    private String knowledge_Fee__c;
    @SerializedName("Knowledge_Fee__r")
    private Receipt_Template__c knowledge_Fee__r;

    private User lastModifiedBy;

    private String lastModifiedById;

    private java.util.Calendar lastModifiedDate;

    private java.util.Calendar lastReferencedDate;

    private java.util.Calendar lastViewedDate;

    private QueryResult lookedUpFromActivities;

    @JsonProperty("NOC_Type__c")
    private String NOC_Type__c;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("New_Edit_VF_Generator__c")
    @SerializedName("New_Edit_VF_Generator__c")
    private String new_Edit_VF_Generator__c;

    @JsonProperty("New_Edit_VF_Generator__r")
    private Web_Form__c new_Edit_VF_Generator__r;

    private QueryResult notes;

    private QueryResult notesAndAttachments;

    private String ownerId;

    private QueryResult processInstances;

    private QueryResult processSteps;

    private QueryResult proposed_Documents_Check_List__r;

    private QueryResult receipt_Line_Items__r;

    private QueryResult recordAssociatedGroups;

    private RecordType recordType;

    @JsonProperty("RecordTypeId")
    private String recordTypeId;
    @JsonProperty("Record_Type_Picklist__c")
    @SerializedName("Record_Type_Picklist__c")
    private String record_Type_Picklist__c;
    @JsonProperty("Redirect_Page__c")
    @SerializedName("Redirect_Page__c")
    private String redirect_Page__c;

    @JsonProperty("Related_to_Object__c")
    @SerializedName("Related_to_Object__c")
    private String related_to_Object__c;

    private String renewal_Page_Link__c;

    @JsonProperty("Renewal_VF_Generator__c")
    @SerializedName("Renewal_VF_Generator__c")
    private String renewal_VF_Generator__c;

    private Web_Form__c renewal_VF_Generator__r;

    private String replace_Page_Link__c;

    @JsonProperty("Replace_VF_Generator__c")
    @SerializedName("Replace_VF_Generator__c")
    private String replace_VF_Generator__c;

    private Web_Form__c replace_VF_Generator__r;

    private Boolean require_Knowledge_Fee__c;

    private Boolean required_Access_Card_Ref__c;

    private Boolean required_Account_Ref__c;

    private Boolean required_Agreement_Payment_Ref__c;

    private Boolean required_License_Amendment_Ref__c;

    private Boolean required_License_Ref__c;

    private Boolean required_NOC_Ref__c;

    private Boolean required_Quote_Ref__c;

    private Boolean required_Registration_Amendment_Ref__c;

    private Boolean required_Visa_Ref__c;

    private String service_Abb__c;

    private String service_GL_Code__c;

    @JsonProperty("Service_Identifier__c")
    @SerializedName("Service_Identifier__c")
    private String service_Identifier__c;

    private String service_Name__c;

    @JsonProperty("Service_Type__c")
    @SerializedName("Service_Type__c")
    private String service_Type__c;

    @JsonProperty("Service_VF_Page__c")
    @SerializedName("Service_VF_Page__c")
    private String service_VF_Page__c;

    @JsonProperty("Short_Service_Name__c")
    @SerializedName("Short_Service_Name__c")
    private String short_Service_Name__c;

    @JsonProperty("Sub_Category__c")
    @SerializedName("Sub_Category__c")
    private String sub_Category__c;

    private java.util.Calendar systemModstamp;

    private QueryResult topicAssignments;

    @SerializedName("Total_Amount__c ")
    private double total_Amount__c;

    @JsonProperty("Visa_Type__c")
    @SerializedName("Visa_Type__c")
    private String visa_Type__c;

    private QueryResult eService_Administration__r;

    @JsonProperty("EService_ERP_Details__c")
    @SerializedName("EService_ERP_Details__c")
    private String eService_ERP_Details__c;

    @JsonProperty("EServices_Document_Checklists1__r")
    @SerializedName("EServices_Document_Checklists1__r")
    private QueryResult eServices_Document_Checklists1__r;

    @JsonProperty("eServices_Document_Checklists__r")
    @SerializedName("eServices_Document_Checklists__r")
    private QueryResult eServices_Document_Checklists__r;

    @JsonProperty("IsAvailableOnPortal__c")
    @SerializedName("IsAvailableOnPortal__c")
    private Boolean isAvailableOnPortal__c;

    //@JsonProperty("records")
    ArrayList<EServices_Document_Checklist__c> eServices_document_checklist__c;

    public ArrayList<EServices_Document_Checklist__c> geteServices_document_checklist__c() {
        return eServices_document_checklist__c;
    }

    public void seteServices_document_checklist__c(ArrayList<EServices_Document_Checklist__c> eServices_document_checklist__c) {
        this.eServices_document_checklist__c = eServices_document_checklist__c;
    }


    public Receipt_Template__c() {
    }


    /**
     * Gets the active_Fee_Management_Fee__c value for this Receipt_Template__c.
     *
     * @return active_Fee_Management_Fee__c
     */
    public Double getActive_Fee_Management_Fee__c() {
        return active_Fee_Management_Fee__c;
    }


    /**
     * Sets the active_Fee_Management_Fee__c value for this Receipt_Template__c.
     *
     * @param active_Fee_Management_Fee__c
     */
    public void setActive_Fee_Management_Fee__c(Double active_Fee_Management_Fee__c) {
        this.active_Fee_Management_Fee__c = active_Fee_Management_Fee__c;
    }


    /**
     * Gets the amount__c value for this Receipt_Template__c.
     *
     * @return amount__c
     */
    public Double getAmount__c() {
        return amount__c;
    }


    /**
     * Sets the amount__c value for this Receipt_Template__c.
     *
     * @param amount__c
     */
    public void setAmount__c(Double amount__c) {
        this.amount__c = amount__c;
    }


    /**
     * Gets the approval_Process_Name__c value for this Receipt_Template__c.
     *
     * @return approval_Process_Name__c
     */
    public String getApproval_Process_Name__c() {
        return approval_Process_Name__c;
    }


    /**
     * Sets the approval_Process_Name__c value for this Receipt_Template__c.
     *
     * @param approval_Process_Name__c
     */
    public void setApproval_Process_Name__c(String approval_Process_Name__c) {
        this.approval_Process_Name__c = approval_Process_Name__c;
    }


    /**
     * Gets the approval_Required__c value for this Receipt_Template__c.
     *
     * @return approval_Required__c
     */
    public Boolean getApproval_Required__c() {
        return approval_Required__c;
    }


    /**
     * Sets the approval_Required__c value for this Receipt_Template__c.
     *
     * @param approval_Required__c
     */
    public void setApproval_Required__c(Boolean approval_Required__c) {
        this.approval_Required__c = approval_Required__c;
    }


    /**
     * Gets the attachedContentDocuments value for this Receipt_Template__c.
     *
     * @return attachedContentDocuments
     */
    public QueryResult getAttachedContentDocuments() {
        return attachedContentDocuments;
    }


    /**
     * Sets the attachedContentDocuments value for this Receipt_Template__c.
     *
     * @param attachedContentDocuments
     */
    public void setAttachedContentDocuments(QueryResult attachedContentDocuments) {
        this.attachedContentDocuments = attachedContentDocuments;
    }


    /**
     * Gets the attachments value for this Receipt_Template__c.
     *
     * @return attachments
     */
    public QueryResult getAttachments() {
        return attachments;
    }


    /**
     * Sets the attachments value for this Receipt_Template__c.
     *
     * @param attachments
     */
    public void setAttachments(QueryResult attachments) {
        this.attachments = attachments;
    }


    /**
     * Gets the authority__c value for this Receipt_Template__c.
     *
     * @return authority__c
     */
    public String getAuthority__c() {
        return authority__c;
    }


    /**
     * Sets the authority__c value for this Receipt_Template__c.
     *
     * @param authority__c
     */
    public void setAuthority__c(String authority__c) {
        this.authority__c = authority__c;
    }


    /**
     * Gets the auto_Populated__c value for this Receipt_Template__c.
     *
     * @return auto_Populated__c
     */
    public Boolean getAuto_Populated__c() {
        return auto_Populated__c;
    }


    /**
     * Sets the auto_Populated__c value for this Receipt_Template__c.
     *
     * @param auto_Populated__c
     */
    public void setAuto_Populated__c(Boolean auto_Populated__c) {
        this.auto_Populated__c = auto_Populated__c;
    }


    /**
     * Gets the available_for_Profiles__c value for this Receipt_Template__c.
     *
     * @return available_for_Profiles__c
     */
    public String getAvailable_for_Profiles__c() {
        return available_for_Profiles__c;
    }


    /**
     * Sets the available_for_Profiles__c value for this Receipt_Template__c.
     *
     * @param available_for_Profiles__c
     */
    public void setAvailable_for_Profiles__c(String available_for_Profiles__c) {
        this.available_for_Profiles__c = available_for_Profiles__c;
    }


    /**
     * Gets the cancel_Page_Link__c value for this Receipt_Template__c.
     *
     * @return cancel_Page_Link__c
     */
    public String getCancel_Page_Link__c() {
        return cancel_Page_Link__c;
    }


    /**
     * Sets the cancel_Page_Link__c value for this Receipt_Template__c.
     *
     * @param cancel_Page_Link__c
     */
    public void setCancel_Page_Link__c(String cancel_Page_Link__c) {
        this.cancel_Page_Link__c = cancel_Page_Link__c;
    }


    /**
     * Gets the cancel_VF_Generator__c value for this Receipt_Template__c.
     *
     * @return cancel_VF_Generator__c
     */
    public String getCancel_VF_Generator__c() {
        return cancel_VF_Generator__c;
    }


    /**
     * Sets the cancel_VF_Generator__c value for this Receipt_Template__c.
     *
     * @param cancel_VF_Generator__c
     */
    public void setCancel_VF_Generator__c(String cancel_VF_Generator__c) {
        this.cancel_VF_Generator__c = cancel_VF_Generator__c;
    }


    /**
     * Gets the cancel_VF_Generator__r value for this Receipt_Template__c.
     *
     * @return cancel_VF_Generator__r
     */
    public Web_Form__c getCancel_VF_Generator__r() {
        return cancel_VF_Generator__r;
    }


    /**
     * Sets the cancel_VF_Generator__r value for this Receipt_Template__c.
     *
     * @param cancel_VF_Generator__r
     */
    public void setCancel_VF_Generator__r(Web_Form__c cancel_VF_Generator__r) {
        this.cancel_VF_Generator__r = cancel_VF_Generator__r;
    }


    /**
     * Gets the cases__r value for this Receipt_Template__c.
     *
     * @return cases__r
     */
    public QueryResult getCases__r() {
        return cases__r;
    }


    /**
     * Sets the cases__r value for this Receipt_Template__c.
     *
     * @param cases__r
     */
    public void setCases__r(QueryResult cases__r) {
        this.cases__r = cases__r;
    }


    /**
     * Gets the category__c value for this Receipt_Template__c.
     *
     * @return category__c
     */
    public String getCategory__c() {
        return category__c;
    }


    /**
     * Sets the category__c value for this Receipt_Template__c.
     *
     * @param category__c
     */
    public void setCategory__c(String category__c) {
        this.category__c = category__c;
    }


    /**
     * Gets the combinedAttachments value for this Receipt_Template__c.
     *
     * @return combinedAttachments
     */
    public QueryResult getCombinedAttachments() {
        return combinedAttachments;
    }


    /**
     * Sets the combinedAttachments value for this Receipt_Template__c.
     *
     * @param combinedAttachments
     */
    public void setCombinedAttachments(QueryResult combinedAttachments) {
        this.combinedAttachments = combinedAttachments;
    }


    /**
     * Gets the createdBy value for this Receipt_Template__c.
     *
     * @return createdBy
     */
    public User getCreatedBy() {
        return createdBy;
    }


    /**
     * Sets the createdBy value for this Receipt_Template__c.
     *
     * @param createdBy
     */
    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }


    /**
     * Gets the createdById value for this Receipt_Template__c.
     *
     * @return createdById
     */
    public String getCreatedById() {
        return createdById;
    }


    /**
     * Sets the createdById value for this Receipt_Template__c.
     *
     * @param createdById
     */
    public void setCreatedById(String createdById) {
        this.createdById = createdById;
    }


    /**
     * Gets the createdDate value for this Receipt_Template__c.
     *
     * @return createdDate
     */
    public java.util.Calendar getCreatedDate() {
        return createdDate;
    }


    /**
     * Sets the createdDate value for this Receipt_Template__c.
     *
     * @param createdDate
     */
    public void setCreatedDate(java.util.Calendar createdDate) {
        this.createdDate = createdDate;
    }


    /**
     * Gets the currencyIsoCode value for this Receipt_Template__c.
     *
     * @return currencyIsoCode
     */
    public String getCurrencyIsoCode() {
        return currencyIsoCode;
    }


    /**
     * Sets the currencyIsoCode value for this Receipt_Template__c.
     *
     * @param currencyIsoCode
     */
    public void setCurrencyIsoCode(String currencyIsoCode) {
        this.currencyIsoCode = currencyIsoCode;
    }


    /**
     * Gets the default_Processing_Fee__c value for this Receipt_Template__c.
     *
     * @return default_Processing_Fee__c
     */
    public Double getDefault_Processing_Fee__c() {
        return default_Processing_Fee__c;
    }


    /**
     * Sets the default_Processing_Fee__c value for this Receipt_Template__c.
     *
     * @param default_Processing_Fee__c
     */
    public void setDefault_Processing_Fee__c(Double default_Processing_Fee__c) {
        this.default_Processing_Fee__c = default_Processing_Fee__c;
    }


    /**
     * Gets the detail_View_P__c value for this Receipt_Template__c.
     *
     * @return detail_View_P__c
     */
    public String getDetail_View_P__c() {
        return detail_View_P__c;
    }


    /**
     * Sets the detail_View_P__c value for this Receipt_Template__c.
     *
     * @param detail_View_P__c
     */
    public void setDetail_View_P__c(String detail_View_P__c) {
        this.detail_View_P__c = detail_View_P__c;
    }


    /**
     * Gets the display_Name__c value for this Receipt_Template__c.
     *
     * @return display_Name__c
     */
    public String getDisplay_Name__c() {
        return display_Name__c;
    }


    /**
     * Sets the display_Name__c value for this Receipt_Template__c.
     *
     * @param display_Name__c
     */
    public void setDisplay_Name__c(String display_Name__c) {
        this.display_Name__c = display_Name__c;
    }


    /**
     * Gets the document_Required__c value for this Receipt_Template__c.
     *
     * @return document_Required__c
     */
    public Boolean getDocument_Required__c() {
        return document_Required__c;
    }


    /**
     * Sets the document_Required__c value for this Receipt_Template__c.
     *
     * @param document_Required__c
     */
    public void setDocument_Required__c(Boolean document_Required__c) {
        this.document_Required__c = document_Required__c;
    }


    /**
     * Gets the document_Upload_Count__c value for this Receipt_Template__c.
     *
     * @return document_Upload_Count__c
     */
    public Double getDocument_Upload_Count__c() {
        return document_Upload_Count__c;
    }


    /**
     * Sets the document_Upload_Count__c value for this Receipt_Template__c.
     *
     * @param document_Upload_Count__c
     */
    public void setDocument_Upload_Count__c(Double document_Upload_Count__c) {
        this.document_Upload_Count__c = document_Upload_Count__c;
    }


    /**
     * Gets the duplicateRecordItems value for this Receipt_Template__c.
     *
     * @return duplicateRecordItems
     */
    public QueryResult getDuplicateRecordItems() {
        return duplicateRecordItems;
    }


    /**
     * Sets the duplicateRecordItems value for this Receipt_Template__c.
     *
     * @param duplicateRecordItems
     */
    public void setDuplicateRecordItems(QueryResult duplicateRecordItems) {
        this.duplicateRecordItems = duplicateRecordItems;
    }


    /**
     * Gets the duration__c value for this Receipt_Template__c.
     *
     * @return duration__c
     */
    public String getDuration__c() {
        return duration__c;
    }


    /**
     * Sets the duration__c value for this Receipt_Template__c.
     *
     * @param duration__c
     */
    public void setDuration__c(String duration__c) {
        this.duration__c = duration__c;
    }


    /**
     * Gets the ERP_Name__c value for this Receipt_Template__c.
     *
     * @return ERP_Name__c
     */
    public String getERP_Name__c() {
        return ERP_Name__c;
    }


    /**
     * Sets the ERP_Name__c value for this Receipt_Template__c.
     *
     * @param ERP_Name__c
     */
    public void setERP_Name__c(String ERP_Name__c) {
        this.ERP_Name__c = ERP_Name__c;
    }


    /**
     * Gets the ERP_Service_Name__c value for this Receipt_Template__c.
     *
     * @return ERP_Service_Name__c
     */
    public String getERP_Service_Name__c() {
        return ERP_Service_Name__c;
    }


    /**
     * Sets the ERP_Service_Name__c value for this Receipt_Template__c.
     *
     * @param ERP_Service_Name__c
     */
    public void setERP_Service_Name__c(String ERP_Service_Name__c) {
        this.ERP_Service_Name__c = ERP_Service_Name__c;
    }


    /**
     * Gets the external_ID__c value for this Receipt_Template__c.
     *
     * @return external_ID__c
     */
    public String getExternal_ID__c() {
        return external_ID__c;
    }


    /**
     * Sets the external_ID__c value for this Receipt_Template__c.
     *
     * @param external_ID__c
     */
    public void setExternal_ID__c(String external_ID__c) {
        this.external_ID__c = external_ID__c;
    }


    /**
     * Gets the fee_Management__r value for this Receipt_Template__c.
     *
     * @return fee_Management__r
     */
    public QueryResult getFee_Management__r() {
        return fee_Management__r;
    }


    /**
     * Sets the fee_Management__r value for this Receipt_Template__c.
     *
     * @param fee_Management__r
     */
    public void setFee_Management__r(QueryResult fee_Management__r) {
        this.fee_Management__r = fee_Management__r;
    }


    /**
     * Gets the feedSubscriptionsForEntity value for this Receipt_Template__c.
     *
     * @return feedSubscriptionsForEntity
     */
    public QueryResult getFeedSubscriptionsForEntity() {
        return feedSubscriptionsForEntity;
    }


    /**
     * Sets the feedSubscriptionsForEntity value for this Receipt_Template__c.
     *
     * @param feedSubscriptionsForEntity
     */
    public void setFeedSubscriptionsForEntity(QueryResult feedSubscriptionsForEntity) {
        this.feedSubscriptionsForEntity = feedSubscriptionsForEntity;
    }


    /**
     * Gets the internal_Use__c value for this Receipt_Template__c.
     *
     * @return internal_Use__c
     */
    public Boolean getInternal_Use__c() {
        return internal_Use__c;
    }


    /**
     * Sets the internal_Use__c value for this Receipt_Template__c.
     *
     * @param internal_Use__c
     */
    public void setInternal_Use__c(Boolean internal_Use__c) {
        this.internal_Use__c = internal_Use__c;
    }


    /**
     * Gets the inventory_Units__r value for this Receipt_Template__c.
     *
     * @return inventory_Units__r
     */
    public QueryResult getInventory_Units__r() {
        return inventory_Units__r;
    }


    /**
     * Sets the inventory_Units__r value for this Receipt_Template__c.
     *
     * @param inventory_Units__r
     */
    public void setInventory_Units__r(QueryResult inventory_Units__r) {
        this.inventory_Units__r = inventory_Units__r;
    }


    /**
     * Gets the invoice_Line_Items__r value for this Receipt_Template__c.
     *
     * @return invoice_Line_Items__r
     */
    public QueryResult getInvoice_Line_Items__r() {
        return invoice_Line_Items__r;
    }


    /**
     * Sets the invoice_Line_Items__r value for this Receipt_Template__c.
     *
     * @param invoice_Line_Items__r
     */
    public void setInvoice_Line_Items__r(QueryResult invoice_Line_Items__r) {
        this.invoice_Line_Items__r = invoice_Line_Items__r;
    }


    /**
     * Gets the isDeleted value for this Receipt_Template__c.
     *
     * @return isDeleted
     */
    public Boolean getIsDeleted() {
        return isDeleted;
    }


    /**
     * Sets the isDeleted value for this Receipt_Template__c.
     *
     * @param isDeleted
     */
    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }


    /**
     * Gets the is_Active__c value for this Receipt_Template__c.
     *
     * @return is_Active__c
     */
    public Boolean getIs_Active__c() {
        return is_Active__c;
    }


    /**
     * Sets the is_Active__c value for this Receipt_Template__c.
     *
     * @param is_Active__c
     */
    public void setIs_Active__c(Boolean is_Active__c) {
        this.is_Active__c = is_Active__c;
    }


    /**
     * Gets the knowledge_Fee__c value for this Receipt_Template__c.
     *
     * @return knowledge_Fee__c
     */
    public String getKnowledge_Fee__c() {
        return knowledge_Fee__c;
    }


    /**
     * Sets the knowledge_Fee__c value for this Receipt_Template__c.
     *
     * @param knowledge_Fee__c
     */
    public void setKnowledge_Fee__c(String knowledge_Fee__c) {
        this.knowledge_Fee__c = knowledge_Fee__c;
    }


    /**
     * Gets the knowledge_Fee__r value for this Receipt_Template__c.
     *
     * @return knowledge_Fee__r
     */
    public Receipt_Template__c getKnowledge_Fee__r() {
        return knowledge_Fee__r;
    }


    /**
     * Sets the knowledge_Fee__r value for this Receipt_Template__c.
     *
     * @param knowledge_Fee__r
     */
    public void setKnowledge_Fee__r(Receipt_Template__c knowledge_Fee__r) {
        this.knowledge_Fee__r = knowledge_Fee__r;
    }


    /**
     * Gets the lastModifiedBy value for this Receipt_Template__c.
     *
     * @return lastModifiedBy
     */
    public User getLastModifiedBy() {
        return lastModifiedBy;
    }


    /**
     * Sets the lastModifiedBy value for this Receipt_Template__c.
     *
     * @param lastModifiedBy
     */
    public void setLastModifiedBy(User lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }


    /**
     * Gets the lastModifiedById value for this Receipt_Template__c.
     *
     * @return lastModifiedById
     */
    public String getLastModifiedById() {
        return lastModifiedById;
    }


    /**
     * Sets the lastModifiedById value for this Receipt_Template__c.
     *
     * @param lastModifiedById
     */
    public void setLastModifiedById(String lastModifiedById) {
        this.lastModifiedById = lastModifiedById;
    }


    /**
     * Gets the lastModifiedDate value for this Receipt_Template__c.
     *
     * @return lastModifiedDate
     */
    public java.util.Calendar getLastModifiedDate() {
        return lastModifiedDate;
    }


    /**
     * Sets the lastModifiedDate value for this Receipt_Template__c.
     *
     * @param lastModifiedDate
     */
    public void setLastModifiedDate(java.util.Calendar lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }


    /**
     * Gets the lastReferencedDate value for this Receipt_Template__c.
     *
     * @return lastReferencedDate
     */
    public java.util.Calendar getLastReferencedDate() {
        return lastReferencedDate;
    }


    /**
     * Sets the lastReferencedDate value for this Receipt_Template__c.
     *
     * @param lastReferencedDate
     */
    public void setLastReferencedDate(java.util.Calendar lastReferencedDate) {
        this.lastReferencedDate = lastReferencedDate;
    }


    /**
     * Gets the lastViewedDate value for this Receipt_Template__c.
     *
     * @return lastViewedDate
     */
    public java.util.Calendar getLastViewedDate() {
        return lastViewedDate;
    }


    /**
     * Sets the lastViewedDate value for this Receipt_Template__c.
     *
     * @param lastViewedDate
     */
    public void setLastViewedDate(java.util.Calendar lastViewedDate) {
        this.lastViewedDate = lastViewedDate;
    }


    /**
     * Gets the lookedUpFromActivities value for this Receipt_Template__c.
     *
     * @return lookedUpFromActivities
     */
    public QueryResult getLookedUpFromActivities() {
        return lookedUpFromActivities;
    }


    /**
     * Sets the lookedUpFromActivities value for this Receipt_Template__c.
     *
     * @param lookedUpFromActivities
     */
    public void setLookedUpFromActivities(QueryResult lookedUpFromActivities) {
        this.lookedUpFromActivities = lookedUpFromActivities;
    }


    /**
     * Gets the NOC_Type__c value for this Receipt_Template__c.
     *
     * @return NOC_Type__c
     */
    public String getNOC_Type__c() {
        return NOC_Type__c;
    }


    /**
     * Sets the NOC_Type__c value for this Receipt_Template__c.
     *
     * @param NOC_Type__c
     */
    public void setNOC_Type__c(String NOC_Type__c) {
        this.NOC_Type__c = NOC_Type__c;
    }


    /**
     * Gets the name value for this Receipt_Template__c.
     *
     * @return name
     */
    public String getName() {
        return name;
    }


    /**
     * Sets the name value for this Receipt_Template__c.
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * Gets the new_Edit_VF_Generator__c value for this Receipt_Template__c.
     *
     * @return new_Edit_VF_Generator__c
     */
    public String getNew_Edit_VF_Generator__c() {
        return new_Edit_VF_Generator__c;
    }


    /**
     * Sets the new_Edit_VF_Generator__c value for this Receipt_Template__c.
     *
     * @param new_Edit_VF_Generator__c
     */
    public void setNew_Edit_VF_Generator__c(String new_Edit_VF_Generator__c) {
        this.new_Edit_VF_Generator__c = new_Edit_VF_Generator__c;
    }


    /**
     * Gets the new_Edit_VF_Generator__r value for this Receipt_Template__c.
     *
     * @return new_Edit_VF_Generator__r
     */
    public Web_Form__c getNew_Edit_VF_Generator__r() {
        return new_Edit_VF_Generator__r;
    }


    /**
     * Sets the new_Edit_VF_Generator__r value for this Receipt_Template__c.
     *
     * @param new_Edit_VF_Generator__r
     */
    public void setNew_Edit_VF_Generator__r(Web_Form__c new_Edit_VF_Generator__r) {
        this.new_Edit_VF_Generator__r = new_Edit_VF_Generator__r;
    }


    /**
     * Gets the notes value for this Receipt_Template__c.
     *
     * @return notes
     */
    public QueryResult getNotes() {
        return notes;
    }


    /**
     * Sets the notes value for this Receipt_Template__c.
     *
     * @param notes
     */
    public void setNotes(QueryResult notes) {
        this.notes = notes;
    }


    /**
     * Gets the notesAndAttachments value for this Receipt_Template__c.
     *
     * @return notesAndAttachments
     */
    public QueryResult getNotesAndAttachments() {
        return notesAndAttachments;
    }


    /**
     * Sets the notesAndAttachments value for this Receipt_Template__c.
     *
     * @param notesAndAttachments
     */
    public void setNotesAndAttachments(QueryResult notesAndAttachments) {
        this.notesAndAttachments = notesAndAttachments;
    }

    /**
     * Gets the ownerId value for this Receipt_Template__c.
     *
     * @return ownerId
     */
    public String getOwnerId() {
        return ownerId;
    }


    /**
     * Sets the ownerId value for this Receipt_Template__c.
     *
     * @param ownerId
     */
    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }


    /**
     * Gets the processInstances value for this Receipt_Template__c.
     *
     * @return processInstances
     */
    public QueryResult getProcessInstances() {
        return processInstances;
    }


    /**
     * Sets the processInstances value for this Receipt_Template__c.
     *
     * @param processInstances
     */
    public void setProcessInstances(QueryResult processInstances) {
        this.processInstances = processInstances;
    }


    /**
     * Gets the processSteps value for this Receipt_Template__c.
     *
     * @return processSteps
     */
    public QueryResult getProcessSteps() {
        return processSteps;
    }


    /**
     * Sets the processSteps value for this Receipt_Template__c.
     *
     * @param processSteps
     */
    public void setProcessSteps(QueryResult processSteps) {
        this.processSteps = processSteps;
    }


    /**
     * Gets the proposed_Documents_Check_List__r value for this Receipt_Template__c.
     *
     * @return proposed_Documents_Check_List__r
     */
    public QueryResult getProposed_Documents_Check_List__r() {
        return proposed_Documents_Check_List__r;
    }


    /**
     * Sets the proposed_Documents_Check_List__r value for this Receipt_Template__c.
     *
     * @param proposed_Documents_Check_List__r
     */
    public void setProposed_Documents_Check_List__r(QueryResult proposed_Documents_Check_List__r) {
        this.proposed_Documents_Check_List__r = proposed_Documents_Check_List__r;
    }


    /**
     * Gets the receipt_Line_Items__r value for this Receipt_Template__c.
     *
     * @return receipt_Line_Items__r
     */
    public QueryResult getReceipt_Line_Items__r() {
        return receipt_Line_Items__r;
    }


    /**
     * Sets the receipt_Line_Items__r value for this Receipt_Template__c.
     *
     * @param receipt_Line_Items__r
     */
    public void setReceipt_Line_Items__r(QueryResult receipt_Line_Items__r) {
        this.receipt_Line_Items__r = receipt_Line_Items__r;
    }


    /**
     * Gets the recordAssociatedGroups value for this Receipt_Template__c.
     *
     * @return recordAssociatedGroups
     */
    public QueryResult getRecordAssociatedGroups() {
        return recordAssociatedGroups;
    }


    /**
     * Sets the recordAssociatedGroups value for this Receipt_Template__c.
     *
     * @param recordAssociatedGroups
     */
    public void setRecordAssociatedGroups(QueryResult recordAssociatedGroups) {
        this.recordAssociatedGroups = recordAssociatedGroups;
    }


    /**
     * Gets the recordType value for this Receipt_Template__c.
     *
     * @return recordType
     */
    public RecordType getRecordType() {
        return recordType;
    }


    /**
     * Sets the recordType value for this Receipt_Template__c.
     *
     * @param recordType
     */
    public void setRecordType(RecordType recordType) {
        this.recordType = recordType;
    }


    /**
     * Gets the recordTypeId value for this Receipt_Template__c.
     *
     * @return recordTypeId
     */
    public String getRecordTypeId() {
        return recordTypeId;
    }


    /**
     * Sets the recordTypeId value for this Receipt_Template__c.
     *
     * @param recordTypeId
     */
    public void setRecordTypeId(String recordTypeId) {
        this.recordTypeId = recordTypeId;
    }


    /**
     * Gets the record_Type_Picklist__c value for this Receipt_Template__c.
     *
     * @return record_Type_Picklist__c
     */
    public String getRecord_Type_Picklist__c() {
        return record_Type_Picklist__c;
    }


    /**
     * Sets the record_Type_Picklist__c value for this Receipt_Template__c.
     *
     * @param record_Type_Picklist__c
     */
    public void setRecord_Type_Picklist__c(String record_Type_Picklist__c) {
        this.record_Type_Picklist__c = record_Type_Picklist__c;
    }


    /**
     * Gets the redirect_Page__c value for this Receipt_Template__c.
     *
     * @return redirect_Page__c
     */
    public String getRedirect_Page__c() {
        return redirect_Page__c;
    }


    /**
     * Sets the redirect_Page__c value for this Receipt_Template__c.
     *
     * @param redirect_Page__c
     */
    public void setRedirect_Page__c(String redirect_Page__c) {
        this.redirect_Page__c = redirect_Page__c;
    }


    /**
     * Gets the related_to_Object__c value for this Receipt_Template__c.
     *
     * @return related_to_Object__c
     */
    public String getRelated_to_Object__c() {
        return related_to_Object__c;
    }


    /**
     * Sets the related_to_Object__c value for this Receipt_Template__c.
     *
     * @param related_to_Object__c
     */
    public void setRelated_to_Object__c(String related_to_Object__c) {
        this.related_to_Object__c = related_to_Object__c;
    }


    /**
     * Gets the renewal_Page_Link__c value for this Receipt_Template__c.
     *
     * @return renewal_Page_Link__c
     */
    public String getRenewal_Page_Link__c() {
        return renewal_Page_Link__c;
    }


    /**
     * Sets the renewal_Page_Link__c value for this Receipt_Template__c.
     *
     * @param renewal_Page_Link__c
     */
    public void setRenewal_Page_Link__c(String renewal_Page_Link__c) {
        this.renewal_Page_Link__c = renewal_Page_Link__c;
    }


    /**
     * Gets the renewal_VF_Generator__c value for this Receipt_Template__c.
     *
     * @return renewal_VF_Generator__c
     */
    public String getRenewal_VF_Generator__c() {
        return renewal_VF_Generator__c;
    }


    /**
     * Sets the renewal_VF_Generator__c value for this Receipt_Template__c.
     *
     * @param renewal_VF_Generator__c
     */
    public void setRenewal_VF_Generator__c(String renewal_VF_Generator__c) {
        this.renewal_VF_Generator__c = renewal_VF_Generator__c;
    }


    /**
     * Gets the renewal_VF_Generator__r value for this Receipt_Template__c.
     *
     * @return renewal_VF_Generator__r
     */
    public Web_Form__c getRenewal_VF_Generator__r() {
        return renewal_VF_Generator__r;
    }


    /**
     * Sets the renewal_VF_Generator__r value for this Receipt_Template__c.
     *
     * @param renewal_VF_Generator__r
     */
    public void setRenewal_VF_Generator__r(Web_Form__c renewal_VF_Generator__r) {
        this.renewal_VF_Generator__r = renewal_VF_Generator__r;
    }


    /**
     * Gets the replace_Page_Link__c value for this Receipt_Template__c.
     *
     * @return replace_Page_Link__c
     */
    public String getReplace_Page_Link__c() {
        return replace_Page_Link__c;
    }


    /**
     * Sets the replace_Page_Link__c value for this Receipt_Template__c.
     *
     * @param replace_Page_Link__c
     */
    public void setReplace_Page_Link__c(String replace_Page_Link__c) {
        this.replace_Page_Link__c = replace_Page_Link__c;
    }


    /**
     * Gets the replace_VF_Generator__c value for this Receipt_Template__c.
     *
     * @return replace_VF_Generator__c
     */
    public String getReplace_VF_Generator__c() {
        return replace_VF_Generator__c;
    }


    /**
     * Sets the replace_VF_Generator__c value for this Receipt_Template__c.
     *
     * @param replace_VF_Generator__c
     */
    public void setReplace_VF_Generator__c(String replace_VF_Generator__c) {
        this.replace_VF_Generator__c = replace_VF_Generator__c;
    }


    /**
     * Gets the replace_VF_Generator__r value for this Receipt_Template__c.
     *
     * @return replace_VF_Generator__r
     */
    public Web_Form__c getReplace_VF_Generator__r() {
        return replace_VF_Generator__r;
    }


    /**
     * Sets the replace_VF_Generator__r value for this Receipt_Template__c.
     *
     * @param replace_VF_Generator__r
     */
    public void setReplace_VF_Generator__r(Web_Form__c replace_VF_Generator__r) {
        this.replace_VF_Generator__r = replace_VF_Generator__r;
    }


    /**
     * Gets the require_Knowledge_Fee__c value for this Receipt_Template__c.
     *
     * @return require_Knowledge_Fee__c
     */
    public Boolean getRequire_Knowledge_Fee__c() {
        return require_Knowledge_Fee__c;
    }


    /**
     * Sets the require_Knowledge_Fee__c value for this Receipt_Template__c.
     *
     * @param require_Knowledge_Fee__c
     */
    public void setRequire_Knowledge_Fee__c(Boolean require_Knowledge_Fee__c) {
        this.require_Knowledge_Fee__c = require_Knowledge_Fee__c;
    }


    /**
     * Gets the required_Access_Card_Ref__c value for this Receipt_Template__c.
     *
     * @return required_Access_Card_Ref__c
     */
    public Boolean getRequired_Access_Card_Ref__c() {
        return required_Access_Card_Ref__c;
    }


    /**
     * Sets the required_Access_Card_Ref__c value for this Receipt_Template__c.
     *
     * @param required_Access_Card_Ref__c
     */
    public void setRequired_Access_Card_Ref__c(Boolean required_Access_Card_Ref__c) {
        this.required_Access_Card_Ref__c = required_Access_Card_Ref__c;
    }


    /**
     * Gets the required_Account_Ref__c value for this Receipt_Template__c.
     *
     * @return required_Account_Ref__c
     */
    public Boolean getRequired_Account_Ref__c() {
        return required_Account_Ref__c;
    }


    /**
     * Sets the required_Account_Ref__c value for this Receipt_Template__c.
     *
     * @param required_Account_Ref__c
     */
    public void setRequired_Account_Ref__c(Boolean required_Account_Ref__c) {
        this.required_Account_Ref__c = required_Account_Ref__c;
    }


    /**
     * Gets the required_Agreement_Payment_Ref__c value for this Receipt_Template__c.
     *
     * @return required_Agreement_Payment_Ref__c
     */
    public Boolean getRequired_Agreement_Payment_Ref__c() {
        return required_Agreement_Payment_Ref__c;
    }


    /**
     * Sets the required_Agreement_Payment_Ref__c value for this Receipt_Template__c.
     *
     * @param required_Agreement_Payment_Ref__c
     */
    public void setRequired_Agreement_Payment_Ref__c(Boolean required_Agreement_Payment_Ref__c) {
        this.required_Agreement_Payment_Ref__c = required_Agreement_Payment_Ref__c;
    }


    /**
     * Gets the required_License_Amendment_Ref__c value for this Receipt_Template__c.
     *
     * @return required_License_Amendment_Ref__c
     */
    public Boolean getRequired_License_Amendment_Ref__c() {
        return required_License_Amendment_Ref__c;
    }


    /**
     * Sets the required_License_Amendment_Ref__c value for this Receipt_Template__c.
     *
     * @param required_License_Amendment_Ref__c
     */
    public void setRequired_License_Amendment_Ref__c(Boolean required_License_Amendment_Ref__c) {
        this.required_License_Amendment_Ref__c = required_License_Amendment_Ref__c;
    }


    /**
     * Gets the required_License_Ref__c value for this Receipt_Template__c.
     *
     * @return required_License_Ref__c
     */
    public Boolean getRequired_License_Ref__c() {
        return required_License_Ref__c;
    }


    /**
     * Sets the required_License_Ref__c value for this Receipt_Template__c.
     *
     * @param required_License_Ref__c
     */
    public void setRequired_License_Ref__c(Boolean required_License_Ref__c) {
        this.required_License_Ref__c = required_License_Ref__c;
    }


    /**
     * Gets the required_NOC_Ref__c value for this Receipt_Template__c.
     *
     * @return required_NOC_Ref__c
     */
    public Boolean getRequired_NOC_Ref__c() {
        return required_NOC_Ref__c;
    }


    /**
     * Sets the required_NOC_Ref__c value for this Receipt_Template__c.
     *
     * @param required_NOC_Ref__c
     */
    public void setRequired_NOC_Ref__c(Boolean required_NOC_Ref__c) {
        this.required_NOC_Ref__c = required_NOC_Ref__c;
    }


    /**
     * Gets the required_Quote_Ref__c value for this Receipt_Template__c.
     *
     * @return required_Quote_Ref__c
     */
    public Boolean getRequired_Quote_Ref__c() {
        return required_Quote_Ref__c;
    }


    /**
     * Sets the required_Quote_Ref__c value for this Receipt_Template__c.
     *
     * @param required_Quote_Ref__c
     */
    public void setRequired_Quote_Ref__c(Boolean required_Quote_Ref__c) {
        this.required_Quote_Ref__c = required_Quote_Ref__c;
    }


    /**
     * Gets the required_Registration_Amendment_Ref__c value for this Receipt_Template__c.
     *
     * @return required_Registration_Amendment_Ref__c
     */
    public Boolean getRequired_Registration_Amendment_Ref__c() {
        return required_Registration_Amendment_Ref__c;
    }


    /**
     * Sets the required_Registration_Amendment_Ref__c value for this Receipt_Template__c.
     *
     * @param required_Registration_Amendment_Ref__c
     */
    public void setRequired_Registration_Amendment_Ref__c(Boolean required_Registration_Amendment_Ref__c) {
        this.required_Registration_Amendment_Ref__c = required_Registration_Amendment_Ref__c;
    }


    /**
     * Gets the required_Visa_Ref__c value for this Receipt_Template__c.
     *
     * @return required_Visa_Ref__c
     */
    public Boolean getRequired_Visa_Ref__c() {
        return required_Visa_Ref__c;
    }


    /**
     * Sets the required_Visa_Ref__c value for this Receipt_Template__c.
     *
     * @param required_Visa_Ref__c
     */
    public void setRequired_Visa_Ref__c(Boolean required_Visa_Ref__c) {
        this.required_Visa_Ref__c = required_Visa_Ref__c;
    }


    /**
     * Gets the service_Abb__c value for this Receipt_Template__c.
     *
     * @return service_Abb__c
     */
    public String getService_Abb__c() {
        return service_Abb__c;
    }


    /**
     * Sets the service_Abb__c value for this Receipt_Template__c.
     *
     * @param service_Abb__c
     */
    public void setService_Abb__c(String service_Abb__c) {
        this.service_Abb__c = service_Abb__c;
    }


    /**
     * Gets the service_GL_Code__c value for this Receipt_Template__c.
     *
     * @return service_GL_Code__c
     */
    public String getService_GL_Code__c() {
        return service_GL_Code__c;
    }


    /**
     * Sets the service_GL_Code__c value for this Receipt_Template__c.
     *
     * @param service_GL_Code__c
     */
    public void setService_GL_Code__c(String service_GL_Code__c) {
        this.service_GL_Code__c = service_GL_Code__c;
    }


    /**
     * Gets the service_Identifier__c value for this Receipt_Template__c.
     *
     * @return service_Identifier__c
     */
    public String getService_Identifier__c() {
        return service_Identifier__c;
    }


    /**
     * Sets the service_Identifier__c value for this Receipt_Template__c.
     *
     * @param service_Identifier__c
     */
    public void setService_Identifier__c(String service_Identifier__c) {
        this.service_Identifier__c = service_Identifier__c;
    }


    /**
     * Gets the service_Name__c value for this Receipt_Template__c.
     *
     * @return service_Name__c
     */
    public String getService_Name__c() {
        return service_Name__c;
    }


    /**
     * Sets the service_Name__c value for this Receipt_Template__c.
     *
     * @param service_Name__c
     */
    public void setService_Name__c(String service_Name__c) {
        this.service_Name__c = service_Name__c;
    }


    /**
     * Gets the service_Type__c value for this Receipt_Template__c.
     *
     * @return service_Type__c
     */
    public String getService_Type__c() {
        return service_Type__c;
    }


    /**
     * Sets the service_Type__c value for this Receipt_Template__c.
     *
     * @param service_Type__c
     */
    public void setService_Type__c(String service_Type__c) {
        this.service_Type__c = service_Type__c;
    }


    /**
     * Gets the service_VF_Page__c value for this Receipt_Template__c.
     *
     * @return service_VF_Page__c
     */
    public String getService_VF_Page__c() {
        return service_VF_Page__c;
    }


    /**
     * Sets the service_VF_Page__c value for this Receipt_Template__c.
     *
     * @param service_VF_Page__c
     */
    public void setService_VF_Page__c(String service_VF_Page__c) {
        this.service_VF_Page__c = service_VF_Page__c;
    }


    /**
     * Gets the short_Service_Name__c value for this Receipt_Template__c.
     *
     * @return short_Service_Name__c
     */
    public String getShort_Service_Name__c() {
        return short_Service_Name__c;
    }


    /**
     * Sets the short_Service_Name__c value for this Receipt_Template__c.
     *
     * @param short_Service_Name__c
     */
    public void setShort_Service_Name__c(String short_Service_Name__c) {
        this.short_Service_Name__c = short_Service_Name__c;
    }


    /**
     * Gets the sub_Category__c value for this Receipt_Template__c.
     *
     * @return sub_Category__c
     */
    public String getSub_Category__c() {
        return sub_Category__c;
    }


    /**
     * Sets the sub_Category__c value for this Receipt_Template__c.
     *
     * @param sub_Category__c
     */
    public void setSub_Category__c(String sub_Category__c) {
        this.sub_Category__c = sub_Category__c;
    }


    /**
     * Gets the systemModstamp value for this Receipt_Template__c.
     *
     * @return systemModstamp
     */
    public java.util.Calendar getSystemModstamp() {
        return systemModstamp;
    }


    /**
     * Sets the systemModstamp value for this Receipt_Template__c.
     *
     * @param systemModstamp
     */
    public void setSystemModstamp(java.util.Calendar systemModstamp) {
        this.systemModstamp = systemModstamp;
    }


    /**
     * Gets the topicAssignments value for this Receipt_Template__c.
     *
     * @return topicAssignments
     */
    public QueryResult getTopicAssignments() {
        return topicAssignments;
    }


    /**
     * Sets the topicAssignments value for this Receipt_Template__c.
     *
     * @param topicAssignments
     */
    public void setTopicAssignments(QueryResult topicAssignments) {
        this.topicAssignments = topicAssignments;
    }


    /**
     * Gets the total_Amount__c value for this Receipt_Template__c.
     *
     * @return total_Amount__c
     */
    public double getTotal_Amount__c() {
        return total_Amount__c;
    }


    /**
     * Sets the total_Amount__c value for this Receipt_Template__c.
     *
     * @param total_Amount__c
     */
    public void setTotal_Amount__c(double total_Amount__c) {
        this.total_Amount__c = total_Amount__c;
    }


    /**
     * Gets the visa_Type__c value for this Receipt_Template__c.
     *
     * @return visa_Type__c
     */
    public String getVisa_Type__c() {
        return visa_Type__c;
    }


    /**
     * Sets the visa_Type__c value for this Receipt_Template__c.
     *
     * @param visa_Type__c
     */
    public void setVisa_Type__c(String visa_Type__c) {
        this.visa_Type__c = visa_Type__c;
    }


    /**
     * Gets the eService_Administration__r value for this Receipt_Template__c.
     *
     * @return eService_Administration__r
     */
    public QueryResult getEService_Administration__r() {
        return eService_Administration__r;
    }


    /**
     * Sets the eService_Administration__r value for this Receipt_Template__c.
     *
     * @param eService_Administration__r
     */
    public void setEService_Administration__r(QueryResult eService_Administration__r) {
        this.eService_Administration__r = eService_Administration__r;
    }


    /**
     * Gets the eService_ERP_Details__c value for this Receipt_Template__c.
     *
     * @return eService_ERP_Details__c
     */
    public String getEService_ERP_Details__c() {
        return eService_ERP_Details__c;
    }


    /**
     * Sets the eService_ERP_Details__c value for this Receipt_Template__c.
     *
     * @param eService_ERP_Details__c
     */
    public void setEService_ERP_Details__c(String eService_ERP_Details__c) {
        this.eService_ERP_Details__c = eService_ERP_Details__c;
    }

    /**
     * Gets the eServices_Document_Checklists1__r value for this Receipt_Template__c.
     *
     * @return eServices_Document_Checklists1__r
     */
    public QueryResult getEServices_Document_Checklists1__r() {
        return eServices_Document_Checklists1__r;
    }


    /**
     * Sets the eServices_Document_Checklists1__r value for this Receipt_Template__c.
     *
     * @param eServices_Document_Checklists1__r
     */
    public void setEServices_Document_Checklists1__r(QueryResult eServices_Document_Checklists1__r) {
        this.eServices_Document_Checklists1__r = eServices_Document_Checklists1__r;
    }


    /**
     * Gets the eServices_Document_Checklists__r value for this Receipt_Template__c.
     *
     * @return eServices_Document_Checklists__r
     */
    public QueryResult getEServices_Document_Checklists__r() {
        return eServices_Document_Checklists__r;
    }


    /**
     * Sets the eServices_Document_Checklists__r value for this Receipt_Template__c.
     *
     * @param eServices_Document_Checklists__r
     */
    public void setEServices_Document_Checklists__r(QueryResult eServices_Document_Checklists__r) {
        this.eServices_Document_Checklists__r = eServices_Document_Checklists__r;
    }


    /**
     * Gets the isAvailableOnPortal__c value for this Receipt_Template__c.
     *
     * @return isAvailableOnPortal__c
     */
    public Boolean getIsAvailableOnPortal__c() {
        return isAvailableOnPortal__c;
    }


    /**
     * Sets the isAvailableOnPortal__c value for this Receipt_Template__c.
     *
     * @param isAvailableOnPortal__c
     */
    public void setIsAvailableOnPortal__c(Boolean isAvailableOnPortal__c) {
        this.isAvailableOnPortal__c = isAvailableOnPortal__c;
    }

}