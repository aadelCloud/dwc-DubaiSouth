package custom;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Gallery;
import android.widget.HorizontalScrollView;

/**
 * Created by Abanoub Wagdy on 9/6/2015.
 */
public class CustomViewPager extends ViewPager {

    private int childId;

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
        if (v != this && (v instanceof HorizontalListView || v instanceof Gallery)) {
            return true;
        }
        return super.canScroll(v, checkV, dx, x, y);
    }
}
