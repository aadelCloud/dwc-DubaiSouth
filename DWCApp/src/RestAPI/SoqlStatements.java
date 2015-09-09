package RestAPI;

import android.util.Log;

import com.google.gson.Gson;

import model.User;
import model.Visa;

/**
 * Created by Abanoub on 6/14/2015.
 */
public class SoqlStatements {

//    public static final String LimitOffsetFormat = "LIMIT " + "\'" + "%d" + "\'" + " OFFSET " + "\'" + "%d" + "\'";
    ;

    public static final String LIMIT = "10";

    public static final String renewVisaSQL = "SELECT Id,Visa_Holder__r.Name,Visa_Holder__r.Id,Applicant_Full_Name__c,Applicant_Full_Name_Arabic__c,Country_of_Birth__c,Applicant_Email__c,marital_Status__c,Applicant_Mobile_Number__c,mother_Name__c,religion__c,languages__c "
            + ",Passport_Number__c,Applicant_Gender__c,Date_of_Birth__c,Job_Title_at_Immigration__r.Id,Place_of_Birth__c," +
            "Job_Title_at_Immigration__r.Name,Country_of_Birth__r.Name,Country_of_Birth__r.Id,qualification__c ,Previous_Nationality__c ,Passport_Issue_Country__c,Visa_Expiry_Date__c,Passport_Country__c,passport_Place_of_Issue__c,renewal_for_Visa__c,Employee_ID__c" +
            ",Current_Nationality__c,Qualification__r.Id,Qualification__r.Name,Current_Nationality__r.Id,Current_Nationality__r.Name,Passport_Expiry__c,monthly_Basic_Salary_in_AED__c,monthly_Allowances_in_AED__c,in_Country_Paid__c ,local_Amendment_Paid__c ,urgent_Processing_Paid__c "
            + ",urgent_Stamping_Paid__c,Residency_File_Number__c,Record_Type_Name__c,Previous_Nationality__r.Id,passport__r.Passport_Holder__r.Name,passport__r.Passport_Holder__c,passport__r.Passport_Expiry_Date__c,passport__r.Passport_Issue_Country__c,passport__r.Passport_Issue_Date__c,Previous_Nationality__r.Name,Passport_Issue_Country__r.Id,Passport_Issue_Country__r.Name FROM Visa__c WHERE Id='%s' ";

    public static final String soql_company_info = "SELECT ContactId, Contact.Name, Contact.Personal_Photo__c, Contact.Account.Id, Contact.Account.Account_Balance__c, Contact.Account.Portal_Balance__c, Contact.Account.Name, Contact.Account.Arabic_Account_Name__c, Contact.Account.License_Number_Formula__c, Contact.Account.BillingCity, Contact.Account.Company_Registration_Date__c, Contact.Account.Legal_Form__c, Contact.Account.Registration_Number_Value__c, Contact.Account.Phone, Contact.Account.Fax, Contact.Account.Email__c, Contact.Account.Mobile__c, Contact.Account.PRO_Email__c, Contact.Account.PRO_Mobile_Number__c,Contact.Account.BillingStreet, Contact.Account.BillingPostalCode, Contact.Account.BillingCountry, Contact.Account.BillingState, Contact.Account.Current_License_Number__r.Id, Contact.Account.Current_License_Number__r.License_Issue_Date__c, Contact.Account.Current_License_Number__r.License_Expiry_Date__c, Contact.Account.Current_License_Number__r.Commercial_Name__c, Contact.Account.Current_License_Number__r.Commercial_Name_Arabic__c, Contact.Account.Current_License_Number__r.License_Number_Value__c, Contact.Account.Current_License_Number__r.Validity_Status__c, Contact.Account.Current_License_Number__r.RecordType.Id, Contact.Account.Current_License_Number__r.RecordType.Name, Contact.Account.Current_License_Number__r.RecordType.DeveloperName, Contact.Account.Current_License_Number__r.RecordType.SObjectType, Contact.Account.Company_Logo__c FROM User WHERE Id = ";

