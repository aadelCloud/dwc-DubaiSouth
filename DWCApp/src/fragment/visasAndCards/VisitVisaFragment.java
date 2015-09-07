package fragment.visasAndCards;

import android.os.Bundle;
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
import android.widget.ListView;
import android.widget.Spinner;

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
import adapter.visasAdapters.MyVisitVisaAdapter;
import cloudconcept.dwc.R;
import dataStorage.StoreData;
import model.Visa;
import utilities.Utilities;

/**
 * Created by Abanoub on 6/24/2015.
 */
public class VisitVisaFragment extends Fragment {

    private static final String ARG_TEXT = "VisitVisa";

    static String strFilter;
    public boolean iscalledFromRefresh = false;
    ListView expandableLayoutListView;
    SwipyRefreshLayout mSwipeRefreshLayout;
    Spinner spinnerFilterPermanentEmployee;
    EditText etSearch;
    String[] visa_validity_status = new String[]{"All", "Issued", "Expired", "Cancelled", "Under Process"};
    RestRequest restRequest;
    int limit = 10;
    int offset = 0;
    MyVisitVisaAdapter adapter;
    private String soqlQuery;
    private ArrayList<Visa> _visas;
    private ArrayList<Visa> _Filteredvisas;

    public static VisitVisaFragment newInstance(String text) {
        VisitVisaFragment fragment = new VisitVisaFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_TEXT, text);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.visas_cards_visit__visas, container, false);
        InitializeViews(view);
        _visas = new ArrayList<Visa>();
        _Filteredvisas = new ArrayList<Visa>();
        CallVisitVisaService(true, iscalledFromRefresh, strFilter);
        return view;
    }

    private void InitializeViews(View view) {

        expandableLayoutListView = (ListView) view.findViewById(R.id.expandableLayoutListView);
        spinnerFilterPermanentEmployee = (Spinner) view.findViewById(R.id.spinner);
        mSwipeRefreshLayout = (SwipyRefreshLayout) view.findViewById(R.id.activity_main_swipe_refresh_layout);
        etSearch = (EditText) view.findViewById(R.id.etSearch);
        iscalledFromRefresh = false;

        if (strFilter == null)
            strFilter = visa_validity_status[1];

        mSwipeRefreshLayout.setOnRefreshListener(new SwipyRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh(SwipyRefreshLayoutDirection direction) {
                Log.d("MainActivity", "Refresh triggered at "
                        + (direction == SwipyRefreshLayoutDirection.TOP ? "top" : "bottom"));
                iscalledFromRefresh = true;
                CallVisitVisaService(true, iscalledFromRefresh, strFilter);
            }
        });

        ArrayAdapter<String> dataAdapter = new SpinnerAdapter(getActivity().getApplicationContext(), R.layout.spinner_item,
                Arrays.asList(getActivity().getApplicationContext().getResources().getStringArray(R.array.permanent_employee_filter)));
        spinnerFilterPermanentEmployee.setAdapter(dataAdapter);
        spinnerFilterPermanentEmployee.setSelection(4, true);
        spinnerFilterPermanentEmployee.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                strFilter = visa_validity_status[position];
                iscalledFromRefresh = false;
                CallVisitVisaService(true, iscalledFromRefresh, strFilter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private void CallVisitVisaService(boolean isNew, final boolean iscalledFromRefresh, String strFilter) {
        soqlQuery = SoqlStatements.getInstance().constructVisitVisaSoqlStatement(new StoreData(getActivity().getApplicationContext()).getUserDataAsString(), strFilter, limit, offset);
        try {
            restRequest = RestRequest.getRequestForQuery(
                    getActivity().getString(R.string.api_version), soqlQuery);
            if (isNew == true) {
                _visas.clear();
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
                                    if (iscalledFromRefresh == true) {
                                        mSwipeRefreshLayout.setRefreshing(false);
                                    }
                                    ArrayList<Visa> _Returnedvisas = SFResponseManager.parseVisaData(result.toString());
                                    if (_visas.size() == 0) {
                                        _visas.addAll(_Returnedvisas);
                                    } else {
                                        for (int i = 0; i < _Returnedvisas.size(); i++) {
                                            if (_visas.size() > 0) {
                                                boolean isFound = false;
                                                for (int j = 0; j < _visas.size(); j++) {
                                                    if (_Returnedvisas.get(i).getApplicant_Full_Name__c().equals(_visas.get(j).getApplicant_Full_Name__c()) && _Returnedvisas.get(i).getPassport_Number__c().equals(_visas.get(j).getPassport_Number__c())) {
                                                        isFound = true;
                                                        break;
                                                    }
                                                }
                                                if (!isFound) {
                                                    _visas.add(_Returnedvisas.get(i));
                                                }
                                            }
                                        }
                                    }

                                    adapter = new MyVisitVisaAdapter(getActivity(), getActivity().getApplicationContext(), R.layout.item_row_visit_visa, _visas);
                                    expandableLayoutListView.setAdapter(adapter);
                                    _Filteredvisas.clear();

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
                                                _Filteredvisas.clear();
                                                for (int i = 0; i < _visas.size(); i++) {
                                                    if (_visas.get(i).getApplicant_Full_Name__c().toLowerCase().contains(s.toString().toLowerCase())) {
                                                        _Filteredvisas.add(_visas.get(i));
                                                    }
                                                }
                                            } else {
                                                _Filteredvisas.clear();
                                                _Filteredvisas.addAll(_visas);
                                            }
                                            adapter = new MyVisitVisaAdapter(getActivity(), getActivity().getApplicationContext(), R.layout.item_row_visit_visa, _visas);
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