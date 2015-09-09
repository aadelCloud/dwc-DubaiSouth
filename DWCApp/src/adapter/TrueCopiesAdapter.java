package adapter;

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
import model.EServices_Document_Checklist__c;
import model.ServiceItem;
import utilities.Utilities;

/**
 * Created by Abanoub Wagdy on 9/9/2015.
 */
public class TrueCopiesAdapter extends RecyclerView.Adapter<TrueCopiesAdapter.ViewHolder> {

    public ArrayList<EServices_Document_Checklist__c> data;
    Context context;

    public TrueCopiesAdapter(Context context, ArrayList<EServices_Document_Checklist__c> data) {
        this.data = data;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.true_copies_item_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.tvTrueCopyName.setText(Utilities.stringNotNull(data.get(position).getName()));

        ArrayList<ServiceItem> _items = new ArrayList<>();
        if (data.get(position).getAvailable_for_Preview__c()) {
            _items.add(new ServiceItem("Preview", R.drawable.preview));
        }

        if (data.get(position).getOriginal_can_be_Requested__c()) {
            _items.add(new ServiceItem("Request True Copy", R.drawable.copy));
        }

        holder.horizontalServices.setAdapter(new HorizontalListViewAdapter(data.get(position), context, _items));

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

    public void add(EServices_Document_Checklist__c string) {
        insert(string, data.size());
    }

    public void insert(EServices_Document_Checklist__c string, int position) {
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

    public boolean addAll(ArrayList<EServices_Document_Checklist__c> strings) {

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
        TextView tvTrueCopyName;

        public ViewHolder(View itemView) {
            super(itemView);
            item = (ExpandableLayoutItem) itemView.findViewById(R.id.expandableLayoutItemTrueCopy);
            RelativeLayout relativeHeader = item.getHeaderLayout();
            tvTrueCopyName = (TextView) relativeHeader.findViewById(R.id.tvTrueCopyName);
            RelativeLayout relativeContent = item.getContentLayout();
            horizontalServices = (HorizontalListView) relativeContent.findViewById(R.id.horizontalServices);
        }
    }
}
