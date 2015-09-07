package fragment.Cards.NewCard;

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
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import RestAPI.RestMessages;
import RestAPI.SFResponseManager;
import RestAPI.SoqlStatements;
import cloudconcept.dwc.R;
import fragmentActivity.CardActivity;
import model.Country__c;
import model.FormField;
import utilities.Utilities;

/**
 * Created by Abanoub Wagdy on 8/24/2015.
 */
public class NewCardFormFieldPage extends Fragment {

    private LinearLayout linearAddForms;
    private String soql;
    private RestRequest restRequest;
    private ArrayList<FormField> picklist;
    private ArrayList<FormField> reference;
    String cardQuery = "Select ID, " + "%s" + " FROM Card_Management__c WHERE ID = " + "\'" + "%s" + "\'";
    private String CardQueryBuilder = "";
    private JSONObject Cardjson;
    private ArrayList<FormField> formFields;
    CardActivity activity;

    public static Fragment newInstance(String newCard) {
        NewCardFormFieldPage fragment = new NewCardFormFieldPage();
        Bundle bundle = new Bundle();
        bundle.putString("text", newCard);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.noc_second_page, container, false);
        InitializeViews(view);
        soql = SoqlStatements.getInstance().constructWebFormQuery(activity.geteServiceAdministration().getNew_Edit_VF_Generator__c());
        perFormFormFieldsRequest();
        return view;
    }

    private void perFormFormFieldsRequest() {

        Utilities.showloadingDialog(getActivity());
        try {
            restRequest = RestRequest.getRequestForQuery(getString(R.string.api_version), soql);
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
                                picklist = new ArrayList<FormField>();
                                reference = new ArrayList<FormField>();
                                Log.d("", result.toString());
                                activity.set_webForm(SFResponseManager.parseWebFormObject(result.toString()));
                                for (int i = 0; i < activity.get_webForm().get_formFields().size(); i++) {
                                    if (!activity.get_webForm().get_formFields().get(i).getType().equals("CUSTOMTEXT") && activity.get_webForm().get_formFields().get(i).isParameter() == false && activity.get_webForm().get_formFields().get(i).isQuery() == true) {
                                        CardQueryBuilder += activity.get_webForm().get_formFields().get(i).getTextValue() + ",";
                                    } else if (!activity.get_webForm().get_formFields().get(i).isParameter() && (activity.get_webForm().get_formFields().get(i).getType().equals("PICKLIST"))) {
                                        picklist.add(activity.get_webForm().get_formFields().get(i));
                                    } else if (!activity.get_webForm().get_formFields().get(i).isParameter() && (activity.get_webForm().get_formFields().get(i).getType().equals("REFERENCE"))) {
                                        reference.add(activity.get_webForm().get_formFields().get(i));
                                    }
                                }
//                                if (!CardQueryBuilder.equals("")) {
//                                    CardQueryBuilder = CardQueryBuilder.substring(0, CardQueryBuilder.length() - 1);
//                                    cardQuery = String.format(cardQuery, CardQueryBuilder, NocActivity.get_visa().get_visaHolder().getID());
//                                    PerformCardQueryValues(NocMainFragment._webForm, cardQuery);
//                                } else if (picklist.size() > 0) {
//                                    new GetPickLists(client).execute(picklist);
//                                } else {
//                                    Utilities.dismissLoadingDialog();
//                                    Utilities.DrawCardFormFieldsOnLayout(getActivity(), getActivity().getApplicationContext(), linearAddForms, formFields, Cardjson, CardBaseServiceFragment.parameters, CardBaseServiceFragment._cardManagement);
//                                }
                                if (CardQueryBuilder.equals("")) {
                                    if (picklist.size() > 0) {
                                        formFields = activity.get_webForm().get_formFields();
                                        new GetPickLists(client).execute(picklist);
                                    }


                                } else {
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

//    private void PerformCardQueryValues(final WebForm webForm, String cardQuery) {
//
//        try {
//            restRequest = RestRequest.getRequestForQuery(getString(R.string.api_version), cardQuery);
//            new ClientManager(getActivity(), SalesforceSDKManager.getInstance().getAccountType(), SalesforceSDKManager.getInstance().getLoginOptions(), SalesforceSDKManager.getInstance().shouldLogoutWhenTokenRevoked()).getRestClient(getActivity(), new ClientManager.RestClientCallback() {
//                @Override
//                public void authenticatedRestClient(RestClient client) {
//                    if (client == null) {
//                        SalesforceSDKManager.getInstance().logout(getActivity());
//                        return;
//                    } else {
//
//                        client.sendAsync(restRequest, new RestClient.AsyncRequestCallback() {
//                            @Override
//                            public void onSuccess(RestRequest request, RestResponse result) {
//                                Cardjson = SFResponseManager.parseJsonCardData(result.toString());
//                                Utilities.dismissLoadingDialog();
//                                formFields = webForm.get_formFields();
//                                new ClientManager(getActivity(), SalesforceSDKManager.getInstance().getAccountType(), SalesforceSDKManager.getInstance().getLoginOptions(), SalesforceSDKManager.getInstance().shouldLogoutWhenTokenRevoked()).getRestClient(getActivity(), new ClientManager.RestClientCallback() {
//                                    @Override
//                                    public void authenticatedRestClient(final RestClient client) {
//                                        if (client == null) {
//                                            return;
//                                        } else {
//
//                                            new GetPickLists(client).execute(picklist);
//                                        }
//                                    }
//                                });
//                            }
//
//                            @Override
//                            public void onError(Exception exception) {
//                                Utilities.showToast(getActivity(), RestMessages.getInstance().getErrorMessage());
//                                Utilities.dismissLoadingDialog();
//                                getActivity().finish();
//                            }
//                        });
//                    }
//                }
//            });
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//    }

    private void InitializeViews(View view) {
        linearAddForms = (LinearLayout) view.findViewById(R.id.linearAddForms);
        activity = (CardActivity) getActivity();
    }


    public class GetPickLists extends AsyncTask<List<FormField>, Void, Map<String, List<String>>> {

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
        protected Map<String, List<String>> doInBackground(List<FormField>... params) {
            String attUrl = client.getClientInfo().resolveUrl("/services/apexrest/MobilePickListValuesWebService?fieldId=").toString();
            for (FormField fieldId : params[0]) {
                HttpClient tempClient = new DefaultHttpClient();

                URI theUrl = null;
                try {
                    theUrl = new URI(attUrl + fieldId.getId());
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
                                JSONObject jo = null;
                                try {
                                    jo = new JSONObject(result);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                JSONArray ja = null;
                                ja = jo.getJSONArray("Requested_From__c");
                                fieldId.setPicklistEntries(convertJsonStringToString(ja));
                            }
                        } else {
                            httpResponse.getEntity().getContent().close();
                            throw new IOException(statusLine.getReasonPhrase());
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Map<String, List<String>> aVoid) {
            super.onPostExecute(aVoid);

//            if (picklist.size() > 0) {
//                formFields = activity.get_webForm().get_formFields();
////                new GetReferences(client).execute(reference);
//            }

            if (reference != null && reference.size() > 0) {
                if (reference.get(0).getTextValue().equals("Country__c")) {
                    String referenceSoql = "select Id,Nationality_Name__c from Country__c";
                    try {
                        restRequest = RestRequest.getRequestForQuery(getString(R.string.api_version), referenceSoql);
                        new ClientManager(getActivity(), SalesforceSDKManager.getInstance().getAccountType(), SalesforceSDKManager.getInstance().getLoginOptions(), SalesforceSDKManager.getInstance().shouldLogoutWhenTokenRevoked()).getRestClient(getActivity(), new ClientManager.RestClientCallback() {
                            @Override
                            public void authenticatedRestClient(RestClient client) {
                                if (client == null) {
                                    System.exit(0);
                                } else {
                                    client.sendAsync(restRequest, new RestClient.AsyncRequestCallback() {
                                        @Override
                                        public void onSuccess(RestRequest request, RestResponse response) {
                                            try {

                                                ArrayList<Country__c> countries = SFResponseManager.parseCountryObject(response.toString());
                                                activity.setCountries(countries);
                                                Utilities.DrawFormFieldsOnLayout(activity, getActivity().getApplicationContext(), linearAddForms, formFields, null, null, activity.getParameters(), activity.getCard());
                                                Utilities.dismissLoadingDialog();
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            }
                                        }

                                        @Override
                                        public void onError(Exception exception) {

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
        }
    }


    public static String convertJsonStringToString(JSONArray jsonArray) {
        String result = "";
        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                result += jsonArray.getString(i);
                if (i != (jsonArray.length() - 1))
                    result += ",";
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
