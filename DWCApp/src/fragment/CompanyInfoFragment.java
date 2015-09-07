package fragment;

import com.blunderer.materialdesignlibrary.handlers.ViewPagerHandler;

import cloudconcept.dwc.R;
import custom.DWCViewPagerFragment;
import fragment.companyInfo.CompanyInfoInnerFragment;
import fragment.companyInfo.DirectorsFragment;
import fragment.companyInfo.GeneralManagersFragment;
import fragment.companyInfo.LeasingInfoFragment;
import fragment.companyInfo.LegalRepresentativesFragment;
import fragment.companyInfo.LicenseInfoFragment;
import fragment.companyInfo.ShareholdersFragment;

/**
 * Created by Abanoub Wagdy on 7/2/2015.
 */
public class CompanyInfoFragment extends DWCViewPagerFragment {

    public CompanyInfoFragment() {
    }

    @Override
    public boolean showViewPagerIndicator() {
        return true;
    }

    @Override
    public ViewPagerHandler getViewPagerHandler() {
        return new ViewPagerHandler(getActivity())
                .addPage(R.string.title_Company_Info, CompanyInfoInnerFragment.newInstance(getString(R.string.title_Company_Info)))
                .addPage(R.string.title_license_info, LicenseInfoFragment.newInstance(getString(R.string.title_license_info)))
                .addPage(R.string.title_leasing_info, LeasingInfoFragment.newInstance(getString(R.string.title_leasing_info)))
                .addPage(R.string.title_shareholders, ShareholdersFragment.newInstance(getString(R.string.title_shareholders)))
                .addPage(R.string.title_directors, DirectorsFragment.newInstance(getString(R.string.title_directors)))
                .addPage(R.string.title_general_managers, GeneralManagersFragment.newInstance(getString(R.string.title_general_managers)))
                .addPage(R.string.title_legal_representative, LegalRepresentativesFragment.newInstance(getString(R.string.title_legal_representative)));
    }

    @Override
    public int defaultViewPagerPageSelectedPosition() {
        return 0;
    }
}
