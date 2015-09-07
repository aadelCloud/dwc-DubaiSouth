/**
 * _case.java
 * <p/>
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package model;


import org.codehaus.jackson.annotate.JsonProperty;

import java.util.Calendar;
import java.util.Date;

public class _case implements java.io.Serializable {
    @JsonProperty("Account")
    public Account account;
    @JsonProperty("AccountId")
    public String accountId;
    @JsonProperty("Accounts__r")
    public QueryResult accounts__r;

    @JsonProperty("Agent_Case__c")
    public boolean agent_Case__c;
    @JsonProperty("Agent_Ref__c")
    public String agent_Ref__c;
    @JsonProperty("Agent_Ref__r")
    public Account agent_Ref__r;
    @JsonProperty("Applicant_Email__c")
    public String applicant_Email__c;
    @JsonProperty("Applicant_First_Name__c")
    public String applicant_First_Name__c;
    @JsonProperty("Applicant_Last_Name__c")
    public String applicant_Last_Name__c;
    @JsonProperty("Applicant_Mobile__c")
    public String applicant_Mobile__c;
    @JsonProperty("Applicant_Phone_NO__c")
    public String applicant_Phone_NO__c;

    @JsonProperty("Applicant_Proposed_Activities__c")
    public String applicant_Proposed_Activities__c;
    @JsonProperty("Applicant_name__c")
    public String applicant_name__c;
    @JsonProperty("Application_Approval_Status__c")
    public String application_Approval_Status__c;
    @JsonProperty("Application_Rejection_Reason__c")
    public String application_Rejection_Reason__c;


    @JsonProperty("Assigned_to__c")
    public String assigned_to__c;

    @JsonProperty("Attachment_Deployment_ID__c")
    public String attachment_Deployment_ID__c;

    @JsonProperty("BC_Setup_Fees_Paid__c")
    public boolean BC_Setup_Fees_Paid__c;

    @JsonProperty("Cancellation_Date__c")
    public java.util.Calendar cancellation_Date__c;
    @JsonProperty("Card_Management__c")
    public String card_Management__c;

    @JsonProperty("Case_Comment_Body__c")
    public String case_Comment_Body__c;
    @JsonProperty("Case_Rating_Score__c")
    public double case_Rating_Score__c;

    @JsonProperty("Closed_Date__c")
    public java.util.Calendar closed_Date__c;
    @JsonProperty("Collected_Date_Time__c")
    public java.util.Calendar collected_Date_Time__c;
    @JsonProperty("Collected__c")
    public boolean collected__c;

    @JsonProperty("Commercial_Company__c")
    public String commercial_Company__c;

    @JsonProperty("Company_Type__c")
    public String company_Type__c;
    @JsonProperty("Confirmation_Passport_Number__c")
    public String confirmation_Passport_Number__c;
    @JsonProperty("Confirmation_Person_Name__c")
    public String confirmation_Person_Name__c;

    @JsonProperty("Contract_Terms_Conditions__c")
    public String contract_Terms_Conditions__c;
    @JsonProperty("Courier_Amount__c")
    public double courier_Amount__c;

    @JsonProperty("Courier_Delivery_Address__c")
    public String courier_Delivery_Address__c;
    @JsonProperty("Courier_Delivery_City__c")
    public String courier_Delivery_City__c;
    @JsonProperty("Courier_Delivery_Contact_Mobile__c")
    public String courier_Delivery_Contact_Mobile__c;
    @JsonProperty("Courier_Delivery_Country_Lookup__c")
    public String courier_Delivery_Country_Lookup__c;
    @JsonProperty("Courier_Delivery_Country__c")
    public String courier_Delivery_Country__c;
    @JsonProperty("Courier_Pickup_Date__c")
    public java.util.Date courier_Pickup_Date__c;
    @JsonProperty("Courier_Pickup_Request_Number__c")
    public String courier_Pickup_Request_Number__c;


    @JsonProperty("Courier_Shipment_Label__c")
    public String courier_Shipment_Label__c;

    @JsonProperty("Date_of_Request__c")
    public java.util.Calendar date_of_Request__c;
    @JsonProperty("Delivery_Method__c")
    public String delivery_Method__c;

    @JsonProperty("Designation__c")
    public String designation__c;

    @JsonProperty("Directorships__r")
    public QueryResult directorships__r;


    @JsonProperty("Due_Date__c")
    public java.util.Date due_Date__c;
    @JsonProperty("Email_Deployment_ID__c")
    public String email_Deployment_ID__c;
    @JsonProperty("Employee_Ref__c")
    public String employee_Ref__c;
    @JsonProperty("Employee_Ref__r")
    public Account employee_Ref__r;

    @JsonProperty("FM_Milestones_Delivered__c")
    public boolean FM_Milestones_Delivered__c;

    @JsonProperty("Finance_Milestone_delivered__c")
    public boolean finance_Milestone_delivered__c;

    @JsonProperty("Free_Zone_Service_Requested__c")
    public String free_Zone_Service_Requested__c;

    @JsonProperty("Invoice__c")
    public String invoice__c;

    @JsonProperty("Is_eCopy__c")
    public boolean is_eCopy__c;
    @JsonProperty("Language__c")
    public String language__c;

    @JsonProperty("Last_Courier_Update__c")
    public java.util.Calendar last_Courier_Update__c;
    @JsonProperty("Legal_Form_Display_for_First_Time__c")
    public boolean legal_Form_Display_for_First_Time__c;
    @JsonProperty("Legal_Milestones_Delivered__c")
    public boolean legal_Milestones_Delivered__c;

    @JsonProperty("License_Ref__c")
    public String license_Ref__c;


    @JsonProperty("Location_of_Case__c")
    public String location_of_Case__c;

    @JsonProperty("Loop_ID__c")
    public String loop_ID__c;
    @JsonProperty("MailingStreet__c")
    public String mailingStreet__c;
    @JsonProperty("Mailing_City__c")
    public String mailing_City__c;
    @JsonProperty("Mailing_Country__c")
    public String mailing_Country__c;
    @JsonProperty("Mailing_State__c")
    public String mailing_State__c;
    @JsonProperty("Mailing_Zip_Postal_Code__c")
    public String mailing_Zip_Postal_Code__c;

    @JsonProperty("Mid_Level_Employees_expected__c")
    public double mid_Level_Employees_expected__c;
    @JsonProperty("NOC__c")
    public String NOC__c;

    @JsonProperty("Non_Registered_Company__c")
    public String non_Registered_Company__c;

    @JsonProperty("Original_Verified__c")
    public boolean original_Verified__c;

    @JsonProperty("Parent_Company_Commercial_Name__c")
    public String parent_Company_Commercial_Name__c;
    @JsonProperty("Passport__c")
    public String passport__c;

    @JsonProperty("Person_Name__c")
    public String person_Name__c;
    @JsonProperty("Pickup_Request_Created__c")
    public boolean pickup_Request_Created__c;
    @JsonProperty("Product_Selected__c")
    public String product_Selected__c;
    @JsonProperty("Product__c")
    public String product__c;
    @JsonProperty("Proposed_Activities_Approved__c")
    public boolean proposed_Activities_Approved__c;


    @JsonProperty("Recorded_by__c")
    public String recorded_by__c;
    @JsonProperty("Registration_Amendment__c")
    public String registration_Amendment__c;


    @JsonProperty("SMS_Sent_BC_Case_Booking_Fee_Paid__c")
    public boolean SMS_Sent_BC_Case_Booking_Fee_Paid__c;
    @JsonProperty("SMS_Sent_BC_Case_Company_Registered__c")
    public boolean SMS_Sent_BC_Case_Company_Registered__c;
    @JsonProperty("SMS_Sent_BC_Case_Created__c")
    public boolean SMS_Sent_BC_Case_Created__c;
    @JsonProperty("SMS_Sent_BC_Case_Pending_Payment__c")
    public boolean SMS_Sent_BC_Case_Pending_Payment__c;
    @JsonProperty("SMS_Sent_BC_Case_Pending_for_Original__c")
    public boolean SMS_Sent_BC_Case_Pending_for_Original__c;
    @JsonProperty("SMS_Sent_BC_Case_Under_Co_Reg__c")
    public boolean SMS_Sent_BC_Case_Under_Co_Reg__c;
    @JsonProperty("SMS_Sent_BC_Case_Under_Review__c")
    public boolean SMS_Sent_BC_Case_Under_Review__c;

    @JsonProperty("Service_Approval_Status__c")
    public String service_Approval_Status__c;

    @JsonProperty("Service_Requested__c")
    public String service_Requested__c;

    @JsonProperty("Service_Status__c")
    public String service_Status__c;

    @JsonProperty("Shipment_Number__c")
    public String shipment_Number__c;
    @JsonProperty("Shipment_Status__c")
    public String shipment_Status__c;


    @JsonProperty("Step_1_Completed__c")
    public boolean step_1_Completed__c;
    @JsonProperty("Step_2_Completed__c")
    public boolean step_2_Completed__c;
    @JsonProperty("Step_3_Completed__c")
    public boolean step_3_Completed__c;
    @JsonProperty("Step_4_Completed__c")
    public boolean step_4_Completed__c;
    @JsonProperty("Sub_Case_reason__c")
    public String sub_Case_reason__c;

    @JsonProperty("Sub_Type__c")
    public String sub_Type__c;


    @JsonProperty("Survey_Taken__c")
    public String survey_Taken__c;


    @JsonProperty("TopicAssignments")
    public QueryResult topicAssignments;
    @JsonProperty("Total_Employees_expected__c")
    public double total_Employees_expected__c;
    @JsonProperty("Trade_Licence_Number__c")
    public String trade_Licence_Number__c;

    @JsonProperty("Upsell_Opportunity_for__c")
    public String upsell_Opportunity_for__c;
    @JsonProperty("Visa_Ref__c")
    public String visa_Ref__c;

    @JsonProperty("Visual_Force_Generator__c")
    public String visual_Force_Generator__c;

    @JsonProperty("Workers_expected__c")
    public double workers_expected__c;
    @JsonProperty("ECopy_Receiver_Email__c")
    public String eCopy_Receiver_Email__c;
    @JsonProperty("EServices_Document_Checklist__c")
    public String eServices_Document_Checklist__c;


    @JsonProperty("isPaymentConfirmed__c")
    public boolean isPaymentConfirmed__c;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }


    public QueryResult getAccounts__r() {
        return accounts__r;
    }

    public void setAccounts__r(QueryResult accounts__r) {
        this.accounts__r = accounts__r;
    }



    public void setAgent_Case__c(boolean agent_Case__c) {
        this.agent_Case__c = agent_Case__c;
    }

    public String getAgent_Ref__c() {
        return agent_Ref__c;
    }

    public void setAgent_Ref__c(String agent_Ref__c) {
        this.agent_Ref__c = agent_Ref__c;
    }

    public Account getAgent_Ref__r() {
        return agent_Ref__r;
    }

    public void setAgent_Ref__r(Account agent_Ref__r) {
        this.agent_Ref__r = agent_Ref__r;
    }

    public String getApplicant_Email__c() {
        return applicant_Email__c;
    }

    public void setApplicant_Email__c(String applicant_Email__c) {
        this.applicant_Email__c = applicant_Email__c;
    }

    public String getApplicant_First_Name__c() {
        return applicant_First_Name__c;
    }

    public void setApplicant_First_Name__c(String applicant_First_Name__c) {
        this.applicant_First_Name__c = applicant_First_Name__c;
    }

    public String getApplicant_Last_Name__c() {
        return applicant_Last_Name__c;
    }

    public void setApplicant_Last_Name__c(String applicant_Last_Name__c) {
        this.applicant_Last_Name__c = applicant_Last_Name__c;
    }

    public String getApplicant_Mobile__c() {
        return applicant_Mobile__c;
    }

    public void setApplicant_Mobile__c(String applicant_Mobile__c) {
        this.applicant_Mobile__c = applicant_Mobile__c;
    }

    public String getApplicant_Phone_NO__c() {
        return applicant_Phone_NO__c;
    }

    public void setApplicant_Phone_NO__c(String applicant_Phone_NO__c) {
        this.applicant_Phone_NO__c = applicant_Phone_NO__c;
    }

    public String getApplicant_Proposed_Activities__c() {
        return applicant_Proposed_Activities__c;
    }

    public void setApplicant_Proposed_Activities__c(String applicant_Proposed_Activities__c) {
        this.applicant_Proposed_Activities__c = applicant_Proposed_Activities__c;
    }

    public String getApplicant_name__c() {
        return applicant_name__c;
    }

    public void setApplicant_name__c(String applicant_name__c) {
        this.applicant_name__c = applicant_name__c;
    }

    public String getApplication_Approval_Status__c() {
        return application_Approval_Status__c;
    }

    public void setApplication_Approval_Status__c(String application_Approval_Status__c) {
        this.application_Approval_Status__c = application_Approval_Status__c;
    }

    public String getApplication_Rejection_Reason__c() {
        return application_Rejection_Reason__c;
    }

    public void setApplication_Rejection_Reason__c(String application_Rejection_Reason__c) {
        this.application_Rejection_Reason__c = application_Rejection_Reason__c;
    }

    public String getAssigned_to__c() {
        return assigned_to__c;
    }

    public void setAssigned_to__c(String assigned_to__c) {
        this.assigned_to__c = assigned_to__c;
    }

    public String getAttachment_Deployment_ID__c() {
        return attachment_Deployment_ID__c;
    }

    public void setAttachment_Deployment_ID__c(String attachment_Deployment_ID__c) {
        this.attachment_Deployment_ID__c = attachment_Deployment_ID__c;
    }



    public void setBC_Setup_Fees_Paid__c(boolean BC_Setup_Fees_Paid__c) {
        this.BC_Setup_Fees_Paid__c = BC_Setup_Fees_Paid__c;
    }

    public Calendar getCancellation_Date__c() {
        return cancellation_Date__c;
    }

    public void setCancellation_Date__c(Calendar cancellation_Date__c) {
        this.cancellation_Date__c = cancellation_Date__c;
    }

    public String getCard_Management__c() {
        return card_Management__c;
    }

    public void setCard_Management__c(String card_Management__c) {
        this.card_Management__c = card_Management__c;
    }

    public String getCase_Comment_Body__c() {
        return case_Comment_Body__c;
    }

    public void setCase_Comment_Body__c(String case_Comment_Body__c) {
        this.case_Comment_Body__c = case_Comment_Body__c;
    }

    public double getCase_Rating_Score__c() {
        return case_Rating_Score__c;
    }

    public void setCase_Rating_Score__c(double case_Rating_Score__c) {
        this.case_Rating_Score__c = case_Rating_Score__c;
    }

    public Calendar getClosed_Date__c() {
        return closed_Date__c;
    }

    public void setClosed_Date__c(Calendar closed_Date__c) {
        this.closed_Date__c = closed_Date__c;
    }

    public Calendar getCollected_Date_Time__c() {
        return collected_Date_Time__c;
    }

    public void setCollected_Date_Time__c(Calendar collected_Date_Time__c) {
        this.collected_Date_Time__c = collected_Date_Time__c;
    }



    public void setCollected__c(boolean collected__c) {
        this.collected__c = collected__c;
    }

    public String getCommercial_Company__c() {
        return commercial_Company__c;
    }

    public void setCommercial_Company__c(String commercial_Company__c) {
        this.commercial_Company__c = commercial_Company__c;
    }

    public String getCompany_Type__c() {
        return company_Type__c;
    }

    public void setCompany_Type__c(String company_Type__c) {
        this.company_Type__c = company_Type__c;
    }

    public String getConfirmation_Passport_Number__c() {
        return confirmation_Passport_Number__c;
    }

    public void setConfirmation_Passport_Number__c(String confirmation_Passport_Number__c) {
        this.confirmation_Passport_Number__c = confirmation_Passport_Number__c;
    }

    public String getConfirmation_Person_Name__c() {
        return confirmation_Person_Name__c;
    }

    public void setConfirmation_Person_Name__c(String confirmation_Person_Name__c) {
        this.confirmation_Person_Name__c = confirmation_Person_Name__c;
    }

    public String getContract_Terms_Conditions__c() {
        return contract_Terms_Conditions__c;
    }

    public void setContract_Terms_Conditions__c(String contract_Terms_Conditions__c) {
        this.contract_Terms_Conditions__c = contract_Terms_Conditions__c;
    }

    public double getCourier_Amount__c() {
        return courier_Amount__c;
    }

    public void setCourier_Amount__c(double courier_Amount__c) {
        this.courier_Amount__c = courier_Amount__c;
    }

    public String getCourier_Delivery_Address__c() {
        return courier_Delivery_Address__c;
    }

    public void setCourier_Delivery_Address__c(String courier_Delivery_Address__c) {
        this.courier_Delivery_Address__c = courier_Delivery_Address__c;
    }

    public String getCourier_Delivery_City__c() {
        return courier_Delivery_City__c;
    }

    public void setCourier_Delivery_City__c(String courier_Delivery_City__c) {
        this.courier_Delivery_City__c = courier_Delivery_City__c;
    }

    public String getCourier_Delivery_Contact_Mobile__c() {
        return courier_Delivery_Contact_Mobile__c;
    }

    public void setCourier_Delivery_Contact_Mobile__c(String courier_Delivery_Contact_Mobile__c) {
        this.courier_Delivery_Contact_Mobile__c = courier_Delivery_Contact_Mobile__c;
    }

    public String getCourier_Delivery_Country_Lookup__c() {
        return courier_Delivery_Country_Lookup__c;
    }

    public void setCourier_Delivery_Country_Lookup__c(String courier_Delivery_Country_Lookup__c) {
        this.courier_Delivery_Country_Lookup__c = courier_Delivery_Country_Lookup__c;
    }

    public String getCourier_Delivery_Country__c() {
        return courier_Delivery_Country__c;
    }

    public void setCourier_Delivery_Country__c(String courier_Delivery_Country__c) {
        this.courier_Delivery_Country__c = courier_Delivery_Country__c;
    }

    public Date getCourier_Pickup_Date__c() {
        return courier_Pickup_Date__c;
    }

    public void setCourier_Pickup_Date__c(Date courier_Pickup_Date__c) {
        this.courier_Pickup_Date__c = courier_Pickup_Date__c;
    }

    public String getCourier_Pickup_Request_Number__c() {
        return courier_Pickup_Request_Number__c;
    }

    public void setCourier_Pickup_Request_Number__c(String courier_Pickup_Request_Number__c) {
        this.courier_Pickup_Request_Number__c = courier_Pickup_Request_Number__c;
    }

    public String getCourier_Shipment_Label__c() {
        return courier_Shipment_Label__c;
    }

    public void setCourier_Shipment_Label__c(String courier_Shipment_Label__c) {
        this.courier_Shipment_Label__c = courier_Shipment_Label__c;
    }

    public Calendar getDate_of_Request__c() {
        return date_of_Request__c;
    }

    public void setDate_of_Request__c(Calendar date_of_Request__c) {
        this.date_of_Request__c = date_of_Request__c;
    }

    public String getDelivery_Method__c() {
        return delivery_Method__c;
    }

    public void setDelivery_Method__c(String delivery_Method__c) {
        this.delivery_Method__c = delivery_Method__c;
    }

    public String getDesignation__c() {
        return designation__c;
    }

    public void setDesignation__c(String designation__c) {
        this.designation__c = designation__c;
    }

    public QueryResult getDirectorships__r() {
        return directorships__r;
    }

    public void setDirectorships__r(QueryResult directorships__r) {
        this.directorships__r = directorships__r;
    }

    public Date getDue_Date__c() {
        return due_Date__c;
    }

    public void setDue_Date__c(Date due_Date__c) {
        this.due_Date__c = due_Date__c;
    }

    public String getEmail_Deployment_ID__c() {
        return email_Deployment_ID__c;
    }

    public void setEmail_Deployment_ID__c(String email_Deployment_ID__c) {
        this.email_Deployment_ID__c = email_Deployment_ID__c;
    }

    public String getEmployee_Ref__c() {
        return employee_Ref__c;
    }

    public void setEmployee_Ref__c(String employee_Ref__c) {
        this.employee_Ref__c = employee_Ref__c;
    }

    public Account getEmployee_Ref__r() {
        return employee_Ref__r;
    }

    public void setEmployee_Ref__r(Account employee_Ref__r) {
        this.employee_Ref__r = employee_Ref__r;
    }



    public void setFM_Milestones_Delivered__c(boolean FM_Milestones_Delivered__c) {
        this.FM_Milestones_Delivered__c = FM_Milestones_Delivered__c;
    }



    public void setFinance_Milestone_delivered__c(boolean finance_Milestone_delivered__c) {
        this.finance_Milestone_delivered__c = finance_Milestone_delivered__c;
    }

    public String getFree_Zone_Service_Requested__c() {
        return free_Zone_Service_Requested__c;
    }

    public void setFree_Zone_Service_Requested__c(String free_Zone_Service_Requested__c) {
        this.free_Zone_Service_Requested__c = free_Zone_Service_Requested__c;
    }

    public String getInvoice__c() {
        return invoice__c;
    }

    public void setInvoice__c(String invoice__c) {
        this.invoice__c = invoice__c;
    }


    public void setIs_eCopy__c(boolean is_eCopy__c) {
        this.is_eCopy__c = is_eCopy__c;
    }

    public String getLanguage__c() {
        return language__c;
    }

    public void setLanguage__c(String language__c) {
        this.language__c = language__c;
    }

    public Calendar getLast_Courier_Update__c() {
        return last_Courier_Update__c;
    }

    public void setLast_Courier_Update__c(Calendar last_Courier_Update__c) {
        this.last_Courier_Update__c = last_Courier_Update__c;
    }

    public void setLegal_Form_Display_for_First_Time__c(boolean legal_Form_Display_for_First_Time__c) {
        this.legal_Form_Display_for_First_Time__c = legal_Form_Display_for_First_Time__c;
    }



    public void setLegal_Milestones_Delivered__c(boolean legal_Milestones_Delivered__c) {
        this.legal_Milestones_Delivered__c = legal_Milestones_Delivered__c;
    }

    public String getLicense_Ref__c() {
        return license_Ref__c;
    }

    public void setLicense_Ref__c(String license_Ref__c) {
        this.license_Ref__c = license_Ref__c;
    }

    public String getLocation_of_Case__c() {
        return location_of_Case__c;
    }

    public void setLocation_of_Case__c(String location_of_Case__c) {
        this.location_of_Case__c = location_of_Case__c;
    }

    public String getLoop_ID__c() {
        return loop_ID__c;
    }

    public void setLoop_ID__c(String loop_ID__c) {
        this.loop_ID__c = loop_ID__c;
    }

    public String getMailingStreet__c() {
        return mailingStreet__c;
    }

    public void setMailingStreet__c(String mailingStreet__c) {
        this.mailingStreet__c = mailingStreet__c;
    }

    public String getMailing_City__c() {
        return mailing_City__c;
    }

    public void setMailing_City__c(String mailing_City__c) {
        this.mailing_City__c = mailing_City__c;
    }

    public String getMailing_Country__c() {
        return mailing_Country__c;
    }

    public void setMailing_Country__c(String mailing_Country__c) {
        this.mailing_Country__c = mailing_Country__c;
    }

    public String getMailing_State__c() {
        return mailing_State__c;
    }

    public void setMailing_State__c(String mailing_State__c) {
        this.mailing_State__c = mailing_State__c;
    }

    public String getMailing_Zip_Postal_Code__c() {
        return mailing_Zip_Postal_Code__c;
    }

    public void setMailing_Zip_Postal_Code__c(String mailing_Zip_Postal_Code__c) {
        this.mailing_Zip_Postal_Code__c = mailing_Zip_Postal_Code__c;
    }

    public double getMid_Level_Employees_expected__c() {
        return mid_Level_Employees_expected__c;
    }

    public void setMid_Level_Employees_expected__c(double mid_Level_Employees_expected__c) {
        this.mid_Level_Employees_expected__c = mid_Level_Employees_expected__c;
    }

    public String getNOC__c() {
        return NOC__c;
    }

    public void setNOC__c(String NOC__c) {
        this.NOC__c = NOC__c;
    }

    public String getNon_Registered_Company__c() {
        return non_Registered_Company__c;
    }

    public void setNon_Registered_Company__c(String non_Registered_Company__c) {
        this.non_Registered_Company__c = non_Registered_Company__c;
    }


    public void setOriginal_Verified__c(boolean original_Verified__c) {
        this.original_Verified__c = original_Verified__c;
    }

    public String getParent_Company_Commercial_Name__c() {
        return parent_Company_Commercial_Name__c;
    }

    public void setParent_Company_Commercial_Name__c(String parent_Company_Commercial_Name__c) {
        this.parent_Company_Commercial_Name__c = parent_Company_Commercial_Name__c;
    }

    public String getPassport__c() {
        return passport__c;
    }

    public void setPassport__c(String passport__c) {
        this.passport__c = passport__c;
    }

    public String getPerson_Name__c() {
        return person_Name__c;
    }

    public void setPerson_Name__c(String person_Name__c) {
        this.person_Name__c = person_Name__c;
    }



    public void setPickup_Request_Created__c(boolean pickup_Request_Created__c) {
        this.pickup_Request_Created__c = pickup_Request_Created__c;
    }

    public String getProduct_Selected__c() {
        return product_Selected__c;
    }

    public void setProduct_Selected__c(String product_Selected__c) {
        this.product_Selected__c = product_Selected__c;
    }

    public String getProduct__c() {
        return product__c;
    }

    public void setProduct__c(String product__c) {
        this.product__c = product__c;
    }


    public void setProposed_Activities_Approved__c(boolean proposed_Activities_Approved__c) {
        this.proposed_Activities_Approved__c = proposed_Activities_Approved__c;
    }

    public String getRecorded_by__c() {
        return recorded_by__c;
    }

    public void setRecorded_by__c(String recorded_by__c) {
        this.recorded_by__c = recorded_by__c;
    }

    public String getRegistration_Amendment__c() {
        return registration_Amendment__c;
    }

    public void setRegistration_Amendment__c(String registration_Amendment__c) {
        this.registration_Amendment__c = registration_Amendment__c;
    }



    public void setSMS_Sent_BC_Case_Booking_Fee_Paid__c(boolean SMS_Sent_BC_Case_Booking_Fee_Paid__c) {
        this.SMS_Sent_BC_Case_Booking_Fee_Paid__c = SMS_Sent_BC_Case_Booking_Fee_Paid__c;
    }



    public void setSMS_Sent_BC_Case_Company_Registered__c(boolean SMS_Sent_BC_Case_Company_Registered__c) {
        this.SMS_Sent_BC_Case_Company_Registered__c = SMS_Sent_BC_Case_Company_Registered__c;
    }


    public void setSMS_Sent_BC_Case_Created__c(boolean SMS_Sent_BC_Case_Created__c) {
        this.SMS_Sent_BC_Case_Created__c = SMS_Sent_BC_Case_Created__c;
    }



    public void setSMS_Sent_BC_Case_Pending_Payment__c(boolean SMS_Sent_BC_Case_Pending_Payment__c) {
        this.SMS_Sent_BC_Case_Pending_Payment__c = SMS_Sent_BC_Case_Pending_Payment__c;
    }



    public void setSMS_Sent_BC_Case_Pending_for_Original__c(boolean SMS_Sent_BC_Case_Pending_for_Original__c) {
        this.SMS_Sent_BC_Case_Pending_for_Original__c = SMS_Sent_BC_Case_Pending_for_Original__c;
    }



    public void setSMS_Sent_BC_Case_Under_Co_Reg__c(boolean SMS_Sent_BC_Case_Under_Co_Reg__c) {
        this.SMS_Sent_BC_Case_Under_Co_Reg__c = SMS_Sent_BC_Case_Under_Co_Reg__c;
    }


    public void setSMS_Sent_BC_Case_Under_Review__c(boolean SMS_Sent_BC_Case_Under_Review__c) {
        this.SMS_Sent_BC_Case_Under_Review__c = SMS_Sent_BC_Case_Under_Review__c;
    }

    public String getService_Approval_Status__c() {
        return service_Approval_Status__c;
    }

    public void setService_Approval_Status__c(String service_Approval_Status__c) {
        this.service_Approval_Status__c = service_Approval_Status__c;
    }

    public String getService_Status__c() {
        return service_Status__c;
    }

    public void setService_Status__c(String service_Status__c) {
        this.service_Status__c = service_Status__c;
    }

    public String getShipment_Number__c() {
        return shipment_Number__c;
    }

    public void setShipment_Number__c(String shipment_Number__c) {
        this.shipment_Number__c = shipment_Number__c;
    }

    public String getShipment_Status__c() {
        return shipment_Status__c;
    }

    public void setShipment_Status__c(String shipment_Status__c) {
        this.shipment_Status__c = shipment_Status__c;
    }



    public void setStep_1_Completed__c(boolean step_1_Completed__c) {
        this.step_1_Completed__c = step_1_Completed__c;
    }


    public void setStep_2_Completed__c(boolean step_2_Completed__c) {
        this.step_2_Completed__c = step_2_Completed__c;
    }


    public void setStep_3_Completed__c(boolean step_3_Completed__c) {
        this.step_3_Completed__c = step_3_Completed__c;
    }


    public void setStep_4_Completed__c(boolean step_4_Completed__c) {
        this.step_4_Completed__c = step_4_Completed__c;
    }

    public String getSub_Case_reason__c() {
        return sub_Case_reason__c;
    }

    public void setSub_Case_reason__c(String sub_Case_reason__c) {
        this.sub_Case_reason__c = sub_Case_reason__c;
    }

    public String getSub_Type__c() {
        return sub_Type__c;
    }

    public void setSub_Type__c(String sub_Type__c) {
        this.sub_Type__c = sub_Type__c;
    }

    public String getSurvey_Taken__c() {
        return survey_Taken__c;
    }

    public void setSurvey_Taken__c(String survey_Taken__c) {
        this.survey_Taken__c = survey_Taken__c;
    }

    public QueryResult getTopicAssignments() {
        return topicAssignments;
    }

    public void setTopicAssignments(QueryResult topicAssignments) {
        this.topicAssignments = topicAssignments;
    }

    public double getTotal_Employees_expected__c() {
        return total_Employees_expected__c;
    }

    public void setTotal_Employees_expected__c(double total_Employees_expected__c) {
        this.total_Employees_expected__c = total_Employees_expected__c;
    }

    public String getTrade_Licence_Number__c() {
        return trade_Licence_Number__c;
    }

    public void setTrade_Licence_Number__c(String trade_Licence_Number__c) {
        this.trade_Licence_Number__c = trade_Licence_Number__c;
    }

    public String getUpsell_Opportunity_for__c() {
        return upsell_Opportunity_for__c;
    }

    public void setUpsell_Opportunity_for__c(String upsell_Opportunity_for__c) {
        this.upsell_Opportunity_for__c = upsell_Opportunity_for__c;
    }

    public String getVisa_Ref__c() {
        return visa_Ref__c;
    }

    public void setVisa_Ref__c(String visa_Ref__c) {
        this.visa_Ref__c = visa_Ref__c;
    }

    public String getVisual_Force_Generator__c() {
        return visual_Force_Generator__c;
    }

    public void setVisual_Force_Generator__c(String visual_Force_Generator__c) {
        this.visual_Force_Generator__c = visual_Force_Generator__c;
    }

    public double getWorkers_expected__c() {
        return workers_expected__c;
    }

    public void setWorkers_expected__c(double workers_expected__c) {
        this.workers_expected__c = workers_expected__c;
    }

    public String geteCopy_Receiver_Email__c() {
        return eCopy_Receiver_Email__c;
    }

    public void seteCopy_Receiver_Email__c(String eCopy_Receiver_Email__c) {
        this.eCopy_Receiver_Email__c = eCopy_Receiver_Email__c;
    }

    public String geteServices_Document_Checklist__c() {
        return eServices_Document_Checklist__c;
    }

    public void seteServices_Document_Checklist__c(String eServices_Document_Checklist__c) {
        this.eServices_Document_Checklist__c = eServices_Document_Checklist__c;
    }



    public void setIsPaymentConfirmed__c(boolean isPaymentConfirmed__c) {
        this.isPaymentConfirmed__c = isPaymentConfirmed__c;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("Status")
    public String status;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("Type")
    public String type;

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @JsonProperty("Origin")
    public String origin;
    @JsonProperty("isCourierRequired__c")
    public boolean isCourierRequired__c;
    @JsonProperty("RecordTypeId")
    public String RecordTypeId;
    @JsonProperty("AccountId")
    public String AccountId;
    @JsonProperty("Service_Requested__c")
    public String Service_Requested__c;


    public void setIsCourierRequired__c(boolean isCourierRequired__c) {
        this.isCourierRequired__c = isCourierRequired__c;
    }

    public String getRecordTypeId() {
        return RecordTypeId;
    }

    public void setRecordTypeId(String recordTypeId) {
        RecordTypeId = recordTypeId;
    }

    public String getAccountId() {
        return AccountId;
    }

    public void setAccountId(String accountId) {
        AccountId = accountId;
    }

    public String getService_Requested__c() {
        return Service_Requested__c;
    }

    public void setService_Requested__c(String service_Requested__c) {
        Service_Requested__c = service_Requested__c;
    }
}