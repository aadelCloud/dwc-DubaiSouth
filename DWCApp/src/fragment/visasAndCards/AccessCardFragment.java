package fragment.visasAndCards;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.volley.NetworkResponse;
import com.android.volley.VolleyError;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayout;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayoutDirection;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.rest.ClientManager;
import com.salesforce.androidsdk.rest.RestClient;
import com.salesforce.androidsdk.rest.RestRequest;
import com.salesforce.androidsdk.rest.RestResponse;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;

import RestAPI.RestMessages;
import RestAPI.SFResponseManager;
import RestAPI.SoqlStatements;
import adapter.SpinnerAdapter;
import adapter.visasAdapters.AccessCardAdapter;
import cloudconcept.dwc.R;
import dataStorage.StoreData;
import model.Card_Management__c;
import utilities.ActivitiesLauncher;
import utilities.Utilities;

/**
 * Created by Abanoub on 6/24/2015.
 */
public class AccessCardFragment extends Fragment implements View.OnClickListener {

    private static final String ARG_TEXT = "AccessCard";
    static String strFilter;
    LinearLayout LinearAddNewCard;
    ListView expandableLayoutListView;
    SwipyRefreshLayout mSwipeRefreshLayout;
    Spinner spinnerFilterAccessCard;
    EditText etSearch;
    String[] Access_Card_visa_validity_status = new String[]{"All", "Draft", "Active", "Expired"};
    RestRequest restRequest;
    AccessCardAdapter adapter;
    private String soqlQuery;
    private int offset = 0;
    private int limit = 10;
    private ArrayList<Card_Management__c> _cards;
    private ArrayList<Card_Management__c> _Filteredcards;
    private boolean iscalledFromRefresh = false;
    ImageView imageNewCard;
    TextView tvNewCard;

