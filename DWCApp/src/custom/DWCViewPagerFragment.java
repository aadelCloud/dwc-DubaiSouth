package custom;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.blunderer.materialdesignlibrary.R;
import com.blunderer.materialdesignlibrary.adapters.ViewPagerAdapter;
import com.blunderer.materialdesignlibrary.handlers.ViewPagerHandler;
import com.blunderer.materialdesignlibrary.models.ViewPagerItem;
import com.google.gson.Gson;
import com.salesforce.androidsdk.accounts.UserAccount;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.List;

import adapter.HorizontalListViewAdapter;
import model.Card_Management__c;
import model.Company_Documents__c;
import model.EServices_Document_Checklist__c;
import model.ServiceItem;
import model.ShareOwnership;
import model.Visa;
import utilities.ActivitiesLauncher;

/**
 * Created by Abanoub on 6/28/2015.
 */
public abstract class DWCViewPagerFragment extends Fragment
        implements com.blunderer.materialdesignlibrary.interfaces.ViewPager {

    protected CustomViewPager mViewPager;
    protected CirclePageIndicator mViewPagerIndicator;
    TextView tvTitle;
    private List<ViewPagerItem> mViewPagerItems;
    private int mCurrentPagePosition = 0;
    private final ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager
            .OnPageChangeListener() {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {

            mCurrentPagePosition = position;
            tvTitle.setText(mViewPagerItems.get(position).getTitle());
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }

    };
    private String objectAsString;
    private Gson gson;

    public DWCViewPagerFragment() {
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        ViewPagerHandler viewPagerHandler = getViewPagerHandler();
        if (viewPagerHandler == null)
            viewPagerHandler = new ViewPagerHandler(getActivity());
        mViewPagerItems = viewPagerHandler.getViewPagerItems();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.mdl_fragment_view_pager, container, false);
        tvTitle = (TextView) view.findViewById(R.id.tvTitle);
        if (mViewPagerItems != null && mViewPagerItems.size() > 0) {
            mViewPager = (CustomViewPager) view.findViewById(R.id.viewpager);
            mViewPager.setAdapter(new ViewPagerAdapter(getChildFragmentManager(), mViewPagerItems));
            int defaultViewPagerItemSelectedPosition = defaultViewPagerPageSelectedPosition();
            if (defaultViewPagerItemSelectedPosition >= 0 &&
                    defaultViewPagerItemSelectedPosition < mViewPagerItems.size()) {
                mViewPager.setCurrentItem(defaultViewPagerItemSelectedPosition);
            }

            showIndicator(view, mViewPager);
        }

        tvTitle.setText(mViewPagerItems.get(mCurrentPagePosition).getTitle());

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (mViewPagerItems != null && mViewPagerItems.size() > 0 && mViewPager != null) {
            int tabPosition = mViewPager.getCurrentItem();
            if (tabPosition >= 0 && tabPosition < mViewPagerItems.size()) {
                mViewPagerItems.get(tabPosition).getFragment()
                        .onActivityResult(requestCode, resultCode, data);
            }
        }
    }

    public synchronized String getTitle() {
        if (mViewPagerItems == null || mCurrentPagePosition < 0
                || mCurrentPagePosition >= mViewPagerItems.size()) {
            return null;
        }
        tvTitle.setText(mViewPagerItems.get(mCurrentPagePosition).getTitle());
        return mViewPagerItems.get(mCurrentPagePosition).getTitle();
    }

    private void showIndicator(View view, final CustomViewPager pager) {
        if (!showViewPagerIndicator()) pager.setOnPageChangeListener(mOnPageChangeListener);
        else {
            mViewPagerIndicator = (CirclePageIndicator) view.findViewById(R.id.viewpagerindicator);
            mViewPagerIndicator.setViewPager(pager);
            mViewPagerIndicator.setVisibility(View.VISIBLE);
            mViewPagerIndicator.setOnPageChangeListener(mOnPageChangeListener);
//            pager.setOnTouchListener(new View.OnTouchListener() {
//                @Override
//                public boolean onTouch(View v, MotionEvent event) {
//                    if (event.getAction() == MotionEvent.ACTION_MOVE) {
//                        if (v instanceof HorizontalListView) {
//                            HorizontalListView horizontalListView = (HorizontalListView) v;
//                            final HorizontalListViewAdapter adapter = (HorizontalListViewAdapter) horizontalListView.getAdapter();
//                            final ArrayList<ServiceItem> _items = adapter.getServiceItems();
//                            pager.setPagingEnabled(false);
//                            v.getParent().requestDisallowInterceptTouchEvent(true);
//                            ScrollView sv = new ScrollView(getActivity());
//                            WScrollView hsv = new WScrollView(getActivity());
//                            LinearLayout rl = new LinearLayout(getActivity());
//                            rl.setBackgroundColor(getActivity().getResources().getColor(R.color.white_green));
//                            rl.setOrientation(LinearLayout.HORIZONTAL);
//                            rl.setDividerPadding(10);
//                            for (int i = 0; i < _items.size(); i++) {
//                                LayoutInflater mInflater = (LayoutInflater)
//                                        getActivity().getApplicationContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
//                                View convertView = mInflater.inflate(cloudconcept.dwc.R.layout.horizontal_item_row, null);
//                                ImageView ivServiceDrawable;
//                                final TextView tvServiceName;
//
//                                ivServiceDrawable = (ImageView) convertView.findViewById(cloudconcept.dwc.R.id.ivServiceDrawable);
//                                tvServiceName = (TextView) convertView.findViewById(cloudconcept.dwc.R.id.tvServiceName);
//
//                                ivServiceDrawable.setImageResource(_items.get(i).getDrawableIcon());
//                                tvServiceName.setText(_items.get(i).getTvServiceName());
//                                convertView.setOnClickListener(new View.OnClickListener() {
//                                    @Override
//                                    public void onClick(View v) {
//                                        if (adapter.getObject() instanceof Visa) {
//                                            Visa _visa = (Visa) adapter.getObject();
//                                            objectAsString = gson.toJson(_visa);
//                                            if (tvServiceName.getText().toString().equals("Show Details")) {
//                                                ActivitiesLauncher.openShowDetailsActivity(getActivity().getApplicationContext(), "Visa Details", objectAsString, "Visa");
//                                            } else if (tvServiceName.getText().toString().equals("New NOC")) {
//                                                ActivitiesLauncher.openNOCActivity(getActivity().getApplicationContext(), objectAsString, "Visa");
//                                            } else if (tvServiceName.getText().toString().equals("Renew Visa")) {
//                                                ActivitiesLauncher.openVisaActivity(getActivity().getApplicationContext(), _visa, "renew");
//                                            } else if (tvServiceName.getText().toString().equals("Cancel Visa")) {
//                                                ActivitiesLauncher.openVisaActivity(getActivity().getApplicationContext(), _visa, "Cancel");
//                                            } else if (tvServiceName.getText().toString().equals("Renew Passport")) {
//                                                ActivitiesLauncher.openVisaActivity(getActivity().getApplicationContext(), _visa, "Passport");
//                                            }
//                                        } else if (adapter.getObject() instanceof Card_Management__c) {
//                                            Card_Management__c card = (Card_Management__c) adapter.getObject();
//                                            if (tvServiceName.getText().toString().equals("Cancel Card")) {
//                                                ActivitiesLauncher.openCardActivity(getActivity().getApplicationContext(), card, "2");
//                                            } else if (tvServiceName.getText().toString().equals("Renew Card")) {
//                                                ActivitiesLauncher.openCardActivity(getActivity().getApplicationContext(), card, "3");
//                                            } else if (tvServiceName.getText().toString().equals("Replace Card")) {
//                                                ActivitiesLauncher.openCardActivity(getActivity().getApplicationContext(), card, "4");
//                                            }
//                                        } else if (adapter.getObject() instanceof ShareOwnership) {
//                                            ShareOwnership shareHolder = (ShareOwnership) adapter.getObject();
//                                            if (tvServiceName.getText().toString().equals("Share Holder")) {
//                                                ActivitiesLauncher.openShareHolderActivity(getActivity().getApplicationContext(), shareHolder, "2", _items.get(i).getObjects());
//                                            }
//                                        } else if (adapter.getObject() instanceof EServices_Document_Checklist__c) {
//                                            EServices_Document_Checklist__c eServices_document_checklist__c = (EServices_Document_Checklist__c) object;
//                                            if (tvServiceName.getText().toString().equals("Preview")) {
//                                                ActivitiesLauncher.openCustomerDocumentsPreviewActivity(getActivity().getApplicationContext(), eServices_document_checklist__c);
//                                            } else if (tvServiceName.getText().toString().equals("Request True Copy")) {
//                                                ActivitiesLauncher.openCompanyDocumentsRequestTrueCopyActivity(get, eServices_document_checklist__c);
//                                            }
//                                        } else if (adapter.getObject() instanceof Company_Documents__c) {
//                                            Company_Documents__c company_documents__c = (Company_Documents__c) object;
//                                            if (tvServiceName.getText().toString().equals("Preview")) {
//                                                ActivitiesLauncher.openCustomerDocumentsPreviewActivity(context, company_documents__c);
//                                            } else if (tvServiceName.getText().toString().equals("Edit")) {
//                                                ActivitiesLauncher.openCustomerDocumentsEditActivity(context, company_documents__c);
//                                            }
//                                        }
//                                    }
//                                });
//                            }
//                            sv.addView(rl, new RelativeLayout.LayoutParams(500, 500));
//                            hsv.addView(sv, new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
//                            return false;
//                        } else {
//                            pager.setPagingEnabled(true);
//                            v.getParent().requestDisallowInterceptTouchEvent(false);
//                            return true;
//                        }
//                    }else{
//                        return true;
//                    }
//                }
//            });
        }
    }

    public abstract boolean showViewPagerIndicator();
}