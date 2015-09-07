package adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import cloudconcept.dwc.R;
import custom.SmartRoundedImageView;
import model.LegalRepresentative;

/**
 * Created by Abanoub on 7/7/2015.
 */
public class LegalRepresentativesAdapter extends ClickableListAdapter {

    public LegalRepresentativesAdapter(Context context, int viewid, List objects) {
        super(context, viewid, objects);
    }

    @Override
    protected ViewHolder createHolder(View v) {

        TextView tvFullName, tvNationality, tvPassportNumber, tvRole, tvStartDate;
        SmartRoundedImageView _smartEmployeeImage;

        tvFullName = (TextView) v.findViewById(R.id.tvFullName);
        tvNationality = (TextView) v.findViewById(R.id.tvNationality);
        tvPassportNumber = (TextView) v.findViewById(R.id.tvpassportNumber);
        tvRole = (TextView) v.findViewById(R.id.tvRole);
        tvStartDate = (TextView) v.findViewById(R.id.tvStartDate);
        _smartEmployeeImage = (SmartRoundedImageView) v.findViewById(R.id.view);
        LegalRepresentativeViewHolder holder = new LegalRepresentativeViewHolder(tvFullName, tvNationality, tvPassportNumber, tvRole, tvStartDate, _smartEmployeeImage);
        return holder;
    }

    @Override
    protected void bindHolder(ViewHolder h) {
        LegalRepresentativeViewHolder holder = (LegalRepresentativeViewHolder) h;
        LegalRepresentative legalRepresentative = (LegalRepresentative) holder.data;
        holder.tvFullName.setText(legalRepresentative.getLegalRepresentativeLookup().getName() == null ? "" : legalRepresentative.getLegalRepresentativeLookup().getName());
        holder.tvNationality.setText(legalRepresentative.getLegalRepresentativeLookup().getNationality() == null ? "" : legalRepresentative.getLegalRepresentativeLookup().getNationality());
        holder.tvPassportNumber.setText(legalRepresentative.getLegalRepresentativeLookup().getCurrentPassport() == null ? "" : legalRepresentative.getLegalRepresentativeLookup().getCurrentPassport().getName());
        holder.tvRole.setText(legalRepresentative.getRole() == null ? "" : legalRepresentative.getRole());
        holder.tvStartDate.setText(legalRepresentative.getLegal_Representative_Start_Date() == null ? "" : legalRepresentative.getLegal_Representative_Start_Date());
    }

    static class LegalRepresentativeViewHolder extends ViewHolder {

        TextView tvFullName, tvNationality, tvPassportNumber, tvRole, tvStartDate;
        SmartRoundedImageView _smartEmployeeImage;

        public LegalRepresentativeViewHolder(TextView tvFullName, TextView tvNationality, TextView tvPassportNumber, TextView tvRole, TextView tvStartDate, SmartRoundedImageView smartEmployeeImage) {
            this.tvFullName = tvFullName;
            this.tvNationality = tvNationality;
            this.tvPassportNumber = tvPassportNumber;
            this.tvRole = tvRole;
            this.tvStartDate = tvStartDate;
        }
    }
}
