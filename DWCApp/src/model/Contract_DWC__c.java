/**
 * Contract_DWC__c.java
 * <p/>
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


public class Contract_DWC__c implements java.io.Serializable {

    @SerializedName("Id")
    private String ID;
    @SerializedName("Name")
    private String name;
    @SerializedName("Contract_Type__c")
    private String Contract_Type__c;
    @SerializedName("Activated_Date__c")
    private String Activated_Date__c;
    @SerializedName("Total_Rent_Price__c")
    private String Total_Rent_Price__c;
    @SerializedName("Contract_Duration__c")
    private String Contract_Duration__c;
    @SerializedName("IS_BC_Contract__c")
    private boolean IS_BC_Contract__c;
    @SerializedName("Rent_Start_Date__c")
    private String Rent_Start_Date__c;
    @SerializedName("Contract_Duration_Year_Month__c")
    private String Contract_Duration_Year_Month__c;
    @SerializedName("Contract_Start_Date__c")
    private String Contract_Start_Date__c;
    @SerializedName("Contract_Expiry_Date__c")
    private String Contract_Expiry_Date__c;
    @SerializedName("Status__c")
    private String Status__c;
    @SerializedName("Contract_Number__c")
    private String Contract_Number__c;
    @SerializedName("Quote__c")
    private String Quote__c;
    @SerializedName("RecordTypeId")
    private String RecordTypeId;

    ArrayList<Contract_Line_Item__c> contract_line_item__cs;

    Quote quote;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContract_Type__c() {
        return Contract_Type__c;
    }

    public void setContract_Type__c(String contract_Type__c) {
        Contract_Type__c = contract_Type__c;
    }

    public String getActivated_Date__c() {
        return Activated_Date__c;
    }

    public void setActivated_Date__c(String activated_Date__c) {
        Activated_Date__c = activated_Date__c;
    }

    public String getTotal_Rent_Price__c() {
        return Total_Rent_Price__c;
    }

    public void setTotal_Rent_Price__c(String total_Rent_Price__c) {
        Total_Rent_Price__c = total_Rent_Price__c;
    }

    public String getContract_Duration__c() {
        return Contract_Duration__c;
    }

    public void setContract_Duration__c(String contract_Duration__c) {
        Contract_Duration__c = contract_Duration__c;
    }

    public boolean IS_BC_Contract__c() {
        return IS_BC_Contract__c;
    }

    public void setIS_BC_Contract__c(boolean IS_BC_Contract__c) {
        this.IS_BC_Contract__c = IS_BC_Contract__c;
    }

    public String getRent_Start_Date__c() {
        return Rent_Start_Date__c;
    }

    public void setRent_Start_Date__c(String rent_Start_Date__c) {
        Rent_Start_Date__c = rent_Start_Date__c;
    }

    public String getContract_Duration_Year_Month__c() {
        return Contract_Duration_Year_Month__c;
    }

    public void setContract_Duration_Year_Month__c(String contract_Duration_Year_Month__c) {
        Contract_Duration_Year_Month__c = contract_Duration_Year_Month__c;
    }

    public String getContract_Start_Date__c() {
        return Contract_Start_Date__c;
    }

    public void setContract_Start_Date__c(String contract_Start_Date__c) {
        Contract_Start_Date__c = contract_Start_Date__c;
    }

    public String getContract_Expiry_Date__c() {
        return Contract_Expiry_Date__c;
    }

    public void setContract_Expiry_Date__c(String contract_Expiry_Date__c) {
        Contract_Expiry_Date__c = contract_Expiry_Date__c;
    }

    public String getStatus__c() {
        return Status__c;
    }

    public void setStatus__c(String status__c) {
        Status__c = status__c;
    }

    public String getContract_Number__c() {
        return Contract_Number__c;
    }

    public void setContract_Number__c(String contract_Number__c) {
        Contract_Number__c = contract_Number__c;
    }

    public String getQuote__c() {
        return Quote__c;
    }

    public void setQuote__c(String quote__c) {
        Quote__c = quote__c;
    }

    public String getRecordTypeId() {
        return RecordTypeId;
    }

    public void setRecordTypeId(String recordTypeId) {
        RecordTypeId = recordTypeId;
    }

    public ArrayList<Contract_Line_Item__c> getContract_line_item__cs() {
        return contract_line_item__cs;
    }

    public void setContract_line_item__cs(ArrayList<Contract_Line_Item__c> contract_line_item__cs) {
        this.contract_line_item__cs = contract_line_item__cs;
    }

    public Quote getQuote() {
        return quote;
    }

    public void setQuote(Quote quote) {
        this.quote = quote;
    }


    //
//    public model.attributes getAttributes() {
//        return attributes;
//    }
//
//    public void setAttributes(model.attributes attributes) {
//        this.attributes = attributes;
//    }
//
//    @SerializedName("attributes")
//    attributes attributes;
//

//
//    @SerializedName("Account__c")
//    private String account__c;
//
//    @SerializedName("Activated_By__c")
//    private String activated_By__c;
//
//    @SerializedName("Activated_Date__c")
//    private java.util.Date activated_Date__c;
//    @SerializedName("ActivityHistories")
//    private QueryResult activityHistories;
//    @SerializedName("Annual_Rent_AED__c")
//    private Double annual_Rent_AED__c;
//    @SerializedName("Annual_Rent__c")
//    private Double annual_Rent__c;
//    @SerializedName("Annual_Service_ChargesFormula__c")
//    private Double annual_Service_ChargesFormula__c;
//    @SerializedName("Annual_Service_Charges_Formula__c")
//    private Double annual_Service_Charges_Formula__c;
//    @SerializedName("Annual_Service_Charges__c")
//    private Double annual_Service_Charges__c;
//    @SerializedName("Anticipated_Operation_Date__c")
//    private java.util.Date anticipated_Operation_Date__c;
//    @SerializedName("Apron_Plot__c")
//    private Double apron_Plot__c;
//    @SerializedName("Apron_Rent__c")
//    private Double apron_Rent__c;
//    @SerializedName("Area_Plot__c")
//    private Double area_Plot__c;
//    @SerializedName("AttachedContentDocuments")
//    private QueryResult attachedContentDocuments;
//    @SerializedName("Attachments")
//    private QueryResult attachments;
//    @SerializedName("Authorized_DWC_Arabic__c")
//    private String authorized_DWC_Arabic__c;
//    @SerializedName("Authorized_DWC_Signatory_Arabic__c")
//    private String authorized_DWC_Signatory_Arabic__c;
//    @SerializedName("Authorized_DWC_Signatory__c")
//    private String authorized_DWC_Signatory__c;
//    @SerializedName("Bill_To_Name__c")
//    private String bill_To_Name__c;
//    @SerializedName("BillingAddress__c")
//    private String billingAddress__c;
//    @SerializedName("Building_Number__c")
//    private String building_Number__c;
//    @SerializedName("CS_Comments__c")
//    private String CS_Comments__c;
//    @SerializedName("CS_Team_Member__c")
//    private String CS_Team_Member__c;
//    @SerializedName("CY_Invoiced__c")
//    private Double CY_Invoiced__c;
//    @SerializedName("Cancellation_Approved__c")
//    public boolean cancellation_Approved__c;
//    @SerializedName("Cancellation_Date__c")
//    private java.util.Date cancellation_Date__c;
//    @SerializedName("Cancellation_Reason__c")
//    private String cancellation_Reason__c;
//    @SerializedName("Cancellation_Type__c")
//    private String cancellation_Type__c;
//    @SerializedName("Cancelled_Deregistration_Approval_Status__c")
//    private String cancelled_Deregistration_Approval_Status__c;
//    @SerializedName("Cancelled_Finance_Approval_Status__c")
//    private String cancelled_Finance_Approval_Status__c;
//    @SerializedName("Cancelled_License_Approval_Status__c")
//    private String cancelled_License_Approval_Status__c;
//    @SerializedName("Contact__c")
//    private String contact__c;
//    @SerializedName("Contract_Collected_By__c")
//    private String contract_Collected_By__c;
//    @SerializedName("Contract_Collected__c")
//    public boolean contract_Collected__c;
//    @SerializedName("Contract_Collection_Date_Time__c")
//    private java.util.Calendar contract_Collection_Date_Time__c;
//    @SerializedName("Contract_Day__c")
//    private Double contract_Day__c;
//    @SerializedName("Contract_Duration_Year_Month__c")
//    private String contract_Duration_Year_Month__c;
//    @SerializedName("Contract_Duration__c")
//    private Double contract_Duration__c;
//    @SerializedName("Contract_Expiry_Date__c")
//    private java.util.Date contract_Expiry_Date__c;
//    @SerializedName("Contract_Month__c")
//    private Double contract_Month__c;
//    @SerializedName("Contract_Number__c")
//    private String contract_Number__c;
//    @SerializedName("Contract_Opportunity__c")
//    private String contract_Opportunity__c;
//    @SerializedName("Contract_Start_Date__c")
//    private java.util.Date contract_Start_Date__c;
//    @SerializedName("Contract_Start_Month__c")
//    private Double contract_Start_Month__c;
//    @SerializedName("Contract_Term_months__c")
//    private Double contract_Term_months__c;
//    @SerializedName("Contract_Transfer_Date__c")
//    private java.util.Date contract_Transfer_Date__c;
//    @SerializedName("Contract_Type__c")
//    private String contract_Type__c;
//    @SerializedName("Contract_Year__c")
//    private Double contract_Year__c;
//    @SerializedName("CreatedBy")
//    private User createdBy;
//    @SerializedName("CreatedById")
//    private String createdById;
//    @SerializedName("CreatedDate")
//    private java.util.Calendar createdDate;
//    @SerializedName("CurrencyIsoCode")
//    private String currencyIsoCode;
//    @SerializedName("Customer_ERP_Code__c")
//    private String customer_ERP_Code__c;
//    @SerializedName("Customer_Position__c")
//    private String customer_Position__c;
//    @SerializedName("Customer_Signed_By_Arabic__c")
//    private String customer_Signed_By_Arabic__c;
//    @SerializedName("Customer_Signed_By__c")
//    private String customer_Signed_By__c;
//
//    @SerializedName("Customer_Signed_Date__c")
//    private java.util.Date customer_Signed_Date__c;
//    @SerializedName("Customer_Transaction_Blocked__c")
//    public boolean customer_Transaction_Blocked__c;
//    @SerializedName("DWC_Signed_By__c")
//    private String DWC_Signed_By__c;
//    @SerializedName("DWC_Signed_Date__c")
//    private java.util.Date DWC_Signed_Date__c;
//    @SerializedName("Date_Contract_Signed_by_Customer__c")
//    private java.util.Date date_Contract_Signed_by_Customer__c;
//    @SerializedName("Deliver_Contract__c")
//    public boolean deliver_Contract__c;
//    @SerializedName("Description__c")
//    private String description__c;
//    @SerializedName("Dif__c")
//    private Double dif__c;
//    @SerializedName("Discount__c")
//    private Double discount__c;
//    @SerializedName("Electrical_Infrastructure_Fee__c")
//    private String electrical_Infrastructure_Fee__c;
//    @SerializedName("Eligable_for_UAE_Citizen_Discount_Flag__c")
//    private String eligable_for_UAE_Citizen_Discount_Flag__c;
//    @SerializedName("Eligable_for_UAE_Citizen_Discount__c")
//    public boolean eligable_for_UAE_Citizen_Discount__c;
//    @SerializedName("Eligible_for_Penalty__c")
//    private String eligible_for_Penalty__c;
//    @SerializedName("Email__c")
//    private String email__c;
//    @SerializedName("Events")
//    private QueryResult events;
//    @SerializedName("Fax__c")
//    private String fax__c;
//    @SerializedName("FeedSubscriptionsForEntity")
//    private QueryResult feedSubscriptionsForEntity;
//    @SerializedName("Feeds")
//    private QueryResult feeds;
//
//    @SerializedName("First_Line_Item_Unit_Area__c")
//    private Double first_Line_Item_Unit_Area__c;
//    @SerializedName("First_Line_Item_Unit_Name__c")
//    private String first_Line_Item_Unit_Name__c;
//    @SerializedName("First_Line_Item_Unit_Price__c")
//    private Double first_Line_Item_Unit_Price__c;
//    @SerializedName("Fit_out_Status__c")
//    private String fit_out_Status__c;
//    @SerializedName("Grand_Total__c")
//    private Double grand_Total__c;
//    @SerializedName("Histories")
//    private QueryResult histories;
//    @SerializedName("History__c")
//    private String history__c;
//    @SerializedName("IS_BC_Contract__c")
//    public boolean IS_BC_Contract__c;
//    @SerializedName("Inspection_Date__c")
//    private java.util.Date inspection_Date__c;
//    @SerializedName("Inspection_Remarks__c")
//    private String inspection_Remarks__c;
//    @SerializedName("Inventory_Unit__c")
//    private String inventory_Unit__c;
//    @SerializedName("IsDeleted")
//    public boolean isDeleted;
//
//    @SerializedName("Is_Ready_for_Approval__c")
//    public boolean is_Ready_for_Approval__c;
//    @SerializedName("LastActivityDate")
//    private java.util.Date lastActivityDate;
//    @SerializedName("LastModifiedBy")
//    private User lastModifiedBy;
//    @SerializedName("LastModifiedById")
//    private String lastModifiedById;
//    @SerializedName("LastModifiedDate")
//    private java.util.Calendar lastModifiedDate;
//    @SerializedName("LastReferencedDate")
//    private java.util.Calendar lastReferencedDate;
//    @SerializedName("LastViewedDate")
//    private java.util.Calendar lastViewedDate;
//    @SerializedName("License_Number__c")
//    private String license_Number__c;
//    @SerializedName("License_and_Establishment_Card_Fee__c")
//    private Double license_and_Establishment_Card_Fee__c;
//    @SerializedName("Line_Item_Number__c")
//    private Double line_Item_Number__c;
//    @SerializedName("LookedUpFromActivities")
//    private QueryResult lookedUpFromActivities;

//    @SerializedName("No_of_Discounted_Service_Charge_Payments__c")
//    private Double no_of_Discounted_Service_Charge_Payments__c;
//    @SerializedName("Not_willing_to_Renew__c")
//    public boolean not_willing_to_Renew__c;
//    @SerializedName("Notes")
//    private QueryResult notes;
//    @SerializedName("NotesAndAttachments")
//    private QueryResult notesAndAttachments;
//    @SerializedName("Number_of_Discounted_Rent_Payments__c")
//    private Double number_of_Discounted_Rent_Payments__c;
//    @SerializedName("Number_of_Installment__c")
//    private Double number_of_Installment__c;
//    @SerializedName("Number_of_Installments__c")
//    private Double number_of_Installments__c;
//    @SerializedName("Number_of_Years_for_Service_Charges__c")
//    private Double number_of_Years_for_Service_Charges__c;
//    @SerializedName("Number_of_Years_of_Payments_to_Print__c")
//    private String number_of_Years_of_Payments_to_Print__c;
//    @SerializedName("Office_Area__c")
//    private Double office_Area__c;
//    @SerializedName("Office_Rent__c")
//    private Double office_Rent__c;
//    @SerializedName("Office_number__c")
//    private String office_number__c;
//    @SerializedName("OpenActivities")
//    private QueryResult openActivities;
//    @SerializedName("Owner_Expiration_Notice_days__c")
//    private Double owner_Expiration_Notice_days__c;
//    @SerializedName("Penalty_Gathered__c")
//    public boolean penalty_Gathered__c;
//    @SerializedName("Phone__c")
//    private String phone__c;
//    @SerializedName("Plot_Rent__c")
//    private Double plot_Rent__c;
//    @SerializedName("Power_Allocation__c")
//    private Double power_Allocation__c;
//    @SerializedName("Primary_Contact_Name__c")
//    private String primary_Contact_Name__c;
//    @SerializedName("ProcessInstances")
//    private QueryResult processInstances;
//    @SerializedName("ProcessSteps")
//    private QueryResult processSteps;
//    @SerializedName("Quantity__c")
//    private Double quantity__c;
//    @SerializedName("Quote__c")
//    private String quote__c;
//    @SerializedName("Quote__r")
//    private Quote quote__r;
//    @SerializedName("RecordAssociatedGroups")
//    private QueryResult recordAssociatedGroups;
//    @SerializedName("RecordType")
//    private RecordType recordType;
//    @SerializedName("RecordTypeId")
//    private String recordTypeId;
//    @SerializedName("Record_Type_Name__c")
//    private String record_Type_Name__c;
//    @SerializedName("Registration_Fee__c")
//    private Double registration_Fee__c;
//    @SerializedName("Renewal_Stage__c")
//    private String renewal_Stage__c;
//    @SerializedName("Renewed_Contract__c")
//    private String renewed_Contract__c;
//
//    @SerializedName("Renewed_Finance_Approval_Status__c")
//    private String renewed_Finance_Approval_Status__c;
//    @SerializedName("Renewed_Inventory_Approval_Status__c")
//    private String renewed_Inventory_Approval_Status__c;
//    @SerializedName("Renewed_License_Approval_Status__c")
//    private String renewed_License_Approval_Status__c;
//    @SerializedName("Renewed_Tenancy_Contract__c")
//    private String renewed_Tenancy_Contract__c;
//
//    @SerializedName("Rent_Adjustment_Arabic_Formula__c")
//    private String rent_Adjustment_Arabic_Formula__c;
//    @SerializedName("Rent_Adjustment__c")
//    private String rent_Adjustment__c;
//    @SerializedName("Rent_Free_Period_Days__c")
//    private Double rent_Free_Period_Days__c;
//    @SerializedName("Rent_Initial_Discount_Duration_Years__c")
//    private Double rent_Initial_Discount_Duration_Years__c;
//    @SerializedName("Rent_Initial_Discount__c")
//    private Double rent_Initial_Discount__c;
//    @SerializedName("Rent_Price__c")
//    private Double rent_Price__c;
//    @SerializedName("Rent_Start_Date__c")
//    private java.util.Date rent_Start_Date__c;
//    @SerializedName("SMS_Agent_Mobile__c")
//    private String SMS_Agent_Mobile__c;
//    @SerializedName("SMS_Tenant_Mobile__c")
//    private String SMS_Tenant_Mobile__c;
//    @SerializedName("Sales_Price__c")
//    private Double sales_Price__c;
//    @SerializedName("Security_Deposit__c")
//    private Double security_Deposit__c;
//    @SerializedName("Service_Charge_Amount__c")
//    private Double service_Charge_Amount__c;
//    @SerializedName("Service_Charge_Installments_Per_Year__c")
//    private Double service_Charge_Installments_Per_Year__c;
//    @SerializedName("Service_Charges_Discount_Duration_Years__c")
//    private Double service_Charges_Discount_Duration_Years__c;
//    @SerializedName("Service_Charges_Initial_Discount__c")
//    private Double service_Charges_Initial_Discount__c;
//    @SerializedName("Service_Charges_Per_Square_Meter__c")
//    private Double service_Charges_Per_Square_Meter__c;
//    @SerializedName("Service_Charges_per_sqm__c")
//    private Double service_Charges_per_sqm__c;
//
//    @SerializedName("ShippingAddress__c")
//    private String shippingAddress__c;
//    @SerializedName("ShippingName__c")
//    private String shippingName__c;
//    @SerializedName("Shipping_and_Handling__c")
//    private Double shipping_and_Handling__c;
//    @SerializedName("Signed_Contract__c")
//    private String signed_Contract__c;
//    @SerializedName("Special_Conditions_Arabic__c")
//    private String special_Conditions_Arabic__c;
//    @SerializedName("Special_Conditions__c")
//    private String special_Conditions__c;
//
//
//    @SerializedName("Status__c")
//    private String status__c;
//    @SerializedName("SystemModstamp")
//    private java.util.Calendar systemModstamp;
//    @SerializedName("Tasks")
//    private QueryResult tasks;
//    @SerializedName("Tax__c")
//    private Double tax__c;
//
//    @SerializedName("Tenancy_Contract_Template__c")
//    private String tenancy_Contract_Template__c;
//    @SerializedName("Tenant_Address_Arabic__c")
//    private String tenant_Address_Arabic__c;
//    @SerializedName("Tenant_Address__c")
//    private String tenant_Address__c;
//    @SerializedName("Tenant_Name_Arabic__c")
//    private String tenant_Name_Arabic__c;
//    @SerializedName("Tenant_Name__c")
//    private String tenant_Name__c;
//    @SerializedName("Tenant__c")
//    private String tenant__c;
//
//    @SerializedName("Today_Month__c")
//    public boolean today_Month__c;
//    @SerializedName("TopicAssignments")
//    private QueryResult topicAssignments;
//    @SerializedName("Total_Contract_Value__c")
//    private Double total_Contract_Value__c;
//    @SerializedName("Total_Installments__c")
//    private Double total_Installments__c;
//    @SerializedName("Total_Price__c")
//    private Double total_Price__c;
//    @SerializedName("Total_Rent_Price_Formula__c")
//    private Double total_Rent_Price_Formula__c;
//    @SerializedName("Total_Rent_Price__c")
//    private Double total_Rent_Price__c;
//    @SerializedName("Total_Service_Charge_Installments__c")
//    private Double total_Service_Charge_Installments__c;
//    @SerializedName("Total_Service_Charges__c")
//    private Double total_Service_Charges__c;
//    @SerializedName("Total_Visas_Granted__c")
//    private Double total_Visas_Granted__c;
//    @SerializedName("UAE_Citizen_Discount__c")
//    private Double UAE_Citizen_Discount__c;
//    @SerializedName("Unit_Handover_Date__c")
//    private java.util.Date unit_Handover_Date__c;
//    @SerializedName("Unit_Name__c")
//    private String unit_Name__c;
//
//    @SerializedName("Units_Reserved_or_Leased_Until__c")
//    private java.util.Date units_Reserved_or_Leased_Until__c;
//    @SerializedName("Unpaid_Due_Payments_On_Cancellation__c")
//    public boolean unpaid_Due_Payments_On_Cancellation__c;
//    @SerializedName("Updated__c")
//    public boolean updated__c;
//    @SerializedName("Warehouse_Area__c")
//    private Double warehouse_Area__c;
//    @SerializedName("Warehouse_Rent__c")
//    private Double warehouse_Rent__c;
//    @SerializedName("Warehouse_number__c")
//    private String warehouse_number__c;
//    @SerializedName("X30DaysBeforeExpiryFlag__c")
//    public boolean x30DaysBeforeExpiryFlag__c;
//
//    public Contract_Line_Item__c getContract_line_items__r() {
//        return contract_line_items__r;
//    }
//
//    public void setContract_line_items__r(Contract_Line_Item__c contract_line_items__r) {
//        this.contract_line_items__r = contract_line_items__r;
//    }
//
//    @SerializedName("Contract_Line_Items__r")
//    private Contract_Line_Item__c contract_line_items__r;
//
//    public Contract_DWC__c() {
//    }
//
//
//    /**
//     * Gets the account__c value for this Contract_DWC__c.
//     *
//     * @return account__c
//     */
//    public String getAccount__c() {
//        return account__c;
//    }
//
//
//    /**
//     * Sets the account__c value for this Contract_DWC__c.
//     *
//     * @param account__c
//     */
//    public void setAccount__c(String account__c) {
//        this.account__c = account__c;
//    }
//
//
//    /**
//     * Gets the activated_By__c value for this Contract_DWC__c.
//     *
//     * @return activated_By__c
//     */
//    public String getActivated_By__c() {
//        return activated_By__c;
//    }
//
//
//    /**
//     * Sets the activated_By__c value for this Contract_DWC__c.
//     *
//     * @param activated_By__c
//     */
//    public void setActivated_By__c(String activated_By__c) {
//        this.activated_By__c = activated_By__c;
//    }
//
//
//    /**
//     * Gets the activated_Date__c value for this Contract_DWC__c.
//     *
//     * @return activated_Date__c
//     */
//    public java.util.Date getActivated_Date__c() {
//        return activated_Date__c;
//    }
//
//
//    /**
//     * Sets the activated_Date__c value for this Contract_DWC__c.
//     *
//     * @param activated_Date__c
//     */
//    public void setActivated_Date__c(java.util.Date activated_Date__c) {
//        this.activated_Date__c = activated_Date__c;
//    }
//
//
//    /**
//     * Gets the activityHistories value for this Contract_DWC__c.
//     *
//     * @return activityHistories
//     */
//    public QueryResult getActivityHistories() {
//        return activityHistories;
//    }
//
//
//    /**
//     * Sets the activityHistories value for this Contract_DWC__c.
//     *
//     * @param activityHistories
//     */
//    public void setActivityHistories(QueryResult activityHistories) {
//        this.activityHistories = activityHistories;
//    }
//
//
//    /**
//     * Gets the annual_Rent_AED__c value for this Contract_DWC__c.
//     *
//     * @return annual_Rent_AED__c
//     */
//    public Double getAnnual_Rent_AED__c() {
//        return annual_Rent_AED__c;
//    }
//
//
//    /**
//     * Sets the annual_Rent_AED__c value for this Contract_DWC__c.
//     *
//     * @param annual_Rent_AED__c
//     */
//    public void setAnnual_Rent_AED__c(Double annual_Rent_AED__c) {
//        this.annual_Rent_AED__c = annual_Rent_AED__c;
//    }
//
//
//    /**
//     * Gets the annual_Rent__c value for this Contract_DWC__c.
//     *
//     * @return annual_Rent__c
//     */
//    public Double getAnnual_Rent__c() {
//        return annual_Rent__c;
//    }
//
//
//    /**
//     * Sets the annual_Rent__c value for this Contract_DWC__c.
//     *
//     * @param annual_Rent__c
//     */
//    public void setAnnual_Rent__c(Double annual_Rent__c) {
//        this.annual_Rent__c = annual_Rent__c;
//    }
//
//
//    /**
//     * Gets the annual_Service_ChargesFormula__c value for this Contract_DWC__c.
//     *
//     * @return annual_Service_ChargesFormula__c
//     */
//    public Double getAnnual_Service_ChargesFormula__c() {
//        return annual_Service_ChargesFormula__c;
//    }
//
//
//    /**
//     * Sets the annual_Service_ChargesFormula__c value for this Contract_DWC__c.
//     *
//     * @param annual_Service_ChargesFormula__c
//     */
//    public void setAnnual_Service_ChargesFormula__c(Double annual_Service_ChargesFormula__c) {
//        this.annual_Service_ChargesFormula__c = annual_Service_ChargesFormula__c;
//    }
//
//
//    /**
//     * Gets the annual_Service_Charges_Formula__c value for this Contract_DWC__c.
//     *
//     * @return annual_Service_Charges_Formula__c
//     */
//    public Double getAnnual_Service_Charges_Formula__c() {
//        return annual_Service_Charges_Formula__c;
//    }
//
//
//    /**
//     * Sets the annual_Service_Charges_Formula__c value for this Contract_DWC__c.
//     *
//     * @param annual_Service_Charges_Formula__c
//     */
//    public void setAnnual_Service_Charges_Formula__c(Double annual_Service_Charges_Formula__c) {
//        this.annual_Service_Charges_Formula__c = annual_Service_Charges_Formula__c;
//    }
//
//
//    /**
//     * Gets the annual_Service_Charges__c value for this Contract_DWC__c.
//     *
//     * @return annual_Service_Charges__c
//     */
//    public Double getAnnual_Service_Charges__c() {
//        return annual_Service_Charges__c;
//    }
//
//
//    /**
//     * Sets the annual_Service_Charges__c value for this Contract_DWC__c.
//     *
//     * @param annual_Service_Charges__c
//     */
//    public void setAnnual_Service_Charges__c(Double annual_Service_Charges__c) {
//        this.annual_Service_Charges__c = annual_Service_Charges__c;
//    }
//
//
//    /**
//     * Gets the anticipated_Operation_Date__c value for this Contract_DWC__c.
//     *
//     * @return anticipated_Operation_Date__c
//     */
//    public java.util.Date getAnticipated_Operation_Date__c() {
//        return anticipated_Operation_Date__c;
//    }
//
//
//    /**
//     * Sets the anticipated_Operation_Date__c value for this Contract_DWC__c.
//     *
//     * @param anticipated_Operation_Date__c
//     */
//    public void setAnticipated_Operation_Date__c(java.util.Date anticipated_Operation_Date__c) {
//        this.anticipated_Operation_Date__c = anticipated_Operation_Date__c;
//    }
//
//
//    /**
//     * Gets the apron_Plot__c value for this Contract_DWC__c.
//     *
//     * @return apron_Plot__c
//     */
//    public Double getApron_Plot__c() {
//        return apron_Plot__c;
//    }
//
//
//    /**
//     * Sets the apron_Plot__c value for this Contract_DWC__c.
//     *
//     * @param apron_Plot__c
//     */
//    public void setApron_Plot__c(Double apron_Plot__c) {
//        this.apron_Plot__c = apron_Plot__c;
//    }
//
//
//    /**
//     * Gets the apron_Rent__c value for this Contract_DWC__c.
//     *
//     * @return apron_Rent__c
//     */
//    public Double getApron_Rent__c() {
//        return apron_Rent__c;
//    }
//
//
//    /**
//     * Sets the apron_Rent__c value for this Contract_DWC__c.
//     *
//     * @param apron_Rent__c
//     */
//    public void setApron_Rent__c(Double apron_Rent__c) {
//        this.apron_Rent__c = apron_Rent__c;
//    }
//
//
//    /**
//     * Gets the area_Plot__c value for this Contract_DWC__c.
//     *
//     * @return area_Plot__c
//     */
//    public Double getArea_Plot__c() {
//        return area_Plot__c;
//    }
//
//
//    /**
//     * Sets the area_Plot__c value for this Contract_DWC__c.
//     *
//     * @param area_Plot__c
//     */
//    public void setArea_Plot__c(Double area_Plot__c) {
//        this.area_Plot__c = area_Plot__c;
//    }
//
//
//    /**
//     * Gets the attachedContentDocuments value for this Contract_DWC__c.
//     *
//     * @return attachedContentDocuments
//     */
//    public QueryResult getAttachedContentDocuments() {
//        return attachedContentDocuments;
//    }
//
//
//    /**
//     * Sets the attachedContentDocuments value for this Contract_DWC__c.
//     *
//     * @param attachedContentDocuments
//     */
//    public void setAttachedContentDocuments(QueryResult attachedContentDocuments) {
//        this.attachedContentDocuments = attachedContentDocuments;
//    }
//
//
//    /**
//     * Gets the attachments value for this Contract_DWC__c.
//     *
//     * @return attachments
//     */
//    public QueryResult getAttachments() {
//        return attachments;
//    }
//
//
//    /**
//     * Sets the attachments value for this Contract_DWC__c.
//     *
//     * @param attachments
//     */
//    public void setAttachments(QueryResult attachments) {
//        this.attachments = attachments;
//    }
//
//
//    /**
//     * Gets the authorized_DWC_Arabic__c value for this Contract_DWC__c.
//     *
//     * @return authorized_DWC_Arabic__c
//     */
//    public String getAuthorized_DWC_Arabic__c() {
//        return authorized_DWC_Arabic__c;
//    }
//
//
//    /**
//     * Sets the authorized_DWC_Arabic__c value for this Contract_DWC__c.
//     *
//     * @param authorized_DWC_Arabic__c
//     */
//    public void setAuthorized_DWC_Arabic__c(String authorized_DWC_Arabic__c) {
//        this.authorized_DWC_Arabic__c = authorized_DWC_Arabic__c;
//    }
//
//
//    /**
//     * Gets the authorized_DWC_Signatory_Arabic__c value for this Contract_DWC__c.
//     *
//     * @return authorized_DWC_Signatory_Arabic__c
//     */
//    public String getAuthorized_DWC_Signatory_Arabic__c() {
//        return authorized_DWC_Signatory_Arabic__c;
//    }
//
//
//    /**
//     * Sets the authorized_DWC_Signatory_Arabic__c value for this Contract_DWC__c.
//     *
//     * @param authorized_DWC_Signatory_Arabic__c
//     */
//    public void setAuthorized_DWC_Signatory_Arabic__c(String authorized_DWC_Signatory_Arabic__c) {
//        this.authorized_DWC_Signatory_Arabic__c = authorized_DWC_Signatory_Arabic__c;
//    }
//
//
//    /**
//     * Gets the authorized_DWC_Signatory__c value for this Contract_DWC__c.
//     *
//     * @return authorized_DWC_Signatory__c
//     */
//    public String getAuthorized_DWC_Signatory__c() {
//        return authorized_DWC_Signatory__c;
//    }
//
//
//    /**
//     * Sets the authorized_DWC_Signatory__c value for this Contract_DWC__c.
//     *
//     * @param authorized_DWC_Signatory__c
//     */
//    public void setAuthorized_DWC_Signatory__c(String authorized_DWC_Signatory__c) {
//        this.authorized_DWC_Signatory__c = authorized_DWC_Signatory__c;
//    }
//
//    /**
//     * Gets the bill_To_Name__c value for this Contract_DWC__c.
//     *
//     * @return bill_To_Name__c
//     */
//    public String getBill_To_Name__c() {
//        return bill_To_Name__c;
//    }
//
//
//    /**
//     * Sets the bill_To_Name__c value for this Contract_DWC__c.
//     *
//     * @param bill_To_Name__c
//     */
//    public void setBill_To_Name__c(String bill_To_Name__c) {
//        this.bill_To_Name__c = bill_To_Name__c;
//    }
//
//
//    /**
//     * Gets the billingAddress__c value for this Contract_DWC__c.
//     *
//     * @return billingAddress__c
//     */
//    public String getBillingAddress__c() {
//        return billingAddress__c;
//    }
//
//
//    /**
//     * Sets the billingAddress__c value for this Contract_DWC__c.
//     *
//     * @param billingAddress__c
//     */
//    public void setBillingAddress__c(String billingAddress__c) {
//        this.billingAddress__c = billingAddress__c;
//    }
//
//
//    /**
//     * Gets the building_Number__c value for this Contract_DWC__c.
//     *
//     * @return building_Number__c
//     */
//    public String getBuilding_Number__c() {
//        return building_Number__c;
//    }
//
//
//    /**
//     * Sets the building_Number__c value for this Contract_DWC__c.
//     *
//     * @param building_Number__c
//     */
//    public void setBuilding_Number__c(String building_Number__c) {
//        this.building_Number__c = building_Number__c;
//    }
//
//
//    /**
//     * Gets the CS_Comments__c value for this Contract_DWC__c.
//     *
//     * @return CS_Comments__c
//     */
//    public String getCS_Comments__c() {
//        return CS_Comments__c;
//    }
//
//
//    /**
//     * Sets the CS_Comments__c value for this Contract_DWC__c.
//     *
//     * @param CS_Comments__c
//     */
//    public void setCS_Comments__c(String CS_Comments__c) {
//        this.CS_Comments__c = CS_Comments__c;
//    }
//
//
//    /**
//     * Gets the CS_Team_Member__c value for this Contract_DWC__c.
//     *
//     * @return CS_Team_Member__c
//     */
//    public String getCS_Team_Member__c() {
//        return CS_Team_Member__c;
//    }
//
//
//    /**
//     * Sets the CS_Team_Member__c value for this Contract_DWC__c.
//     *
//     * @param CS_Team_Member__c
//     */
//    public void setCS_Team_Member__c(String CS_Team_Member__c) {
//        this.CS_Team_Member__c = CS_Team_Member__c;
//    }
//
//
//    /**
//     * Gets the CY_Invoiced__c value for this Contract_DWC__c.
//     *
//     * @return CY_Invoiced__c
//     */
//    public Double getCY_Invoiced__c() {
//        return CY_Invoiced__c;
//    }
//
//
//    /**
//     * Sets the CY_Invoiced__c value for this Contract_DWC__c.
//     *
//     * @param CY_Invoiced__c
//     */
//    public void setCY_Invoiced__c(Double CY_Invoiced__c) {
//        this.CY_Invoiced__c = CY_Invoiced__c;
//    }
//
//
//    /**
//     * Gets the cancellation_Date__c value for this Contract_DWC__c.
//     *
//     * @return cancellation_Date__c
//     */
//    public java.util.Date getCancellation_Date__c() {
//        return cancellation_Date__c;
//    }
//
//
//    /**
//     * Sets the cancellation_Date__c value for this Contract_DWC__c.
//     *
//     * @param cancellation_Date__c
//     */
//    public void setCancellation_Date__c(java.util.Date cancellation_Date__c) {
//        this.cancellation_Date__c = cancellation_Date__c;
//    }
//
//
//    /**
//     * Gets the cancellation_Reason__c value for this Contract_DWC__c.
//     *
//     * @return cancellation_Reason__c
//     */
//    public String getCancellation_Reason__c() {
//        return cancellation_Reason__c;
//    }
//
//
//    /**
//     * Sets the cancellation_Reason__c value for this Contract_DWC__c.
//     *
//     * @param cancellation_Reason__c
//     */
//    public void setCancellation_Reason__c(String cancellation_Reason__c) {
//        this.cancellation_Reason__c = cancellation_Reason__c;
//    }
//
//
//    /**
//     * Gets the cancellation_Type__c value for this Contract_DWC__c.
//     *
//     * @return cancellation_Type__c
//     */
//    public String getCancellation_Type__c() {
//        return cancellation_Type__c;
//    }
//
//
//    /**
//     * Sets the cancellation_Type__c value for this Contract_DWC__c.
//     *
//     * @param cancellation_Type__c
//     */
//    public void setCancellation_Type__c(String cancellation_Type__c) {
//        this.cancellation_Type__c = cancellation_Type__c;
//    }
//
//
//    /**
//     * Gets the cancelled_Deregistration_Approval_Status__c value for this Contract_DWC__c.
//     *
//     * @return cancelled_Deregistration_Approval_Status__c
//     */
//    public String getCancelled_Deregistration_Approval_Status__c() {
//        return cancelled_Deregistration_Approval_Status__c;
//    }
//
//
//    /**
//     * Sets the cancelled_Deregistration_Approval_Status__c value for this Contract_DWC__c.
//     *
//     * @param cancelled_Deregistration_Approval_Status__c
//     */
//    public void setCancelled_Deregistration_Approval_Status__c(String cancelled_Deregistration_Approval_Status__c) {
//        this.cancelled_Deregistration_Approval_Status__c = cancelled_Deregistration_Approval_Status__c;
//    }
//
//
//    /**
//     * Gets the cancelled_Finance_Approval_Status__c value for this Contract_DWC__c.
//     *
//     * @return cancelled_Finance_Approval_Status__c
//     */
//    public String getCancelled_Finance_Approval_Status__c() {
//        return cancelled_Finance_Approval_Status__c;
//    }
//
//
//    /**
//     * Sets the cancelled_Finance_Approval_Status__c value for this Contract_DWC__c.
//     *
//     * @param cancelled_Finance_Approval_Status__c
//     */
//    public void setCancelled_Finance_Approval_Status__c(String cancelled_Finance_Approval_Status__c) {
//        this.cancelled_Finance_Approval_Status__c = cancelled_Finance_Approval_Status__c;
//    }
//
//
//    /**
//     * Gets the cancelled_License_Approval_Status__c value for this Contract_DWC__c.
//     *
//     * @return cancelled_License_Approval_Status__c
//     */
//    public String getCancelled_License_Approval_Status__c() {
//        return cancelled_License_Approval_Status__c;
//    }
//
//
//    /**
//     * Sets the cancelled_License_Approval_Status__c value for this Contract_DWC__c.
//     *
//     * @param cancelled_License_Approval_Status__c
//     */
//    public void setCancelled_License_Approval_Status__c(String cancelled_License_Approval_Status__c) {
//        this.cancelled_License_Approval_Status__c = cancelled_License_Approval_Status__c;
//    }
//
//
//    /**
//     * Gets the contact__c value for this Contract_DWC__c.
//     *
//     * @return contact__c
//     */
//    public String getContact__c() {
//        return contact__c;
//    }
//
//
//    /**
//     * Sets the contact__c value for this Contract_DWC__c.
//     *
//     * @param contact__c
//     */
//    public void setContact__c(String contact__c) {
//        this.contact__c = contact__c;
//    }
//
//
//    /**
//     * Gets the contract_Collected_By__c value for this Contract_DWC__c.
//     *
//     * @return contract_Collected_By__c
//     */
//    public String getContract_Collected_By__c() {
//        return contract_Collected_By__c;
//    }
//
//
//    /**
//     * Sets the contract_Collected_By__c value for this Contract_DWC__c.
//     *
//     * @param contract_Collected_By__c
//     */
//    public void setContract_Collected_By__c(String contract_Collected_By__c) {
//        this.contract_Collected_By__c = contract_Collected_By__c;
//    }
//
//
//    /**
//     * Gets the contract_Collection_Date_Time__c value for this Contract_DWC__c.
//     *
//     * @return contract_Collection_Date_Time__c
//     */
//    public java.util.Calendar getContract_Collection_Date_Time__c() {
//        return contract_Collection_Date_Time__c;
//    }
//
//
//    /**
//     * Sets the contract_Collection_Date_Time__c value for this Contract_DWC__c.
//     *
//     * @param contract_Collection_Date_Time__c
//     */
//    public void setContract_Collection_Date_Time__c(java.util.Calendar contract_Collection_Date_Time__c) {
//        this.contract_Collection_Date_Time__c = contract_Collection_Date_Time__c;
//    }
//
//
//    /**
//     * Gets the contract_Day__c value for this Contract_DWC__c.
//     *
//     * @return contract_Day__c
//     */
//    public Double getContract_Day__c() {
//        return contract_Day__c;
//    }
//
//
//    /**
//     * Sets the contract_Day__c value for this Contract_DWC__c.
//     *
//     * @param contract_Day__c
//     */
//    public void setContract_Day__c(Double contract_Day__c) {
//        this.contract_Day__c = contract_Day__c;
//    }
//
//
//    /**
//     * Gets the contract_Duration_Year_Month__c value for this Contract_DWC__c.
//     *
//     * @return contract_Duration_Year_Month__c
//     */
//    public String getContract_Duration_Year_Month__c() {
//        return contract_Duration_Year_Month__c;
//    }
//
//
//    /**
//     * Sets the contract_Duration_Year_Month__c value for this Contract_DWC__c.
//     *
//     * @param contract_Duration_Year_Month__c
//     */
//    public void setContract_Duration_Year_Month__c(String contract_Duration_Year_Month__c) {
//        this.contract_Duration_Year_Month__c = contract_Duration_Year_Month__c;
//    }
//
//
//    /**
//     * Gets the contract_Duration__c value for this Contract_DWC__c.
//     *
//     * @return contract_Duration__c
//     */
//    public Double getContract_Duration__c() {
//        return contract_Duration__c;
//    }
//
//
//    /**
//     * Sets the contract_Duration__c value for this Contract_DWC__c.
//     *
//     * @param contract_Duration__c
//     */
//    public void setContract_Duration__c(Double contract_Duration__c) {
//        this.contract_Duration__c = contract_Duration__c;
//    }
//
//
//    /**
//     * Gets the contract_Expiry_Date__c value for this Contract_DWC__c.
//     *
//     * @return contract_Expiry_Date__c
//     */
//    public java.util.Date getContract_Expiry_Date__c() {
//        return contract_Expiry_Date__c;
//    }
//
//
//    /**
//     * Sets the contract_Expiry_Date__c value for this Contract_DWC__c.
//     *
//     * @param contract_Expiry_Date__c
//     */
//    public void setContract_Expiry_Date__c(java.util.Date contract_Expiry_Date__c) {
//        this.contract_Expiry_Date__c = contract_Expiry_Date__c;
//    }
//
//
//    /**
//     * Gets the contract_Month__c value for this Contract_DWC__c.
//     *
//     * @return contract_Month__c
//     */
//    public Double getContract_Month__c() {
//        return contract_Month__c;
//    }
//
//
//    /**
//     * Sets the contract_Month__c value for this Contract_DWC__c.
//     *
//     * @param contract_Month__c
//     */
//    public void setContract_Month__c(Double contract_Month__c) {
//        this.contract_Month__c = contract_Month__c;
//    }
//
//
//    /**
//     * Gets the contract_Number__c value for this Contract_DWC__c.
//     *
//     * @return contract_Number__c
//     */
//    public String getContract_Number__c() {
//        return contract_Number__c;
//    }
//
//
//    /**
//     * Sets the contract_Number__c value for this Contract_DWC__c.
//     *
//     * @param contract_Number__c
//     */
//    public void setContract_Number__c(String contract_Number__c) {
//        this.contract_Number__c = contract_Number__c;
//    }
//
//
//    /**
//     * Gets the contract_Opportunity__c value for this Contract_DWC__c.
//     *
//     * @return contract_Opportunity__c
//     */
//    public String getContract_Opportunity__c() {
//        return contract_Opportunity__c;
//    }
//
//
//    /**
//     * Sets the contract_Opportunity__c value for this Contract_DWC__c.
//     *
//     * @param contract_Opportunity__c
//     */
//    public void setContract_Opportunity__c(String contract_Opportunity__c) {
//        this.contract_Opportunity__c = contract_Opportunity__c;
//    }
//
//
//    /**
//     * Gets the contract_Start_Date__c value for this Contract_DWC__c.
//     *
//     * @return contract_Start_Date__c
//     */
//    public java.util.Date getContract_Start_Date__c() {
//        return contract_Start_Date__c;
//    }
//
//
//    /**
//     * Sets the contract_Start_Date__c value for this Contract_DWC__c.
//     *
//     * @param contract_Start_Date__c
//     */
//    public void setContract_Start_Date__c(java.util.Date contract_Start_Date__c) {
//        this.contract_Start_Date__c = contract_Start_Date__c;
//    }
//
//
//    /**
//     * Gets the contract_Start_Month__c value for this Contract_DWC__c.
//     *
//     * @return contract_Start_Month__c
//     */
//    public Double getContract_Start_Month__c() {
//        return contract_Start_Month__c;
//    }
//
//
//    /**
//     * Sets the contract_Start_Month__c value for this Contract_DWC__c.
//     *
//     * @param contract_Start_Month__c
//     */
//    public void setContract_Start_Month__c(Double contract_Start_Month__c) {
//        this.contract_Start_Month__c = contract_Start_Month__c;
//    }
//
//
//    /**
//     * Gets the contract_Term_months__c value for this Contract_DWC__c.
//     *
//     * @return contract_Term_months__c
//     */
//    public Double getContract_Term_months__c() {
//        return contract_Term_months__c;
//    }
//
//
//    /**
//     * Sets the contract_Term_months__c value for this Contract_DWC__c.
//     *
//     * @param contract_Term_months__c
//     */
//    public void setContract_Term_months__c(Double contract_Term_months__c) {
//        this.contract_Term_months__c = contract_Term_months__c;
//    }
//
//
//    /**
//     * Gets the contract_Transfer_Date__c value for this Contract_DWC__c.
//     *
//     * @return contract_Transfer_Date__c
//     */
//    public java.util.Date getContract_Transfer_Date__c() {
//        return contract_Transfer_Date__c;
//    }
//
//
//    /**
//     * Sets the contract_Transfer_Date__c value for this Contract_DWC__c.
//     *
//     * @param contract_Transfer_Date__c
//     */
//    public void setContract_Transfer_Date__c(java.util.Date contract_Transfer_Date__c) {
//        this.contract_Transfer_Date__c = contract_Transfer_Date__c;
//    }
//
//
//    /**
//     * Gets the contract_Type__c value for this Contract_DWC__c.
//     *
//     * @return contract_Type__c
//     */
//    public String getContract_Type__c() {
//        return contract_Type__c;
//    }
//
//
//    /**
//     * Sets the contract_Type__c value for this Contract_DWC__c.
//     *
//     * @param contract_Type__c
//     */
//    public void setContract_Type__c(String contract_Type__c) {
//        this.contract_Type__c = contract_Type__c;
//    }
//
//
//    /**
//     * Gets the contract_Year__c value for this Contract_DWC__c.
//     *
//     * @return contract_Year__c
//     */
//    public Double getContract_Year__c() {
//        return contract_Year__c;
//    }
//
//
//    /**
//     * Sets the contract_Year__c value for this Contract_DWC__c.
//     *
//     * @param contract_Year__c
//     */
//    public void setContract_Year__c(Double contract_Year__c) {
//        this.contract_Year__c = contract_Year__c;
//    }
//
//
//    /**
//     * Gets the createdBy value for this Contract_DWC__c.
//     *
//     * @return createdBy
//     */
//    public User getCreatedBy() {
//        return createdBy;
//    }
//
//
//    /**
//     * Sets the createdBy value for this Contract_DWC__c.
//     *
//     * @param createdBy
//     */
//    public void setCreatedBy(User createdBy) {
//        this.createdBy = createdBy;
//    }
//
//
//    /**
//     * Gets the createdById value for this Contract_DWC__c.
//     *
//     * @return createdById
//     */
//    public String getCreatedById() {
//        return createdById;
//    }
//
//
//    /**
//     * Sets the createdById value for this Contract_DWC__c.
//     *
//     * @param createdById
//     */
//    public void setCreatedById(String createdById) {
//        this.createdById = createdById;
//    }
//
//
//    /**
//     * Gets the createdDate value for this Contract_DWC__c.
//     *
//     * @return createdDate
//     */
//    public java.util.Calendar getCreatedDate() {
//        return createdDate;
//    }
//
//
//    /**
//     * Sets the createdDate value for this Contract_DWC__c.
//     *
//     * @param createdDate
//     */
//    public void setCreatedDate(java.util.Calendar createdDate) {
//        this.createdDate = createdDate;
//    }
//
//
//    /**
//     * Gets the currencyIsoCode value for this Contract_DWC__c.
//     *
//     * @return currencyIsoCode
//     */
//    public String getCurrencyIsoCode() {
//        return currencyIsoCode;
//    }
//
//
//    /**
//     * Sets the currencyIsoCode value for this Contract_DWC__c.
//     *
//     * @param currencyIsoCode
//     */
//    public void setCurrencyIsoCode(String currencyIsoCode) {
//        this.currencyIsoCode = currencyIsoCode;
//    }
//
//
//    /**
//     * Gets the customer_ERP_Code__c value for this Contract_DWC__c.
//     *
//     * @return customer_ERP_Code__c
//     */
//    public String getCustomer_ERP_Code__c() {
//        return customer_ERP_Code__c;
//    }
//
//
//    /**
//     * Sets the customer_ERP_Code__c value for this Contract_DWC__c.
//     *
//     * @param customer_ERP_Code__c
//     */
//    public void setCustomer_ERP_Code__c(String customer_ERP_Code__c) {
//        this.customer_ERP_Code__c = customer_ERP_Code__c;
//    }
//
//
//    /**
//     * Gets the customer_Position__c value for this Contract_DWC__c.
//     *
//     * @return customer_Position__c
//     */
//    public String getCustomer_Position__c() {
//        return customer_Position__c;
//    }
//
//
//    /**
//     * Sets the customer_Position__c value for this Contract_DWC__c.
//     *
//     * @param customer_Position__c
//     */
//    public void setCustomer_Position__c(String customer_Position__c) {
//        this.customer_Position__c = customer_Position__c;
//    }
//
//
//    /**
//     * Gets the customer_Signed_By_Arabic__c value for this Contract_DWC__c.
//     *
//     * @return customer_Signed_By_Arabic__c
//     */
//    public String getCustomer_Signed_By_Arabic__c() {
//        return customer_Signed_By_Arabic__c;
//    }
//
//
//    /**
//     * Sets the customer_Signed_By_Arabic__c value for this Contract_DWC__c.
//     *
//     * @param customer_Signed_By_Arabic__c
//     */
//    public void setCustomer_Signed_By_Arabic__c(String customer_Signed_By_Arabic__c) {
//        this.customer_Signed_By_Arabic__c = customer_Signed_By_Arabic__c;
//    }
//
//
//    /**
//     * Gets the customer_Signed_By__c value for this Contract_DWC__c.
//     *
//     * @return customer_Signed_By__c
//     */
//    public String getCustomer_Signed_By__c() {
//        return customer_Signed_By__c;
//    }
//
//
//    /**
//     * Sets the customer_Signed_By__c value for this Contract_DWC__c.
//     *
//     * @param customer_Signed_By__c
//     */
//    public void setCustomer_Signed_By__c(String customer_Signed_By__c) {
//        this.customer_Signed_By__c = customer_Signed_By__c;
//    }
//
//    /**
//     * Gets the customer_Signed_Date__c value for this Contract_DWC__c.
//     *
//     * @return customer_Signed_Date__c
//     */
//    public java.util.Date getCustomer_Signed_Date__c() {
//        return customer_Signed_Date__c;
//    }
//
//
//    /**
//     * Sets the customer_Signed_Date__c value for this Contract_DWC__c.
//     *
//     * @param customer_Signed_Date__c
//     */
//    public void setCustomer_Signed_Date__c(java.util.Date customer_Signed_Date__c) {
//        this.customer_Signed_Date__c = customer_Signed_Date__c;
//    }
//
//
//    /**
//     * Gets the DWC_Signed_By__c value for this Contract_DWC__c.
//     *
//     * @return DWC_Signed_By__c
//     */
//    public String getDWC_Signed_By__c() {
//        return DWC_Signed_By__c;
//    }
//
//
//    /**
//     * Sets the DWC_Signed_By__c value for this Contract_DWC__c.
//     *
//     * @param DWC_Signed_By__c
//     */
//    public void setDWC_Signed_By__c(String DWC_Signed_By__c) {
//        this.DWC_Signed_By__c = DWC_Signed_By__c;
//    }
//
//
//    /**
//     * Gets the DWC_Signed_Date__c value for this Contract_DWC__c.
//     *
//     * @return DWC_Signed_Date__c
//     */
//    public java.util.Date getDWC_Signed_Date__c() {
//        return DWC_Signed_Date__c;
//    }
//
//
//    /**
//     * Sets the DWC_Signed_Date__c value for this Contract_DWC__c.
//     *
//     * @param DWC_Signed_Date__c
//     */
//    public void setDWC_Signed_Date__c(java.util.Date DWC_Signed_Date__c) {
//        this.DWC_Signed_Date__c = DWC_Signed_Date__c;
//    }
//
//
//    /**
//     * Gets the date_Contract_Signed_by_Customer__c value for this Contract_DWC__c.
//     *
//     * @return date_Contract_Signed_by_Customer__c
//     */
//    public java.util.Date getDate_Contract_Signed_by_Customer__c() {
//        return date_Contract_Signed_by_Customer__c;
//    }
//
//
//    /**
//     * Sets the date_Contract_Signed_by_Customer__c value for this Contract_DWC__c.
//     *
//     * @param date_Contract_Signed_by_Customer__c
//     */
//    public void setDate_Contract_Signed_by_Customer__c(java.util.Date date_Contract_Signed_by_Customer__c) {
//        this.date_Contract_Signed_by_Customer__c = date_Contract_Signed_by_Customer__c;
//    }
//
//
//    /**
//     * Gets the description__c value for this Contract_DWC__c.
//     *
//     * @return description__c
//     */
//    public String getDescription__c() {
//        return description__c;
//    }
//
//
//    /**
//     * Sets the description__c value for this Contract_DWC__c.
//     *
//     * @param description__c
//     */
//    public void setDescription__c(String description__c) {
//        this.description__c = description__c;
//    }
//
//
//    /**
//     * Gets the dif__c value for this Contract_DWC__c.
//     *
//     * @return dif__c
//     */
//    public Double getDif__c() {
//        return dif__c;
//    }
//
//
//    /**
//     * Sets the dif__c value for this Contract_DWC__c.
//     *
//     * @param dif__c
//     */
//    public void setDif__c(Double dif__c) {
//        this.dif__c = dif__c;
//    }
//
//
//    /**
//     * Gets the discount__c value for this Contract_DWC__c.
//     *
//     * @return discount__c
//     */
//    public Double getDiscount__c() {
//        return discount__c;
//    }
//
//
//    /**
//     * Sets the discount__c value for this Contract_DWC__c.
//     *
//     * @param discount__c
//     */
//    public void setDiscount__c(Double discount__c) {
//        this.discount__c = discount__c;
//    }
//
//
//    /**
//     * Gets the electrical_Infrastructure_Fee__c value for this Contract_DWC__c.
//     *
//     * @return electrical_Infrastructure_Fee__c
//     */
//    public String getElectrical_Infrastructure_Fee__c() {
//        return electrical_Infrastructure_Fee__c;
//    }
//
//
//    /**
//     * Sets the electrical_Infrastructure_Fee__c value for this Contract_DWC__c.
//     *
//     * @param electrical_Infrastructure_Fee__c
//     */
//    public void setElectrical_Infrastructure_Fee__c(String electrical_Infrastructure_Fee__c) {
//        this.electrical_Infrastructure_Fee__c = electrical_Infrastructure_Fee__c;
//    }
//
//
//    /**
//     * Gets the eligable_for_UAE_Citizen_Discount_Flag__c value for this Contract_DWC__c.
//     *
//     * @return eligable_for_UAE_Citizen_Discount_Flag__c
//     */
//    public String getEligable_for_UAE_Citizen_Discount_Flag__c() {
//        return eligable_for_UAE_Citizen_Discount_Flag__c;
//    }
//
//
//    /**
//     * Sets the eligable_for_UAE_Citizen_Discount_Flag__c value for this Contract_DWC__c.
//     *
//     * @param eligable_for_UAE_Citizen_Discount_Flag__c
//     */
//    public void setEligable_for_UAE_Citizen_Discount_Flag__c(String eligable_for_UAE_Citizen_Discount_Flag__c) {
//        this.eligable_for_UAE_Citizen_Discount_Flag__c = eligable_for_UAE_Citizen_Discount_Flag__c;
//    }
//
//
//    /**
//     * Gets the eligible_for_Penalty__c value for this Contract_DWC__c.
//     *
//     * @return eligible_for_Penalty__c
//     */
//    public String getEligible_for_Penalty__c() {
//        return eligible_for_Penalty__c;
//    }
//
//
//    /**
//     * Sets the eligible_for_Penalty__c value for this Contract_DWC__c.
//     *
//     * @param eligible_for_Penalty__c
//     */
//    public void setEligible_for_Penalty__c(String eligible_for_Penalty__c) {
//        this.eligible_for_Penalty__c = eligible_for_Penalty__c;
//    }
//
//
//    /**
//     * Gets the email__c value for this Contract_DWC__c.
//     *
//     * @return email__c
//     */
//    public String getEmail__c() {
//        return email__c;
//    }
//
//
//    /**
//     * Sets the email__c value for this Contract_DWC__c.
//     *
//     * @param email__c
//     */
//    public void setEmail__c(String email__c) {
//        this.email__c = email__c;
//    }
//
//
//    /**
//     * Gets the events value for this Contract_DWC__c.
//     *
//     * @return events
//     */
//    public QueryResult getEvents() {
//        return events;
//    }
//
//
//    /**
//     * Sets the events value for this Contract_DWC__c.
//     *
//     * @param events
//     */
//    public void setEvents(QueryResult events) {
//        this.events = events;
//    }
//
//
//    /**
//     * Gets the fax__c value for this Contract_DWC__c.
//     *
//     * @return fax__c
//     */
//    public String getFax__c() {
//        return fax__c;
//    }
//
//
//    /**
//     * Sets the fax__c value for this Contract_DWC__c.
//     *
//     * @param fax__c
//     */
//    public void setFax__c(String fax__c) {
//        this.fax__c = fax__c;
//    }
//
//
//    /**
//     * Gets the feedSubscriptionsForEntity value for this Contract_DWC__c.
//     *
//     * @return feedSubscriptionsForEntity
//     */
//    public QueryResult getFeedSubscriptionsForEntity() {
//        return feedSubscriptionsForEntity;
//    }
//
//
//    /**
//     * Sets the feedSubscriptionsForEntity value for this Contract_DWC__c.
//     *
//     * @param feedSubscriptionsForEntity
//     */
//    public void setFeedSubscriptionsForEntity(QueryResult feedSubscriptionsForEntity) {
//        this.feedSubscriptionsForEntity = feedSubscriptionsForEntity;
//    }
//
//
//    /**
//     * Gets the feeds value for this Contract_DWC__c.
//     *
//     * @return feeds
//     */
//    public QueryResult getFeeds() {
//        return feeds;
//    }
//
//
//    /**
//     * Sets the feeds value for this Contract_DWC__c.
//     *
//     * @param feeds
//     */
//    public void setFeeds(QueryResult feeds) {
//        this.feeds = feeds;
//    }
//
//    /**
//     * Gets the first_Line_Item_Unit_Area__c value for this Contract_DWC__c.
//     *
//     * @return first_Line_Item_Unit_Area__c
//     */
//    public Double getFirst_Line_Item_Unit_Area__c() {
//        return first_Line_Item_Unit_Area__c;
//    }
//
//
//    /**
//     * Sets the first_Line_Item_Unit_Area__c value for this Contract_DWC__c.
//     *
//     * @param first_Line_Item_Unit_Area__c
//     */
//    public void setFirst_Line_Item_Unit_Area__c(Double first_Line_Item_Unit_Area__c) {
//        this.first_Line_Item_Unit_Area__c = first_Line_Item_Unit_Area__c;
//    }
//
//
//    /**
//     * Gets the first_Line_Item_Unit_Name__c value for this Contract_DWC__c.
//     *
//     * @return first_Line_Item_Unit_Name__c
//     */
//    public String getFirst_Line_Item_Unit_Name__c() {
//        return first_Line_Item_Unit_Name__c;
//    }
//
//
//    /**
//     * Sets the first_Line_Item_Unit_Name__c value for this Contract_DWC__c.
//     *
//     * @param first_Line_Item_Unit_Name__c
//     */
//    public void setFirst_Line_Item_Unit_Name__c(String first_Line_Item_Unit_Name__c) {
//        this.first_Line_Item_Unit_Name__c = first_Line_Item_Unit_Name__c;
//    }
//
//
//    /**
//     * Gets the first_Line_Item_Unit_Price__c value for this Contract_DWC__c.
//     *
//     * @return first_Line_Item_Unit_Price__c
//     */
//    public Double getFirst_Line_Item_Unit_Price__c() {
//        return first_Line_Item_Unit_Price__c;
//    }
//
//
//    /**
//     * Sets the first_Line_Item_Unit_Price__c value for this Contract_DWC__c.
//     *
//     * @param first_Line_Item_Unit_Price__c
//     */
//    public void setFirst_Line_Item_Unit_Price__c(Double first_Line_Item_Unit_Price__c) {
//        this.first_Line_Item_Unit_Price__c = first_Line_Item_Unit_Price__c;
//    }
//
//
//    /**
//     * Gets the fit_out_Status__c value for this Contract_DWC__c.
//     *
//     * @return fit_out_Status__c
//     */
//    public String getFit_out_Status__c() {
//        return fit_out_Status__c;
//    }
//
//
//    /**
//     * Sets the fit_out_Status__c value for this Contract_DWC__c.
//     *
//     * @param fit_out_Status__c
//     */
//    public void setFit_out_Status__c(String fit_out_Status__c) {
//        this.fit_out_Status__c = fit_out_Status__c;
//    }
//
//
//    /**
//     * Gets the grand_Total__c value for this Contract_DWC__c.
//     *
//     * @return grand_Total__c
//     */
//    public Double getGrand_Total__c() {
//        return grand_Total__c;
//    }
//
//
//    /**
//     * Sets the grand_Total__c value for this Contract_DWC__c.
//     *
//     * @param grand_Total__c
//     */
//    public void setGrand_Total__c(Double grand_Total__c) {
//        this.grand_Total__c = grand_Total__c;
//    }
//
//
//    /**
//     * Gets the histories value for this Contract_DWC__c.
//     *
//     * @return histories
//     */
//    public QueryResult getHistories() {
//        return histories;
//    }
//
//
//    /**
//     * Sets the histories value for this Contract_DWC__c.
//     *
//     * @param histories
//     */
//    public void setHistories(QueryResult histories) {
//        this.histories = histories;
//    }
//
//
//    /**
//     * Gets the history__c value for this Contract_DWC__c.
//     *
//     * @return history__c
//     */
//    public String getHistory__c() {
//        return history__c;
//    }
//
//
//    /**
//     * Sets the history__c value for this Contract_DWC__c.
//     *
//     * @param history__c
//     */
//    public void setHistory__c(String history__c) {
//        this.history__c = history__c;
//    }
//
//
//    /**
//     * Gets the inspection_Date__c value for this Contract_DWC__c.
//     *
//     * @return inspection_Date__c
//     */
//    public java.util.Date getInspection_Date__c() {
//        return inspection_Date__c;
//    }
//
//
//    /**
//     * Sets the inspection_Date__c value for this Contract_DWC__c.
//     *
//     * @param inspection_Date__c
//     */
//    public void setInspection_Date__c(java.util.Date inspection_Date__c) {
//        this.inspection_Date__c = inspection_Date__c;
//    }
//
//
//    /**
//     * Gets the inspection_Remarks__c value for this Contract_DWC__c.
//     *
//     * @return inspection_Remarks__c
//     */
//    public String getInspection_Remarks__c() {
//        return inspection_Remarks__c;
//    }
//
//
//    /**
//     * Sets the inspection_Remarks__c value for this Contract_DWC__c.
//     *
//     * @param inspection_Remarks__c
//     */
//    public void setInspection_Remarks__c(String inspection_Remarks__c) {
//        this.inspection_Remarks__c = inspection_Remarks__c;
//    }
//
//
//    /**
//     * Gets the inventory_Unit__c value for this Contract_DWC__c.
//     *
//     * @return inventory_Unit__c
//     */
//    public String getInventory_Unit__c() {
//        return inventory_Unit__c;
//    }
//
//
//    /**
//     * Sets the inventory_Unit__c value for this Contract_DWC__c.
//     *
//     * @param inventory_Unit__c
//     */
//    public void setInventory_Unit__c(String inventory_Unit__c) {
//        this.inventory_Unit__c = inventory_Unit__c;
//    }
//
//    /**
//     * Gets the lastActivityDate value for this Contract_DWC__c.
//     *
//     * @return lastActivityDate
//     */
//    public java.util.Date getLastActivityDate() {
//        return lastActivityDate;
//    }
//
//
//    /**
//     * Sets the lastActivityDate value for this Contract_DWC__c.
//     *
//     * @param lastActivityDate
//     */
//    public void setLastActivityDate(java.util.Date lastActivityDate) {
//        this.lastActivityDate = lastActivityDate;
//    }
//
//
//    /**
//     * Gets the lastModifiedBy value for this Contract_DWC__c.
//     *
//     * @return lastModifiedBy
//     */
//    public User getLastModifiedBy() {
//        return lastModifiedBy;
//    }
//
//
//    /**
//     * Sets the lastModifiedBy value for this Contract_DWC__c.
//     *
//     * @param lastModifiedBy
//     */
//    public void setLastModifiedBy(User lastModifiedBy) {
//        this.lastModifiedBy = lastModifiedBy;
//    }
//
//
//    /**
//     * Gets the lastModifiedById value for this Contract_DWC__c.
//     *
//     * @return lastModifiedById
//     */
//    public String getLastModifiedById() {
//        return lastModifiedById;
//    }
//
//
//    /**
//     * Sets the lastModifiedById value for this Contract_DWC__c.
//     *
//     * @param lastModifiedById
//     */
//    public void setLastModifiedById(String lastModifiedById) {
//        this.lastModifiedById = lastModifiedById;
//    }
//
//
//    /**
//     * Gets the lastModifiedDate value for this Contract_DWC__c.
//     *
//     * @return lastModifiedDate
//     */
//    public java.util.Calendar getLastModifiedDate() {
//        return lastModifiedDate;
//    }
//
//
//    /**
//     * Sets the lastModifiedDate value for this Contract_DWC__c.
//     *
//     * @param lastModifiedDate
//     */
//    public void setLastModifiedDate(java.util.Calendar lastModifiedDate) {
//        this.lastModifiedDate = lastModifiedDate;
//    }
//
//
//    /**
//     * Gets the lastReferencedDate value for this Contract_DWC__c.
//     *
//     * @return lastReferencedDate
//     */
//    public java.util.Calendar getLastReferencedDate() {
//        return lastReferencedDate;
//    }
//
//
//    /**
//     * Sets the lastReferencedDate value for this Contract_DWC__c.
//     *
//     * @param lastReferencedDate
//     */
//    public void setLastReferencedDate(java.util.Calendar lastReferencedDate) {
//        this.lastReferencedDate = lastReferencedDate;
//    }
//
//
//    /**
//     * Gets the lastViewedDate value for this Contract_DWC__c.
//     *
//     * @return lastViewedDate
//     */
//    public java.util.Calendar getLastViewedDate() {
//        return lastViewedDate;
//    }
//
//
//    /**
//     * Sets the lastViewedDate value for this Contract_DWC__c.
//     *
//     * @param lastViewedDate
//     */
//    public void setLastViewedDate(java.util.Calendar lastViewedDate) {
//        this.lastViewedDate = lastViewedDate;
//    }
//
//
//    /**
//     * Gets the license_Number__c value for this Contract_DWC__c.
//     *
//     * @return license_Number__c
//     */
//    public String getLicense_Number__c() {
//        return license_Number__c;
//    }
//
//
//    /**
//     * Sets the license_Number__c value for this Contract_DWC__c.
//     *
//     * @param license_Number__c
//     */
//    public void setLicense_Number__c(String license_Number__c) {
//        this.license_Number__c = license_Number__c;
//    }
//
//
//    /**
//     * Gets the license_and_Establishment_Card_Fee__c value for this Contract_DWC__c.
//     *
//     * @return license_and_Establishment_Card_Fee__c
//     */
//    public Double getLicense_and_Establishment_Card_Fee__c() {
//        return license_and_Establishment_Card_Fee__c;
//    }
//
//
//    /**
//     * Sets the license_and_Establishment_Card_Fee__c value for this Contract_DWC__c.
//     *
//     * @param license_and_Establishment_Card_Fee__c
//     */
//    public void setLicense_and_Establishment_Card_Fee__c(Double license_and_Establishment_Card_Fee__c) {
//        this.license_and_Establishment_Card_Fee__c = license_and_Establishment_Card_Fee__c;
//    }
//
//
//    /**
//     * Gets the line_Item_Number__c value for this Contract_DWC__c.
//     *
//     * @return line_Item_Number__c
//     */
//    public Double getLine_Item_Number__c() {
//        return line_Item_Number__c;
//    }
//
//
//    /**
//     * Sets the line_Item_Number__c value for this Contract_DWC__c.
//     *
//     * @param line_Item_Number__c
//     */
//    public void setLine_Item_Number__c(Double line_Item_Number__c) {
//        this.line_Item_Number__c = line_Item_Number__c;
//    }
//
//
//    /**
//     * Gets the lookedUpFromActivities value for this Contract_DWC__c.
//     *
//     * @return lookedUpFromActivities
//     */
//    public QueryResult getLookedUpFromActivities() {
//        return lookedUpFromActivities;
//    }
//
//
//    /**
//     * Sets the lookedUpFromActivities value for this Contract_DWC__c.
//     *
//     * @param lookedUpFromActivities
//     */
//    public void setLookedUpFromActivities(QueryResult lookedUpFromActivities) {
//        this.lookedUpFromActivities = lookedUpFromActivities;
//    }
//
//
//    /**
//     * Gets the name value for this Contract_DWC__c.
//     *
//     * @return name
//     */
//    public String getName() {
//        return name;
//    }
//
//
//    /**
//     * Sets the name value for this Contract_DWC__c.
//     *
//     * @param name
//     */
//    public void setName(String name) {
//        this.name = name;
//    }
//
//
//    /**
//     * Gets the no_of_Discounted_Service_Charge_Payments__c value for this Contract_DWC__c.
//     *
//     * @return no_of_Discounted_Service_Charge_Payments__c
//     */
//    public Double getNo_of_Discounted_Service_Charge_Payments__c() {
//        return no_of_Discounted_Service_Charge_Payments__c;
//    }
//
//
//    /**
//     * Sets the no_of_Discounted_Service_Charge_Payments__c value for this Contract_DWC__c.
//     *
//     * @param no_of_Discounted_Service_Charge_Payments__c
//     */
//    public void setNo_of_Discounted_Service_Charge_Payments__c(Double no_of_Discounted_Service_Charge_Payments__c) {
//        this.no_of_Discounted_Service_Charge_Payments__c = no_of_Discounted_Service_Charge_Payments__c;
//    }
//
//    /**
//     * Gets the notes value for this Contract_DWC__c.
//     *
//     * @return notes
//     */
//    public QueryResult getNotes() {
//        return notes;
//    }
//
//
//    /**
//     * Sets the notes value for this Contract_DWC__c.
//     *
//     * @param notes
//     */
//    public void setNotes(QueryResult notes) {
//        this.notes = notes;
//    }
//
//
//    /**
//     * Gets the notesAndAttachments value for this Contract_DWC__c.
//     *
//     * @return notesAndAttachments
//     */
//    public QueryResult getNotesAndAttachments() {
//        return notesAndAttachments;
//    }
//
//
//    /**
//     * Sets the notesAndAttachments value for this Contract_DWC__c.
//     *
//     * @param notesAndAttachments
//     */
//    public void setNotesAndAttachments(QueryResult notesAndAttachments) {
//        this.notesAndAttachments = notesAndAttachments;
//    }
//
//
//    /**
//     * Gets the number_of_Discounted_Rent_Payments__c value for this Contract_DWC__c.
//     *
//     * @return number_of_Discounted_Rent_Payments__c
//     */
//    public Double getNumber_of_Discounted_Rent_Payments__c() {
//        return number_of_Discounted_Rent_Payments__c;
//    }
//
//
//    /**
//     * Sets the number_of_Discounted_Rent_Payments__c value for this Contract_DWC__c.
//     *
//     * @param number_of_Discounted_Rent_Payments__c
//     */
//    public void setNumber_of_Discounted_Rent_Payments__c(Double number_of_Discounted_Rent_Payments__c) {
//        this.number_of_Discounted_Rent_Payments__c = number_of_Discounted_Rent_Payments__c;
//    }
//
//
//    /**
//     * Gets the number_of_Installment__c value for this Contract_DWC__c.
//     *
//     * @return number_of_Installment__c
//     */
//    public Double getNumber_of_Installment__c() {
//        return number_of_Installment__c;
//    }
//
//
//    /**
//     * Sets the number_of_Installment__c value for this Contract_DWC__c.
//     *
//     * @param number_of_Installment__c
//     */
//    public void setNumber_of_Installment__c(Double number_of_Installment__c) {
//        this.number_of_Installment__c = number_of_Installment__c;
//    }
//
//
//    /**
//     * Gets the number_of_Installments__c value for this Contract_DWC__c.
//     *
//     * @return number_of_Installments__c
//     */
//    public Double getNumber_of_Installments__c() {
//        return number_of_Installments__c;
//    }
//
//
//    /**
//     * Sets the number_of_Installments__c value for this Contract_DWC__c.
//     *
//     * @param number_of_Installments__c
//     */
//    public void setNumber_of_Installments__c(Double number_of_Installments__c) {
//        this.number_of_Installments__c = number_of_Installments__c;
//    }
//
//
//    /**
//     * Gets the number_of_Years_for_Service_Charges__c value for this Contract_DWC__c.
//     *
//     * @return number_of_Years_for_Service_Charges__c
//     */
//    public Double getNumber_of_Years_for_Service_Charges__c() {
//        return number_of_Years_for_Service_Charges__c;
//    }
//
//
//    /**
//     * Sets the number_of_Years_for_Service_Charges__c value for this Contract_DWC__c.
//     *
//     * @param number_of_Years_for_Service_Charges__c
//     */
//    public void setNumber_of_Years_for_Service_Charges__c(Double number_of_Years_for_Service_Charges__c) {
//        this.number_of_Years_for_Service_Charges__c = number_of_Years_for_Service_Charges__c;
//    }
//
//
//    /**
//     * Gets the number_of_Years_of_Payments_to_Print__c value for this Contract_DWC__c.
//     *
//     * @return number_of_Years_of_Payments_to_Print__c
//     */
//    public String getNumber_of_Years_of_Payments_to_Print__c() {
//        return number_of_Years_of_Payments_to_Print__c;
//    }
//
//
//    /**
//     * Sets the number_of_Years_of_Payments_to_Print__c value for this Contract_DWC__c.
//     *
//     * @param number_of_Years_of_Payments_to_Print__c
//     */
//    public void setNumber_of_Years_of_Payments_to_Print__c(String number_of_Years_of_Payments_to_Print__c) {
//        this.number_of_Years_of_Payments_to_Print__c = number_of_Years_of_Payments_to_Print__c;
//    }
//
//
//    /**
//     * Gets the office_Area__c value for this Contract_DWC__c.
//     *
//     * @return office_Area__c
//     */
//    public Double getOffice_Area__c() {
//        return office_Area__c;
//    }
//
//
//    /**
//     * Sets the office_Area__c value for this Contract_DWC__c.
//     *
//     * @param office_Area__c
//     */
//    public void setOffice_Area__c(Double office_Area__c) {
//        this.office_Area__c = office_Area__c;
//    }
//
//
//    /**
//     * Gets the office_Rent__c value for this Contract_DWC__c.
//     *
//     * @return office_Rent__c
//     */
//    public Double getOffice_Rent__c() {
//        return office_Rent__c;
//    }
//
//
//    /**
//     * Sets the office_Rent__c value for this Contract_DWC__c.
//     *
//     * @param office_Rent__c
//     */
//    public void setOffice_Rent__c(Double office_Rent__c) {
//        this.office_Rent__c = office_Rent__c;
//    }
//
//
//    /**
//     * Gets the office_number__c value for this Contract_DWC__c.
//     *
//     * @return office_number__c
//     */
//    public String getOffice_number__c() {
//        return office_number__c;
//    }
//
//
//    /**
//     * Sets the office_number__c value for this Contract_DWC__c.
//     *
//     * @param office_number__c
//     */
//    public void setOffice_number__c(String office_number__c) {
//        this.office_number__c = office_number__c;
//    }
//
//
//    /**
//     * Gets the openActivities value for this Contract_DWC__c.
//     *
//     * @return openActivities
//     */
//    public QueryResult getOpenActivities() {
//        return openActivities;
//    }
//
//
//    /**
//     * Sets the openActivities value for this Contract_DWC__c.
//     *
//     * @param openActivities
//     */
//    public void setOpenActivities(QueryResult openActivities) {
//        this.openActivities = openActivities;
//    }
//
//
//    /**
//     * Gets the owner_Expiration_Notice_days__c value for this Contract_DWC__c.
//     *
//     * @return owner_Expiration_Notice_days__c
//     */
//    public Double getOwner_Expiration_Notice_days__c() {
//        return owner_Expiration_Notice_days__c;
//    }
//
//
//    /**
//     * Sets the owner_Expiration_Notice_days__c value for this Contract_DWC__c.
//     *
//     * @param owner_Expiration_Notice_days__c
//     */
//    public void setOwner_Expiration_Notice_days__c(Double owner_Expiration_Notice_days__c) {
//        this.owner_Expiration_Notice_days__c = owner_Expiration_Notice_days__c;
//    }
//
//
//    /**
//     * Gets the phone__c value for this Contract_DWC__c.
//     *
//     * @return phone__c
//     */
//    public String getPhone__c() {
//        return phone__c;
//    }
//
//
//    /**
//     * Sets the phone__c value for this Contract_DWC__c.
//     *
//     * @param phone__c
//     */
//    public void setPhone__c(String phone__c) {
//        this.phone__c = phone__c;
//    }
//
//
//    /**
//     * Gets the plot_Rent__c value for this Contract_DWC__c.
//     *
//     * @return plot_Rent__c
//     */
//    public Double getPlot_Rent__c() {
//        return plot_Rent__c;
//    }
//
//
//    /**
//     * Sets the plot_Rent__c value for this Contract_DWC__c.
//     *
//     * @param plot_Rent__c
//     */
//    public void setPlot_Rent__c(Double plot_Rent__c) {
//        this.plot_Rent__c = plot_Rent__c;
//    }
//
//
//    /**
//     * Gets the power_Allocation__c value for this Contract_DWC__c.
//     *
//     * @return power_Allocation__c
//     */
//    public Double getPower_Allocation__c() {
//        return power_Allocation__c;
//    }
//
//
//    /**
//     * Sets the power_Allocation__c value for this Contract_DWC__c.
//     *
//     * @param power_Allocation__c
//     */
//    public void setPower_Allocation__c(Double power_Allocation__c) {
//        this.power_Allocation__c = power_Allocation__c;
//    }
//
//
//    /**
//     * Gets the primary_Contact_Name__c value for this Contract_DWC__c.
//     *
//     * @return primary_Contact_Name__c
//     */
//    public String getPrimary_Contact_Name__c() {
//        return primary_Contact_Name__c;
//    }
//
//
//    /**
//     * Sets the primary_Contact_Name__c value for this Contract_DWC__c.
//     *
//     * @param primary_Contact_Name__c
//     */
//    public void setPrimary_Contact_Name__c(String primary_Contact_Name__c) {
//        this.primary_Contact_Name__c = primary_Contact_Name__c;
//    }
//
//
//    /**
//     * Gets the processInstances value for this Contract_DWC__c.
//     *
//     * @return processInstances
//     */
//    public QueryResult getProcessInstances() {
//        return processInstances;
//    }
//
//
//    /**
//     * Sets the processInstances value for this Contract_DWC__c.
//     *
//     * @param processInstances
//     */
//    public void setProcessInstances(QueryResult processInstances) {
//        this.processInstances = processInstances;
//    }
//
//
//    /**
//     * Gets the processSteps value for this Contract_DWC__c.
//     *
//     * @return processSteps
//     */
//    public QueryResult getProcessSteps() {
//        return processSteps;
//    }
//
//
//    /**
//     * Sets the processSteps value for this Contract_DWC__c.
//     *
//     * @param processSteps
//     */
//    public void setProcessSteps(QueryResult processSteps) {
//        this.processSteps = processSteps;
//    }
//
//
//    /**
//     * Gets the quantity__c value for this Contract_DWC__c.
//     *
//     * @return quantity__c
//     */
//    public Double getQuantity__c() {
//        return quantity__c;
//    }
//
//
//    /**
//     * Sets the quantity__c value for this Contract_DWC__c.
//     *
//     * @param quantity__c
//     */
//    public void setQuantity__c(Double quantity__c) {
//        this.quantity__c = quantity__c;
//    }
//
//
//    /**
//     * Gets the quote__c value for this Contract_DWC__c.
//     *
//     * @return quote__c
//     */
//    public String getQuote__c() {
//        return quote__c;
//    }
//
//
//    /**
//     * Sets the quote__c value for this Contract_DWC__c.
//     *
//     * @param quote__c
//     */
//    public void setQuote__c(String quote__c) {
//        this.quote__c = quote__c;
//    }
//
//
//    /**
//     * Gets the quote__r value for this Contract_DWC__c.
//     *
//     * @return quote__r
//     */
//    public Quote getQuote__r() {
//        return quote__r;
//    }
//
//
//    /**
//     * Sets the quote__r value for this Contract_DWC__c.
//     *
//     * @param quote__r
//     */
//    public void setQuote__r(Quote quote__r) {
//        this.quote__r = quote__r;
//    }
//
//
//    /**
//     * Gets the recordAssociatedGroups value for this Contract_DWC__c.
//     *
//     * @return recordAssociatedGroups
//     */
//    public QueryResult getRecordAssociatedGroups() {
//        return recordAssociatedGroups;
//    }
//
//
//    /**
//     * Sets the recordAssociatedGroups value for this Contract_DWC__c.
//     *
//     * @param recordAssociatedGroups
//     */
//    public void setRecordAssociatedGroups(QueryResult recordAssociatedGroups) {
//        this.recordAssociatedGroups = recordAssociatedGroups;
//    }
//
//
//    /**
//     * Gets the recordType value for this Contract_DWC__c.
//     *
//     * @return recordType
//     */
//    public RecordType getRecordType() {
//        return recordType;
//    }
//
//
//    /**
//     * Sets the recordType value for this Contract_DWC__c.
//     *
//     * @param recordType
//     */
//    public void setRecordType(RecordType recordType) {
//        this.recordType = recordType;
//    }
//
//
//    /**
//     * Gets the recordTypeId value for this Contract_DWC__c.
//     *
//     * @return recordTypeId
//     */
//    public String getRecordTypeId() {
//        return recordTypeId;
//    }
//
//
//    /**
//     * Sets the recordTypeId value for this Contract_DWC__c.
//     *
//     * @param recordTypeId
//     */
//    public void setRecordTypeId(String recordTypeId) {
//        this.recordTypeId = recordTypeId;
//    }
//
//
//    /**
//     * Gets the record_Type_Name__c value for this Contract_DWC__c.
//     *
//     * @return record_Type_Name__c
//     */
//    public String getRecord_Type_Name__c() {
//        return record_Type_Name__c;
//    }
//
//
//    /**
//     * Sets the record_Type_Name__c value for this Contract_DWC__c.
//     *
//     * @param record_Type_Name__c
//     */
//    public void setRecord_Type_Name__c(String record_Type_Name__c) {
//        this.record_Type_Name__c = record_Type_Name__c;
//    }
//
//
//    /**
//     * Gets the registration_Fee__c value for this Contract_DWC__c.
//     *
//     * @return registration_Fee__c
//     */
//    public Double getRegistration_Fee__c() {
//        return registration_Fee__c;
//    }
//
//
//    /**
//     * Sets the registration_Fee__c value for this Contract_DWC__c.
//     *
//     * @param registration_Fee__c
//     */
//    public void setRegistration_Fee__c(Double registration_Fee__c) {
//        this.registration_Fee__c = registration_Fee__c;
//    }
//
//
//    /**
//     * Gets the renewal_Stage__c value for this Contract_DWC__c.
//     *
//     * @return renewal_Stage__c
//     */
//    public String getRenewal_Stage__c() {
//        return renewal_Stage__c;
//    }
//
//
//    /**
//     * Sets the renewal_Stage__c value for this Contract_DWC__c.
//     *
//     * @param renewal_Stage__c
//     */
//    public void setRenewal_Stage__c(String renewal_Stage__c) {
//        this.renewal_Stage__c = renewal_Stage__c;
//    }
//
//
//    /**
//     * Gets the renewed_Contract__c value for this Contract_DWC__c.
//     *
//     * @return renewed_Contract__c
//     */
//    public String getRenewed_Contract__c() {
//        return renewed_Contract__c;
//    }
//
//
//    /**
//     * Sets the renewed_Contract__c value for this Contract_DWC__c.
//     *
//     * @param renewed_Contract__c
//     */
//    public void setRenewed_Contract__c(String renewed_Contract__c) {
//        this.renewed_Contract__c = renewed_Contract__c;
//    }
//
//    /**
//     * Gets the renewed_Finance_Approval_Status__c value for this Contract_DWC__c.
//     *
//     * @return renewed_Finance_Approval_Status__c
//     */
//    public String getRenewed_Finance_Approval_Status__c() {
//        return renewed_Finance_Approval_Status__c;
//    }
//
//
//    /**
//     * Sets the renewed_Finance_Approval_Status__c value for this Contract_DWC__c.
//     *
//     * @param renewed_Finance_Approval_Status__c
//     */
//    public void setRenewed_Finance_Approval_Status__c(String renewed_Finance_Approval_Status__c) {
//        this.renewed_Finance_Approval_Status__c = renewed_Finance_Approval_Status__c;
//    }
//
//
//    /**
//     * Gets the renewed_Inventory_Approval_Status__c value for this Contract_DWC__c.
//     *
//     * @return renewed_Inventory_Approval_Status__c
//     */
//    public String getRenewed_Inventory_Approval_Status__c() {
//        return renewed_Inventory_Approval_Status__c;
//    }
//
//
//    /**
//     * Sets the renewed_Inventory_Approval_Status__c value for this Contract_DWC__c.
//     *
//     * @param renewed_Inventory_Approval_Status__c
//     */
//    public void setRenewed_Inventory_Approval_Status__c(String renewed_Inventory_Approval_Status__c) {
//        this.renewed_Inventory_Approval_Status__c = renewed_Inventory_Approval_Status__c;
//    }
//
//
//    /**
//     * Gets the renewed_License_Approval_Status__c value for this Contract_DWC__c.
//     *
//     * @return renewed_License_Approval_Status__c
//     */
//    public String getRenewed_License_Approval_Status__c() {
//        return renewed_License_Approval_Status__c;
//    }
//
//
//    /**
//     * Sets the renewed_License_Approval_Status__c value for this Contract_DWC__c.
//     *
//     * @param renewed_License_Approval_Status__c
//     */
//    public void setRenewed_License_Approval_Status__c(String renewed_License_Approval_Status__c) {
//        this.renewed_License_Approval_Status__c = renewed_License_Approval_Status__c;
//    }
//
//
//    /**
//     * Gets the renewed_Tenancy_Contract__c value for this Contract_DWC__c.
//     *
//     * @return renewed_Tenancy_Contract__c
//     */
//    public String getRenewed_Tenancy_Contract__c() {
//        return renewed_Tenancy_Contract__c;
//    }
//
//
//    /**
//     * Sets the renewed_Tenancy_Contract__c value for this Contract_DWC__c.
//     *
//     * @param renewed_Tenancy_Contract__c
//     */
//    public void setRenewed_Tenancy_Contract__c(String renewed_Tenancy_Contract__c) {
//        this.renewed_Tenancy_Contract__c = renewed_Tenancy_Contract__c;
//    }
//
//
//    /**
//     * Gets the rent_Adjustment_Arabic_Formula__c value for this Contract_DWC__c.
//     *
//     * @return rent_Adjustment_Arabic_Formula__c
//     */
//    public String getRent_Adjustment_Arabic_Formula__c() {
//        return rent_Adjustment_Arabic_Formula__c;
//    }
//
//
//    /**
//     * Sets the rent_Adjustment_Arabic_Formula__c value for this Contract_DWC__c.
//     *
//     * @param rent_Adjustment_Arabic_Formula__c
//     */
//    public void setRent_Adjustment_Arabic_Formula__c(String rent_Adjustment_Arabic_Formula__c) {
//        this.rent_Adjustment_Arabic_Formula__c = rent_Adjustment_Arabic_Formula__c;
//    }
//
//
//    /**
//     * Gets the rent_Adjustment__c value for this Contract_DWC__c.
//     *
//     * @return rent_Adjustment__c
//     */
//    public String getRent_Adjustment__c() {
//        return rent_Adjustment__c;
//    }
//
//
//    /**
//     * Sets the rent_Adjustment__c value for this Contract_DWC__c.
//     *
//     * @param rent_Adjustment__c
//     */
//    public void setRent_Adjustment__c(String rent_Adjustment__c) {
//        this.rent_Adjustment__c = rent_Adjustment__c;
//    }
//
//
//    /**
//     * Gets the rent_Free_Period_Days__c value for this Contract_DWC__c.
//     *
//     * @return rent_Free_Period_Days__c
//     */
//    public Double getRent_Free_Period_Days__c() {
//        return rent_Free_Period_Days__c;
//    }
//
//
//    /**
//     * Sets the rent_Free_Period_Days__c value for this Contract_DWC__c.
//     *
//     * @param rent_Free_Period_Days__c
//     */
//    public void setRent_Free_Period_Days__c(Double rent_Free_Period_Days__c) {
//        this.rent_Free_Period_Days__c = rent_Free_Period_Days__c;
//    }
//
//
//    /**
//     * Gets the rent_Initial_Discount_Duration_Years__c value for this Contract_DWC__c.
//     *
//     * @return rent_Initial_Discount_Duration_Years__c
//     */
//    public Double getRent_Initial_Discount_Duration_Years__c() {
//        return rent_Initial_Discount_Duration_Years__c;
//    }
//
//
//    /**
//     * Sets the rent_Initial_Discount_Duration_Years__c value for this Contract_DWC__c.
//     *
//     * @param rent_Initial_Discount_Duration_Years__c
//     */
//    public void setRent_Initial_Discount_Duration_Years__c(Double rent_Initial_Discount_Duration_Years__c) {
//        this.rent_Initial_Discount_Duration_Years__c = rent_Initial_Discount_Duration_Years__c;
//    }
//
//
//    /**
//     * Gets the rent_Initial_Discount__c value for this Contract_DWC__c.
//     *
//     * @return rent_Initial_Discount__c
//     */
//    public Double getRent_Initial_Discount__c() {
//        return rent_Initial_Discount__c;
//    }
//
//
//    /**
//     * Sets the rent_Initial_Discount__c value for this Contract_DWC__c.
//     *
//     * @param rent_Initial_Discount__c
//     */
//    public void setRent_Initial_Discount__c(Double rent_Initial_Discount__c) {
//        this.rent_Initial_Discount__c = rent_Initial_Discount__c;
//    }
//
//
//    /**
//     * Gets the rent_Price__c value for this Contract_DWC__c.
//     *
//     * @return rent_Price__c
//     */
//    public Double getRent_Price__c() {
//        return rent_Price__c;
//    }
//
//
//    /**
//     * Sets the rent_Price__c value for this Contract_DWC__c.
//     *
//     * @param rent_Price__c
//     */
//    public void setRent_Price__c(Double rent_Price__c) {
//        this.rent_Price__c = rent_Price__c;
//    }
//
//
//    /**
//     * Gets the rent_Start_Date__c value for this Contract_DWC__c.
//     *
//     * @return rent_Start_Date__c
//     */
//    public java.util.Date getRent_Start_Date__c() {
//        return rent_Start_Date__c;
//    }
//
//
//    /**
//     * Sets the rent_Start_Date__c value for this Contract_DWC__c.
//     *
//     * @param rent_Start_Date__c
//     */
//    public void setRent_Start_Date__c(java.util.Date rent_Start_Date__c) {
//        this.rent_Start_Date__c = rent_Start_Date__c;
//    }
//
//
//    /**
//     * Gets the SMS_Agent_Mobile__c value for this Contract_DWC__c.
//     *
//     * @return SMS_Agent_Mobile__c
//     */
//    public String getSMS_Agent_Mobile__c() {
//        return SMS_Agent_Mobile__c;
//    }
//
//
//    /**
//     * Sets the SMS_Agent_Mobile__c value for this Contract_DWC__c.
//     *
//     * @param SMS_Agent_Mobile__c
//     */
//    public void setSMS_Agent_Mobile__c(String SMS_Agent_Mobile__c) {
//        this.SMS_Agent_Mobile__c = SMS_Agent_Mobile__c;
//    }
//
//
//    /**
//     * Gets the SMS_Tenant_Mobile__c value for this Contract_DWC__c.
//     *
//     * @return SMS_Tenant_Mobile__c
//     */
//    public String getSMS_Tenant_Mobile__c() {
//        return SMS_Tenant_Mobile__c;
//    }
//
//
//    /**
//     * Sets the SMS_Tenant_Mobile__c value for this Contract_DWC__c.
//     *
//     * @param SMS_Tenant_Mobile__c
//     */
//    public void setSMS_Tenant_Mobile__c(String SMS_Tenant_Mobile__c) {
//        this.SMS_Tenant_Mobile__c = SMS_Tenant_Mobile__c;
//    }
//
//
//    /**
//     * Gets the sales_Price__c value for this Contract_DWC__c.
//     *
//     * @return sales_Price__c
//     */
//    public Double getSales_Price__c() {
//        return sales_Price__c;
//    }
//
//
//    /**
//     * Sets the sales_Price__c value for this Contract_DWC__c.
//     *
//     * @param sales_Price__c
//     */
//    public void setSales_Price__c(Double sales_Price__c) {
//        this.sales_Price__c = sales_Price__c;
//    }
//
//
//    /**
//     * Gets the security_Deposit__c value for this Contract_DWC__c.
//     *
//     * @return security_Deposit__c
//     */
//    public Double getSecurity_Deposit__c() {
//        return security_Deposit__c;
//    }
//
//
//    /**
//     * Sets the security_Deposit__c value for this Contract_DWC__c.
//     *
//     * @param security_Deposit__c
//     */
//    public void setSecurity_Deposit__c(Double security_Deposit__c) {
//        this.security_Deposit__c = security_Deposit__c;
//    }
//
//
//    /**
//     * Gets the service_Charge_Amount__c value for this Contract_DWC__c.
//     *
//     * @return service_Charge_Amount__c
//     */
//    public Double getService_Charge_Amount__c() {
//        return service_Charge_Amount__c;
//    }
//
//
//    /**
//     * Sets the service_Charge_Amount__c value for this Contract_DWC__c.
//     *
//     * @param service_Charge_Amount__c
//     */
//    public void setService_Charge_Amount__c(Double service_Charge_Amount__c) {
//        this.service_Charge_Amount__c = service_Charge_Amount__c;
//    }
//
//
//    /**
//     * Gets the service_Charge_Installments_Per_Year__c value for this Contract_DWC__c.
//     *
//     * @return service_Charge_Installments_Per_Year__c
//     */
//    public Double getService_Charge_Installments_Per_Year__c() {
//        return service_Charge_Installments_Per_Year__c;
//    }
//
//
//    /**
//     * Sets the service_Charge_Installments_Per_Year__c value for this Contract_DWC__c.
//     *
//     * @param service_Charge_Installments_Per_Year__c
//     */
//    public void setService_Charge_Installments_Per_Year__c(Double service_Charge_Installments_Per_Year__c) {
//        this.service_Charge_Installments_Per_Year__c = service_Charge_Installments_Per_Year__c;
//    }
//
//
//    /**
//     * Gets the service_Charges_Discount_Duration_Years__c value for this Contract_DWC__c.
//     *
//     * @return service_Charges_Discount_Duration_Years__c
//     */
//    public Double getService_Charges_Discount_Duration_Years__c() {
//        return service_Charges_Discount_Duration_Years__c;
//    }
//
//
//    /**
//     * Sets the service_Charges_Discount_Duration_Years__c value for this Contract_DWC__c.
//     *
//     * @param service_Charges_Discount_Duration_Years__c
//     */
//    public void setService_Charges_Discount_Duration_Years__c(Double service_Charges_Discount_Duration_Years__c) {
//        this.service_Charges_Discount_Duration_Years__c = service_Charges_Discount_Duration_Years__c;
//    }
//
//
//    /**
//     * Gets the service_Charges_Initial_Discount__c value for this Contract_DWC__c.
//     *
//     * @return service_Charges_Initial_Discount__c
//     */
//    public Double getService_Charges_Initial_Discount__c() {
//        return service_Charges_Initial_Discount__c;
//    }
//
//
//    /**
//     * Sets the service_Charges_Initial_Discount__c value for this Contract_DWC__c.
//     *
//     * @param service_Charges_Initial_Discount__c
//     */
//    public void setService_Charges_Initial_Discount__c(Double service_Charges_Initial_Discount__c) {
//        this.service_Charges_Initial_Discount__c = service_Charges_Initial_Discount__c;
//    }
//
//
//    /**
//     * Gets the service_Charges_Per_Square_Meter__c value for this Contract_DWC__c.
//     *
//     * @return service_Charges_Per_Square_Meter__c
//     */
//    public Double getService_Charges_Per_Square_Meter__c() {
//        return service_Charges_Per_Square_Meter__c;
//    }
//
//
//    /**
//     * Sets the service_Charges_Per_Square_Meter__c value for this Contract_DWC__c.
//     *
//     * @param service_Charges_Per_Square_Meter__c
//     */
//    public void setService_Charges_Per_Square_Meter__c(Double service_Charges_Per_Square_Meter__c) {
//        this.service_Charges_Per_Square_Meter__c = service_Charges_Per_Square_Meter__c;
//    }
//
//
//    /**
//     * Gets the service_Charges_per_sqm__c value for this Contract_DWC__c.
//     *
//     * @return service_Charges_per_sqm__c
//     */
//    public Double getService_Charges_per_sqm__c() {
//        return service_Charges_per_sqm__c;
//    }
//
//
//    /**
//     * Sets the service_Charges_per_sqm__c value for this Contract_DWC__c.
//     *
//     * @param service_Charges_per_sqm__c
//     */
//    public void setService_Charges_per_sqm__c(Double service_Charges_per_sqm__c) {
//        this.service_Charges_per_sqm__c = service_Charges_per_sqm__c;
//    }
//
//    /**
//     * Gets the shippingAddress__c value for this Contract_DWC__c.
//     *
//     * @return shippingAddress__c
//     */
//    public String getShippingAddress__c() {
//        return shippingAddress__c;
//    }
//
//
//    /**
//     * Sets the shippingAddress__c value for this Contract_DWC__c.
//     *
//     * @param shippingAddress__c
//     */
//    public void setShippingAddress__c(String shippingAddress__c) {
//        this.shippingAddress__c = shippingAddress__c;
//    }
//
//
//    /**
//     * Gets the shippingName__c value for this Contract_DWC__c.
//     *
//     * @return shippingName__c
//     */
//    public String getShippingName__c() {
//        return shippingName__c;
//    }
//
//
//    /**
//     * Sets the shippingName__c value for this Contract_DWC__c.
//     *
//     * @param shippingName__c
//     */
//    public void setShippingName__c(String shippingName__c) {
//        this.shippingName__c = shippingName__c;
//    }
//
//
//    /**
//     * Gets the shipping_and_Handling__c value for this Contract_DWC__c.
//     *
//     * @return shipping_and_Handling__c
//     */
//    public Double getShipping_and_Handling__c() {
//        return shipping_and_Handling__c;
//    }
//
//
//    /**
//     * Sets the shipping_and_Handling__c value for this Contract_DWC__c.
//     *
//     * @param shipping_and_Handling__c
//     */
//    public void setShipping_and_Handling__c(Double shipping_and_Handling__c) {
//        this.shipping_and_Handling__c = shipping_and_Handling__c;
//    }
//
//
//    /**
//     * Gets the signed_Contract__c value for this Contract_DWC__c.
//     *
//     * @return signed_Contract__c
//     */
//    public String getSigned_Contract__c() {
//        return signed_Contract__c;
//    }
//
//
//    /**
//     * Sets the signed_Contract__c value for this Contract_DWC__c.
//     *
//     * @param signed_Contract__c
//     */
//    public void setSigned_Contract__c(String signed_Contract__c) {
//        this.signed_Contract__c = signed_Contract__c;
//    }
//
//
//    /**
//     * Gets the special_Conditions_Arabic__c value for this Contract_DWC__c.
//     *
//     * @return special_Conditions_Arabic__c
//     */
//    public String getSpecial_Conditions_Arabic__c() {
//        return special_Conditions_Arabic__c;
//    }
//
//
//    /**
//     * Sets the special_Conditions_Arabic__c value for this Contract_DWC__c.
//     *
//     * @param special_Conditions_Arabic__c
//     */
//    public void setSpecial_Conditions_Arabic__c(String special_Conditions_Arabic__c) {
//        this.special_Conditions_Arabic__c = special_Conditions_Arabic__c;
//    }
//
//
//    /**
//     * Gets the special_Conditions__c value for this Contract_DWC__c.
//     *
//     * @return special_Conditions__c
//     */
//    public String getSpecial_Conditions__c() {
//        return special_Conditions__c;
//    }
//
//
//    /**
//     * Sets the special_Conditions__c value for this Contract_DWC__c.
//     *
//     * @param special_Conditions__c
//     */
//    public void setSpecial_Conditions__c(String special_Conditions__c) {
//        this.special_Conditions__c = special_Conditions__c;
//    }
//
//
//    /**
//     * Gets the status__c value for this Contract_DWC__c.
//     *
//     * @return status__c
//     */
//    public String getStatus__c() {
//        return status__c;
//    }
//
//
//    /**
//     * Sets the status__c value for this Contract_DWC__c.
//     *
//     * @param status__c
//     */
//    public void setStatus__c(String status__c) {
//        this.status__c = status__c;
//    }
//
//
//    /**
//     * Gets the systemModstamp value for this Contract_DWC__c.
//     *
//     * @return systemModstamp
//     */
//    public java.util.Calendar getSystemModstamp() {
//        return systemModstamp;
//    }
//
//
//    /**
//     * Sets the systemModstamp value for this Contract_DWC__c.
//     *
//     * @param systemModstamp
//     */
//    public void setSystemModstamp(java.util.Calendar systemModstamp) {
//        this.systemModstamp = systemModstamp;
//    }
//
//
//    /**
//     * Gets the tasks value for this Contract_DWC__c.
//     *
//     * @return tasks
//     */
//    public QueryResult getTasks() {
//        return tasks;
//    }
//
//
//    /**
//     * Sets the tasks value for this Contract_DWC__c.
//     *
//     * @param tasks
//     */
//    public void setTasks(QueryResult tasks) {
//        this.tasks = tasks;
//    }
//
//
//    /**
//     * Gets the tax__c value for this Contract_DWC__c.
//     *
//     * @return tax__c
//     */
//    public Double getTax__c() {
//        return tax__c;
//    }
//
//
//    /**
//     * Sets the tax__c value for this Contract_DWC__c.
//     *
//     * @param tax__c
//     */
//    public void setTax__c(Double tax__c) {
//        this.tax__c = tax__c;
//    }
//
//
//    /**
//     * Gets the tenancy_Contract_Template__c value for this Contract_DWC__c.
//     *
//     * @return tenancy_Contract_Template__c
//     */
//    public String getTenancy_Contract_Template__c() {
//        return tenancy_Contract_Template__c;
//    }
//
//
//    /**
//     * Sets the tenancy_Contract_Template__c value for this Contract_DWC__c.
//     *
//     * @param tenancy_Contract_Template__c
//     */
//    public void setTenancy_Contract_Template__c(String tenancy_Contract_Template__c) {
//        this.tenancy_Contract_Template__c = tenancy_Contract_Template__c;
//    }
//
//
//    /**
//     * Gets the tenant_Address_Arabic__c value for this Contract_DWC__c.
//     *
//     * @return tenant_Address_Arabic__c
//     */
//    public String getTenant_Address_Arabic__c() {
//        return tenant_Address_Arabic__c;
//    }
//
//
//    /**
//     * Sets the tenant_Address_Arabic__c value for this Contract_DWC__c.
//     *
//     * @param tenant_Address_Arabic__c
//     */
//    public void setTenant_Address_Arabic__c(String tenant_Address_Arabic__c) {
//        this.tenant_Address_Arabic__c = tenant_Address_Arabic__c;
//    }
//
//
//    /**
//     * Gets the tenant_Address__c value for this Contract_DWC__c.
//     *
//     * @return tenant_Address__c
//     */
//    public String getTenant_Address__c() {
//        return tenant_Address__c;
//    }
//
//
//    /**
//     * Sets the tenant_Address__c value for this Contract_DWC__c.
//     *
//     * @param tenant_Address__c
//     */
//    public void setTenant_Address__c(String tenant_Address__c) {
//        this.tenant_Address__c = tenant_Address__c;
//    }
//
//
//    /**
//     * Gets the tenant_Name_Arabic__c value for this Contract_DWC__c.
//     *
//     * @return tenant_Name_Arabic__c
//     */
//    public String getTenant_Name_Arabic__c() {
//        return tenant_Name_Arabic__c;
//    }
//
//
//    /**
//     * Sets the tenant_Name_Arabic__c value for this Contract_DWC__c.
//     *
//     * @param tenant_Name_Arabic__c
//     */
//    public void setTenant_Name_Arabic__c(String tenant_Name_Arabic__c) {
//        this.tenant_Name_Arabic__c = tenant_Name_Arabic__c;
//    }
//
//
//    /**
//     * Gets the tenant_Name__c value for this Contract_DWC__c.
//     *
//     * @return tenant_Name__c
//     */
//    public String getTenant_Name__c() {
//        return tenant_Name__c;
//    }
//
//
//    /**
//     * Sets the tenant_Name__c value for this Contract_DWC__c.
//     *
//     * @param tenant_Name__c
//     */
//    public void setTenant_Name__c(String tenant_Name__c) {
//        this.tenant_Name__c = tenant_Name__c;
//    }
//
//
//    /**
//     * Gets the tenant__c value for this Contract_DWC__c.
//     *
//     * @return tenant__c
//     */
//    public String getTenant__c() {
//        return tenant__c;
//    }
//
//
//    /**
//     * Gets the topicAssignments value for this Contract_DWC__c.
//     *
//     * @return topicAssignments
//     */
//    public QueryResult getTopicAssignments() {
//        return topicAssignments;
//    }
//
//
//    /**
//     * Sets the topicAssignments value for this Contract_DWC__c.
//     *
//     * @param topicAssignments
//     */
//    public void setTopicAssignments(QueryResult topicAssignments) {
//        this.topicAssignments = topicAssignments;
//    }
//
//
//    /**
//     * Gets the total_Contract_Value__c value for this Contract_DWC__c.
//     *
//     * @return total_Contract_Value__c
//     */
//    public Double getTotal_Contract_Value__c() {
//        return total_Contract_Value__c;
//    }
//
//
//    /**
//     * Sets the total_Contract_Value__c value for this Contract_DWC__c.
//     *
//     * @param total_Contract_Value__c
//     */
//    public void setTotal_Contract_Value__c(Double total_Contract_Value__c) {
//        this.total_Contract_Value__c = total_Contract_Value__c;
//    }
//
//
//    /**
//     * Gets the total_Installments__c value for this Contract_DWC__c.
//     *
//     * @return total_Installments__c
//     */
//    public Double getTotal_Installments__c() {
//        return total_Installments__c;
//    }
//
//
//    /**
//     * Sets the total_Installments__c value for this Contract_DWC__c.
//     *
//     * @param total_Installments__c
//     */
//    public void setTotal_Installments__c(Double total_Installments__c) {
//        this.total_Installments__c = total_Installments__c;
//    }
//
//
//    /**
//     * Gets the total_Price__c value for this Contract_DWC__c.
//     *
//     * @return total_Price__c
//     */
//    public Double getTotal_Price__c() {
//        return total_Price__c;
//    }
//
//
//    /**
//     * Sets the total_Price__c value for this Contract_DWC__c.
//     *
//     * @param total_Price__c
//     */
//    public void setTotal_Price__c(Double total_Price__c) {
//        this.total_Price__c = total_Price__c;
//    }
//
//
//    /**
//     * Gets the total_Rent_Price_Formula__c value for this Contract_DWC__c.
//     *
//     * @return total_Rent_Price_Formula__c
//     */
//    public Double getTotal_Rent_Price_Formula__c() {
//        return total_Rent_Price_Formula__c;
//    }
//
//
//    /**
//     * Sets the total_Rent_Price_Formula__c value for this Contract_DWC__c.
//     *
//     * @param total_Rent_Price_Formula__c
//     */
//    public void setTotal_Rent_Price_Formula__c(Double total_Rent_Price_Formula__c) {
//        this.total_Rent_Price_Formula__c = total_Rent_Price_Formula__c;
//    }
//
//
//    /**
//     * Gets the total_Rent_Price__c value for this Contract_DWC__c.
//     *
//     * @return total_Rent_Price__c
//     */
//    public Double getTotal_Rent_Price__c() {
//        return total_Rent_Price__c;
//    }
//
//
//    /**
//     * Sets the total_Rent_Price__c value for this Contract_DWC__c.
//     *
//     * @param total_Rent_Price__c
//     */
//    public void setTotal_Rent_Price__c(Double total_Rent_Price__c) {
//        this.total_Rent_Price__c = total_Rent_Price__c;
//    }
//
//
//    /**
//     * Gets the total_Service_Charge_Installments__c value for this Contract_DWC__c.
//     *
//     * @return total_Service_Charge_Installments__c
//     */
//    public Double getTotal_Service_Charge_Installments__c() {
//        return total_Service_Charge_Installments__c;
//    }
//
//
//    /**
//     * Sets the total_Service_Charge_Installments__c value for this Contract_DWC__c.
//     *
//     * @param total_Service_Charge_Installments__c
//     */
//    public void setTotal_Service_Charge_Installments__c(Double total_Service_Charge_Installments__c) {
//        this.total_Service_Charge_Installments__c = total_Service_Charge_Installments__c;
//    }
//
//
//    /**
//     * Gets the total_Service_Charges__c value for this Contract_DWC__c.
//     *
//     * @return total_Service_Charges__c
//     */
//    public Double getTotal_Service_Charges__c() {
//        return total_Service_Charges__c;
//    }
//
//
//    /**
//     * Sets the total_Service_Charges__c value for this Contract_DWC__c.
//     *
//     * @param total_Service_Charges__c
//     */
//    public void setTotal_Service_Charges__c(Double total_Service_Charges__c) {
//        this.total_Service_Charges__c = total_Service_Charges__c;
//    }
//
//
//    /**
//     * Gets the total_Visas_Granted__c value for this Contract_DWC__c.
//     *
//     * @return total_Visas_Granted__c
//     */
//    public Double getTotal_Visas_Granted__c() {
//        return total_Visas_Granted__c;
//    }
//
//
//    /**
//     * Sets the total_Visas_Granted__c value for this Contract_DWC__c.
//     *
//     * @param total_Visas_Granted__c
//     */
//    public void setTotal_Visas_Granted__c(Double total_Visas_Granted__c) {
//        this.total_Visas_Granted__c = total_Visas_Granted__c;
//    }
//
//
//    /**
//     * Gets the UAE_Citizen_Discount__c value for this Contract_DWC__c.
//     *
//     * @return UAE_Citizen_Discount__c
//     */
//    public Double getUAE_Citizen_Discount__c() {
//        return UAE_Citizen_Discount__c;
//    }
//
//
//    /**
//     * Sets the UAE_Citizen_Discount__c value for this Contract_DWC__c.
//     *
//     * @param UAE_Citizen_Discount__c
//     */
//    public void setUAE_Citizen_Discount__c(Double UAE_Citizen_Discount__c) {
//        this.UAE_Citizen_Discount__c = UAE_Citizen_Discount__c;
//    }
//
//
//    /**
//     * Gets the unit_Handover_Date__c value for this Contract_DWC__c.
//     *
//     * @return unit_Handover_Date__c
//     */
//    public java.util.Date getUnit_Handover_Date__c() {
//        return unit_Handover_Date__c;
//    }
//
//
//    /**
//     * Sets the unit_Handover_Date__c value for this Contract_DWC__c.
//     *
//     * @param unit_Handover_Date__c
//     */
//    public void setUnit_Handover_Date__c(java.util.Date unit_Handover_Date__c) {
//        this.unit_Handover_Date__c = unit_Handover_Date__c;
//    }
//
//
//    /**
//     * Gets the unit_Name__c value for this Contract_DWC__c.
//     *
//     * @return unit_Name__c
//     */
//    public String getUnit_Name__c() {
//        return unit_Name__c;
//    }
//
//
//    /**
//     * Sets the unit_Name__c value for this Contract_DWC__c.
//     *
//     * @param unit_Name__c
//     */
//    public void setUnit_Name__c(String unit_Name__c) {
//        this.unit_Name__c = unit_Name__c;
//    }
//
//
//    /**
//     * Gets the units_Reserved_or_Leased_Until__c value for this Contract_DWC__c.
//     *
//     * @return units_Reserved_or_Leased_Until__c
//     */
//    public java.util.Date getUnits_Reserved_or_Leased_Until__c() {
//        return units_Reserved_or_Leased_Until__c;
//    }
//
//
//    /**
//     * Sets the units_Reserved_or_Leased_Until__c value for this Contract_DWC__c.
//     *
//     * @param units_Reserved_or_Leased_Until__c
//     */
//    public void setUnits_Reserved_or_Leased_Until__c(java.util.Date units_Reserved_or_Leased_Until__c) {
//        this.units_Reserved_or_Leased_Until__c = units_Reserved_or_Leased_Until__c;
//    }
//
//
//    /**
//     * Gets the warehouse_Area__c value for this Contract_DWC__c.
//     *
//     * @return warehouse_Area__c
//     */
//    public Double getWarehouse_Area__c() {
//        return warehouse_Area__c;
//    }
//
//
//    /**
//     * Sets the warehouse_Area__c value for this Contract_DWC__c.
//     *
//     * @param warehouse_Area__c
//     */
//    public void setWarehouse_Area__c(Double warehouse_Area__c) {
//        this.warehouse_Area__c = warehouse_Area__c;
//    }
//
//
//    /**
//     * Gets the warehouse_Rent__c value for this Contract_DWC__c.
//     *
//     * @return warehouse_Rent__c
//     */
//    public Double getWarehouse_Rent__c() {
//        return warehouse_Rent__c;
//    }
//
//
//    /**
//     * Sets the warehouse_Rent__c value for this Contract_DWC__c.
//     *
//     * @param warehouse_Rent__c
//     */
//    public void setWarehouse_Rent__c(Double warehouse_Rent__c) {
//        this.warehouse_Rent__c = warehouse_Rent__c;
//    }
//
//
//    /**
//     * Gets the warehouse_number__c value for this Contract_DWC__c.
//     *
//     * @return warehouse_number__c
//     */
//    public String getWarehouse_number__c() {
//        return warehouse_number__c;
//    }
//
//
//    /**
//     * Sets the warehouse_number__c value for this Contract_DWC__c.
//     *
//     * @param warehouse_number__c
//     */
//    public void setWarehouse_number__c(String warehouse_number__c) {
//        this.warehouse_number__c = warehouse_number__c;
//    }
//

}