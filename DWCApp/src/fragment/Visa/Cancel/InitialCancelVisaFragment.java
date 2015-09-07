package fragment.Visa.Cancel;

import android.app.DatePickerDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.android.volley.NetworkResponse;
import com.android.volley.VolleyError;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.rest.ClientManager;
import com.salesforce.androidsdk.rest.RestClient;
import com.salesforce.androidsdk.rest.RestRequest;
import com.salesforce.androidsdk.rest.RestResponse;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import RestAPI.SFResponseManager;
import RestAPI.SoqlStatements;
import adapter.NationalityAdapter;
import cloudconcept.dwc.R;
import fragmentActivity.VisaActivity;
import model.Country__c;
import model.CurrentNationality;
import model.Receipt_Template__c;
import model.Visa;
import utilities.Utilities;

/**
 * Created by M_Ghareeb on 9/1/2015.
 */
public class InitialCancelVisaFragment extends Fragment {
    EditText Name, ArabicName, Gender, Dateofbirth, BirthCountry,
            PlaceCountry, Email, mobile, Maritalstatus, mothername,
            currentnationality, Previousnationality, religion, languagesspoken,
            passportno, dateofexpiry,countryofissue, placeofissue;
    private RestRequest restRequest;
    private ArrayList<Receipt_Template__c> eServiceAdministrations;
    private String objectType;
    private String DeveloperName;
    private VisaActivity activity;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_initial_cancel_visa, container, false);
        activity = (VisaActivity) getActivity();
        InitializeViews(view);
        return null;
    }

    private void InitializeViews(View view) {
        Name = (EditText) view.findViewById(R.id.Name);
        ArabicName = (EditText) view.findViewById(R.id.ArabicName);
        Gender = (EditText) view.findViewById(R.id.Gender);
        Dateofbirth = (EditText) view.findViewById(R.id.Dateofbirth);
        BirthCountry = (EditText) view.findViewById(R.id.BirthCountry);
        PlaceCountry = (EditText) view.findViewById(R.id.PlaceCountry);
        Email = (EditText) view.findViewById(R.id.Email);
        mobile = (EditText) view.findViewById(R.id.mobile);
        Maritalstatus = (EditText) view.findViewById(R.id.Maritalstatus);
        mothername = (EditText) view.findViewById(R.id.mothername);
        currentnationality = (EditText) view.findViewById(R.id.currentnationality);
        Previousnationality = (EditText) view.findViewById(R.id.Previousnationality);
        religion = (EditText) view.findViewById(R.id.religion);
        languagesspoken = (EditText) view.findViewById(R.id.languagesspoken);
        passportno = (EditText) view.findViewById(R.id.passportno);
        dateofexpiry = (EditText) view.findViewById(R.id.dateofexpiry);
        countryofissue = (EditText) view.findViewById(R.id.countryofissue);
        placeofissue = (EditText) view.findViewById(R.id.placeofissue);

        new ClientManager(getActivity(), SalesforceSDKManager.getInstance().getAccountType(), SalesforceSDKManager.getInstance().getLoginOptions(), SalesforceSDKManager.getInstance().shouldLogoutWhenTokenRevoked()).getRestClient(getActivity(), new ClientManager.RestClientCallback() {
            @Override
            public void authenticatedRestClient(RestClient client) {
                if (client == null) {
                    SalesforceSDKManager.getInstance().logout(getActivity());
                    return;
                } else {
                    execution(client);
                }
            }
        });
    }
    public static Fragment newInstance(String RenewVisa) {
        InitialCancelVisaFragment fragment = new InitialCancelVisaFragment();
        Bundle bundle = new Bundle();
        bundle.putString("text", RenewVisa);
        fragment.setArguments(bundle);
        return fragment;
    }



    protected void execution(RestClient client) {


        String SoqlVisaQuery = String.format(SoqlStatements.renewVisaSQL, activity.getVisa().getID());
        try {
            restRequest = RestRequest.getRequestForQuery(getActivity().getString(R.string.api_version), SoqlVisaQuery);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        client.sendAsync(restRequest, new RestClient.AsyncRequestCallback() {
            @Override
            public void onSuccess(RestRequest request, RestResponse response) {

                List<Visa> visa = SFResponseManager.parseVisaData(response.toString());
                activity.setVisa(visa.get(0));

                Name.setText(activity.getVisa().getApplicant_Full_Name__c());
                ArabicName.setText(activity.getVisa().getApplicant_Full_Name_Arabic__c());
                Gender.setText(activity.getVisa().getApplicant_Gender__c());
                Dateofbirth.setText(activity.getVisa().getDate_of_Birth__c());
                BirthCountry.setText(activity.getVisa().getCountry_of_Birth__r().getName());
                PlaceCountry.setText(activity.getVisa().getPlace_of_Birth__c());
                Email.setText(activity.getVisa().getApplicant_Email__c());

                mobile.setText(activity.getVisa().getApplicant_Mobile_Number__c());

                Maritalstatus.setText(activity.getVisa().getMarital_Status__c());

                mothername.setText(activity.getVisa().getMother_Name__c());

                currentnationality.setText(activity.getVisa().getCurrent_Nationality__r().getName());
                Previousnationality.setText(activity.getVisa().getPrevious_Nationality__r().getName());
                religion.setText(activity.getVisa().getReligion__c());

                languagesspoken.setText(activity.getVisa().getLanguages__c());

                passportno.setText(activity.getVisa().getPassport_Number__c());

                dateofexpiry.setText(activity.getVisa().getVisa_Expiry_Date__c());

                countryofissue.setText(activity.getVisa().getPassport_Issue_Country__r().getName());

                placeofissue.setText(activity.getVisa().getPassport_Place_of_Issue__c());

                Utilities.dismissLoadingDialog();
            }

            @Override
            public void onError(Exception exception) {
                VolleyError volleyError = (VolleyError) exception;
                NetworkResponse response = volleyError.networkResponse;
                String json = new String(response.data);
                Log.d("", json);
                Utilities.dismissLoadingDialog();
                getActivity().finish();
            }
        });


    }

}
