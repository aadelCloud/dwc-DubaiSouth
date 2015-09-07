package model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Abanoub on 7/5/2015.
 */
public class LicenseActivity {

    public String url;

    @SerializedName("Id")
    private String ID;

    @SerializedName("Name")
    private String Name;
    @SerializedName("Status__c")
    private String Status;
    @SerializedName("Start_Date__c")
    private String StartDate;
    @SerializedName("End_Date__c")
    private String EndDate;

    private OriginalBusinessActivity _originalBusinessActivity;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String startDate) {
        StartDate = startDate;
    }

    public String getEndDate() {
        return EndDate;
    }

    public void setEndDate(String endDate) {
        EndDate = endDate;
    }

    public OriginalBusinessActivity get_originalBusinessActivity() {
        return _originalBusinessActivity;
    }

    public void set_originalBusinessActivity(OriginalBusinessActivity _originalBusinessActivity) {
        this._originalBusinessActivity = _originalBusinessActivity;
    }
}
