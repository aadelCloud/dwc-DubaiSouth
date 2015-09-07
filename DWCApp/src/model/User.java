package model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Abanoub on 6/16/2015.
 */
public class User implements Serializable{

    @SerializedName("url")
    private String url;

    @SerializedName("ContactId")
    private String ContactId;

    private Contact _contact;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContactId() {
        return ContactId;
    }

    public void setContactId(String contactId) {
        ContactId = contactId;
    }

    public Contact get_contact() {
        return _contact;
    }

    public void set_contact(Contact _contact) {
        this._contact = _contact;
    }
}
