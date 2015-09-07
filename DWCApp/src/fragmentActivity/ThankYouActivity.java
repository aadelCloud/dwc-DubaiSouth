package fragmentActivity;

import android.support.v4.app.Fragment;
import android.view.View;

import cloudconcept.dwc.BaseActivity;
import fragment.ThankYouFragment;

/**
 * Created by Bibo on 7/29/2015.
 */
public class ThankYouActivity extends BaseActivity {

    @Override
    public int getNotificationVisibillity() {
        return View.GONE;
    }

    @Override
    public int getMenuVisibillity() {
        return View.GONE;
    }

    @Override
    public int getBackVisibillity() {
        return View.GONE;
    }

    @Override
    public String getHeaderTitle() {
        return "Thank You";
    }

    @Override
    public Fragment GetFragment() {
        Fragment _companyInfoFragment = ThankYouFragment.newInstance("Thank You", getIntent().getExtras().getString("Message"));
        return _companyInfoFragment;
    }
}