    public static final String soql_get_permanent_employee_list_page = "SELECT Id, Employee_ID__c, Personal_Photo__c, Salutation_Arabic__c, " +
            "Applicant_Middle_Name_Arabic__c, Applicant_Last_Name_Arabic__c, " +
            "Applicant_First_Name_Arabic__c, Religion__c, Applicant_Email__c, " +
            "Applicant_Mobile_Number__c, Applicant_Gender__c, " +
            "Passport_Country__c, Passport_Number__c, Passport_Expiry__c, " +
            "Date_of_Birth__c, Salutation__c, Visa_Type__c, Visa_Expiry_Date__c, " +
            "Applicant_Full_Name__c, Visa_Validity_Status__c, Accompanied_By__c, " +
            "Visit_Visa_Duration__c, Country_of_Birth__r.Id, " +
            "Country_of_Birth__r.Name, Current_Nationality__r.Id, " +
            "Current_Nationality__r.Name, Job_Title_at_Immigration__r.Id, " +
            "Job_Title_at_Immigration__r.Name, Sponsoring_Company__c, " +
            "Sponsoring_Company__r.Name, Visa_Holder__c, Visa_Holder__r.Id, " +
            "Visa_Holder__r.Name, Visa_Holder__r.BillingCity FROM Visa__c WHERE " +
            "Sponsoring_Company__c = " + "\'" + "%s" + "\'" + "AND Visa_Validity_Status__c LIKE " + "\'" + "%s" + "\'" +
            "AND Visa_Type__c IN ('Employment', 'Transfer - External', 'Transfer - " +
            "Internal') ORDER BY Visa_Expiry_Date__c LIMIT %s Offset %s";


    public static final String soql_get_access_card_page = "SELECT Id, Name, Personal_Photo__c, Card_Number__c, Status__c, " +
            "Sponsor__c, Card_Type__c, Salutation__c, Card_Expiry_Date__c,Card_Issue_Date__c, Full_Name__c, Arabic_Name__c,Designation__c, Duration__c, " +
            "Passport_Number__c, RecordType.Id, RecordType.Name," +
            "RecordType.DeveloperName,Requested_From__c,Account__r.Id,Account__r.Name, Nationality__r.Id, Nationality__r.Name " +
            "FROM Card_Management__c WHERE Account__c = '%s' and Status__c " +
            "NOT IN ('Renewed') AND Card_Type__c NOT IN ('Employee " +
            "Card','Student Card') AND Status__c LIKE '%s'";

    public static final String soql_get_visit_visa_page = "SELECT Id, Employee_ID__c, Personal_Photo__c, Salutation_Arabic__c, Applicant_Middle_Name_Arabic__c, Applicant_Last_Name_Arabic__c, Applicant_First_Name_Arabic__c, Religion__c, Applicant_Email__c, Applicant_Mobile_Number__c, Applicant_Gender__c, Passport_Country__c, Passport_Number__c, Passport_Expiry__c, Date_of_Birth__c, Salutation__c, Visa_Type__c, Visa_Expiry_Date__c, Applicant_Full_Name__c, Visa_Validity_Status__c, Accompanied_By__c, Visit_Visa_Duration__c, Country_of_Birth__r.Id, Country_of_Birth__r.Name, Current_Nationality__r.Id, Current_Nationality__r.Name, Job_Title_at_Immigration__r.Id, Job_Title_at_Immigration__r.Name, Sponsoring_Company__c, Sponsoring_Company__r.Name, Visa_Holder__c, Visa_Holder__r.Id, Visa_Holder__r.Name, Visa_Holder__r.BillingCity FROM Visa__c WHERE Sponsoring_Company__c = " + "\'" + "%s" + "\'" + " AND Visa_Validity_Status__c LIKE " + "\'" + "%s" + "\'" + " AND Visa_Type__c in ('Visit') ORDER BY Visa_Expiry_Date__c";

    public static final String soql_get_activity_license_number = "SELECT Id, Name, Status__c, Start_Date__c, End_Date__c, Original_Business_Activity__r.Id, Original_Business_Activity__r.Name, Original_Business_Activity__r.License_Type__c, Original_Business_Activity__r.Business_Activity_Name__c, Original_Business_Activity__r.Business_Activity_Name_Arabic__c, Original_Business_Activity__r.Business_Activity_Description__c, Original_Business_Activity__r.Status__c FROM License_Activity__c WHERE License__c = " + "\'" + "%s" + "\'";

