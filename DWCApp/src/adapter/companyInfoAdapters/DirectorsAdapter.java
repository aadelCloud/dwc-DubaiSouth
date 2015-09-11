package adapter.companyInfoAdapters;

import android.app.Activity;
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
import model.Directorship;
import model.ServiceItem;
import utilities.Utilities;

/**
 * Created by Abanoub on 7/7/2015.
 */
public class DirectorsAdapter extends ClickableListAdapter {

    Activity activity;
    ArrayList<Directorship> directorships;
    Context context;

    public DirectorsAdapter(Activity activity, Context context, int viewid, List objects) {
        super(context, viewid, objects);
        this.context = context;
        this.activity = activity;
        directorships = new ArrayList<>();
        directorships = (ArrayList<Directorship>) objects;
    }

    @Override
    protected ViewHolder createHolder(View v) {

        TextView tvFullName, tvNationality, tvPassportNumber, tvRole, tvStartDate;
        RoundedImageView _smartEmployeeImage;

        final ExpandableLayoutItem item = (ExpandableLayoutItem) v.findViewById(R.id.expandableLayoutListView);
        RelativeLayout relativeHeader = item.getHeaderLayout();

        tvFullName = (TextView) relativeHeader.findViewById(R.id.tvFullName);
        tvNationality = (TextView) relativeHeader.findViewById(R.id.tvNationality);
        tvPassportNumber = (TextView) relativeHeader.findViewById(R.id.tvpassportNumber);
        tvRole = (TextView) relativeHeader.findViewById(R.id.tvRole);
        tvStartDate = (TextView) relativeHeader.findViewById(R.id.tvStartDate);
        _smartEmployeeImage = (RoundedImageView) relativeHeader.findViewById(R.id.view);
        RelativeLayout relativeContent = item.getContentLayout();
        HorizontalListView _horizontalServices = (HorizontalListView) relativeContent.findViewById(R.id.horizontalServices);
        DirectorViewHolder mvh = new DirectorViewHolder(tvFullName, tvNationality, tvPassportNumber, tvRole, tvStartDate, _smartEmployeeImage, item, _horizontalServices);
        return mvh;
    }

    @Override
    protected void bindHolder(ViewHolder h) {

        DirectorViewHolder holder = (DirectorViewHolder) h;
        Directorship _directorship = (Directorship) holder.data;
        holder.tvFullName.setText(_directorship.get_director().getName() == null ? "" : _directorship.get_director().getName());
        holder.tvNationality.setText(_directorship.get_director().getNationality() == null ? "" : _directorship.get_director().getNationality());
        holder.tvPassportNumber.setText(_directorship.get_director().get_currentPassport() == null ? "" : _directorship.get_director().get_currentPassport().getName());
        holder.tvRole.setText(_directorship.getRoles() == null ? "" : _directorship.getRoles());
        holder.tvStartDate.setText(_directorship.getDirectorship_Start_Date() == null ? "" : _directorship.getDirectorship_Start_Date());

        ArrayList<ServiceItem> _items = new ArrayList<ServiceItem>();
        _items.add(new ServiceItem("Show Details", R.drawable.service_show_details));
        if (directorships != null && directorships.size() > 1) {
            _items.add(new ServiceItem("Director Removal", R.drawable.reports_myrequests));
        }

        holder.item.setOnClickListener(new ClickableListAdapter.OnClickListener(holder) {

            public void onClick(View v, ViewHolder viewHolder) {
                if (viewHolder != null) {
                    DirectorViewHolder myViewHolder = (DirectorViewHolder) viewHolder;
                    if (!myViewHolder.item.isOpened()) {
                        myViewHolder.item.show();
                    } else {
                        myViewHolder.item.hide();
                    }
                }
            }
        });
        Utilities.setUserPhoto(activity, Utilities.stringNotNull(_directorship.get_director().getPersonal_Photo()), holder._smartEmployeeImage);
        holder._horizontalListView.setAdapter(new HorizontalListViewAdapter(_directorship,activity, context, _items));
    }

    static class DirectorViewHolder extends ViewHolder {

        TextView tvFullName, tvNationality, tvPassportNumber, tvRole, tvStartDate;
        RoundedImageView _smartEmployeeImage;
        ExpandableLayoutItem item;
        HorizontalListView _horizontalListView;

        public DirectorViewHolder(TextView tvFullName, TextView tvNationality, TextView tvPassportNumber, TextView tvRole, TextView tvStartDate, RoundedImageView _smartEmployeeImage, ExpandableLayoutItem item, HorizontalListView _horizontalListView) {
            this.tvFullName = tvFullName;
            this.tvNationality = tvNationality;
            this.tvPassportNumber = tvPassportNumber;
            this.tvRole = tvRole;
            this.tvStartDate = tvStartDate;
            this._smartEmployeeImage = _smartEmployeeImage;
            this.item = item;
            this._horizontalListView = _horizontalListView;
        }
    }
}