    public static AccessCardFragment newInstance(String text) {
        AccessCardFragment fragment = new AccessCardFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_TEXT, text);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.visas_cards_access__cards, container, false);
        offset = 0;
        _cards = new ArrayList<Card_Management__c>();
        _Filteredcards = new ArrayList<Card_Management__c>();
        InitializeViews(view);
        CallAccessCardService(true, iscalledFromRefresh, strFilter);
        return view;
    }

    private void InitializeViews(View view) {

        tvNewCard = (TextView) view.findViewById(R.id.tvNewCard);
        imageNewCard = (ImageView) view.findViewById(R.id.imageNewCard);
        tvNewCard.setOnClickListener(this);
        imageNewCard.setOnClickListener(this);
        expandableLayoutListView = (ListView) view.findViewById(R.id.expandableLayoutListView);
        spinnerFilterAccessCard = (Spinner) view.findViewById(R.id.spinner);
        mSwipeRefreshLayout = (SwipyRefreshLayout) view.findViewById(R.id.activity_main_swipe_refresh_layout);
        etSearch = (EditText) view.findViewById(R.id.etSearch);
        LinearAddNewCard = (LinearLayout) view.findViewById(R.id.LinearAddNewCard);
        if (strFilter == null)
            strFilter = Access_Card_visa_validity_status[2];

        mSwipeRefreshLayout.setOnRefreshListener(new SwipyRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh(SwipyRefreshLayoutDirection direction) {
                Log.d("MainActivity", "Refresh triggered at "
                        + (direction == SwipyRefreshLayoutDirection.TOP ? "top" : "bottom"));
                iscalledFromRefresh = true;
                CallAccessCardService(true, iscalledFromRefresh, strFilter);
            }
        });


        ArrayAdapter<String> dataAdapter = new SpinnerAdapter(getActivity().getApplicationContext(), R.layout.spinner_item,
                Arrays.asList(getActivity().getApplicationContext().getResources().getStringArray(R.array.access_card_filter)));

        spinnerFilterAccessCard.setAdapter(dataAdapter);
        spinnerFilterAccessCard.setSelection(2, true);
        spinnerFilterAccessCard.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                strFilter = Access_Card_visa_validity_status[position];
                iscalledFromRefresh = false;
                CallAccessCardService(true, iscalledFromRefresh, strFilter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        LinearAddNewCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utilities.showLongToast(getActivity(), "Add New Card");
            }
        });
    }

    public void CallAccessCardService(boolean isNew, final boolean iscalledFromRefresh, String visa_validity_status) {
        soqlQuery = SoqlStatements.getInstance().constructAccessCardSoqlStatement(new StoreData(getActivity().getApplicationContext()).getUserDataAsString(), visa_validity_status, limit, offset);
        try {
            restRequest = RestRequest.getRequestForQuery(
                    getActivity().getString(R.string.api_version), soqlQuery);
            if (isNew == true) {
                _cards.clear();
                offset = 0;
            } else {
                offset += limit - 1;
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
                            public void onSuccess(RestRequest request, RestResponse result) {
                                try {

                                    if (iscalledFromRefresh == true)
                                        mSwipeRefreshLayout.setRefreshing(false);

                                    ArrayList<Card_Management__c> _Returnedcards = SFResponseManager.parseCardsData(result.toString());
                                    if (_cards.size() == 0) {
                                        _cards.addAll(_Returnedcards);
                                    } else {
                                        for (int i = 0; i < _Returnedcards.size(); i++) {
                                            if (_cards.size() > 0) {
                                                boolean isFound = false;
                                                for (int j = 0; j < _cards.size(); j++) {
                                                    if (_Returnedcards.get(i).getAccount_Name__c().equals(_cards.get(j).getAccount_Name__c()) && _Returnedcards.get(i).getPassport_Number__c().equals(_Returnedcards.get(j).getPassport_Number__c())) {
                                                        isFound = true;
                                                        break;
                                                    }
                                                }
                                                if (!isFound) {
                                                    _cards.add(_Returnedcards.get(i));
                                                }
                                            }
                                        }
                                    }

                                    adapter = new AccessCardAdapter(getActivity(), getActivity().getApplicationContext(), R.layout.item_row_access_card, _cards);
                                    expandableLayoutListView.setAdapter(adapter);
                                    _Filteredcards.clear();

                                    etSearch.addTextChangedListener(new TextWatcher() {
                                        @Override
                                        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                                        }

                                        @Override
                                        public void onTextChanged(CharSequence s, int start, int before, int count) {

                                        }

                                        @Override
                                        public void afterTextChanged(Editable s) {
                                            if (!s.toString().toLowerCase().equals("")) {
                                                _Filteredcards.clear();
                                                for (int i = 0; i < _cards.size(); i++) {
                                                    if (_cards.get(i).getAccount_Name__c().toLowerCase().contains(s.toString().toLowerCase())) {
                                                        _Filteredcards.add(_cards.get(i));
                                                    }
                                                }
                                            } else {
                                                _Filteredcards.clear();
                                                _Filteredcards.addAll(_cards);
                                            }
                                            adapter = new AccessCardAdapter(getActivity(), getActivity().getApplicationContext(), R.layout.item_row_access_card, _Filteredcards);
                                            expandableLayoutListView.setAdapter(adapter);
                                        }
                                    });
                                } catch (Exception e) {
                                    onError(e);
                                }
                            }

                            @Override
                            public void onError(Exception exception) {
                                Utilities.showToast(getActivity(), RestMessages.getInstance().getErrorMessage());
                                VolleyError volleyError = (VolleyError) exception;
                                NetworkResponse response = volleyError.networkResponse;
                                String json = new String(response.data);
                                Log.d("hello", json);
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

    @Override
    public void onClick(View v) {
        if (v == imageNewCard || v == tvNewCard) {
            ActivitiesLauncher.openNewCardActivity(getActivity().getApplicationContext(), "1");
        }
    }
}
