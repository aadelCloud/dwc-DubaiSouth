package fragment.Visa.Cancel;

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
import java.util.HashMap;
import java.util.Map;

import RestAPI.JSONConstants;
import RestAPI.RestMessages;
import RestAPI.SFResponseManager;
import RestAPI.SoqlStatements;
import cloudconcept.dwc.R;
import custom.customdialog.NiftyDialogBuilder;
import fragment.BaseFragmentFourStepsNew;
import fragment.Visa.NOCAttachmentPage;
import fragmentActivity.NOCScreen.ThankYou;
import fragmentActivity.VisaActivity;
import utilities.Utilities;

/**
 * Created by M_Ghareeb on 9/1/2015.
 */
public class CancelVisaMainFragment extends BaseFragmentFourStepsNew {

    VisaActivity activity;
    private RestRequest restRequest;
    public String eServiceAdmin = "SELECT ID, Name, Service_Identifier__c, Amount__c, Total_Amount__c, Related_to_Object__c, New_Edit_VF_Generator__c, Renewal_VF_Generator__c, Replace_VF_Generator__c, Cancel_VF_Generator__c, Record_Type_Picklist__c, (SELECT ID, Name, Type__c, Language__c, Document_Type__c, Authority__c FROM eServices_Document_Checklists__r) FROM Receipt_Template__c WHERE Service_Identifier__c ='%s'";

    public String getServiceIdentifier() {
        return serviceIdentifier;
    }

    public void setServiceIdentifier(String serviceIdentifier) {
        this.serviceIdentifier = serviceIdentifier;
    }

    private String serviceIdentifier;


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        activity = (VisaActivity) getActivity();
        tvTitle.setText("Cancel Visa");
    }

    @Override
    public Fragment getInitialFragment() {
        return SecondFragment.newInstance("", "");
    }


    @Override
    public Fragment getThirdFragment() {
        return NOCAttachmentPage.newInstance("Third");
    }

    @Override
    public Fragment getFourthFragment() {
        return PayAndSubmitCancelVisa.newInstance("1");
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
        CancelVisaMainFragment fragment = new CancelVisaMainFragment();
        Bundle bundle = new Bundle();
        bundle.putString("text", newCard);
        fragment.setArguments(bundle);
        return fragment;
    }

    // onClick and Validations

    @Override
    public void onClick(View v) {
        if (v == btnNext) {
            if (getStatus() == 1) {
                new ClientManager(getActivity(), SalesforceSDKManager.getInstance().getAccountType(), SalesforceSDKManager.getInstance().getLoginOptions(), SalesforceSDKManager.getInstance().shouldLogoutWhenTokenRevoked()).getRestClient(getActivity(), new ClientManager.RestClientCallback() {
                    @Override
                    public void authenticatedRestClient(final RestClient client) {
                        if (client == null) {
                            SalesforceSDKManager.getInstance().logout(getActivity());
                            return;
                        } else {
                            Utilities.showloadingDialog(activity);
                            createVisaRecord(client);
                        }
                    }
                });

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

    private boolean required() {
        return true;
    }

    //End of onclick and validations
    private void PerfromParentNext() {
        super.onClick(btnNext);
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
            Utilities.showloadingDialog(activity);
        }

        @Override
        protected String doInBackground(String... params) {
            String attUrl = client.getClientInfo().resolveUrl("/services/apexrest/MobileServiceUtilityWebService").toString();

            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(attUrl);
            httppost.setHeader("Authorization", "Bearer " + client.getAuthToken());
            StringEntity entity = null;
            try {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("visaId", activity.getVisa().getID());
                map.put("AccountId", activity.getUser().get_contact().get_account().getID());
                map.put("urgentCancellation", activity.getVisa().Urgent_Stamping_Paid__c);
                map.put("serviceIdentifier", getServiceIdentifier());
                map.put("actionType", "SubmitRequestVisaCancellation");

                entity = new StringEntity("{\"wrapper\":" + new JSONObject(map).toString() + "}", "UTF-8");
                entity.setContentType("application/json");
                httppost.setEntity(entity);
                HttpResponse response = httpclient.execute(httppost);
                result = EntityUtils.toString(response.getEntity());
                Log.d("result", result);
                return result.toLowerCase().contains("success") ? result.replace("\"", "").replace("Success", "") : null;
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
            if (aVoid != null) {
                NiftyDialogBuilder
                        .getInstance(getActivity()).dismiss();
                {
                    activity.setInsertedCaseId(aVoid);

                    new ClientManager(getActivity(), SalesforceSDKManager.getInstance().getAccountType(), SalesforceSDKManager.getInstance().getLoginOptions(), SalesforceSDKManager.getInstance().shouldLogoutWhenTokenRevoked()).getRestClient(getActivity(), new ClientManager.RestClientCallback() {
                        @Override
                        public void authenticatedRestClient(final RestClient client) {
                            if (client == null) {
                                SalesforceSDKManager.getInstance().logout(getActivity());
                                return;
                            } else {

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
                                            Log.d("result", response.toString());
                                            activity.setCaseNumber(jsonRecord.getString("CaseNumber"));
                                            activity.setService_Requested__c(jsonRecord.getString("Service_Requested__c"));
                                            Utilities.dismissLoadingDialog();
                                            getfifthfragment("", activity.getCaseNumber());
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


            }

        }
    }


    private void createVisaRecord(RestClient client) {
        String vRt = activity.getVisa().getRecord_Type_Name__c();
        serviceIdentifier = "";
        if (vRt.equals("Employment Visa Issued") || vRt.equals("Transfer Visa Issued")) {
            serviceIdentifier = "Residency Permit Cancellation";
        } else if ((vRt.equals("Employment Visa Under Process") || vRt.equals("Transfer Visa Under Process")) && activity.getVisa().getResidency_File_Number__c() != null) {
            serviceIdentifier = "Residency Permit Cancellation";
        } else if (vRt.equals("Employment Visa Under Process") || vRt.equals("Transfer Visa Under Process")) {
            serviceIdentifier = "Entry Permit Cancellation";
        } else if (vRt.equals("Visit Visa Issued")) {
            serviceIdentifier = "Visit Visa Cancellation";
        }

        String SoqlEServiceQuery = String.format(eServiceAdmin, serviceIdentifier);
        try {
            restRequest = RestRequest.getRequestForQuery(getActivity().getString(R.string.api_version), SoqlEServiceQuery);
            client.sendAsync(restRequest, new RestClient.AsyncRequestCallback() {

                @Override
                public void onSuccess(RestRequest request, RestResponse result) {

                    activity.seteServiceAdministration(SFResponseManager.parseReceiptObjectResponse(result.toString()).get(0));
                    Utilities.dismissLoadingDialog();
                    performParentNext();

                }

                @Override
                public void onError(Exception exception) {
                    Utilities.showToast(getActivity(), RestMessages.getInstance().getErrorMessage());
                    Utilities.dismissLoadingDialog();
                    getActivity().finish();
                }
            });
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public void performParentNext() {
        super.onClick(btnNext);
    }


}