    public static final String soql_get_renewal_for_license =
            "SELECT ID, (SELECT Id, Status__c FROM Invoices__r WHERE Status__c = 'Paid') FROM License__c WHERE Renewal_for_License__c = " + "\'" + "%s" + "\'";

    public static final String soql_get_shareholders = "SELECT Id, No_of_Shares__c, Ownership_of_Share__c, Shareholder__r.Id, Shareholder__r.Name, Shareholder__r.Nationality__c, Shareholder__r.Personal_Photo__pc, Shareholder__r.Current_Passport__r.Id, Shareholder__r.Current_Passport__r.Name, Shareholder__r.Current_Passport__r.Passport_Expiry_Date__c, Shareholder__r.Current_Passport__r.Passport_Issue_Date__c, Shareholder__r.Current_Passport__r.Passport_Type__c, Shareholder__r.Current_Passport__r.Passport_Place_of_Issue__c, Shareholder_Status__c, Ownership_End_Date__c, Ownership_Start_Date__c FROM Share_Ownership__c WHERE Company__c = " + "\'" + "%s" + "\'" + " ORDER BY Shareholder__r.Name";

    public static final String soql_getDirectors = "SELECT Id, Roles__c, Director_Status__c, Directorship_End_Date__c, Directorship_Start_Date__c, Director__r.Id, Director__r.Name, Director__r.Personal_Photo__pc ,Director__r.Nationality__c, Director__r.Current_Passport__r.Id, Director__r.Current_Passport__r.Name, Director__r.Current_Passport__r.Passport_Expiry_Date__c, Director__r.Current_Passport__r.Passport_Issue_Date__c, Director__r.Current_Passport__r.Passport_Type__c, Director__r.Current_Passport__r.Passport_Place_of_Issue__c FROM Directorship__c WHERE Company__c = " + "\'" + "%s" + "\'" + " ORDER BY Director__r.Name";

    public static final String soql_generalManagers = "SELECT Id, Manager__r.Id, Manager__r.Name, Manager_Status__c, Manager__r.Personal_Photo__pc, Manager__r.Nationality__c, Manager__r.Current_Passport__r.Id, Manager__r.Current_Passport__r.Name, Manager__r.Current_Passport__r.Passport_Expiry_Date__c, Manager__r.Current_Passport__r.Passport_Issue_Date__c, Manager__r.Current_Passport__r.Passport_Type__c, Manager__r.Current_Passport__r.Passport_Place_of_Issue__c, Manager_Start_Date__c, Manager_End_Date__c, Role__c, Status__c FROM Management_Member__c WHERE Company__c = " + "\'" + "%s" + "\'" + " ORDER BY Manager__r.Name";

    public static final String soql_legal_representatives = "SELECT Id, Legal_Representative__r.Id, Legal_Representative__r.Name, Legal_Representative__r.Nationality__c, Legal_Representative__r.Personal_Photo__pc, Legal_Representative__r.Current_Passport__r.Id, Legal_Representative__r.Current_Passport__r.Name, Legal_Representative__r.Current_Passport__r.Passport_Expiry_Date__c, Legal_Representative__r.Current_Passport__r.Passport_Issue_Date__c, Legal_Representative__r.Current_Passport__r.Passport_Type__c, Legal_Representative__r.Current_Passport__r.Passport_Place_of_Issue__c , Status__c, Role__c, Legal_Representative_End_Date__c, Legal_Representative_Start_Date__c FROM Legal_Representative__c WHERE Company__c = " + "\'" + "%s" + "\'" + " ORDER BY Legal_Representative__r.Name";

    public static final String Employee_WHERE_CLAUSE = "AND Related_to_Object__c = 'NOC'" +
            "AND RecordType.DeveloperName = 'Service_Request' AND NOC_Type__c " +
            "= 'Employee' AND isAvailableOnPortal__c = true AND " +
            "New_Edit_VF_Generator__c != null";


