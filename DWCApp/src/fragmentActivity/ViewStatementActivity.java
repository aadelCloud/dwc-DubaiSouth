package fragmentActivity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import cloudconcept.dwc.BaseActivity;
import exceptionHandling.ExceptionHandler;
import fragment.ViewStatementFragment;

/**
 * Created by Abanoub Wagdy on 9/6/2015.
 */
public class ViewStatementActivity extends BaseActivity{

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
        return "Statement";
    }

    @Override
    public Fragment GetFragment() {
        Fragment fragment = new ViewStatementFragment();
        return fragment;
    }
}
