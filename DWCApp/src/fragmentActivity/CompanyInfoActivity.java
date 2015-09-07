package fragmentActivity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.salesforce.androidsdk.rest.RestClient;

import cloudconcept.dwc.BaseActivity;
import cloudconcept.dwc.R;
import exceptionHandling.ExceptionHandler;
import fragment.CompanyInfoFragment;

public class CompanyInfoActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler(this));
    }

    @Override
    public void onResume(RestClient client) {
        this.client = client;
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
        return getString(R.string.title_Company_Info);
    }

    @Override
    public Fragment GetFragment() {
        Fragment _companyInfoFragment = new CompanyInfoFragment();
        return _companyInfoFragment;
    }
}