    public static final String Company_WHERE_CLAUSE = "AND Related_to_Object__c = 'NOC'" +
            "AND RecordType.DeveloperName = 'Service_Request' AND NOC_Type__c " +
            "= 'Company' AND isAvailableOnPortal__c = true AND " +
            "New_Edit_VF_Generator__c != null";
    public static final String soql_get__company_noc_service = "SELECT ID, Name, Display_Name__c, Service_Identifier__c, Amount__c," +
            " Total_Amount__c, Related_to_Object__c, New_Edit_VF_Generator__c, Renewal_VF_Generator__c, " +
            "Replace_VF_Generator__c, Cancel_VF_Generator__c, Record_Type_Picklist__c, (SELECT ID, Name, Type__c," +
            " Language__c, Document_Type__c, Authority__c FROM eServices_Document_Checklists__r)" +
            " FROM Receipt_Template__c WHERE Is_Active__c = true " + Company_WHERE_CLAUSE + " ORDER BY Service_Identifier__c";


    //eServices Administration Object
//    public static final String soql_get__employee_noc_service = "SELECT ID, Name, Display_Name__c, Service_Identifier__c, Amount__c, " +
//            "Total_Amount__c, Related_to_Object__c, New_Edit_VF_Generator__c, " +
//            "Renewal_VF_Generator__c, Replace_VF_Generator__c, " +
//            "Cancel_VF_Generator__c, Record_Type_Picklist__c, (SELECT ID, Name, " +
//            "Type__c, Language__c, Document_Type__c, Authority__c FROM " +
//            "eServices_Document_Checklists__r where Template_Name_Link__c != null AND Document_Type__c = 'Download' AND Language__c != null AND Authority__c != null and Gender__c in ( " + "\'" + "%s" + "\'" + "  )) FROM Receipt_Template__c WHERE " +
//            "Is_Active__c = true " + "%s" + " ORDER BY Service_Identifier__c";

    public static final String soql_get__employee_noc_service = "SELECT ID, Name, Display_Name__c, Service_Identifier__c, Amount__c, " +
            "Total_Amount__c, Related_to_Object__c, New_Edit_VF_Generator__c, " +
            "Renewal_VF_Generator__c, Replace_VF_Generator__c, " +
            "Cancel_VF_Generator__c, Record_Type_Picklist__c, (SELECT ID, Name, " +
            "Type__c, Language__c, Document_Type__c, Authority__c FROM " +
            "eServices_Document_Checklists__r where Template_Name_Link__c != null AND Language__c != null AND Authority__c != null and Gender__c in ( " + "\'" + "%s" + "\'" + "  )) FROM Receipt_Template__c WHERE " + "Is_Active__c = true " + "%s" + " ORDER BY Service_Identifier__c";

    public static final String soql_get_my_requests = "SELECT Id, CaseNumber, Status, Type, Web_Form__c, CreatedDate, Sub_Type__c, Sub_Type_Formula__c, RecordType.Id, RecordType.Name, RecordType.DeveloperName, RecordType.SobjectType, Employee_Ref__r.Id, Employee_Ref__r.Name FROM Case WHERE AccountId = " + "\'" + "%s" + "\'" + " AND Status LIKE " + "\'" + "%s" + "\'" +
            " AND Type LIKE " + "\'" + "%s" + "\'";

    public static final String soql_get_my_notifications = "SELECT ID, Name, isFeedbackAllowed__c, Case_Process_Name__c, Case_Status__c, isMessageRead__c, Is_Push_Notification_Allowed__c, Notification_Message__c, Prior_Value__c, Read_Date_and_Time__c, Compiled_Message__c, Mobile_Compiled_Message__c, CreatedDate, Case__r.Id, Case__r.CaseNumber, Case__r.Case_Rating_Score__c, Case__r.Web_Form__c, Case__r.Status, Case__r.CreatedDate FROM Notification_Management__c WHERE Case__r.AccountId = " + "\'" + "%s" + "\'" + " AND Is_Push_Notification_Allowed__c = TRUE " + " LIMIT " + "%s" + " OFFSET " + "%s";

    public static final String soql_get_NOC_WebForm = "SELECT Id, Name, Description__c, Title__c, isNotesAttachments__c, Object_Label__c, Object_Name__c, (SELECT Id, Name, APIRequired__c, Boolean_Value__c, Currency_Value__c, DateTime_Value__c, Date_Value__c, Email_Value__c , Hidden__c, isCalculated__c, isParameter__c, isQuery__c, Label__c, Number_Value__c, Order__c, Percent_Value__c, Phone_Value__c, Picklist_Value__c, PicklistEntries__c, Required__c, Text_Area_Long_Value__c, Text_Area_Value__c, Text_Value__c, Type__c, URL_Value__c, Web_Form__c, Width__c, isMobileAvailable__c, Mobile_Label__c, Mobile_Order__c, isDependentPicklist__c, Controlling_Field__c, should_Be_Cloned__c FROM R00N70000002DiOrEAK WHERE isMobileAvailable__c = true ORDER BY Mobile_Order__c) FROM Web_Form__c WHERE ID = " + "\'" + "%s" + "\'";

