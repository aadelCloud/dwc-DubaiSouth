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
import model.Company_Documents__c;
import model.EServices_Document_Checklist__c;
import model.ServiceItem;
import model.ShareOwnership;
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
    public View getView(final int position, View convertView, ViewGroup parent) {
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
                } else if (object instanceof ShareOwnership) {
                    ShareOwnership shareHolder = (ShareOwnership) object;
                    if (tvServiceName.getText().toString().equals("Share Holder")) {
                        ActivitiesLauncher.openShareHolderActivity(context, shareHolder, "2", _items.get(position).getObjects());
                    }
                } else if (object instanceof EServices_Document_Checklist__c) {
                    EServices_Document_Checklist__c eServices_document_checklist__c = (EServices_Document_Checklist__c) object;
                    if (tvServiceName.getText().toString().equals("Preview")) {
                        ActivitiesLauncher.openCustomerDocumentsPreviewActivity(context, eServices_document_checklist__c);
                    } else if (tvServiceName.getText().toString().equals("Request True Copy")) {
                        ActivitiesLauncher.openCompanyDocumentsRequestTrueCopyActivity(context, eServices_document_checklist__c);
                    }
                } else if (object instanceof Company_Documents__c) {
                    Company_Documents__c company_documents__c = (Company_Documents__c) object;
                    if (tvServiceName.getText().toString().equals("Preview")) {
                        ActivitiesLauncher.openCustomerDocumentsPreviewActivity(context, company_documents__c);
                    } else if (tvServiceName.getText().toString().equals("Edit")) {
                        ActivitiesLauncher.openCustomerDocumentsEditActivity(context, company_documents__c);
                    }
                }
            }
        });

        return convertView;
    }
}
