package fragment.Cards;

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
import model.Card_Management__c;
import model.FormField;

/**
 * Created by M_Ghareeb on 8/26/2015.
 */
public class PayAndSubmit extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    LinearLayout nocDetails;


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

    CardActivity activity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        activity = ((CardActivity) getActivity());
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

            person.setText(activity.getCard().getFull_Name__c());

        TextView ref = (TextView) view.findViewById(R.id.refnumber);

            ref.setText(activity.getCaseNumber());
        if(activity.getType().equals("1"))
            image.setImageResource(R.drawable.new_card);
        else if(activity.getType().equals("2"))
            image.setImageResource(R.drawable.cancel_card);
            else if(activity.getType().equals("3"))
            image.setImageResource(R.drawable.renew_card);
            else if(activity.getType().equals("4"))
            image.setImageResource(R.drawable.replace_card);


        DrawLayout(inflater);
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {

    }

    public void DrawLayout(LayoutInflater inflater) {
        List<FormField> formFields = null;
        formFields = ((CardActivity) getActivity()).get_webForm().get_formFields();
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
                Field[] fields = Card_Management__c.class.getFields();
                for (int j = 0; j < fields.length; j++)
                    if (name.toLowerCase().equals(fields[j].getName().toLowerCase()))
                        try {
                            stringValue = String.valueOf(fields[j].get(activity.getCard()));
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                tvValue.setText(stringValue);
                nocDetails.addView(view);
            }
        }
    }
}