    public static final String soql_get_company_documents = "select Company__c,Uploaded__c,NOC__c, Card_Management__c, Verified_Scan_Copy__c , name , Required_Scan_copy__c , Attachment_Id__c , Version__c from Company_Documents__c where NOC__c = " + "\'" + "%s" + "\'";

    public static final String soql_get_record_type_company_documents = "SELECT ID FROM RecordType where DeveloperName = 'Company_Documents' AND SObjectType = 'Company_Documents__c'";

    public static final String soql_view_statement = "SELECT Id, Name, CreatedDate, Transaction_Date__c, Paypal_Amount__c, Status__c, Payment_Type__c, Debit_Amount__c, Credit_Amount__c, Closing_Balance__C, Narrative__c, Effect_on_Account__c, Request__r.Employee_Ref__r.Name FROM Free_Zone_Payment__c WHERE Free_Zone_Customer__c = " + "\'" + "%s" + "\'" + " AND Effect_on_Account__c IN ('Credit', 'Debit') " + " %s " + " LIMIT " + "%s" + " OFFSET " + "%s";

    public static final String soql_get_true_copies = "SELECT Id, Name, Template_Name_Link__c, Available_for_Preview__c, Original_can_be_Requested__c, eService_Administration__r.New_Edit_VF_Generator__c, eService_Administration__r.Redirect_Page__c, eService_Administration__r.Id, eService_Administration__r.Related_to_Object__c, eService_Administration__r.Display_Name__c, eService_Administration__r.Record_Type_Picklist__c, eService_Administration__r.Service_VF_Page__c FROM eServices_Document_Checklist__c WHERE eService_Administration__r.Related_to_Object__c = 'Registration' AND eService_Administration__r.RecordType.DeveloperName = 'Service_Request' AND eService_Administration__r.Is_Active__c = true AND eService_Administration__r.Sub_Category__c = 'Registration Services' ORDER BY Name LIMIT " + "%s" + " OFFSET " + "%s";

    public static final String soql_get_customer_documents = "SELECT Id, Name, Customer_Document__c, Attachment_Id__c, Version__c, CreatedDate, Document_Type__c, Party__r.Id, Party__r.Name, RecordType.Id, RecordType.Name, RecordType.DeveloperName, RecordType.SObjectType, Original_Verified__c, Original_Collected__c, Required_Original__c, Verified_Scan_Copy__c, Uploaded__c, Required_Scan_copy__c FROM Company_Documents__C WHERE Company__c = " + "\'" + "%s" + "\'" + " ORDER BY CreatedDate LIMIT %s OFFSET %s";

    private static SoqlStatements instance = null;

    protected SoqlStatements() {

    }

    public static SoqlStatements getInstance() {
        if (instance == null) {
            instance = new SoqlStatements();
        }
        return instance;
    }

    public String constructAccessCardSoqlStatement(String userDataAsString, String validity_status, int limit, int offset) {
        Gson gson = new Gson();
        User _user = gson.fromJson(userDataAsString, User.class);
        String soqlFormat;
        if (validity_status.equals("All")) {
            soqlFormat = "SELECT Id, Name, Personal_Photo__c, Card_Number__c, Status__c, " +
                    "Sponsor__c, Card_Type__c, Salutation__c, Card_Expiry_Date__c, " +
                    "Card_Issue_Date__c , Full_Name__c, Designation__c, Duration__c, " +
                    "Passport_Number__c, RecordType.Id, RecordType.Name, " +
                    "RecordType.DeveloperName, Nationality__r.Id, Nationality__r.Name " +
                    "FROM Card_Management__c WHERE Account__c = '%s' and Status__c " +
                    "NOT IN ('Renewed') AND Card_Type__c NOT IN ('Employee Card','Student Card')";
            soqlFormat = String.format(soqlFormat, _user.get_contact().get_account().getID());
        } else {
            soqlFormat = String.format(soql_get_access_card_page, _user.get_contact().get_account().getID(), validity_status);
        }
        return soqlFormat;
    }

