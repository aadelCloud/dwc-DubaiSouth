package fragmentActivity;

import android.support.v4.app.Fragment;
import android.view.View;

import com.google.gson.Gson;

import cloudconcept.dwc.BaseActivity;
import dataStorage.StoreData;
import fragment.CompanyDocumentsFragment;
import model.User;

/**
 * Created by Abanoub Wagdy on 9/8/2015.
 */
public class HomeCompanyDocumentsActivity extends BaseActivity {
    User user;

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
        return "Company Documents";
    }

    @Override
    public Fragment GetFragment() {
        Gson gson = new Gson();
        user = gson.fromJson(new StoreData(getApplicationContext()).getUserDataAsString(),User.class);
        Fragment fragment = new CompanyDocumentsFragment();
        return fragment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
