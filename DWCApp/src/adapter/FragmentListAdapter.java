package adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import cloudconcept.dwc.R;
import custom.HorizontalListView;
import custom.SmartImageView;
import custom.expandableView.ExpandableLayoutItem;
import fragment.visasAndCards.PermanentEmployeeFragment;
import model.ServiceItem;
import model.Visa;

/**
 * Created by Abanoub on 6/25/2015.
 */
public class FragmentListAdapter extends BaseAdapter {

    private Activity activity;
    public ArrayList<Visa> _visas;
    Fragment _fragment;
    Context context;

    public FragmentListAdapter(Activity act, Context context, PermanentEmployeeFragment fragment, ArrayList<Visa> visas) {
        this._fragment = fragment;
        this._visas = visas;
        this.context = context;
        this.activity = act;
    }

    @Override
    public int getCount() {
        return _visas.size();
    }

    @Override
    public Object getItem(int position) {
        return _visas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public synchronized View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            TextView tvFullName, tvVisaExpiry, tvPassportNumber, tvStatus;
            SmartImageView _smartEmployeeImage;
            LayoutInflater mInflater = (LayoutInflater)
                    context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.item_row_permanent_employee, null);
            final ExpandableLayoutItem item = (ExpandableLayoutItem) convertView.findViewById(R.id.expandableLayoutListView);
            RelativeLayout relativeHeader = item.getHeaderLayout();
            tvFullName = (TextView) relativeHeader.findViewById(R.id.tvFullName);
            tvVisaExpiry = (TextView) relativeHeader.findViewById(R.id.tvVisaExpiry);
            tvPassportNumber = (TextView) relativeHeader.findViewById(R.id.tvpassportNumber);
            tvStatus = (TextView) relativeHeader.findViewById(R.id.tvStatus);
            _smartEmployeeImage = (SmartImageView) relativeHeader.findViewById(R.id.view);
            tvFullName.setText(_visas.get(position).getApplicant_Full_Name__c());
            tvStatus.setText(_visas.get(position).getVisa_Validity_Status__c());
            tvPassportNumber.setText(_visas.get(position).getPassport_Number__c());
            tvVisaExpiry.setText(_visas.get(position).getVisa_Expiry_Date__c());


            RelativeLayout relativeContent = item.getContentLayout();
            HorizontalListView _horizontalServices = (HorizontalListView) relativeContent.findViewById(R.id.horizontalServices);
            ArrayList<ServiceItem> _items = new ArrayList<ServiceItem>();

            if (_visas.get(position).getVisa_Validity_Status__c().equals("Issued")) {
                _items.add(new ServiceItem("New NOC", R.drawable.noc_service_image));
            }

            _items.add(new ServiceItem("Show Details", R.drawable.service_show_details));

            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!item.isOpened()) {
                        item.show();
                    } else {
                        item.hide();
                    }
                }
            });
            _horizontalServices.setAdapter(new HorizontalListViewAdapter(_visas.get(position), activity, context, _items));
        }
        return convertView;
    }
}