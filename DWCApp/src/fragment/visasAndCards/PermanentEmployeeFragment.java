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
import adapter.visasAdapters.PermanentEmployeeListAdapter;
import adapter.SpinnerAdapter;
import cloudconcept.dwc.R;
import custom.CustomViewPager;
import dataStorage.StoreData;
import model.Visa;
import utilities.Utilities;

/**
 * Created by Abanoub on 6/24/2015.
 */
public class PermanentEmployeeFragment extends Fragment {

    private static final String ARG_TEXT = "PermanentEmployee";
    static String strFilter;
    public boolean iscalledFromRefresh = false;
    ListView expandableLayoutListView;
    SwipyRefreshLayout mSwipeRefreshLayout;
    Spinner spinnerFilterPermanentEmployee;
    EditText etSearch;
    String[] visa_validity_status = new String[]{"All", "Issued", "Expired", "Cancelled", "Under Process", "Under Renewal"};
    RestRequest restRequest;
    ArrayList<Visa> _visas;
    ArrayList<Visa> _Filteredvisas;
    int limit = 10;
    int offset = 0;
    PermanentEmployeeListAdapter adapter;
    private String soqlQuery;

    public static PermanentEmployeeFragment newInstance(String text) {

        PermanentEmployeeFragment fragment = new PermanentEmployeeFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_TEXT, text);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.visas_cards_permanent__employee, container, false);
        offset = 0;
        _visas = new ArrayList<Visa>();
        _Filteredvisas = new ArrayList<Visa>();
        InitializeViews(view);
        CallPermanentEmployeeService(true, iscalledFromRefresh, strFilter);
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
                CallPermanentEmployeeService(true, iscalledFromRefresh, strFilter);
            }
        });

        ArrayAdapter<String> dataAdapter = new SpinnerAdapter(getActivity().getApplicationContext(), R.layout.spinner_item,
                Arrays.asList(getActivity().getApplicationContext().getResources().getStringArray(R.array.permanent_employee_filter)));
        spinnerFilterPermanentEmployee.setAdapter(dataAdapter);
        spinnerFilterPermanentEmployee.setSelection(1, true);
        spinnerFilterPermanentEmployee.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                strFilter = visa_validity_status[position];
                iscalledFromRefresh = false;
                CallPermanentEmployeeService(true, iscalledFromRefresh, strFilter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    public void CallPermanentEmployeeService(boolean isNew, final boolean iscalledFromRefresh, String visa_validity_status) {
        soqlQuery = SoqlStatements.getInstance().constructPermanentEmployeeSoqlStatement(new StoreData(getActivity().getApplicationContext()).getUserDataAsString(), visa_validity_status, limit, offset);
        try {
            restRequest = RestRequest.getRequestForQuery(
                    getActivity().getString(R.string.api_version), soqlQuery);

            if (isNew == true) {
                _visas.clear();
                offset = 0;
            } else {
                offset += limit - 1;
            }

            if (iscalledFromRefresh == false) {
                Utilities.showloadingDialog(getActivity());
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
                                    if (iscalledFromRefresh == false) {
                                        Utilities.dismissLoadingDialog();
                                    } else {
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

                                    adapter = new PermanentEmployeeListAdapter(getActivity(),getActivity().getApplicationContext(),
                                            R.layout.item_row_permanent_employee, _visas);
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

                                            adapter = new PermanentEmployeeListAdapter(getActivity(),getActivity().getApplicationContext(),
                                                    R.layout.item_row_permanent_employee, _Filteredvisas);
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