    public String constructPermanentEmployeeSoqlStatement(String userDataAsString, String Visa_Validity_Status, int limit, int offset) {
        Gson gson = new Gson();
        User _user = gson.fromJson(userDataAsString, User.class);
        String soqlFormat;
        if (Visa_Validity_Status.equals("All")) {
            soqlFormat = "SELECT Id, Employee_ID__c, Personal_Photo__c, Salutation_Arabic__c, " +
                    "Applicant_Middle_Name_Arabic__c, Applicant_Last_Name_Arabic__c, " +
                    "Applicant_First_Name_Arabic__c, Religion__c, Applicant_Email__c, " +
                    "Applicant_Mobile_Number__c, Applicant_Gender__c, " +
                    "Passport_Country__c, Passport_Number__c, Passport_Expiry__c, " +
                    "Date_of_Birth__c, Salutation__c, Visa_Type__c, Visa_Expiry_Date__c, " +
                    "Applicant_Full_Name__c, Visa_Validity_Status__c, Accompanied_By__c, " +
                    "Visit_Visa_Duration__c, Country_of_Birth__r.Id, " +
                    "Country_of_Birth__r.Name, Current_Nationality__r.Id, " +
                    "Current_Nationality__r.Name, Job_Title_at_Immigration__r.Id, " +
                    "Job_Title_at_Immigration__r.Name, Sponsoring_Company__c, " +
                    "Sponsoring_Company__r.Name, Visa_Holder__c, Visa_Holder__r.Id, " +
                    "Visa_Holder__r.Name, Visa_Holder__r.BillingCity FROM Visa__c WHERE " +
                    "Sponsoring_Company__c = " + "\'" + "%s" + "\'" +
                    "AND Visa_Type__c IN ('Employment', 'Transfer - External', 'Transfer - " +
                    "Internal') ORDER BY Visa_Expiry_Date__c Limit " + limit + " Offset " + offset;
            soqlFormat = String.format(soqlFormat, _user.get_contact().get_account().getID());
        } else {
            soqlFormat = String.format(soql_get_permanent_employee_list_page, _user.get_contact().get_account().getID(), Visa_Validity_Status, limit, offset);
        }
        return soqlFormat;
    }

    public String constructEmployeeListStatement(String ID, int Limit, int Offset) {


        String soqlFormat;
        soqlFormat = "SELECT Id, Employee_ID__c, Personal_Photo__c, Salutation_Arabic__c, " +
                "Applicant_Middle_Name_Arabic__c, Applicant_Last_Name_Arabic__c, " +
                "Applicant_First_Name_Arabic__c, Religion__c, Applicant_Email__c, " +
                "Applicant_Mobile_Number__c, Applicant_Gender__c, " +
                "Passport_Country__c, Passport_Number__c, Passport_Expiry__c, " +
                "Date_of_Birth__c, Salutation__c, Visa_Type__c, Visa_Expiry_Date__c, " +
                "Applicant_Full_Name__c, Visa_Validity_Status__c, Accompanied_By__c, " +
                "Visit_Visa_Duration__c, Country_of_Birth__r.Id, " +
                "Country_of_Birth__r.Name, Current_Nationality__r.Id, " +
                "Current_Nationality__r.Name, Job_Title_at_Immigration__r.Id, " +
                "Job_Title_at_Immigration__r.Name, Sponsoring_Company__c, " +
                "Sponsoring_Company__r.Name, Visa_Holder__c, Visa_Holder__r.Id, " +
                "Visa_Holder__r.Name, Visa_Holder__r.BillingCity FROM Visa__c WHERE " +
                "Sponsoring_Company__c = " + "\'" + "%s" + "\'" + "AND Visa_Validity_Status__c LIKE " + "\'" + "%s" + "\'" +
                "AND Visa_Type__c IN ('Employment', 'Transfer - External', 'Transfer - " +
                "Internal') ORDER BY Visa_Expiry_Date__c" + " LIMIT " + Limit + " OFFSET " + Offset;

        soqlFormat = String.format(soql_get_permanent_employee_list_page, ID, "Issued");
        return soqlFormat;
    }

