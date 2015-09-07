package model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Bibo on 7/26/2015.
 */
public class EmployeeRef {
    @SerializedName("url")
    String url;
    @SerializedName("Id")
    String Id;
    @SerializedName("Name")
    String Name;

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
}
