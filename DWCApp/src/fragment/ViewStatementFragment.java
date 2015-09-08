package fragment;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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
import adapter.ViewStatementAdapter;
import cloudconcept.dwc.R;
import dataStorage.StoreData;
import fragmentActivity.ViewStatementActivity;
import model.FreeZonePayment;
import model.User;
import utilities.Utilities;

/**
 * Created by Abanoub Wagdy on 9/6/2015.
 */
public class ViewStatementFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener, OnMoreListener {


//    @Override
//    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        CallFreeZonePaymentRequest(offset, limit, CallType.FIRSTTIME);
//    }
//
//    @Override
//    public void setRefreshing(boolean refreshing) {
//
//    }
//
//    @Override
//    public ListAdapter getListAdapter() {
//        return null;
//    }
//

//
//    private void SetListAdapter(ArrayList<FreeZonePayment> freeZonePayments) {
//        ArrayList<FreeZonePayment> listFreeZonePayments = new ArrayList<>();
//        listFreeZonePayments.addAll(freeZonePayments);
//        ViewStatementAdapter adapter = new ViewStatementAdapter(getActivity(), R.layout.view_statement_item_row, listFreeZonePayments);
//        mListView.setAdapter(adapter);
////        super.setAdapter(adapter);
//    }
//
//    @Override
//    public boolean useCustomContentView() {
//        return false;
//    }
//
//    @Override
//    public int getCustomContentView() {
//        return 0;
//    }
//
//    @Override
//    public boolean pullToRefreshEnabled() {
//        return true;
//    }
//
//    @Override
//    public boolean LoadMoreEnabled() {
//        return true;
//    }
//
////    @Override
////    public int[] getPullToRefreshColorResources() {
////        return new int[0];
////    }
//
////    @Override
////    public int[] getPullToRefreshColorResources() {
////    }
//
//    @Override
//    public int[] getPullToRefreshColorResources() {
//        int[] colors = new int[]{R.color.dwc_blue_color, R.color.black, R.color.red};
//        return colors;
//    }
//
//    @Override
//    public void onRefresh() {
//        offset = 0;
//        CallFreeZonePaymentRequest(offset, limit, CallType.PULLTOREFRESH);
//    }
//
//    @Override
//    public void loadMore() {
//        offset += 20;
//        CallFreeZonePaymentRequest(offset, limit, CallType.LOADMORE);
//    }
//
//    @Override
//    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//
//    }
//
//    @Override
//    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
//        return false;
//    }
//
//    enum CallType {
//        FIRSTTIME, LOADMORE, PULLTOREFRESH
//    }

    private SuperRecyclerView mRecycler;
    private ViewStatementAdapter mAdapter;
    private Handler mHandler;
    ViewStatementActivity activity;
    int limit = 20;
    int offset = 0;
    private User user;
    RestRequest restRequest;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.view_statement, container, false);
        InitializeViews(view);
        mHandler = new Handler(Looper.getMainLooper());
        onRefresh();
        return view;
    }

    private void InitializeViews(View view) {

        activity = (ViewStatementActivity) getActivity();
        mRecycler = (SuperRecyclerView) view.findViewById(R.id.list);
        mRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));

        mRecycler.setRefreshListener(this);
        mRecycler.setRefreshingColorResources(android.R.color.holo_orange_light, android.R.color.holo_blue_light, android.R.color.holo_green_light, R.color.dwc_blue_color);
        mRecycler.setupMoreListener(this, 20);
    }

    @Override
    public void onMoreAsked(int i, int i1, int i2) {
        mRecycler.setupMoreListener(this, 20);
        CallFreeZonePaymentRequest(offset, limit);
    }

    @Override
    public void onRefresh() {
        offset = 0;
        mRecycler.setLoadingMore(false);
        CallFreeZonePaymentRequest(offset, limit);
    }

    private void CallFreeZonePaymentRequest(final int offset, final int limit) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Gson gson = new Gson();
                user = gson.fromJson(new StoreData(getActivity().getApplicationContext()).getUserDataAsString(), User.class);
                String soql = SoqlStatements.constructViewStatementQuery(user.get_contact().get_account().getID(), offset, limit);
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
                                                if (mAdapter == null) {
                                                    mAdapter = new ViewStatementAdapter(getActivity().getApplicationContext(), (ArrayList<FreeZonePayment>) SFResponseManager.parseFreeZonePaymentResponse(response.toString()));
                                                    mRecycler.setAdapter(mAdapter);
                                                } else {
                                                    boolean flag = mAdapter.addAll((ArrayList<FreeZonePayment>) SFResponseManager.parseFreeZonePaymentResponse(response.toString()));
                                                    if (!flag) {
                                                        mRecycler.setLoadingMore(false);
//                                                        mRecycler.setupMoreListener(null, 0);
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
}