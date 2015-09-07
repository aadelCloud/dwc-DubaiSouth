package fragment.Visa.RenewPassport;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import cloudconcept.dwc.R;
import fragmentActivity.VisaActivity;

/**
 * Created by M_Ghareeb on 8/26/2015.
 */
public class PayAndSubmit extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    LinearLayout nocDetails;

    private String mParam1;
    private String mParam2;


    public static PayAndSubmit newInstance(String Type) {
        PayAndSubmit fragment = new PayAndSubmit();
        String param1 = Type;
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);

        fragment.setArguments(args);
        return fragment;
    }

    public PayAndSubmit() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    VisaActivity activity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        activity = ((VisaActivity) getActivity());
        View view = inflater.inflate(R.layout.fragment_noc_pay_and_submit, container, false);
        nocDetails = (LinearLayout) view.findViewById(R.id.nocDetails);
        // Inflate the layout for this fragment
        ImageView image = (ImageView) view.findViewById(R.id.imageEmpoyeeNOC);
        TextView labelPerson = (TextView) view.findViewById(R.id.labelPerson);
        TextView date = (TextView) view.findViewById(R.id.date);
        long yourmilliseconds = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
        Date resultdate = new Date(yourmilliseconds);
        date.setText(sdf.format(resultdate));

        TextView total = (TextView) view.findViewById(R.id.total_Amount);
        total.setText((activity.geteServiceAdministration().getTotal_Amount__c()) + " AED");
        TextView person = (TextView) view.findViewById(R.id.personName);

        person.setText(activity.getVisa().getApplicant_Full_Name__c());

        TextView ref = (TextView) view.findViewById(R.id.refnumber);

        ref.setText(activity.getCaseNumber());

        image.setImageResource(R.drawable.renew_license);


        DrawLayout(inflater);
        return view;
    }

    public void onButtonPressed(Uri uri) {

    }

    public void DrawLayout(LayoutInflater inflater) {

        View view = inflater.inflate(R.layout.wizard_form_field_pay_header, null, false);
        TextView tvHeader = (TextView) view.findViewById(R.id.pay_header);
        tvHeader.setText("Visa Details");
        nocDetails.addView(view);
        TextView tvLabel;
        TextView tvValue;
        view = inflater.inflate(R.layout.wizards_form_field_details, null, false);
        tvLabel = (TextView) view.findViewById(R.id.pay_title);
        tvValue = (TextView) view.findViewById(R.id.pay_text);

        tvLabel.setText("Passport holder" + "\t:");
        tvValue.setText(activity.getNewPassport().getPassport_Holder__r().getName());
        nocDetails.addView(view);
        view = inflater.inflate(R.layout.wizards_form_field_details, null, false);
        tvLabel = (TextView) view.findViewById(R.id.pay_title);
        tvValue = (TextView) view.findViewById(R.id.pay_text);
        tvLabel.setText("New passport no" + "\t:");
        tvValue.setText(activity.getNewPassport().getName());
        nocDetails.addView(view);
        view = inflater.inflate(R.layout.wizards_form_field_details, null, false);
        tvLabel = (TextView) view.findViewById(R.id.pay_title);
        tvValue = (TextView) view.findViewById(R.id.pay_text);
        tvLabel.setText("New Issue Date" + "\t:");
        tvValue.setText(activity.getNewPassport().getPassport_Issue_Date__c());
        nocDetails.addView(view);
        view = inflater.inflate(R.layout.wizards_form_field_details, null, false);
        tvLabel = (TextView) view.findViewById(R.id.pay_title);
        tvValue = (TextView) view.findViewById(R.id.pay_text);
        tvLabel.setText("New Expiry Date" + "\t:");
        tvValue.setText(activity.getNewPassport().getPassport_Expiry_Date__c());
        nocDetails.addView(view);
        view = inflater.inflate(R.layout.wizards_form_field_details, null, false);
        tvLabel = (TextView) view.findViewById(R.id.pay_title);
        tvValue = (TextView) view.findViewById(R.id.pay_text);
        tvLabel.setText("New Place of issue" + "\t:");
        tvValue.setText(activity.getNewPassport().getPassport_Place_of_Issue__c());
        nocDetails.addView(view);
        view = inflater.inflate(R.layout.wizards_form_field_details, null, false);
        tvLabel = (TextView) view.findViewById(R.id.pay_title);
        tvValue = (TextView) view.findViewById(R.id.pay_text);
        tvLabel.setText("Country of Issue" + "\t:");
        tvValue.setText(activity.getVisa().getPassport_Issue_Country__r().getName());
        nocDetails.addView(view);
    }

}