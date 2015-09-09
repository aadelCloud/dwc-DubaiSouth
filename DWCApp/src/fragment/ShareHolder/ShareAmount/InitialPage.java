package fragment.ShareHolder.ShareAmount;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

import adapter.NameIdAdapter;
import cloudconcept.dwc.R;
import fragmentActivity.ShareHolderActivity;
import model.ShareOwnership;
import utilities.Utilities;

/**
 * Created by M_Ghareeb on 9/8/2015.
 */
public class InitialPage extends Fragment {
    private ShareHolderActivity activity;
    EditText transferFrom, noOfShares, NoofTransferredShares;
    Spinner transferTo;

    public static Fragment newInstance(String RenewVisa) {
        InitialPage fragment = new InitialPage();
        Bundle bundle = new Bundle();
        bundle.putString("text", RenewVisa);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_share_holder_initial, container, false);
        activity = (ShareHolderActivity) getActivity();

        InitializeViews(view);
        return view;
    }

    private void InitializeViews(View view) {
        transferFrom = (EditText) view.findViewById(R.id.transferFrom);
        noOfShares = (EditText) view.findViewById(R.id.noOfShares);
        NoofTransferredShares = (EditText) view.findViewById(R.id.NoofTransferredShares);
        NoofTransferredShares.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                int value=Integer.parseInt(TextUtils.isEmpty(editable.toString()) ? "0" : editable.toString());
                if(value>Integer.parseInt(activity.getShareHolder().getNo_of_Shares__c())){
                    activity.setShareno(Integer.parseInt(activity.getShareHolder().getNo_of_Shares__c()));
                    NoofTransferredShares.setText(activity.getShareHolder().getNo_of_Shares__c());
                }else{
                    activity.setShareno(value);
                }
            }
        });

        transferTo = (Spinner) view.findViewById(R.id.transferTo);

        transferFrom.setText(activity.getShareHolder().get_shareholder().getName());
        noOfShares.setText(activity.getShareHolder().getNo_of_Shares__c());
        NoofTransferredShares.setText(activity.getShareHolder().getNo_of_Shares__c());
//        ArrayList<ShareOwnership> holders=new ArrayList<ShareOwnership>();
//        for(Object obj:activity.getShareHolders()){
//
//            ShareOwnership temp=(ShareOwnership)obj;
//            if(temp.get_shareholder().getName()!=null)
//                holders.add(temp);
//        }
        transferTo.setAdapter(new NameIdAdapter(activity,android.R.layout.simple_list_item_1,0,activity.getShareHolders()));
        transferTo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(activity.getShareHolder().getID().equals(((ShareOwnership)activity.getShareHolders().get(i)).getID())) {
                    activity.setSelectedShareHolder(null);
                    return;
                }



                activity.setSelectedShareHolder((ShareOwnership)activity.getShareHolders().get(i));

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
