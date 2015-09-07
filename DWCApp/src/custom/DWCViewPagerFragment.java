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
import android.widget.TextView;

import com.blunderer.materialdesignlibrary.R;
import com.blunderer.materialdesignlibrary.adapters.ViewPagerAdapter;
import com.blunderer.materialdesignlibrary.handlers.ViewPagerHandler;
import com.blunderer.materialdesignlibrary.models.ViewPagerItem;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.List;

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

    private void showIndicator(View view, ViewPager pager) {
        if (!showViewPagerIndicator()) pager.setOnPageChangeListener(mOnPageChangeListener);
        else {
            mViewPagerIndicator = (CirclePageIndicator) view.findViewById(R.id.viewpagerindicator);
            mViewPagerIndicator.setViewPager(pager);
            mViewPagerIndicator.setVisibility(View.VISIBLE);
            mViewPagerIndicator.setOnPageChangeListener(mOnPageChangeListener);
        }
    }

    public abstract boolean showViewPagerIndicator();
}