package adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import cloudconcept.dwc.R;
import model.MyRequest;
import utilities.Utilities;

/**
 * Created by Bibo on 7/26/2015.
 */
public class MyRequestsAdapter extends ClickableListAdapter {

    Context context;
    Activity act;
    String[] status_filter;
    String[] services;

    public MyRequestsAdapter(Activity act, Context context, int viewid, ArrayList<MyRequest> myRequests) {
        super(context, viewid, myRequests);
        this.context = context;
        this.act = act;
        services = new String[]{"Visa Services", "NOC Services", "License Services", "Access Cards Services", "Registration Services", "Leasing Services"};
        status_filter = new String[]{"Completed", "In Process", "Ready for collection", "Not Submitted", "Application Submitted", "Draft"};
    }

    @Override
    protected ViewHolder createHolder(View v) {
        TextView tvRefNumber, tvDate, tvRequestType, tvService, tvPersonName, tvCurrentStatus, tvPersonNameLabel;
        ImageView imageView, bulletStatus;
        tvRefNumber = (TextView) v.findViewById(R.id.tvRefNumber);
        tvDate = (TextView) v.findViewById(R.id.tvDate);
        tvRequestType = (TextView) v.findViewById(R.id.tvRequestType);
        tvService = (TextView) v.findViewById(R.id.tvService);
        tvPersonName = (TextView) v.findViewById(R.id.tvPersonName);
        tvCurrentStatus = (TextView) v.findViewById(R.id.tvCurrentStatus);
        tvPersonNameLabel = (TextView) v.findViewById(R.id.tvPersonNameLabel);
        imageView = (ImageView) v.findViewById(R.id.view);
        bulletStatus = (ImageView) v.findViewById(R.id.bulletStatus);
        MyRequestsViewHolder holder = new MyRequestsViewHolder(tvRefNumber, tvDate, tvRequestType, tvService, tvPersonName, tvCurrentStatus, tvPersonNameLabel, imageView, bulletStatus);
        return holder;
    }

    @Override
    protected void bindHolder(ViewHolder h) {

        final MyRequestsViewHolder mvh = (MyRequestsViewHolder) h;
        MyRequest myRequest = (MyRequest) mvh.data;

        mvh.tvRefNumber.setText(Utilities.stringNotNull(myRequest.getCaseNumber()));
        mvh.tvDate.setText(Utilities.stringNotNull(myRequest.getCreatedDate()));
        mvh.tvRequestType.setText(Utilities.stringNotNull(myRequest.getType()));
        mvh.tvService.setText(Utilities.stringNotNull(myRequest.getSub_Type()).equals("") ? Utilities.stringNotNull(myRequest.getSub_Type_Formula()) : Utilities.stringNotNull(myRequest.getSub_Type()));
        if (myRequest.getEmployee_Ref() == null) {
            mvh.tvPersonName.setVisibility(View.GONE);
            mvh.tvPersonNameLabel.setVisibility(View.GONE);
        } else {
            mvh.tvPersonName.setText(myRequest.getEmployee_Ref().getName());
        }

        mvh.tvCurrentStatus.setText(myRequest.getStatus());

        if (myRequest.getType().equals(services[0])) {
            mvh.imageMyRequest.setImageDrawable(act.getResources().getDrawable(R.drawable.notification_visa));
        } else if (myRequest.getType().equals(services[1])) {
            mvh.imageMyRequest.setImageDrawable(act.getResources().getDrawable(R.drawable.notification_noc));
        } else if (myRequest.getType().equals(services[2])) {
            mvh.imageMyRequest.setImageDrawable(act.getResources().getDrawable(R.drawable.renew_license));
        } else if (myRequest.getType().equals(services[3])) {
            mvh.imageMyRequest.setImageDrawable(act.getResources().getDrawable(R.drawable.notification_license));
        } else if (myRequest.getType().equals(services[4])) {
            mvh.imageMyRequest.setImageDrawable(act.getResources().getDrawable(R.drawable.notification_registration));
        } else if (myRequest.getType().equals(services[5])) {
            mvh.imageMyRequest.setImageDrawable(act.getResources().getDrawable(R.drawable.notification_leasing));
        }

        if (myRequest.getStatus().equals(status_filter[0])) {
            mvh.bulletStatus.setImageDrawable(act.getResources().getDrawable(R.drawable.bullet_green));
        } else if (myRequest.getStatus().equals(status_filter[1]) || myRequest.getStatus().equals(status_filter[5])) {
            mvh.bulletStatus.setImageDrawable(act.getResources().getDrawable(R.drawable.bullet_yellow));
        } else if (myRequest.getStatus().equals(status_filter[2])) {
            mvh.bulletStatus.setImageDrawable(act.getResources().getDrawable(R.drawable.bullet_blue));
        } else if (myRequest.getStatus().equals(status_filter[3]) || myRequest.getStatus().equals(status_filter[4])) {
            mvh.bulletStatus.setImageDrawable(act.getResources().getDrawable(R.drawable.bullet_red));
        }
    }

    static class MyRequestsViewHolder extends ViewHolder {

        TextView tvRefNumber, tvDate, tvRequestType, tvService, tvPersonName, tvCurrentStatus, tvPersonNameLabel;
        ImageView imageMyRequest, bulletStatus;

        public MyRequestsViewHolder(TextView tvRefNumber, TextView tvDate, TextView tvRequestType, TextView tvService, TextView tvPersonName, TextView tvCurrentStatus, TextView tvPersonNameLabel, ImageView imageView, ImageView bulletStatus) {
            this.tvRefNumber = tvRefNumber;
            this.tvDate = tvDate;
            this.tvRequestType = tvRequestType;
            this.tvService = tvService;
            this.tvPersonName = tvPersonName;
            this.tvCurrentStatus = tvCurrentStatus;
            this.tvPersonNameLabel = tvPersonNameLabel;
            this.imageMyRequest = imageView;
            this.bulletStatus = bulletStatus;
        }
    }
}
