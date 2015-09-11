package fragment.companyDocumentsScreen;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.malinskiy.superrecyclerview.OnMoreListener;
import com.malinskiy.superrecyclerview.SuperRecyclerView;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.rest.ClientManager;
import com.salesforce.androidsdk.rest.RestClient;
import com.salesforce.androidsdk.rest.RestRequest;
import com.salesforce.androidsdk.rest.RestResponse;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import RestAPI.SFResponseManager;
import RestAPI.SoqlStatements;
import adapter.CustomerDocumentsAdapter;
import cloudconcept.dwc.R;
import fragmentActivity.HomeCompanyDocumentsActivity;
import model.Company_Documents__c;
import utilities.Utilities;

/**
 * Created by Abanoub Wagdy on 9/8/2015.
 */
public class CustomerDocumentsFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener, OnMoreListener {

    private static final String ARG_TEXT = "CompanyDocuments";
    private static ArrayList<Company_Documents__c> companyDocuments;
    private Handler mHandler;
    private static HomeCompanyDocumentsActivity activity;
    private static SuperRecyclerView recyclerView;
    private int offset = 0;
    private int limit = 10;
    private RestRequest restRequest;
    static CustomerDocumentsAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.true_copies, container, false);
        InitializeViews(view);
        mHandler = new Handler(Looper.getMainLooper());
        onRefresh();
        return view;
    }

    private void InitializeViews(View view) {

        activity = (HomeCompanyDocumentsActivity) getActivity();
        recyclerView = (SuperRecyclerView) view.findViewById(R.id.lstTrueCopies);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setRefreshListener(this);
        recyclerView.setRefreshingColorResources(android.R.color.holo_orange_light, android.R.color.holo_blue_light, android.R.color.holo_green_light, R.color.dwc_blue_color);
        recyclerView.setupMoreListener(this, 20);
    }

    public static CustomerDocumentsFragment newInstance(String text) {
        CustomerDocumentsFragment fragment = new CustomerDocumentsFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_TEXT, text);
        fragment.setArguments(bundle);
        return fragment;
    }

    private void CallCustomerDocumentsService(final int offset, final int limit) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Gson gson = new Gson();
                String soql = SoqlStatements.constructCustomerDocumentsQuery(activity.getUser().get_contact().get_account().getID(), offset, limit);
                try {
                    restRequest = RestRequest.getRequestForQuery(getString(R.string.api_version), soql);
                    new ClientManager(getActivity(), SalesforceSDKManager.getInstance().getAccountType(), SalesforceSDKManager.getInstance().getLoginOptions(), SalesforceSDKManager.getInstance().shouldLogoutWhenTokenRevoked()).getRestClient(getActivity(), new ClientManager.RestClientCallback() {
                        @Override
                        public void authenticatedRestClient(RestClient client) {
                            if (client == null) {
                                SalesforceSDKManager.getInstance().logout(getActivity());
                                return;
                            } else {
                                client.sendAsync(restRequest, new RestClient.AsyncRequestCallback() {
                                    @Override
                                    public void onSuccess(RestRequest request, final RestResponse response) {
                                        companyDocuments = (ArrayList<Company_Documents__c>) SFResponseManager.parseCompanyDocumentObject(response.toString());
                                        mHandler.postDelayed(new Runnable() {
                                            public void run() {
                                                if (mAdapter == null) {
                                                    mAdapter = new CustomerDocumentsAdapter(getActivity(), getActivity().getApplicationContext(), companyDocuments);
                                                    recyclerView.setAdapter(mAdapter);
                                                } else {
                                                    ArrayList<Company_Documents__c> company_documents__cs = (ArrayList<Company_Documents__c>) SFResponseManager.parseCompanyDocumentObject(response.toString());
                                                    if (company_documents__cs.size() == 0) {
                                                        recyclerView.setLoadingMore(true);
                                                        recyclerView.setupMoreListener(null, 0);
                                                        recyclerView.hideMoreProgress();
                                                        recyclerView.hideProgress();
                                                    } else {
//                                                        for (int i=0;i<company_documents__cs.size();i++){
//                                                            mAdapter.insert();
//                                                        }
                                                        mAdapter.addAll(company_documents__cs);
                                                    }
                                                }
                                            }
                                        }, 2000);
                                    }

                                    @Override
                                    public void onError(Exception exception) {
                                        Utilities.dismissLoadingDialog();
                                    }
                                });
                            }
                        }
                    });
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    @Override
    public void onMoreAsked(int i, int i1, int i2) {
        offset += 10;
        CallCustomerDocumentsService(offset, limit);
    }

    @Override
    public void onRefresh() {
        offset = 0;
        CallCustomerDocumentsService(offset, limit);
    }

    public static void setNewCompanyDocuments(Company_Documents__c company_documents__c, int position) {
        companyDocuments.set(position, company_documents__c);
        mAdapter = new CustomerDocumentsAdapter(activity, activity.getApplicationContext(), companyDocuments);
        recyclerView.setAdapter(mAdapter);
    }
}
