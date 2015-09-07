package fragmentActivity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import cloudconcept.dwc.BaseActivity;
import exceptionHandling.ExceptionHandler;
import fragment.NeedHelpFragment;

public class NeedHelpActivity extends BaseActivity {

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
        return "Need Help";
    }

    @Override
    public Fragment GetFragment() {
        Fragment fragment = NeedHelpFragment.newInstance("Need Help");
        return fragment;
    }
}
