package model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Abanoub on 7/7/2015.
 */
public class Shareholder implements Serializable {

    String url;
    @SerializedName("Id")
    String ID;
    @SerializedName("Name")
    String Name;
    @SerializedName("Nationality__c")
    String Nationality;
    @SerializedName("Personal_Photo__pc")
    String PersonalPhoto;
    CurrentPassport _currentPassport;

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

    public String getNationality() {
        return Nationality;
    }

    public void setNationality(String nationality) {
        Nationality = nationality;
    }

    public String getPersonalPhoto() {
        return PersonalPhoto;
    }

    public void setPersonalPhoto(String personalPhoto) {
        PersonalPhoto = personalPhoto;
    }

    public CurrentPassport get_currentPassport() {
        return _currentPassport;
    }

    public void set_currentPassport(CurrentPassport _currentPassport) {
        this._currentPassport = _currentPassport;
    }
}
