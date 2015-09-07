package fragmentActivity.NOCScreen;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

import com.android.volley.NetworkResponse;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


import RestAPI.JSONConstants;
import RestAPI.SoqlStatements;
import custom.customdialog.NiftyDialogBuilder;
import dataStorage.StoreData;
import model.Company_Documents__c;
import model.FormField;
import model.NOC__c;
import cloudconcept.dwc.R;
import fragment.BaseServiceFragment;
import model.Receipt_Template__c;
import model.Request;
import model.User;
import model.WebForm;
import model._case;
import utilities.Utilities;

public class NocMainFragment extends BaseServiceFragment {

    static String caseRecordTypeId, nocRecordTypeId;
    public static NOC__c _noc;
    public static _case finalCase;
    public static User user;
    public static Map<String, Object> caseFields = new HashMap<String, Object>();
    public static Map<String, Object> serviceFields = new HashMap<String, Object>();
    public static String insertedCaseId, insertedServiceId, caseNummberId;
    public static WebForm _webForm;
    private Receipt_Template__c eServiceAdministration;
    private RestRequest restRequest;
    String serviceFieldCaseObjectName;

    Gson gson;
    int i = 0;

    public NocMainFragment() {

    }

    @Override
    public Fragment getInitialFragment() {
        return NOCInitialPage.newInstance("Initial");
    }

    @Override
    public Fragment getSecondFragment() {
        return NOCFormFieldPage.newInstance("Second");
    }

    @Override
    public Fragment getThirdFragment() {
        return NOCAttachmentPage.newInstance("Third");
    }

    @Override
    public Fragment getFourthFragment() {
        return NocPayAndSubmit.newInstance("Emp");
    }

    @Override
    public Fragment getFifthFragment(String msg, String fee, String mail) {
        return ThankYou.newInstance(msg, fee, mail);
    }

    @Override
    public RelatedServiceType getRelatedService() {
        if (NocActivity._visa != null) {
            return RelatedServiceType.RELATED_SERVICE_EMPLOYEE_NOC;
        } else {
            return RelatedServiceType.RELATED_SERVICE_COMPANY_NOC;
        }
    }

    @Override
    public void onClick(View v) {
        if (v == BaseServiceFragment.btnNext) {
            if (BaseServiceFragment.status == 1) {
                if (NOCInitialPage.ValidateInput()) {
                    super.onClick(v);
                } else {
                    Utilities.showLongToast(getActivity(), "Please fill all fields");
                }
            } else if (BaseServiceFragment.status == 2) {
                if (required())
                    createCaseRecord();

                else {
                    Utilities.showLongToast(getActivity(), "Please fill required fields");
                }
            } else if (BaseServiceFragment.status == 3) {
                if (NOCAttachmentPage._companyDocuments.size() > 0) {
                    final ArrayList<Company_Documents__c> company_documents__cs = NOCAttachmentPage._companyDocuments;
                    if (NOCAttachmentPage.ValidateAttachments()) {
                        new ClientManager(getActivity(), SalesforceSDKManager.getInstance().getAccountType(), SalesforceSDKManager.getInstance().getLoginOptions(), SalesforceSDKManager.getInstance().shouldLogoutWhenTokenRevoked()).getRestClient(getActivity(), new ClientManager.RestClientCallback() {
                            @Override
                            public void authenticatedRestClient(RestClient client) {
                                if (client == null) {
                                    SalesforceSDKManager.getInstance().logout(getActivity());
                                    return;
                                } else {
                                    PerfromParentNext(BaseServiceFragment.btnNext);
                                }
                            }
                        });
                    } else {
                        Utilities.showToast(getActivity(), "Please fill all attachments");
                    }
                } else {
                    Utilities.showToast(getActivity(), "Please fill all attachments");
                }
            } else if (BaseServiceFragment.status == 4) {
                Utilities.showCustomNiftyDialog("Pay Process", getActivity(), listenerOkPay, "Are you sure want to Pay for the service ?");

                super.onClick(v);
            } else {

                super.onClick(v);
            }
        } else {
            if (BaseServiceFragment.status == 3) {
                NocMainFragment.insertedServiceId = null;
                NocMainFragment.insertedCaseId = null;
            } else if (BaseServiceFragment.status == 4) {
                if (NOCAttachmentPage._companyDocuments == null || NOCAttachmentPage._companyDocuments.size() == 0) {
                    BaseServiceFragment.status = 3;
                    NocMainFragment.insertedServiceId = null;
                    NocMainFragment.insertedCaseId = null;
                    btnNOC3.setBackground(getActivity().getResources().getDrawable(R.drawable.noc_selector));
                    btnNOC3.setSelected(false);
                    btnNOC3.setTextColor(getActivity().getResources().getColor(R.color.white));
                    btnNOC3.setGravity(Gravity.CENTER);
                    btnNOC3.setText("3");
                    btnNext.setText(("Next"));
                    btnNOC4.setBackground(getActivity().getResources().getDrawable(R.drawable.noc_selector));
                    btnNOC4.setSelected(false);
                    btnNOC4.setTextColor(getActivity().getResources().getColor(R.color.white));
                    btnNOC4.setGravity(Gravity.CENTER);
                    btnNOC4.setText("4");
                }
            }
            super.onClick(v);
        }
    }

