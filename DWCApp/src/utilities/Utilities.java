package utilities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Environment;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.gc.materialdesign.views.Switch;
import com.google.gson.Gson;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.rest.ClientManager;
import com.salesforce.androidsdk.rest.RestClient;
import com.salesforce.androidsdk.rest.RestRequest;
import com.salesforce.androidsdk.rest.RestResponse;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import RestAPI.RelatedServiceType;
import adapter.HorizontalListViewAdapter;
import adapter.NationalityAdapter;
import cloudconcept.dwc.R;
import custom.HorizontalListView;
import custom.RoundedImageView;
import custom.customdialog.Effectstype;
import custom.customdialog.NiftyDialogBuilder;
import dataStorage.StoreData;
import fragmentActivity.CardActivity;
import model.Attachment;
import model.Card_Management__c;
import model.DWCView;
import model.FormField;
import model.ItemType;
import model.NOC__c;
import model.Receipt_Template__c;
import model.ServiceItem;
import model.User;
import model.Visa;
import model.WebForm;

public class Utilities {

    static ProgressBar mProgressBar;
    private static ProgressDialog _progress;
    private static Receipt_Template__c eServiceAdministration;


    @SuppressWarnings("deprecation")
    public static void showNiftyDialog(String title, Activity act,
                                       OnClickListener listenerPositive) {

        final NiftyDialogBuilder dialogBuilder = NiftyDialogBuilder
                .getInstance(act);

        dialogBuilder
                .withTitle(title)
                .withTitleColor("#FFFFFF")
                .withDividerColor("#11000000")
                .withMessage(act.getResources().getString(R.string.sf__passcode_logout_confirmation))
                .withMessageColor("#FFFFFFFF")
                .withDialogColor("#2F7CB4")
                .withIcon(
                        act.getResources().getDrawable(R.drawable.ic_launcher))
                .withDuration(300).withEffect(Effectstype.Newspager)
                .withButton1Text("OK").withButton2Text("Cancel")
                .isCancelableOnTouchOutside(true)
                .setButton1Click(listenerPositive)
                .setButton2Click(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialogBuilder.dismiss();
                    }
                }).show();
    }

    public static NiftyDialogBuilder showCustomNiftyDialog(String title, Activity act, OnClickListener listenerPositive, String Text) {
        final NiftyDialogBuilder dialogBuilder = NiftyDialogBuilder
                .getInstance(act);

        dialogBuilder
                .withTitle(title)
                .withTitleColor("#FFFFFF")
                .withDividerColor("#11000000")
                .withMessage(Text)
                .withMessageColor("#FFFFFFFF")
                .withDialogColor("#2F7CB4")
                .withIcon(
                        act.getResources().getDrawable(R.drawable.ic_launcher))
                .withDuration(300).withEffect(Effectstype.Slidetop)
                .withButton1Text("OK").withButton2Text("Cancel")
                .isCancelableOnTouchOutside(true)
                .setButton1Click(listenerPositive)
                .setButton2Click(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialogBuilder.dismiss();
                    }
                }).show();
        return dialogBuilder;
    }

    public static void showloadingDialog(Activity activity) {
        _progress = new ProgressDialog(activity);
        _progress.setMessage("Loading ...");
        _progress.setCancelable(false);
        _progress.show();
    }

    public static void showloadingDialog(Activity activity, String text) {
        _progress = new ProgressDialog(activity);
        _progress.setMessage(text);
        _progress.setCancelable(false);
        _progress.show();
    }

    public static void dismissLoadingDialog() {
        _progress.dismiss();
    }


    public static void showToast(Activity act, String message) {
        Toast.makeText(act, message, Toast.LENGTH_SHORT).show();
    }

    public static void showLongToast(Activity act, String message) {
        Toast.makeText(act, message, Toast.LENGTH_LONG).show();
    }

    public static synchronized void setUserPhoto(Activity act, final String attachmentId, final RoundedImageView smartImageView) {

        if (!attachmentId.equals("") && attachmentId != null) {
            List<String> fieldList = new ArrayList<String>();
            fieldList.add("Id");
            fieldList.add("Body");

            try {
                final RestRequest restRequest = RestRequest.getRequestForRetrieve(act.getApplicationContext().getResources().getString(R.string.api_version), "Attachment", attachmentId, fieldList);
                new ClientManager(act, SalesforceSDKManager.getInstance().getAccountType(), SalesforceSDKManager.getInstance().getLoginOptions(), SalesforceSDKManager.getInstance().shouldLogoutWhenTokenRevoked()).getRestClient(act, new ClientManager.RestClientCallback() {
                    @Override
                    public void authenticatedRestClient(final RestClient client) {
                        if (client == null) {
                            System.exit(0);
                        } else {
                            client.sendAsync(restRequest, new RestClient.AsyncRequestCallback() {
                                @Override
                                public void onSuccess(RestRequest request, RestResponse response) {
                                    try {
                                        final JSONObject json = new JSONObject(response.toString());
                                        final Attachment attachment = new Attachment();
                                        attachment.setID(json.getString("Id"));
                                        attachment.setBody(json.getString("Body"));
                                        try {
                                            new DownloadAttachmentBodyForRoundedImage(client, attachment, smartImageView).execute().get();
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        } catch (ExecutionException e) {
                                            e.printStackTrace();
                                        }

                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }

                                @Override
                                public void onError(Exception exception) {

                                }
                            });
                        }
                    }
                });
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        } else {
            smartImageView.setImageDrawable(act.getResources().getDrawable(R.drawable.avatar));
        }
    }

    public static synchronized void setUserPhoto(Activity act, final String attachmentId, final ImageView smartImageView) {

        if (!attachmentId.equals("") && attachmentId != null) {
            List<String> fieldList = new ArrayList<String>();
            fieldList.add("Id");
            fieldList.add("Body");

            try {
                final RestRequest restRequest = RestRequest.getRequestForRetrieve(act.getApplicationContext().getResources().getString(R.string.api_version), "Attachment", attachmentId, fieldList);
                new ClientManager(act, SalesforceSDKManager.getInstance().getAccountType(), SalesforceSDKManager.getInstance().getLoginOptions(), SalesforceSDKManager.getInstance().shouldLogoutWhenTokenRevoked()).getRestClient(act, new ClientManager.RestClientCallback() {
                    @Override
                    public void authenticatedRestClient(final RestClient client) {
                        if (client == null) {
                            System.exit(0);
                        } else {
                            client.sendAsync(restRequest, new RestClient.AsyncRequestCallback() {
                                @Override
                                public void onSuccess(RestRequest request, RestResponse response) {
                                    try {
                                        final JSONObject json = new JSONObject(response.toString());
                                        final Attachment attachment = new Attachment();
                                        attachment.setID(json.getString("Id"));
                                        attachment.setBody(json.getString("Body"));
                                        try {
                                            new DownloadAttachmentBody(client, attachment, smartImageView).execute().get();
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        } catch (ExecutionException e) {
                                            e.printStackTrace();
                                        }

                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }

                                @Override
                                public void onError(Exception exception) {

                                }
                            });
                        }
                    }
                });
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        } else {
            smartImageView.setImageDrawable(act.getResources().getDrawable(R.drawable.avatar));
        }
    }

    public static void drawstaticFormFields(final Activity act, final Context applicationContext, LinearLayout linearLayout, final ArrayList<FormField> formFields, Map<String, String> parameters, final Card_Management__c _noc) {

        LayoutInflater inflater = (LayoutInflater)
                applicationContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        for (FormField field : formFields) {

            if (field.getType().equals("CUSTOMTEXT")) {

                View view = inflater.inflate(R.layout.wizard_form_field_header, null, false);
                TextView tvHeader = (TextView) view.findViewById(R.id.formFieldheader);
                tvHeader.setText(field.getMobileLabel());
                linearLayout.addView(view);

            } else if (field.isParameter()) {
                {


                    View view = null;
                    TextView tvLabel;
                    EditText tvValue;


                    view = inflater.inflate(R.layout.wizard_form_field_label_disabled, null, false);


                    tvLabel = (TextView) view.findViewById(R.id.formFieldLabel);
                    tvValue = (EditText) view.findViewById(R.id.formFieldvalue);
                    tvLabel.setText(field.getMobileLabel());
                    tvValue.setText(parameters.get(field.getTextValue()));
                    String name = field.getName();
                    Field[] fields = Card_Management__c.class.getFields();
                    for (int j = 0; j < fields.length; j++)
                        if (name.toLowerCase().equals(fields[j].getName().toLowerCase()))
                            try {
                                fields[j].set(_noc, parameters.get(field.getTextValue()));
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            }
                    linearLayout.addView(view);


                }

            } else {
                View view = null;
                TextView tvLabel;
                EditText tvValue;


                view = inflater.inflate(R.layout.wizard_form_field_label_disabled, null, false);

                tvLabel = (TextView) view.findViewById(R.id.formFieldLabel);
                tvValue = (EditText) view.findViewById(R.id.formFieldvalue);
                tvLabel.setText(field.getMobileLabel());

                String stringValue = "";
                String name = field.getName();
                Field[] fields = Card_Management__c.class.getFields();
                for (int j = 0; j < fields.length; j++)
                    if (name.toLowerCase().equals(fields[j].getName().toLowerCase()))
                        try {
                            stringValue = (String) fields[j].get(_noc);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                tvValue.setText(stringValue);
                linearLayout.addView(view);


            }
        }


    }

    public static void DrawFormFieldsOnLayout(final Activity act, final Context applicationContext, LinearLayout linearLayout, final ArrayList<FormField> formFields, Visa _visa, JSONObject visaJson, Map<String, String> parameters, final Card_Management__c _noc) {

        LayoutInflater inflater = (LayoutInflater)
                applicationContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);


        for (FormField field : formFields) {
            if (field.isQuery() == false && field.isParameter() == false) {

                if (field.getType().equals("CUSTOMTEXT")) {

                    View view = inflater.inflate(R.layout.wizard_form_field_header, null, false);
                    TextView tvHeader = (TextView) view.findViewById(R.id.formFieldheader);
                    tvHeader.setText(field.getMobileLabel());
                    linearLayout.addView(view);

                } else if (field.getType().equals("PICKLIST")) {

                    View view = inflater.inflate(R.layout.wizard_form_field_picklist, null, false);
                    Spinner spinner = (Spinner) view.findViewById(R.id.spinner);
                    spinner.setTag(field);
                    final TextView tvLabel = (TextView) view.findViewById(R.id.tvLabel);
                    tvLabel.setText(field.getMobileLabel());
//                    spinner.setHint(field.getMobileLabel());
                    final String[] entries = field.getPicklistEntries().split(",");
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(act, android.R.layout.simple_list_item_1, entries);
                    adapter.setDropDownViewResource(R.layout.customtext);
                    spinner.setAdapter(adapter);
                    spinner.setSelection(0);
                    spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            new StoreData(applicationContext).setPickListSelected(tvLabel.getText().toString(), entries[position]);
                            FormField f = (FormField) parent.getTag();
                            String name = f.getName();
                            Field[] fields = Card_Management__c.class.getFields();
                            for (int j = 0; j < fields.length; j++)
                                if (name.toLowerCase().equals(fields[j].getName().toLowerCase()))
                                    try {
                                        fields[j].set(_noc, entries[position]);
                                    } catch (IllegalAccessException e) {
                                        e.printStackTrace();
                                    }

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });

                    linearLayout.addView(view);

                } else if (field.getType().equals("REFERENCE")) {

                    View view = inflater.inflate(R.layout.wizard_form_field_picklist, null, false);
                    Spinner spinner = (Spinner) view.findViewById(R.id.spinner);
                    spinner.setTag(field);
                    final TextView tvLabel = (TextView) view.findViewById(R.id.tvLabel);
                    tvLabel.setText(field.getMobileLabel());
//                    spinner.setHint(field.getMobileLabel());
                    NationalityAdapter adapter = new NationalityAdapter(act, android.R.layout.simple_list_item_1, 0, ((CardActivity) act).getCountries());
                    adapter.setDropDownViewResource(R.layout.customtext);
                    spinner.setAdapter(adapter);
                    spinner.setSelection(0);
                    spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            FormField f = (FormField) parent.getTag();
                            String name = f.getName();
                            Field[] fields = Card_Management__c.class.getFields();
                            for (int j = 0; j < fields.length; j++)
                                if (name.toLowerCase().equals(fields[j].getName().toLowerCase()))
                                    try {
                                        fields[j].set(_noc, ((CardActivity) act).getCountries().get(position).getId());
                                    } catch (IllegalAccessException e) {
                                        e.printStackTrace();
                                    }

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });

                    linearLayout.addView(view);


                } else if (field.getType().equals("BOOLEAN")) {
                    View view = inflater.inflate(R.layout.wizard_form_field_checkbox, null, false);
                    final TextView tvLabel;
                    Switch switchView;
                    tvLabel = (TextView) view.findViewById(R.id.tvLabel);
                    switchView = (Switch) view.findViewById(R.id.switchView);
                    switchView.setTag(field);
                    tvLabel.setText(field.getMobileLabel());

                    switchView.setOncheckListener(new Switch.OnCheckListener() {

                        @Override
                        public void onCheck(Switch aSwitch, boolean b) {

                            FormField f = (FormField) aSwitch.getTag();
                            String name = f.getName();
                            Field[] fields = Card_Management__c.class.getFields();
                            for (int j = 0; j < fields.length; j++)
                                if (name.toLowerCase().equals(fields[j].getName().toLowerCase()))
                                    try {
                                        fields[j].set(_noc, b);
                                    } catch (IllegalAccessException e) {
                                        e.printStackTrace();
                                    }

                        }
                    });

                    linearLayout.addView(view);

                } else if (field.getType().equals("EMAIL")) {

                    View view = inflater.inflate(R.layout.wizard_form_field_edit_text_email, null, false);
                    EditText etEmail = (EditText) view.findViewById(R.id.etEmail);
                    TextView tvLabel = (TextView) view.findViewById(R.id.tvLabel);
                    String stringValue = "";
                    String name = field.getName();
                    if (name.equals("NOC_Receiver_Email__c")) {
                        String user = new StoreData(applicationContext).getUserDataAsString();
                        Gson g = new Gson();
                        User u = g.fromJson(user, User.class);
                        stringValue = u.get_contact().get_account().getEmail();
                        Field[] fields = Card_Management__c.class.getFields();
                        for (int j = 0; j < fields.length; j++)
                            if (name.toLowerCase().equals(fields[j].getName().toLowerCase()))
                                try {
                                    fields[j].set(_noc, stringValue);
                                } catch (IllegalAccessException e) {
                                    e.printStackTrace();
                                }
                    } else {
                        Field[] fields = Card_Management__c.class.getFields();
                        for (int j = 0; j < fields.length; j++)
                            if (name.toLowerCase().equals(fields[j].getName().toLowerCase()))
                                try {
                                    stringValue = (String) fields[j].get(_noc);
                                } catch (IllegalAccessException e) {
                                    e.printStackTrace();
                                }
                    }

                    etEmail.setText(stringValue);
                    etEmail.setTag(field);
                    etEmail.setInputType(InputType.TYPE_TEXT_VARIATION_WEB_EMAIL_ADDRESS);

                    etEmail.addTextChangedListener(new GenericTextWatcherCard(etEmail, _noc));
                    tvLabel.setText(field.getMobileLabel());
                    linearLayout.addView(view);
                } else if (field.getType().equals("DOUBLE")) {
                    View view = inflater.inflate(R.layout.wizard_form_field_label_enabled, null, false);
                    EditText etEmail = (EditText) view.findViewById(R.id.formFieldvalue);
                    TextView tvLabel = (TextView) view.findViewById(R.id.formFieldLabel);

                    TextView formFieldLabelrequired = (TextView) view.findViewById(R.id.formFieldLabelrequired);
                    if (field.isRequired())
                        formFieldLabelrequired.setVisibility(View.VISIBLE);
                    String stringValue = "";
                    String name = field.getName();
                    etEmail.setText(stringValue);
                    etEmail.setHint(field.getMobileLabel());
                    etEmail.setTag(field);
                    etEmail.setInputType(InputType.TYPE_CLASS_NUMBER);
                    etEmail.addTextChangedListener(new GenericTextWatcherCard(etEmail, _noc));
                    tvLabel.setText(field.getMobileLabel());

                    linearLayout.addView(view);
                } else if (field.getType().equals("STRING")) {
                    View view = inflater.inflate(R.layout.wizard_form_field_label_enabled, null, false);
                    EditText etEmail = (EditText) view.findViewById(R.id.formFieldvalue);
                    TextView tvLabel = (TextView) view.findViewById(R.id.formFieldLabel);

                    TextView formFieldLabelrequired = (TextView) view.findViewById(R.id.formFieldLabelrequired);
                    if (field.isRequired())
                        formFieldLabelrequired.setVisibility(View.VISIBLE);
                    String stringValue = "";
                    String name = field.getName();
                    etEmail.setText(stringValue);
                    etEmail.setTag(field);
                    etEmail.setInputType(InputType.TYPE_CLASS_TEXT);
                    etEmail.addTextChangedListener(new GenericTextWatcherCard(etEmail, _noc));
                    tvLabel.setText(field.getMobileLabel());
                    etEmail.setHint(field.getMobileLabel());

                    linearLayout.addView(view);
                } else if (field.getType().equals("DATE")) {
                    String name = field.getName();
                    Field[] fields = Card_Management__c.class.getFields();
                    for (int j = 0; j < fields.length; j++)
                        if (name.toLowerCase().equals(fields[j].getName().toLowerCase()))
                            try {
                                fields[j].set(_noc, "2017-02-22");
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            }
                }

            } else if (field.isParameter() == false && field.isQuery() == true) {
                if (field.getType().equals("STRING")) {

                    View view = null;
                    TextView tvLabel;
                    EditText tvValue;

                    if (field.isCalculated()) {
                        view = inflater.inflate(R.layout.wizard_form_field_label_disabled, null, false);
                    } else {
                        view = inflater.inflate(R.layout.wizard_form_field_label_enabled, null, false);
                    }

                    tvLabel = (TextView) view.findViewById(R.id.formFieldLabel);
                    tvValue = (EditText) view.findViewById(R.id.formFieldvalue);
                    tvLabel.setText(field.getMobileLabel());

                    String stringValue = "";
                    String name = field.getName();
                    Field[] fields = Card_Management__c.class.getFields();
                    for (int j = 0; j < fields.length; j++)
                        if (name.toLowerCase().equals(fields[j].getName().toLowerCase()))
                            try {
                                stringValue = (String) fields[j].get(_noc);
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            }
                    tvValue.setText(stringValue);
                    linearLayout.addView(view);

                }
            } else if (field.isParameter() == true && field.isQuery() == false) {


                View view = null;
                TextView tvLabel;
                EditText tvValue;


                view = inflater.inflate(R.layout.wizard_form_field_label_disabled, null, false);


                tvLabel = (TextView) view.findViewById(R.id.formFieldLabel);
                tvValue = (EditText) view.findViewById(R.id.formFieldvalue);
                tvLabel.setText(field.getMobileLabel());
                tvValue.setText(parameters.get(field.getTextValue()));
                String name = field.getName();
                Field[] fields = Card_Management__c.class.getFields();
                for (int j = 0; j < fields.length; j++)
                    if (name.toLowerCase().equals(fields[j].getName().toLowerCase()))
                        try {
                            fields[j].set(_noc, parameters.get(field.getTextValue()));
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                linearLayout.addView(view);


            }

        }


    }


    public static void DrawFormFieldsOnLayout(Activity act, final Context applicationContext, LinearLayout linearLayout, final ArrayList<FormField> formFields, Visa _visa, JSONObject visaJson, Map<String, String> parameters, final NOC__c _noc) {

        LayoutInflater inflater = (LayoutInflater)
                applicationContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);


        for (FormField field : formFields) {
            if (field.isQuery() == false && field.isParameter() == false) {

                if (field.getType().equals("CUSTOMTEXT")) {

                    View view = inflater.inflate(R.layout.wizard_form_field_header, null, false);
                    TextView tvHeader = (TextView) view.findViewById(R.id.formFieldheader);
                    tvHeader.setText(field.getMobileLabel());
                    linearLayout.addView(view);

                } else if (field.getType().equals("PICKLIST")) {

                    View view = inflater.inflate(R.layout.wizard_form_field_picklist, null, false);
                    Spinner spinner = (Spinner) view.findViewById(R.id.spinner);
                    spinner.setTag(field);
                    final TextView tvLabel = (TextView) view.findViewById(R.id.tvLabel);
                    tvLabel.setText(field.getMobileLabel());
//                    spinner.setHint(field.getMobileLabel());
                    final String[] entries = field.getPicklistEntries().split(",");
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(act, android.R.layout.simple_list_item_1, entries);
                    adapter.setDropDownViewResource(R.layout.customtext);
                    spinner.setAdapter(adapter);
                    spinner.setSelection(0);
                    spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            new StoreData(applicationContext).setPickListSelected(tvLabel.getText().toString(), entries[position]);
                            FormField f = (FormField) parent.getTag();
                            String name = f.getName();
                            Field[] fields = NOC__c.class.getFields();
                            for (int j = 0; j < fields.length; j++)
                                if (name.toLowerCase().equals(fields[j].getName().toLowerCase()))
                                    try {
                                        fields[j].set(_noc, entries[position]);
                                    } catch (IllegalAccessException e) {
                                        e.printStackTrace();
                                    }

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });

                    linearLayout.addView(view);

                } else if (field.getType().equals("BOOLEAN")) {
                    getNocAndFields(visaJson, field, _noc);
                    View view = inflater.inflate(R.layout.wizard_form_field_checkbox, null, false);
                    final TextView tvLabel;
                    Switch switchView;
                    tvLabel = (TextView) view.findViewById(R.id.tvLabel);
                    switchView = (Switch) view.findViewById(R.id.switchView);
                    switchView.setTag(field);
                    tvLabel.setText(field.getMobileLabel());

                    switchView.setOncheckListener(new Switch.OnCheckListener() {

                        @Override
                        public void onCheck(Switch aSwitch, boolean b) {

                            FormField f = (FormField) aSwitch.getTag();
                            String name = f.getName();
                            Field[] fields = NOC__c.class.getFields();
                            for (int j = 0; j < fields.length; j++)
                                if (name.toLowerCase().equals(fields[j].getName().toLowerCase()))
                                    try {
                                        fields[j].set(_noc, b);
                                    } catch (IllegalAccessException e) {
                                        e.printStackTrace();
                                    }

                        }
                    });

                    linearLayout.addView(view);

                } else if (field.getType().equals("EMAIL")) {

                    View view = inflater.inflate(R.layout.wizard_form_field_edit_text_email, null, false);
                    EditText etEmail = (EditText) view.findViewById(R.id.etEmail);
                    TextView tvLabel = (TextView) view.findViewById(R.id.tvLabel);
                    String stringValue = "";
                    String name = field.getName();
                    if (name.equals("NOC_Receiver_Email__c")) {
                        String user = new StoreData(applicationContext).getUserDataAsString();
                        Gson g = new Gson();
                        User u = g.fromJson(user, User.class);
                        stringValue = u.get_contact().get_account().getEmail();
                        Field[] fields = NOC__c.class.getFields();
                        for (int j = 0; j < fields.length; j++)
                            if (name.toLowerCase().equals(fields[j].getName().toLowerCase()))
                                try {
                                    fields[j].set(_noc, stringValue);
                                } catch (IllegalAccessException e) {
                                    e.printStackTrace();
                                }
                    } else {
                        getNocAndFields(visaJson, field, _noc);
                        Field[] fields = NOC__c.class.getFields();
                        for (int j = 0; j < fields.length; j++)
                            if (name.toLowerCase().equals(fields[j].getName().toLowerCase()))
                                try {
                                    stringValue = (String) fields[j].get(_noc);
                                } catch (IllegalAccessException e) {
                                    e.printStackTrace();
                                }
                    }

                    etEmail.setText(stringValue);
                    etEmail.setTag(field);
                    etEmail.setInputType(InputType.TYPE_TEXT_VARIATION_WEB_EMAIL_ADDRESS);

                    etEmail.addTextChangedListener(new GenericTextWatcher(etEmail, _noc));
                    tvLabel.setText(field.getMobileLabel());
                    linearLayout.addView(view);
                } else if (field.getType().equals("DOUBLE")) {
                    View view = inflater.inflate(R.layout.wizard_form_field_label_enabled, null, false);
                    EditText etEmail = (EditText) view.findViewById(R.id.formFieldvalue);
                    TextView tvLabel = (TextView) view.findViewById(R.id.formFieldLabel);

                    TextView formFieldLabelrequired = (TextView) view.findViewById(R.id.formFieldLabelrequired);
                    if (field.isRequired())
                        formFieldLabelrequired.setVisibility(View.VISIBLE);
                    String stringValue = "";
                    String name = field.getName();
                    etEmail.setText(stringValue);
                    etEmail.setHint(field.getMobileLabel());
                    etEmail.setTag(field);
                    etEmail.setInputType(InputType.TYPE_CLASS_NUMBER);
                    etEmail.addTextChangedListener(new GenericTextWatcher(etEmail, _noc));
                    tvLabel.setText(field.getMobileLabel());

                    linearLayout.addView(view);
                } else if (field.getType().equals("STRING")) {
                    View view = inflater.inflate(R.layout.wizard_form_field_label_enabled, null, false);
                    EditText etEmail = (EditText) view.findViewById(R.id.formFieldvalue);
                    TextView tvLabel = (TextView) view.findViewById(R.id.formFieldLabel);

                    TextView formFieldLabelrequired = (TextView) view.findViewById(R.id.formFieldLabelrequired);
                    if (field.isRequired())
                        formFieldLabelrequired.setVisibility(View.VISIBLE);
                    String stringValue = "";
                    String name = field.getName();
                    etEmail.setText(stringValue);
                    etEmail.setTag(field);
                    etEmail.setInputType(InputType.TYPE_CLASS_TEXT);
                    etEmail.addTextChangedListener(new GenericTextWatcher(etEmail, _noc));
                    tvLabel.setText(field.getMobileLabel());
                    etEmail.setHint(field.getMobileLabel());

                    linearLayout.addView(view);
                }

            } else if (field.isParameter() == false && field.isQuery() == true) {
                if (field.getType().equals("STRING")) {
                    getNocAndFields(visaJson, field, _noc);

                    View view = null;
                    TextView tvLabel;
                    EditText tvValue;

                    if (field.isCalculated()) {
                        view = inflater.inflate(R.layout.wizard_form_field_label_disabled, null, false);
                    } else {
                        view = inflater.inflate(R.layout.wizard_form_field_label_enabled, null, false);
                    }

                    tvLabel = (TextView) view.findViewById(R.id.formFieldLabel);
                    tvValue = (EditText) view.findViewById(R.id.formFieldvalue);
                    tvLabel.setText(field.getMobileLabel());

                    String stringValue = "";
                    String name = field.getName();
                    Field[] fields = NOC__c.class.getFields();
                    for (int j = 0; j < fields.length; j++)
                        if (name.toLowerCase().equals(fields[j].getName().toLowerCase()))
                            try {
                                stringValue = (String) fields[j].get(_noc);
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            }
                    tvValue.setText(stringValue);
                    linearLayout.addView(view);

                }
            } else if (field.isParameter() == true && field.isQuery() == false) {


                View view = null;
                TextView tvLabel;
                EditText tvValue;


                view = inflater.inflate(R.layout.wizard_form_field_label_disabled, null, false);


                tvLabel = (TextView) view.findViewById(R.id.formFieldLabel);
                tvValue = (EditText) view.findViewById(R.id.formFieldvalue);
                tvLabel.setText(field.getMobileLabel());
                tvValue.setText(parameters.get(field.getTextValue()));
                String name = field.getName();
                Field[] fields = NOC__c.class.getFields();
                for (int j = 0; j < fields.length; j++)
                    if (name.toLowerCase().equals(fields[j].getName().toLowerCase()))
                        try {
                            fields[j].set(_noc, parameters.get(field.getTextValue()));
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                linearLayout.addView(view);


            }

        }


    }

    private static class DownloadAttachmentBodyForRoundedImage extends AsyncTask<Void, Void, Void> {


        private final RestClient client;
        private final Attachment attachment;
        String path;
        RoundedImageView smartImageView;
        boolean isFound = false;

        public DownloadAttachmentBodyForRoundedImage(RestClient client, Attachment attachment, RoundedImageView smartImageView) {
            this.client = client;
            this.attachment = attachment;
            this.smartImageView = smartImageView;
        }

        @Override
        protected Void doInBackground(Void... params) {
            String attUrl = client.getClientInfo().resolveUrl(attachment.getBody()).toString();
            HttpClient tempClient = new DefaultHttpClient();
            URI theUrl = null;
            try {
                String extStorageDirectory = Environment.getExternalStorageDirectory().toString();
                File folder = new File(extStorageDirectory, "attachment-export");
                if (!folder.exists()) {
                    folder.mkdir();
                }

                ArrayList<String> filesname = getListOfAttachments();
                for (int i = 0; i < filesname.size(); i++) {
                    if (filesname.get(i).equals(attachment.getID())) {
                        isFound = true;
                        break;
                    }
                }

                if (!isFound) {
                    theUrl = new URI(attUrl);
                    HttpGet getRequest = new HttpGet();
                    getRequest.setURI(theUrl);
                    getRequest.setHeader("Authorization", "Bearer " + client.getAuthToken());
                    HttpResponse httpResponse = null;
                    try {
                        httpResponse = tempClient.execute(getRequest);
                        StatusLine statusLine = httpResponse.getStatusLine();
                        if (statusLine.getStatusCode() == HttpStatus.SC_OK) {
                            FileOutputStream fos = null;
                            fos = new FileOutputStream(new File(Environment.getExternalStorageDirectory(), "/attachment-export/" + attachment.getID()));
                            path = Environment.getExternalStorageDirectory() + "/attachment-export/" + attachment.getID();
                            HttpEntity entity = httpResponse.getEntity();
                            entity.writeTo(fos);
                            entity.consumeContent();
                            fos.flush();
                            fos.close();
                        } else {
                            httpResponse.getEntity().getContent().close();
                            throw new IOException(statusLine.getReasonPhrase());
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    path = Environment.getExternalStorageDirectory() + "/attachment-export/" + attachment.getID();
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            Bitmap bitmap = BitmapFactory.decodeFile(path, options);
            smartImageView.setImageBitmap(bitmap);
        }
    }


    private static class DownloadAttachmentBody extends AsyncTask<Void, Void, Void> {


        private final RestClient client;
        private final Attachment attachment;
        String path;
        ImageView smartImageView;
        boolean isFound = false;

        public DownloadAttachmentBody(RestClient client, Attachment attachment, ImageView smartImageView) {
            this.client = client;
            this.attachment = attachment;
            this.smartImageView = smartImageView;
        }

        @Override
        protected Void doInBackground(Void... params) {
            String attUrl = client.getClientInfo().resolveUrl(attachment.getBody()).toString();
            HttpClient tempClient = new DefaultHttpClient();
            URI theUrl = null;
            try {
                String extStorageDirectory = Environment.getExternalStorageDirectory().toString();
                File folder = new File(extStorageDirectory, "attachment-export");
                if (!folder.exists()) {
                    folder.mkdir();
                }

                ArrayList<String> filesname = getListOfAttachments();
                for (int i = 0; i < filesname.size(); i++) {
                    if (filesname.get(i).equals(attachment.getID())) {
                        isFound = true;
                        break;
                    }
                }

                if (!isFound) {
                    theUrl = new URI(attUrl);
                    HttpGet getRequest = new HttpGet();
                    getRequest.setURI(theUrl);
                    getRequest.setHeader("Authorization", "Bearer " + client.getAuthToken());
                    HttpResponse httpResponse = null;
                    try {
                        httpResponse = tempClient.execute(getRequest);
                        StatusLine statusLine = httpResponse.getStatusLine();
                        if (statusLine.getStatusCode() == HttpStatus.SC_OK) {
                            FileOutputStream fos = null;
                            fos = new FileOutputStream(new File(Environment.getExternalStorageDirectory(), "/attachment-export/" + attachment.getID()));
                            path = Environment.getExternalStorageDirectory() + "/attachment-export/" + attachment.getID();
                            HttpEntity entity = httpResponse.getEntity();
                            entity.writeTo(fos);
                            entity.consumeContent();
                            fos.flush();
                            fos.close();
                        } else {
                            httpResponse.getEntity().getContent().close();
                            throw new IOException(statusLine.getReasonPhrase());
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    path = Environment.getExternalStorageDirectory() + "/attachment-export/" + attachment.getID();
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            Bitmap bitmap = BitmapFactory.decodeFile(path, options);
            smartImageView.setImageBitmap(bitmap);
        }
    }


    private static ArrayList<String> getListOfAttachments() {
        File sdCardRoot = Environment.getExternalStorageDirectory();

        File yourDir = new File(sdCardRoot, "attachment-export");
        ArrayList<String> filesname = new ArrayList<String>();
        for (File f : yourDir.listFiles()) {
            if (f.isFile()) {
                filesname.add(f.getName());
            }
        }

        return filesname;
    }

    public static long daysDifference(String expiryDate) {

        String ActualExpiryDate = "";
        long diffSeconds;
        long diffMinutes;
        long diffHours;
        long diffDays = 0;

        String[] expiry_date_array = expiryDate.split("-");

        long diff = 0;

        ActualExpiryDate = expiry_date_array[1] + "/" + expiry_date_array[2] + "/" + expiry_date_array[0] + " 09:29:58";

        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

        Calendar cal = Calendar.getInstance();
        String today = format.format(cal.getTime());
        Date d1 = null;
        Date d2 = null;

        try {
            d1 = format.parse(ActualExpiryDate);
            d2 = format.parse(today);
            diff = d1.getTime() - d2.getTime();
//            diffSeconds = diff / 1000 % 60;
//            diffMinutes = diff / (60 * 1000) % 60;
//            diffHours = diff / (60 * 60 * 1000) % 24;
            diffDays = diff / (24 * 60 * 60 * 1000);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return diffDays;
    }

    public static View drawViewsOnLayout(Object object, Context applicationContext, ArrayList<DWCView> _views) {

        LayoutInflater inflater = (LayoutInflater)
                applicationContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        LinearLayout linear;

        View view = inflater.inflate(R.layout.fragment_generic, null, false);
        linear = (LinearLayout) view.findViewById(R.id.relativeViews);
        for (int i = 0; i < _views.size(); i++) {
            if (_views.get(i).getType() == ItemType.HEADER) {
                View viewHeader = LayoutInflater.from(applicationContext).inflate(R.layout.generic_view_header_item, null);
                TextView tvHeader = (TextView) viewHeader.findViewById(R.id.tvHeader);
                tvHeader.setText(_views.get(i).getValue());
                if (i == 0) {
                    linear.addView(viewHeader);
                } else {
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                    params.topMargin = 10;
                    params.leftMargin = 5;
                    params.bottomMargin = 10;
                    viewHeader.setLayoutParams(params);
                    linear.addView(viewHeader);
                }
            } else if (_views.get(i).getType() == ItemType.LABEL) {

                View viewHeader = LayoutInflater.from(applicationContext).inflate(R.layout.generic_view_label_item, null);
                TextView tvHeader = (TextView) viewHeader.findViewById(R.id.tvLabelItem);
                tvHeader.setText(_views.get(i).getValue());
                if (i == 0) {
                    linear.addView(viewHeader);
                } else {
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                    params.topMargin = 10;
                    params.leftMargin = 5;
                    params.bottomMargin = 10;
                    viewHeader.setLayoutParams(params);
                    linear.addView(viewHeader);
                }

            } else if (_views.get(i).getType() == ItemType.VALUE) {

                View viewHeader = LayoutInflater.from(applicationContext).inflate(R.layout.generic_view_value_item, null);
                TextView tvHeader = (TextView) viewHeader.findViewById(R.id.tvValueItem);
                tvHeader.setText(_views.get(i).getValue());
                if (i == 0) {
                    linear.addView(viewHeader);
                } else {
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                    params.topMargin = 10;
                    params.leftMargin = 5;
                    params.bottomMargin = 10;
                    viewHeader.setLayoutParams(params);
                    linear.addView(viewHeader);
                }

            } else if (_views.get(i).getType() == ItemType.HORIZONTAL_LIST_VIEW) {

                View viewHeader = LayoutInflater.from(applicationContext).inflate(R.layout.generic_view_horizontal_list_view_item, null);
                final HorizontalListView hlvServices = (HorizontalListView) viewHeader.findViewById(R.id.hlvServices);
                String[] services;
                if (_views.get(i).getValue().contains(",")) {
                    services = _views.get(i).getValue().split(",");
                } else {
                    services = new String[1];
                    services[0] = _views.get(i).getValue();
                }

                ArrayList<ServiceItem> _items = new ArrayList<ServiceItem>();
                for (int j = 0; j < services.length; j++) {
                    if (services[j].toLowerCase().trim().replace(" ", "").equals("NewNOC".toLowerCase())) {
                        _items.add(new ServiceItem("New NOC", R.drawable.noc_service_image));
                    } else if (services[j].toLowerCase().trim().replace(" ", "").equals("AddressChange".toLowerCase())) {
                        _items.add(new ServiceItem("Address Change", R.drawable.address_change_service));
                    } else if (services[j].toLowerCase().trim().replace(" ", "").equals("NameChange".toLowerCase())) {
                        _items.add(new ServiceItem("Name Change", R.drawable.name_change_service));
                    } else if (services[j].toLowerCase().trim().replace(" ", "").equals("LicenseRenewal".toLowerCase())) {
                        _items.add(new ServiceItem("License Renewal", R.drawable.renew_license));
                    } else if (services[j].toLowerCase().trim().replace(" ", "").equals("CancelVisa".toLowerCase())) {
                        _items.add(new ServiceItem("Cancel Visa", R.drawable.cancel_visa));
                    } else if (services[j].toLowerCase().trim().replace(" ", "").equals("NewNOCCompany".toLowerCase())) {
                        _items.add(new ServiceItem("New NOC", R.drawable.company_noc));
                    } else if (services[j].toLowerCase().trim().replace(" ", "").equals("NameReservation".toLowerCase())) {
                        _items.add(new ServiceItem("Name Reservation", R.drawable.name_change_service));
                    } else if (services[j].toLowerCase().trim().replace(" ", "").equals("NameChange".toLowerCase())) {
                        _items.add(new ServiceItem("Name Change", R.drawable.reports_myrequests));
                    } else if (services[j].toLowerCase().trim().replace(" ", "").equals("CapitalChange".toLowerCase())) {
                        _items.add(new ServiceItem("Capital Change", R.drawable.reports_myrequests));
                    } else if (services[j].toLowerCase().trim().replace(" ", "").equals("AddressChange".toLowerCase())) {
                        _items.add(new ServiceItem("Address Change", R.drawable.reports_myrequests));
                    }
                }

                if (_items.size() > 0) {

                    if (i == 0) {
                        linear.addView(viewHeader);
                    } else {
                        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                        params.topMargin = 10;
                        params.leftMargin = 5;
                        params.bottomMargin = 10;
                        viewHeader.setLayoutParams(params);
                        hlvServices.setAdapter(new HorizontalListViewAdapter(object, applicationContext, _items));
//                        hlvServices.requestFocus();
//                        hlvServices.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//                            @Override
//                            public void onFocusChange(View v, boolean hasFocus) {
//                                if (hasFocus) {
//                                    hlvServices.requestFocus();
//                                    hlvServices.setFocusable(true);
//                                } else {
//                                    hlvServices.setFocusable(false);
//                                }
//                            }
//                        });
                        linear.addView(viewHeader);
                    }
                }

            } else if (_views.get(i).getType() == ItemType.LINE) {
                View viewHeader = LayoutInflater.from(applicationContext).inflate(R.layout.generic_view_line_item, null);
                if (i == 0) {
                    linear.addView(viewHeader);
                } else {
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                    params.topMargin = 7;
                    params.leftMargin = 4;
                    params.bottomMargin = 7;
                    viewHeader.setLayoutParams(params);
                    linear.addView(viewHeader);
                }
            }
        }
        return view;
    }

    public static String stringNotNull(String s) {
        return s == null ? "" : s;
    }

    public static User getUserObject(Context context) {
        Gson gson = new Gson();
        User _user = gson.fromJson(new StoreData(context).getUserDataAsString(), User.class);
        return _user;
    }


    public static void getNocAndFields(JSONObject visa, FormField f, NOC__c _noc) {
        String key = f.getTextValue();
        if (key == null)
            return;
        String[] splits = key.split("\\.");
        List<String> keys = new ArrayList<String>();
        for (int i = 0; i < splits.length; i++)
            keys.add(splits[i]);
        String value = getValueFromJson(keys, visa);
        String name = f.getName();
        Field[] fields;
        fields = NOC__c.class.getFields();
        for (int i = 0; i < fields.length; i++) {
            if (name.toLowerCase().equals(fields[i].getName().toLowerCase())) {
                if (f.getType().equals("STRING") || f.getType().equals("EMAIL")) {
                    try {
                        fields[i].set(_noc, value == null ? "" : value);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                } else if (f.getType().equals("BOOLEAN")) {
                    try {
                        fields[i].set(_noc, Boolean.valueOf(value));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }


        return;
    }

    public static boolean flag = false;

    public static String getValueFromJson(List<String> key, JSONObject json) {
        String result = null;
        for (int i = 0; i < key.size(); i++) {
            if (i == (key.size() - 1)) {
                try {
                    result = json.getString(key.get(i));

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                JSONObject jsonObject = json.optJSONObject(key.get(i));
                key.remove(i);
                result = getValueFromJson(key, jsonObject);
            }
        }
        return result;
    }


    public static String encodeTobase64(Bitmap image) {
        Bitmap immagex = image;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        immagex.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] b = baos.toByteArray();
        String imageEncoded = Base64.encodeToString(b, Base64.DEFAULT);
        Log.e("LOOK", imageEncoded);
        return imageEncoded;
    }


    public static Bitmap decodeFile(File f, int WIDTH, int HIGHT) {
        try {
            //Decode image size
            BitmapFactory.Options o = new BitmapFactory.Options();
            o.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(new FileInputStream(f), null, o);

            //The new size we want to scale to
            final int REQUIRED_WIDTH = WIDTH;
            final int REQUIRED_HIGHT = HIGHT;
            //Find the correct scale value. It should be the power of 2.
            int scale = 1;
            while (o.outWidth / scale / 2 >= REQUIRED_WIDTH && o.outHeight / scale / 2 >= REQUIRED_HIGHT)
                scale *= 2;

            //Decode with inSampleSize
            BitmapFactory.Options o2 = new BitmapFactory.Options();
            o2.inSampleSize = scale;
            return BitmapFactory.decodeStream(new FileInputStream(f), null, o2);
        } catch (FileNotFoundException e) {
        }
        return null;
    }

    public static void setEServiceAdministration(Receipt_Template__c eServiceAdministration) {
        Utilities.eServiceAdministration = eServiceAdministration;
    }

    public static Receipt_Template__c geteServiceAdministration() {
        return eServiceAdministration;
    }

    //Declaration
    private static class GenericTextWatcherCard implements TextWatcher {

        private View view;
        Card_Management__c _noc;

        private GenericTextWatcherCard(View view, Card_Management__c _noc) {
            this.view = view;
            this._noc = _noc;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {
            String text = editable.toString();
            FormField f = (FormField) view.getTag();
            String name = f.getName();
            Field[] fields = Card_Management__c.class.getFields();
            for (int j = 0; j < fields.length; j++)
                if (name.toLowerCase().equals(fields[j].getName().toLowerCase()))
                    try {
                        if (f.getType().equals("DOUBLE"))
                            fields[j].set(_noc, Double.parseDouble(text));
                        else
                            fields[j].set(_noc, text);

                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

        }
    }

    //Declaration
    private static class GenericTextWatcher implements TextWatcher {

        private View view;
        NOC__c _noc;

        private GenericTextWatcher(View view, NOC__c _noc) {
            this.view = view;
            this._noc = _noc;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {
            String text = editable.toString();
            FormField f = (FormField) view.getTag();
            String name = f.getName();
            Field[] fields = NOC__c.class.getFields();
            for (int j = 0; j < fields.length; j++)
                if (name.toLowerCase().equals(fields[j].getName().toLowerCase()))
                    try {
                        if (f.getType().equals("DOUBLE"))
                            fields[j].set(_noc, Double.parseDouble(text));
                        else
                            fields[j].set(_noc, text);

                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

        }
    }


    public void ValidateAndDrawFormFields(Activity activity, RestClient client, ArrayList<FormField> formFields, WebForm webForm, Map<String, String> parameters, RelatedServiceType serviceType, Object object) {

        String selectVisaAccountQuery = "SELECT Id";
        String selectObjectQuery = "SELECT Id";
        boolean queryFields = false;
        Gson gson = new Gson();
        User user = gson.fromJson(new StoreData(activity.getApplicationContext()).getUserDataAsString(), User.class);

        Utilities.showloadingDialog(activity);
        for (int i = 0; i < formFields.size(); i++) {
            FormField formField = formFields.get(i);
            if (formField.getType().equals("PICKLIST")) {
                try {
                    new GetPicklistItems(client, formField, i, formFields).execute().get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            } else if (formField.getType().equals("REFERENCE") && !formField.isParameter()) {
                try {
                    new GetReferenceItems(client, formField, i, formFields).execute().get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }

        for (int i = 0; i < formFields.size(); i++) {
            FormField formField = formFields.get(i);
            if (formField.isParameter()) {
                formField.setFormFieldValue(parameters.get(formField.getTextValue()));
            }

            if (formField.getType().equals("CUSTOMTEXT")) {
                continue;
            }

            if (formField.getType().equals("REFERENCE")) {
                String id = formField.getName().replace("__c", "__r.Id");
                String name = formField.getName().replace("__c", "__r.Name");
                selectObjectQuery += ", " + id + ", " + name;
            } else {
                selectObjectQuery += ", " + formField.getName();
            }

            if (!formField.isQuery()) {
                continue;
            }

            queryFields = true;
            selectVisaAccountQuery += ", " + formField.getTextValue();
        }

        if (queryFields) {
            if (serviceType == RelatedServiceType.RelatedServiceTypeNewCompanyNOC) {
                selectVisaAccountQuery += " FROM Account WHERE ID = " + "\'" + "%s" + "\'" + " LIMIT 1";
                selectVisaAccountQuery = String.format(selectVisaAccountQuery, user.get_contact().get_account().getID());
            } else {
                selectVisaAccountQuery += " FROM Visa__c WHERE ID = " + "\'" + "%s" + "\'" + " LIMIT 1";
                Visa visa = (Visa) object;
                selectVisaAccountQuery = String.format(selectVisaAccountQuery, visa.getID());
            }
        } else {
            getObjectValue(webForm, selectObjectQuery, object);
        }
    }

    private void getObjectValue(WebForm webForm, String selectObjectQuery, Object object) {
        String soql = selectObjectQuery + " FROM %s WHERE ID = ";
        soql = String.format(soql, webForm.getObject_Name());
        if (webForm.getObject_Name().equals("Card_Management__c")) {
            Card_Management__c card_management__c = (Card_Management__c) object;
            soql += card_management__c.getId();
        } else {
            displayWebForm(webForm, selectObjectQuery, object);
        }
    }

    private void displayWebForm(WebForm webForm, String selectObjectQuery, Object object) {


    }

    private void CallReferenceWebService(RestClient client, final FormField formField, int i, ArrayList<FormField> formFields, Activity activity) {

        String soql = String.format("SELECT Id, Name FROM %s ORDER BY Name", formField.getTextValue());
        try {
            RestRequest restRequest = RestRequest.getRequestForQuery(activity.getString(R.string.api_version), soql);
            client.sendAsync(restRequest, new RestClient.AsyncRequestCallback() {
                @Override
                public void onSuccess(RestRequest request, RestResponse response) {


                }

                @Override
                public void onError(Exception exception) {

                }
            });
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public class GetReferenceItems extends AsyncTask<Void, Void, Void> {


        public GetReferenceItems(RestClient client, FormField formField, int i, ArrayList<FormField> formFields) {

        }

        @Override
        protected Void doInBackground(Void... params) {
            return null;
        }
    }

    public class GetPicklistItems extends AsyncTask<Void, Void, Void> {

        private RestClient client;
        private FormField formfield;
        private int position;
        ArrayList<FormField> formFields;

        public GetPicklistItems(RestClient client, FormField formField, int position, ArrayList<FormField> formFields) {
            this.client = client;
            this.formfield = formField;
            this.position = position;
            this.formFields = formFields;
        }

        @Override
        protected Void doInBackground(Void... params) {
            CallPicklistWebService(client, formfield, position, formFields);
            return null;
        }
    }


    private static void CallPicklistWebService(RestClient client, FormField formField, int i, ArrayList<FormField> formFields) {

        String result = "";
        String attUrl = client.getClientInfo().resolveUrl("/services/apexrest/MobilePickListValuesWebService?fieldId=").toString();
        HttpClient tempClient = new DefaultHttpClient();

        URI theUrl = null;
        try {
            theUrl = new URI(attUrl + formField.getId());
            HttpGet getRequest = new HttpGet();
            getRequest.setURI(theUrl);
            getRequest.setHeader("Authorization", "Bearer " + client.getAuthToken());
            BasicHttpParams param = new BasicHttpParams();
            getRequest.setParams(param);
            HttpResponse httpResponse = null;
            try {
                httpResponse = tempClient.execute(getRequest);
                StatusLine statusLine = httpResponse.getStatusLine();
                if (statusLine.getStatusCode() == HttpStatus.SC_OK) {
                    HttpEntity httpEntity = httpResponse.getEntity();
                    if (httpEntity != null) {
                        result = EntityUtils.toString(httpEntity);
                        JSONObject jo = null;
                        try {
                            jo = new JSONObject(result);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        JSONArray ja = null;
                        ja = jo.getJSONArray("Requested_From__c");
                        formField.setPicklistEntries(convertJsonStringToString(ja));
                        formFields.set(i, formField);
                    }
                } else {
                    httpResponse.getEntity().getContent().close();
                    throw new IOException(statusLine.getReasonPhrase());
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public static String convertJsonStringToString(JSONArray jsonArray) {
        String result = "";
        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                result += jsonArray.getString(i);
                if (i != (jsonArray.length() - 1))
                    result += ",";
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static int daysBetween(Date d1, Date d2) {
        return (int) ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
    }

    public static String getCurrentTimeStamp() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        String strDate = sdfDate.format(now);
        return strDate;
    }
}