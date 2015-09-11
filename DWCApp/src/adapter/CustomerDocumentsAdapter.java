package adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import cloudconcept.dwc.R;
import custom.HorizontalListView;
import custom.expandableView.ExpandableLayoutItem;
import model.Company_Documents__c;
import model.EServices_Document_Checklist__c;
import model.ServiceItem;
import utilities.Utilities;

/**
 * Created by Abanoub Wagdy on 9/9/2015.
 */
public class CustomerDocumentsAdapter extends RecyclerView.Adapter<CustomerDocumentsAdapter.ViewHolder> {

    private Activity activity;
    public ArrayList<Company_Documents__c> data;
    Context context;

    public CustomerDocumentsAdapter(Activity activity, Context applicationContext, ArrayList<Company_Documents__c> company_documents__cs) {
        this.data = company_documents__cs;
        this.context = applicationContext;
        this.activity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.company_document_item_row_screen, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        holder.tvCompanyDocumentName.setText(data.get(position).getName());
        holder.tvDate.setText(Utilities.stringNotNull(data.get(position).getCreatedDate().getTime().toString()));
        holder.tvVersion.setText(String.valueOf(data.get(position).getVersion__c()));

        ArrayList<ServiceItem> _items = new ArrayList<ServiceItem>();
        if (data.get(position).getAttachment_Id__c() != null && !data.get(position).getAttachment_Id__c().equals("")) {
            _items.add(new ServiceItem("Preview", R.drawable.preview));
        }
        _items.add(new ServiceItem("Edit", R.drawable.edit));

        holder.horizontalServices.setAdapter(new HorizontalListViewAdapter(data.get(position), activity, context, _items));

        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder != null) {
                    if (!holder.item.isOpened()) {
                        holder.item.show();
                    } else {
                        holder.item.hide();
                    }
                }
            }
        });
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void add(Company_Documents__c string) {
        insert(string, data.size());
    }

    public void insert(Company_Documents__c string, int position) {
        data.add(position, string);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        data.remove(position);
        notifyItemRemoved(position);
    }

    public void clear() {
        int size = data.size();
        data.clear();
        notifyItemRangeRemoved(0, size);
    }


    public boolean addAll(ArrayList<Company_Documents__c> strings) {

        boolean returnedProgress = false;
        int startIndex = data.size();
        for (int i = 0; i < strings.size(); i++) {
            boolean found = false;
            for (int j = 0; j < data.size(); j++) {
                if (data.get(j).getId().equals(strings.get(i).getId())) {
                    found = true;
                    break;
                }
                if (!found) {
                    data.add(strings.get(i));
                    returnedProgress = true;
                }
            }
        }
        if (returnedProgress) {
            data.addAll(startIndex, strings);
            notifyItemRangeInserted(startIndex, strings.size());
            return true;
        } else {
            return returnedProgress;
        }
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        ExpandableLayoutItem item;
        HorizontalListView horizontalServices;
        TextView tvCompanyDocumentName, tvDate, tvVersion;

        public ViewHolder(View itemView) {
            super(itemView);
            item = (ExpandableLayoutItem) itemView.findViewById(R.id.expandableLayoutItemTrueCopy);
            RelativeLayout relativeHeader = item.getHeaderLayout();
            tvCompanyDocumentName = (TextView) relativeHeader.findViewById(R.id.tvCompanyDocumentName);
            tvDate = (TextView) relativeHeader.findViewById(R.id.tvDate);
            tvVersion = (TextView) relativeHeader.findViewById(R.id.tvVersion);
            RelativeLayout relativeContent = item.getContentLayout();
            horizontalServices = (HorizontalListView) relativeContent.findViewById(R.id.horizontalServices);
        }
    }
}
