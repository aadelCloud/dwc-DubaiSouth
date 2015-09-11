package adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import cloudconcept.dwc.R;
import custom.HorizontalListView;
import custom.RoundedImageView;
import custom.expandableView.ExpandableLayoutItem;
import model.Contract_DWC__c;
import model.ServiceItem;
import utilities.Utilities;

/**
 * Created by Abanoub Wagdy on 8/31/2015.
 */
public class LeasingInfoAdapter extends ClickableListAdapter {


    private Activity act;
    private Context context;
    private ArrayList<Contract_DWC__c> contracts;

    public LeasingInfoAdapter(Activity act, Context context, int viewid, ArrayList<Contract_DWC__c> contracts) {
        super(context, viewid, contracts);
        this.context = context;
        this.act = act;
        this.contracts = new ArrayList<>();
        for (Contract_DWC__c contract_dwc__c : contracts) {
            this.contracts.add(contract_dwc__c);
        }
    }

    @Override
    protected ViewHolder createHolder(View v) {

        TextView tvContractName, tvUnitName, tvContractType, tvExpiryDate, tvStatus;
        RoundedImageView _smartEmployeeImage;

        final ExpandableLayoutItem item = (ExpandableLayoutItem) v.findViewById(R.id.expandableLayoutListView);

        RelativeLayout relativeHeader = item.getHeaderLayout();
        tvContractName = (TextView) relativeHeader.findViewById(R.id.tvContractName);
        tvUnitName = (TextView) relativeHeader.findViewById(R.id.tvUnitName);
        tvContractType = (TextView) relativeHeader.findViewById(R.id.tvContractType);
        tvExpiryDate = (TextView) relativeHeader.findViewById(R.id.tvExpiryDate);
        tvStatus = (TextView) relativeHeader.findViewById(R.id.tvStatus);

        _smartEmployeeImage = (RoundedImageView) relativeHeader.findViewById(R.id.view);

        RelativeLayout relativeContent = item.getContentLayout();

        HorizontalListView _horizontalServices = (HorizontalListView) relativeContent.findViewById(R.id.horizontalServices);
        ContractViewHolder mvh = new ContractViewHolder(tvContractName, tvUnitName, tvContractType, tvExpiryDate, tvStatus, _smartEmployeeImage, item, _horizontalServices);
        return mvh;
    }

    @Override
    protected void bindHolder(ViewHolder h) {

        final ContractViewHolder mvh = (ContractViewHolder) h;
        Contract_DWC__c mo = (Contract_DWC__c) mvh.data;

        mvh.tvContractName.setText(Utilities.stringNotNull(mo.getName()));
        mvh.tvUnitName.setText(mo.getContract_line_item__cs().get(0).getInventory_unit__r().getName());
        mvh.tvContractType.setText(Utilities.stringNotNull(mo.getContract_Type__c()));
        mvh.tvStatus.setText(Utilities.stringNotNull(mo.getStatus__c()));
        mvh.tvExpiryDate.setText(Utilities.stringNotNull(mo.getContract_Expiry_Date__c().toString()));
        ArrayList<ServiceItem> _items = new ArrayList<ServiceItem>();
        _items.add(new ServiceItem("Show Details", R.drawable.noc_service_image));

        mvh.item.setOnClickListener(new ClickableListAdapter.OnClickListener(mvh) {

            public void onClick(View v, ViewHolder viewHolder) {
                if (viewHolder != null) {
                    ContractViewHolder myViewHolder = (ContractViewHolder) viewHolder;
                    if (!myViewHolder.item.isOpened()) {
                        myViewHolder.item.show();
                    } else {
                        myViewHolder.item.hide();
                    }
                }
            }
        });

        mvh._horizontalListView.setAdapter(new HorizontalListViewAdapter(mo,act, context, _items));
    }


    static class ContractViewHolder extends ViewHolder {

        TextView tvContractName, tvUnitName, tvContractType, tvExpiryDate, tvStatus;
        RoundedImageView _smartEmployeeImage;
        ExpandableLayoutItem item;
        HorizontalListView _horizontalListView;

        public ContractViewHolder(TextView tvContractName, TextView tvUnitName, TextView tvContractType, TextView tvExpiryDate, TextView tvStatus, RoundedImageView _smartEmployeeImage, ExpandableLayoutItem item, HorizontalListView _horizontalListView) {
            this.tvContractName = tvContractName;
            this.tvUnitName = tvUnitName;
            this.tvContractType = tvContractType;
            this.tvExpiryDate = tvExpiryDate;
            this.tvStatus = tvStatus;
            this._smartEmployeeImage = _smartEmployeeImage;
            this.item = item;
            this._horizontalListView = _horizontalListView;
        }
    }
}
