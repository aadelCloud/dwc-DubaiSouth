package fragment.Cards.NewCard;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

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
import custom.MaterialSpinner;
import fragmentActivity.CardActivity;
import model.Receipt_Template__c;
import utilities.Utilities;

/**
 * Created by Abanoub Wagdy on 8/19/2015.
 */
public class NewCardInitialPage extends Fragment {

    MaterialSpinner spinnerCardType, spinnerDuration;

    String[] FM_Contractor_Pass_elements = new String[]{"1 Month", "3 Months", "6 Months", "1 Year"};
    String[] Contractor_Pass_elements = new String[]{"1 Week", "1 Month", "2 Months", "3 Months", "4 Months", "5 Months", "6 Months", "1 Year"};
    String[] Access_Card_elements = new String[]{"1 Day", "1 Month", "3 Months", "6 Months", "1 Year"};
    String[] Card_Type_Elements = new String[]{"FM Contractor Pass", "Contractor Pass", "Access Card"};
    String CardType = "";
    String CardQuery = "SELECT ID, Name, Display_Name__c, Service_Identifier__c, Amount__c, Total_Amount__c, Related_to_Object__c, New_Edit_VF_Generator__c, Renewal_VF_Generator__c, Replace_VF_Generator__c, Cancel_VF_Generator__c, Record_Type_Picklist__c, (SELECT ID, Name, Type__c, Language__c, Document_Type__c, Authority__c FROM eServices_Document_Checklists__r) FROM Receipt_Template__c WHERE Is_Active__c = true AND Duration__c = " + "\'" + "%s" + "\'" + " AND Record_Type_Picklist__c = " + "\'" + "%s" + "\'";
    private RestRequest restRequest;
    private ArrayList<Receipt_Template__c> eServiceAdministrations;
    private String objectType;
    private String DeveloperName;
    private CardActivity activity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.new_card_first_page, container, false);
        InitializeViews(view);
        return view;
    }

    private void InitializeViews(View view) {
        activity = (CardActivity) getActivity();
        spinnerCardType = (MaterialSpinner) view.findViewById(R.id.spinnerCardType);
        spinnerDuration = (MaterialSpinner) view.findViewById(R.id.spinnerDurationValues);
        spinnerDuration.setEnabled(false);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, Card_Type_Elements);
        spinnerCardType.setAdapter(adapter);
        spinnerCardType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != -1) {
                    spinnerDuration.setEnabled(true);
                    switch (position) {
                        case 0:
                            CardType = "FM_Contractor_Pass";
                            ValidateSpinnerItems(spinnerDuration, FM_Contractor_Pass_elements);
                            break;
                        case 1:
                            CardType = "Contractor_Pass";
                            ValidateSpinnerItems(spinnerDuration, Contractor_Pass_elements);
                            break;
                        case 2:
                            CardType = "Access_Card";
                            ValidateSpinnerItems(spinnerDuration, Access_Card_elements);
                            break;
                    }
                    activity.setCardType(CardType);
                } else {
                    CardType = "";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void ValidateSpinnerItems(MaterialSpinner spinnerDuration, final String[] elements) {

        ArrayAdapter<String> adapterAccessCard = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, elements);
        spinnerDuration.setAdapter(adapterAccessCard);

        spinnerDuration.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != -1) {
                    Utilities.showloadingDialog(getActivity());
                    activity.setDuration(elements[position]);
                    DoCardEServiceAdminQuery(CardQuery, CardType, activity.getDuration());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void DoCardEServiceAdminQuery(String cardQuery, final String cardType, final String duration) {

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

    private void getCardRecordType(final String cardType, String duration) {
        String soql = "SELECT Id, Name, DeveloperName, SobjectType FROM RecordType WHERE (SobjectType = 'Case' AND DeveloperName = 'Access_Card_Request') OR (SObjectType = 'Card_Management__c' AND DeveloperName = " + "\'" + cardType + "\'" + ")";
        try {
            restRequest = RestRequest.getRequestForQuery(getActivity().getString(R.string.api_version), soql);
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
                                Utilities.dismissLoadingDialog();
                                try {
                                    JSONObject jsonObject = new JSONObject(result.toString());
                                    JSONArray jsonArrayRecords = jsonObject.getJSONArray(JSONConstants.RECORDS);
                                    for (int i = 0; i < jsonArrayRecords.length(); i++) {
                                        JSONObject jsonRecord = jsonArrayRecords.getJSONObject(i);
                                        objectType = jsonRecord.getString("SobjectType");
                                        DeveloperName = jsonRecord.getString("DeveloperName");
                                        if (objectType.equals("Case") && DeveloperName.equals("Access_Card_Request")) {
                                            activity.setCaseRecordTypeId(jsonRecord.getString("Id"));
                                        }
                                        if (objectType.equals("Card_Management__c") && DeveloperName.equals(cardType)) {
                                            activity.setCardRecordTypeId(jsonRecord.getString("Id"));
                                        }
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
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
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static Fragment newInstance(String newCard) {
        NewCardInitialPage fragment = new NewCardInitialPage();
        Bundle bundle = new Bundle();
        bundle.putString("text", newCard);
        fragment.setArguments(bundle);
        return fragment;
    }
}
