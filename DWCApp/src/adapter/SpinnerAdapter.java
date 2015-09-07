package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import cloudconcept.dwc.R;

/**
 * Created by Abanoub on 6/27/2015.
 */
public class SpinnerAdapter extends ArrayAdapter<String> {

    private final List<String> items;
    private final Context c;
    private int textViewResourceId;

    public SpinnerAdapter(Context context, int textViewResourceId, List<String> items) {
        super(context, textViewResourceId, items);
        this.textViewResourceId = textViewResourceId;
        this.items = items;
        this.c = context;
    }

    @Override

    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        if (v == null) {
            LayoutInflater vi = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(textViewResourceId, null);
        }
        TextView label = (TextView) v.findViewById(R.id.label);
        String item = (String) items.get(position);
        Animation anim = null;
        label.setText(item);
        return v;
    }
}
