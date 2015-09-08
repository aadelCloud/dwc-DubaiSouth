package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import RestAPI.RelatedServiceType;
import cloudconcept.dwc.R;
import dataStorage.StoreData;
import fragmentActivity.BaseFragmentActivity;
import fragmentActivity.ChangeAndRemovalActivity;
import utilities.Utilities;

/**
 * Created by Abanoub Wagdy on 9/2/2015.
 */
public abstract class BaseFragmentFourSteps extends Fragment implements View.OnClickListener {


    FragmentManager fragmentManager;
    public Button btnNext;
    public Button btnCancel;
    public Button btnBackTransparent;
    public ImageView btnBack;
    public Button btnNOC1;
    public Button btnNOC2;
    public Button btnNOC3;
    public Button btnNOC4;
    View line1, line2, line3, line4, line5, line6;
    private Button btnClose;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int status = 1;
    FrameLayout frameLayout;
    TextView tvTitle;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.base_service_four_steps2, container, false);
        InitializeViews(view);
        fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.content, getInitialFragment())
                .commit();
//        activity = (BaseFragmentActivity) getActivity();
        return view;
    }


    private void InitializeViews(View view) {

        btnNext = (Button) view.findViewById(R.id.btnNext);
        btnCancel = (Button) view.findViewById(R.id.btnCancel);
        btnBackTransparent = (Button) view.findViewById(R.id.btnBackTransparent);
        btnBack = (ImageView) view.findViewById(R.id.btnBack);
        tvTitle = (TextView) view.findViewById(R.id.tvTitle);
        btnNext.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
        btnBackTransparent.setOnClickListener(this);
        btnBack.setOnClickListener(this);

        btnNOC1 = (Button) view.findViewById(R.id.btnNOC1);
        btnNOC2 = (Button) view.findViewById(R.id.btnNOC2);
        btnNOC3 = (Button) view.findViewById(R.id.btnNOC3);
        btnNOC4 = (Button) view.findViewById(R.id.btnNOC4);

        btnNOC1.setSelected(true);
        btnNOC1.setEnabled(true);

        line1 = view.findViewById(R.id.line1);
        line2 = view.findViewById(R.id.line2);
        line3 = view.findViewById(R.id.line3);
        line4 = view.findViewById(R.id.line4);
        line5 = view.findViewById(R.id.line5);
        line6 = view.findViewById(R.id.line6);

        btnClose = (Button) view.findViewById(R.id.btnClose);

        frameLayout = (FrameLayout) view.findViewById(R.id.content);
    }

    @Override
    public void onClick(View v) {
        if (v == btnBack || v == btnBackTransparent) {
            if (status == 1) {
                Utilities.showCustomNiftyDialog("Cancel Process", getActivity(), listenerOk1, "Are you sure want to cancel the process ?");
            } else if (status == 2) {
                frameLayout.removeAllViewsInLayout();
                fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.content, getInitialFragment())
                        .commit();

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
                if (getRelatedService() == RelatedServiceType.RelatedServiceTypeCompanyAddressChange) {
                    frameLayout.removeAllViewsInLayout();
                    fragmentManager = getActivity().getSupportFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.content, getInitialFragment())
                            .commit();
                    btnNOC1.setBackground(getActivity().getResources().getDrawable(R.drawable.noc_selector));
                    btnNOC1.setSelected(true);
                    btnNOC1.setTextColor(getActivity().getResources().getColor(R.color.white));
                    btnNOC1.setGravity(Gravity.CENTER);
                    btnNOC1.setText("2");

                    btnNOC2.setBackground(getActivity().getResources().getDrawable(R.drawable.noc_selector));
                    btnNOC2.setSelected(false);
                    btnNOC2.setTextColor(getActivity().getResources().getColor(R.color.white));
                    btnNOC2.setGravity(Gravity.CENTER);
                    btnNOC2.setText("2");

                    btnNOC3.setBackground(getActivity().getResources().getDrawable(R.drawable.noc_selector));
                    btnNOC3.setSelected(false);
                    btnNOC3.setTextColor(getActivity().getResources().getColor(R.color.white));
                    btnNOC3.setGravity(Gravity.CENTER);
                    btnNOC3.setText("3");
                    status = 1;
                    btnNext.setText("Next");

                } else {
                    frameLayout.removeAllViewsInLayout();
                    fragmentManager = getActivity().getSupportFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.content, getSecondFragment())
                            .commit();

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
                }
            } else if (status == 4) {

            }

        } else if (v == btnNext) {
            if (status == 1) {
                if (getRelatedService() == RelatedServiceType.RelatedServiceTypeCompanyAddressChange) {
                    frameLayout.removeAllViews();
                    fragmentManager = getChildFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.content, getThirdFragment())
                            .commitAllowingStateLoss();
                    btnNOC1.setBackgroundResource(R.drawable.bullet_success);
                    btnNOC1.setText("");
                    btnNOC2.setBackgroundResource(R.drawable.bullet_success);
                    btnNOC2.setText("");
                    btnNOC3.setSelected(true);
                    btnNext.setText("Submit");
                    status = 3;

                } else {
                    frameLayout.removeAllViews();
                    fragmentManager = getChildFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.content, getSecondFragment())
                            .commitAllowingStateLoss();
                    btnNOC1.setBackgroundResource(R.drawable.bullet_success);
                    btnNOC1.setText("");
                    btnNOC2.setSelected(true);
                    status = 2;
                }
            } else if (status == 2) {
                frameLayout.removeAllViews();
                fragmentManager = getChildFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.content, getThirdFragment())
                        .commitAllowingStateLoss();
                btnNOC1.setBackgroundResource(R.drawable.bullet_success);
                btnNOC1.setText("");
                btnNext.setText("Pay/Submit");
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
                btnNOC3.setText("");
                btnNOC4.setSelected(true);
                btnBack.setVisibility(View.GONE);
                btnBackTransparent.setVisibility(View.GONE);
                btnClose.setVisibility(View.VISIBLE);
                btnNext.setVisibility(View.GONE);
                btnCancel.setVisibility(View.GONE);
                btnClose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getActivity().finish();
                    }
                });
                status = 4;
            }

        } else if (v == btnCancel) {
            Utilities.showCustomNiftyDialog("Cancel Process", getActivity(), listenerOk1, "Are you sure want to cancel the process ?");
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
//            status = 1;
//            new StoreData(getActivity().getApplicationContext()).saveNocType("");
//            new StoreData(getActivity().getApplicationContext()).saveNOCAuthorityType("");
//            new StoreData(getActivity().getApplicationContext()).saveNOCLanguage("");
//            new StoreData(getActivity().getApplicationContext()).setIsLoadedInitialEmployeeNOCPage(false);
            getActivity().finish();
        }
    };

    public abstract Fragment getInitialFragment();

    public abstract Fragment getSecondFragment();

    public abstract Fragment getThirdFragment();

    public abstract Fragment getFourthFragment();

    public abstract RelatedServiceType getRelatedService();


    public void gotoPayAndSubmitFragment(Fragment payAndSubmitFragmnet) {
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        FragmentTransaction fragmentTransaction;
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction
                .replace(R.id.content, payAndSubmitFragmnet)
                .commitAllowingStateLoss();
        btnNOC3.setBackgroundResource(R.drawable.bullet_success);
        btnNOC3.setText("");
        btnNext.setText("Pay & Submit");
        btnNOC4.setSelected(true);
        status = 4;
    }
}
