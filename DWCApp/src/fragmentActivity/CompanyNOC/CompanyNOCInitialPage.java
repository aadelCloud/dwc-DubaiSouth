package fragmentActivity.CompanyNOC;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;

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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import RestAPI.JSONConstants;
import RestAPI.RestMessages;
import RestAPI.SFResponseManager;
import RestAPI.SoqlStatements;
import cloudconcept.dwc.R;
import custom.MaterialSpinner;
import dataStorage.StoreData;
import fragmentActivity.NOCScreen.*;
import model.EServices_Document_Checklist__c;
import model.Receipt_Template__c;
import utilities.Utilities;

/**
 * Created by Abanoub Wagdy on 8/13/2015.
 */
public class CompanyNOCInitialPage extends Fragment {


    String NOCType, Authority, Language;
    private int nocposition;
    private int AuthorityPosition;
    private int LanguagePosition;
    ArrayList<EServices_Document_Checklist__c> eServicesDocumentChecklistses;
    private static MaterialSpinner spinnerNOCType;
    private static MaterialSpinner spinnerChooseAuthority;
    private MaterialSpinner spinnerchooseLanguage;
    private EditText etPrice;
    private String soqlQuery;
    private RestRequest restRequest;
    private String objectType;
    private String DeveloperName;
    private ArrayList<Receipt_Template__c> eServiceAdministrations;
    private String[] ITEMS;

    public static Fragment newInstance(String s) {
        CompanyNOCInitialPage fragment = new CompanyNOCInitialPage();
        Bundle bundle = new Bundle();
        bundle.putString("text", s);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.noc_first_page, container, false);
        InitializeViews(view);
        CompanyNocMainFragment.status=1;

