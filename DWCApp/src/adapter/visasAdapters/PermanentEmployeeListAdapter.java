package adapter.visasAdapters;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import adapter.ClickableListAdapter;
import adapter.HorizontalListViewAdapter;
import cloudconcept.dwc.R;
import custom.CustomViewPager;
import custom.HorizontalListView;
import custom.RoundedImageView;
import custom.expandableView.ExpandableLayoutItem;
import model.ServiceItem;
import model.Visa;
import utilities.AutomaticUtilities;
import utilities.Utilities;

/**
 * Created by Abanoub on 7/2/2015.
 */
public class PermanentEmployeeListAdapter extends ClickableListAdapter {

    Context context;
    Activity act;

    public PermanentEmployeeListAdapter(Activity act, Context context, int viewid, List objects) {
        super(context, viewid, objects);
        this.context = context;
        this.act = act;
    }

    @Override
    protected ViewHolder createHolder(View v) {

        TextView tvFullName, tvVisaExpiry, tvPassportNumber, tvStatus;
        RoundedImageView _smartEmployeeImage;

        final ExpandableLayoutItem item = (ExpandableLayoutItem) v.findViewById(R.id.expandableLayoutListView);

        RelativeLayout relativeHeader = item.getHeaderLayout();
        tvFullName = (TextView) relativeHeader.findViewById(R.id.tvFullName);
        tvVisaExpiry = (TextView) relativeHeader.findViewById(R.id.tvVisaExpiry);
        tvPassportNumber = (TextView) relativeHeader.findViewById(R.id.tvpassportNumber);
        tvStatus = (TextView) relativeHeader.findViewById(R.id.tvStatus);
        _smartEmployeeImage = (RoundedImageView) relativeHeader.findViewById(R.id.view);

        RelativeLayout relativeContent = item.getContentLayout();

        HorizontalListView _horizontalServices = (HorizontalListView) relativeContent.findViewById(R.id.horizontalServices);
        VisaViewHolder mvh = new VisaViewHolder(tvFullName, tvVisaExpiry, tvPassportNumber, tvStatus, _smartEmployeeImage, item, _horizontalServices);

        return mvh;
    }

    @Override
    protected void bindHolder(ViewHolder h) {

        final VisaViewHolder mvh = (VisaViewHolder) h;
        Visa mo = (Visa) mvh.data;

        mvh.tvFullName.setText(mo.getApplicant_Full_Name__c());
        mvh.tvStatus.setText(mo.getVisa_Validity_Status__c());
        mvh.tvPassportNumber.setText(mo.getPassport_Number__c());
        mvh.tvVisaExpiry.setText(mo.getVisa_Expiry_Date__c());
        if (mo.getPersonal_Photo__c() != null && !mo.getPersonal_Photo__c().equals(""))
            Utilities.setUserPhoto(act, mo.getPersonal_Photo__c(), mvh._smartEmployeeImage);

        ArrayList<ServiceItem> _items = new ArrayList<ServiceItem>();


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date VisaDate = null;
        try {
            if (mo.getVisa_Expiry_Date__c() != null) {
                VisaDate = sdf.parse(mo.getVisa_Expiry_Date__c());
            } else {
                VisaDate = null;
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (mo.getVisa_Validity_Status__c().equals("Issued")) {

            _items.add(new ServiceItem("New NOC", R.drawable.noc_service_image));
            _items.add(new ServiceItem("Renew Passport", R.drawable.renew_license));
            if (mo.getVisa_Type__c().equals("Employment") || mo.getVisa_Type__c().equals("Transfer - Internal") || mo.getVisa_Type__c().equals("Transfer - External")) {
                _items.add(new ServiceItem("Renew Visa", R.drawable.renew_visa));
                _items.add(new ServiceItem("Cancel Visa", R.drawable.cancel_visa));
            }

        } else if (VisaDate != null) {
            if (AutomaticUtilities.daysBetween(VisaDate, System.currentTimeMillis()) < 60) {
                _items.add(new ServiceItem("Renew Visa", R.drawable.renew_visa));
            }
        }

        _items.add(new ServiceItem("Show Details", R.drawable.service_show_details));
        mvh.item.setOnClickListener(new ClickableListAdapter.OnClickListener(mvh) {

            public void onClick(View v, ViewHolder viewHolder) {
                if (viewHolder != null) {
                    VisaViewHolder myViewHolder = (VisaViewHolder) viewHolder;
                    if (!myViewHolder.item.isOpened()) {
                        myViewHolder.item.show();
                    } else {
                        myViewHolder.item.hide();
                    }
                }
            }
        });

        mvh._horizontalListView.setAdapter(new HorizontalListViewAdapter(mo,act, context, _items));
//        mvh._horizontalListView.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent event) {
//                switch (event.getAction()) {
//                    case MotionEvent.ACTION_MOVE:
//                        view.getParent().requestDisallowInterceptTouchEvent(true);
//                        break;
//                    case MotionEvent.ACTION_UP:
//                    case MotionEvent.ACTION_CANCEL:
//                        view.getParent().requestDisallowInterceptTouchEvent(false);
//                        break;
//                }
//                return false;
//            }
//        });
    }

    static class VisaViewHolder extends ViewHolder {

        TextView tvFullName, tvVisaExpiry, tvPassportNumber, tvStatus;
        RoundedImageView _smartEmployeeImage;
        ExpandableLayoutItem item;
        HorizontalListView _horizontalListView;

        public VisaViewHolder(TextView tvFullName, TextView tvVisaExpiry, TextView tvPassportNumber, TextView tvStatus, RoundedImageView i, ExpandableLayoutItem item, HorizontalListView _horizontalListView) {
            this.tvFullName = tvFullName;
            this._smartEmployeeImage = i;
            this.tvPassportNumber = tvPassportNumber;
            this.tvVisaExpiry = tvVisaExpiry;
            this.tvStatus = tvStatus;
            this.item = item;
            this._horizontalListView = _horizontalListView;
        }
    }
}