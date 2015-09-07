package adapter.companyInfoAdapters;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import adapter.ClickableListAdapter;
import cloudconcept.dwc.R;
import custom.RoundedImageView;
import model.ShareOwnership;
import utilities.Utilities;

/**
 * Created by Abanoub on 7/7/2015.
 */
public class ShareHolderAdapter extends ClickableListAdapter {

    private final Activity activity;

    public ShareHolderAdapter(Activity activity, Context context, int viewid, List objects) {
        super(context, viewid, objects);
        this.activity = activity;
    }

    @Override
    protected ViewHolder createHolder(View v) {

        TextView tvFullName, tvNationality, tvPassportNumber, tvOwnerShip, tvNumberOfShares, tvStartDate;
        RoundedImageView _smartEmployeeImage;
        tvFullName = (TextView) v.findViewById(R.id.tvFullName);
        tvNationality = (TextView) v.findViewById(R.id.tvNationality);
        tvPassportNumber = (TextView) v.findViewById(R.id.tvpassportNumber);
        tvOwnerShip = (TextView) v.findViewById(R.id.tvOwnership);
        tvNumberOfShares = (TextView) v.findViewById(R.id.tvNumberOfShares);
        tvStartDate = (TextView) v.findViewById(R.id.tvStartDate);
        _smartEmployeeImage = (RoundedImageView) v.findViewById(R.id.view);
        ShareHoldersViewHolder holder = new ShareHoldersViewHolder(tvFullName, tvNationality, tvPassportNumber, tvOwnerShip, tvNumberOfShares, tvStartDate, _smartEmployeeImage);
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
    }

    static class ShareHoldersViewHolder extends ViewHolder {

        TextView tvFullName, tvNationality, tvPassportNumber, tvOwnerShip, tvNumberOfShares, tvStartDate;
        RoundedImageView _smartEmployeeImage;

        public ShareHoldersViewHolder(TextView tvFullName, TextView tvNationality, TextView tvPassportNumber, TextView tvOwnerShip, TextView tvNumberOfShares, TextView tvStartDate, RoundedImageView smartRoundedImageView) {
            this.tvFullName = tvFullName;
            this.tvNationality = tvNationality;
            this.tvPassportNumber = tvPassportNumber;
            this.tvOwnerShip = tvOwnerShip;
            this.tvNumberOfShares = tvNumberOfShares;
            this.tvStartDate = tvStartDate;
            this._smartEmployeeImage = smartRoundedImageView;
        }
    }
}
