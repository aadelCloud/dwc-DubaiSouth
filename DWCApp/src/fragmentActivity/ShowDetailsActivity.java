package fragmentActivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.gson.Gson;

import java.util.ArrayList;

import cloudconcept.dwc.BaseActivity;
import cloudconcept.dwc.R;
import exceptionHandling.ExceptionHandler;
import model.DWCView;
import model.ItemType;
import model.Visa;
import utilities.Utilities;

/**
 * Created by Abanoub on 7/8/2015.
 */
public class ShowDetailsActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler(this));
    }

    @Override
    public int getNotificationVisibillity() {
        return View.VISIBLE;
    }

    @Override
    public int getMenuVisibillity() {
        return View.VISIBLE;
    }

    @Override
    public int getBackVisibillity() {
        return View.GONE;
    }

    @Override
    public String getHeaderTitle() {
        String title = getIntent().getExtras().getString("title");
        return title;
    }

    @Override
    public Fragment GetFragment() {
        Fragment fragment = ShowDetailsFragment.newInstance("ShowDetails", getIntent().getExtras().getString("objectType"), getIntent().getExtras().getString("objectAsString"));
        return null;
    }

    public static class ShowDetailsFragment extends Fragment {

        private static ArrayList<DWCView> _views;
        private static String ARG_TEXT = "ShowDetails";
        static String ObjectType;
        static String ObjectAsString;
        Visa _visa;
        Gson gson = new Gson();

        public static ShowDetailsFragment newInstance(String details, String objectType, String objectAsString) {
            ShowDetailsFragment fragment = new ShowDetailsFragment();
            Bundle bundle = new Bundle();
            _views = new ArrayList<DWCView>();
            bundle.putString(ARG_TEXT, details);
            ObjectType = objectType;
            ObjectAsString = objectAsString;
            fragment.setArguments(bundle);
            return fragment;
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.company_info_inner_fragment, container, false);
            _views.clear();
            if (ObjectType.equals("Visa")) {
                gson = new Gson();
                _visa = gson.fromJson(ObjectAsString, Visa.class);
                InitializeVisaViews(view);
            }
            return view;
        }

        private void InitializeVisaViews(View view) {
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.content_linear);
            _views.add(new DWCView("Employee Information", ItemType.HEADER));
            _views.add(new DWCView("Name", ItemType.LABEL));
            _views.add(new DWCView(Utilities.stringNotNull(_visa.getApplicant_Full_Name__c()), ItemType.VALUE));
            _views.add(new DWCView("Employee ID", ItemType.LABEL));
            _views.add(new DWCView(Utilities.stringNotNull(_visa.getEmployee_ID__c()) , ItemType.VALUE));
            _views.add(new DWCView("Gender", ItemType.LABEL));
            _views.add(new DWCView(Utilities.stringNotNull(_visa.getApplicant_Gender__c()), ItemType.VALUE));
            _views.add(new DWCView("Birth Date", ItemType.LABEL));
            _views.add(new DWCView(Utilities.stringNotNull(_visa.getDate_of_Birth__c()), ItemType.HEADER));
            _views.add(new DWCView("Mobile", ItemType.LABEL));
            _views.add(new DWCView(Utilities.stringNotNull(_visa.getApplicant_Mobile_Number__c()), ItemType.HEADER));
            _views.add(new DWCView("Email", ItemType.LABEL));
            _views.add(new DWCView(Utilities.stringNotNull(_visa.getApplicant_Email__c()), ItemType.HEADER));
            _views.add(new DWCView("Visa Information", ItemType.HEADER));
            _views.add(new DWCView("Visa Number", ItemType.LABEL));
            _views.add(new DWCView(Utilities.stringNotNull(_visa.getID()), ItemType.VALUE));
            _views.add(new DWCView("Status", ItemType.LABEL));
            _views.add(new DWCView(Utilities.stringNotNull(_visa.getVisa_Validity_Status__c()), ItemType.VALUE));
            _views.add(new DWCView("Expiry", ItemType.LABEL));
            _views.add(new DWCView(Utilities.stringNotNull(_visa.getVisa_Expiry_Date__c()), ItemType.VALUE));

            _views.add(new DWCView("Passport Information", ItemType.HEADER));
            _views.add(new DWCView("Passport", ItemType.LABEL));
            _views.add(new DWCView(Utilities.stringNotNull(_visa.getPassport_Number__c()), ItemType.VALUE));
            _views.add(new DWCView("Expriry Date", ItemType.LABEL));
            _views.add(new DWCView(Utilities.stringNotNull(_visa.getVisa_Expiry_Date__c()), ItemType.VALUE));
            _views.add(new DWCView("Issue Country", ItemType.LABEL));
            _views.add(new DWCView(Utilities.stringNotNull(_visa.getPassport_Country__c()), ItemType.VALUE));
            String Services = "";
            if (_visa.getVisa_Validity_Status__c().equals("Issued")) {
                Services += "New NOC";
            }

            if (_visa.getVisa_Validity_Status__c().equals("Issued") || _visa.getVisa_Validity_Status__c().equals("Expired")) {
                Services += "," + "License Renewal" + "," + "Cancel Visa";
            }
            _views.add(new DWCView(Services, ItemType.HORIZONTAL_LIST_VIEW));
            View RenderedViewItems = Utilities.drawViewsOnLayout(getActivity(),_visa, getActivity().getApplicationContext(), _views);
            linearLayout.addView(RenderedViewItems);
        }
    }
}
