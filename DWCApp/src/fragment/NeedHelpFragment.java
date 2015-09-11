package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.gson.Gson;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.rest.ClientManager;
import com.salesforce.androidsdk.rest.RestClient;
import com.salesforce.androidsdk.rest.RestRequest;
import com.salesforce.androidsdk.rest.RestResponse;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import RestAPI.JSONConstants;
import RestAPI.SFResponseManager;
import cloudconcept.dwc.R;
import custom.MaterialSpinner;
import utilities.ActivitiesLauncher;
import utilities.Utilities;

/**
 * Created by Bibo on 7/29/2015.
 */
public class NeedHelpFragment extends Fragment implements View.OnClickListener {

    static String[] needHelpValues;
    Spinner spinnerNeedHelp;
    EditText etCaseSubject;
    EditText etDescription;
    Button btnSubmit;
    private String caseRecordTypeId;
    private RestRequest restRequest;
    RestClient clientManager;
    String NeedHelpCategory = "";

    public static Fragment newInstance(String s) {
        NeedHelpFragment fragment = new NeedHelpFragment();
        Bundle bundle = new Bundle();
        bundle.putString("FragmentName", s);
        needHelpValues = new String[]{"Inquiry", "Suggestion", "Complaint"};
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.need_help, container, false);
        InitializeViews(view);
        loadCaseRecordType();
        return view;
    }

    private void InitializeViews(View view) {
        etCaseSubject = (EditText) view.findViewById(R.id.etCaseSubject);
        etDescription = (EditText) view.findViewById(R.id.etDescription);
        btnSubmit = (Button) view.findViewById(R.id.btnSubmit);
        spinnerNeedHelp = (Spinner) view.findViewById(R.id.spinnetNeedHelpType);
        btnSubmit.setOnClickListener(this);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, needHelpValues);
        spinnerNeedHelp.setAdapter(adapter);
        spinnerNeedHelp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                NeedHelpCategory = (String) spinnerNeedHelp.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private void loadCaseRecordType() {

        final String soqlQuery = "SELECT Id, Name, DeveloperName, SobjectType FROM RecordType WHERE SObjectType = 'Case' AND DeveloperName = 'Customer_Inquiry'";

        new ClientManager(getActivity(), SalesforceSDKManager.getInstance().getAccountType(), SalesforceSDKManager.getInstance().getLoginOptions(), SalesforceSDKManager.getInstance().shouldLogoutWhenTokenRevoked()).getRestClient(getActivity(), new ClientManager.RestClientCallback() {
            @Override
            public void authenticatedRestClient(RestClient client) {
                try {
                    restRequest = RestRequest.getRequestForQuery(
                            getActivity().getString(R.string.api_version), soqlQuery);
                    if (client == null) {
                        SalesforceSDKManager.getInstance().logout(getActivity());
                        return;
                    } else {

                        clientManager = client;
                        client.sendAsync(restRequest, new RestClient.AsyncRequestCallback() {

                            @Override
                            public void onSuccess(RestRequest request, RestResponse response) {
                                Utilities.dismissLoadingDialog();
                                caseRecordTypeId = SFResponseManager.parseNeedHelpService(response.toString());
                            }

                            @Override
                            public void onError(Exception exception) {
                                Utilities.showToast(getActivity(), "Please Check Your internet connection");
                            }
                        });
                    }
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v == btnSubmit) {
            ValidateFields();
        }
    }

    private void ValidateFields() {

        if (etCaseSubject.getText().toString().equals("") || etDescription.getText().toString().equals("") || NeedHelpCategory.equals("")) {
            Utilities.showToast(getActivity(), "Please fill the required fields");
            return;
        } else {

            Gson gson = new Gson();
            Map<String, Object> fields = new HashMap<String, Object>();
            fields.put("Type", NeedHelpCategory);
            fields.put("ContactId", Utilities.getUserObject(getActivity().getApplicationContext()).getContactId());
            fields.put("AccountId", Utilities.getUserObject(getActivity().getApplicationContext()).get_contact().get_account().getID());
            fields.put("Subject", etCaseSubject.getText().toString());
            fields.put("Description", etDescription.getText().toString());
            fields.put("RecordTypeId", caseRecordTypeId);
            sendRequestNeedHelpService(fields);
        }
    }

    private void sendRequestNeedHelpService(Map<String, Object> fields) {
        Utilities.showloadingDialog(getActivity());
        try {
            restRequest =
                    RestRequest.getRequestForCreate(getActivity().getResources().getString(R.string.api_version), "Case", fields);

            clientManager.sendAsync(restRequest, new RestClient.AsyncRequestCallback() {
                @Override
                public void onSuccess(RestRequest request, RestResponse response) {
                    Log.d("", response.toString());
                    try {
                        JSONObject json = new JSONObject(response.toString());
                        String caseNumber = json.getString("id");
                        String soqlQuery = "SELECT Id, CaseNumber FROM Case WHERE ID =" + "\'" + caseNumber + "\'";
                        try {
                            restRequest = RestRequest.getRequestForQuery(
                                    getActivity().getString(R.string.api_version), soqlQuery);
                            if (clientManager == null) {
                                SalesforceSDKManager.getInstance().logout(getActivity());
                                return;
                            } else {

                                clientManager.sendAsync(restRequest, new RestClient.AsyncRequestCallback() {

                                    @Override
                                    public void onSuccess(RestRequest request, RestResponse response) {
                                        try {
                                            JSONObject jsonObject = new JSONObject(response.toString());
                                            String CaseNumber = jsonObject.getJSONArray(JSONConstants.RECORDS).getJSONObject(0).getString("CaseNumber");
                                            String Message = getActivity().getResources().getString(R.string.NeedHelpThankYouMessage);
                                            ActivitiesLauncher.openThankYouActivity(getActivity(), getActivity().getApplicationContext(), String.format(Message, CaseNumber));
                                            Utilities.dismissLoadingDialog();
                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                            Utilities.dismissLoadingDialog();
                                        }
                                    }

                                    @Override
                                    public void onError(Exception exception) {
                                        Utilities.showToast(getActivity(), "Please Check Your internet connection");
                                        Utilities.dismissLoadingDialog();
                                    }
                                });
                            }
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onError(Exception exception) {

                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        Utilities.dismissLoadingDialog();
    }
}
