package model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Bibo on 7/28/2015.
 */
public class NotificationManagement {
    @SerializedName("url")
    String url;
    @SerializedName("Id")
    String Id;
    @SerializedName("Name")
    String Name;
    @SerializedName("isFeedbackAllowed__c")
    boolean isFeedbackAllowed;
    @SerializedName("Case_Process_Name__c")
    String Case_Process_Name;
    @SerializedName("Case_Status__c")
    String Case_Status;
    @SerializedName("isMessageRead__c")
    boolean isMessageRead;
    @SerializedName("Is_Push_Notification_Allowed__c")
    boolean Is_Push_Notification_Allowed;
    @SerializedName("Notification_Message__c")
    String Notification_Message;
    @SerializedName("Prior_Value__c")
    String Prior_Value;
    @SerializedName("Read_Date_and_Time__c")
    String Read_Date_and_Time;
    @SerializedName("Compiled_Message__c")
    String Compiled_Message;
    @SerializedName("Mobile_Compiled_Message__c")
    String Mobile_Compiled_Message;
    @SerializedName("CreatedDate")
    String CreatedDate;

    Case caseNotification;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public boolean isFeedbackAllowed() {
        return isFeedbackAllowed;
    }

    public void setIsFeedbackAllowed(boolean isFeedbackAllowed) {
        this.isFeedbackAllowed = isFeedbackAllowed;
    }

    public String getCase_Process_Name() {
        return Case_Process_Name;
    }

    public void setCase_Process_Name(String case_Process_Name) {
        Case_Process_Name = case_Process_Name;
    }

    public String getCase_Status() {
        return Case_Status;
    }

    public void setCase_Status(String case_Status) {
        Case_Status = case_Status;
    }

    public boolean isMessageRead() {
        return isMessageRead;
    }

    public void setIsMessageRead(boolean isMessageRead) {
        this.isMessageRead = isMessageRead;
    }

    public boolean is_Push_Notification_Allowed() {
        return Is_Push_Notification_Allowed;
    }

    public void setIs_Push_Notification_Allowed(boolean is_Push_Notification_Allowed) {
        Is_Push_Notification_Allowed = is_Push_Notification_Allowed;
    }

    public String getNotification_Message() {
        return Notification_Message;
    }

    public void setNotification_Message(String notification_Message) {
        Notification_Message = notification_Message;
    }

    public String getPrior_Value() {
        return Prior_Value;
    }

    public void setPrior_Value(String prior_Value) {
        Prior_Value = prior_Value;
    }

    public String getRead_Date_and_Time() {
        return Read_Date_and_Time;
    }

    public void setRead_Date_and_Time(String read_Date_and_Time) {
        Read_Date_and_Time = read_Date_and_Time;
    }

    public String getCompiled_Message() {
        return Compiled_Message;
    }

    public void setCompiled_Message(String compiled_Message) {
        Compiled_Message = compiled_Message;
    }

    public String getMobile_Compiled_Message() {
        return Mobile_Compiled_Message;
    }

    public void setMobile_Compiled_Message(String mobile_Compiled_Message) {
        Mobile_Compiled_Message = mobile_Compiled_Message;
    }

    public String getCreatedDate() {
        return CreatedDate;
    }

    public void setCreatedDate(String createdDate) {
        CreatedDate = createdDate;
    }

    public Case getCaseNotification() {
        return caseNotification;
    }

    public void setCaseNotification(Case caseNotification) {
        this.caseNotification = caseNotification;
    }
}
