package fragment.Cards.CancelCard;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.View;

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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import RestAPI.JSONConstants;
import RestAPI.SoqlStatements;
import cloudconcept.dwc.R;
import custom.customdialog.NiftyDialogBuilder;
import fragment.BaseFragmentFiveSteps;
import fragment.Cards.NOCAttachmentPage;
import fragment.Cards.PayAndSubmit;
import fragmentActivity.CardActivity;
import fragmentActivity.NOCScreen.ThankYou;
import model.Card_Management__c;
import model.FormField;
import utilities.Utilities;

/**
 * Created by M_Ghareeb on 8/25/2015.
 */
public class CancelCardMainFragment extends BaseFragmentFiveSteps {

    CardActivity activity;
    private RestRequest restRequest;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        activity = (CardActivity) getActivity();

        if (activity.getType().equals("2"))
            tvTitle.setText("Cancel Card");
        else if (activity.getType().equals("3"))
            tvTitle.setText("Renew Card");
        else if (activity.getType().equals("4"))
            tvTitle.setText("Replace Card");

    }

    @Override
    public void onClick(View v) {
        if (v == btnNext) {
            if (getStatus() == 1) {
                Map<String, String> parameters = activity.getParameters();
                parameters.put("actName", Utilities.stringNotNull(activity.getUser().get_contact().get_account().getName()));
                parameters.put("accountID", Utilities.stringNotNull(activity.getUser().get_contact().get_account().getID()));
                parameters.put("Dur", activity.getDuration());
                activity.setParameters(parameters);
                super.onClick(v);
            } else if (getStatus() == 2) {
                if (true)
                    createCaseRecord();
                else {
                    Utilities.showLongToast(getActivity(), "Please fill required fields");
                }
            } else if (getStatus() == 3) {
                if (!isValidAttachments()) {
                    Utilities.showLongToast(activity, "Please fill all attachments");
                } else {
                    super.onClick(v);
                }
            } else if (getStatus() == 4)
                Utilities.showCustomNiftyDialog("Pay Process", getActivity(), listenerOkPay, "Are you sure want to Pay for the service ?");
            else {
                super.onClick(v);
            }
        } else if (v == btnBack || v == btnBackTransparent) {

            if (getStatus() == 3) {
                activity.setInsertedCaseId(null);
                activity.setInsertedServiceId(null);
            } else if (getStatus() == 4) {
                if (activity.getCompanyDocuments() == null || activity.getCompanyDocuments().size() == 0) {
                    setStatus(3);
                    activity.setInsertedCaseId(null);
                    activity.setInsertedServiceId(null);
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
        } else {
            super.onClick(v);
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

    private boolean required() {
        boolean result = true;
        for (FormField field : activity.get_webForm().get_formFields()) {
            if (field.isRequired()) {
                String name = field.getName();
                String stringValue = "";
                Field[] fields = Card_Management__c.class.getFields();
                for (int j = 0; j < fields.length; j++)
                    if (name.toLowerCase().equals(fields[j].getName().toLowerCase()))
                        try {
                            stringValue = (String) fields[j].get(activity.getCard());
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (ClassCastException e) {
                            e.printStackTrace();
                            if (field.getType().equals("DOUBLE")) {
                                try {
                                    if (fields[j].getDouble(activity.getCard()) == 0.0) {
                                        result = false;
                                        return false;
                                    } else {
                                        stringValue = String.valueOf(fields[j].getDouble(activity.getCard()));
                                    }
                                } catch (IllegalAccessException e1) {
                                    e1.printStackTrace();
                                }
                            }
                        }

                if (stringValue == null) {
                    result = false;
                    return false;
                } else if (stringValue.equals("")) {
                    result = false;
                    return false;
                }
            }
        }
        return result;
    }

    public void createCaseRecord() {
        activity = (CardActivity) getActivity();
        if (activity.geteServiceAdministration() != null) {
            Map<String, Object> caseFields = activity.getCaseFields();
            caseFields.put("Service_Requested__c", activity.geteServiceAdministration().getID());
            caseFields.put("AccountId", activity.getUser().get_contact().get_account().getID());
            caseFields.put("RecordTypeId", activity.getCaseRecordTypeId());
            caseFields.put("Status", "Draft");
            caseFields.put("Type", "Access Card Services");
            caseFields.put("Origin", "Mobile");
            caseFields.put("Visual_Force_Generator__c", activity.get_webForm().getID());
            caseFields.put("Card_Management__c", activity.getCard().getId());


            activity.setCaseFields(caseFields);
        }
//        if (activity.get_webForm() != null) {
//            Map<String, Object> caseFields = activity.getCaseFields();
//            caseFields.put("Visual_Force_Generator__c", activity.get_webForm().getID());
//            activity.setCaseFields(caseFields);
//        }

        if (activity.getInsertedCaseId() != null && !activity.getInsertedCaseId().equals("")) {
            try {
                restRequest = RestRequest.getRequestForUpdate(getActivity().getString(R.string.api_version), "Case", activity.getInsertedCaseId(), activity.getCaseFields());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                restRequest = RestRequest.getRequestForCreate(getActivity().getString(R.string.api_version), "Case", activity.getCaseFields());
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
                                activity.setInsertedCaseId(jsonObject.getString("id"));

                                try {
                                    restRequest = RestRequest.getRequestForQuery(getString(R.string.api_version), SoqlStatements.getCaseNumberQuery(activity.getInsertedCaseId()));
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
                                            activity.setCaseNumber(jsonRecord.getString("CaseNumber"));
                                            createCardRecord();
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

    public void createCardRecord() {

        Map<String, Object> serviceFields = activity.getServiceFields();
//        serviceFields = new HashMap<String, Object>();
        serviceFields.put("RecordTypeId", activity.getCardRecordTypeId());
        serviceFields.put("Card_Type__c", activity.getCardType().replaceAll(" ", "_"));
        if (activity.getType().equals("3"))
            serviceFields.put("Renewal_For__c", activity.getCard().getId());
        else if (activity.getType().equals("4"))
            serviceFields.put("Lost_Card__c", activity.getCard().getId());


            /* Load dynamic fetching */


        for (FormField field : activity.get_webForm().get_formFields()) {
            if (field.getType().equals("CUSTOMTEXT")) {


            } else if (field.isShouldBeCloned()) {


                String stringValue = "";
                String name = field.getName();
                Field[] fields = Card_Management__c.class.getFields();
                if (!field.getType().equals("REFERENCE")) {
                    for (int j = 0; j < fields.length; j++)
                        if (name.toLowerCase().equals(fields[j].getName().toLowerCase()))
                            try {
                                stringValue = String.valueOf(fields[j].get(activity.getCard()));
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            }
                    serviceFields.put(name, (stringValue.equals("true") || stringValue.equals("false") ? Boolean.valueOf(stringValue) : stringValue));

                } else {
                    String refName = name.replace("__c", "");
                    try {
                        Class refclass = Class.forName("model." + refName);
                        Field reffield = null;
                        for (int l = 0; l < refclass.getFields().length; l++)
                            if (("id").equals(refclass.getFields()[l].getName().toLowerCase()))
                                reffield = refclass.getFields()[l];

                        for (int j = 0; j < fields.length; j++)
                            if ((refName + "__r").toLowerCase().equals(fields[j].getName().toLowerCase()))
                                try {


                                    stringValue = String.valueOf(reffield.get(fields[j].get(activity.getCard())));
                                } catch (IllegalAccessException e) {
                                    e.printStackTrace();
                                }
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    serviceFields.put(name, (stringValue.equals("true") || stringValue.equals("false") ? Boolean.valueOf(stringValue) : stringValue));

                }
            }
        }


            /* End of dynamic fetching*/
        activity.setServiceFields(serviceFields);
        if (activity.getInsertedServiceId() != null && !activity.getInsertedServiceId().equals("")) {
            try {
                restRequest = RestRequest.getRequestForUpdate(getActivity().getString(R.string.api_version), activity.get_webForm().getObject_Name(), activity.getInsertedServiceId(), serviceFields);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                restRequest = RestRequest.getRequestForCreate(getActivity().getString(R.string.api_version), activity.get_webForm().getObject_Name(), serviceFields);
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
                                activity.setInsertedServiceId(jsonObject.getString("id"));
                                updateCaseRecord(activity.getInsertedCaseId(), activity.getInsertedServiceId());
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

    private void updateCaseRecord(String insertedCaseId, String insertedServiceId) {

        Map<String, Object> fields = new HashMap<String, Object>();
        fields.put(activity.get_webForm().getObject_Name(), insertedServiceId);

        try {
            restRequest = RestRequest.getRequestForUpdate(getString(R.string.api_version), "Case", insertedCaseId, fields);
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

                                Log.d("", response.toString());
                                if (activity.getType().equals("2")) {
                                    CallCancelCardWebService(client);
                                } else {
                                    PerfromParentNext();
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private void CallCancelCardWebService(RestClient client) {

        Map<String, Object> fields = new HashMap<String, Object>();
        fields.put("Status__c", "Cancelled");
        long yourmilliseconds = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        Date resultdate = new Date(yourmilliseconds);
        fields.put("Cancellation_Date__c", sdf.format(resultdate));
        try {
            restRequest = RestRequest.getRequestForUpdate(activity.getString(R.string.api_version), "Card_Management__c", activity.getCard().getId(), fields);
            client.sendAsync(restRequest, new RestClient.AsyncRequestCallback() {
                @Override
                public void onSuccess(RestRequest request, RestResponse response) {
                    Utilities.dismissLoadingDialog();
                    PerfromParentNext();
                }

                @Override
                public void onError(Exception exception) {
                    Utilities.dismissLoadingDialog();
                    VolleyError volleyError = (VolleyError) exception;
                    NetworkResponse response = volleyError.networkResponse;
                    String json = new String(response.data);
                    Log.d("", json);

                    getActivity().finish();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
            Utilities.dismissLoadingDialog();
        }
    }

    @Override
    public Fragment getInitialFragment() {
        return CancelCardInitialPage.newInstance("Initial");
    }

    @Override
    public Fragment getSecondFragment() {
        return CancelCardFormFieldPage.newInstance("Second");
    }

    @Override
    public Fragment getThirdFragment() {
        return NOCAttachmentPage.newInstance("Third");
    }

    @Override
    public Fragment getFourthFragment() {
        return PayAndSubmit.newInstance("2");
    }

    @Override
    public Fragment getFifthFragment(String msg, String fee, String mail) {
        return ThankYou.newInstance(msg, fee, mail);
    }

    @Override
    public RelatedServiceType getRelatedService() {
        return null;
    }

    public static Fragment newInstance(String newCard) {
        CancelCardMainFragment fragment = new CancelCardMainFragment();
        Bundle bundle = new Bundle();
        bundle.putString("text", newCard);
        fragment.setArguments(bundle);
        return fragment;
    }


    private void PerfromParentNext() {
        super.onClick(btnNext);
    }

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
                map.put("caseId", activity.getInsertedCaseId());
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
                getfifthfragment("", activity.getCaseNumber());
            }

        }
    }

    private boolean isValidAttachments() {
        if (activity.getCompanyDocuments() != null && activity.getCompanyDocuments().size() > 0) {
            for (int i = 0; i < activity.getCompanyDocuments().size(); i++) {
                if (activity.getCompanyDocuments().get(i).getAttachment_Id__c() == null || activity.getCompanyDocuments().get(i).getAttachment_Id__c().equals("")) {
                    return false;
                }
            }
        } else {
            return false;
        }

        return true;
    }

}
