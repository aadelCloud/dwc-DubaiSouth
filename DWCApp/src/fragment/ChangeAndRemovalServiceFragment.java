package fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.rest.ClientManager;
import com.salesforce.androidsdk.rest.RestClient;
import com.salesforce.androidsdk.rest.RestRequest;
import com.salesforce.androidsdk.rest.RestResponse;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;

import RestAPI.RelatedServiceType;
import RestAPI.SFResponseManager;
import cloudconcept.dwc.R;
import fragment.companychangeservices.AttachmentPage;
import fragment.companychangeservices.InitialPage;
import fragment.companychangeservices.PreviewPage;
import fragment.companychangeservices.ThankYouPage;
import fragmentActivity.ChangeAndRemovalActivity;
import model.Case;
import model.Receipt_Template__c;
import utilities.Utilities;

/**
 * Created by Abanoub Wagdy on 9/2/2015.
 */
public class ChangeAndRemovalServiceFragment extends BaseFragmentFourSteps {

    private static final String ARG_TEXT = "BaseFragment";
    ChangeAndRemovalActivity activity;
    private String result;
    private RestRequest restRequest;
    private Receipt_Template__c eServiceAdministration;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        activity = (ChangeAndRemovalActivity) getActivity();
        if (getActivity() instanceof ChangeAndRemovalActivity) {
            activity = (ChangeAndRemovalActivity) getActivity();
            tvTitle.setText(activity.getScreenTitle());
        }
    }

    @Override
    public Fragment getInitialFragment() {
        return InitialPage.newInstance("Initial");
    }

    @Override
    public Fragment getSecondFragment() {
        return AttachmentPage.newInstance("Attachment");
    }

    @Override
    public Fragment getThirdFragment() {
        return PreviewPage.newInstance("Preview");
    }

    @Override
    public Fragment getFourthFragment() {
        return ThankYouPage.newInstance("Thank You");
    }

    @Override
    public RelatedServiceType getRelatedService() {
        if (activity.getMethodName().equals("CreateRequestAddressChange")) {
            return RelatedServiceType.RelatedServiceTypeCompanyAddressChange;
        } else if (activity.getMethodName().equals("CreateRequestNameChange")) {
            return RelatedServiceType.RelatedServiceTypeCompanyNameChange;
        } else if (activity.getMethodName().equals("CreateRequestCapitalChange")) {
            return RelatedServiceType.RelatedServiceTypeCompanyCapitalChange;
        } else if (activity.getMethodName().equals("CreateRequestDirectorRemoval")) {
            return RelatedServiceType.RelatedServiceTypeDirecorRemoval;
        } else {
            return null;
        }
    }

    public static ChangeAndRemovalServiceFragment newInstance(String text) {
        ChangeAndRemovalServiceFragment fragment = new ChangeAndRemovalServiceFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_TEXT, text);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onClick(View v) {
        if (v == btnNext) {
            if (status == 1) {
                if (getRelatedService() == RelatedServiceType.RelatedServiceTypeDirecorRemoval) {
                    DoDirectorRemovalRequest();
                } else if (getRelatedService() == RelatedServiceType.RelatedServiceTypeCompanyAddressChange) {
                    if (activity.getCurrentEmail().equals(activity.getNewEmail()) && activity.getCurrentMobile().equals(activity.getNewMobile()) && activity.getCurrentFax().equals(activity.getNewFax()) && activity.getCurrentPoBox().equals(activity.getNewPoBox())) {
                        Utilities.showLongToast(getActivity(), "You should change at least one attribute to complete the process");
                    } else if (activity.getNewEmail().equals("") || activity.getNewMobile().equals("") || activity.getNewPoBox().equals("") || activity.getNewFax().equals("")) {
                        Utilities.showLongToast(getActivity(), "Please fill all required fields");
                    } else {
                        DoCompanyAddressChangeRequest();
                    }
                } else if (getRelatedService() == RelatedServiceType.RelatedServiceTypeCompanyCapitalChange) {
                    if (Long.valueOf(activity.getNewShareCapital()) < 300000) {
                        Utilities.showLongToast(getActivity(), "Your New Share Capital must be not less that 300000");
                    } else {
                        DoCapitalChangeRequest();
                    }

                } else if (getRelatedService() == RelatedServiceType.RelatedServiceTypeCompanyNameChange) {
                    DoNameChangeRequest();
                }
            } else if (status == 2) {
                boolean isEmptyAttachment = false;
                if (activity.getCompanyDocuments() != null && activity.getCompanyDocuments().size() > 0) {
                    for (int i = 0; i < activity.getCompanyDocuments().size(); i++) {
                        if (activity.getCompanyDocuments().get(i).getAttachment_Id__c() == null || activity.getCompanyDocuments().get(i).getAttachment_Id__c().equals("")) {
                            isEmptyAttachment = true;
                            break;
                        }
                    }
                }
                if (isEmptyAttachment == false) {
                    super.onClick(v);
                } else {
                    Utilities.showLongToast(getActivity(), "Please fill all attachments");
                }
            } else if (status == 3) {
                DoSubmitRequest();

            } else {
                super.onClick(v);
            }
        } else {
            super.onClick(v);
        }
    }

    private void DoSubmitRequest() {
        new ClientManager(getActivity(), SalesforceSDKManager.getInstance().getAccountType(), SalesforceSDKManager.getInstance().getLoginOptions(), SalesforceSDKManager.getInstance().shouldLogoutWhenTokenRevoked()).getRestClient(getActivity(), new ClientManager.RestClientCallback() {
            @Override
            public void authenticatedRestClient(final RestClient client) {
                if (client == null) {
                    System.exit(0);
                } else {
                    new SubmitRequestTask(client).execute();
                }
            }
        });
    }

    private void DoNameChangeRequest() {
        new ClientManager(getActivity(), SalesforceSDKManager.getInstance().getAccountType(), SalesforceSDKManager.getInstance().getLoginOptions(), SalesforceSDKManager.getInstance().shouldLogoutWhenTokenRevoked()).getRestClient(getActivity(), new ClientManager.RestClientCallback() {
            @Override
            public void authenticatedRestClient(final RestClient client) {
                if (client == null) {
                    System.exit(0);
                } else {
                    new CreateNameChangeRequest(client).execute();
                }
            }
        });
    }

    public class SubmitRequestTask extends AsyncTask<Void, Void, Void> {

        private RestClient client;

        public SubmitRequestTask(RestClient client) {
            this.client = client;
        }

        @Override
        protected void onPreExecute() {
            Utilities.showloadingDialog(activity);
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            String attUrl = client.getClientInfo().resolveUrl("/services/apexrest/MobileServiceUtilityWebService").toString();
            HttpClient tempClient = new DefaultHttpClient();
            URI theUrl = null;
            try {
                JSONObject parent = new JSONObject();
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject();
//                    if (getRelatedService() == RelatedServiceType.RelatedServiceTypeDirecorRemoval) {
////                        jsonObject.put("directorId", activity.getDirectorship().getID());
////                        jsonObject.put("AccountId", activity.getUser().get_contact().get_account().getID());
//                        jsonObject.put("caseId", activity.getCaseId());
//                    } else if (getRelatedService() == RelatedServiceType.RelatedServiceTypeCompanyCapitalChange) {
////                        jsonObject.put("AccountId", activity.getUser().get_contact().get_account().getID());
////                        jsonObject.put("newCapital", activity.getNewShareCapital());
//                        jsonObject.put("caseId", activity.getCaseId());
//                    } else if (getRelatedService() == RelatedServiceType.RelatedServiceTypeCompanyAddressChange) {
////                        jsonObject.put("AccountId", activity.getUser().get_contact().get_account().getID());
////                        jsonObject.put("poBox", activity.getNewPoBox());
////                        jsonObject.put("email", activity.getNewEmail());
////                        jsonObject.put("mobile", activity.getNewMobile());
////                        jsonObject.put("fax", activity.getNewFax());
//                        jsonObject.put("caseId", activity.getCaseId());
//                    } else if (getRelatedService() == RelatedServiceType.RelatedServiceTypeCompanyNameChange) {
////                        jsonObject.put("directorId", activity.getDirectorship().getID());
////                        jsonObject.put("newEnName", activity.getNewCompanyName());
////                        jsonObject.put("newARName", activity.getNewCompanyNameArabic());
//                        jsonObject.put("caseId", activity.getCaseId());
//                    }
                    jsonObject.put("caseId", activity.getCaseId());
                    jsonObject.put("actionType", activity.getSubmitMethodName());
                    parent.put("wrapper", jsonObject);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                theUrl = new URI(attUrl);
                HttpPost getRequest = new HttpPost();

                getRequest.setURI(theUrl);
                getRequest.setHeader("Authorization", "Bearer " + client.getAuthToken());
                HttpResponse httpResponse = null;
                StringEntity se = null;
                try {
                    se = new StringEntity(parent.toString());
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                se.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
                getRequest.setEntity(se);
                try {
                    httpResponse = tempClient.execute(getRequest);
                    StatusLine statusLine = httpResponse.getStatusLine();
                    if (statusLine.getStatusCode() == HttpStatus.SC_OK) {
                        HttpEntity httpEntity = httpResponse.getEntity();
                        Log.d("response", httpEntity.toString());
                        if (httpEntity != null) {
                            result = EntityUtils.toString(httpEntity);
                            activity.setCaseId(result.substring(8, result.length() - 1));

                        }
                    } else {
                        httpResponse.getEntity().getContent().close();
                        throw new IOException(statusLine.getReasonPhrase());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Utilities.dismissLoadingDialog();
            if (result.contains("Success")) {
                PerformParentNext(btnNext);
            }
        }
    }

    private void DoCapitalChangeRequest() {
        new ClientManager(getActivity(), SalesforceSDKManager.getInstance().getAccountType(), SalesforceSDKManager.getInstance().getLoginOptions(), SalesforceSDKManager.getInstance().shouldLogoutWhenTokenRevoked()).getRestClient(getActivity(), new ClientManager.RestClientCallback() {
            @Override
            public void authenticatedRestClient(final RestClient client) {
                if (client == null) {
                    System.exit(0);
                } else {
                    new CreateCapitalChangeRequest(client).execute();
                }
            }
        });
    }

    private void DoCompanyAddressChangeRequest() {
        new ClientManager(getActivity(), SalesforceSDKManager.getInstance().getAccountType(), SalesforceSDKManager.getInstance().getLoginOptions(), SalesforceSDKManager.getInstance().shouldLogoutWhenTokenRevoked()).getRestClient(getActivity(), new ClientManager.RestClientCallback() {
            @Override
            public void authenticatedRestClient(final RestClient client) {
                if (client == null) {
                    System.exit(0);
                } else {
                    new CreateCompanyAddressChangeRequest(client).execute();
                }
            }
        });
    }

    private void DoDirectorRemovalRequest() {
        new ClientManager(getActivity(), SalesforceSDKManager.getInstance().getAccountType(), SalesforceSDKManager.getInstance().getLoginOptions(), SalesforceSDKManager.getInstance().shouldLogoutWhenTokenRevoked()).getRestClient(getActivity(), new ClientManager.RestClientCallback() {
            @Override
            public void authenticatedRestClient(final RestClient client) {
                if (client == null) {
                    System.exit(0);
                } else {
                    new CreateDirectorRemovalRequest(client).execute();
                }
            }
        });
    }


    public class CreateCapitalChangeRequest extends AsyncTask<Void, Void, Void> {

        private RestClient client;

        public CreateCapitalChangeRequest(RestClient client) {
            this.client = client;
        }

        @Override
        protected void onPreExecute() {
            Utilities.showloadingDialog(activity);
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            String attUrl = client.getClientInfo().resolveUrl("/services/apexrest/MobileServiceUtilityWebService").toString();
            HttpClient tempClient = new DefaultHttpClient();
            URI theUrl = null;
            try {
                JSONObject parent = new JSONObject();
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject();
                    jsonObject.put("AccountId", activity.getUser().get_contact().get_account().getID());
                    jsonObject.put("newCapital", activity.getNewShareCapital());
                    jsonObject.put("actionType", activity.getMethodName());
                    parent.put("wrapper", jsonObject);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                theUrl = new URI(attUrl);
                HttpPost getRequest = new HttpPost();

                getRequest.setURI(theUrl);
                getRequest.setHeader("Authorization", "Bearer " + client.getAuthToken());
                HttpResponse httpResponse = null;
                StringEntity se = null;
                try {
                    se = new StringEntity(parent.toString());
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                se.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
                getRequest.setEntity(se);
                try {
                    httpResponse = tempClient.execute(getRequest);
                    StatusLine statusLine = httpResponse.getStatusLine();
                    if (statusLine.getStatusCode() == HttpStatus.SC_OK) {
                        HttpEntity httpEntity = httpResponse.getEntity();
                        Log.d("response", httpEntity.toString());
                        if (httpEntity != null) {
                            result = EntityUtils.toString(httpEntity);
                            activity.setCaseId(result.substring(8, result.length() - 1));
                        }
                    } else {
                        httpResponse.getEntity().getContent().close();
                        throw new IOException(statusLine.getReasonPhrase());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if (result.contains("Success")) {
                getCaseInfo(client);
            } else {
                Utilities.dismissLoadingDialog();
            }
        }
    }

    public class CreateCompanyAddressChangeRequest extends AsyncTask<Void, Void, Void> {

        private RestClient client;

        public CreateCompanyAddressChangeRequest(RestClient client) {
            this.client = client;
        }

        @Override
        protected void onPreExecute() {
            Utilities.showloadingDialog(activity);
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            String attUrl = client.getClientInfo().resolveUrl("/services/apexrest/MobileServiceUtilityWebService").toString();
            HttpClient tempClient = new DefaultHttpClient();
            URI theUrl = null;
            try {
                JSONObject parent = new JSONObject();
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject();
                    jsonObject.put("AccountId", activity.getUser().get_contact().get_account().getID());
                    jsonObject.put("poBox", activity.getNewPoBox());
                    jsonObject.put("email", activity.getNewEmail());
                    jsonObject.put("mobile", activity.getNewMobile());
                    jsonObject.put("fax", activity.getNewFax());
                    jsonObject.put("actionType", activity.getMethodName());
                    parent.put("wrapper", jsonObject);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                theUrl = new URI(attUrl);
                HttpPost getRequest = new HttpPost();

                getRequest.setURI(theUrl);
                getRequest.setHeader("Authorization", "Bearer " + client.getAuthToken());
                HttpResponse httpResponse = null;
                StringEntity se = null;
                try {
                    se = new StringEntity(parent.toString());
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                se.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
                getRequest.setEntity(se);
                try {
                    httpResponse = tempClient.execute(getRequest);
                    StatusLine statusLine = httpResponse.getStatusLine();
                    if (statusLine.getStatusCode() == HttpStatus.SC_OK) {
                        HttpEntity httpEntity = httpResponse.getEntity();
                        Log.d("response", httpEntity.toString());
                        if (httpEntity != null) {
                            result = EntityUtils.toString(httpEntity);
                            activity.setCaseId(result.substring(8, result.length() - 1));
                        }
                    } else {
                        httpResponse.getEntity().getContent().close();
                        throw new IOException(statusLine.getReasonPhrase());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if (result.contains("Success")) {
                getCaseInfo(client);
            } else {
                Utilities.dismissLoadingDialog();
            }
        }
    }

    public class CreateNameChangeRequest extends AsyncTask<Void, Void, Void> {

        private RestClient client;

        public CreateNameChangeRequest(RestClient client) {
            this.client = client;
        }

        @Override
        protected void onPreExecute() {
            Utilities.showloadingDialog(activity);
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            String attUrl = client.getClientInfo().resolveUrl("/services/apexrest/MobileServiceUtilityWebService").toString();
            HttpClient tempClient = new DefaultHttpClient();
            URI theUrl = null;
            try {
                JSONObject parent = new JSONObject();
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject();
//                    jsonObject.put("directorId", activity.getDirectorship().getID());
                    jsonObject.put("AccountId", activity.getUser().get_contact().get_account().getID());
                    jsonObject.put("newEnName", activity.getNewCompanyName());
                    jsonObject.put("newARName", activity.getNewCompanyNameArabic());
                    jsonObject.put("actionType", activity.getMethodName());
                    parent.put("wrapper", jsonObject);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                theUrl = new URI(attUrl);
                HttpPost getRequest = new HttpPost();

                getRequest.setURI(theUrl);
                getRequest.setHeader("Authorization", "Bearer " + client.getAuthToken());
                HttpResponse httpResponse = null;
                StringEntity se = null;
                try {
                    se = new StringEntity(parent.toString());
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                se.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
                getRequest.setEntity(se);
                try {
                    httpResponse = tempClient.execute(getRequest);
                    StatusLine statusLine = httpResponse.getStatusLine();
                    if (statusLine.getStatusCode() == HttpStatus.SC_OK) {
                        HttpEntity httpEntity = httpResponse.getEntity();
                        Log.d("response", httpEntity.toString());
                        if (httpEntity != null) {
                            result = EntityUtils.toString(httpEntity);
//                            if (!result.contains("Error")) {
//                                activity.setCaseId(result.substring(8, result.length() - 1));
//                            }
                        }
                    } else {
                        httpResponse.getEntity().getContent().close();
                        throw new IOException(statusLine.getReasonPhrase());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if (result.contains("Success")) {
                activity.setCaseId(result.substring(8, result.length() - 1));
                getCaseInfo(client);
            } else {
                Utilities.dismissLoadingDialog();
                Utilities.showLongToast(getActivity(), "Error Please try again later");
            }
        }
    }

    public class CreateDirectorRemovalRequest extends AsyncTask<Void, Void, Void> {

        private RestClient client;

        public CreateDirectorRemovalRequest(RestClient client) {
            this.client = client;
        }

        @Override
        protected void onPreExecute() {
            Utilities.showloadingDialog(activity);
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            String attUrl = client.getClientInfo().resolveUrl("/services/apexrest/MobileServiceUtilityWebService").toString();
            HttpClient tempClient = new DefaultHttpClient();
            URI theUrl = null;
            try {
                JSONObject parent = new JSONObject();
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject();
                    jsonObject.put("directorId", activity.getDirectorship().getID());
                    jsonObject.put("AccountId", activity.getUser().get_contact().get_account().getID());
                    jsonObject.put("actionType", activity.getMethodName());
                    parent.put("wrapper", jsonObject);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                theUrl = new URI(attUrl);
                HttpPost getRequest = new HttpPost();

                getRequest.setURI(theUrl);
                getRequest.setHeader("Authorization", "Bearer " + client.getAuthToken());
                HttpResponse httpResponse = null;
                StringEntity se = null;
                try {
                    se = new StringEntity(parent.toString());
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                se.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
                getRequest.setEntity(se);
                try {
                    httpResponse = tempClient.execute(getRequest);
                    StatusLine statusLine = httpResponse.getStatusLine();
                    if (statusLine.getStatusCode() == HttpStatus.SC_OK) {
                        HttpEntity httpEntity = httpResponse.getEntity();
                        Log.d("response", httpEntity.toString());
                        if (httpEntity != null) {
                            result = EntityUtils.toString(httpEntity);
                            activity.setCaseId(result.substring(8, result.length() - 1));

                        }
                    } else {
                        httpResponse.getEntity().getContent().close();
                        throw new IOException(statusLine.getReasonPhrase());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if (result.contains("Success")) {
                getCaseInfo(client);
            } else {
                Utilities.dismissLoadingDialog();
            }
        }
    }

    private void getCaseInfo(final RestClient client) {
        String soql = "select id , CaseNumber , Service_Requested__c , Registration_Amendment__r.Service_Identifier__c , Registration_Amendment__c , Registration_Amendment__r.Require_Fees__c , Invoice__c , Invoice__r.Amount__c  from Case where Id=" + "\'" + activity.getCaseId() + "\'";
        try {
            restRequest = RestRequest.getRequestForQuery(activity.getString(R.string.api_version), soql);
            client.sendAsync(restRequest, new RestClient.AsyncRequestCallback() {
                @Override
                public void onSuccess(RestRequest request, RestResponse response) {
                    Case caseDirectorRemoval = SFResponseManager.parseCaseObject(response.toString());
                    activity.setCaseObject(caseDirectorRemoval);
                    if (activity.getMethodName().equals("CreateRequestAddressChange")) {
                        Utilities.dismissLoadingDialog();
                        PerformParentNext(btnNext);
                    } else {
                        getEServiceAdminInfo(client, activity.getCaseObject().getService_Requested__c());
                    }
                }

                @Override
                public void onError(Exception exception) {
                    Utilities.dismissLoadingDialog();
                }
            });
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private void getEServiceAdminInfo(RestClient client, String service_requested__c) {
        String soql = "SELECT ID, Name, Display_Name__c, Service_Identifier__c, Amount__c, Total_Amount__c, Related_to_Object__c, New_Edit_VF_Generator__c, Renewal_VF_Generator__c, Replace_VF_Generator__c, Cancel_VF_Generator__c, Record_Type_Picklist__c, (SELECT ID, Name, Type__c, Language__c, Document_Type__c, Authority__c FROM eServices_Document_Checklists__r) FROM Receipt_Template__c WHERE Id=" + "\'" + service_requested__c + "\'" + "LIMIT 1";
        try {
            restRequest = RestRequest.getRequestForQuery(activity.getString(R.string.api_version), soql);
            client.sendAsync(restRequest, new RestClient.AsyncRequestCallback() {
                @Override
                public void onSuccess(RestRequest request, RestResponse response) {
                    Utilities.dismissLoadingDialog();
                    eServiceAdministration = SFResponseManager.parseReceiptObjectResponse(response.toString()).get(0);
                    activity.setEServiceAdmin(eServiceAdministration);
                    PerformParentNext(btnNext);
                }

                @Override
                public void onError(Exception exception) {
                    Utilities.dismissLoadingDialog();
                }
            });
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private void PerformParentNext(Button btnNext) {
        super.onClick(btnNext);
    }

    public View getButtonNext() {

        return btnNext;
    }

}
