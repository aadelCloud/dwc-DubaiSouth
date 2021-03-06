package fragmentActivity.CompanyNOC;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.android.volley.NetworkResponse;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.rest.ClientManager;
import com.salesforce.androidsdk.rest.RestClient;
import com.salesforce.androidsdk.rest.RestRequest;
import com.salesforce.androidsdk.rest.RestResponse;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import RestAPI.RestMessages;
import RestAPI.SFResponseManager;
import adapter.DWCExpandableListAdapter;
import cloudconcept.dwc.R;
import dataStorage.StoreData;
import exceptionHandling.ExceptionHandler;
import model.Account;
import model.Company_Documents__c;
import model.NOC__c;
import model.Visa;
import utilities.Utilities;

public class CompanyNocActivity extends FragmentActivity {

    private Gson gson;
    private Context ctx;
    private Activity act;
    private String objectType;
    private static Account _account;
    private FragmentManager fragmentManager;
    private static int RESULT_LOAD_IMG_FROM_GALLERY = 2;
    private static int RESULT_LOAD_IMG_FROM_CAMERA = 3;
    HashMap<String, Object> caseFields;
    private Company_Documents__c company_documents__c;
    RestRequest restRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler(this));
        setContentView(R.layout.noc);

        gson = new Gson();
        ctx = getApplicationContext();
        act = this;



        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.content_frame, CompanyNocMainFragment.newInstance("BaseEmployee", this))
                .commit();

    }

    private void ConnectAttachmentWithCompanyDocument(final Company_Documents__c company_documents__c, final int position) {
        Map<String, Object> fields = new HashMap<String, Object>();
        fields.put("Attachment_Id__c", company_documents__c.getAttachment_Id__c());
        try {
            restRequest = RestRequest.getRequestForUpdate(getString(R.string.api_version), "Company_Documents__c", company_documents__c.getId(), fields);
            new ClientManager(this, SalesforceSDKManager.getInstance().getAccountType(), SalesforceSDKManager.getInstance().getLoginOptions(), SalesforceSDKManager.getInstance().shouldLogoutWhenTokenRevoked()).getRestClient(this, new ClientManager.RestClientCallback() {
                @Override
                public void authenticatedRestClient(final RestClient client) {
                    if (client == null) {
                        SalesforceSDKManager.getInstance().logout(CompanyNocActivity.this);
                        return;
                    } else {
                        client.sendAsync(restRequest, new RestClient.AsyncRequestCallback() {
                            @Override
                            public void onSuccess(RestRequest request, RestResponse result) {
                                Utilities.dismissLoadingDialog();
                                Log.d("", result.toString());
                                CompanyNOCAttachmentPage.setReturnedCompnayDocument(company_documents__c, position);
                            }

                            @Override
                            public void onError(Exception exception) {
                                Utilities.dismissLoadingDialog();
                                Utilities.showToast(CompanyNocActivity.this, RestMessages.getInstance().getErrorMessage());
                                VolleyError volleyError = (VolleyError) exception;
                                NetworkResponse response = volleyError.networkResponse;
                                String json = new String(response.data);
                                Log.d("", json);
                            }
                        });

//                        String attUrl = client.getClientInfo().resolveUrl("/services/data/v26.0/sobjects/attachment").toString();
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void UploadCompanyDocumentAttachment(String filename, final Company_Documents__c company_documents__c, final int position, String encodedImage) {
        caseFields = new HashMap<>();
        caseFields.put("Name", filename);
        caseFields.put("ContentType", "image");
        caseFields.put("ParentId", company_documents__c.getId());
        caseFields.put("Body", encodedImage);
        try {
            restRequest = RestRequest.getRequestForCreate(getString(R.string.api_version), "Attachment", caseFields);
            new ClientManager(this, SalesforceSDKManager.getInstance().getAccountType(), SalesforceSDKManager.getInstance().getLoginOptions(), SalesforceSDKManager.getInstance().shouldLogoutWhenTokenRevoked()).getRestClient(this, new ClientManager.RestClientCallback() {
                @Override
                public void authenticatedRestClient(final RestClient client) {
                    if (client == null) {
                        SalesforceSDKManager.getInstance().logout(CompanyNocActivity.this);
                        return;
                    } else {
                        client.sendAsync(restRequest, new RestClient.AsyncRequestCallback() {
                            @Override
                            public void onSuccess(RestRequest request, RestResponse result) {
                                Log.d("", result.toString());
                                try {
                                    JSONObject jsonObject = new JSONObject(result.toString());
                                    company_documents__c.setAttachment_Id__c(jsonObject.getString("id"));
                                    company_documents__c.setHasAttachment(true);
                                    ConnectAttachmentWithCompanyDocument(company_documents__c, position);
//                                    NOCAttachmentPage.setReturnedCompnayDocument(company_documents__c, position);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void onError(Exception exception) {
                                Utilities.showToast(CompanyNocActivity.this, RestMessages.getInstance().getErrorMessage());
                                Utilities.dismissLoadingDialog();
                            }
                        });

//                        String attUrl = client.getClientInfo().resolveUrl("/services/data/v26.0/sobjects/attachment").toString();
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                Utilities.showloadingDialog(this,"Uploading ....");
                company_documents__c = new Company_Documents__c();
                String result = data.getStringExtra("result");
                int position = data.getIntExtra("position", -1);
                company_documents__c = gson.fromJson(result, Company_Documents__c.class);
                ConnectAttachmentWithCompanyDocument(company_documents__c, position);
            } else if (resultCode == RESULT_CANCELED) {
                int position = data.getIntExtra("position", -1);
                CompanyNOCAttachmentPage.setReturnedCompnayDocument(company_documents__c, position);
            }
        } else if (requestCode == RESULT_LOAD_IMG_FROM_GALLERY) {
            if (resultCode == RESULT_OK) {
                Utilities.showloadingDialog(this,"Uploading ....");
                Uri selectedImage = data.getData();
                String[] filePathColumn = {MediaStore.Images.Media.DATA};
                Cursor cursor = getContentResolver().query(selectedImage,
                        filePathColumn, null, null, null);
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                String picturePath = cursor.getString(columnIndex);
                File file = new File(picturePath);
                Bitmap myBitmap = Utilities.decodeFile(file, 300, 300);
//                Bitmap myBitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
//                ByteArrayOutputStream bao = new ByteArrayOutputStream();
//                myBitmap.compress(Bitmap.CompressFormat.JPEG, 100, bao);
//                String imgDecodableString = cursor.getString(columnIndex);
//                String imgDecodableString = Utilities.encodeTobase64(myBitmap);
//                ByteArrayOutputStream bao = new ByteArrayOutputStream();
//                myBitmap.compress(Bitmap.CompressFormat.JPEG, 100, bao);
//                byte[] ba = bao.toByteArray();
                String encodedImage = Utilities.encodeTobase64(myBitmap);
                cursor.close();
                int position = Integer.valueOf(new StoreData(getApplicationContext()).getCompanyDocumentPosition());
                String result = new StoreData(getApplicationContext()).getCompanyDocumentObject();
                company_documents__c = gson.fromJson(result, Company_Documents__c.class);
                UploadCompanyDocumentAttachment(file.getName(), company_documents__c, position, encodedImage);
            } else if (resultCode == RESULT_CANCELED) {
                int position = Integer.valueOf(new StoreData(getApplicationContext()).getCompanyDocumentPosition());
                String result = new StoreData(getApplicationContext()).getCompanyDocumentObject();
                company_documents__c = gson.fromJson(result, Company_Documents__c.class);
                CompanyNOCAttachmentPage.setReturnedCompnayDocument(company_documents__c, position);
            }

        } else if (requestCode == RESULT_LOAD_IMG_FROM_CAMERA) {
            if (resultCode == RESULT_OK) {
                Utilities.showloadingDialog(this,"Uploading ....");
                Uri selectedImage = data.getData();
                String[] filePathColumn = {MediaStore.Images.Media.DATA};
                Cursor cursor = getContentResolver().query(selectedImage,
                        filePathColumn, null, null, null);
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                String picturePath = cursor.getString(columnIndex);
                File file = new File(picturePath);
                cursor.close();
//                Bitmap photo = (Bitmap) data.getExtras().get("data");
                Bitmap myBitmap = Utilities.decodeFile(file, 300, 300);
//                photo = Utilities.encodeTobase64(photo);

//                ByteArrayOutputStream bao = new ByteArrayOutputStream();
//                photo.compress(Bitmap.CompressFormat.JPEG, 100, bao);
//                byte[] ba = bao.toByteArray();
                String encodedImage = Utilities.encodeTobase64(myBitmap);
                int position = Integer.valueOf(new StoreData(getApplicationContext()).getCompanyDocumentPosition());
                String result = new StoreData(getApplicationContext()).getCompanyDocumentObject();
                company_documents__c = gson.fromJson(result, Company_Documents__c.class);
                UploadCompanyDocumentAttachment(file.getName(), company_documents__c, position, encodedImage);
            } else if (resultCode == RESULT_CANCELED) {
                int position = Integer.valueOf(new StoreData(getApplicationContext()).getCompanyDocumentPosition());
                String result = new StoreData(getApplicationContext()).getCompanyDocumentObject();
                company_documents__c = gson.fromJson(result, Company_Documents__c.class);
                CompanyNOCAttachmentPage.setReturnedCompnayDocument(company_documents__c, position);
            }
        }
    }

    private void UploadCompanyDocumentAttachment(final Company_Documents__c company_documents__c, final int position, String encodedImage) {
        caseFields = new HashMap<String, Object>();
        caseFields.put("Name", company_documents__c.getName());
        caseFields.put("ContentType", "image");
        caseFields.put("ParentId", company_documents__c.getEServices_Document__c());
        caseFields.put("Body", encodedImage);
        try {
            restRequest = RestRequest.getRequestForCreate(getString(R.string.api_version), "Attachment", caseFields);
            new ClientManager(this, SalesforceSDKManager.getInstance().getAccountType(), SalesforceSDKManager.getInstance().getLoginOptions(), SalesforceSDKManager.getInstance().shouldLogoutWhenTokenRevoked()).getRestClient(this, new ClientManager.RestClientCallback() {
                @Override
                public void authenticatedRestClient(RestClient client) {
                    if (client == null) {
                        SalesforceSDKManager.getInstance().logout(CompanyNocActivity.this);
                        return;
                    } else {

                        client.sendAsync(restRequest, new RestClient.AsyncRequestCallback() {
                            @Override
                            public void onSuccess(RestRequest request, RestResponse result) {

                                Log.d("", result.toString());

                                try {
                                    JSONObject jsonObject = new JSONObject(result.toString());
                                    company_documents__c.setAttachment_Id__c(jsonObject.getString("id"));
                                    company_documents__c.setHasAttachment(true);
                                    CompanyNOCAttachmentPage.setReturnedCompnayDocument(company_documents__c, position);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void onError(Exception exception) {
                                Utilities.showToast(CompanyNocActivity.this, RestMessages.getInstance().getErrorMessage());
                            }
                        });
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Account get_visa() {
        return _account;
    }

    @Override
    protected void onDestroy() {
        CompanyNocMainFragment._webForm=null;
        CompanyNocMainFragment._noc=new NOC__c();
        CompanyNocMainFragment.insertedCaseId=null;
        CompanyNocMainFragment.caseNummberId=null;
        CompanyNocMainFragment.insertedServiceId=null;
        super.onDestroy();
    }
    @Override
    public void onBackPressed() {

    }
}
