package adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;

import cloudconcept.dwc.R;
import model.Card_Management__c;
import model.Contract_DWC__c;
import model.Directorship;
import model.ServiceItem;
import model.User;
import model.Visa;
import utilities.ActivitiesLauncher;

/**
 * Created by Abanoub on 6/26/2015.
 */
public class HorizontalListViewAdapter extends BaseAdapter {

    Object object;
    Gson gson;
    String objectAsString = "";
    private Context context;
    private ArrayList<ServiceItem> _items;

    public HorizontalListViewAdapter(Object object, Context context, ArrayList<ServiceItem> _items) {
        this._items = _items;
        this.context = context;
        this.object = object;
        gson = new Gson();
    }


    @Override
    public int getCount() {
        return _items.size();
    }

    @Override
    public Object getItem(int position) {
        return _items.get(position);
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
            convertView = mInflater.inflate(R.layout.horizontal_item_row, null);
        }

        ImageView ivServiceDrawable;
        final TextView tvServiceName;

        ivServiceDrawable = (ImageView) convertView.findViewById(R.id.ivServiceDrawable);
        tvServiceName = (TextView) convertView.findViewById(R.id.tvServiceName);

        ivServiceDrawable.setImageResource(_items.get(position).getDrawableIcon());
        tvServiceName.setText(_items.get(position).getTvServiceName());
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (object instanceof Visa) {
                    Visa _visa = (Visa) object;
                    objectAsString = gson.toJson(_visa);
                    if (tvServiceName.getText().toString().equals("Show Details")) {
                        ActivitiesLauncher.openShowDetailsActivity(context, "Visa Details", objectAsString, "Visa");
                    } else if (tvServiceName.getText().toString().equals("New NOC")) {
                        ActivitiesLauncher.openNOCActivity(context, objectAsString, "Visa");
                    } else if (tvServiceName.getText().toString().equals("Renew Visa")) {
                        ActivitiesLauncher.openVisaActivity(context, _visa, "renew");
                    } else if (tvServiceName.getText().toString().equals("Cancel Visa")) {
                        ActivitiesLauncher.openVisaActivity(context, _visa, "Cancel");
                    } else if (tvServiceName.getText().toString().equals("Renew Passport")) {
                        ActivitiesLauncher.openVisaActivity(context, _visa, "Passport");
                    }
                } else if (object instanceof Card_Management__c) {
                    Card_Management__c card = (Card_Management__c) object;
                    if (tvServiceName.getText().toString().equals("Cancel Card")) {
                        ActivitiesLauncher.openCardActivity(context, card, "2");
                    } else if (tvServiceName.getText().toString().equals("Renew Card")) {
                        ActivitiesLauncher.openCardActivity(context, card, "3");
                    } else if (tvServiceName.getText().toString().equals("Replace Card")) {
                        ActivitiesLauncher.openCardActivity(context, card, "4");
                    }
                } else if (object instanceof Contract_DWC__c) {
                    Contract_DWC__c contract_dwc__c = (Contract_DWC__c) object;
                    if (tvServiceName.getText().toString().equals("Show Details")) {
                        ActivitiesLauncher.openShowContractDetailsActivity(context, contract_dwc__c);
                    }
                } else if (object instanceof User) {
                    User user = (User) object;
                    if (tvServiceName.getText().toString().equals("New NOC Company")) {
                        ActivitiesLauncher.openCompanyNocActivity(context);
                    } else if (tvServiceName.getText().toString().equals("Name Reservation")) {
                        ActivitiesLauncher.openNameReservationActivity(context);
                    } else if (tvServiceName.getText().toString().equals("Address Change")) {
                        ActivitiesLauncher.openGenericChangeAndRemovalActivity(context, "Address Change", object);
                    } else if (tvServiceName.getText().toString().equals("Name Change")) {
                        ActivitiesLauncher.openGenericChangeAndRemovalActivity(context, "Name Change", object);
                    } else if (tvServiceName.getText().toString().equals("Capital Change")) {
                        ActivitiesLauncher.openGenericChangeAndRemovalActivity(context, "Capital Change", object);
                    }
                } else if (object instanceof Directorship) {
                    if (tvServiceName.getText().toString().equals("Director Removal")) {
                        ActivitiesLauncher.openGenericChangeAndRemovalActivity(context, "Director Removal", object);
                    } else if (tvServiceName.getText().toString().equals("Show Details")) {
                    }
                }
            }
        });

        return convertView;
    }
}
