package fragment;

import com.blunderer.materialdesignlibrary.handlers.ViewPagerHandler;

import cloudconcept.dwc.R;
import custom.DWCViewPagerFragment;
import fragment.visasAndCards.AccessCardFragment;
import fragment.visasAndCards.PermanentEmployeeFragment;
import fragment.visasAndCards.VisitVisaFragment;

/**
 * Created by Abanoub on 6/28/2015.
 */
public class VisasAndCardsFragment extends DWCViewPagerFragment {

    @Override
    public boolean showViewPagerIndicator() {
        return true;
    }

    @Override
    public ViewPagerHandler getViewPagerHandler() {
        return new ViewPagerHandler(getActivity())
                .addPage(R.string.title1, PermanentEmployeeFragment.newInstance("PermanentEmployeeFragment"))
                .addPage(R.string.title2, AccessCardFragment.newInstance("AccessCardFragment"))
                .addPage(R.string.title3, VisitVisaFragment.newInstance("VisitVisaFragment"));
    }

    @Override
    public int defaultViewPagerPageSelectedPosition() {
        return 0;
    }


}
