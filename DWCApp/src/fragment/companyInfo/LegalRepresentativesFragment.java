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

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import RestAPI.SFResponseManager;
import RestAPI.SoqlStatements;
import adapter.companyInfoAdapters.LegalRepresentativesAdapter;
import cloudconcept.dwc.R;
import dataStorage.StoreData;
import model.LegalRepresentative;
import model.SFServiceCall;
import model.User;

/**
 * Created by Abanoub on 7/2/2015.
 */
public class LegalRepresentativesFragment extends Fragment {

    private static final String ARG_TEXT = "LegalRepresentativesFragment";
    private SwipyRefreshLayout swipyRefreshLayout;
    private ListView lvLegalRepresentatives;
    private int offset = 0;
    private int limit = 10;
    private String soqlQuery;
    private RestRequest restRequest;
    private String lastReponseString = "";
    private ArrayList<LegalRepresentative> legalRepresentatives;

    public static LegalRepresentativesFragment newInstance(String text) {
        LegalRepresentativesFragment fragment = new LegalRepresentativesFragment();
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
        lvLegalRepresentatives = (ListView) view.findViewById(R.id.expandableLayoutListView);
        swipyRefreshLayout.setOnRefreshListener(new SwipyRefreshLayout.OnRefreshListener() {

            @Override
            public void onRefresh(SwipyRefreshLayoutDirection swipyRefreshLayoutDirection) {
                if (swipyRefreshLayoutDirection == SwipyRefreshLayoutDirection.TOP) {
                    if (offset > 0) {
                        limit = offset;
                        offset = 0;
                    }
                    CallLegalRepresentativesService(true, SFServiceCall.REFRESH);
                } else if (swipyRefreshLayoutDirection == SwipyRefreshLayoutDirection.BOTTOM) {
                    CallLegalRepresentativesService(true, SFServiceCall.LOADMORE);
                }
            }
        });

        CallLegalRepresentativesService(true, SFServiceCall.FIRSTTIME);
    }

    private void CallLegalRepresentativesService(boolean b, final SFServiceCall serviceCall) {
        Gson gson = new Gson();
        User _user = gson.fromJson(new StoreData(getActivity().getApplicationContext()).getUserDataAsString(), User.class);
        if (serviceCall == SFServiceCall.LOADMORE) {
            offset += 10;
            limit = 10;
        }
        soqlQuery = SoqlStatements.getInstance().constructLegalRepresentativeQuery(_user.get_contact().get_account().getID(), limit, offset);
        try {
            restRequest = RestRequest.getRequestForQuery(
                    getActivity().getString(R.string.api_version), soqlQuery);
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

                                if (serviceCall == SFServiceCall.LOADMORE) {
                                    if (lastReponseString.equals("") || !lastReponseString.equals(response.toString())) {
                                        legalRepresentatives.addAll(SFResponseManager.parseLegalRepresentativesObject(response.toString()));
                                    }
                                } else {
                                    legalRepresentatives = new ArrayList<LegalRepresentative>();
                                    legalRepresentatives = SFResponseManager.parseLegalRepresentativesObject(response.toString());
                                }

                                lastReponseString = response.toString();
                                lvLegalRepresentatives.setAdapter(new LegalRepresentativesAdapter(getActivity(), getActivity().getApplicationContext(), R.layout.directors_item, legalRepresentatives));
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
