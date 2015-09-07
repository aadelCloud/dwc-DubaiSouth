package fragment.Cards.CancelCard;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.rest.ClientManager;
import com.salesforce.androidsdk.rest.RestClient;
import com.salesforce.androidsdk.rest.RestRequest;
import com.salesforce.androidsdk.rest.RestResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import RestAPI.JSONConstants;
import RestAPI.RestMessages;
import RestAPI.SFResponseManager;
import cloudconcept.dwc.R;
import fragmentActivity.CardActivity;
import model.Card_Management__c;
import model.Receipt_Template__c;
import utilities.Utilities;

/**
 * Created by M_Ghareeb on 8/26/2015.
 */
public class CancelCardInitialPage extends Fragment {
    String[] FM_Contractor_Pass_elements = new String[]{"1 Month", "3 Months", "6 Months", "1 Year"};
    String[] Contractor_Pass_elements = new String[]{"1 Week", "1 Month", "2 Months", "3 Months", "4 Months", "5 Months", "6 Months", "1 Year"};
    String[] Access_Card_elements = new String[]{"1 Day", "1 Month", "3 Months", "6 Months", "1 Year"};
    String[] Card_Type_Elements = new String[]{"FM Contractor Pass", "Contractor Pass", "Access Card"};
    EditText etCardType, etRecordToProcess;
    Card_Management__c card;
    CardActivity activity;
    String query = "SELECT Id, Name, DeveloperName, SobjectType FROM RecordType WHERE (SobjectType = 'Case' AND DeveloperName = 'Access_Card_Request') OR (SObjectType = 'Card_Management__c')";
    private RestRequest restRequest;
    private String objectType;
    private String DeveloperName;
    private ArrayList<Receipt_Template__c> eServiceAdministrations;
    String CardQuery = "SELECT ID, Name, Display_Name__c, Service_Identifier__c, Amount__c, Total_Amount__c, Related_to_Object__c, New_Edit_VF_Generator__c, Renewal_VF_Generator__c, Replace_VF_Generator__c, Cancel_VF_Generator__c, Record_Type_Picklist__c, (SELECT ID, Name, Type__c, Language__c, Document_Type__c, Authority__c FROM eServices_Document_Checklists__r) FROM Receipt_Template__c WHERE Is_Active__c = true AND Duration__c = " + "\'" + "%s" + "\'" + " AND Record_Type_Picklist__c = " + "\'" + "%s" + "\'";
    private TextView tvDuration;private Spinner spinnerDuration;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cancel_card_first_page, container, false);
        InitializeViews(view);
        return view;
    }

    private void InitializeViews(View view) {
        activity = (CardActivity) getActivity();
        card = activity.getCard();
        activity.setCardType(card.getCard_Type__c());
        activity.setDuration(card.getDuration__c());
        tvDuration = (TextView) view.findViewById(R.id.tvDuration);
        spinnerDuration = (Spinner) view.findViewById(R.id.spinnerDuration);
        etCardType = (EditText) view.findViewById(R.id.etCardType);
        etRecordToProcess = (EditText) view.findViewById(R.id.etRecordToProcess);
        etCardType.setKeyListener(null);
        etRecordToProcess.setKeyListener(null);
        etCardType.setText(card.getCard_Type__c());
        etRecordToProcess.setText(card.getCard_Number__c());
        if (activity.getType().equals("3")) {
            tvDuration.setVisibility(View.VISIBLE);
            spinnerDuration.setVisibility(View.VISIBLE);
            if (activity.getCard().getCard_Type__c().equals(Card_Type_Elements[0])) {

                ArrayAdapter<String> adapterAccessCard = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, FM_Contractor_Pass_elements);
                spinnerDuration.setAdapter(adapterAccessCard);
                for (int i = 0; i < FM_Contractor_Pass_elements.length; i++) {
                    if (activity.getCard().getDuration__c().equals(FM_Contractor_Pass_elements[i])) {
                        spinnerDuration.setSelection(i);
                        break;
                    }
                }
                spinnerDuration.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if (position != -1) {
                            activity.setDuration(FM_Contractor_Pass_elements[position]);
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

            } else if (activity.getCard().getCard_Type__c().equals(Card_Type_Elements[1])) {

                ArrayAdapter<String> adapterAccessCard = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, Contractor_Pass_elements);
                spinnerDuration.setAdapter(adapterAccessCard);
                for (int i = 0; i < Contractor_Pass_elements.length; i++) {
                    if (activity.getCard().getDuration__c().equals(Contractor_Pass_elements[i])) {
                        spinnerDuration.setSelection(i);
                        break;
                    }
                }

                spinnerDuration.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if (position != -1) {
                            activity.setDuration(Contractor_Pass_elements[position]);
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

            } else if (activity.getCard().getCard_Type__c().equals(Card_Type_Elements[2])) {

                ArrayAdapter<String> adapterAccessCard = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, Access_Card_elements);
                spinnerDuration.setAdapter(adapterAccessCard);

                for (int i = 0; i < Access_Card_elements.length; i++) {
                    if (activity.getCard().getDuration__c().equals(Access_Card_elements[i])) {
                        spinnerDuration.setSelection(i);
                        break;
                    }
                }
                spinnerDuration.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if (position != -1) {
                            activity.setDuration(Access_Card_elements[position]);
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

            }
        }
        DoCardEServiceAdminQuery(CardQuery, card.getCard_Type__c().replace(" ","_"), card.getDuration__c());
    }

    public static Fragment newInstance(String newCard) {
        CancelCardInitialPage fragment = new CancelCardInitialPage();
        Bundle bundle = new Bundle();
        bundle.putString("text", newCard);
        fragment.setArguments(bundle);
        return fragment;
    }

    private void DoCardEServiceAdminQuery(String cardQuery, final String cardType, final String duration) {
        Utilities.showloadingDialog(activity);
        String SoqlcardQuery = String.format(cardQuery, duration, cardType);
        try {
            restRequest = RestRequest.getRequestForQuery(getActivity().getString(R.string.api_version), SoqlcardQuery);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        new ClientManager(getActivity(), SalesforceSDKManager.getInstance().getAccountType(), SalesforceSDKManager.getInstance().getLoginOptions(), SalesforceSDKManager.getInstance().shouldLogoutWhenTokenRevoked()).getRestClient(getActivity(), new ClientManager.RestClientCallback() {
            @Override
            public void authenticatedRestClient(RestClient client) {
                if (client == null) {
                    SalesforceSDKManager.getInstance().logout(getActivity());
                    return;
                } else {
                    client.sendAsync(restRequest, new RestClient.AsyncRequestCallback() {

                        @Override
                        public void onSuccess(RestRequest request, RestResponse result) {
                            eServiceAdministrations = SFResponseManager.parseReceiptObjectResponse(result.toString());
                            activity.seteServiceAdministration(eServiceAdministrations.get(0));
                            getCardRecordType(cardType, duration);
                        }

                        @Override
                        public void onError(Exception exception) {
                            Utilities.showToast(getActivity(), RestMessages.getInstance().getErrorMessage());
                            Utilities.dismissLoadingDialog();
                            getActivity().finish();
                        }
                    });
                }
            }
        });
    }

    private void getCardRecordType(String cardType, String duration) {
        try {
            restRequest = RestRequest.getRequestForQuery(getString(R.string.api_version), query);
            new ClientManager(getActivity(), SalesforceSDKManager.getInstance().getAccountType(), SalesforceSDKManager.getInstance().getLoginOptions(), SalesforceSDKManager.getInstance().shouldLogoutWhenTokenRevoked()).getRestClient(getActivity(), new ClientManager.RestClientCallback() {
                @Override
                public void authenticatedRestClient(final RestClient client) {
                    if (client == null) {
                        SalesforceSDKManager.getInstance().logout(getActivity());
                        return;
                    } else {
                        client.sendAsync(restRequest, new RestClient.AsyncRequestCallback() {
                            @Override
                            public void onSuccess(RestRequest request, RestResponse result) {
                                try {
                                    Utilities.dismissLoadingDialog();
                                    JSONObject jsonObject = new JSONObject(result.toString());
                                    JSONArray jsonArrayRecords = jsonObject.getJSONArray(JSONConstants.RECORDS);
                                    for (int i = 0; i < jsonArrayRecords.length(); i++) {
                                        JSONObject jsonRecord = jsonArrayRecords.getJSONObject(i);
                                        objectType = jsonRecord.getString("SobjectType");
                                        DeveloperName = jsonRecord.getString("DeveloperName");
                                        if (objectType.equals("Case") && DeveloperName.equals("Access_Card_Request")) {
                                            activity.setCaseRecordTypeId(jsonRecord.getString("Id"));
                                        }
                                        if (objectType.equals("Card_Management__c")) {
                                            activity.setCardRecordTypeId(jsonRecord.getString("Id"));
                                        }
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void onError(Exception exception) {
                                Utilities.dismissLoadingDialog();
                            }
                        });
                    }
                }
            });
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
