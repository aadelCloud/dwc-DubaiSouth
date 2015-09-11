package fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.rest.ClientManager;
import com.salesforce.androidsdk.rest.RestClient;

import cloudconcept.dwc.R;
import dataStorage.StoreData;
import model.Company_Documents__c;
import model.EServices_Document_Checklist__c;
import model.User;
import utilities.Utilities;

/**
 * Created by Abanoub Wagdy on 9/10/2015.
 */
public class PreviewFragment extends Fragment {

    static String objectAsStr;
    static String type;
    Company_Documents__c company_documents__c;
    EServices_Document_Checklist__c eServices_document_checklist__c;
    Gson gson = new Gson();
    ImageView imagePreview;
    static Context context;
    String attachmentId;
    private User user;
    private String url;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = null;
        if (type.equals("Company_Documents__c")) {
            view = inflater.inflate(R.layout.preview, container, false);
            InitializeViews(view, savedInstanceState);
            CallDownloadAttachmentService(attachmentId);
        } else {
            view = inflater.inflate(R.layout.dashboard, container, false);
            InitializeViews(view, savedInstanceState);
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

                    String attUrl = client.getClientInfo().resolveUrl(url).toString();
                    webView.loadUrl(attUrl);
                }
            });

            return view;
        }

        return view;
    }

    private void CallDownloadAttachmentService(String attachmentId) {
        Utilities.setUserPhoto(getActivity(), attachmentId, imagePreview);
    }

    public static PreviewFragment newInstance(Context applicationContext, String object, String text) {
        PreviewFragment fragment = new PreviewFragment();
        Bundle bundle = new Bundle();
//        bundle.putString("object", object);
//        bundle.putString("type", text);
        objectAsStr = object;
        type = text;
        fragment.setArguments(bundle);
        PreviewFragment.context = applicationContext;
        return fragment;
    }

    private void InitializeViews(View view, Bundle savedInstanceState) {
        Gson gson = new Gson();
        user = gson.fromJson(new StoreData(getActivity().getApplicationContext()).getUserDataAsString(), User.class);
        imagePreview = (ImageView) view.findViewById(R.id.ImagePreview);
        if (type.equals("Company_Documents__c")) {
            company_documents__c = gson.fromJson(objectAsStr, Company_Documents__c.class);
            attachmentId = company_documents__c.getAttachment_Id__c();
        } else {
            eServices_document_checklist__c = gson.fromJson(objectAsStr, EServices_Document_Checklist__c.class);
            url = eServices_document_checklist__c.getEService_Administration__r().getService_VF_Page__c();
            if (url.contains("<accId>")) {
                url.replaceAll("<accId>", "");
                url += "\'" + user.get_contact().get_account().getID() + "\'";
            } else if (url.contains("<ContractId>")) {
                url.replaceAll("<ContractId>", "");
                url += "\'" + user.get_contact().get_account().getID() + "\'";
            }
        }
    }
}