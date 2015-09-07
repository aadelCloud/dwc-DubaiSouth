package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;

import com.blunderer.materialdesignlibrary.fragments.ListViewFragment;
import com.google.gson.Gson;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.rest.ClientManager;
import com.salesforce.androidsdk.rest.RestClient;
import com.salesforce.androidsdk.rest.RestRequest;
import com.salesforce.androidsdk.rest.RestResponse;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import RestAPI.SFResponseManager;
import RestAPI.SoqlStatements;
import adapter.ViewStatementAdapter;
import cloudconcept.dwc.R;
import dataStorage.StoreData;
import model.FreeZonePayment;
import model.User;
import utilities.Utilities;

/**
 * Created by Abanoub Wagdy on 9/6/2015.
 */
public class ViewStatementFragment extends ListViewFragment {

    int limit = 20;
    int offset = 0;
    private User user;
    RestRequest restRequest;
    ArrayList<FreeZonePayment> freeZonePayments;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        CallFreeZonePaymentRequest(offset, limit, CallType.FIRSTTIME);
    }

    @Override
    public void setRefreshing(boolean refreshing) {

    }

    @Override
    public ListAdapter getListAdapter() {
        return null;
    }

    private void CallFreeZonePaymentRequest(int offset, int limit, final CallType callType) {
        if (callType == CallType.FIRSTTIME) {
            Utilities.showloadingDialog(getActivity());
        }

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
                            public void onSuccess(RestRequest request, RestResponse response) {
                                if (callType == CallType.FIRSTTIME) {
                                    Utilities.dismissLoadingDialog();
                                } else if (callType == CallType.PULLTOREFRESH) {
//                                    mListView.onRefreshComplete();
                                } else {
//                                    mListView.onLoadMoreComplete();
                                }
                                if (freeZonePayments == null) {
                                    freeZonePayments = new ArrayList<FreeZonePayment>();
                                }
                                freeZonePayments.addAll(SFResponseManager.parseFreeZonePaymentResponse(response.toString()));
                                SetListAdapter(freeZonePayments);
                            }

                            @Override
                            public void onError(Exception exception) {
                                if (callType == CallType.FIRSTTIME) {
                                    Utilities.dismissLoadingDialog();
                                } else if (callType == CallType.PULLTOREFRESH) {
//                                    mListView.onRefreshComplete();
                                } else {
//                                    mListView.onLoadMoreComplete();
                                }
                            }
                        });
                    }
                }
            });
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private void SetListAdapter(ArrayList<FreeZonePayment> freeZonePayments) {
        ArrayList<FreeZonePayment> listFreeZonePayments = new ArrayList<>();
        listFreeZonePayments.addAll(freeZonePayments);
        ViewStatementAdapter adapter = new ViewStatementAdapter(getActivity(), R.layout.view_statement_item_row, listFreeZonePayments);
//        super.setAdapter(adapter);
    }

    @Override
    public boolean useCustomContentView() {
        return false;
    }

    @Override
    public int getCustomContentView() {
        return 0;
    }

    @Override
    public boolean pullToRefreshEnabled() {
        return true;
    }

    @Override
    public boolean LoadMoreEnabled() {
        return true;
    }

//    @Override
//    public int[] getPullToRefreshColorResources() {
//        return new int[0];
//    }

//    @Override
//    public int[] getPullToRefreshColorResources() {
//    }

    @Override
    public int[] getPullToRefreshColorResources() {
        int[] colors = new int[]{R.color.dwc_blue_color, R.color.black, R.color.red};
        return colors;
    }

    @Override
    public void onRefresh() {
        offset = 0;
        CallFreeZonePaymentRequest(offset, limit, CallType.PULLTOREFRESH);
    }

    @Override
    public void loadMore() {
        offset += 20;
        CallFreeZonePaymentRequest(offset, limit, CallType.LOADMORE);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
        return false;
    }

    enum CallType {
        FIRSTTIME, LOADMORE, PULLTOREFRESH
    }
}
