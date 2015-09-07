package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.gson.Gson;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.rest.ClientManager;
import com.salesforce.androidsdk.rest.RestClient;

import cloudconcept.dwc.R;
import dataStorage.StoreData;
import model.User;

/**
 * Created by Bibo on 7/28/2015.
 */
public class DashboardFragment extends Fragment {

    public static Fragment newInstance(String dashboard) {
        DashboardFragment fragment = new DashboardFragment();
        Bundle bundle = new Bundle();
        bundle.putString("DashboardFragment", dashboard);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dashboard, container, false);
        final WebView webView = (WebView) view.findViewById(R.id.sf__oauth_webview);
        new ClientManager(getActivity(), SalesforceSDKManager.getInstance().getAccountType(), SalesforceSDKManager.getInstance().getLoginOptions(), SalesforceSDKManager.getInstance().shouldLogoutWhenTokenRevoked()).getRestClient(getActivity(), new ClientManager.RestClientCallback() {

            @Override
            public void authenticatedRestClient(RestClient client) {
                final WebSettings webSettings = webView.getSettings();
                webSettings.setJavaScriptEnabled(true);
                webSettings.setAllowFileAccessFromFileURLs(true);
                webSettings.setDatabaseEnabled(true);
                webSettings.setDomStorageEnabled(true);
                webView.setWebChromeClient(new WebChromeClient() {
                    public void onProgressChanged(WebView view, int progress) {

                        getActivity().setProgress(progress * 1000);
                    }
                });

                webView.setWebViewClient(new WebViewClient() {
                    public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {

                    }
                });

                final Gson gson = new Gson();
                User user = gson.fromJson(new StoreData(getActivity().getApplicationContext()).getUserDataAsString(), User.class);
                String attUrl = client.getClientInfo().resolveUrl("/apex/DWCPortal_DashboardMobile").toString();
                String url = attUrl + "?accountId=" + user.get_contact().get_account().getID();
                webView.loadUrl(url);
            }
        });

        return view;
    }
}
