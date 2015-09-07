package model;

import java.io.Serializable;

/**
 * Created by M_Ghareeb on 8/10/2015.
 */
public class attributes implements Serializable{
    String type;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    String url;
}