        LoadNOCService();
        return view;
    }

    private void InitializeViews(View view) {

        spinnerNOCType = (MaterialSpinner) view.findViewById(R.id.spinnerNOCType);
        spinnerChooseAuthority = (MaterialSpinner) view.findViewById(R.id.spinnerChooseAuthority);
        spinnerchooseLanguage = (MaterialSpinner) view.findViewById(R.id.spinnerChooseLanguage);
        etPrice = (EditText) view.findViewById(R.id.etPrice);
        spinnerChooseAuthority.setEnabled(false);
        spinnerchooseLanguage.setEnabled(false);
    }

    private void LoadNOCService() {

        soqlQuery = SoqlStatements.soql_get__company_noc_service;
        Log.d("SQL",soqlQuery);
        try {
            restRequest = RestRequest.getRequestForQuery(
                    getActivity().getString(R.string.api_version), soqlQuery);
            new ClientManager(getActivity(), SalesforceSDKManager.getInstance().getAccountType(), SalesforceSDKManager.getInstance().getLoginOptions(), SalesforceSDKManager.getInstance().shouldLogoutWhenTokenRevoked()).getRestClient(getActivity(), new ClientManager.RestClientCallback() {
                @Override
                public void authenticatedRestClient(RestClient client) {
                    if (client == null) {
                        SalesforceSDKManager.getInstance().logout(getActivity());
                        return;
                    } else {
                        Utilities.showloadingDialog(getActivity());
                        client.sendAsync(restRequest, new RestClient.AsyncRequestCallback() {

                            @Override
                            public void onSuccess(RestRequest request, RestResponse result) {
                                eServiceAdministrations = SFResponseManager.parseReceiptObjectResponse(result.toString());
                                getNocRecordType();
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
            getActivity().finish();
        }
    }

    public void getNocRecordType() {
        String soql = "SELECT Id, Name, DeveloperName, SobjectType FROM RecordType WHERE (SobjectType = 'Case' AND DeveloperName = 'NOC_Request') OR (SObjectType = 'NOC__c' AND DeveloperName = 'Under_Process')";
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
                                try {
                                    JSONObject jsonObject = new JSONObject(result.toString());
                                    JSONArray jsonArrayRecords = jsonObject.getJSONArray(JSONConstants.RECORDS);
                                    for (int i = 0; i < jsonArrayRecords.length(); i++) {
                                        JSONObject jsonRecord = jsonArrayRecords.getJSONObject(i);
                                        objectType = jsonRecord.getString("SobjectType");
                                        DeveloperName = jsonRecord.getString("DeveloperName");
                                        if (objectType.equals("Case") && DeveloperName.equals("NOC_Request")) {
                                            fragmentActivity.CompanyNOC.CompanyNocMainFragment.caseRecordTypeId = jsonRecord.getString("Id");
                                        }
                                        if (objectType.equals("NOC__c") && DeveloperName.equals("Under_Process")) {
                                            fragmentActivity.CompanyNOC.CompanyNocMainFragment.nocRecordTypeId = jsonRecord.getString("Id");
                                        }
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                Utilities.dismissLoadingDialog();
                                setInitialPageLayoutAttributes();
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

    public void setInitialPageLayoutAttributes() {

        ITEMS = new String[eServiceAdministrations.size()];
        for (int i = 0; i < eServiceAdministrations.size(); i++) {
            ITEMS[i] = eServiceAdministrations.get(i).getDisplay_Name__c();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, ITEMS);
        spinnerNOCType.setAdapter(adapter);

        spinnerNOCType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != -1) {
                    Utilities.setEServiceAdministration(eServiceAdministrations.get(position));
                    spinnerChooseAuthority.setEnabled(true);
                    etPrice.setText("AED " + (eServiceAdministrations.get(position).getTotal_Amount__c()));
                    new StoreData(getActivity().getApplicationContext()).saveNocType((String) spinnerNOCType.getSelectedItem());
                    eServicesDocumentChecklistses = eServiceAdministrations.get(position).geteServices_document_checklist__c();
                    Set AuthorityItems = new HashSet();
                    for (int i = 0; i < eServicesDocumentChecklistses.size(); i++) {
                        if (eServicesDocumentChecklistses.get(i) != null && eServicesDocumentChecklistses.get(i).getAuthority__c() != null) {
                            if (!eServicesDocumentChecklistses.get(i).getAuthority__c().equals(""))
                                AuthorityItems.add(eServicesDocumentChecklistses.get(i).getAuthority__c());
                        }
                    }
                    List<String> authorityItems = new ArrayList<String>();
                    authorityItems.addAll(AuthorityItems);
                    ArrayAdapter<String> AuthorityAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, authorityItems);
                    spinnerChooseAuthority.setAdapter(AuthorityAdapter);
                    spinnerChooseAuthority.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            if (position != -1) {
                                spinnerchooseLanguage.setEnabled(true);
                                new StoreData(getActivity().getApplicationContext()).saveNOCAuthorityType((String) spinnerChooseAuthority.getSelectedItem());
                                ArrayList<String> LanguageItems = new ArrayList<String>();
                                Set<String> languageItems = new HashSet<String>();

                                for (int i = 0; i < eServicesDocumentChecklistses.size(); i++) {
                                  if(eServicesDocumentChecklistses.get(i).getAuthority__c()!=null)
                                    if (eServicesDocumentChecklistses.get(i).getAuthority__c().equals((String) spinnerChooseAuthority.getSelectedItem())) {
                                        languageItems.add(eServicesDocumentChecklistses.get(i).getLanguage__c());
                                    }
                                }
                                LanguageItems.addAll(languageItems);
                                ArrayAdapter<String> AuthorityAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, LanguageItems);
                                spinnerchooseLanguage.setAdapter(AuthorityAdapter);
                                spinnerchooseLanguage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                        if (position != -1) {
                                            new StoreData(getActivity().getApplicationContext()).saveNOCLanguage((String) spinnerchooseLanguage.getSelectedItem());
                                        }
                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> parent) {

                                    }
                                });
                                new StoreData(getActivity().getApplicationContext()).setIsLoadedInitialEmployeeNOCPage(true);
                            } else {
                                spinnerchooseLanguage.setSelection(0);
                                spinnerchooseLanguage.setEnabled(false);
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                } else {
                    spinnerChooseAuthority.setSelection(0);
                    spinnerchooseLanguage.setSelection(0);
                    spinnerChooseAuthority.setEnabled(false);
                    spinnerchooseLanguage.setEnabled(false);
                    etPrice.setText("AED " +0);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Utilities.dismissLoadingDialog();
    }

    public static boolean ValidateInput() {
        if (spinnerNOCType.getSelectedItemPosition() == 0 || spinnerChooseAuthority.getSelectedItemPosition() == 0) {
            return false;
        } else {
            return true;
        }
    }
}
