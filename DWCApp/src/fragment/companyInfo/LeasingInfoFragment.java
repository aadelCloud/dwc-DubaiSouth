package fragment.companyInfo;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.NetworkResponse;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayout;
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
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import RestAPI.SFResponseManager;
import adapter.LeasingInfoAdapter;
import cloudconcept.dwc.R;
import dataStorage.StoreData;
import model.Contract_DWC__c;
import model.User;

/**
 * Created by Abanoub on 7/2/2015.
 */
public class LeasingInfoFragment extends Fragment {

    private static final String ARG_TEXT = "LeasingInfoFragment";
    SwipyRefreshLayout swipyRefreshLayout;
    ListView lvLeasingInfoItems;
    RestRequest restRequest;
    private String result;
    private TextView tvNoEmployees;
    //    String soql = "select IS_BC_Contract__c , id , name , Contract_Type__c , Activated_Date__c , Total_Rent_Price__c , Contract_Duration__c , Rent_Start_date__c , Contract_Duration_Year_Month__c , Contract_Start_Date__c ,Contract_Expiry_Date__c from Contract_DWC__C where Status__c = 'Active' and Tenant__c = ";
    private User user;
    int offset = 0;
    int limit = 10;
    private Set<Contract_DWC__c> contract_dwc__cs;

    public LeasingInfoFragment() {

    }


    public static LeasingInfoFragment newInstance(String text) {
        LeasingInfoFragment fragment = new LeasingInfoFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_TEXT, text);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.leasing_info_fragment, container, false);
        InitializeViews(view);
        contract_dwc__cs = new HashSet<>();
        return view;
    }

    private void InitializeViews(View view) {

        Gson gson = new Gson();
        user = gson.fromJson(new StoreData(getActivity().getApplicationContext()).getUserDataAsString(), User.class);

//        StringBuilder builder = new StringBuilder(1000);
//        builder.append(soql);
//        builder.append("\'" + user.get_contact().get_account().getID() + "\'");
//        soql = builder.toString();

        swipyRefreshLayout = (SwipyRefreshLayout) view.findViewById(R.id.activity_main_swipe_refresh_layout);
        lvLeasingInfoItems = (ListView) view.findViewById(R.id.expandableLayoutListView);
        tvNoEmployees = (TextView) view.findViewById(R.id.tvNoEmployees);
        new ClientManager(getActivity(), SalesforceSDKManager.getInstance().getAccountType(), SalesforceSDKManager.getInstance().getLoginOptions(), SalesforceSDKManager.getInstance().shouldLogoutWhenTokenRevoked()).getRestClient(getActivity(), new ClientManager.RestClientCallback() {
            @Override
            public void authenticatedRestClient(final RestClient client) {
                if (client == null) {
                    System.exit(0);
                } else {
                    new LeasingInfoTask(client, offset, limit).execute();
//                    try {
//                        restRequest = RestRequest.getRequestForQuery(getString(R.string.api_version), soql);
//                        client.sendAsync(restRequest, new RestClient.AsyncRequestCallback() {
//                            @Override
//                            public void onSuccess(RestRequest request, RestResponse response) {
//
//                                Log.d("response", response.toString());
//                            }
//
//                            @Override
//                            public void onError(Exception exception) {
//                                VolleyError volleyError = (VolleyError) exception;
//                                NetworkResponse response = volleyError.networkResponse;
//                                String json = new String(response.data);
//                                Log.d("", json);
//                            }
//                        });
//                    } catch (UnsupportedEncodingException e) {
//                        e.printStackTrace();
//                    }
                }
            }
        });

//        new ClientManager(getActivity(), SalesforceSDKManager.getInstance().getAccountType(), SalesforceSDKManager.getInstance().getLoginOptions(), SalesforceSDKManager.getInstance().shouldLogoutWhenTokenRevoked()).getRestClient(getActivity(), new ClientManager.RestClientCallback() {
//            @Override
//            public void authenticatedRestClient(final RestClient client) {
//                if (client == null) {
//                    System.exit(0);
//                } else {
//
//                    try {
//                        restRequest = RestRequest.getRequestForQuery(getString(R.string.api_version), soql);
//                        client.sendAsync(restRequest, new RestClient.AsyncRequestCallback() {
//                            @Override
//                            public void onSuccess(RestRequest request, RestResponse response) {
//
//                                Log.d("response", response.toString());
//                            }
//
//                            @Override
//                            public void onError(Exception exception) {
//                                VolleyError volleyError = (VolleyError) exception;
//                                NetworkResponse response = volleyError.networkResponse;
//                                String json = new String(response.data);
//                                Log.d("", json);
//                            }
//                        });
//                    } catch (UnsupportedEncodingException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });


    }

    public class LeasingInfoTask extends AsyncTask<Void, Void, Void> {

        private final RestClient client;
        private int offset;
        private int limit;

        public LeasingInfoTask(RestClient client, int offset, int limit) {
            this.client = client;
            this.limit = limit;
            this.offset = offset;
        }

        @Override
        protected Void doInBackground(Void... params) {
            String attUrl = client.getClientInfo().resolveUrl("/services/apexrest/MobileTenantContractsWebService").toString();
            attUrl += "?AccountId=" + user.get_contact().get_account().getID() + "&LIMIT=" + limit + "&OFFSET=" + offset;
            HttpClient tempClient = new DefaultHttpClient();
            URI theUrl = null;
            try {
                theUrl = new URI(attUrl);
                HttpGet getRequest = new HttpGet();
                getRequest.setURI(theUrl);
                getRequest.setHeader("Authorization", "Bearer " + client.getAuthToken());
                HttpResponse httpResponse = null;
                try {
                    httpResponse = tempClient.execute(getRequest);
                    StatusLine statusLine = httpResponse.getStatusLine();
                    if (statusLine.getStatusCode() == HttpStatus.SC_OK) {
                        HttpEntity httpEntity = httpResponse.getEntity();
                        Log.d("response", httpEntity.toString());
                        if (httpEntity != null) {
                            result = EntityUtils.toString(httpEntity);
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
            if (result != null && result.equals("[]")) {
                tvNoEmployees.setVisibility(View.VISIBLE);
            } else {
                tvNoEmployees.setVisibility(View.GONE);
                contract_dwc__cs.addAll(SFResponseManager.parseLeasingContractResponse(result.toString()));
                ArrayList<Contract_DWC__c> contracts = new ArrayList<>();
                for (Contract_DWC__c contract_dwc__c : contract_dwc__cs) {
                    contracts.add(contract_dwc__c);
                }
                lvLeasingInfoItems.setAdapter(new LeasingInfoAdapter(getActivity(), getActivity().getApplicationContext(), R.layout.leasing_info_item, contracts));
            }
        }
    }
}