package adapter;

import android.app.Activity;
import android.app.Service;
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
import model.ShareOwnership;
import utilities.Utilities;

/**
 * Created by Abanoub on 7/7/2015.
 */
public class ShareHolderAdapter extends ClickableListAdapter {

    private final Activity activity;
    Context context;
    ArrayList objects;

    public ShareHolderAdapter(Activity activity, Context context, int viewid, List objects) {
        super(context, viewid, objects);
        this.activity = activity;
        this.context = context;
        this.objects= (ArrayList) objects;
    }

    @Override
    protected ViewHolder createHolder(View v) {

        TextView tvFullName, tvNationality, tvPassportNumber, tvOwnerShip, tvNumberOfShares, tvStartDate;
        RoundedImageView _smartEmployeeImage;


        final ExpandableLayoutItem item = (ExpandableLayoutItem) v.findViewById(R.id.expandableLayoutListView);
        RelativeLayout relativeHeader = item.getHeaderLayout();

        tvFullName = (TextView) relativeHeader.findViewById(R.id.tvFullName);
        tvNationality = (TextView) relativeHeader.findViewById(R.id.tvNationality);
        tvPassportNumber = (TextView) relativeHeader.findViewById(R.id.tvpassportNumber);
        tvOwnerShip = (TextView) relativeHeader.findViewById(R.id.tvOwnership);
        tvNumberOfShares = (TextView) relativeHeader.findViewById(R.id.tvNumberOfShares);
        tvStartDate = (TextView) relativeHeader.findViewById(R.id.tvStartDate);
        _smartEmployeeImage = (RoundedImageView) v.findViewById(R.id.view);

        RelativeLayout relativeContent = item.getContentLayout();
        HorizontalListView _horizontalServices = (HorizontalListView) relativeContent.findViewById(R.id.horizontalServices);

        ShareHoldersViewHolder holder = new ShareHoldersViewHolder(tvFullName, tvNationality, tvPassportNumber, tvOwnerShip, tvNumberOfShares, tvStartDate, _smartEmployeeImage,item,_horizontalServices);
        return holder;
    }

    @Override
    protected void bindHolder(ViewHolder h) {

        ShareHoldersViewHolder holder = (ShareHoldersViewHolder) h;
        ShareOwnership _ShareHolder = (ShareOwnership) holder.data;
        holder.tvFullName.setText(_ShareHolder.get_shareholder().getName() == null ? "" : _ShareHolder.get_shareholder().getName());
        holder.tvNationality.setText(_ShareHolder.get_shareholder().getNationality() == null ? "" : _ShareHolder.get_shareholder().getNationality());
        holder.tvPassportNumber.setText(_ShareHolder.get_shareholder().get_currentPassport() == null ? "" : _ShareHolder.get_shareholder().get_currentPassport().getName());
        holder.tvOwnerShip.setText(_ShareHolder.getOwnership_of_Share__c() == null ? "" : _ShareHolder.getOwnership_of_Share__c());
        holder.tvNumberOfShares.setText(_ShareHolder.getNo_of_Shares__c() == null ? "" : _ShareHolder.getNo_of_Shares__c());
        holder.tvStartDate.setText(_ShareHolder.getOwnership_Start_Date__c() == null ? "" : _ShareHolder.getOwnership_Start_Date__c());
        Utilities.setUserPhoto(activity, Utilities.stringNotNull(_ShareHolder.get_shareholder().getPersonalPhoto()), holder._smartEmployeeImage);

        holder.item.setOnClickListener(new OnClickListener(holder) {

            public void onClick(View v, ViewHolder viewHolder) {
                if (viewHolder != null) {
                    ShareHoldersViewHolder myViewHolder = (ShareHoldersViewHolder) viewHolder;
                    if (!myViewHolder.item.isOpened()) {
                        myViewHolder.item.show();
                    } else {
                        myViewHolder.item.hide();
                    }
                }
            }
        });

        ArrayList<ServiceItem> _items = new ArrayList<ServiceItem>();
        _items.add(new ServiceItem("Share Holder", R.drawable.renew_visa, objects));
        _items.add(new ServiceItem("Show Details", R.drawable.service_show_details));
        holder._horizontalListView.setAdapter(new HorizontalListViewAdapter(_ShareHolder,activity, context, _items));

    }

    static class ShareHoldersViewHolder extends ViewHolder {

        TextView tvFullName, tvNationality, tvPassportNumber, tvOwnerShip, tvNumberOfShares, tvStartDate;
        RoundedImageView _smartEmployeeImage;
        ExpandableLayoutItem item;
        HorizontalListView _horizontalListView;

        public ShareHoldersViewHolder(TextView tvFullName, TextView tvNationality, TextView tvPassportNumber, TextView tvOwnerShip, TextView tvNumberOfShares, TextView tvStartDate, RoundedImageView _smartEmployeeImage, ExpandableLayoutItem item, HorizontalListView _horizontalListView) {
            this.tvFullName = tvFullName;
            this.tvNationality = tvNationality;
            this.tvPassportNumber = tvPassportNumber;
            this.tvOwnerShip = tvOwnerShip;
            this.tvNumberOfShares = tvNumberOfShares;
            this.tvStartDate = tvStartDate;
            this._smartEmployeeImage = _smartEmployeeImage;
            this.item = item;
            this._horizontalListView = _horizontalListView;
        }
    }
}
