package fragmentActivity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.salesforce.androidsdk.rest.RestClient;

import cloudconcept.dwc.BaseActivity;
import cloudconcept.dwc.R;
import exceptionHandling.ExceptionHandler;
import fragment.VisasAndCardsFragment;

public class VisasAndCardsActivity extends BaseActivity {

    protected RestClient client;

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
        return 0;
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
        return getString(R.string.visas_cards);
    }

    @Override
    public Fragment GetFragment() {
        Fragment _visasCardsFragment = new VisasAndCardsFragment();
        return _visasCardsFragment;
    }
}
