package adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import cloudconcept.dwc.R;
import custom.RoundedImageView;
import model.Visa;
import utilities.Utilities;

/**
 * Created by Abanoub Wagdy on 7/21/2015.
 */
public class NOCEmployeeListAdapter extends ClickableListAdapter {

    Context context;
    Activity act;

    public NOCEmployeeListAdapter(Activity act, Context context, int viewid, List objects) {
        super(context, viewid, objects);
        this.context = context;
        this.act = act;
    }

    @Override
    protected ViewHolder createHolder(View v) {

        TextView tvFullName, tvVisaExpiry, tvPassportNumber, tvStatus;
        RoundedImageView _smartEmployeeImage;
        tvFullName = (TextView) v.findViewById(R.id.tvFullName);
        tvVisaExpiry = (TextView) v.findViewById(R.id.tvVisaExpiry);
        tvPassportNumber = (TextView) v.findViewById(R.id.tvpassportNumber);
        tvStatus = (TextView) v.findViewById(R.id.tvStatus);
        _smartEmployeeImage = (RoundedImageView) v.findViewById(R.id.view);
        EmployeeListHolder holder = new EmployeeListHolder(tvFullName, tvVisaExpiry, tvPassportNumber, tvStatus, _smartEmployeeImage);
        return holder;
    }

    @Override
    protected void bindHolder(ViewHolder h) {

        final EmployeeListHolder mvh = (EmployeeListHolder) h;
        Visa mo = (Visa) mvh.data;

        mvh.tvFullName.setText(Utilities.stringNotNull(mo.getApplicant_Full_Name__c())); 
        mvh.tvStatus.setText(Utilities.stringNotNull(mo.getVisa_Validity_Status__c()));
        mvh.tvPassportNumber.setText(Utilities.stringNotNull(mo.getPassport_Number__c()));
        mvh.tvVisaExpiry.setText(Utilities.stringNotNull(mo.getVisa_Expiry_Date__c()));
        Utilities.setUserPhoto(act, Utilities.stringNotNull(mo.getPersonal_Photo__c()), mvh._smartEmployeeImage);
    }

    static class EmployeeListHolder extends ViewHolder {

        TextView tvFullName, tvVisaExpiry, tvPassportNumber, tvStatus;
        RoundedImageView _smartEmployeeImage;

        public EmployeeListHolder(TextView tvFullName, TextView tvVisaExpiry, TextView tvPassportNumber, TextView tvStatus, RoundedImageView i) {
            this.tvFullName = tvFullName;
            this._smartEmployeeImage = i;
            this.tvPassportNumber = tvPassportNumber;
            this.tvVisaExpiry = tvVisaExpiry;
            this.tvStatus = tvStatus;
        }
    }
}