package fragment.companyDocumentsScreen;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
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

import org.json.JSONException;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import RestAPI.SFResponseManager;
import RestAPI.SoqlStatements;
import adapter.TrueCopiesAdapter;
import adapter.ViewStatementAdapter;
import cloudconcept.dwc.R;
import dataStorage.StoreData;
import fragmentActivity.HomeCompanyDocumentsActivity;
import fragmentActivity.ViewStatementActivity;
import model.EServices_Document_Checklist__c;
import model.FreeZonePayment;
import model.User;
import model.Visa;
import utilities.Utilities;

/**
 * Created by Abanoub Wagdy on 9/8/2015.
 */
public class TrueCopiesFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener, OnMoreListener {

    private static final String ARG_TEXT = "TrueCopies";
    SuperRecyclerView recyclerView;
    private HomeCompanyDocumentsActivity activity;
    private TrueCopiesAdapter mAdapter;
    int offset = 0;
    int limit = 10;
    private RestRequest restRequest;
    private Handler mHandler;

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

    public static TrueCopiesFragment newInstance(String text) {
        TrueCopiesFragment fragment = new TrueCopiesFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_TEXT, text);
        fragment.setArguments(bundle);
        return fragment;
    }

    private void CallTrueCopiesService(final int offset, final int limit) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Gson gson = new Gson();
                String soql = SoqlStatements.constructTrueCopiesQuery(offset, limit);
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
                                        mHandler.postDelayed(new Runnable() {
                                            public void run() {
                                                try {
                                                    if (mAdapter == null) {
                                                        mAdapter = new TrueCopiesAdapter(getActivity().getApplicationContext(), (ArrayList<EServices_Document_Checklist__c>) SFResponseManager.parseEServiceDocumentChecklist(response.toString()));
                                                        recyclerView.setAdapter(mAdapter);
                                                    } else {
                                                        ArrayList<EServices_Document_Checklist__c> eServices_document_checklist__cs = (ArrayList<EServices_Document_Checklist__c>) SFResponseManager.parseEServiceDocumentChecklist(response.toString());
                                                        if (eServices_document_checklist__cs.size() == 0) {
                                                            recyclerView.setLoadingMore(true);
                                                            recyclerView.setupMoreListener(null, 0);
                                                            recyclerView.hideMoreProgress();
                                                            recyclerView.hideProgress();
                                                        } else {
                                                            mAdapter.addAll(eServices_document_checklist__cs);
                                                        }
                                                    }
                                                } catch (JSONException e) {
                                                    e.printStackTrace();
                                                } catch (IOException e) {
                                                    e.printStackTrace();
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
        CallTrueCopiesService(offset, limit);
    }

    @Override
    public void onRefresh() {
        offset = 0;
        CallTrueCopiesService(offset, limit);
    }
}