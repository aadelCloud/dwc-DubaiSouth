package custom;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Gallery;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;

import adapter.HorizontalListViewAdapter;
import cloudconcept.dwc.R;
import model.Card_Management__c;
import model.Company_Documents__c;
import model.EServices_Document_Checklist__c;
import model.ServiceItem;
import model.ShareOwnership;
import model.Visa;
import utilities.ActivitiesLauncher;

/**
 * Created by Abanoub Wagdy on 9/6/2015.
 */
public class CustomViewPager extends ViewPager {

    private int childId;
    private String objectAsString;
    private Gson gson;

    public CustomViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

//
//    @Override
//    public boolean onInterceptTouchEvent(MotionEvent event) {
//
//        if (childId > 0) {
//            View scroll = findViewById(childId);
//            if (scroll != null) {
//                Rect rect = new Rect();
//                scroll.getHitRect(rect);
//                if (rect.contains((int) event.getX(), (int) event.getY())) {
//                    return false;
//                }
//            }
//        }
//        return super.onInterceptTouchEvent(event);
//    }
//
//    public void setChildId(int id) {
//        this.childId = id;
//    }

    @Override
    protected boolean canScroll(View v, boolean checkV, int dx, int x, int y) {
        if (v != this && (v instanceof HorizontalListView)) {
            v.requestFocus();
            v.getParent().requestDisallowInterceptTouchEvent(true);
//            ((HorizontalListView) v).requestDisallowInterceptTouchEvent(false);
//            HorizontalListView listView = (HorizontalListView) v;
//            HorizontalListViewAdapter adapter = (HorizontalListViewAdapter) listView.getAdapter();
//            ArrayList<ServiceItem> _items = adapter.getServiceItems();
//            if (!adapter.getInflated()) {
//                listView.setAdapter(adapter);
//                adapter.setInflated(true);
//                adapter.notifyDataSetChanged();
//            } else {
////                return super.canScroll(v, checkV, dx, x, y);
//                if (listView.getLastVisiblePosition() == _items.size()) {
//                    listView.setSelection(0);
//                }
//            }

            return true;
        } else {
            return super.canScroll(v, checkV, dx, x, y);
        }
    }
}
