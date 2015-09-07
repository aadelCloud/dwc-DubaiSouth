package activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

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

import RestAPI.RestMessages;
import RestAPI.SFResponseManager;
import RestAPI.SoqlStatements;
import adapter.NOCEmployeeListAdapter;
import cloudconcept.dwc.R;
import dataStorage.StoreData;
import model.User;
import model.Visa;
import utilities.ActivitiesLauncher;
import utilities.Utilities;

/**
 * Created by Bibo on 7/21/2015.
 */
public class EmployeeListActivity extends Activity {

    ListView listEmployess;
    SwipyRefreshLayout mSwipeRefreshLayout;
    private ArrayList<Visa> _Filteredvisas;
    private ArrayList<Visa> _visas;
    private String soqlQuery;
    int limit = 10;
    int offset = 0;
    private RestRequest restRequest;
    private NOCEmployeeListAdapter adapter;
    EditText etSearch;
    private boolean iscalledFromRefresh = false;
    private ImageView imageBack;
    private TextView tvQuickAccess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee_noc_list);
        _visas = new ArrayList<Visa>();
        _Filteredvisas = new ArrayList<Visa>();
        InitializeViews();
        CallPermanentEmployeeService(true, iscalledFromRefresh);
    }

    private void InitializeViews() {
        mSwipeRefreshLayout = (SwipyRefreshLayout) findViewById(R.id.activity_main_swipe_refresh_layout);
        etSearch = (EditText) findViewById(R.id.etSearch);
        iscalledFromRefresh = false;
        listEmployess = (ListView) findViewById(R.id.listEmployees);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipyRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh(SwipyRefreshLayoutDirection direction) {
                Log.d("MainActivity", "Refresh triggered at "
                        + (direction == SwipyRefreshLayoutDirection.TOP ? "top" : "bottom"));
                iscalledFromRefresh = true;
                CallPermanentEmployeeService(true, iscalledFromRefresh);
            }
        });
        imageBack = (ImageView) findViewById(R.id.imageBack);
        tvQuickAccess = (TextView) findViewById(R.id.tvQuickAccess);
        tvQuickAccess.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ActivitiesLauncher.openQuickAccessActivity(getApplicationContext());
                finish();
            }
        });

        imageBack.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ActivitiesLauncher.openQuickAccessActivity(getApplicationContext());
                finish();
            }
        });
    }

    public void CallPermanentEmployeeService(boolean isNew, final boolean iscalledFromRefresh) {
        Gson gson = new Gson();
        User _user = gson.fromJson(new StoreData(getApplicationContext()).getUserDataAsString(), User.class);
        soqlQuery = SoqlStatements.getInstance().constructEmployeeListStatement(_user.get_contact().get_account().getID(), limit, offset);
        try {
            restRequest = RestRequest.getRequestForQuery(getString(R.string.api_version), soqlQuery);
            if (isNew == true) {
                _visas.clear();
                offset = 0;
            } else {
                offset += limit - 1;
            }

            if (iscalledFromRefresh == false) {
                Utilities.showloadingDialog(this);
            }

            new ClientManager(this, SalesforceSDKManager.getInstance().getAccountType(), SalesforceSDKManager.getInstance().getLoginOptions(), SalesforceSDKManager.getInstance().shouldLogoutWhenTokenRevoked()).getRestClient(EmployeeListActivity.this, new ClientManager.RestClientCallback() {
                @Override
                public void authenticatedRestClient(RestClient client) {
                    if (client == null) {
                        SalesforceSDKManager.getInstance().logout(EmployeeListActivity.this);
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

                                    adapter = new NOCEmployeeListAdapter(EmployeeListActivity.this, EmployeeListActivity.this.getApplicationContext(),
                                            R.layout.item_row_permanent_employee, _visas);
                                    listEmployess.setAdapter(adapter);
                                    listEmployess.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                        @Override
                                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                            Gson gson = new Gson();
                                            String objectAsString = gson.toJson(_visas.get(position));
                                            ActivitiesLauncher.openNOCActivity(getApplicationContext(), objectAsString, "Visa");
                                        }
                                    });
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
                                                    if (Utilities.stringNotNull(_visas.get(i).getApplicant_Full_Name__c()).toLowerCase().contains(s.toString().toLowerCase())) {
                                                        _Filteredvisas.add(_visas.get(i));
                                                    }
                                                }

                                            } else {
                                                _Filteredvisas.clear();
                                                _Filteredvisas.addAll(_visas);
                                            }

                                            adapter = new NOCEmployeeListAdapter(EmployeeListActivity.this, EmployeeListActivity.this.getApplicationContext(),
                                                    R.layout.item_row_employee_list, _Filteredvisas);
                                            listEmployess.setAdapter(adapter);
                                            listEmployess.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                                @Override
                                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                                    Gson gson = new Gson();
                                                    String objectAsString = gson.toJson(_Filteredvisas.get(position));
                                                    ActivitiesLauncher.openNOCActivity(getApplicationContext(), objectAsString, "Visa");
                                                }
                                            });
                                        }
                                    });
                                } catch (Exception e) {
                                    onError(e);
                                }
                            }

                            @Override
                            public void onError(Exception exception) {
                                Utilities.showToast(EmployeeListActivity.this, RestMessages.getInstance().getErrorMessage());
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