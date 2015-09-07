package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.salesforce.androidsdk.rest.RestRequest;

import cloudconcept.dwc.R;

/**
 * Created by Bibo on 7/29/2015.
 */
public class ThankYouFragment extends Fragment {

    static String Message;
    private RestRequest restRequest;
    TextView tvThankYou;
    Button btnClose;

    public static Fragment newInstance(String s, String caseNumber) {
        ThankYouFragment fragment = new ThankYouFragment();
        Bundle bundle = new Bundle();
        bundle.putString("text", s);
        ThankYouFragment.Message = caseNumber;
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.thank_you, container, false);
        tvThankYou = (TextView) view.findViewById(R.id.tvThankyou);
        btnClose = (Button) view.findViewById(R.id.btnClose);
        tvThankYou.setText(Message);
        btnClose.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
        return view;
    }
}
