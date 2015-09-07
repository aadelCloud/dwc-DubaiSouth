package model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Bibo on 8/2/2015.
 */
public class WebForm {

    @SerializedName("Id")
    String ID;
    @SerializedName("url")
    String url;
    @SerializedName("Name")
    String Name;
    @SerializedName("Description__c")
    String Description;
    @SerializedName("Title__c")
    String Title;
    @SerializedName("isNotesAttachments__c")
    boolean isNotesAttachments;
    @SerializedName("Object_Label__c")
    String Object_Label;
    @SerializedName("Object_Name__c")
    String Object_Name;

    ArrayList<FormField> _formFields;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public boolean isNotesAttachments() {
        return isNotesAttachments;
    }

    public void setIsNotesAttachments(boolean isNotesAttachments) {
        this.isNotesAttachments = isNotesAttachments;
    }

    public String getObject_Label() {
        return Object_Label;
    }

    public void setObject_Label(String object_Label) {
        Object_Label = object_Label;
    }

    public String getObject_Name() {
        return Object_Name;
    }

    public void setObject_Name(String object_Name) {
        Object_Name = object_Name;
    }

    public ArrayList<FormField> get_formFields() {
        return _formFields;
    }

    public void set_formFields(ArrayList<FormField> _formFields) {
        this._formFields = _formFields;
    }
}
