package adapter;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cocosw.bottomsheet.BottomSheet;
import com.google.gson.Gson;

import java.util.ArrayList;

import activity.CompanyDocumentsActivity;
import cloudconcept.dwc.R;
import dataStorage.StoreData;
import model.Card_Management__c;
import model.Company_Documents__c;
import model.EServices_Document_Checklist__c;
import model.ServiceItem;
import model.ShareOwnership;
import model.Visa;
import utilities.ActivitiesLauncher;

/**
 * Created by Abanoub on 6/26/2015.
 */
public class HorizontalListViewAdapter extends BaseAdapter {

    private Activity activity;
    Object object;
    Gson gson;
    String objectAsString = "";
    private Context context;
    private ArrayList<ServiceItem> _items;
    private static int RESULT_LOAD_IMG_FROM_GALLERY = 2;
    private static int RESULT_LOAD_IMG_FROM_CAMERA = 3;

    public boolean isInflated() {
        return inflated;
    }

    private boolean inflated;

    public HorizontalListViewAdapter(Object object, Activity activity, Context context, ArrayList<ServiceItem> _items) {
        this._items = _items;
        this.context = context;
        this.object = object;
        inflated = false;
        this.activity = activity;
    }

    public ArrayList<ServiceItem> getServiceItems() {
        return this._items;
    }

    public Object getObject() {
        return this.object;
    }


    @Override
    public int getCount() {
        return _items.size();
    }

    @Override
    public Object getItem(int position) {
        return _items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater)
                    context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.horizontal_item_row, null);
        }

        ImageView ivServiceDrawable;
        final TextView tvServiceName;

        ivServiceDrawable = (ImageView) convertView.findViewById(R.id.ivServiceDrawable);
        tvServiceName = (TextView) convertView.findViewById(R.id.tvServiceName);

        ivServiceDrawable.setImageResource(_items.get(position).getDrawableIcon());
        tvServiceName.setText(_items.get(position).getTvServiceName());
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (object instanceof Visa) {
                    Visa _visa = (Visa) object;
                    gson = new Gson();
                    objectAsString = gson.toJson(_visa);
                    if (tvServiceName.getText().toString().equals("Show Details")) {
                        ActivitiesLauncher.openShowDetailsActivity(context, "Visa Details", objectAsString, "Visa");
                    } else if (tvServiceName.getText().toString().equals("New NOC")) {
                        ActivitiesLauncher.openNOCActivity(context, objectAsString, "Visa");
                    } else if (tvServiceName.getText().toString().equals("Renew Visa")) {
                        ActivitiesLauncher.openVisaActivity(context, _visa, "renew");
                    } else if (tvServiceName.getText().toString().equals("Cancel Visa")) {
                        ActivitiesLauncher.openVisaActivity(context, _visa, "Cancel");
                    } else if (tvServiceName.getText().toString().equals("Renew Passport")) {
                        ActivitiesLauncher.openVisaActivity(context, _visa, "Passport");
                    }
                } else if (object instanceof Card_Management__c) {
                    Card_Management__c card = (Card_Management__c) object;
                    if (tvServiceName.getText().toString().equals("Cancel Card")) {
                        ActivitiesLauncher.openCardActivity(context, card, "2");
                    } else if (tvServiceName.getText().toString().equals("Renew Card")) {
                        ActivitiesLauncher.openCardActivity(context, card, "3");
                    } else if (tvServiceName.getText().toString().equals("Replace Card")) {
                        ActivitiesLauncher.openCardActivity(context, card, "4");
                    }
                } else if (object instanceof ShareOwnership) {
                    ShareOwnership shareHolder = (ShareOwnership) object;
                    if (tvServiceName.getText().toString().equals("Share Holder")) {
                        ActivitiesLauncher.openShareHolderActivity(context, shareHolder, "2", _items.get(position).getObjects());
                    }
                } else if (object instanceof EServices_Document_Checklist__c) {
                    EServices_Document_Checklist__c eServices_document_checklist__c = (EServices_Document_Checklist__c) object;
                    if (tvServiceName.getText().toString().equals("Preview")) {
                        ActivitiesLauncher.openCustomerDocumentsPreviewActivity(context, eServices_document_checklist__c);
                    } else if (tvServiceName.getText().toString().equals("Request True Copy")) {
                        ActivitiesLauncher.openCompanyDocumentsRequestTrueCopyActivity(context, eServices_document_checklist__c);
                    }
                } else if (object instanceof Company_Documents__c) {
                    final Company_Documents__c company_documents__c = (Company_Documents__c) object;
                    if (tvServiceName.getText().toString().equals("Preview")) {
                        ActivitiesLauncher.openCustomerDocumentsPreviewActivity(context, company_documents__c);
                    } else if (tvServiceName.getText().toString().equals("Edit")) {
                        new BottomSheet.Builder(activity).title("Choose Edit Option").sheet(R.menu.customer_document_list).listener(new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                switch (which) {
                                    case R.id.camera:
                                        loadImagefromCamera(position, company_documents__c);
                                        break;
                                    case R.id.gallery:
                                        loadImagefromGallery(position, company_documents__c);
                                        break;
                                }
                            }
                        }).show();
                    }
                }
            }
        });

        return convertView;
    }

    public void loadImagefromGallery(int position, Company_Documents__c company_documents__c) {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        gson = new Gson();
        new StoreData(context).setCompanyDocumentObject(gson.toJson(company_documents__c));
        new StoreData(context).setCompanyDocumentPosition(position);
        activity.startActivityForResult(galleryIntent, RESULT_LOAD_IMG_FROM_GALLERY);
    }

    public void loadImagefromCamera(int position, Company_Documents__c company_documents__c) {
        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        gson = new Gson();
        new StoreData(context).setCompanyDocumentObject(gson.toJson(company_documents__c));
        new StoreData(context).setCompanyDocumentPosition(position);
        activity.startActivityForResult(cameraIntent, RESULT_LOAD_IMG_FROM_CAMERA);
    }

    public void setInflated(boolean b) {
        this.inflated = b;
    }

    public boolean getInflated() {
        return this.inflated;
    }
}
