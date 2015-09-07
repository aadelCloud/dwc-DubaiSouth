package fragmentActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;

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

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import RestAPI.RestMessages;
import cloudconcept.dwc.R;
import dataStorage.StoreData;
import exceptionHandling.ExceptionHandler;
import fragment.Cards.CancelCard.CancelCardMainFragment;
import fragment.Cards.NOCAttachmentPage;
import fragment.Cards.NewCard.MainNewCardFragment;
import model.Card_Management__c;
import model.Company_Documents__c;
import model.Country__c;
import model.Receipt_Template__c;
import model.User;
import model.WebForm;
import utilities.Utilities;

/**
 * Created by Abanoub Wagdy on 8/19/2015.
 */
public class CardActivity extends BaseFragmentActivity {


    private ArrayList<Company_Documents__c> companyDocuments;

    public Card_Management__c getCard() {
        return card;
    }

    public void setCard(Card_Management__c card) {
        this.card = card;
    }

    private Card_Management__c card;

    public String getDuration() {
        return Duration;
    }

    public void setDuration(String duration) {
        Duration = duration;
    }

    private String Duration;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private User user;

    private String cardType;

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardRecordId() {
        return cardRecordId;
    }

    public void setCardRecordId(String cardRecordId) {
        this.cardRecordId = cardRecordId;
    }

    public String getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }

    private RestRequest restRequest;

    public String getInsertedCaseId() {
        return insertedCaseId;
    }

    public void setInsertedCaseId(String insertedCaseId) {
        this.insertedCaseId = insertedCaseId;
    }

    public String getCaseRecordTypeId() {
        return caseRecordTypeId;
    }

    public void setCaseRecordTypeId(String caseRecordTypeId) {
        this.caseRecordTypeId = caseRecordTypeId;
    }

    public String getInsertedServiceId() {
        return insertedServiceId;
    }

    public void setInsertedServiceId(String insertedServiceId) {
        this.insertedServiceId = insertedServiceId;
    }

    private String insertedCaseId = null;
    private String caseRecordTypeId = null;
    private String insertedServiceId = null;
    private String cardRecordId = null;

    public ArrayList<Country__c> getCountries() {
        return countries;
    }

    public void setCountries(ArrayList<Country__c> countries) {
        this.countries = countries;
    }

    ArrayList<Country__c> countries;

    public String getCardRecordTypeId() {
        return cardRecordTypeId;
    }

    public void setCardRecordTypeId(String cardRecordTypeId) {
        this.cardRecordTypeId = cardRecordTypeId;
    }

    private String cardRecordTypeId = null;
    private String caseNumber = null;
    private Map<String, Object> caseFields = new HashMap<String, Object>();
    private Map<String, Object> serviceFields = new HashMap<String, Object>();
    private Map<String, String> parameters = new HashMap<String, String>();

    public Map<String, String> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }


    public WebForm get_webForm() {
        return _webForm;
    }

    public void set_webForm(WebForm _webForm) {
        this._webForm = _webForm;
    }

    public Map<String, Object> getServiceFields() {
        return serviceFields;
    }

    public void setServiceFields(Map<String, Object> serviceFields) {
        this.serviceFields = serviceFields;
    }

    public Map<String, Object> getCaseFields() {
        return caseFields;
    }

    public void setCaseFields(Map<String, Object> caseFields) {
        this.caseFields = caseFields;
    }

    private WebForm _webForm;


    private FragmentManager fragmentManager;
    private Gson gson;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler(this));
        setContentView(R.layout.new_card);
        gson = new Gson();
        user = gson.fromJson(new StoreData(getApplicationContext()).getUserDataAsString(), User.class);

        type = getIntent().getExtras().getString("type");
        if (getIntent().getExtras() != null) {
            if (getIntent().getExtras().containsKey("card")) {
                setCard((Card_Management__c) getIntent().getExtras().get("card"));
                card.setNationality__c(card.getNationality__r().getName());
                card.setAccount__c(card.getAccount__r().getName());

            } else
                card = new Card_Management__c();
        } else {
            card = new Card_Management__c();
        }

        if (type.equals("1")) {
            fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, MainNewCardFragment.newInstance("NewCard"))
                    .commit();
        } else  {
            fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, CancelCardMainFragment.newInstance("CancelCard"))
                    .commit();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                Utilities.showloadingDialog(this, "Uploading ....");
                company_documents__c = new Company_Documents__c();
                String result = data.getStringExtra("result");
                int position = data.getIntExtra("position", -1);
                company_documents__c = gson.fromJson(result, Company_Documents__c.class);
                ConnectAttachmentWithCompanyDocument(company_documents__c, position);
            } else if (resultCode == RESULT_CANCELED) {
                int position = data.getIntExtra("position", -1);
                NOCAttachmentPage.setReturnedCompnayDocument(company_documents__c, position);
            }
        } else if (requestCode == RESULT_LOAD_IMG_FROM_GALLERY) {
            if (resultCode == RESULT_OK) {
                Utilities.showloadingDialog(this, "Uploading ....");
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
                NOCAttachmentPage.setReturnedCompnayDocument(company_documents__c, position);
            }

        } else if (requestCode == RESULT_LOAD_IMG_FROM_CAMERA) {
            if (resultCode == RESULT_OK) {
                Utilities.showloadingDialog(this, "Uploading ....");
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
                NOCAttachmentPage.setReturnedCompnayDocument(company_documents__c, position);
            }
        }
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
                        SalesforceSDKManager.getInstance().logout(CardActivity.this);
                        return;
                    } else {
                        client.sendAsync(restRequest, new RestClient.AsyncRequestCallback() {
                            @Override
                            public void onSuccess(RestRequest request, RestResponse result) {
                                Utilities.dismissLoadingDialog();
                                Log.d("", result.toString());

                                NOCAttachmentPage.setReturnedCompnayDocument(company_documents__c, position);
                            }

                            @Override
                            public void onError(Exception exception) {
                                Utilities.dismissLoadingDialog();
                                Utilities.showToast(CardActivity.this, RestMessages.getInstance().getErrorMessage());
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
        caseFields = new HashMap<String, Object>();
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
                        SalesforceSDKManager.getInstance().logout(CardActivity.this);
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
                                Utilities.showToast(CardActivity.this, RestMessages.getInstance().getErrorMessage());
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

    public void setCompanyDocuments(ArrayList<Company_Documents__c> companyDocuments) {

        this.companyDocuments = companyDocuments;
    }

    public ArrayList<Company_Documents__c> getCompanyDocuments() {
        return companyDocuments;
    }
}
