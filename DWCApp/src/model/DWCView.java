package model;

/**
 * Created by Abanoub on 7/4/2015.
 */
public class DWCView {

    String value;
    ItemType type;

    public DWCView(String value, ItemType type) {
        this.value = value;
        this.type = type;
    }

    public ItemType getType() {
        return type;
    }


    public String getValue() {

        return value;
    }
}