    public String constructVisitVisaSoqlStatement(String userDataAsString, String Visa_Validity_Status, int limit, int offset) {
        Gson gson = new Gson();
        User _user = gson.fromJson(userDataAsString, User.class);
        String soqlFormat;
        if (Visa_Validity_Status.equals("All")) {
            soqlFormat = "SELECT Id, Employee_ID__c, Personal_Photo__c, Salutation_Arabic__c, Applicant_Middle_Name_Arabic__c, Applicant_Last_Name_Arabic__c, Applicant_First_Name_Arabic__c, Religion__c, Applicant_Email__c, Applicant_Mobile_Number__c, Applicant_Gender__c, Passport_Country__c, Passport_Number__c, Passport_Expiry__c, Date_of_Birth__c, Salutation__c, Visa_Type__c, Visa_Expiry_Date__c, Applicant_Full_Name__c, Visa_Validity_Status__c, Accompanied_By__c, Visit_Visa_Duration__c, Country_of_Birth__r.Id, Country_of_Birth__r.Name, Current_Nationality__r.Id, Current_Nationality__r.Name, Job_Title_at_Immigration__r.Id, Job_Title_at_Immigration__r.Name, Sponsoring_Company__c, Sponsoring_Company__r.Name, Visa_Holder__c, Visa_Holder__r.Id, Visa_Holder__r.Name, Visa_Holder__r.BillingCity FROM Visa__c WHERE Sponsoring_Company__c = " + "\'" + "%s" + "\'" + " AND Visa_Type__c in ('Visit') ORDER BY Visa_Expiry_Date__c";
            soqlFormat = String.format(soqlFormat, _user.get_contact().get_account().getID());
        } else {
            soqlFormat = String.format(soql_get_visit_visa_page, _user.get_contact().get_account().getID(), Visa_Validity_Status);
        }
        return soqlFormat;
    }

    public String constructLicenseInfoStatement(String LicenseId) {
        return String.format(soql_get_activity_license_number, LicenseId);
    }

    public String constructRenewalLicenseQuery(String LicenseId) {
        return String.format(soql_get_renewal_for_license, LicenseId);
    }

    public String constructShareHoldersQuery(String AccountId, int Limit, int Offset) {
        String soql = String.format(soql_get_shareholders, AccountId) + " LIMIT " + Limit + " OFFSET " + Offset;
        return soql;
    }

    public String constructDirectorsQuery(String AccountId, int Limit, int Offset) {
        String soql = String.format(soql_getDirectors, AccountId) + " LIMIT " + Limit + " OFFSET " + Offset;
        return soql;
    }

    public String constructGeneralManagersQuery(String AccountId, int Limit, int Offset) {
        String soql = String.format(soql_generalManagers, AccountId) + " LIMIT " + Limit + " OFFSET " + Offset;
        return soql;
    }

    public String constructLegalRepresentativeQuery(String AccountId, int Limit, int Offset) {
        String soql = String.format(soql_legal_representatives, AccountId) + " LIMIT " + Limit + " OFFSET " + Offset;
        return soql;
    }

    public String constructNOCServiceQuery(Object object) {
        String soql = "";
        if (object instanceof Visa) {
            Visa visa = (Visa) object;
            soql = String.format(soql_get__employee_noc_service, "Both','" + visa.getApplicant_Gender__c(), Employee_WHERE_CLAUSE);
            Log.d("sql", soql);
        } else {
            User user = (User) object;
            soql = "SELECT ID, Name, Display_Name__c, Service_Identifier__c, Amount__c, Total_Amount__c, Related_to_Object__c, New_Edit_VF_Generator__c, Renewal_VF_Generator__c, Replace_VF_Generator__c, Cancel_VF_Generator__c, Record_Type_Picklist__c, (SELECT ID, Name, Type__c, Language__c, Document_Type__c, Authority__c FROM eServices_Document_Checklists__r) FROM Receipt_Template__c WHERE Is_Active__c = true " + Company_WHERE_CLAUSE + " ORDER BY Service_Identifier__c";
            Log.d("sql", soql);
        }
        return soql;
    }

