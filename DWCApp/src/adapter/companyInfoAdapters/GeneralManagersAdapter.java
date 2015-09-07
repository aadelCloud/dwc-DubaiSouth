package adapter.companyInfoAdapters;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import adapter.ClickableListAdapter;
import cloudconcept.dwc.R;
import custom.RoundedImageView;
import model.ManagementMember;
import utilities.Utilities;

/**
 * Created by Abanoub on 7/7/2015.
 */
public class GeneralManagersAdapter extends ClickableListAdapter {

    private final Activity activity;

    public GeneralManagersAdapter(Activity activity, Context context, int viewid, List objects) {
        super(context, viewid, objects);
        this.activity = activity;
    }

    @Override
    protected ViewHolder createHolder(View v) {

        TextView tvFullName, tvNationality, tvPassportNumber, tvRole, tvStartDate;
        RoundedImageView _smartEmployeeImage;

        tvFullName = (TextView) v.findViewById(R.id.tvFullName);
        tvNationality = (TextView) v.findViewById(R.id.tvNationality);
        tvPassportNumber = (TextView) v.findViewById(R.id.tvpassportNumber);
        tvRole = (TextView) v.findViewById(R.id.tvRole);
        tvStartDate = (TextView) v.findViewById(R.id.tvStartDate);
        _smartEmployeeImage = (RoundedImageView) v.findViewById(R.id.view);
        GeneralManagerViewHolder holder = new GeneralManagerViewHolder(tvFullName, tvNationality, tvPassportNumber, tvRole, tvStartDate, _smartEmployeeImage);
        return holder;
    }

    @Override
    protected void bindHolder(ViewHolder h) {

        GeneralManagerViewHolder holder = (GeneralManagerViewHolder) h;
        ManagementMember managementMember = (ManagementMember) holder.data;
        holder.tvFullName.setText(managementMember.get_manager().getName() == null ? "" : managementMember.get_manager().getName());
        holder.tvNationality.setText(managementMember.get_manager().getNationality() == null ? "" : managementMember.get_manager().getNationality());
        holder.tvPassportNumber.setText(managementMember.get_manager().getCurrentPassport() == null ? "" : managementMember.get_manager().getCurrentPassport().getName());
        holder.tvRole.setText(managementMember.getRole() == null ? "" : managementMember.getRole());
        holder.tvStartDate.setText(managementMember.getManager_Start_Date() == null ? "" : managementMember.getManager_Start_Date());
        Utilities.setUserPhoto(activity, Utilities.stringNotNull(managementMember.get_manager().getPersonal_Photo()), holder._smartEmployeeImage);
    }

    static class GeneralManagerViewHolder extends ViewHolder {

        TextView tvFullName, tvNationality, tvPassportNumber, tvRole, tvStartDate;
        RoundedImageView _smartEmployeeImage;

        public GeneralManagerViewHolder(TextView tvFullName, TextView tvNationality, TextView tvPassportNumber, TextView tvRole, TextView tvStartDate, RoundedImageView smartEmployeeImage) {
            this.tvFullName = tvFullName;
            this.tvNationality = tvNationality;
            this.tvPassportNumber = tvPassportNumber;
            this.tvRole = tvRole;
            this.tvStartDate = tvStartDate;
            this._smartEmployeeImage = smartEmployeeImage;
        }
    }
}

