package fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
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
import adapter.NotificationsAdapter;
import cloudconcept.dwc.R;
import custom.PullAndLoadListView;
import custom.PullToRefreshListView;
import dataStorage.StoreData;
import model.NotificationManagement;
import model.SFServiceCall;
import model.User;
import utilities.Utilities;

/**
 * Created by Abanoub Wagdy on 6/17/2015.
 */
public class NotificationFragment extends Fragment {

    PullAndLoadListView pullAndLoadListViewNotifications;
    private int limit = 10;
    private int offset = 0;
    private String soqlQuery;
    private RestRequest restRequest;
    private String loadMoreResponse = "";
    private ArrayList<NotificationManagement> InflatedNotificationManagements;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.notifications, container, false);
        pullAndLoadListViewNotifications = (PullAndLoadListView) view.findViewById(R.id.pullandloadNotifications);
        pullAndLoadListViewNotifications.setOnRefreshListener(new PullToRefreshListView.OnRefreshListener() {

            @Override
            public void onRefresh() {
                limit = 10;
                offset = 0;
                new PullToRefreshNotificationsTask(offset, limit).execute();
            }
        });

        pullAndLoadListViewNotifications.setOnLoadMoreListener(new PullAndLoadListView.OnLoadMoreListener() {

            @Override
            public void onLoadMore() {
                offset += 10;
                new LoadMoreNotificationsTask(offset, limit).execute();
            }
        });

        InflatedNotificationManagements = new ArrayList<NotificationManagement>();
        pullAndLoadListViewNotifications.onRefresh();
        return view;
    }

    public class PullToRefreshNotificationsTask extends AsyncTask<Void, Void, Void> {

        private int offset;
        private int limit;

        public PullToRefreshNotificationsTask(int offset, int limit) {
            this.limit = limit;
            this.offset = offset;
        }

        @Override
        protected Void doInBackground(Void... params) {

            if (isCancelled()) {
                return null;
            }
            offset = 0;
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Utilities.showloadingDialog(getActivity());
            CallOnRefreshNotificationService(SFServiceCall.REFRESH, offset, limit);
            super.onPostExecute(aVoid);
        }

        @Override
        protected void onCancelled() {
            pullAndLoadListViewNotifications.onRefreshComplete();
        }
    }

    public class LoadMoreNotificationsTask extends AsyncTask<Void, Void, Void> {

        private int offset;
        private int limit;

        public LoadMoreNotificationsTask(int offset, int limit) {
            this.limit = limit;
            this.offset = offset;
        }

        @Override
        protected Void doInBackground(Void... params) {

            if (isCancelled()) {
                return null;
            }
            offset = 0;
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Utilities.showloadingDialog(getActivity());
            CallOnRefreshNotificationService(SFServiceCall.LOADMORE, offset, limit);
            super.onPostExecute(aVoid);
        }

        @Override
        protected void onCancelled() {
            pullAndLoadListViewNotifications.onRefreshComplete();
        }
    }

    private void CallOnRefreshNotificationService(final SFServiceCall callType, int offset, int limit) {

        Gson gson = new Gson();
        User _user = gson.fromJson(new StoreData(getActivity().getApplicationContext()).getUserDataAsString(), User.class);
        soqlQuery = SoqlStatements.getInstance().constructNotificationsServiceQuery(_user.get_contact().get_account().getID(), limit, offset);

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
                            public void onSuccess(RestRequest request, RestResponse result) {
                                ArrayList<NotificationManagement> notificationManagements = SFResponseManager.parseNotificationsResponse(result.toString());
                                if (loadMoreResponse.equals("")) {
                                    InflatedNotificationManagements.addAll(notificationManagements);
                                } else {
                                    for (int i = 0; i < notificationManagements.size(); i++) {
                                        if (!InflatedNotificationManagements.contains(notificationManagements.get(i))) {
                                            InflatedNotificationManagements.add(notificationManagements.get(i));
                                        }
                                    }
                                }
                                if (result.toString().equals(loadMoreResponse)) {
                                    pullAndLoadListViewNotifications.setOnLoadMoreListener(null);
                                }
                                loadMoreResponse = result.toString();
                                if (callType == SFServiceCall.LOADMORE) {
                                    pullAndLoadListViewNotifications.onLoadMoreComplete();
                                } else if (callType == SFServiceCall.REFRESH) {
                                    pullAndLoadListViewNotifications.onRefreshComplete();
                                }
                                Utilities.dismissLoadingDialog();
                                pullAndLoadListViewNotifications.setAdapter(new NotificationsAdapter(getActivity(), getActivity().getApplicationContext(), R.layout.notifications_row_item, InflatedNotificationManagements));
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
