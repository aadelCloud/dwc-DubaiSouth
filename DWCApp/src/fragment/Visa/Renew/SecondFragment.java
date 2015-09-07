package fragment.Visa.Renew;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;

import com.gc.materialdesign.views.Switch;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.rest.ClientManager;
import com.salesforce.androidsdk.rest.RestClient;
import com.salesforce.androidsdk.rest.RestRequest;
import com.salesforce.androidsdk.rest.RestResponse;

import org.json.JSONException;

import java.io.UnsupportedEncodingException;

import RestAPI.SFResponseManager;
import adapter.JobAdapters;
import cloudconcept.dwc.R;
import fragmentActivity.VisaActivity;
import utilities.Utilities;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link SecondFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SecondFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    EditText MonthlySalary, MonthlyAllowance;
    Spinner Occupation, Qualification;
    Switch UrgentStamping;

    private String mParam1;
    private String mParam2;
    private VisaActivity activity;
    private RestRequest restRequest;



    public static SecondFragment newInstance(String param1, String param2) {
        SecondFragment fragment = new SecondFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public SecondFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        activity = (VisaActivity) getActivity();
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        MonthlySalary = (EditText) view.findViewById(R.id.MonthlySalary);
        MonthlyAllowance = (EditText) view.findViewById(R.id.MonthlyAllowance);
        Occupation = (Spinner) view.findViewById(R.id.Occupation);
        Qualification = (Spinner) view.findViewById(R.id.Qualification);
        UrgentStamping = (Switch) view.findViewById(R.id.UrgentStamping);
        MonthlySalary.setText(activity.getVisa().getMonthly_Basic_Salary_in_AED__c() + "");
        MonthlySalary.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                activity.getVisa().setMonthly_Basic_Salary_in_AED__c(Double.parseDouble(editable.toString()));
            }
        });
        MonthlyAllowance.setText(activity.getVisa().getMonthly_Allowances_in_AED__c() + "");
        MonthlyAllowance.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                activity.getVisa().setMonthly_Allowances_in_AED__c(Double.parseDouble(editable.toString()));
            }
        });
        UrgentStamping.setOncheckListener(new Switch.OnCheckListener() {
            @Override
            public void onCheck(Switch aSwitch, boolean b) {
                activity.getVisa().Urgent_Stamping_Paid__c = b;
            }
        });
        getTitles();
        return view;
    }

    private void getTitles() {
        final String referenceSoql = "select Id,Name from Occupation__c";
        try {
            restRequest = RestRequest.getRequestForQuery(getString(R.string.api_version), referenceSoql);
            Utilities.showloadingDialog(activity);
            new ClientManager(getActivity(), SalesforceSDKManager.getInstance().getAccountType(), SalesforceSDKManager.getInstance().getLoginOptions(), SalesforceSDKManager.getInstance().shouldLogoutWhenTokenRevoked()).getRestClient(getActivity(), new ClientManager.RestClientCallback() {
                @Override
                public void authenticatedRestClient(final RestClient client) {
                    if (client == null) {
                        System.exit(0);
                    } else {
                        client.sendAsync(restRequest, new RestClient.AsyncRequestCallback() {

                            @Override
                            public void onSuccess(RestRequest request, RestResponse response) {
                                try {
                                    activity.setOccupations(SFResponseManager.parseJobImmagrationObject(response.toString()));
                                    Occupation.setAdapter(new JobAdapters(activity, android.R.layout.simple_list_item_1, 0, activity.getOccupations()));
                                    Occupation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                        @Override
                                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                            activity.getVisa().setJob_Title_at_Immigration__r(activity.getOccupations().get(i));

                                        }

                                        @Override
                                        public void onNothingSelected(AdapterView<?> adapterView) {

                                        }
                                    });

                                    String referenceSoql1 = "select Id,Name from Qualification__c";
                                    restRequest = RestRequest.getRequestForQuery(getString(R.string.api_version), referenceSoql1);
                                    client.sendAsync(restRequest, new RestClient.AsyncRequestCallback() {

                                        @Override
                                        public void onSuccess(RestRequest request, RestResponse response) {
                                            try {
                                                Utilities.dismissLoadingDialog();
                                                activity.setQualifications(SFResponseManager.parseJobImmagrationObject(response.toString()));
                                                Qualification.setAdapter(new JobAdapters(activity, android.R.layout.simple_list_item_1, 0, activity.getQualifications()));
                                                Qualification.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                                    @Override
                                                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                                        activity.getVisa().setQualification__r(activity.getQualifications().get(i));
                                                        activity.getVisa().setQualification__c(activity.getQualifications().get(i).getID());


                                                    }

                                                    @Override
                                                    public void onNothingSelected(AdapterView<?> adapterView) {

                                                    }
                                                });
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            }

                                        }

                                        @Override
                                        public void onError(Exception exception) {
                                            Utilities.dismissLoadingDialog();
                                        }
                                    });

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                } catch (UnsupportedEncodingException e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void onError(Exception exception) {
                                Utilities.dismissLoadingDialog();
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
