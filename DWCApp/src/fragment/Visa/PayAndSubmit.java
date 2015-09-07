package fragment.Visa;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import cloudconcept.dwc.R;
import fragmentActivity.CardActivity;
import fragmentActivity.VisaActivity;
import model.Card_Management__c;
import model.FormField;

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
        if(activity.getType().equals("1"))
            image.setImageResource(R.drawable.renew_visa);
        else if(activity.getType().equals("2"))
            image.setImageResource(R.drawable.cancel_visa);



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

        tvLabel.setText( "Name"+ "\t:");
        tvValue.setText(activity.getVisa().getApplicant_Full_Name__c());
        nocDetails.addView(view);
         view = inflater.inflate(R.layout.wizards_form_field_details, null, false);
        tvLabel = (TextView) view.findViewById(R.id.pay_title);
        tvValue = (TextView) view.findViewById(R.id.pay_text);
        tvLabel.setText( "Arabic Name"+ "\t:");
        tvValue.setText(activity.getVisa().getApplicant_Full_Name_Arabic__c());
        nocDetails.addView(view);
        view = inflater.inflate(R.layout.wizards_form_field_details, null, false);
        tvLabel = (TextView) view.findViewById(R.id.pay_title);
        tvValue = (TextView) view.findViewById(R.id.pay_text);
        tvLabel.setText( "Gender"+ "\t:");
        tvValue.setText(activity.getVisa().getApplicant_Gender__c());
        nocDetails.addView(view);
        view = inflater.inflate(R.layout.wizards_form_field_details, null, false);
        tvLabel = (TextView) view.findViewById(R.id.pay_title);
        tvValue = (TextView) view.findViewById(R.id.pay_text);
        tvLabel.setText( "Date of birth"+ "\t:");
        tvValue.setText(activity.getVisa().getDate_of_Birth__c());
        nocDetails.addView(view);
        view = inflater.inflate(R.layout.wizards_form_field_details, null, false);
        tvLabel = (TextView) view.findViewById(R.id.pay_title);
        tvValue = (TextView) view.findViewById(R.id.pay_text);
        tvLabel.setText("Birth Country" + "\t:");
        tvValue.setText(activity.getVisa().getCountry_of_Birth__r().getName());
        nocDetails.addView(view);
        view = inflater.inflate(R.layout.wizards_form_field_details, null, false);
        tvLabel = (TextView) view.findViewById(R.id.pay_title);
        tvValue = (TextView) view.findViewById(R.id.pay_text);
        tvLabel.setText("Place Country" + "\t:");
        tvValue.setText(activity.getVisa().getPlace_of_Birth__c());
        nocDetails.addView(view);
        view = inflater.inflate(R.layout.wizards_form_field_details, null, false);
        tvLabel = (TextView) view.findViewById(R.id.pay_title);
        tvValue = (TextView) view.findViewById(R.id.pay_text);
        view = inflater.inflate(R.layout.wizards_form_field_details, null, false);
        tvLabel = (TextView) view.findViewById(R.id.pay_title);
        tvValue = (TextView) view.findViewById(R.id.pay_text);
        tvLabel.setText("Email" + "\t:");
        tvValue.setText(activity.getVisa().getApplicant_Email__c());
        nocDetails.addView(view);
        view = inflater.inflate(R.layout.wizards_form_field_details, null, false);
        tvLabel = (TextView) view.findViewById(R.id.pay_title);
        tvValue = (TextView) view.findViewById(R.id.pay_text);
        tvLabel.setText("mobile" + "\t:");
        tvValue.setText(activity.getVisa().getApplicant_Mobile_Number__c());
        nocDetails.addView(view);
        view = inflater.inflate(R.layout.wizards_form_field_details, null, false);
        tvLabel = (TextView) view.findViewById(R.id.pay_title);
        tvValue = (TextView) view.findViewById(R.id.pay_text);
        tvLabel.setText("Marital status" + "\t:");
        tvValue.setText(activity.getVisa().getMarital_Status__c());
        nocDetails.addView(view);
        view = inflater.inflate(R.layout.wizards_form_field_details, null, false);
        tvLabel = (TextView) view.findViewById(R.id.pay_title);
        tvValue = (TextView) view.findViewById(R.id.pay_text);
        tvLabel.setText( "mother's name"+ "\t:");
        tvValue.setText(activity.getVisa().getMother_Name__c());
        nocDetails.addView(view);
        view = inflater.inflate(R.layout.wizards_form_field_details, null, false);
        tvLabel = (TextView) view.findViewById(R.id.pay_title);
        tvValue = (TextView) view.findViewById(R.id.pay_text);
        tvLabel.setText( "current nationality"+ "\t:");
        tvValue.setText(activity.getVisa().getCurrent_Nationality__r().getName());
        nocDetails.addView(view);
        view = inflater.inflate(R.layout.wizards_form_field_details, null, false);
        tvLabel = (TextView) view.findViewById(R.id.pay_title);
        tvValue = (TextView) view.findViewById(R.id.pay_text);
        tvLabel.setText( "Previous nationality"+ "\t:");
        tvValue.setText(activity.getVisa().getPrevious_Nationality__r().getName());
        nocDetails.addView(view);
        view = inflater.inflate(R.layout.wizards_form_field_details, null, false);
        tvLabel = (TextView) view.findViewById(R.id.pay_title);
        tvValue = (TextView) view.findViewById(R.id.pay_text);
        tvLabel.setText( "religion"+ "\t:");
        tvValue.setText(activity.getVisa().getReligion__c());
        nocDetails.addView(view);
        view = inflater.inflate(R.layout.wizards_form_field_details, null, false);
        tvLabel = (TextView) view.findViewById(R.id.pay_title);
        tvValue = (TextView) view.findViewById(R.id.pay_text);
        tvLabel.setText( "languages spoken"+ "\t:");
        tvValue.setText(activity.getVisa().getLanguages__c());
        nocDetails.addView(view);
        view = inflater.inflate(R.layout.wizards_form_field_details, null, false);
        tvLabel = (TextView) view.findViewById(R.id.pay_title);
        tvValue = (TextView) view.findViewById(R.id.pay_text);
        tvLabel.setText( "passport no"+ "\t:");
        tvValue.setText(activity.getVisa().getPassport_Number__c());
        nocDetails.addView(view);
        view = inflater.inflate(R.layout.wizards_form_field_details, null, false);
        tvLabel = (TextView) view.findViewById(R.id.pay_title);
        tvValue = (TextView) view.findViewById(R.id.pay_text);
        tvLabel.setText( "date of expiry"+ "\t:");
        tvValue.setText(activity.getVisa().getPassport_Expiry__c());
        nocDetails.addView(view);
        view = inflater.inflate(R.layout.wizards_form_field_details, null, false);
        tvLabel = (TextView) view.findViewById(R.id.pay_title);
        tvValue = (TextView) view.findViewById(R.id.pay_text);
        tvLabel.setText( "country of issue"+ "\t:");
        tvValue.setText(activity.getVisa().getPassport_Issue_Country__r().getName());
        nocDetails.addView(view);
        view = inflater.inflate(R.layout.wizards_form_field_details, null, false);
        tvLabel = (TextView) view.findViewById(R.id.pay_title);
        tvValue = (TextView) view.findViewById(R.id.pay_text);
        tvLabel.setText( "place of issue"+ "\t:");
        tvValue.setText(activity.getVisa().getPassport_Place_of_Issue__c());
        nocDetails.addView(view);
        view = inflater.inflate(R.layout.wizards_form_field_details, null, false);
        tvLabel = (TextView) view.findViewById(R.id.pay_title);
        tvValue = (TextView) view.findViewById(R.id.pay_text);
        tvLabel.setText( "Monthly Salary"+ "\t:");
        tvValue.setText(activity.getVisa().getMonthly_Basic_Salary_in_AED__c()+"AED");
        nocDetails.addView(view);
        view = inflater.inflate(R.layout.wizards_form_field_details, null, false);
        tvLabel = (TextView) view.findViewById(R.id.pay_title);
        tvValue = (TextView) view.findViewById(R.id.pay_text);
        tvLabel.setText( "Monthly Allowance"+ "\t:");
        tvValue.setText(activity.getVisa().getMonthly_Allowances_in_AED__c()+"AED");
        nocDetails.addView(view);
        view = inflater.inflate(R.layout.wizards_form_field_details, null, false);
        tvLabel = (TextView) view.findViewById(R.id.pay_title);
        tvValue = (TextView) view.findViewById(R.id.pay_text);
        tvLabel.setText( "Occupation"+ "\t:");
        tvValue.setText(activity.getVisa().getJob_Title_at_Immigration__r().getName());
        nocDetails.addView(view);
        view = inflater.inflate(R.layout.wizards_form_field_details, null, false);
        tvLabel = (TextView) view.findViewById(R.id.pay_title);
        tvValue = (TextView) view.findViewById(R.id.pay_text);
        tvLabel.setText( "Qualification"+ "\t:");
        tvValue.setText(activity.getVisa().getQualification__r().getName());
        nocDetails.addView(view);
        view = inflater.inflate(R.layout.wizard_form_field_pay_header, null, false);
         tvHeader = (TextView) view.findViewById(R.id.pay_header);
        tvHeader.setText("Additions");
        nocDetails.addView(view);
        view = inflater.inflate(R.layout.wizards_form_field_details, null, false);
        tvLabel = (TextView) view.findViewById(R.id.pay_title);
        tvValue = (TextView) view.findViewById(R.id.pay_text);
        tvLabel.setText( "Urgent Stamping (AED 250)"+ "\t:");
        tvValue.setText(activity.getVisa().Urgent_Stamping_Paid__c?"Yes":"No");
        nocDetails.addView(view);


















    }

}