package fragmentActivity.NOCScreen;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import cloudconcept.dwc.R;
import fragmentActivity.CompanyNOC.CompanyNocMainFragment;
import model.FormField;
import model.NOC__c;
import utilities.Utilities;

public class NocPayAndSubmit extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    LinearLayout nocDetails;
    NOC__c noc;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    //    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment NocPayAndSubmit.
//     */
    // TODO: Rename and change types and number of parameters
    public static NocPayAndSubmit newInstance(String Type) {
        NocPayAndSubmit fragment = new NocPayAndSubmit();
        String param1 = Type;
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);

        fragment.setArguments(args);
        return fragment;
    }

    public NocPayAndSubmit() {
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_noc_pay_and_submit, container, false);
        nocDetails = (LinearLayout) view.findViewById(R.id.nocDetails);
        // Inflate the layout for this fragment
        ImageView image= (ImageView) view.findViewById(R.id.imageEmpoyeeNOC);
        TextView labelPerson= (TextView) view.findViewById(R.id.labelPerson);
        TextView date = (TextView) view.findViewById(R.id.date);
        long yourmilliseconds = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
        Date resultdate = new Date(yourmilliseconds);
        date.setText(sdf.format(resultdate));

        TextView total = (TextView) view.findViewById(R.id.total_Amount);
        total.setText((Utilities.geteServiceAdministration().getTotal_Amount__c()) + " AED");
        TextView person = (TextView) view.findViewById(R.id.personName);
        if (mParam1.equals("Emp")) {
            person.setText(NocActivity.get_visa().getApplicant_Full_Name__c());
        } else
            person.setText(CompanyNocMainFragment.user.get_contact().get_account().getName());
        TextView ref = (TextView) view.findViewById(R.id.refnumber);
        if (mParam1.equals("Emp")) {
            ref.setText(NocMainFragment.caseNummberId);
            noc=NocMainFragment._noc;
        } else {
            ref.setText(CompanyNocMainFragment.caseNummberId);
            noc=CompanyNocMainFragment._noc;
            image.setImageResource(R.drawable.company_noc);
            labelPerson.setText("Company Name:");
        }

        DrawLayout(inflater);
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {

    }

    public void DrawLayout(LayoutInflater inflater) {
        List<FormField> formFields=null;
        if(mParam1.equals("Emp"))
            formFields=NocMainFragment._webForm.get_formFields();
        else
            formFields=CompanyNocMainFragment._webForm.get_formFields();

        for (FormField field : formFields) {
            if (field.getType().equals("CUSTOMTEXT")) {

                View view = inflater.inflate(R.layout.wizard_form_field_pay_header, null, false);
                TextView tvHeader = (TextView) view.findViewById(R.id.pay_header);
                tvHeader.setText(field.getMobileLabel());
                nocDetails.addView(view);

            } else {


                TextView tvLabel;
                TextView tvValue;

                View view = inflater.inflate(R.layout.wizards_form_field_details, null, false);


                tvLabel = (TextView) view.findViewById(R.id.pay_title);
                tvValue = (TextView) view.findViewById(R.id.pay_text);
                tvLabel.setText(field.getMobileLabel() + "\t:");

                String stringValue = "";
                String name = field.getName();
                Field[] fields = NOC__c.class.getFields();
                for (int j = 0; j < fields.length; j++)
                    if (name.toLowerCase().equals(fields[j].getName().toLowerCase()))
                        try {
                            stringValue = String.valueOf(fields[j].get(noc));
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                tvValue.setText(stringValue);
                nocDetails.addView(view);
            }
        }
    }


}
