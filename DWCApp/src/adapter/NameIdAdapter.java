package adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cloudconcept.dwc.R;
import model.ShareOwnership;


/**
 * Created by M_Ghareeb on 9/8/2015.
 */
public class NameIdAdapter extends ArrayAdapter {


    Context context;
    List objects;

    public NameIdAdapter(Context context, int resource, int textViewResourceId, List objects) {
        super(context, resource, textViewResourceId, objects);
        this.context = context;
        this.objects=objects;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater)
                    context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(android.R.layout.simple_list_item_1, parent,false);
        }

        TextView tv = (TextView)convertView;
        if(objects.get(position) instanceof ShareOwnership)
        tv.setText(((ShareOwnership) objects.get(position)).get_shareholder().getName());

        return convertView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater)
                    context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.customtext, parent,false);
        }

        TextView tv = (TextView)convertView;
        if(objects.get(position) instanceof ShareOwnership)
            tv.setText(((ShareOwnership) objects.get(position)).get_shareholder().getName());

        return convertView;

    }
}
