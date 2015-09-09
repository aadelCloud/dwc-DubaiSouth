package fragment;

import android.support.v4.app.Fragment;

import com.blunderer.materialdesignlibrary.handlers.ViewPagerHandler;

import cloudconcept.dwc.R;
import custom.DWCViewPagerFragment;
import fragment.companyDocumentsScreen.CompanyDocumentsInnerFragment;
import fragment.companyDocumentsScreen.TrueCopiesFragment;
import fragment.visasAndCards.AccessCardFragment;
import fragment.visasAndCards.PermanentEmployeeFragment;
import fragment.visasAndCards.VisitVisaFragment;

/**
 * Created by Abanoub Wagdy on 9/8/2015.
 */
public class CompanyDocumentsFragment extends DWCViewPagerFragment {

    @Override
    public boolean showViewPagerIndicator() {
        return true;
    }

    @Override
    public ViewPagerHandler getViewPagerHandler() {
        return new ViewPagerHandler(getActivity())
                .addPage("CERTIFICATES/AGREEMENTS", TrueCopiesFragment.newInstance("TrueCopiesFragment"))
                .addPage("CUSTOMER DOCUMENTS", CompanyDocumentsInnerFragment.newInstance("CompanyDocumentsInnerFragment"));
    }

    @Override
    public int defaultViewPagerPageSelectedPosition() {
        return 0;
    }


}

