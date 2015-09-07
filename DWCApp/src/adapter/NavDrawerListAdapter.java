package adapter;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import cloudconcept.dwc.R;
import model.NavDrawerItem;


/**
 * Created by Abanoub on 6/22/2015.
 */
public class NavDrawerListAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<NavDrawerItem> navDrawerItems;

    public NavDrawerListAdapter(Context context, ArrayList<NavDrawerItem> navDrawerItems) {
        this.context = context;
        this.navDrawerItems = navDrawerItems;
    }

    @Override
    public int getCount() {
        return navDrawerItems.size();
    }

    @Override
    public Object getItem(int position) {
        return navDrawerItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater)
                    context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.item_row, null);
        }
        ImageView imgIcon = (ImageView) convertView.findViewById(R.id.rowIcon);
        TextView txtTitle = (TextView) convertView.findViewById(R.id.rowText);
        imgIcon.setImageDrawable(context.getResources().getDrawable(navDrawerItems.get(position).getIcon()));
        txtTitle.setText(navDrawerItems.get(position).getTitle());
        return convertView;
    }

}
