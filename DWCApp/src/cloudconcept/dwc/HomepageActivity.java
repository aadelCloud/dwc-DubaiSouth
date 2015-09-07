package cloudconcept.dwc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.rest.ClientManager;
import com.salesforce.androidsdk.rest.RestClient;
import com.salesforce.androidsdk.rest.RestRequest;
import com.salesforce.androidsdk.rest.RestResponse;
import com.salesforce.androidsdk.ui.sfnative.SalesforceActivity;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

import RestAPI.JSONConstants;
import RestAPI.RestMessages;
import RestAPI.SFResponseManager;
import RestAPI.SoqlStatements;
import custom.BadgeButton;
import dataStorage.StoreData;
import exceptionHandling.ExceptionHandler;
import model.User;
import utilities.ActivitiesLauncher;
import utilities.Utilities;

public class HomepageActivity extends SalesforceActivity implements
        OnClickListener {

    BadgeButton _badgeButton;
    Button btnLogout, btnLogoutTrasparent;
    RelativeLayout relativeDashboard, relativeMyRequest, relativeNotifications,
            relativeVisasAndCards, relativeCompanyInfo, relativeReports,
            relativeNeedHelp, relativeQuickAccess, relativeCompanyDocuments,relativeViewStatement;

    Button btnViewStatement;


    TextView tvCompanyName, tvLicenseNumber, tvLicenseExpiry, tvBalance;
    ImageView imageDashboard, imageMyRequests, imageVisasAndCards, imageCompanyInfo, imageCompanyDocuments, imageQuickAccess, imageNeedHelp, imageReports, smartCompanyImage;
    private OnClickListener listenerOk1 = new OnClickListener() {

        @Override
        public void onClick(View v) {
            SalesforceSDKManager.getInstance().logout(HomepageActivity.this);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler(this));
        setContentView(R.layout.homepage);
        Utilities.showloadingDialog(this);
        initializeViews();
    }

    private void initializeViews() {

        _badgeButton = (BadgeButton) findViewById(R.id.btnBadgeCount);
        _badgeButton.setBadgeDrawable(getResources().getDrawable(
                R.drawable.notification_image3));

        btnLogout = (Button) findViewById(R.id.btnLogout);

        btnLogoutTrasparent = (Button) findViewById(R.id.btnLogoutTransparent);
        relativeDashboard = (RelativeLayout) findViewById(R.id.relativeDashboard);
        relativeMyRequest = (RelativeLayout) findViewById(R.id.relativeMyRequests);
        relativeNotifications = (RelativeLayout) findViewById(R.id.relativeNotifications);
        relativeVisasAndCards = (RelativeLayout) findViewById(R.id.relativeVisasAndCards);
        relativeCompanyInfo = (RelativeLayout) findViewById(R.id.relativeCompanyInfo);
        relativeReports = (RelativeLayout) findViewById(R.id.relativeReports);
        relativeNeedHelp = (RelativeLayout) findViewById(R.id.relativeNeedHelp);
        relativeQuickAccess = (RelativeLayout) findViewById(R.id.relativeQuickAccess);
        relativeCompanyDocuments = (RelativeLayout) findViewById(R.id.relativeCompanyDocuments);
        relativeViewStatement = (RelativeLayout)findViewById(R.id.relativeViewStatement);

        btnViewStatement = (Button)findViewById(R.id.btnViewStatement);

        imageCompanyDocuments = (ImageView) findViewById(R.id.imageCompanyDocuments);
        imageDashboard = (ImageView) findViewById(R.id.imageDashboard);
        imageMyRequests = (ImageView) findViewById(R.id.imageMyRequests);
        imageVisasAndCards = (ImageView) findViewById(R.id.imageVisasAndCards);
        imageCompanyInfo = (ImageView) findViewById(R.id.imageCompanyInfo);
        imageQuickAccess = (ImageView) findViewById(R.id.imageQuickAccess);
        imageNeedHelp = (ImageView) findViewById(R.id.imageNeedHelp);
        imageReports = (ImageView) findViewById(R.id.imageReports);

        relativeDashboard.setOnClickListener(this);
        relativeMyRequest.setOnClickListener(this);
        relativeNotifications.setOnClickListener(this);
        relativeVisasAndCards.setOnClickListener(this);
        relativeCompanyInfo.setOnClickListener(this);
        relativeReports.setOnClickListener(this);
        relativeNeedHelp.setOnClickListener(this);
        relativeQuickAccess.setOnClickListener(this);
        relativeCompanyDocuments.setOnClickListener(this);
relativeViewStatement.setOnClickListener(this);
        btnViewStatement.setOnClickListener(this);
        imageCompanyDocuments.setOnClickListener(this);
        imageDashboard.setOnClickListener(this);
        imageMyRequests.setOnClickListener(this);
        imageVisasAndCards.setOnClickListener(this);
        imageCompanyInfo.setOnClickListener(this);
        imageQuickAccess.setOnClickListener(this);
        imageNeedHelp.setOnClickListener(this);
        imageReports.setOnClickListener(this);

        tvCompanyName = (TextView) findViewById(R.id.tvCompanyName);
        tvLicenseExpiry = (TextView) findViewById(R.id.tvLicenseExpiry);
        tvLicenseNumber = (TextView) findViewById(R.id.tvLicenseNumber);
        smartCompanyImage = (ImageView) findViewById(R.id.companyImage);
        tvBalance = (TextView) findViewById(R.id.tvBalance);
    }

    @Override
    public void onResume() {
        findViewById(R.id.root).setVisibility(View.INVISIBLE);
        super.onResume();
        new ClientManager(this, SalesforceSDKManager.getInstance().getAccountType(), SalesforceSDKManager.getInstance().getLoginOptions(), SalesforceSDKManager.getInstance().shouldLogoutWhenTokenRevoked()).getRestClient(this, new ClientManager.RestClientCallback() {
            @Override
            public void authenticatedRestClient(RestClient client) {
                if (client == null) {
                    SalesforceSDKManager.getInstance().logout(HomepageActivity.this);
                    return;
                } else {
                    try {
                        new StoreData(getApplicationContext()).saveUserID(SalesforceSDKManager.getInstance().getUserAccountManager().getCurrentUser().getUserId());
                        sendRequestCompanyInfo(HomepageActivity.this, client);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    @Override
    public void onResume(RestClient client) {
//        RestClient.ClientInfo _userInfo = client.getClientInfo();
//        new StoreData(getApplicationContext()).saveUserID(_userInfo.userId);
//        new ClientManager(this, SalesforceSDKManager.getInstance().getAccountType(), SalesforceSDKManager.getInstance().getLoginOptions(), SalesforceSDKManager.getInstance().shouldLogoutWhenTokenRevoked()).getRestClient(this, new ClientManager.RestClientCallback() {
//            @Override
//            public void authenticatedRestClient(RestClient client) {
//                if (client == null) {
//                    SalesforceSDKManager.getInstance().logout(HomepageActivity.this);
//                    return;
//                } else {
//                    try {
//                        sendRequestCompanyInfo(HomepageActivity.this, client);
//                    } catch (UnsupportedEncodingException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });
    }

    public void onLogoutClick(View v) {
        Utilities.showNiftyDialog("Logout", this, listenerOk1);
    }

    @Override
    public void onClick(View v) {
        if (v == relativeDashboard || v == imageDashboard) {

            ActivitiesLauncher.openDashboardActivity(getApplicationContext());
            imageDashboard.setSelected(true);

        } else if (v == relativeMyRequest || v == imageMyRequests) {

            ActivitiesLauncher.openMyRequestsActivity(getApplicationContext());
            imageMyRequests.setSelected(true);

        } else if (v == relativeNotifications || v == _badgeButton) {

            ActivitiesLauncher.openNotificationsActivity(getApplicationContext());
            _badgeButton.setSelected(true);

        } else if (v == relativeVisasAndCards || v == imageVisasAndCards) {

            ActivitiesLauncher.openVisasAndCardsActivity(getApplicationContext());
            imageVisasAndCards.setSelected(true);

        } else if (v == relativeCompanyInfo || v == imageCompanyInfo) {

            ActivitiesLauncher.openCompanyInfoActivity(getApplicationContext());
            imageCompanyInfo.setSelected(true);

        } else if (v == relativeReports || v == imageReports) {

            ActivitiesLauncher.openReportsActivity(getApplicationContext());
            imageReports.setSelected(true);

        } else if (v == relativeNeedHelp || v == imageNeedHelp) {

            ActivitiesLauncher.openNeedHelpActivity(getApplicationContext());
            imageNeedHelp.setSelected(true);

        } else if (v == relativeQuickAccess || v == imageQuickAccess) {

            ActivitiesLauncher.openQuickAccessActivity(getApplicationContext());
            imageQuickAccess.setSelected(true);

        } else if (v == relativeCompanyDocuments || v == imageCompanyDocuments) {

            ActivitiesLauncher.openCompanyDocumentsActivity(getApplicationContext());
            imageCompanyDocuments.setSelected(true);

        }else if(v==btnViewStatement||v==relativeViewStatement){
            ActivitiesLauncher.openViewStatementActivity(getApplicationContext());
        }
    }

    public void sendRequestCompanyInfo(final Activity act, final RestClient client) throws UnsupportedEncodingException {

        String soql = SoqlStatements.soql_company_info + "\'" + new StoreData(act.getApplicationContext()).getUserID() + "\'";

        final RestRequest restRequest = RestRequest.getRequestForQuery(
                getString(R.string.api_version), soql);

        client.sendAsync(restRequest, new RestClient.AsyncRequestCallback() {
            @Override
            public void onSuccess(RestRequest request, RestResponse result) {
                try {
                    User _user = SFResponseManager.parseCompanyRestResponse(result.toString());
                    Gson gson = new Gson();
                    String json = gson.toJson(_user);
                    Utilities.setUserPhoto(HomepageActivity.this, _user.get_contact().get_account().getCompany_Logo(), smartCompanyImage);
                    new StoreData(getApplicationContext()).setUserDataAsString(json);
                    sendNotificationCountRequest(_user, client);
                } catch (Exception e) {
                    onError(e);
                }
            }

            @Override
            public void onError(Exception exception) {
                Utilities.showToast(HomepageActivity.this, RestMessages.getInstance().getErrorMessage());
                finish();
            }
        });
    }

    private void sendNotificationCountRequest(final User user, RestClient client) {

        String soql = "SELECT COUNT(ID) FROM Notification_Management__c WHERE Case__r.AccountId = " + "\'" + user.get_contact().get_account().getID() + "\'" + " AND Is_Push_Notification_Allowed__c = TRUE AND isMessageRead__c = FALSE";
        try {
            final RestRequest rest_request_notification = RestRequest.getRequestForQuery(
                    getString(R.string.api_version), soql);

            client.sendAsync(rest_request_notification, new RestClient.AsyncRequestCallback() {
                @Override
                public void onSuccess(RestRequest request, RestResponse result) {
                    try {
                        int notificationCount = 0;
                        JSONObject jsonCountNotifications = new JSONObject(result.toString());
                        if (jsonCountNotifications.optBoolean(JSONConstants.DONE) == true) {
                            notificationCount = jsonCountNotifications.getJSONArray(JSONConstants.RECORDS).getJSONObject(0).getInt("expr0");
                            new StoreData(getApplicationContext()).setNotificationCount(notificationCount + "");
                            setUICOmponents(user, notificationCount);
                        }
                    } catch (Exception e) {
                        onError(e);
                    }
                }

                @Override
                public void onError(Exception exception) {
                    Utilities.showToast(HomepageActivity.this, RestMessages.getInstance().getErrorMessage());
                    finish();
                }
            });
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public void setUICOmponents(User _user, int notificationCount) {
        Utilities.dismissLoadingDialog();
        new StoreData(getApplicationContext()).setUsername(_user.get_contact().getName());
        findViewById(R.id.root).setVisibility(View.VISIBLE);
        tvCompanyName.setText(_user.get_contact().get_account().getName());
        tvLicenseNumber.setText(_user.get_contact().get_account().getLicenseNumberFormula());
        tvLicenseExpiry.setText(_user.get_contact().get_account().get_currentLicenseNumber().getLicense_Expiry_Date());
        tvBalance.setText(_user.get_contact().get_account().getPortalBalance() + " AED");
        if (notificationCount == 0) {
            _badgeButton.hideBadge();
        } else {
            _badgeButton.setBadgeText(notificationCount + "");
            _badgeButton.showBadge();
        }
    }
}