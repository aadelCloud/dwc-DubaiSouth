package adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import cloudconcept.dwc.R;
import model.Company_Documents__c;

/**
 * Created by Abanoub Wagdy on 8/17/2015.
 */
public class CompanyDocumentsAdapter extends BaseAdapter {

    ArrayList<Company_Documents__c> companyDocuments;
    private Context context;

    public CompanyDocumentsAdapter(Context context, ArrayList<Company_Documents__c> companyDocuments) {
        this.companyDocuments = companyDocuments;
        this.context = context;
    }

    @Override
    public int getCount() {
        return companyDocuments.size();
    }

    @Override
    public Object getItem(int position) {
        return companyDocuments.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater mInflater = (LayoutInflater)
                context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.company_document_item_row, parent, false);
        }

        TextView tvAttachmentName = (TextView) convertView.findViewById(R.id.tvAttachmentName);
        tvAttachmentName.setText(companyDocuments.get(position).getName());

        if (companyDocuments.get(position).getHasAttachment()) {
            tvAttachmentName.setBackgroundResource(R.drawable.add_attachment_enabled);
        }else{
            tvAttachmentName.setBackgroundResource(R.drawable.add_attchment_disabled);
        }

        return convertView;
    }
}
