package fragment;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.rest.ClientManager;
import com.salesforce.androidsdk.rest.RestClient;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import cloudconcept.dwc.R;
import custom.customdialog.NiftyDialogBuilder;
import dataStorage.StoreData;

import fragmentActivity.CompanyNOC.CompanyNocMainFragment;
import fragmentActivity.NOCScreen.NocMainFragment;
import fragmentActivity.NOCScreen.NocPayAndSubmit;
import model.NOC__c;
import utilities.Utilities;

/**
 * Created by Abanoub Wagdy on 8/2/2015.
 */
public abstract class BaseServiceFragment extends Fragment implements View.OnClickListener {

    static FragmentManager fragmentManager;
    public static Button btnNext;
    Button btnCancel;
    Button btnBackTransparent;
    ImageView btnBack;
    public static Button btnNOC1;
    public static Button btnNOC2;
    public static Button btnNOC3;
    public static Button btnNOC4;
    Button btnNOC5;
    View line1, line2, line3, line4, line5, line6;
    public static int status = 1;
    static FrameLayout frameLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.base_service_layout, container, false);
        InitializeViews(view);
        fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.content, getInitialFragment())
                .commit();
        return view;
    }



    private void InitializeViews(View view) {

        btnNext = (Button) view.findViewById(R.id.btnNext);
        btnCancel = (Button) view.findViewById(R.id.btnCancel);
        btnBackTransparent = (Button) view.findViewById(R.id.btnBackTransparent);
        btnBack = (ImageView) view.findViewById(R.id.btnBack);

        btnNext.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
        btnBackTransparent.setOnClickListener(this);
        btnBack.setOnClickListener(this);

        btnNOC1 = (Button) view.findViewById(R.id.btnNOC1);
        btnNOC2 = (Button) view.findViewById(R.id.btnNOC2);
        btnNOC3 = (Button) view.findViewById(R.id.btnNOC3);
        btnNOC4 = (Button) view.findViewById(R.id.btnNOC4);
        btnNOC5 = (Button) view.findViewById(R.id.btnNOC5);

        btnNOC1.setSelected(true);
        btnNOC1.setEnabled(true);

        line1 = view.findViewById(R.id.line1);
        line2 = view.findViewById(R.id.line2);
        line3 = view.findViewById(R.id.line3);
        line4 = view.findViewById(R.id.line4);
        line5 = view.findViewById(R.id.line5);
        line6 = view.findViewById(R.id.line6);

        frameLayout = (FrameLayout) view.findViewById(R.id.content);
    }

    @Override
    public void onClick(View v) {

        if (v == btnBack || v == btnBackTransparent) {
            if (status == 1) {
                Utilities.showCustomNiftyDialog("Cancel NOC Process", getActivity(), listenerOk1, "Are you sure want to cancel the NOC process ?");
            } else if (status == 2) {
                frameLayout.removeAllViewsInLayout();
                fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.content, getInitialFragment())
                        .commit();
//                showInactiveWizard(btnNOC1, line2);

                btnNOC1.setBackground(getActivity().getResources().getDrawable(R.drawable.noc_selector));
                btnNOC1.setSelected(true);
                btnNOC1.setTextColor(getActivity().getResources().getColor(R.color.white));
                btnNOC1.setGravity(Gravity.CENTER);
                btnNOC1.setText("1");

                btnNOC2.setBackground(getActivity().getResources().getDrawable(R.drawable.noc_selector));
                btnNOC2.setSelected(false);
                btnNOC2.setTextColor(getActivity().getResources().getColor(R.color.white));
                btnNOC2.setGravity(Gravity.CENTER);
                btnNOC2.setText("2");

                status = 1;

            } else if (status == 3) {
                frameLayout.removeAllViewsInLayout();
                fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.content, getSecondFragment())
                        .commit();
//                showInactiveWizard(btnNOC2, line3);


                btnNOC2.setBackground(getActivity().getResources().getDrawable(R.drawable.noc_selector));
                btnNOC2.setSelected(true);
                btnNOC2.setTextColor(getActivity().getResources().getColor(R.color.white));
                btnNOC2.setGravity(Gravity.CENTER);
                btnNOC2.setText("2");

                btnNOC3.setBackground(getActivity().getResources().getDrawable(R.drawable.noc_selector));
                btnNOC3.setSelected(false);
                btnNOC3.setTextColor(getActivity().getResources().getColor(R.color.white));
                btnNOC3.setGravity(Gravity.CENTER);
                btnNOC3.setText("3");

                status = 2;
            } else if (status == 4) {
                frameLayout.removeAllViewsInLayout();
                fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.content, getThirdFragment())
                        .commit();
//                showInactiveWizard(btnNOC3, line4);


                btnNOC3.setBackground(getActivity().getResources().getDrawable(R.drawable.noc_selector));
                btnNOC3.setSelected(true);
                btnNOC3.setTextColor(getActivity().getResources().getColor(R.color.white));
                btnNOC3.setGravity(Gravity.CENTER);
                btnNOC3.setText("3");
                btnNext.setText("Next");
                btnNOC4.setBackground(getActivity().getResources().getDrawable(R.drawable.noc_selector));
                btnNOC4.setSelected(false);
                btnNOC4.setTextColor(getActivity().getResources().getColor(R.color.white));
                btnNOC4.setGravity(Gravity.CENTER);
                btnNOC4.setText("4");

                status = 3;

            } else if (status == 5) {
                frameLayout.removeAllViewsInLayout();
                fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.content, getFourthFragment())
                        .commit();
