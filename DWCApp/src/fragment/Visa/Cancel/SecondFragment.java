package fragment.Visa.Cancel;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;

import com.android.volley.NetworkResponse;
import com.android.volley.VolleyError;
import com.gc.materialdesign.views.Switch;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.rest.ClientManager;
import com.salesforce.androidsdk.rest.RestClient;
import com.salesforce.androidsdk.rest.RestRequest;
import com.salesforce.androidsdk.rest.RestResponse;

import org.json.JSONException;

import java.io.UnsupportedEncodingException;
import java.util.List;

import RestAPI.SFResponseManager;
import RestAPI.SoqlStatements;
import adapter.JobAdapters;
import cloudconcept.dwc.R;
import fragmentActivity.VisaActivity;
import model.Visa;
import utilities.Utilities;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link SecondFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SecondFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    EditText visaNumber, visaHolderName;
    EditText passportNumber, visaExpiryDate;
    Switch UrgentStamping;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private VisaActivity activity;
    private RestRequest restRequest;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SecondFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SecondFragment newInstance(String param1, String param2) {
        SecondFragment fragment = new SecondFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public SecondFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        activity = (VisaActivity) getActivity();
        View view = inflater.inflate(R.layout.fragment_second_cancel_visa, container, false);
        visaNumber = (EditText) view.findViewById(R.id.visaNumber);
        visaHolderName = (EditText) view.findViewById(R.id.visaHolderName);
        passportNumber = (EditText) view.findViewById(R.id.passportNumber);
        visaExpiryDate = (EditText) view.findViewById(R.id.visaExpiryDate);
        UrgentStamping = (Switch) view.findViewById(R.id.UrgentStamping);
        Utilities.showloadingDialog(activity);
        new ClientManager(getActivity(), SalesforceSDKManager.getInstance().getAccountType(), SalesforceSDKManager.getInstance().getLoginOptions(), SalesforceSDKManager.getInstance().shouldLogoutWhenTokenRevoked()).getRestClient(getActivity(), new ClientManager.RestClientCallback() {
            @Override
            public void authenticatedRestClient(RestClient client) {
                if (client == null) {
                    SalesforceSDKManager.getInstance().logout(getActivity());
                    Utilities.dismissLoadingDialog();
                    return;
                } else {
                    execution(client);
                }
            }
        });


        return view;
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
                visaNumber.setText(activity.getVisa().getID());

                visaHolderName.setText(activity.getVisa().getVisa_Holder__r().getName() + "");

                passportNumber.setText(activity.getVisa().getPassport_Number__c());

                visaExpiryDate.setText(activity.getVisa().getVisa_Expiry_Date__c());
                UrgentStamping.setOncheckListener(new Switch.OnCheckListener() {
                    @Override
                    public void onCheck(Switch aSwitch, boolean b) {
                        activity.getVisa().Urgent_Stamping_Paid__c = b;
                    }
                });
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