package adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import cloudconcept.dwc.R;
import model.Company_Documents__c;
import utilities.Utilities;

/**
 * Created by Abanoub Wagdy on 8/18/2015.
 */
public class CompanyDocumentsActivityAdapter extends BaseAdapter {

    Context applicationContext;
    ArrayList<Company_Documents__c> filteredCompanyDocuments;

    public CompanyDocumentsActivityAdapter(Context applicationContext, ArrayList<Company_Documents__c> filteredCompanyDocuments) {
        this.applicationContext = applicationContext;
        this.filteredCompanyDocuments = filteredCompanyDocuments;
    }

    @Override
    public int getCount() {
        return filteredCompanyDocuments.size();
    }

    @Override
    public Object getItem(int position) {
        return filteredCompanyDocuments.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater)
                    applicationContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.company_document_item_row_activity, null);
        }

        TextView tvCompanyDocumentName, tvDate, tvVersion;

        tvCompanyDocumentName = (TextView) convertView.findViewById(R.id.tvCompanyDocumentName);
        tvDate = (TextView) convertView.findViewById(R.id.tvDate);
        tvVersion = (TextView) convertView.findViewById(R.id.tvVersion);

        tvCompanyDocumentName.setText(filteredCompanyDocuments.get(position).getName());
        tvDate.setText(Utilities.stringNotNull(filteredCompanyDocuments.get(position).getCreatedDate().getTime().toString()));
        tvVersion.setText(String.valueOf(filteredCompanyDocuments.get(position).getVersion__c()));

        return convertView;
    }
}