//                showInactiveWizard(btnNOC4, line5);

                btnNOC4.setBackground(getActivity().getResources().getDrawable(R.drawable.noc_selector));
                btnNOC4.setSelected(true);
                btnNOC4.setTextColor(getActivity().getResources().getColor(R.color.white));
                btnNOC4.setGravity(Gravity.CENTER);
                btnNOC4.setText("4");
                btnNext.setText("Pay & Submit");
                btnCancel.setVisibility(View.VISIBLE);
                btnNOC5.setBackground(getActivity().getResources().getDrawable(R.drawable.noc_selector));
                btnNOC5.setSelected(false);
                btnNOC5.setTextColor(getActivity().getResources().getColor(R.color.white));
                btnNOC5.setGravity(Gravity.CENTER);
                btnNOC5.setText("5");

                status = 4;
            }
        } else if (v == btnNext) {
            if (status == 1) {
                frameLayout.removeAllViews();
                fragmentManager = getChildFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.content, getSecondFragment())
                        .commitAllowingStateLoss();
                btnNOC1.setBackgroundResource(R.drawable.bullet_success);
                btnNOC1.setText("");
                btnNOC2.setSelected(true);
                status = 2;
            } else if (status == 2) {
                frameLayout.removeAllViews();
                fragmentManager = getChildFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.content, getThirdFragment())
                        .commitAllowingStateLoss();
                btnNOC2.setBackgroundResource(R.drawable.bullet_success);
                btnNOC2.setText("");
                btnNOC3.setSelected(true);
                status = 3;
            } else if (status == 3) {
                if (frameLayout != null) {
                    frameLayout.removeAllViews();
                }
                FragmentTransaction fragmentTransaction;
                fragmentManager = getChildFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction
                        .replace(R.id.content, getFourthFragment())
                        .commitAllowingStateLoss();
                btnNOC3.setBackgroundResource(R.drawable.bullet_success);
                btnNext.setText("Pay & Submit");
                btnNOC3.setText("");
                btnNOC4.setSelected(true);
                status = 4;
            } else if (status == 4) {

            }else{

                getActivity().finish();
            }
        } else if (v == btnCancel) {
            Utilities.showCustomNiftyDialog("Cancel NOC Process", getActivity(), listenerOk1, "Are you sure want to cancel the NOC process ?");
        }
    }

    private boolean ValidateInput() {
        if (getRelatedService() == RelatedServiceType.RELATED_SERVICE_EMPLOYEE_NOC) {
            if (new StoreData(getActivity().getApplicationContext()).getNocType().equals("") || new StoreData(getActivity().getApplicationContext()).getNOCAuthorityType().equals("")) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    private void showInactiveWizard(Button btnNOC, View line) {
        btnNOC.setBackground(getActivity().getResources().getDrawable(R.drawable.noc_selector));
        btnNOC.setSelected(false);
        btnNOC.setTextColor(getActivity().getResources().getColor(R.color.white));
        btnNOC.setGravity(Gravity.CENTER);
        if (btnNOC == btnNOC1) {
            btnNOC.setText("1");
        } else if (btnNOC == btnNOC2) {
            btnNOC.setText("2");
        } else if (btnNOC == btnNOC3) {
            btnNOC.setText("3");
        } else if (btnNOC == btnNOC4) {
            btnNOC.setText("4");
        }

        line.setBackgroundColor(getActivity().getResources().getColor(R.color.light_grey));
    }

    private View.OnClickListener listenerOk1 = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            status = 1;
            new StoreData(getActivity().getApplicationContext()).saveNocType("");
            new StoreData(getActivity().getApplicationContext()).saveNOCAuthorityType("");
            new StoreData(getActivity().getApplicationContext()).saveNOCLanguage("");
            new StoreData(getActivity().getApplicationContext()).setIsLoadedInitialEmployeeNOCPage(false);



            getActivity().finish();
        }
    };

    protected enum RelatedServiceType {
        RELATED_SERVICE_EMPLOYEE_NOC,
        RELATED_SERVICE_COMPANY_NOC,
    }

    public abstract Fragment getInitialFragment();

    public abstract Fragment getSecondFragment();

    public abstract Fragment getThirdFragment();

    public abstract Fragment getFourthFragment();

    public abstract Fragment getFifthFragment(String msg,String fee,String mail);

    public abstract RelatedServiceType getRelatedService();
    public static void AddNextFragment(String Type) {
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        FragmentTransaction fragmentTransaction;
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction
                .replace(R.id.content, NocPayAndSubmit.newInstance(Type))
                .commitAllowingStateLoss();
        btnNOC3.setBackgroundResource(R.drawable.bullet_success);
        btnNOC3.setText("");
        btnNext.setText("Pay & Submit");
        btnNOC4.setSelected(true);
        status = 4;
    }
    public void getfifthfragment(String RXEmail, String caseNumber){
        frameLayout.removeAllViews();
        fragmentManager = getActivity().getSupportFragmentManager();
        String ServiceThankYouMessage= String.format(getActivity().getString(R.string.ServiceThankYouMessage), caseNumber);
        String ServiceThankYouMessageCards=String.format(getActivity().getString(R.string.ServiceThankYouMessageCards),(Utilities.geteServiceAdministration().getTotal_Amount__c()));
        String ServiceThankYouMessageNOCNote=String.format(getActivity().getString(R.string.ServiceThankYouMessageNOCNote),RXEmail);
        fragmentManager.beginTransaction()
                .replace(R.id.content, getFifthFragment(ServiceThankYouMessage,ServiceThankYouMessageCards,ServiceThankYouMessageNOCNote))
                .commit();
        btnNext.setText("Close");
        btnCancel.setVisibility(View.GONE);
        btnNOC4.setBackgroundResource(R.drawable.bullet_success);
        btnNOC4.setText("");
        btnNOC5.setSelected(true);
        status = 5;
    }
}
