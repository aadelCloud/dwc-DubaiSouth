package fragment.nameReservation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import cloudconcept.dwc.R;
import fragmentActivity.NameReservationActivity;

/**
 * Created by Abanoub Wagdy on 8/31/2015.
 */
public class NameReservationInitialPage extends Fragment {

    private static final String ARG_TEXT = "Initial";
    EditText etChoice1, etChoice2, etChoice3;
    NameReservationActivity activity;
    static TextView tvErrorMessage;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.name_reservation_initial_page, container, false);
        InitializeViews(view);
        return view;
    }

    private void InitializeViews(View view) {
        tvErrorMessage = (TextView) view.findViewById(R.id.tvErrorMessage);
        etChoice1 = (EditText) view.findViewById(R.id.etChoice1);
        etChoice2 = (EditText) view.findViewById(R.id.etChoice2);
        etChoice3 = (EditText) view.findViewById(R.id.etChoice3);
        activity = (NameReservationActivity) getActivity();
        etChoice1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                activity.setChoice1Text(s.toString());
            }
        });

        etChoice2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                activity.setChoice2Text(s.toString());
            }
        });

        etChoice3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                activity.setChoice3Text(s.toString());
            }
        });
    }

    public static NameReservationInitialPage newInstance(String text) {

        NameReservationInitialPage fragment = new NameReservationInitialPage();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_TEXT, text);
        fragment.setArguments(bundle);
        return fragment;
    }

    public static void setErrorMessage(String result) {
        if (result.contains(",")) {
            String[] texts = result.split(",");
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < texts.length; i++) {
                builder.append(texts[i] + "\n");
            }
            tvErrorMessage.setText(builder.toString());
        }else{
            tvErrorMessage.setText(result);
        }
    }
}
