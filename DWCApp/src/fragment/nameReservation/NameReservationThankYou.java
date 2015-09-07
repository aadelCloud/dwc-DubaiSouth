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
public class NameReservationThankYou extends Fragment {

    private static final String ARG_TEXT = "Final";
    TextView tv;
    NameReservationActivity activity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.thank_you_name_reservation, container, false);
        InitializeViews(view);
        return view;
    }

    private void InitializeViews(View view) {
        tv = (TextView) view.findViewById(R.id.tvThankyou);
        activity = (NameReservationActivity) getActivity();
        String ServiceThankYouMessage = String.format(getActivity().getString(R.string.ServiceThankYouMessage), activity.getCaseNumber());
        String ServiceThankYouMessageCards = String.format(getActivity().getString(R.string.ServiceThankYouReservation), "AED 510.00");
        tv.setText(ServiceThankYouMessage+"\n"+ServiceThankYouMessageCards);
    }

    public static NameReservationThankYou newInstance(String text) {

        NameReservationThankYou fragment = new NameReservationThankYou();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_TEXT, text);
        fragment.setArguments(bundle);
        return fragment;
    }
}
