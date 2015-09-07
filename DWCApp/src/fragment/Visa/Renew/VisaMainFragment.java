package fragment.Visa.Renew;

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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import RestAPI.JSONConstants;
import RestAPI.RestMessages;
import RestAPI.SFResponseManager;
import RestAPI.SoqlStatements;
import cloudconcept.dwc.R;
import custom.customdialog.NiftyDialogBuilder;
import fragment.BaseFragmentFiveSteps;
import fragment.Visa.NOCAttachmentPage;
import fragment.Visa.PayAndSubmit;
import fragmentActivity.NOCScreen.ThankYou;
import fragmentActivity.VisaActivity;
import utilities.Utilities;

/**
 * Created by M_Ghareeb on 8/30/2015.
 */
public class VisaMainFragment extends BaseFragmentFiveSteps {
    VisaActivity activity;
    private RestRequest restRequest;
    public String eServiceAdmin = "SELECT ID, Name, Service_Identifier__c, Amount__c, Total_Amount__c, Related_to_Object__c, New_Edit_VF_Generator__c, Renewal_VF_Generator__c, Replace_VF_Generator__c, Cancel_VF_Generator__c, Record_Type_Picklist__c, (SELECT ID, Name, Type__c, Language__c, Document_Type__c, Authority__c FROM eServices_Document_Checklists__r) FROM Receipt_Template__c WHERE Id='%s'";

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        activity = (VisaActivity) getActivity();
        tvTitle.setText("Renew Visa");
    }

    @Override
    public Fragment getInitialFragment() {
        return InitialPage.newInstance("Renew");
    }

    @Override
    public Fragment getSecondFragment() {
        return SecondFragment.newInstance("", "");
    }

    @Override
    public Fragment getThirdFragment() {
        return NOCAttachmentPage.newInstance("Third");
    }

    @Override
    public Fragment getFourthFragment() {
        return PayAndSubmit.newInstance("1");
    }

    @Override
    public Fragment getFifthFragment(String msg, String fee, String mail) {
        return ThankYou.newInstance(msg, fee, mail);
    }

    @Override
    public RelatedServiceType getRelatedService() {
        return null;
    }


    // onClick and Validations

    @Override
    public void onClick(View v) {
        if (v == btnNext) {
            if (getStatus() == 1) {
                String Expiry = activity.getVisa().getPassport_Expiry__c();
                long yourmilliseconds = System.currentTimeMillis();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date resultdate = new Date(yourmilliseconds);
                Calendar now = Calendar.getInstance();
                now.setTime(resultdate);
                try {
                    Date expiryDate = sdf.parse(Expiry);
                    now.add(Calendar.MONTH, 6);
                    if (sdf.parse(sdf.format(now.getTime())).compareTo(expiryDate) < 0) {
                        Utilities.showloadingDialog(activity);
                        new ClientManager(getActivity(), SalesforceSDKManager.getInstance().getAccountType(), SalesforceSDKManager.getInstance().getLoginOptions(), SalesforceSDKManager.getInstance().shouldLogoutWhenTokenRevoked()).getRestClient(getActivity(), new ClientManager.RestClientCallback() {
                                    @Override
                                    public void authenticatedRestClient(final RestClient client) {
                                        if (client == null) {
                                            System.exit(0);
                                        } else {
                                            if (activity.getVisa().getPassport_Number__c().equals(activity.getVisa().getOldPass())) {
                                                Utilities.dismissLoadingDialog();
                                                performParentNext();

                                            } else {
                                                try {
                                                    restRequest = RestRequest.getRequestForQuery(activity.getString(R.string.api_version), "select id from Passport__c where name = '" + activity.getVisa().getPassport_Number__c() + "' and Passport_Issue_Country__c ='" + activity.getVisa().getPassport_Issue_Country__c() + "'");
                                                    client.sendAsync(restRequest, new RestClient.AsyncRequestCallback() {
                                                                @Override
                                                                public void onSuccess(RestRequest request, RestResponse response) {
                                                                    JSONObject jsonVisas = null;
                                                                    try {
                                                                        jsonVisas = new JSONObject(response.toString());
                                                                        if (jsonVisas.optBoolean(JSONConstants.DONE)) {

                                                                            JSONArray jsonArrayVisas = jsonVisas.getJSONArray(JSONConstants.RECORDS);
                                                                            if (jsonArrayVisas.length() > 0) {
                                                                                Utilities.showLongToast(activity, "A duplicate entry found in the system with the same Passport number and Passport Issue country.");
                                                                                Utilities.dismissLoadingDialog();
                                                                            } else {
                                                                                Utilities.dismissLoadingDialog();
                                                                                performParentNext();

                                                                            }

                                                                        }
                                                                    } catch (JSONException e) {
                                                                        e.printStackTrace();
                                                                        Utilities.dismissLoadingDialog();
                                                                    }

                                                                }

                                                                @Override
                                                                public void onError(Exception exception) {
                                                                    Utilities.dismissLoadingDialog();
                                                                }
                                                            }

                                                    );
                                                } catch (UnsupportedEncodingException e) {
                                                    e.printStackTrace();
                                                }
                                            }
//


                                        }
                                    }
                                }

                        );

                    } else {
                        Utilities.showLongToast(activity, "passport validity should be at least 6 months from today");
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                    Utilities.showLongToast(activity, "Expiry Date should be Valid (YYYY-MM-DD)");
                }


            } else if (getStatus() == 2) {

                new ClientManager(getActivity(), SalesforceSDKManager.getInstance().getAccountType(), SalesforceSDKManager.getInstance().getLoginOptions(), SalesforceSDKManager.getInstance().shouldLogoutWhenTokenRevoked()).getRestClient(getActivity(), new ClientManager.RestClientCallback() {
                    @Override
                    public void authenticatedRestClient(final RestClient client) {
                        if (client == null) {
                            System.exit(0);
                        } else {
                            new AsyncCreateCase(client).execute();
                        }
                    }
                });


            }  else if (getStatus() == 3) {
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

    public static Fragment newInstance(String newCard) {
        VisaMainFragment fragment = new VisaMainFragment();
        Bundle bundle = new Bundle();
        bundle.putString("text", newCard);
        fragment.setArguments(bundle);
        return fragment;
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

    public class AsyncCreateCase extends AsyncTask<Void, Void, String> {
        RestClient client;
        private String result;

        public AsyncCreateCase(RestClient client) {
            this.client = client;
            Utilities.showloadingDialog(activity);
        }


        @Override
        protected String doInBackground(Void... voids) {
            String attUrl = client.getClientInfo().resolveUrl("/services/apexrest/MobileSubmitRenewVisaWebService").toString();

            DefaultHttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(attUrl);
            httppost.setHeader("Authorization", "Bearer " + client.getAuthToken());
            Map<String, String> map = new HashMap<String, String>();
            map.put("AccountId", activity.getUser().get_contact().get_account().getID());
            map.put("Applicant_Email", activity.getVisa().getApplicant_Email__c());
            map.put("Applicant_Mobile_Number", activity.getVisa().getApplicant_Mobile_Number__c());
            map.put("Marital_Status", activity.getVisa().getMarital_Status__c());
            map.put("Mother_Name", activity.getVisa().getMother_Name__c());
            map.put("Religion", activity.getVisa().getReligion__c());
            map.put("Languages", activity.getVisa().getLanguages__c());
            map.put("Passport_Number", activity.getVisa().getPassport_Number__c());
            map.put("Job_Title_at_Immigration", activity.getVisa().getJob_Title_at_Immigration__r().getID());
            map.put("Qualification", activity.getVisa().getQualification__c());
            map.put("Passport_Issue_Country", activity.getVisa().getPassport_Issue_Country__c());
            map.put("Passport_Place_of_Issue", activity.getVisa().getPassport_Place_of_Issue__c());
            map.put("RenewalForVisa", activity.getVisa().getRenewal_for_Visa__c());
            map.put("VisaId", activity.getVisa().getID());
            map.put("PassportHolderId", activity.getVisa().getPassport__r().getPassport_Holder__c());
            map.put("Passport_Expiry_Date", activity.getVisa().getPassport_Expiry__c());
            map.put("Monthly_Basic_Salary_in_AED", String.valueOf(activity.getVisa().getMonthly_Basic_Salary_in_AED__c()));
            map.put("Monthly_Allowances_in_AED", String.valueOf(activity.getVisa().getMonthly_Allowances_in_AED__c()));
            map.put("In_Country", activity.getVisa().getCurrent_Nationality__c());
            map.put("Local_Amendment", String.valueOf(activity.getVisa().Local_Amendment_Paid__c));
            map.put("Urgent_Processing", String.valueOf(activity.getVisa().urgent_Processing_Paid__c));
            map.put("Urgent_Stamping", String.valueOf(activity.getVisa().Urgent_Stamping_Paid__c));


            StringEntity entity = null;
            try {
                entity = new StringEntity("{\"wrapper\":" + new JSONObject(map).toString() + "}", "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            entity.setContentType("application/json");
            httppost.setEntity(entity);
            HttpResponse response = null;
            try {
                response = httpclient.execute(httppost);
                result = EntityUtils.toString(response.getEntity());
            } catch (IOException e) {
                e.printStackTrace();
            }

            Log.d("result", result);

            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (s != null) {
                activity.setInsertedCaseId(s.replace("\"", ""));

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

                                        createVisaRecord(client);
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


    private void createVisaRecord(RestClient client) {
        String SoqlEServiceQuery = String.format(eServiceAdmin, activity.getService_Requested__c());
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
                    VolleyError volleyError = (VolleyError) exception;
                    NetworkResponse response = volleyError.networkResponse;
                    String json = new String(response.data);
                    Log.d("", json);
                    Utilities.dismissLoadingDialog();
                    getActivity().finish();
                }
            });
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private void performParentNext() {
        super.onClick(btnNext);
    }

}