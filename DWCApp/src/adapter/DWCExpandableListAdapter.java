package adapter;

import android.app.Activity;
import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import cloudconcept.dwc.R;
import custom.HorizontalListView;
import custom.RoundedImageView;
import model.ServiceItem;
import model.Visa;
import utilities.Utilities;

/**
 * Created by Bibo on 8/4/2015.
 */
public class DWCExpandableListAdapter extends BaseExpandableListAdapter {

    private LayoutInflater mInflater;
    Context context;
    ArrayList<Object> parent;
    int parentlayoutResourceId;
    String classname;
    ArrayList<Visa> _visas;
    Activity act;

    public DWCExpandableListAdapter(String classname, Context context, Activity act, Object parent) {
        mInflater = (LayoutInflater)
                context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        this.context = context;
        this.act = act;
        this.classname = classname;
        if (classname.equals("PermanentEmployeeFragment")) {
            _visas = (ArrayList<Visa>) parent;
            this.parentlayoutResourceId = R.layout.view_header;
        }
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getGroupCount() {
        return parent.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return parent.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return parent.get(groupPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        if (convertView == null)
            convertView = mInflater.inflate(parentlayoutResourceId, null);

        if (classname.equals("PermanentEmployeeFragment")) {
            TextView tvFullName, tvVisaExpiry, tvPassportNumber, tvStatus;
            RoundedImageView _smartEmployeeImage;
            tvFullName = (TextView) convertView.findViewById(R.id.tvFullName);
            tvVisaExpiry = (TextView) convertView.findViewById(R.id.tvVisaExpiry);
            tvPassportNumber = (TextView) convertView.findViewById(R.id.tvpassportNumber);
            tvStatus = (TextView) convertView.findViewById(R.id.tvStatus);
            _smartEmployeeImage = (RoundedImageView) convertView.findViewById(R.id.view);

            tvFullName.setText(_visas.get(groupPosition).getApplicant_Full_Name__c());
            tvStatus.setText(_visas.get(groupPosition).getVisa_Validity_Status__c());
            tvPassportNumber.setText(_visas.get(groupPosition).getPassport_Number__c());
            tvVisaExpiry.setText(_visas.get(groupPosition).getVisa_Expiry_Date__c());
            Utilities.setUserPhoto(act, _visas.get(groupPosition).getPersonal_Photo__c(), _smartEmployeeImage);
        }
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.view_content, null);
        }

        ArrayList<ServiceItem> _items = new ArrayList<ServiceItem>();
        HorizontalListView _horizontalServices = (HorizontalListView) convertView.findViewById(R.id.horizontalServices);
        if (classname.equals("PermanentEmployeeFragment")) {
            if (_visas.get(groupPosition).getVisa_Validity_Status__c().equals("Issued")) {
                _items.add(new ServiceItem("New NOC", R.drawable.noc_service_image));
            }

            _items.add(new ServiceItem("Show Details", R.drawable.service_show_details));
            _horizontalServices.setAdapter(new HorizontalListViewAdapter(_visas.get(groupPosition),act, context, _items));
        }

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return true;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void onGroupExpanded(int groupPosition) {

    }

    @Override
    public void onGroupCollapsed(int groupPosition) {

    }

    @Override
    public long getCombinedChildId(long groupId, long childId) {
        return 0;
    }

    @Override
    public long getCombinedGroupId(long groupId) {
        return 0;
    }
}