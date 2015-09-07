package fragment.Visa.RenewPassport;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;

import com.android.volley.NetworkResponse;
import com.android.volley.VolleyError;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.rest.ClientManager;
import com.salesforce.androidsdk.rest.RestClient;
import com.salesforce.androidsdk.rest.RestRequest;
import com.salesforce.androidsdk.rest.RestResponse;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.List;

import RestAPI.SFResponseManager;
import RestAPI.SoqlStatements;
import cloudconcept.dwc.R;
import fragmentActivity.VisaActivity;
import model.CurrentPassport;
import model.Visa;
import utilities.Utilities;

/**
 * Created by M_Ghareeb on 9/2/2015.
 */
public class InitialPassportPage extends Fragment {
    private VisaActivity activity;

    EditText passportholder, oldpassportnumber, newpassportno, dateofissue, dateofexpiry, placeofissue, countryofissue;
    private RestRequest restRequest;

    public static Fragment newInstance(String RenewVisa) {
        InitialPassportPage fragment = new InitialPassportPage();
        Bundle bundle = new Bundle();
        bundle.putString("text", RenewVisa);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_initial_renew_passport, container, false);
        activity = (VisaActivity) getActivity();

        InitializeViews(view);
        return view;
    }

    private void InitializeViews(View view) {
        passportholder = (EditText) view.findViewById(R.id.passportholder);

        oldpassportnumber = (EditText) view.findViewById(R.id.oldpassportnumber);

        newpassportno = (EditText) view.findViewById(R.id.newpassportno);

        dateofissue = (EditText) view.findViewById(R.id.dateofissue);

        dateofexpiry = (EditText) view.findViewById(R.id.dateofexpiry);

        placeofissue = (EditText) view.findViewById(R.id.placeofissue);

        countryofissue = (EditText) view.findViewById(R.id.countryofissue);

        Utilities.showloadingDialog(activity);
        new ClientManager(getActivity(), SalesforceSDKManager.getInstance().getAccountType(), SalesforceSDKManager.getInstance().getLoginOptions(), SalesforceSDKManager.getInstance().shouldLogoutWhenTokenRevoked()).getRestClient(getActivity(), new ClientManager.RestClientCallback() {
            @Override
            public void authenticatedRestClient(final RestClient client) {
                if (client == null) {
                    System.exit(0);
                } else {
                    String SoqlVisaQuery = String.format(SoqlStatements.renewVisaSQL, activity.getVisa().getID());
                    try {
                        restRequest = RestRequest.getRequestForQuery(getActivity().getString(R.string.api_version), SoqlVisaQuery);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    client.sendAsync(restRequest, new RestClient.AsyncRequestCallback() {
                        @Override
                        public void onSuccess(RestRequest request, RestResponse response) {
                            List<Visa> visa = SFResponseManager.parseVisaData(response.toString());
                            activity.setVisa(visa.get(0));
                            setUpFields();
                            Utilities.dismissLoadingDialog();
                        }

                        @Override
                        public void onError(Exception exception) {
                            VolleyError volleyError = (VolleyError) exception;
                            NetworkResponse response = volleyError.networkResponse;
                            String json = new String(response.data);
                            Log.d("", json);
                            Utilities.dismissLoadingDialog();
                            getActivity().finish();
                        }
                    });
                }
            }
        });
    }

    private void setUpFields(){
        activity.setNewPassport(activity.getVisa().getPassport__r());
        passportholder.setText(activity.getNewPassport().getPassport_Holder__r().getName());
        oldpassportnumber.setText(activity.getVisa().getPassport_Number__c());
        newpassportno.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                activity.getNewPassport().setName(editable.toString());
            }
        });
        activity.getNewPassport().setPassport_Expiry_Date__c("");
        activity.getNewPassport().setPassport_Issue_Date__c("");
        dateofissue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dialog = new DatePickerDialog(activity, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        String date = year + "-" + (monthOfYear + 1) + "-" + dayOfMonth;
                        dateofissue.setText(date);
                        activity.getNewPassport().setPassport_Issue_Date__c(date);
                    }
                }, 2016, Calendar.MONTH, Calendar.DAY_OF_MONTH);
                dialog.show();
            }
        });
        dateofissue.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    DatePickerDialog dialog = new DatePickerDialog(activity, new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                            String date = year + "-" + (monthOfYear + 1) + "-" + dayOfMonth;
                            dateofissue.setText(date);
                            activity.getNewPassport().setPassport_Issue_Date__c(date);
                        }
                    }, 2016, Calendar.MONTH, Calendar.DAY_OF_MONTH);
                    dialog.show();
                }
            }
        });

        dateofexpiry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dialog = new DatePickerDialog(activity, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        String date = year + "-" + (monthOfYear + 1) + "-" + dayOfMonth;
                        dateofexpiry.setText(date);
                        activity.getNewPassport().setPassport_Expiry_Date__c(date);
                    }
                }, 2016, Calendar.MONTH, Calendar.DAY_OF_MONTH);
                dialog.show();
            }
        });
        dateofexpiry.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    DatePickerDialog dialog = new DatePickerDialog(activity, new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                            String date = year + "-" + (monthOfYear + 1) + "-" + dayOfMonth;
                            dateofexpiry.setText(date);
                            activity.getNewPassport().setPassport_Expiry_Date__c(date);
                        }
                    }, 2016, Calendar.MONTH, Calendar.DAY_OF_MONTH);
                    dialog.show();
                }
            }
        });


        placeofissue.setText(activity.getNewPassport().getPassport_Place_of_Issue__c());
        placeofissue.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                activity.getNewPassport().setPassport_Place_of_Issue__c(editable.toString());
            }
        });

        countryofissue.setText(activity.getVisa().getPassport_Issue_Country__r().getName());
    }
}
