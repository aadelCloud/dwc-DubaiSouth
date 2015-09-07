package fragment.nameReservation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cloudconcept.dwc.R;
import fragmentActivity.NameReservationActivity;

/**
 * Created by Abanoub Wagdy on 8/31/2015.
 */
public class NameReservationPayAndSubmit extends Fragment {
    private static final String ARG_TEXT = "Second";
    TextView tvChoice1, tvChoice2, tvChoice3, tvServiceFees, tvKnowledgeServiceFees, tvTotal;
    NameReservationActivity activity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.name_reservation_pay_and_submit, container, false);
        InitializeViews(view);
        return view;
    }

    private void InitializeViews(View view) {
        tvChoice1 = (TextView) view.findViewById(R.id.tvChoice1);
        tvChoice2 = (TextView) view.findViewById(R.id.tvChoice2);
        tvChoice3 = (TextView) view.findViewById(R.id.tvChoice3);
        tvServiceFees = (TextView) view.findViewById(R.id.tvServiceFees);
        tvKnowledgeServiceFees = (TextView) view.findViewById(R.id.tvKnowledgeServiceFees);
        tvTotal = (TextView) view.findViewById(R.id.tvTotal);
        activity = (NameReservationActivity) getActivity();
        tvChoice1.setText(activity.getChoice1Text());
        tvChoice2.setText(activity.getChoice2Text());
        tvChoice3.setText(activity.getChoice3Text());
        tvServiceFees.setText("AED 500.00");
        tvKnowledgeServiceFees.setText("AED 10.00");
        tvTotal.setText("AED 510.00");
    }

    public static NameReservationPayAndSubmit newInstance(String text) {

        NameReservationPayAndSubmit fragment = new NameReservationPayAndSubmit();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_TEXT, text);
        fragment.setArguments(bundle);
        return fragment;
    }
}
