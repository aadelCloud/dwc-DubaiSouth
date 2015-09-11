package fragmentActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;

import com.android.volley.NetworkResponse;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.rest.ClientManager;
import com.salesforce.androidsdk.rest.RestClient;
import com.salesforce.androidsdk.rest.RestRequest;
import com.salesforce.androidsdk.rest.RestResponse;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import RestAPI.RestMessages;
import cloudconcept.dwc.BaseActivity;
import cloudconcept.dwc.R;
import dataStorage.StoreData;
import fragment.PreviewFragment;
import fragmentActivity.CompanyNOC.CompanyNOCAttachmentPage;
import model.Company_Documents__c;
import utilities.Utilities;

/**
 * Created by Abanoub Wagdy on 9/9/2015.
 */
public class PreviewActivity extends BaseActivity {

    @Override
    public int getNotificationVisibillity() {
        return View.GONE;
    }

    @Override
    public int getMenuVisibillity() {
        return View.GONE;
    }

    @Override
    public int getBackVisibillity() {
        return View.VISIBLE;
    }

    @Override
    public String getHeaderTitle() {
        return "Preview";
    }

    @Override
    public Fragment GetFragment() {
        Fragment fragment = PreviewFragment.newInstance(getApplicationContext(), getIntent().getExtras().getString("object"), getIntent().getExtras().getString("type"));
        return fragment;
    }
}
