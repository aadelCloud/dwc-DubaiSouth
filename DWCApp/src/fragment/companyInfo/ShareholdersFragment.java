package fragment.companyInfo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.gson.Gson;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayout;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayoutDirection;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.rest.ClientManager;
import com.salesforce.androidsdk.rest.RestClient;
import com.salesforce.androidsdk.rest.RestRequest;
import com.salesforce.androidsdk.rest.RestResponse;

import org.json.JSONException;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import RestAPI.SFResponseManager;
import RestAPI.SoqlStatements;
import adapter.ShareHolderAdapter;
import cloudconcept.dwc.R;
import dataStorage.StoreData;
import model.SFServiceCall;
import model.ShareOwnership;
import model.User;

/**
 * Created by Abanoub on 7/2/2015.
 */
public class ShareholdersFragment extends Fragment {

    private static final String ARG_TEXT = "ShareholdersFragment";
    int limit = 10;
    int offset = 0;
    private SwipyRefreshLayout swipyRefreshLayout;
    private ListView lvShareholders;
    private String soqlQuery;
    private RestRequest restRequest;
    private boolean iscalledFromRefresh = false;
    private ArrayList<ShareOwnership> _shareOwnerships;

    public static ShareholdersFragment newInstance(String text) {
        ShareholdersFragment fragment = new ShareholdersFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_TEXT, text);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shareholders, container, false);
        InitializeViews(view);
        return view;
    }

    private void InitializeViews(View view) {
        swipyRefreshLayout = (SwipyRefreshLayout) view.findViewById(R.id.activity_main_swipe_refresh_layout);
        lvShareholders = (ListView) view.findViewById(R.id.expandableLayoutListView);
        swipyRefreshLayout.setOnRefreshListener(new SwipyRefreshLayout.OnRefreshListener() {

            @Override
            public void onRefresh(SwipyRefreshLayoutDirection swipyRefreshLayoutDirection) {
                if (swipyRefreshLayoutDirection == SwipyRefreshLayoutDirection.TOP) {
                    if (offset > 0) {
                        limit = offset;
                        offset = 0;
                    }
                    CallShareholdersService(true, SFServiceCall.REFRESH);
                } else if (swipyRefreshLayoutDirection == SwipyRefreshLayoutDirection.BOTTOM) {
                    CallShareholdersService(true, SFServiceCall.LOADMORE);
                }
            }
        });

        CallShareholdersService(true, SFServiceCall.FIRSTTIME);
    }

    private void CallShareholdersService(boolean isNew, final SFServiceCall serviceCall) {
        Gson gson = new Gson();
        User _user = gson.fromJson(new StoreData(getActivity().getApplicationContext()).getUserDataAsString(), User.class);
        if (serviceCall == SFServiceCall.LOADMORE) {
            offset += 10;
            limit = 10;
        }
        soqlQuery = SoqlStatements.getInstance().constructShareHoldersQuery(_user.get_contact().get_account().getID(), limit, offset);
        try {
            restRequest = RestRequest.getRequestForQuery(
                    getActivity().getString(R.string.api_version), soqlQuery);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

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
                            if (serviceCall == SFServiceCall.LOADMORE || serviceCall == SFServiceCall.REFRESH)
                                swipyRefreshLayout.setRefreshing(false);
                            try {
                                if (serviceCall == SFServiceCall.LOADMORE) {
                                    _shareOwnerships.addAll(SFResponseManager.parseShareOwnerShipObject(response.toString()));
                                } else {
                                    _shareOwnerships = new ArrayList<ShareOwnership>();
                                    _shareOwnerships = SFResponseManager.parseShareOwnerShipObject(response.toString());
                                }
                                lvShareholders.setAdapter(new ShareHolderAdapter(getActivity(), getActivity().getApplicationContext(), R.layout.shareholder_item, _shareOwnerships));
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
    }
}