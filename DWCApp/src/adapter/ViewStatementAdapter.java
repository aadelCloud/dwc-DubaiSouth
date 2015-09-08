package adapter;

import android.content.Context;
import android.database.DataSetObserver;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cloudconcept.dwc.R;
import fragment.ViewStatementFragment;
import model.FreeZonePayment;
import utilities.ActivitiesLauncher;
import utilities.Utilities;

/**
 * Created by Abanoub Wagdy on 9/6/2015.
 */
public class ViewStatementAdapter extends RecyclerView.Adapter<ViewStatementAdapter.ViewHolder> {


    public ArrayList<FreeZonePayment> data;
    Context context;

    public ViewStatementAdapter(Context context, ArrayList<FreeZonePayment> data) {
        this.data = data;
        this.context = context;
    }

    @Override
    public ViewStatementAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_statement_item_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewStatementAdapter.ViewHolder holder, int position) {
        if (data.get(position).getName() != null && !data.get(position).getName().equals("")) {
            holder.tvEmployeeName.setText(data.get(position).getEmployeeName());
        } else {
            holder.tvEmployeeName.setVisibility(View.GONE);
            holder.tvEmployeeNameLabel.setVisibility(View.GONE);
        }

        holder.tvStatus.setText(Utilities.stringNotNull(data.get(position).getStatus()));

        if (data.get(position).getEffectOnAccount().equals("Debit")) {
            holder.tvAmount.setText(Utilities.stringNotNull(data.get(position).getDebitAmount()) + " AED.");
            holder.imageStatusDebitCredit.setBackgroundResource(R.drawable.payment_debit);
            holder.tvBalance.setVisibility(View.GONE);
            holder.tvBalanceLabel.setVisibility(View.GONE);
        } else {
            holder.tvAmount.setText(Utilities.stringNotNull(data.get(position).getCreditAmount()));
            holder.imageStatusDebitCredit.setBackgroundResource(R.drawable.payment_credit);
            holder.tvBalance.setText(Utilities.stringNotNull(data.get(position).getClosingBalance()));
        }

        holder.tvDate.setText(!Utilities.stringNotNull(data.get(position).getCreatedDate()).equals("") ? Utilities.stringNotNull(data.get(position).getCreatedDate()).substring(0, 10) : "");

        holder.setIsRecyclable(true);

        setupListeners(holder, position);

    }

    private void setupListeners(ViewHolder holder, final int position) {
        holder.tvEmployeeName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivitiesLauncher.openViewStatementShowDetails(context, data.get(position));
            }
        });
        holder.tvEmployeeNameLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivitiesLauncher.openViewStatementShowDetails(context, data.get(position));
                ;
            }
        });
        holder.tvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivitiesLauncher.openViewStatementShowDetails(context, data.get(position));
                ;
            }
        });
        holder.tvDateLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivitiesLauncher.openViewStatementShowDetails(context, data.get(position));
                ;
            }
        });
        holder.tvStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivitiesLauncher.openViewStatementShowDetails(context, data.get(position));
                ;
            }
        });
        holder.tvStatusLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivitiesLauncher.openViewStatementShowDetails(context, data.get(position));
                ;
            }
        });
        holder.tvBalance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivitiesLauncher.openViewStatementShowDetails(context, data.get(position));
                ;
            }
        });
        holder.tvBalanceLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivitiesLauncher.openViewStatementShowDetails(context, data.get(position));
                ;
            }
        });
        holder.tvAmount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivitiesLauncher.openViewStatementShowDetails(context, data.get(position));
                ;
            }
        });
        holder.tvAmountLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivitiesLauncher.openViewStatementShowDetails(context, data.get(position));
                ;
            }
        });
        holder.imageStatusDebitCredit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivitiesLauncher.openViewStatementShowDetails(context, data.get(position));
                ;
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void add(FreeZonePayment string) {
        insert(string, data.size());
    }

    public void insert(FreeZonePayment string, int position) {
        data.add(position, string);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        data.remove(position);
        notifyItemRemoved(position);
    }

    public void clear() {
        int size = data.size();
        data.clear();
        notifyItemRangeRemoved(0, size);
    }

    public boolean addAll(ArrayList<FreeZonePayment> strings) {

        boolean returnedProgress = false;
        int startIndex = data.size();
        for (int i = 0; i < strings.size(); i++) {
            boolean found = false;
            for (int j = 0; j < data.size(); j++) {
                if (data.get(j).getId().equals(strings.get(i).getId())) {
                    found = true;
                    break;
                }
                if (!found) {
                    data.add(strings.get(i));
                    returnedProgress = true;
                }
            }
        }
        if (returnedProgress) {
            data.addAll(startIndex, strings);
            notifyItemRangeInserted(startIndex, strings.size());
            return true;
        } else {
            return returnedProgress;
        }
    }

    //    private int mLayoutResourceId;
