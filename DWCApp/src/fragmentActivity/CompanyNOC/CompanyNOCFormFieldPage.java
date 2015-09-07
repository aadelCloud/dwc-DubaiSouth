package fragmentActivity.CompanyNOC;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

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
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import RestAPI.RestMessages;
import RestAPI.SFResponseManager;
import RestAPI.SoqlStatements;
import cloudconcept.dwc.R;
import dataStorage.StoreData;

import fragmentActivity.NOCScreen.NocActivity;
import fragmentActivity.NOCScreen.NocMainFragment;
import model.FormField;
import model.Receipt_Template__c;
import model.Visa;
import model.WebForm;
import utilities.Utilities;

/**
 * Created by Abanoub Wagdy on 8/13/2015.
 */

public class CompanyNOCFormFieldPage extends Fragment {

    static Receipt_Template__c eServiceAdministration;
    LinearLayout linearAddForms;
    private String soql;
    JSONObject visaJson;
    ArrayList<FormField> formFields;
    String visaQueryBuilder = "";
    String visaQuery = "Select ID, "+ "%s" +" FROM Account WHERE ID = " + "\'" + "%s" + "\'";
    ;
    Visa _currentVisa;
    static Map<String, String> parameters;
    private static RestRequest restRequest;
    List<FormField> picklist;
    public static Fragment newInstance(String second) {
        CompanyNOCFormFieldPage fragment = new CompanyNOCFormFieldPage();
        Bundle bundle = new Bundle();
        bundle.putString("text", second);
        fragment.setArguments(bundle);
        parameters = new HashMap<String, String>();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.noc_second_page, container, false);
        InitializeViews(view);
        parameters.put("auth", new StoreData(getActivity()).getNOCAuthorityType());
        parameters.put("lang", new StoreData(getActivity().getApplicationContext()).getNOCLanguage());
        eServiceAdministration = Utilities.geteServiceAdministration();
        soql = SoqlStatements.getInstance().constructWebFormQuery(eServiceAdministration.getNew_Edit_VF_Generator__c());
        perFormFormFieldsRequest(soql);
        return view;
    }

    private void InitializeViews(View view) {
        linearAddForms = (LinearLayout) view.findViewById(R.id.linearAddForms);
    }

    private void perFormFormFieldsRequest(String soql) {
        try {
            restRequest = RestRequest.getRequestForQuery(getString(R.string.api_version), soql);
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
                                picklist=new ArrayList<FormField>();

                                Log.d("", result.toString());
                                CompanyNocMainFragment._webForm = SFResponseManager.parseWebFormObject(result.toString());
                                for (int i = 0; i < CompanyNocMainFragment._webForm.get_formFields().size(); i++) {
                                    if (!CompanyNocMainFragment._webForm.get_formFields().get(i).getType().equals("CUSTOMTEXT") && CompanyNocMainFragment._webForm.get_formFields().get(i).isParameter() == false && CompanyNocMainFragment._webForm.get_formFields().get(i).isQuery() == true) {
                                        visaQueryBuilder += CompanyNocMainFragment._webForm.get_formFields().get(i).getTextValue() + ",";
                                    }else if(!CompanyNocMainFragment._webForm.get_formFields().get(i).isParameter()&&CompanyNocMainFragment._webForm.get_formFields().get(i).getType().equals("PICKLIST")){
                                        picklist.add(CompanyNocMainFragment._webForm.get_formFields().get(i));

                                    }
                                }


                                visaQueryBuilder = visaQueryBuilder.substring(0, visaQueryBuilder.length() - 1);
                                visaQuery = String.format(visaQuery, visaQueryBuilder, CompanyNocMainFragment.user.get_contact().get_account().getID());
                                PerformVisaQueryValues(CompanyNocMainFragment._webForm, visaQuery);
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

    private void PerformVisaQueryValues(final WebForm _webFormFields, String visaQuery) {
        try {
            restRequest = RestRequest.getRequestForQuery(getString(R.string.api_version), visaQuery);
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
                                visaJson=SFResponseManager.parseJsonVisaData(result.toString());
                                Utilities.dismissLoadingDialog();
                                formFields=_webFormFields.get_formFields();
                                new ClientManager(getActivity(), SalesforceSDKManager.getInstance().getAccountType(), SalesforceSDKManager.getInstance().getLoginOptions(), SalesforceSDKManager.getInstance().shouldLogoutWhenTokenRevoked()).getRestClient(getActivity(), new ClientManager.RestClientCallback() {
                                    @Override
                                    public void authenticatedRestClient(final RestClient client) {
                                        if (client == null) {
                                            System.exit(0);
                                        } else {

                                            new GetPickLists(client).execute(picklist);


                                        }
                                    }
                                });
                                Log.d("Hello", result.toString());
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


    public class GetPickLists extends AsyncTask<List<FormField>, Void, Map<String,List<String>>> {

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
        protected Map<String,List<String>> doInBackground(List<FormField>... params) {
            String attUrl = client.getClientInfo().resolveUrl("/services/apexrest/MobilePickListValuesWebService?fieldId=").toString();
            for(FormField fieldId:params[0]) {
                HttpClient tempClient = new DefaultHttpClient();


                URI theUrl = null;
                try {
                    theUrl = new URI(attUrl+fieldId.getId());
                    HttpGet getRequest = new HttpGet();

                    getRequest.setURI(theUrl);
                    getRequest.setHeader("Authorization", "Bearer " + client.getAuthToken());
                    BasicHttpParams param = new BasicHttpParams();

//                    param.setParameter("fieldId", fieldId);
                    getRequest.setParams(param);
                    HttpResponse httpResponse = null;
                    try {
                        httpResponse = tempClient.execute(getRequest);
                        StatusLine statusLine = httpResponse.getStatusLine();
                        if (statusLine.getStatusCode() == HttpStatus.SC_OK) {
                            HttpEntity httpEntity = httpResponse.getEntity();

                            if (httpEntity != null) {
                                result = EntityUtils.toString(httpEntity);
                                JSONObject jo= null;
                                try {
                                    jo = new JSONObject(result);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                JSONArray ja= null;
                                try {
                                    ja = jo.getJSONArray(parameters.get("auth"));
                                    fieldId.setPicklistEntries(convertJsonStringToString(ja));
                                } catch (JSONException e) {
                                    e.printStackTrace();

                                }


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
            }
            return null;
        }

        @Override
        protected void onPostExecute(Map<String,List<String>> aVoid) {
            super.onPostExecute(aVoid);
            Utilities.dismissLoadingDialog();
            Utilities.DrawFormFieldsOnLayout(getActivity(), getActivity().getApplicationContext(), linearAddForms, formFields, _currentVisa, visaJson, parameters,CompanyNocMainFragment._noc);

        }
    }
    public static String convertJsonStringToString(JSONArray jsonArray){
        String result="";
        for(int i=0;i<jsonArray.length();i++){
            try {
                result+=jsonArray.getString(i);
                if(i!=(jsonArray.length()-1))
                    result+=",";
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}