    private boolean required() {
        boolean result=true;
        for(FormField field: _webForm.get_formFields()){
            if(field.isRequired()){
                String name=field.getName();
                String stringValue="";
                Field[] fields = NOC__c.class.getFields();
                for (int j = 0; j < fields.length; j++)
                    if (name.toLowerCase().equals(fields[j].getName().toLowerCase()))
                        try {
                            stringValue = (String) fields[j].get(_noc);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }catch(ClassCastException e){
                            e.printStackTrace();
                            if(field.getType().equals("DOUBLE")){
                                try {
                                    if(fields[j].getDouble(_noc)==0.0) {
                                        result = false;
                                        return false;
                                    }else {
                                        stringValue=String.valueOf(fields[j].getDouble(_noc));
                                    }
                                } catch (IllegalAccessException e1) {
                                    e1.printStackTrace();
                                }
                            }
                        }

                if(stringValue==null){
                    result=false;
                    return false;
                }else if(stringValue.equals("")){
                    result=false;
                    return false;
                }
            }
        }
        return result;
    }

    public static Fragment newInstance(String baseEmployee, Context context) {
        NocMainFragment fragment = new NocMainFragment();
        _noc = new NOC__c();
        finalCase = new _case();
        Bundle bundle = new Bundle();
        bundle.putString("text", baseEmployee);
        user = new Gson().fromJson(new StoreData(context).getUserDataAsString(), User.class);
        fragment.setArguments(bundle);
        return fragment;
    }

    public static void setCaseFields(Map<String, Object> caseFields) {
        NocMainFragment.caseFields = caseFields;
    }

    public static Map<String, Object> getCaseFields() {
        return caseFields;
    }

    public static void setServiceFields(Map<String, Object> serviceFields) {
        NocMainFragment.serviceFields = serviceFields;
    }

    public static Map<String, Object> getServiceFields() {
        return serviceFields;
    }

    public static NOC__c get_noc() {
        return _noc;
    }

    public static void set_noc(NOC__c _noc) {
        _noc = _noc;
    }



