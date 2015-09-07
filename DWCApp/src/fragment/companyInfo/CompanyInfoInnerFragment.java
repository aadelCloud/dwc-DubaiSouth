package fragment.companyInfo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.gson.Gson;

import java.util.ArrayList;

import cloudconcept.dwc.R;
import dataStorage.StoreData;
import model.DWCView;
import model.ItemType;
import model.User;
import utilities.Utilities;

/**
 * Created by Abanoub on 7/2/2015.
 */
public class CompanyInfoInnerFragment extends Fragment {

    private static final String ARG_TEXT = "CompanyInfoInner";
    static ArrayList<DWCView> _views;
    private FragmentManager fragmentManager;
    private String title;


    public static CompanyInfoInnerFragment newInstance(String text) {
        CompanyInfoInnerFragment fragment = new CompanyInfoInnerFragment();
        Bundle bundle = new Bundle();
        _views = new ArrayList<DWCView>();
        bundle.putString(ARG_TEXT, text);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.company_info_inner_fragment, container, false);
        _views.clear();
        InitializeViews(view);
        return view;
    }

    private void InitializeViews(View view) {
        title = getActivity().getApplicationContext().getResources().getString(R.string.title_Company_Info);
        Gson gson = new Gson();
        User _user = gson.fromJson(new StoreData(getActivity().getApplicationContext()).getUserDataAsString(), User.class);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.content_linear);
        _views.add(new DWCView("Registration Information", ItemType.HEADER));
        _views.add(new DWCView("Account Name", ItemType.LABEL));
        _views.add(new DWCView(_user.get_contact().get_account().getName(), ItemType.VALUE));
        _views.add(new DWCView("", ItemType.LINE));
        _views.add(new DWCView("Registration Date", ItemType.LABEL));
        _views.add(new DWCView(_user.get_contact().get_account().getCompanyRegistrationDate(), ItemType.VALUE));
        _views.add(new DWCView("", ItemType.LINE));
        _views.add(new DWCView("Legal Form", ItemType.LABEL));
        _views.add(new DWCView(_user.get_contact().get_account().getLegalForm(), ItemType.VALUE));
        _views.add(new DWCView("", ItemType.LINE));
        _views.add(new DWCView("Registration Number", ItemType.LABEL));
        _views.add(new DWCView(_user.get_contact().get_account().getRegistrationNumberValue(), ItemType.VALUE));
        _views.add(new DWCView("Contact Information", ItemType.HEADER));
        _views.add(new DWCView("Phone", ItemType.LABEL));
        _views.add(new DWCView(_user.get_contact().get_account().getPhone(), ItemType.VALUE));
        _views.add(new DWCView("", ItemType.LINE));
        _views.add(new DWCView("Fax", ItemType.LABEL));
        _views.add(new DWCView(_user.get_contact().get_account().getFax(), ItemType.VALUE));
        _views.add(new DWCView("", ItemType.LINE));
        _views.add(new DWCView("Email", ItemType.LABEL));
        _views.add(new DWCView(_user.get_contact().get_account().getEmail(), ItemType.VALUE));
        _views.add(new DWCView("", ItemType.LINE));
        _views.add(new DWCView("Mobile", ItemType.LABEL));
        _views.add(new DWCView(_user.get_contact().get_account().getMobile(), ItemType.VALUE));
        _views.add(new DWCView("", ItemType.LINE));
        _views.add(new DWCView("Pro Email", ItemType.LABEL));
        _views.add(new DWCView(_user.get_contact().get_account().getProEmail(), ItemType.VALUE));
        _views.add(new DWCView("", ItemType.LINE));
        _views.add(new DWCView("Pro Mobile", ItemType.LABEL));
        _views.add(new DWCView(_user.get_contact().get_account().getProMobileNumber(), ItemType.VALUE));
        _views.add(new DWCView("", ItemType.LINE));
        _views.add(new DWCView("Billing Address", ItemType.LABEL));
        _views.add(new DWCView(_user.get_contact().get_account().getBillingStreet().equals("null") || _user.get_contact().get_account().getBillingStreet() == null ? "" : _user.get_contact().get_account().getBillingStreet(), ItemType.VALUE));
        _views.add(new DWCView("Address Change,Name Change,Name Reservation,Capital Change,New NOC Company", ItemType.HORIZONTAL_LIST_VIEW));
        View viewItems = Utilities.drawViewsOnLayout(_user, getActivity().getApplicationContext(), _views);
        linearLayout.removeAllViews();
        linearLayout.addView(viewItems);
    }
}
