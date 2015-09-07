package fragmentActivity;

import android.support.v4.app.FragmentActivity;

import model.Company_Documents__c;
import model.Receipt_Template__c;

/**
 * Created by M_Ghareeb on 8/25/2015.
 */
public class BaseFragmentActivity extends FragmentActivity {
    public static final int RESULT_LOAD_IMG_FROM_GALLERY = 2;
    public static final int RESULT_LOAD_IMG_FROM_CAMERA = 3;
    public Company_Documents__c company_documents__c;
    public Receipt_Template__c geteServiceAdministration() {
        return eServiceAdministration;
    }

    public void seteServiceAdministration(Receipt_Template__c eServiceAdministration) {
        this.eServiceAdministration = eServiceAdministration;
    }

    private Receipt_Template__c eServiceAdministration;
    @Override
    public void onBackPressed() {

    }
}
