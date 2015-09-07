package model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Abanoub on 7/7/2015.
 */
public class Manager {

    String url;
    @SerializedName("Id")
    String ID;
    @SerializedName("Name")
    String Name;
    @SerializedName("Personal_Photo__pc")
    String Personal_Photo;
    @SerializedName("Nationality__c")
    String Nationality;

    CurrentPassport currentPassport;

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

    public String getPersonal_Photo() {
        return Personal_Photo;
    }

    public void setPersonal_Photo(String personal_Photo) {
        Personal_Photo = personal_Photo;
    }

    public String getNationality() {
        return Nationality;
    }

    public void setNationality(String nationality) {
        Nationality = nationality;
    }

    public CurrentPassport getCurrentPassport() {
        return currentPassport;
    }

    public void setCurrentPassport(CurrentPassport currentPassport) {
        this.currentPassport = currentPassport;
    }
}
