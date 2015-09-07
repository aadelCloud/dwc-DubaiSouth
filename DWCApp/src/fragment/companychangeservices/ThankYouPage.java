package fragment.companychangeservices;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cloudconcept.dwc.R;
import fragmentActivity.ChangeAndRemovalActivity;

/**
 * Created by Abanoub Wagdy on 9/2/2015.
 */
public class ThankYouPage extends Fragment {

    private static final String ARG_TEXT = "Thank You";
    TextView tvThankyou;
    ChangeAndRemovalActivity activity;

    public static ThankYouPage newInstance(String text) {
        ThankYouPage fragment = new ThankYouPage();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_TEXT, text);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.thank_you_name_reservation, container, false);
        activity = (ChangeAndRemovalActivity) getActivity();
        InitializeViews(view);
        return view;
    }

    private void InitializeViews(View view) {
        tvThankyou = (TextView) view.findViewById(R.id.tvThankyou);
        String str = "We Can Confirm that we have received your submission and your Ref No #" + activity.getCaseObject().getCaseNumber();
        if (activity.getCaseObject().getInvoice__c() != null && !activity.getCaseObject().getInvoice__c().equals("")) {
            str += "\n\nYour Account will be debited AED " + activity.getCaseObject().getInvoice__c() + " (including AED 10 knowledge fee) and you will be notified when your payment is complete";
        }
        tvThankyou.setText(str);
    }
}