    public String constructMyRequestsServiceQuery(String accountId, String status, String type, int Limit, int Offset) {
        String soql = "";
        if (status.equals("All") && type.equals("All")) {
            soql = "SELECT Id, CaseNumber, Status, Type, Web_Form__c, CreatedDate, Sub_Type__c, Sub_Type_Formula__c, RecordType.Id, RecordType.Name, RecordType.DeveloperName, RecordType.SobjectType, Employee_Ref__r.Id, Employee_Ref__r.Name FROM Case WHERE " +
                    "AccountId = " + "\'" + "%s" + "\'" + " LIMIT " + Limit + " OFFSET " + Offset;
            soql = String.format(soql, accountId);
        } else if (!status.equals("All") && !type.equals("All")) {
            soql = String.format(soql_get_my_requests, accountId, status, type) + " LIMIT " + Limit + " OFFSET " + Offset;
        } else if (!status.equals("All") && type.equals("All")) {
            soql = "SELECT Id, CaseNumber, Status, Type, Web_Form__c, CreatedDate, Sub_Type__c, Sub_Type_Formula__c, RecordType.Id, RecordType.Name, RecordType.DeveloperName, RecordType.SobjectType, Employee_Ref__r.Id, Employee_Ref__r.Name FROM Case " +
                    "WHERE AccountId = " + "\'" + "%s" + "\'" + " AND Status LIKE " + "\'" + "%s" + "\'" + " LIMIT " + Limit + " OFFSET " + Offset;
            soql = String.format(soql, accountId, status);
        } else if (status.equals("All") && !type.equals("All")) {
            soql = "SELECT Id, CaseNumber, Status, Type, Web_Form__c, CreatedDate, Sub_Type__c, Sub_Type_Formula__c, RecordType.Id, RecordType.Name, RecordType.DeveloperName, RecordType.SobjectType, Employee_Ref__r.Id, Employee_Ref__r.Name FROM Case " +
                    "WHERE AccountId = " + "\'" + "%s" + "\'" + " AND Type LIKE " + "\'" + "%s" + "\'" + " LIMIT " + Limit + " OFFSET " + Offset;

            soql = String.format(soql, accountId, type);
        }
        return soql;
    }

    public String constructNotificationsServiceQuery(String accountId, int limit, int offset) {
        String soql = "";
        if (!accountId.equals("") && accountId != null) {
            soql = String.format(soql_get_my_notifications, accountId, limit, offset);
        }
        return soql;
    }


    public String constructWebFormQuery(String webFormID) {
        String soql = String.format(soql_get_NOC_WebForm, webFormID);
        return soql;
    }

    public String constructCompanyDocumentsQuery(String ObjectID) {
        String soql = String.format(soql_get_company_documents, ObjectID);
        return soql;
    }

    public String constructCompanyDocumentsRecordType() {
        return soql_get_record_type_company_documents;
    }

    public static String getCaseNumberQuery(String caseId) {
        String SQL = "select CaseNumber,Service_Requested__c from Case where Id='%s'";
        return String.format(SQL, caseId);
    }

    public static String constructViewStatementQuery(String id, int offset, int limit, String queryFilter) {
        String soql = "";
        if (queryFilter != null && !queryFilter.equals("")) {
            soql = String.format(soql_view_statement, id, queryFilter, limit, offset);
        } else {
            soql = "SELECT Id, Name, CreatedDate, Transaction_Date__c, Paypal_Amount__c, Status__c, Payment_Type__c, Debit_Amount__c, Credit_Amount__c, Closing_Balance__C, Narrative__c, Effect_on_Account__c, Request__r.Employee_Ref__r.Name FROM Free_Zone_Payment__c WHERE Free_Zone_Customer__c = " + "\'" + "%s" + "\'" + " AND Effect_on_Account__c IN ('Credit', 'Debit') " + " LIMIT " + "%s" + " OFFSET " + "%s";
            soql = String.format(soql, id, limit, offset);
        }
        return soql;
    }

    public static String constructTrueCopiesQuery(int offset, int limit) {
        String soql = String.format(soql_get_true_copies, limit, offset);
        return soql;
    }

    public static String constructCustomerDocumentsQuery(String accountId, int offset, int limit) {
        String soql = String.format(soql_get_customer_documents, accountId, limit, offset);
        return soql;
    }
}