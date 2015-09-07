package activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayout;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayoutDirection;
import com.salesforce.androidsdk.rest.RestClient;
import com.salesforce.androidsdk.rest.RestRequest;
import com.salesforce.androidsdk.rest.RestResponse;
import com.salesforce.androidsdk.ui.sfnative.SalesforceActivity;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import RestAPI.RestMessages;
import RestAPI.SFResponseManager;
import adapter.CompanyDocumentsActivityAdapter;
import adapter.CompanyDocumentsAdapter;
import cloudconcept.dwc.R;
import custom.PullAndLoadListView;
import custom.PullToRefreshListView;
import dataStorage.StoreData;
import exceptionHandling.ExceptionHandler;
import model.Attachment;
import model.Company_Documents__c;
import model.SFServiceCall;
import model.User;
import utilities.Utilities;

public class CompanyDocumentsActivity extends SalesforceActivity implements View.OnClickListener {

    ListView lstCompanyDocuments;
    SwipyRefreshLayout mSwipeRefreshLayout;
    Gson gson;
    User user;
    private RestRequest restRequest;
    private String soql;
    ImageView imageBack;
    TextView tvBack;
    Company_Documents__c company_document;
    String parentIds = "";
    Set<Company_Documents__c> company_documents;
    ArrayList<Company_Documents__c> _filteredCompanyDocuments;
    int limit = 50;
    int Mainoffset = 0;
    private RestClient client;
    private ArrayList<Attachment> attachments;
    private CompanyDocumentsActivityAdapter adapter;
    int Docposition;
    boolean isFirstTime = true;

//    String soql = "SELECT Id, Name, Customer_Document__c, Attachment_Id__c, Version__c, CreatedDate, Document_Type__c, Party__r.Id, Party__r.Name, RecordType.Id, RecordType.Name, RecordType.DeveloperName, RecordType.SObjectType, Original_Verified__c, Original_Collected__c, Required_Original__c, Verified_Scan_Copy__c, Uploaded__c, Required_Scan_copy__c FROM Company_Documents__C WHERE Company__c = "+""+" ORDER BY CreatedDate LIMIT %%d OFFSET %%d"


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler(this));
        setContentView(R.layout.company_documents);
        company_documents = new HashSet<Company_Documents__c>();
        _filteredCompanyDocuments = new ArrayList<Company_Documents__c>();
        attachments = new ArrayList<Attachment>();
        mSwipeRefreshLayout = (SwipyRefreshLayout) findViewById(R.id.activity_main_swipe_refresh_layout);
        lstCompanyDocuments = (ListView) findViewById(R.id.lstCompanyDocuments);