    public void createCaseRecord() {
        eServiceAdministration = Utilities.geteServiceAdministration();
        if (eServiceAdministration != null) {
            Map<String, Object> caseFields = getCaseFields();
            caseFields.put("Service_Requested__c", eServiceAdministration.getId());
            caseFields.put("AccountId", user.get_contact().get_account().getID());
            caseFields.put("RecordTypeId", caseRecordTypeId);
            caseFields.put("Status", "Draft");
            caseFields.put("Type", "NOC Services");
            caseFields.put("Origin", "Mobile");
            caseFields.put("isCourierRequired__c", false);
            caseFields.put("Employee_Ref__c", NocActivity.get_visa().getVisa_Holder__r().getID());
            caseFields.put("Service_Requested__c", eServiceAdministration.getID());
            caseFields.put("Visa_Ref__c", NocActivity.get_visa().getID());
            setCaseFields(caseFields);
        }

        if (_webForm != null) {
            Map<String, Object> caseFields = getCaseFields();
            caseFields.put("Visual_Force_Generator__c", _webForm.getID());
            setCaseFields(caseFields);
        }

        if (insertedCaseId != null && !insertedCaseId.equals("")) {
            try {
                restRequest = RestRequest.getRequestForUpdate(getActivity().getString(R.string.api_version), "Case", insertedCaseId, getCaseFields());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                restRequest = RestRequest.getRequestForCreate(getActivity().getString(R.string.api_version), "Case", getCaseFields());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Utilities.showloadingDialog(getActivity());
        new ClientManager(getActivity(), SalesforceSDKManager.getInstance().getAccountType(), SalesforceSDKManager.getInstance().getLoginOptions(), SalesforceSDKManager.getInstance().shouldLogoutWhenTokenRevoked()).getRestClient(getActivity(), new ClientManager.RestClientCallback() {
            @Override
            public void authenticatedRestClient(final RestClient client) {
                if (client == null) {
                    SalesforceSDKManager.getInstance().logout(getActivity());
                    return;
                } else {
                    client.sendAsync(restRequest, new RestClient.AsyncRequestCallback() {
                        @Override
                        public void onSuccess(RestRequest request, RestResponse response) {
                            try {
                                JSONObject jsonObject = new JSONObject(response.toString());
                                insertedCaseId = jsonObject.getString("id");

                                try {
                                    restRequest = RestRequest.getRequestForQuery(getString(R.string.api_version), SoqlStatements.getCaseNumberQuery(insertedCaseId));
                                } catch (UnsupportedEncodingException e) {
                                    e.printStackTrace();
                                }
                                client.sendAsync(restRequest, new RestClient.AsyncRequestCallback() {
                                    @Override
                                    public void onSuccess(RestRequest request, RestResponse response) {
                                        JSONObject jsonObject = null;
                                        try {
                                            jsonObject = new JSONObject(response.toString());
                                            JSONArray jsonArray = jsonObject.getJSONArray(JSONConstants.RECORDS);
                                            JSONObject jsonRecord = jsonArray.getJSONObject(0);
                                            Log.d("resultcase", response.toString());
                                            caseNummberId = jsonRecord.getString("CaseNumber");
                                            createServiceRecord(insertedCaseId);
                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }

                                    }

                                    @Override
                                    public void onError(Exception exception) {

                                    }
                                });
                                Log.d("", response.toString());

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
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
        });
    }

    private void createServiceRecord(String caseRecordTypeId) {

        Map<String, Object> serviceFields = getServiceFields();
        serviceFields.put("Request__c", caseRecordTypeId);
        serviceFields.put("Document_Name__c", new StoreData(getActivity()).getNocType());
        serviceFields.put("Person__c", NocActivity.get_visa().getVisa_Holder__r().getID());
        serviceFields.put("Current_Visa__c", NocActivity.get_visa().getID());
        serviceFields.put("Current_Sponsor__c", user.get_contact().get_account().getID());
        for (FormField field : NocMainFragment._webForm.get_formFields()) {
            if (field.getType().equals("CUSTOMTEXT") || field.isCalculated()) {


            } else {


                String stringValue = "";
                String name = field.getName();
                Field[] fields = NOC__c.class.getFields();
                for (int j = 0; j < fields.length; j++)
                    if (name.toLowerCase().equals(fields[j].getName().toLowerCase()))
                        try {
                            stringValue = String.valueOf(fields[j].get(NocMainFragment._noc));
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                serviceFields.put(name, (stringValue.equals("true") || stringValue.equals("false") ? Boolean.valueOf(stringValue) : stringValue));
            }
        }
        if (insertedServiceId != null && !insertedServiceId.equals("")) {
            try {
                restRequest = RestRequest.getRequestForUpdate(getActivity().getString(R.string.api_version), _webForm.getObject_Name(), insertedServiceId, serviceFields);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                restRequest = RestRequest.getRequestForCreate(getActivity().getString(R.string.api_version), _webForm.getObject_Name(), serviceFields);
            } catch (IOException e) {
                e.printStackTrace();
            }
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
                        public void onSuccess(RestRequest request, RestResponse response) {
                            try {
                                JSONObject jsonObject = new JSONObject(response.toString());
                                insertedServiceId = jsonObject.getString("id");
                                updateCaseRecord(insertedCaseId, insertedServiceId);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
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
        });
    }

    public void updateCaseRecord(String insertedCaseId, String insertedServiceId) {

        Map<String, Object> fields = new HashMap<String, Object>();
        fields.put(_webForm.getObject_Name(), insertedServiceId);

        try {
            restRequest = RestRequest.getRequestForUpdate(getString(R.string.api_version), "Case", insertedCaseId, fields);
            new ClientManager(getActivity(), SalesforceSDKManager.getInstance().getAccountType(), SalesforceSDKManager.getInstance().getLoginOptions(), SalesforceSDKManager.getInstance().shouldLogoutWhenTokenRevoked()).getRestClient(getActivity(), new ClientManager.RestClientCallback() {
                @Override
                public void authenticatedRestClient(RestClient client) {
                    if (client == null) {
                        SalesforceSDKManager.getInstance().logout(getActivity());
                        return;
                    } else {
                        client.sendAsync(restRequest, new RestClient.AsyncRequestCallback() {
                            @Override
                            public void onSuccess(RestRequest request, RestResponse response) {
                                Utilities.dismissLoadingDialog();
                                Log.d("", response.toString());
//                                onClick(BaseServiceFragment.btnNext);
                                PerfromParentNext(BaseServiceFragment.btnNext);
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
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void PerfromParentNext(Button btnNext) {
        super.onClick(btnNext);
    }

    private void UploadAttachments(final RestClient client, final ArrayList<Company_Documents__c> companyDocuments) {

        final int size = companyDocuments.size();

        Company_Documents__c company_documents__c = companyDocuments.get(i);
        HashMap<String, Object> fields = new HashMap<String, Object>();
        fields.put("Name", company_documents__c.getName());
        fields.put("eServices_Document__c", company_documents__c.getId());
        fields.put("Company__c", user.get_contact().get_account().getID());
        fields.put("Request__c", insertedCaseId);
        fields.put(_webForm.getObject_Name(), insertedServiceId);
        fields.put("Attachment_Id__c", company_documents__c.getAttachment_Id__c());
        if (company_documents__c.getHasAttachmentBefore()) {
            try {
                restRequest = RestRequest.getRequestForUpdate(getActivity().getString(R.string.api_version), "Company_Documents__c", company_documents__c.getId(), fields);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                restRequest = RestRequest.getRequestForCreate(getActivity().getString(R.string.api_version), "Company_Documents__c", fields);
            } catch (IOException e) {
                e.printStackTrace();
            }
            client.sendAsync(restRequest, new RestClient.AsyncRequestCallback() {
                @Override
                public void onSuccess(RestRequest request, RestResponse response) {

                    if (i + 1 == size) {
                        PerfromParentNext(BaseServiceFragment.btnNext);
                    } else {
                        i++;
                        UploadAttachments(client, companyDocuments);
                    }
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

    private View.OnClickListener listenerOkPay = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            new ClientManager(getActivity(), SalesforceSDKManager.getInstance().getAccountType(), SalesforceSDKManager.getInstance().getLoginOptions(), SalesforceSDKManager.getInstance().shouldLogoutWhenTokenRevoked()).getRestClient(getActivity(), new ClientManager.RestClientCallback() {
                @Override
                public void authenticatedRestClient(final RestClient client) {
                    if (client == null) {
                        System.exit(0);
                    } else {

                        new GetPickLists(client).execute();
//


                    }
                }
            });

        }
    };

    public class GetPickLists extends AsyncTask<String, Void, String> {

        private final RestClient client;
        String result;

        public GetPickLists(RestClient client) {
            this.client = client;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Utilities.showloadingDialog(getActivity());
        }

        @Override
        protected String doInBackground(String... params) {
            String attUrl = client.getClientInfo().resolveUrl("/services/apexrest/MobilePayAndSubmitWebService").toString();

            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(attUrl);
            httppost.setHeader("Authorization", "Bearer " + client.getAuthToken());
            StringEntity entity = null;
            try {
                Map<String, String> map = new HashMap<String, String>();
                map.put("caseId", NocMainFragment.insertedCaseId);
                entity = new StringEntity(new JSONObject(map).toString(), "UTF-8");
                entity.setContentType("application/json");
                httppost.setEntity(entity);
                HttpResponse response = httpclient.execute(httppost);
                result = EntityUtils.toString(response.getEntity());
                Log.d("result", result);
                return result.toLowerCase().contains("success") ? "success" : null;
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }




            return null;
        }

        @Override
        protected void onPostExecute(String aVoid) {
            super.onPostExecute(aVoid);
            Utilities.dismissLoadingDialog();
            if (aVoid.equals("success")) {
                NiftyDialogBuilder
                        .getInstance(getActivity()).dismiss();
                getfifthfragment(_noc.getNOC_Receiver_Email__c(), caseNummberId);
            }

        }
    }
}