//    private int mCount;
//
//    public ViewStatementAdapter(Context context, int layoutResourceId, List<FreeZonePayment> objects) {
//        super(context, layoutResourceId, objects);
//        mLayoutResourceId = layoutResourceId;
//        mCount = objects.size();
//    }
//
//
//    @Override
//    public int getCount() {
//        return mCount;
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    @Override
//    public boolean areAllItemsEnabled() {
//        return false;
//    }
//
//    @Override
//    public boolean isEnabled(int position) {
//        return false;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//
//        ViewHolder holder;
//
//        FreeZonePayment item = (FreeZonePayment) getItem(position);
//
//        if (convertView == null) {
//            convertView = LayoutInflater.from(getContext())
//                    .inflate(mLayoutResourceId, parent, false);
//            holder = new ViewHolder();
//            holder.tvEmployeeName = (TextView) convertView.findViewById(R.id.tvEmployeeName);
//            holder.tvDate = (TextView) convertView.findViewById(R.id.tvDate);
//            holder.tvAmount = (TextView) convertView.findViewById(R.id.tvAmount);
//            holder.tvBalance = (TextView) convertView.findViewById(R.id.tvBalance);
//            holder.tvStatus = (TextView) convertView.findViewById(R.id.tvStatus);
//            holder.imageStatusDebitCredit = (ImageView) convertView.findViewById(R.id.imageStatusDebitCredit);
//
//            holder.tvEmployeeNameLabel = (TextView) convertView.findViewById(R.id.tvEmployeeNameLabel);
//            holder.tvDateLabel = (TextView) convertView.findViewById(R.id.tvDateLabel);
//            holder.tvAmountLabel = (TextView) convertView.findViewById(R.id.tvAmountLabel);
//            holder.tvBalanceLabel = (TextView) convertView.findViewById(R.id.tvBalanceLabel);
//            holder.tvStatusLabel = (TextView) convertView.findViewById(R.id.tvStatusLabel);
//            convertView.setTag(holder);
//        } else {
//            holder = (ViewHolder) convertView.getTag();
//        }
//
//        if (item.getName() != null && !item.getName().equals("")) {
//            holder.tvEmployeeName.setText(item.getEmployeeName());
//        } else {
//            holder.tvEmployeeName.setVisibility(View.GONE);
//            holder.tvEmployeeNameLabel.setVisibility(View.GONE);
//        }
//
//        holder.tvStatus.setText(Utilities.stringNotNull(item.getStatus()));
//
//        if (item.getEffectOnAccount().equals("Debit")) {
//            holder.tvAmount.setText(Utilities.stringNotNull(item.getDebitAmount()) + " AED.");
//            holder.imageStatusDebitCredit.setBackgroundResource(R.drawable.payment_debit);
//            holder.tvBalance.setVisibility(View.GONE);
//            holder.tvBalanceLabel.setVisibility(View.GONE);
//        } else {
//            holder.tvAmount.setText(Utilities.stringNotNull(item.getCreditAmount()));
//            holder.imageStatusDebitCredit.setBackgroundResource(R.drawable.payment_credit);
//            holder.tvBalance.setText(Utilities.stringNotNull(item.getClosingBalance()));
//        }
//
//        holder.tvDate.setText(!Utilities.stringNotNull(item.getCreatedDate()).equals("") ? Utilities.stringNotNull(item.getCreatedDate()).substring(0, 10) : "");
//
//        return convertView;
//    }
//
    public static class ViewHolder extends RecyclerView.ViewHolder {
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

        public ViewHolder(View itemView) {
            super(itemView);
            tvEmployeeName = (TextView) itemView.findViewById(R.id.tvEmployeeName);
            tvDate = (TextView) itemView.findViewById(R.id.tvDate);
            tvAmount = (TextView) itemView.findViewById(R.id.tvAmount);
            tvBalance = (TextView) itemView.findViewById(R.id.tvBalance);
            tvStatus = (TextView) itemView.findViewById(R.id.tvStatus);
            imageStatusDebitCredit = (ImageView) itemView.findViewById(R.id.imageStatusDebitCredit);

            tvEmployeeNameLabel = (TextView) itemView.findViewById(R.id.tvEmployeeNameLabel);
            tvDateLabel = (TextView) itemView.findViewById(R.id.tvDateLabel);
            tvAmountLabel = (TextView) itemView.findViewById(R.id.tvAmountLabel);
            tvBalanceLabel = (TextView) itemView.findViewById(R.id.tvBalanceLabel);
            tvStatusLabel = (TextView) itemView.findViewById(R.id.tvStatusLabel);
        }
    }
}
