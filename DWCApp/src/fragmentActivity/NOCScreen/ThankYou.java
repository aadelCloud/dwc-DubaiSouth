package fragmentActivity.NOCScreen;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cloudconcept.dwc.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link ThankYou#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ThankYou extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "msg";
    private static final String ARG_PARAM2 = "fee";
    private static final String ARG_PARAM3 = "mail";

    // TODO: Rename and change types of parameters
    private String msg;
    private String fee;
    private String mail;



    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param msg Parameter 1.
     * @param fee Parameter 2.
     * @param mail Parameter 3.
     * @return A new instance of fragment ThankYou.
     */
    // TODO: Rename and change types and number of parameters
    public static ThankYou newInstance(String msg, String fee,String mail) {
        ThankYou fragment = new ThankYou();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, msg);
        args.putString(ARG_PARAM2, fee);
        args.putString(ARG_PARAM3, mail);
        fragment.setArguments(args);
        return fragment;
    }

    public ThankYou() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            msg = getArguments().getString(ARG_PARAM1);
            fee = getArguments().getString(ARG_PARAM2);
            mail=getArguments().getString(ARG_PARAM3);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_thank_you, container, false);
        TextView txtmsg= (TextView) v.findViewById(R.id.txtmsg);
        TextView txtfee= (TextView) v.findViewById(R.id.txtfee);
        TextView txtmail= (TextView) v.findViewById(R.id.txtmail);
        txtmsg.setText(msg);
        txtfee.setText(fee);
        txtmail.setText(mail);

        return v;
    }




}
