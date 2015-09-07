package adapter;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.List;

import cloudconcept.dwc.R;
import fragment.ViewStatementFragment;
import model.FreeZonePayment;
import utilities.Utilities;

/**
 * Created by Abanoub Wagdy on 9/6/2015.
 */
public class ViewStatementAdapter extends ArrayAdapter<FreeZonePayment> {

    private int mLayoutResourceId;
    private int mCount;

    public ViewStatementAdapter(Context context, int layoutResourceId, List<FreeZonePayment> objects) {
        super(context, layoutResourceId, objects);
        mLayoutResourceId = layoutResourceId;
        mCount = objects.size();
    }


    @Override
    public int getCount() {
        return mCount;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        FreeZonePayment item = (FreeZonePayment) getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(mLayoutResourceId, parent, false);
            holder = new ViewHolder();
            holder.tvEmployeeName = (TextView) convertView.findViewById(R.id.tvEmployeeName);
            holder.tvDate = (TextView) convertView.findViewById(R.id.tvDate);
            holder.tvAmount = (TextView) convertView.findViewById(R.id.tvAmount);
            holder.tvBalance = (TextView) convertView.findViewById(R.id.tvBalance);
            holder.tvStatus = (TextView) convertView.findViewById(R.id.tvStatus);
            holder.imageStatusDebitCredit = (ImageView) convertView.findViewById(R.id.imageStatusDebitCredit);

            holder.tvEmployeeNameLabel = (TextView) convertView.findViewById(R.id.tvEmployeeNameLabel);
            holder.tvDateLabel = (TextView) convertView.findViewById(R.id.tvDateLabel);
            holder.tvAmountLabel = (TextView) convertView.findViewById(R.id.tvAmountLabel);
            holder.tvBalanceLabel = (TextView) convertView.findViewById(R.id.tvBalanceLabel);
            holder.tvStatusLabel = (TextView) convertView.findViewById(R.id.tvStatusLabel);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        if (item.getName() != null && !item.getName().equals("")) {
            holder.tvEmployeeName.setText(item.getEmployeeName());
        } else {
            holder.tvEmployeeName.setVisibility(View.GONE);
            holder.tvEmployeeNameLabel.setVisibility(View.GONE);
        }

        holder.tvStatus.setText(Utilities.stringNotNull(item.getStatus()));

        if (item.getEffectOnAccount().equals("Debit")) {
            holder.tvAmount.setText(Utilities.stringNotNull(item.getDebitAmount()) + " AED.");
            holder.imageStatusDebitCredit.setBackgroundResource(R.drawable.payment_debit);
            holder.tvBalance.setVisibility(View.GONE);
            holder.tvBalanceLabel.setVisibility(View.GONE);
        } else {
            holder.tvAmount.setText(Utilities.stringNotNull(item.getCreditAmount()));
            holder.imageStatusDebitCredit.setBackgroundResource(R.drawable.payment_credit);
            holder.tvBalance.setText(Utilities.stringNotNull(item.getClosingBalance()));
        }

        holder.tvDate.setText(!Utilities.stringNotNull(item.getCreatedDate()).equals("") ? Utilities.stringNotNull(item.getCreatedDate()).substring(0, 10) : "");

        return convertView;
    }

    private class ViewHolder {
        private ImageView imageStatusDebitCredit;
        private TextView tvEmployeeName;
        private TextView tvDate;
        private TextView tvAmount;
        private TextView tvBalance;
        private TextView tvStatus;

        private TextView tvEmployeeNameLabel;
        private TextView tvDateLabel;
        private TextView tvAmountLabel;
        private TextView tvBalanceLabel;
        private TextView tvStatusLabel;
    }
}
