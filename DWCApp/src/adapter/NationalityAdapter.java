package adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import cloudconcept.dwc.R;
import model.Country__c;

/**
 * Created by M_Ghareeb on 8/25/2015.
 */
public class NationalityAdapter extends ArrayAdapter<Country__c> {

    Context context;
    List<Country__c> objects;

    public NationalityAdapter(Context context, int resource, int textViewResourceId, List<Country__c> objects) {
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
        tv.setText(objects.get(position).getNationality_Name__c());

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
        tv.setText(objects.get(position).getNationality_Name__c());

        return convertView;

    }
}
