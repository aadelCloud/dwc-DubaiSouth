package adapter.visasAdapters;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import adapter.ClickableListAdapter;
import adapter.HorizontalListViewAdapter;
import cloudconcept.dwc.R;
import custom.HorizontalListView;
import custom.RoundedImageView;
import custom.expandableView.ExpandableLayoutItem;
import model.ServiceItem;
import model.Visa;
import utilities.Utilities;

/**
 * Created by Abanoub on 7/2/2015.
 */
public class MyVisitVisaAdapter extends ClickableListAdapter {

    private final Activity activity;
    Context context;

    public MyVisitVisaAdapter(Activity activity, Context context, int viewid, List objects) {
        super(context, viewid, objects);
        this.context = context;
        this.activity = activity;
    }

    @Override
    protected ViewHolder createHolder(View v) {
        TextView tvFullName, tvVisaExpiry, tvPassportNumber, tvStatus, textView10;
        RoundedImageView _smartEmployeeImage;

        final ExpandableLayoutItem item = (ExpandableLayoutItem) v.findViewById(R.id.expandableLayoutListView);
        RelativeLayout relativeHeader = item.getHeaderLayout();
        tvFullName = (TextView) relativeHeader.findViewById(R.id.tvFullName);
        tvVisaExpiry = (TextView) relativeHeader.findViewById(R.id.tvCardExpiry);
        tvPassportNumber = (TextView) relativeHeader.findViewById(R.id.tvpassportNumber);
        tvStatus = (TextView) relativeHeader.findViewById(R.id.tvStatus);
        textView10 = (TextView) relativeHeader.findViewById(R.id.textView10);
        _smartEmployeeImage = (RoundedImageView) relativeHeader.findViewById(R.id.view);
        RelativeLayout relativeContent = item.getContentLayout();
        HorizontalListView _horizontalServices = (HorizontalListView) relativeContent.findViewById(R.id.horizontalServices);
        VisitVisaViewHolder holder = new VisitVisaViewHolder(tvFullName, tvPassportNumber, tvStatus, textView10, tvVisaExpiry, _smartEmployeeImage, item, _horizontalServices);
        return holder;
    }

    @Override
    protected void bindHolder(ViewHolder h) {
        final VisitVisaViewHolder mvh = (VisitVisaViewHolder) h;
        Visa mo = (Visa) mvh.data;

        mvh.tvFullName.setText(mo.getApplicant_Full_Name__c());
        mvh.tvStatus.setText(mo.getVisa_Validity_Status__c());
        mvh.tvPassportNumber.setText(mo.getPassport_Number__c());
        ArrayList<ServiceItem> _items = new ArrayList<ServiceItem>();

        if (mo.getVisa_Validity_Status__c().equals("Issued") || mo.getVisa_Validity_Status__c().equals("Expired")) {
            mvh.tvVisaExpiry.setText(mo.getVisa_Validity_Status__c());
        } else {
            mvh.textView10.setVisibility(View.GONE);
            mvh.tvVisaExpiry.setVisibility(View.GONE);
        }

        if (mo.getPersonal_Photo__c() != null && !mo.getPersonal_Photo__c().equals(""))
            Utilities.setUserPhoto(activity, mo.getPersonal_Photo__c(), mvh._smartEmployeeImage);

        _items.add(new ServiceItem("Show Details", R.drawable.service_show_details));

        mvh.item.setOnClickListener(new ClickableListAdapter.OnClickListener(mvh) {

            public void onClick(View v, ViewHolder viewHolder) {
                if (viewHolder != null) {
                    VisitVisaViewHolder myViewHolder = (VisitVisaViewHolder) viewHolder;
                    if (!myViewHolder.item.isOpened()) {
                        myViewHolder.item.show();
                    } else {
                        myViewHolder.item.hide();
                    }
                }
            }
        });
        mvh._horizontalListView.setAdapter(new HorizontalListViewAdapter(mo, context, _items));
    }

    static class VisitVisaViewHolder extends ViewHolder {

        TextView tvFullName, tvVisaExpiry, tvPassportNumber, tvStatus, textView10;
        RoundedImageView _smartEmployeeImage;
        ExpandableLayoutItem item;
        HorizontalListView _horizontalListView;

        public VisitVisaViewHolder(TextView tvFullName, TextView tvPassportNumber, TextView tvStatus, TextView textView10, TextView tvCardExpiry, RoundedImageView i, ExpandableLayoutItem item, HorizontalListView _horizontalListView) {
            this.tvFullName = tvFullName;
            this.tvPassportNumber = tvPassportNumber;
            this.tvStatus = tvStatus;
            this.tvVisaExpiry = tvCardExpiry;
            this.textView10 = textView10;
            this._smartEmployeeImage = i;
            this.item = item;
            this._horizontalListView = _horizontalListView;
        }
    }
}