//        lstCompanyDocuments.setOnRefreshListener(new PullToRefreshListView.OnRefreshListener() {
//
//            @Override
//            public void onRefresh() {
//                new PullToRefreshCompanyDocumentsTask().execute();
//            }
//        });
//        lstCompanyDocuments.setOnLoadMoreListener(new PullAndLoadListView.OnLoadMoreListener() {
//
//            @Override
//            public void onLoadMore() {
//                Mainoffset += 10;
//                new LoadMoreCompanyDocumentsTask().execute();
//            }
//        });

        mSwipeRefreshLayout.setOnRefreshListener(new SwipyRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh(SwipyRefreshLayoutDirection direction) {
                Log.d("MainActivity", "Refresh triggered at "
                        + (direction == SwipyRefreshLayoutDirection.TOP ? "top" : "bottom"));
                if (direction == SwipyRefreshLayoutDirection.TOP) {
                    new PullToRefreshCompanyDocumentsTask(false).execute();
                } else {
                    new LoadMoreCompanyDocumentsTask().execute();
                }
            }
        });

        imageBack = (ImageView) findViewById(R.id.imageBack);
        tvBack = (TextView) findViewById(R.id.tvBack);
        imageBack.setOnClickListener(this);
        tvBack.setOnClickListener(this);
        Docposition = getIntent().getExtras().getInt("position");
    }

    @Override
    public void onResume(final RestClient client) {
        gson = new Gson();
        company_document = gson.fromJson(getIntent().getExtras().getString("company_documents__c"), Company_Documents__c.class);
        user = gson.fromJson(new StoreData(getApplicationContext()).getUserDataAsString(), User.class);
        this.client = client;
        if (isFirstTime) {
            Utilities.showloadingDialog(this);
        }
        DoCompanyDocumentQuery(this.client, SFServiceCall.FIRSTTIME, limit, Mainoffset);
//        lstCompanyDocuments.onRefresh();
    }

    public class PullToRefreshCompanyDocumentsTask extends AsyncTask<Void, Void, Void> {
        boolean isFirstTime;

        public PullToRefreshCompanyDocumentsTask(boolean isFirstTime) {
            this.isFirstTime = isFirstTime;
        }

        @Override
        protected Void doInBackground(Void... params) {
            if (isCancelled()) {
                return null;
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Mainoffset = 0;
            DoCompanyDocumentQuery(client, SFServiceCall.REFRESH, limit, Mainoffset);
            super.onPostExecute(aVoid);
        }
    }

    public class LoadMoreCompanyDocumentsTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            if (isCancelled()) {
                return null;
            }
            Mainoffset += 10;
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            DoCompanyDocumentQuery(client, SFServiceCall.LOADMORE, Mainoffset, limit);
            super.onPostExecute(aVoid);
        }
    }

    private void DoCompanyDocumentQuery(final RestClient client, final SFServiceCall serviceCall, final int limit, final int offset) {
        DoRequest(serviceCall, limit, offset);
    }

    private void DoRequest(final SFServiceCall serviceCall, final int limit, final int offset) {

        final int n = offset;

        soql = "SELECT Id, Name, Customer_Document__c, Attachment_Id__c, Version__c, CreatedDate, Document_Type__c, Party__r.Id, Party__r.Name, RecordType.Id, RecordType.Name, RecordType.DeveloperName, RecordType.SObjectType, Original_Verified__c, Original_Collected__c, Required_Original__c, Verified_Scan_Copy__c, Uploaded__c, Required_Scan_copy__c FROM Company_Documents__C WHERE Company__c = " + "\'" + user.get_contact().get_account().getID() + "\'" + " LIMIT " + limit + " OFFSET " + offset;
        try {
            restRequest = RestRequest.getRequestForQuery(getString(R.string.api_version), soql);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        client.sendAsync(restRequest, new RestClient.AsyncRequestCallback() {
            @Override
            public void onSuccess(RestRequest request, RestResponse response) {
                company_documents.addAll(SFResponseManager.parseCompanyDocumentObject(response.toString(), true));
//                Iterator iter = company_documents.iterator();
//                for (int i = 0; i < company_documents.size(); i++) {
//                    if (company_documents.iterator(). != null && !company_documents.get(i).getAttachment_Id__c().equals("")) {
//                        parentIds += "\'" + company_documents.get(i).getAttachment_Id__c() + "\'" + ",";
//                        _filteredCompanyDocuments.add(company_documents.get(i));
//                    }
//                }

                for (Company_Documents__c company_documents__c : company_documents) {
                    if (company_documents__c.getAttachment_Id__c() != null && !company_documents__c.getAttachment_Id__c().equals("")) {
                        _filteredCompanyDocuments.add(company_documents__c);
                    }
                }

                if (_filteredCompanyDocuments.size() > 0) {
                    adapter = new CompanyDocumentsActivityAdapter(getApplicationContext(), _filteredCompanyDocuments);
                    lstCompanyDocuments.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                    if (isFirstTime) {
                        Utilities.dismissLoadingDialog();
                        isFirstTime = false;
                    } else {
                        checkServiceCall(serviceCall);
                    }
                    lstCompanyDocuments.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            gson = new Gson();
                            company_document.setAttachment_Id__c(_filteredCompanyDocuments.get(position).getAttachment_Id__c());
                            company_document.setHasAttachment(true);
                            Intent returnIntent = new Intent();
                            returnIntent.putExtra("result", gson.toJson(company_document));
                            returnIntent.putExtra("position", Docposition);
                            setResult(RESULT_OK, returnIntent);
                            finish();
                        }
                    });
                } else {
                    DoRequest(SFServiceCall.FIRSTTIME, limit, Mainoffset += 50);
                }
            }

            @Override
            public void onError(Exception exception) {
                Utilities.showToast(CompanyDocumentsActivity.this, "Please Check Your internet connection");
            }
        });
    }

    private void checkServiceCall(SFServiceCall serviceCall) {
//        if (serviceCall == SFServiceCall.REFRESH) {
//            mSwipeRefreshLayout.setRefreshing(false);
//        } else if (serviceCall == SFServiceCall.LOADMORE) {
//            lstCo
//        }

        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onBackPressed() {
    }

    @Override
    public void onClick(View v) {
        if (v == imageBack || v == tvBack) {
            Intent returnIntent = new Intent();
            returnIntent.putExtra("result", "");
            returnIntent.putExtra("position", -1);
            setResult(RESULT_CANCELED, returnIntent);
            finish();
        }
    }
}