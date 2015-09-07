package dataStorage;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class StoreData {
    private Context context;
    String DATABASE_NAME = "DWC";
    private SharedPreferences sharedPreferences;
    private Editor editor;
    String TAG = "StoreData";

    public StoreData(Context ctx) {
        super();
        this.context = ctx;

        sharedPreferences = context.getSharedPreferences(DATABASE_NAME,
                Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void saveUserID(String ID) {
        editor.putString("UserID", ID);
        editor.commit();
    }

    public String getUserID() {
        String UserID = sharedPreferences.getString("UserID",
                "");
        return UserID;
    }

    public synchronized void setCompanyRestResponse(String s) {
        editor.putString("CompanyRestResponse", s);
        editor.commit();
    }

    public synchronized String getCompanyRestResponse() {
        String UserID = sharedPreferences.getString("CompanyRestResponse",
                "");
        return UserID;
    }

    public void setUsername(String name) {
        editor.putString("Username", name);
        editor.commit();
    }

    public synchronized String getUsername() {
        String UserID = sharedPreferences.getString("Username",
                "");
        return UserID;
    }

    public synchronized void setUserDataAsString(String json) {
        editor.putString("jsonUser", json);
        editor.commit();
    }

    public synchronized String getUserDataAsString() {
        String UserData = sharedPreferences.getString("jsonUser",
                "");
        return UserData;
    }

    public void setNotificationCount(String s) {

        editor.putString("notificationCount", s);
        editor.commit();
    }

    public synchronized int getNotificationCount() {

        int NotificationCount = Integer.valueOf(sharedPreferences.getString("notificationCount",
                ""));
        return NotificationCount;
    }

    public synchronized void saveNocType(String selectedItem) {
        editor.putString("noc_type", selectedItem);
        editor.commit();
    }

    public synchronized String getNocType() {
        String noc_type = sharedPreferences.getString("noc_type",
                "");
        return noc_type;
    }

    public synchronized void saveNOCAuthorityType(String selectedItem) {
        editor.putString("noc__authority_type", selectedItem);
        editor.commit();
    }

    public synchronized String getNOCAuthorityType() {
        String noc__authority_type = sharedPreferences.getString("noc__authority_type",
                "");
        return noc__authority_type;
    }

    public void saveNOCLanguage(String selectedItem) {
        editor.putString("noc__language", selectedItem);
        editor.commit();
    }

    public synchronized String getNOCLanguage() {
        String noc__language = sharedPreferences.getString("noc__language",
                "");
        return noc__language;
    }

    public void setIsLoadedInitialEmployeeNOCPage(boolean b) {

        editor.putBoolean("InitialEmployeeNOCPage", b);
        editor.commit();
    }

    public synchronized boolean getIsLoadedInitialEmployeeNOCPage() {
        boolean b = sharedPreferences.getBoolean("InitialEmployeeNOCPage",
                false);
        return b;
    }

    public void setPickListSelected(String key, String entry) {
        editor.putString(key, entry);
        editor.commit();
    }

    public synchronized String getPickListSelected(String key) {
        String b = sharedPreferences.getString(key,
                "");
        return b;
    }

    public void setCheckBoxSelected(String s, boolean b) {
        editor.putBoolean(s, b);
        editor.commit();
    }

    public synchronized boolean getIsLoadedInitialEmployeeNOCPage(String s) {
        boolean b = sharedPreferences.getBoolean(s,
                false);
        return b;
    }

    public void setCompanyDocumentObject(String s) {
        editor.putString("CompanyDocumentObject", s);
        editor.commit();
    }

    public String getCompanyDocumentObject() {
        String b = sharedPreferences.getString("CompanyDocumentObject",
                "");
        return b;
    }

    public void setCompanyDocumentPosition(int position) {
        editor.putString("CompanyDocumentPosition", String.valueOf(position));
        editor.commit();
    }

    public String getCompanyDocumentPosition() {
        String b = sharedPreferences.getString("CompanyDocumentPosition",
                "");
        return b;
    }
}
