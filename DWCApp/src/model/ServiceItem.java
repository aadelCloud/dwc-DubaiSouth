package model;

/**
 * Created by Abanoub on 6/26/2015.
 */
public class ServiceItem {

    int drawableIcon;
    String tvServiceName;

    public ServiceItem() {

    }

    public ServiceItem(String text, int icon) {
        this.drawableIcon = icon;
        this.tvServiceName = text;
    }

    public int getDrawableIcon() {
        return drawableIcon;
    }

    public void setDrawableIcon(int drawableIcon) {
        this.drawableIcon = drawableIcon;
    }

    public String getTvServiceName() {
        return tvServiceName;
    }

    public void setTvServiceName(String tvServiceName) {
        this.tvServiceName = tvServiceName;
    }
}
