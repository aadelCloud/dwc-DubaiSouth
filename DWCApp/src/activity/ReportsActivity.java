package activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.salesforce.androidsdk.rest.RestClient;

import cloudconcept.dwc.BaseActivity;
import exceptionHandling.ExceptionHandler;
import fragment.ReportsFragment;

public class ReportsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler(this));
    }

    @Override
    public void onResume(RestClient client) {
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
        return "Reports";
    }

    @Override
    public Fragment GetFragment() {
        Fragment fragment = ReportsFragment.newInstance("Reports");
        return fragment;
    }
}
