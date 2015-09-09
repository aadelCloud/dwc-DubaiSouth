package fragment.ShareHolder;

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
import fragmentActivity.ShareHolderActivity;
import fragmentActivity.VisaActivity;

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

    ShareHolderActivity activity;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        activity = ((ShareHolderActivity) getActivity());
        View view = inflater.inflate(R.layout.fragment_cancel_visa_pay_and_submit, container, false);
        nocDetails = (LinearLayout) view.findViewById(R.id.nocDetails);
        // Inflate the layout for this fragment
        ImageView image = (ImageView) view.findViewById(R.id.imageEmpoyeeNOC);


        image.setImageResource(R.drawable.cancel_visa);




        DrawLayout(inflater);
        return view;
    }

    private void DrawLayout(LayoutInflater inflater) {
        View view = inflater.inflate(R.layout.wizard_form_field_pay_header, null, false);
        TextView tvHeader = (TextView) view.findViewById(R.id.pay_header);
        tvHeader.setText("Share Transfer Details");
        nocDetails.addView(view);
        TextView tvLabel;
        TextView tvValue;
        view = inflater.inflate(R.layout.wizards_form_field_details, null, false);
        tvLabel = (TextView) view.findViewById(R.id.pay_title);
        tvValue = (TextView) view.findViewById(R.id.pay_text);

        tvLabel.setText( "Transfer From"+ "\t:");
        tvValue.setText(activity.getShareHolder().get_shareholder().getName());
        nocDetails.addView(view);
        view = inflater.inflate(R.layout.wizards_form_field_details, null, false);
        tvLabel = (TextView) view.findViewById(R.id.pay_title);
        tvValue = (TextView) view.findViewById(R.id.pay_text);
        tvLabel.setText( "Transfer To"+ "\t:");
        tvValue.setText(activity.getSelectedShareHolder().get_shareholder().getName());
        nocDetails.addView(view);
        view = inflater.inflate(R.layout.wizards_form_field_details, null, false);
        tvLabel = (TextView) view.findViewById(R.id.pay_title);
        tvValue = (TextView) view.findViewById(R.id.pay_text);
        tvLabel.setText("No of Transferred Shares" + "\t:");
        tvValue.setText(activity.getShareno()+"");
        nocDetails.addView(view);

        view = inflater.inflate(R.layout.wizards_form_field_details, null, false);
        tvLabel = (TextView) view.findViewById(R.id.pay_title);
        tvValue = (TextView) view.findViewById(R.id.pay_text);
        tvLabel.setText("Total Amount" + "\t:");
        tvValue.setText(activity.geteServiceAdministration().getTotal_Amount__c()+"AED");
        nocDetails.addView(view);



    }
}