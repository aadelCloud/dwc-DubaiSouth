package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Abanoub on 7/2/2015.
 */
public abstract class ClickableListAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private List mDataObjects;
    private int mViewId;


    public ClickableListAdapter(Context context, int viewid, List objects) {

        mInflater = LayoutInflater.from(context);
        mDataObjects = objects;
        mViewId = viewid;

        if (objects == null) {
            mDataObjects = new ArrayList<Object>();
        }
    }


    public int getCount() {
        return mDataObjects.size();
    }


    public Object getItem(int position) {
        return mDataObjects.get(position);
    }

    public long getItemId(int position) {
        return position;
    }


    public View getView(int position, View view, ViewGroup parent) {

        ViewHolder holder;


        if (view == null) {
            view = mInflater.inflate(mViewId, null);
            holder = createHolder(view);
            view.setTag(holder);

        } else {
            holder = (ViewHolder) view.getTag();
        }

        // we must update the object's reference
        holder.data = getItem(position);
        // call the user's implementation
        bindHolder(holder);

        return view;
    }

    protected abstract ViewHolder createHolder(View v);

    protected abstract void bindHolder(ViewHolder h);


    public static class ViewHolder {
        public Object data;
    }

    public static abstract class OnClickListener implements
            View.OnClickListener {

        private ViewHolder mViewHolder;

        /**
         * @param holder The holder of the clickable item
         */
        public OnClickListener(ViewHolder holder) {
            mViewHolder = holder;
        }

        // delegates the click event
        public void onClick(View v) {
            onClick(v, mViewHolder);
        }

        /**
         * Implement your click behavior here
         *
         * @param v The clicked view.
         */
        public abstract void onClick(View v, ViewHolder viewHolder);
    }

    /**
     * The long click listener base class.
     */
    public static abstract class OnLongClickListener implements
            View.OnLongClickListener {

        private ViewHolder mViewHolder;

        /**
         * @param holder The holder of the clickable item
         */
        public OnLongClickListener(ViewHolder holder) {
            mViewHolder = holder;
        }

        // delegates the click event
        public boolean onLongClick(View v) {
            onLongClick(v, mViewHolder);
            return true;
        }

        /**
         * Implement your click behavior here
         *
         * @param v The clicked view.
         */
        public abstract void onLongClick(View v, ViewHolder viewHolder);

    }
}
