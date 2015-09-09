package RestAPI;

import android.util.Log;

import com.google.gson.Gson;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectReader;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Locale;

import model.Account;
import model.Attachment;
import model.Card_Management__c;
import model.Case;
import model.Company_Documents__c;
import model.Contact;
import model.Contract_DWC__c;
import model.Contract_Line_Item__c;
import model.Country__c;
import model.CountryofBirth;
import model.CurrentLicenseNumber;
import model.CurrentNationality;
import model.CurrentPassport;
import model.Director;
import model.Directorship;
import model.EServices_Document_Checklist__c;
import model.FreeZonePayment;
import model.Inventory_Unit__r;
import model.JobTitleAtImmigration;
import model.MyVisa;
import model.Product_Type__r;
import model.Quote;
import model.Receipt_Template__c;
import model.EmployeeRef;
import model.FormField;
import model.LegalRepresentative;
import model.LegalRepresentativeLookup;
import model.LicenseActivity;
import model.ManagementMember;
import model.Manager;
import model.MyRequest;
import model.Nationality;
import model.NotificationManagement;
import model.OriginalBusinessActivity;
import model.RecordType;
import model.Registration_Amendments__c;
import model.ShareOwnership;
import model.Shareholder;
import model.SponsoringCompany;
import model.User;
import model.Visa;
import model.VisaHolder;
import model.WebForm;

/**
 * Created by Abanoub on 6/15/2015.
 */
public class SFResponseManager {

    static User _user;
    private static Gson gson;

    public static User parseCompanyRestResponse(String companyRestResponse) {
        _user = new User();
        try {
            JSONObject jsonResult = new JSONObject(companyRestResponse);
            if (jsonResult.optBoolean(JSONConstants.DONE) == true) {
                JSONArray jsonRecords = jsonResult.getJSONArray(JSONConstants.RECORDS);
                for (int i = 0; i < jsonRecords.length(); i++) {
                    JSONObject jsonUser = jsonRecords.getJSONObject(i);
                    _user = parseUserObject(jsonUser);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return _user;
    }

    public static ArrayList<Card_Management__c> parseCardsData(String companyRestResponse) {
        ArrayList<Card_Management__c> _cards = new ArrayList<Card_Management__c>();
        Log.d("Card", companyRestResponse);
        Card_Management__c _card;
        try {
            JSONObject jsonResult = new JSONObject(companyRestResponse);
            if (jsonResult.optBoolean(JSONConstants.DONE) == true) {
                JSONArray jsonRecords = jsonResult.getJSONArray(JSONConstants.RECORDS);
                for (int i = 0; i < jsonRecords.length(); i++) {
                    _card = new Card_Management__c();
                    JSONObject jsonCard = jsonRecords.getJSONObject(i);
//                    gson = new Gson();
//                    _card = gson.fromJson(jsonCard.toString(), Card_Management__c.class);
                    ObjectReader or = new ObjectMapper().reader().withType(
                            Card_Management__c.class);
                    try {
                        _card = or.readValue(jsonCard.toString());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
//                    _card = parseCardsObject(_card, jsonCard);
                    _cards.add(_card);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return _cards;
    }

//    private static Card_Management__c parseCardsObject(Card_Management__c card, JSONObject jsonCard) {
//        RecordType _recordType = new RecordType();
//        Nationality _nationality = new Nationality();
//        try {
//            JSONObject jsonRecordType = jsonCard.getJSONObject("RecordType");
//            ObjectReader or = new ObjectMapper().reader().withType(
//                    RecordType.class);
//            try {
//                _recordType = or.readValue(jsonRecordType.toString());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
////            _recordType = gson.fromJson(jsonRecordType.toString(), RecordType.class);
//            JSONObject jsonNationality = jsonCard.getJSONObject("Nationality__r");
//            _nationality = gson.fromJson(jsonNationality.toString(), Nationality.class);
//            _nationality.setUrl(jsonRecordType.getJSONObject(JSONConstants.ATTRIBUTES).getString(JSONConstants.URL));
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
////        card.set(_recordType);
////        card.set_nationality(_nationality);
//        return card;
//    }


    private static User parseUserObject(JSONObject jsonUser) {

        try {
            _user.setUrl(jsonUser.getJSONObject(JSONConstants.ATTRIBUTES).getString(JSONConstants.URL));
            _user.setContactId(jsonUser.getString(JSONConstants.CONTACTID));
            JSONObject jsonContact = jsonUser.getJSONObject(JSONConstants.CONTACT);
            Contact _contact = parseContactObject(jsonContact);
            _user.set_contact(_contact);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return _user;
    }

    private static Contact parseContactObject(JSONObject jsonContact) {
        Contact _contact = new Contact();
        try {
            _contact.setUrl(jsonContact.getJSONObject(JSONConstants.ATTRIBUTES).getString(JSONConstants.URL));
            _contact.setName(jsonContact.getString(JSONConstants.NAME));
            _contact.setPersonal_Photo(jsonContact.getString(JSONConstants.PERSONAL_PHOTO));
            JSONObject jsonAccount = jsonContact.getJSONObject(JSONConstants.ACCOUNT);
            Account _account = parseAccountObject(jsonAccount);
            _contact.set_account(_account);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return _contact;
    }

    private static Account parseAccountObject(JSONObject jsonAccount) {
        Account _account = new Account();
        try {
            ObjectReader or = new ObjectMapper().reader().withType(
                    Account.class);
            try {
                _account = or.readValue(jsonAccount.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
//            _account.setUrl(jsonAccount.getJSONObject(JSONConstants.ATTRIBUTES).getString(JSONConstants.URL));
//            _account.setID(jsonAccount.getString(JSONConstants.ID));
//            _account.setName(jsonAccount.getString(JSONConstants.NAME));
//            _account.setAccountBalance(jsonAccount.getString(JSONConstants.ACCOUNT_BALANCE));
//            _account.setPortalBalance(jsonAccount.getString(JSONConstants.PORTAL_BALANCE));
//            _account.setName(jsonAccount.getString(JSONConstants.NAME));
//            _account.setArabicAccountName(jsonAccount.getString(JSONConstants.ARABIC_ACCOUNT_NAME));
//            _account.setLicenseNumberFormula(jsonAccount.getString(JSONConstants.LICENSE_NUMBER_FORMULA));
//            _account.setBillingCity(jsonAccount.getString(JSONConstants.BILLING_CITY));
//            _account.setBillingCountry(jsonAccount.getString(JSONConstants.BILLING_COUNTRY));
//            _account.setBillingPostalCode(jsonAccount.getString(JSONConstants.BILLING_POSTAL_CODE));
//            _account.setBillingState(jsonAccount.getString(JSONConstants.BILLING_STATE));
//            _account.setBillingStreet(jsonAccount.getString(JSONConstants.BILLING_STREET));
//            _account.setRegistrationNumberValue(jsonAccount.getString(JSONConstants.REGISTRATION_NUMBER));
//            _account.setAccountBalance(jsonAccount.getString(JSONConstants.ACCOUNT_BALANCE));
//            _account.setCompany_Logo(jsonAccount.getString(JSONConstants.COMPANY_LOGO));
//            _account.setEmail(jsonAccount.getString(JSONConstants.EMAIL));
//            _account.setProEmail(jsonAccount.getString(JSONConstants.PRO_EMAIL));
//            _account.setMobile(jsonAccount.getString(JSONConstants.MOBILE));
//            _account.setProMobileNumber(jsonAccount.getString(JSONConstants.PRO_MOBILE_NUMBER));

            JSONObject jsonCurentLicenseNumber = jsonAccount.getJSONObject(JSONConstants.CURRENT_LICENSE_NUMBER);
            // CurrentLicenseNumber _currentLicenseNumber = parseLicenseNumberObject(jsonCurentLicenseNumber);
            //  _account.set_currentLicenseNumber(_currentLicenseNumber);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return _account;
    }

    private static CurrentLicenseNumber parseLicenseNumberObject(JSONObject jsonCurentLicenseNumber) throws JSONException {
        CurrentLicenseNumber _currentLicenseNumber = new CurrentLicenseNumber();
        // _currentLicenseNumber.setUrl(jsonCurentLicenseNumber.getJSONObject(JSONConstants.ATTRIBUTES).getString(JSONConstants.URL));
        _currentLicenseNumber.setCommercial_Name(jsonCurentLicenseNumber.getString(JSONConstants.COMMERCIAL_NAME));
        _currentLicenseNumber.setCommercial_Name_Arabic(jsonCurentLicenseNumber.getString(JSONConstants.COMMERCIAL_ARABIC_NAME));
        _currentLicenseNumber.setId(jsonCurentLicenseNumber.getString(JSONConstants.ID));
        _currentLicenseNumber.setLicense_Expiry_Date(jsonCurentLicenseNumber.getString(JSONConstants.LICENSE_EXPIRY_DATE));
        _currentLicenseNumber.setLicense_Issue_Date(jsonCurentLicenseNumber.getString(JSONConstants.License_Issue_Date));
        _currentLicenseNumber.setValidity_Status(jsonCurentLicenseNumber.getString(JSONConstants.VALIDITY_STATUS));
        RecordType _recordType = new RecordType();
        JSONObject jsonRecordType = jsonCurentLicenseNumber.getJSONObject(JSONConstants.RECORD_TYPE);
        _recordType = parseRecordTypeobject(jsonRecordType);
        _currentLicenseNumber.set_recordType(_recordType);
        return _currentLicenseNumber;
    }

    private static RecordType parseRecordTypeobject(JSONObject jsonRecordType) throws JSONException {
//        RecordType _recordType = new RecordType();
//        _recordType.setUrl(jsonRecordType.getJSONObject(JSONConstants.ATTRIBUTES).getString(JSONConstants.URL));
//        _recordType.setId(jsonRecordType.getString(JSONConstants.ID));
//        _recordType.setDeveloperName(jsonRecordType.getString(JSONConstants.DEVELOPER_NAME));
//        _recordType.setName(jsonRecordType.getString(JSONConstants.NAME));
//        _recordType.setSobjectType(jsonRecordType.getString(JSONConstants.OBJECT_Type));

        ObjectReader or = new ObjectMapper().reader().withType(
                RecordType.class);
        RecordType _recordType = null;
        try {
            _recordType = or.readValue(jsonRecordType.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return _recordType;
    }

    public static ArrayList<Visa> parseVisaData(String s) {
        ArrayList<Visa> _visas = new ArrayList<Visa>();
        try {
            JSONObject jsonVisas = new JSONObject(s);
            if (jsonVisas.optBoolean(JSONConstants.DONE)) {
                JSONArray jsonArrayVisas = jsonVisas.getJSONArray(JSONConstants.RECORDS);
                for (int i = 0; i < jsonArrayVisas.length(); i++) {
                    JSONObject json = jsonArrayVisas.getJSONObject(i);
                    Visa _visa = parseVisaObject(json);
                    _visas.add(_visa);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return _visas;
    }

    public static Account parseAccountData(String s) {
        ArrayList<Account> _accounts = new ArrayList<Account>();
        try {
            JSONObject jsonVisas = new JSONObject(s);
            if (jsonVisas.optBoolean(JSONConstants.DONE)) {
                JSONArray jsonArrayVisas = jsonVisas.getJSONArray(JSONConstants.RECORDS);
                for (int i = 0; i < jsonArrayVisas.length(); i++) {
                    JSONObject json = jsonArrayVisas.getJSONObject(i);
                    Account _account = parseAccountDataObject(json.toString());
                    _accounts.add(_account);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return _accounts.get(0);
    }

    private static Account parseAccountDataObject(String s) {
        Account _account = new Account();
        ObjectReader or = new ObjectMapper().reader().withType(
                Account.class);
        try {
            _account = or.readValue(s);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return _account;
    }

    public static ArrayList<MyVisa> parseMyVisaData(String s) {
        ArrayList<MyVisa> _visas = new ArrayList<MyVisa>();
        try {
            JSONObject jsonVisas = new JSONObject(s);
            if (jsonVisas.optBoolean(JSONConstants.DONE)) {
                JSONArray jsonArrayVisas = jsonVisas.getJSONArray(JSONConstants.RECORDS);
                for (int i = 0; i < jsonArrayVisas.length(); i++) {
                    JSONObject json = jsonArrayVisas.getJSONObject(i);
                    MyVisa _visa = parseMyVisaObject(json);
                    _visas.add(_visa);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return _visas;
    }

    public static JSONObject parseJsonVisaData(String s) {
        ArrayList<JSONObject> _visas = new ArrayList<JSONObject>();
        try {
            JSONObject jsonVisas = new JSONObject(s);
            if (jsonVisas.optBoolean(JSONConstants.DONE)) {
                JSONArray jsonArrayVisas = jsonVisas.getJSONArray(JSONConstants.RECORDS);
                for (int i = 0; i < jsonArrayVisas.length(); i++) {
                    JSONObject json = jsonArrayVisas.getJSONObject(i);
                    Visa _visa = parseVisaObject(json);
                    _visas.add(json);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return _visas.get(0);
    }

    public static JSONObject parseJsonCardData(String s) {
        ArrayList<JSONObject> _cards = new ArrayList<JSONObject>();
        try {
            JSONObject jsonVisas = new JSONObject(s);
            if (jsonVisas.optBoolean(JSONConstants.DONE)) {
                JSONArray jsonArrayVisas = jsonVisas.getJSONArray(JSONConstants.RECORDS);
                for (int i = 0; i < jsonArrayVisas.length(); i++) {
                    JSONObject json = jsonArrayVisas.getJSONObject(i);
                    Visa _visa = parseVisaObject(json);
                    _cards.add(json);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return _cards.get(0);
    }


    private static Visa parseVisaObject(JSONObject json) {
        Visa _visa = new Visa();
//        Gson gson = new Gson();
//        _visa = gson.fromJson(json.toString(), Visa.class);
        ObjectReader or = new ObjectMapper().reader().withType(
                Visa.class);
        try {
            _visa = or.readValue(json.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

//        Log.d("json",json.toString());
//        try {
//            _visa.setUrl(json.getJSONObject(JSONConstants.ATTRIBUTES).getString(JSONConstants.URL));
//            CountryofBirth _countryOfBirth = new CountryofBirth();
//            _countryOfBirth.setUrl(json.getJSONObject("Country_of_Birth__r").getJSONObject(JSONConstants.ATTRIBUTES).getString(JSONConstants.URL));
//            _countryOfBirth.setID(json.getJSONObject("Country_of_Birth__r").getString(JSONConstants.ID));
//            _countryOfBirth.setName(json.getJSONObject("Country_of_Birth__r").getString(JSONConstants.NAME));
//            _visa.set_countryOfBirth(_countryOfBirth);
//
//            CurrentNationality _currentNationality = new CurrentNationality();
//            _currentNationality.setUrl(json.getJSONObject("Current_Nationality__r").getJSONObject(JSONConstants.ATTRIBUTES).getString(JSONConstants.URL));
//            _currentNationality.setID(json.getJSONObject("Current_Nationality__r").getString(JSONConstants.ID));
//            _currentNationality.setName(json.getJSONObject("Current_Nationality__r").getString(JSONConstants.NAME));
//            _visa.set_currentNationality(_currentNationality);
//
//            JobTitleAtImmigration _jobTitleImmigration = new JobTitleAtImmigration();
//            _jobTitleImmigration.setUrl(json.getJSONObject("Job_Title_at_Immigration__r").getJSONObject(JSONConstants.ATTRIBUTES).getString(JSONConstants.URL));
//            _jobTitleImmigration.setID(json.getJSONObject("Job_Title_at_Immigration__r").getString(JSONConstants.ID));
//            _jobTitleImmigration.setName(json.getJSONObject("Job_Title_at_Immigration__r").getString(JSONConstants.NAME));
//            _visa.set_jobTitleImigration(_jobTitleImmigration);
//
//            SponsoringCompany _sponsoringCompany = new SponsoringCompany();
//            _sponsoringCompany.setUrl(json.getJSONObject("Sponsoring_Company__r").getJSONObject(JSONConstants.ATTRIBUTES).getString(JSONConstants.URL));
//            _sponsoringCompany.setName(json.getJSONObject("Sponsoring_Company__r").getString(JSONConstants.NAME));
//            _visa.set_sponsoringCompany(_sponsoringCompany);
//
//            VisaHolder _visaHolder = new VisaHolder();
//            _visaHolder.setUrl(json.getJSONObject("Visa_Holder__r").getJSONObject(JSONConstants.ATTRIBUTES).getString(JSONConstants.URL));
//            _visaHolder.setID(json.getJSONObject("Visa_Holder__r").getString(JSONConstants.ID));
//            _visaHolder.setName(json.getJSONObject("Visa_Holder__r").getString(JSONConstants.NAME));
//            _visaHolder.setBillingCity(json.getJSONObject("Visa_Holder__r").getString(JSONConstants.BILLING_CITY));
//            _visa.set_visaHolder(_visaHolder);
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
        return _visa;
    }

    private static MyVisa parseMyVisaObject(JSONObject json) {
        MyVisa _visa = new MyVisa();
        Gson gson = new Gson();
        _visa = gson.fromJson(json.toString(), MyVisa.class);


        Log.d("json", json.toString());
        try {
            CountryofBirth _countryOfBirth = new CountryofBirth();
            _countryOfBirth.setID(json.getJSONObject("Country_of_Birth__r").getString(JSONConstants.ID));
            _countryOfBirth.setName(json.getJSONObject("Country_of_Birth__r").getString(JSONConstants.NAME));
            _visa.set_countryOfBirth(_countryOfBirth);

            CurrentNationality _currentNationality = new CurrentNationality();
            _currentNationality.setID(json.getJSONObject("Current_Nationality__r").getString(JSONConstants.ID));
            _currentNationality.setName(json.getJSONObject("Current_Nationality__r").getString(JSONConstants.NAME));
            _visa.set_currentNationality(_currentNationality);

            JobTitleAtImmigration _jobTitleImmigration = new JobTitleAtImmigration();
//            _jobTitleImmigration.setUrl(json.getJSONObject("Job_Title_at_Immigration__r").getJSONObject(JSONConstants.ATTRIBUTES).getString(JSONConstants.URL));
            _jobTitleImmigration.setID(json.getJSONObject("Job_Title_at_Immigration__r").getString(JSONConstants.ID));
            _jobTitleImmigration.setName(json.getJSONObject("Job_Title_at_Immigration__r").getString(JSONConstants.NAME));
            _visa.set_jobTitleImigration(_jobTitleImmigration);

            SponsoringCompany _sponsoringCompany = new SponsoringCompany();
//            _sponsoringCompany.setUrl(json.getJSONObject("Sponsoring_Company__r").getJSONObject(JSONConstants.ATTRIBUTES).getString(JSONConstants.URL));
            _sponsoringCompany.setName(json.getJSONObject("Sponsoring_Company__r").getString(JSONConstants.NAME));
            _visa.set_sponsoringCompany(_sponsoringCompany);

            VisaHolder _visaHolder = new VisaHolder();
//            _visaHolder.setUrl(json.getJSONObject("Visa_Holder__r").getJSONObject(JSONConstants.ATTRIBUTES).getString(JSONConstants.URL));
            _visaHolder.setID(json.getJSONObject("Visa_Holder__r").getString(JSONConstants.ID));
            _visaHolder.setName(json.getJSONObject("Visa_Holder__r").getString(JSONConstants.NAME));
            _visaHolder.setBillingCity(json.getJSONObject("Visa_Holder__r").getString(JSONConstants.BILLING_CITY));
            _visa.set_visaHolder(_visaHolder);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return _visa;
    }


    public static ArrayList<LicenseActivity> parseLicenseActivityObject(String s) throws JSONException {
        JSONObject jsonLicenseActivities = new JSONObject(s);
        ArrayList<LicenseActivity> _licenses = new ArrayList<LicenseActivity>();
        Gson gson = new Gson();
        if (jsonLicenseActivities.optBoolean(JSONConstants.DONE) == true) {

            JSONArray jRecords = jsonLicenseActivities.getJSONArray(JSONConstants.RECORDS);
            for (int i = 0; i < jRecords.length(); i++) {
                gson = new Gson();
                JSONObject jsonLicense = jRecords.getJSONObject(i);
                LicenseActivity _licenseActivity = gson.fromJson(jsonLicense.toString(), LicenseActivity.class);
                _licenseActivity.setUrl(jsonLicense.getJSONObject(JSONConstants.ATTRIBUTES).getString(JSONConstants.URL));
                gson = new Gson();
                OriginalBusinessActivity _originalBusinessActivity = gson.fromJson(jsonLicense.getJSONObject("Original_Business_Activity__r").toString(), OriginalBusinessActivity.class);
                _originalBusinessActivity.setUrl(jsonLicense.getJSONObject("Original_Business_Activity__r").getJSONObject(JSONConstants.ATTRIBUTES).getString(JSONConstants.URL));
                _licenseActivity.set_originalBusinessActivity(_originalBusinessActivity);
                _licenses.add(_licenseActivity);
            }
        }


        return _licenses;
    }

    public static String parseRenewalRequest(String s) throws JSONException {
        JSONObject jsonObject = new JSONObject(s);
        String Invoices = "";
        if (jsonObject.optBoolean(JSONConstants.DONE) == true) {
            if (jsonObject.getJSONArray(JSONConstants.RECORDS).length() > 0) {
                Invoices = "";
            } else {
                Invoices = "Found";
            }
        }

        return Invoices;
    }

    public static ArrayList<ShareOwnership> parseShareOwnerShipObject(String s) throws JSONException {

        Gson gson = new Gson();
        ShareOwnership shareOwnership = new ShareOwnership();
        ArrayList<ShareOwnership> shareOwnerships = new ArrayList<ShareOwnership>();
        JSONObject jsonObject = new JSONObject(s.toString());
        JSONArray jsonArrayRecords = jsonObject.getJSONArray(JSONConstants.RECORDS);
        for (int i = 0; i < jsonArrayRecords.length(); i++) {
            JSONObject json = jsonArrayRecords.getJSONObject(i);
            shareOwnership = gson.fromJson(json.toString(), ShareOwnership.class);
            shareOwnership.setUrl(json.getJSONObject(JSONConstants.ATTRIBUTES).getString(JSONConstants.URL));

            JSONObject jsonShareHolder = json.getJSONObject("Shareholder__r");
            Shareholder shareholder = new Shareholder();
            gson = new Gson();
            shareholder = gson.fromJson(jsonShareHolder.toString(), Shareholder.class);
            shareholder.setUrl(jsonShareHolder.getJSONObject(JSONConstants.ATTRIBUTES).getString(JSONConstants.URL));

            CurrentPassport currentPassport = new CurrentPassport();
            gson = new Gson();
            if (!jsonShareHolder.toString().contains("\"Current_Passport__r\":null")) {
                JSONObject jsonCurrentPassport = jsonShareHolder.getJSONObject("Current_Passport__r");
                currentPassport = gson.fromJson(jsonCurrentPassport.toString(), CurrentPassport.class);
                currentPassport.setUrl(jsonCurrentPassport.getJSONObject(JSONConstants.ATTRIBUTES).getString(JSONConstants.URL));
                shareholder.set_currentPassport(currentPassport);
            } else {
                shareholder.set_currentPassport(null);
            }
            shareOwnership.set_shareholder(shareholder);
            shareOwnerships.add(shareOwnership);
        }
        return shareOwnerships;
    }

    public static ArrayList<Directorship> parseDirectionshipObject(String s) {

        Gson gson = new Gson();
        Directorship directorship = new Directorship();
        ArrayList<Directorship> directorships = new ArrayList<Directorship>();
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(s.toString());
            JSONArray jsonArrayRecords = jsonObject.getJSONArray(JSONConstants.RECORDS);
            for (int i = 0; i < jsonArrayRecords.length(); i++) {
                JSONObject json = jsonArrayRecords.getJSONObject(i);
                directorship = gson.fromJson(json.toString(), Directorship.class);
                directorship.setUrl(json.getJSONObject(JSONConstants.ATTRIBUTES).getString(JSONConstants.URL));

                JSONObject jsonDirector = json.getJSONObject("Director__r");
                Director director = new Director();
                gson = new Gson();
                director = gson.fromJson(jsonDirector.toString(), Director.class);
                director.setUrl(jsonDirector.getJSONObject(JSONConstants.ATTRIBUTES).getString(JSONConstants.URL));

                CurrentPassport currentPassport = new CurrentPassport();
                gson = new Gson();
                if (!jsonDirector.toString().contains("\"Current_Passport__r\":null")) {
                    JSONObject jsonCurrentPassport = jsonDirector.getJSONObject("Current_Passport__r");
                    currentPassport = gson.fromJson(jsonCurrentPassport.toString(), CurrentPassport.class);
                    currentPassport.setUrl(jsonCurrentPassport.getJSONObject(JSONConstants.ATTRIBUTES).getString(JSONConstants.URL));
                    director.set_currentPassport(currentPassport);
                } else {
                    director.set_currentPassport(null);
                }
                directorship.set_director(director);
                directorships.add(directorship);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return directorships;
    }


    public static ArrayList<ManagementMember> parseManagementMemberObject(String s) {
        Gson gson = new Gson();
        ManagementMember managementMember = new ManagementMember();
        ArrayList<ManagementMember> managementMembers = new ArrayList<ManagementMember>();
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(s.toString());
            JSONArray jsonArrayRecords = jsonObject.getJSONArray(JSONConstants.RECORDS);
            for (int i = 0; i < jsonArrayRecords.length(); i++) {
                JSONObject json = jsonArrayRecords.getJSONObject(i);
                managementMember = gson.fromJson(json.toString(), ManagementMember.class);
                managementMember.setUrl(json.getJSONObject(JSONConstants.ATTRIBUTES).getString(JSONConstants.URL));

                JSONObject jsonDirector = json.getJSONObject("Manager__r");
                Manager manager = new Manager();
                gson = new Gson();
                manager = gson.fromJson(jsonDirector.toString(), Manager.class);
                manager.setUrl(jsonDirector.getJSONObject(JSONConstants.ATTRIBUTES).getString(JSONConstants.URL));

                CurrentPassport currentPassport = new CurrentPassport();
                gson = new Gson();
                if (!jsonDirector.toString().contains("\"Current_Passport__r\":null")) {
                    JSONObject jsonCurrentPassport = jsonDirector.getJSONObject("Current_Passport__r");
                    currentPassport = gson.fromJson(jsonCurrentPassport.toString(), CurrentPassport.class);
                    currentPassport.setUrl(jsonCurrentPassport.getJSONObject(JSONConstants.ATTRIBUTES).getString(JSONConstants.URL));
                    manager.setCurrentPassport(currentPassport);
                } else {
                    manager.setCurrentPassport(null);
                }
                managementMember.set_manager(manager);
                managementMembers.add(managementMember);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return managementMembers;
    }

    public static ArrayList<LegalRepresentative> parseLegalRepresentativesObject(String s) {

        Gson gson = new Gson();
        LegalRepresentative legalRepresentative = new LegalRepresentative();
        ArrayList<LegalRepresentative> legalRepresentatives = new ArrayList<LegalRepresentative>();
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(s.toString());
            JSONArray jsonArrayRecords = jsonObject.getJSONArray(JSONConstants.RECORDS);
            for (int i = 0; i < jsonArrayRecords.length(); i++) {
                JSONObject json = jsonArrayRecords.getJSONObject(i);
                legalRepresentative = gson.fromJson(json.toString(), LegalRepresentative.class);
                legalRepresentative.setUrl(json.getJSONObject(JSONConstants.ATTRIBUTES).getString(JSONConstants.URL));

                JSONObject jsonLegalReprentativeLookup = json.getJSONObject("Legal_Representative__r");
                LegalRepresentativeLookup legalRepresentativeLookup = new LegalRepresentativeLookup();
                gson = new Gson();

                legalRepresentativeLookup = gson.fromJson(jsonLegalReprentativeLookup.toString(), LegalRepresentativeLookup.class);
                legalRepresentativeLookup.setUrl(jsonLegalReprentativeLookup.getJSONObject(JSONConstants.ATTRIBUTES).getString(JSONConstants.URL));

                CurrentPassport currentPassport = new CurrentPassport();
                gson = new Gson();
                if (!jsonLegalReprentativeLookup.toString().contains("\"Current_Passport__r\":null")) {
                    JSONObject jsonCurrentPassport = jsonLegalReprentativeLookup.getJSONObject("Current_Passport__r");
                    currentPassport = gson.fromJson(jsonCurrentPassport.toString(), CurrentPassport.class);
                    currentPassport.setUrl(jsonCurrentPassport.getJSONObject(JSONConstants.ATTRIBUTES).getString(JSONConstants.URL));
                    legalRepresentativeLookup.setCurrentPassport(currentPassport);
                } else {
                    legalRepresentativeLookup.setCurrentPassport(null);
                }

                legalRepresentative.setLegalRepresentativeLookup(legalRepresentativeLookup);
                legalRepresentatives.add(legalRepresentative);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return legalRepresentatives;
    }

    public static ArrayList<Receipt_Template__c> parseReceiptObjectResponse(String s) {

//        ArrayList<Receipt_Template__c> receipt_template__cs = new ArrayList<>();
//        Receipt_Template__c receipt_template__c;
//
//        JSONObject jsonFullResponse = null;
//        try {
//            jsonFullResponse = new JSONObject(s);
//            JSONArray jsonArrayRecords = jsonFullResponse.getJSONArray(JSONConstants.RECORDS);
//            for (int i = 0; i < jsonArrayRecords.length(); i++) {
//                receipt_template__c = new Receipt_Template__c();
//                JSONObject jsonObject = jsonArrayRecords.getJSONObject(i);
//                ObjectReader or = new ObjectMapper().reader().withType(
//                        Receipt_Template__c.class);
//                try {
//                    receipt_template__c = or.readValue(jsonObject.toString());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//                receipt_template__cs.add(receipt_template__c);
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//        return receipt_template__cs;

//        ArrayList<Receipt_Template__c> receipt_template__cs = new ArrayList<>();
//
//        try {
//            receipt_template__cs = new ObjectMapper().readValue(s.toString(), new TypeReference<Collection<Receipt_Template__c>>() {
//            });
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return receipt_template__cs;


        Gson gson;
        ArrayList<Receipt_Template__c> receiptTemplates = new ArrayList<Receipt_Template__c>();
        ArrayList<EServices_Document_Checklist__c> eServicesDocumentChecklistses = new ArrayList<EServices_Document_Checklist__c>();
        try {
            JSONObject jsonFullResponse = new JSONObject(s);
            JSONArray jsonArrayRecords = jsonFullResponse.getJSONArray(JSONConstants.RECORDS);

            for (int i = 0; i < jsonArrayRecords.length(); i++) {
                gson = new Gson();
                eServicesDocumentChecklistses = new ArrayList<EServices_Document_Checklist__c>();
                JSONObject jsonObject = jsonArrayRecords.getJSONObject(i);
                Receipt_Template__c receiptTemplate = gson.fromJson(jsonObject.toString(), Receipt_Template__c.class);
                Log.d("object", jsonObject.toString());
                receiptTemplate.setTotal_Amount__c(jsonObject.getDouble("Total_Amount__c"));
                JSONObject jsoneServices_Document_Checklists = jsonObject.getJSONObject("eServices_Document_Checklists__r");
                JSONArray jArrayeServices_Document_ChecklistsRecords = jsoneServices_Document_Checklists.getJSONArray(JSONConstants.RECORDS);
                for (int j = 0; j < jArrayeServices_Document_ChecklistsRecords.length(); j++) {
                    gson = new Gson();
                    JSONObject jsonEServicesDocumentChecklistsItem = jArrayeServices_Document_ChecklistsRecords.getJSONObject(j);
                    EServices_Document_Checklist__c eServicesDocumentChecklists = gson.fromJson(jsonEServicesDocumentChecklistsItem.toString(), EServices_Document_Checklist__c.class);
                    eServicesDocumentChecklistses.add(eServicesDocumentChecklists);
                }
                receiptTemplate.seteServices_document_checklist__c(eServicesDocumentChecklistses);
                receiptTemplates.add(receiptTemplate);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return receiptTemplates;


    }

    public static ArrayList<MyRequest> parseMyRequestsResponse(String s) {

        Gson gson;
        ArrayList<MyRequest> myRequests = new ArrayList<MyRequest>();
        try {
            JSONObject jsonObject = new JSONObject(s);
            if (jsonObject.optBoolean(JSONConstants.DONE) == true) {
                JSONArray jArrayRecords = jsonObject.getJSONArray(JSONConstants.RECORDS);
                for (int i = 0; i < jArrayRecords.length(); i++) {
                    gson = new Gson();
                    JSONObject jsonRecord = jArrayRecords.getJSONObject(i);
                    MyRequest myRequest = new MyRequest();
                    myRequest = gson.fromJson(jsonRecord.toString(), MyRequest.class);
                    JSONObject jsonRecordType = jsonRecord.getJSONObject(JSONConstants.RECORD_TYPE);
                    gson = new Gson();
                    RecordType recordType = gson.fromJson(jsonRecordType.toString(), RecordType.class);
                    myRequest.setRecordType(recordType);
                    myRequest.setUrl(jsonRecord.getJSONObject(JSONConstants.ATTRIBUTES).getString(JSONConstants.URL));
                    if (!jsonRecord.toString().contains("\"Employee_Ref__r\":null")) {
                        JSONObject jsonEmployeeRef = jsonRecord.getJSONObject("Employee_Ref__r");
                        EmployeeRef employeeRef = new EmployeeRef();
                        gson = new Gson();
                        employeeRef = gson.fromJson(jsonEmployeeRef.toString(), EmployeeRef.class);
                        employeeRef.setUrl(jsonEmployeeRef.getJSONObject(JSONConstants.ATTRIBUTES).getString(JSONConstants.URL));
                        myRequest.setEmployee_Ref(employeeRef);
                    }
                    myRequests.add(myRequest);
                }
            } else {
                return null;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

        return myRequests;
    }

    public static ArrayList<NotificationManagement> parseNotificationsResponse(String s) {
        Gson gson;
        ArrayList<NotificationManagement> notificationManagements = new ArrayList<NotificationManagement>();
        JSONObject jsonObject;
        try {
            jsonObject = new JSONObject(s.toString());
            JSONArray jArrayRecords = jsonObject.getJSONArray(JSONConstants.RECORDS);
            for (int i = 0; i < jArrayRecords.length(); i++) {
                gson = new Gson();
                JSONObject jsonRecord = jArrayRecords.getJSONObject(i);
                NotificationManagement notificationManagement = new NotificationManagement();
                notificationManagement = gson.fromJson(jsonRecord.toString(), NotificationManagement.class);
                notificationManagement.setUrl(jsonRecord.getJSONObject(JSONConstants.ATTRIBUTES).getString(JSONConstants.URL));
                JSONObject jsonCase = jsonRecord.getJSONObject("Case__r");
                gson = new Gson();
                Case recordCase = gson.fromJson(jsonCase.toString(), Case.class);
                recordCase.setUrl(jsonCase.getJSONObject(JSONConstants.ATTRIBUTES).getString(JSONConstants.URL));
                notificationManagement.setCaseNotification(recordCase);
                notificationManagements.add(notificationManagement);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return notificationManagements;
    }

    public static String parseNeedHelpService(String s) {
        String ID = "";
        try {
            JSONObject json = new JSONObject(s.toString());
            ID = json.getJSONArray(JSONConstants.RECORDS).getJSONObject(0).getString("Id");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return ID;
    }

    public static WebForm parseWebFormObject(String s) {
        WebForm webForm = new WebForm();
        Gson gson = new Gson();
        try {
            JSONObject jsonObject = new JSONObject(s.toString());
            if (jsonObject.optBoolean(JSONConstants.DONE) == true) {
                JSONArray jsonArrayRecords = jsonObject.getJSONArray(JSONConstants.RECORDS);
                for (int i = 0; i < jsonArrayRecords.length(); i++) {
                    JSONObject jsonRecord = jsonArrayRecords.getJSONObject(i);
                    webForm = gson.fromJson(jsonRecord.toString(), WebForm.class);
                    webForm.setUrl(jsonRecord.getJSONObject(JSONConstants.ATTRIBUTES).getString(JSONConstants.URL));
                    JSONObject jsonFields = jsonRecord.getJSONObject(JSONConstants.VISUALFORCE_GENERATOR_ID);
                    JSONArray jsonArrayFields = jsonFields.getJSONArray(JSONConstants.RECORDS);
                    ArrayList<FormField> formFields = new ArrayList<FormField>();
                    for (int j = 0; j < jsonArrayFields.length(); j++) {
                        JSONObject json = jsonArrayFields.getJSONObject(j);
                        gson = new Gson();
                        FormField formField = new FormField();
                        formField = gson.fromJson(json.toString(), FormField.class);
                        formFields.add(formField);
                    }
                    webForm.set_formFields(formFields);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return webForm;
    }

    public static ArrayList<Company_Documents__c> parseCompanyDocumentObject(String s) {

        ArrayList<Company_Documents__c> company_documents = new ArrayList<Company_Documents__c>();
        JSONObject jsonObject = null;
        Company_Documents__c company_documents__c;
        try {
            jsonObject = new JSONObject(s.toString());
            JSONArray jsonArrayRecords = jsonObject.getJSONArray(JSONConstants.RECORDS);
            if (jsonArrayRecords.length() > 0) {
                for (int i = 0; i < jsonArrayRecords.length(); i++) {
                    JSONObject jsonRecord = jsonArrayRecords.getJSONObject(i);
                    company_documents__c = new Company_Documents__c();
                    ObjectReader or = new ObjectMapper().reader().withType(
                            Company_Documents__c.class);
                    try {
                        company_documents__c = or.readValue(jsonRecord.toString());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    company_documents.add(company_documents__c);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return company_documents;
    }

    public static ArrayList<Company_Documents__c> parseCompanyDocumentObject(String s, boolean t) {

        ArrayList<Company_Documents__c> company_documents = new ArrayList<Company_Documents__c>();
        JSONObject jsonObject = null;
        Company_Documents__c company_documents__c;
        try {
            jsonObject = new JSONObject(s.toString());
            JSONArray jsonArrayRecords = jsonObject.getJSONArray(JSONConstants.RECORDS);
            if (jsonArrayRecords.length() > 0) {
                for (int i = 0; i < jsonArrayRecords.length(); i++) {
                    JSONObject jsonRecord = jsonArrayRecords.getJSONObject(i);
                    company_documents__c = new Company_Documents__c();
//                    ObjectReader or = new ObjectMapper().reader().withType(
//                            Company_Documents__c.class);
//                    try {
//                        company_documents__c = or.readValue(jsonRecord.toString());
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
                    company_documents__c.setName(jsonRecord.getString("Name"));
                    company_documents__c.setVersion__c(jsonRecord.get("Version__c") == null ? 1.0 : Double.valueOf(jsonRecord.optDouble("Version__c")));
                    company_documents__c.setOriginal_Verified__c(jsonRecord.optBoolean("Original_Verified__c"));
                    company_documents__c.setRequired_Scan_copy__c(jsonRecord.optBoolean("Required_Scan_copy__c"));
                    company_documents__c.setVerified_Scan_Copy__c(jsonRecord.optBoolean("Verified_Scan_Copy__c"));
                    company_documents__c.setOriginal_Collected__c(jsonRecord.optBoolean("Original_Collected__c"));
                    Calendar cal = Calendar.getInstance();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
                    try {
                        cal.setTime(sdf.parse(jsonRecord.getString("CreatedDate").substring(0, 10)));
                        company_documents__c.setCreatedDate(cal);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    company_documents__c.setUploaded__c(jsonRecord.optBoolean("Uploaded__c"));
                    company_documents__c.setDocument_Type__c(jsonRecord.getString("Document_Type__c"));
                    company_documents__c.setAttachment_Id__c(jsonRecord.getString("Attachment_Id__c") == null || jsonRecord.getString("Attachment_Id__c").equals("null") ? "" : jsonRecord.getString("Attachment_Id__c"));
                    company_documents__c.setCustomer_Document__c(jsonRecord.optBoolean("Customer_Document__c"));
                    company_documents__c.setRequired_Original__c(jsonRecord.optBoolean("Required_Original__c"));
                    company_documents__c.setId(jsonRecord.getString("Id"));
//                    company_documents__c.setParty(jsonRecord.getString("Party__r"));
                    company_documents.add(company_documents__c);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return company_documents;
    }

    public static String parseCompanyDocumentRecordType(String s) {

        String recordId = "";
        try {
            JSONObject jsonObject = new JSONObject(s.toString());
            if (jsonObject.optBoolean(JSONConstants.DONE) == true) {
                JSONArray jsonArrayRecords = jsonObject.getJSONArray(JSONConstants.RECORDS);
                for (int i = 0; i < jsonArrayRecords.length(); i++) {
                    JSONObject jsonRecord = jsonArrayRecords.getJSONObject(i);
                    recordId = jsonRecord.getString("Id");
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return recordId;
    }

    public static ArrayList<Company_Documents__c> parseCompanyDocumentChecklist(String caseId, String accountId, String RecordTypeId, String ObjectId, String s) {

        ArrayList<Company_Documents__c> _companyDocuments = new ArrayList<Company_Documents__c>();

        try {
            JSONObject jsonObject = new JSONObject(s.toString());
            JSONArray jArrayRecords = jsonObject.getJSONArray(JSONConstants.RECORDS);
            if (jArrayRecords.length() > 0) {
                for (int i = 0; i < jArrayRecords.length(); i++) {
                    JSONObject jsonObjectRecord = jArrayRecords.getJSONObject(i);
                    Company_Documents__c company_document = new Company_Documents__c();
                    company_document.setId(jsonObjectRecord.getString("Id"));
                    company_document.setRequired_Scan_copy__c(jsonObjectRecord.getBoolean("Required_Scan_copy__c"));
                    company_document.setName(jsonObjectRecord.getString("Name"));
                    company_document.setDocument_Type__c(jsonObjectRecord.getString("Document_Type__c"));
                    company_document.setVersion__c(Double.valueOf(0));
                    company_document.setRequest__c(caseId);
                    company_document.setParty__c(accountId);
                    company_document.setCompany__c(accountId);
                    company_document.setEServices_Document__c(jsonObjectRecord.getString("Id"));
                    company_document.setRecordTypeId(RecordTypeId);
                    company_document.setNOC__c(ObjectId);
                    if (company_document.getDocument_Type__c() != null) {
                        if (!company_document.getDocument_Type__c().equals("Download")) {
                            _companyDocuments.add(company_document);
                        }
                    } else {
                        _companyDocuments.add(company_document);
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return _companyDocuments;
    }

    public static ArrayList<Attachment> parseAttachmentObject(String s) {
        ArrayList<Attachment> attachments = new ArrayList<Attachment>();
        Attachment attachment = new Attachment();
        try {
            JSONObject jsonObject = new JSONObject(s.toString());
            JSONArray jArrayRecords = jsonObject.getJSONArray(JSONConstants.RECORDS);
            for (int i = 0; i < jArrayRecords.length(); i++) {
                JSONObject jsonRecord = jArrayRecords.getJSONObject(i);
                ObjectReader or = new ObjectMapper().reader().withType(
                        Attachment.class);
                try {
                    attachment = or.readValue(jsonRecord.toString());
                    attachments.add(attachment);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return attachments;
    }

    public static ArrayList<Country__c> parseCountryObject(String s) throws JSONException {
        ArrayList<Country__c> attachments = new ArrayList<Country__c>();
        Country__c attachment = new Country__c();
        JSONObject jsonObject = new JSONObject(s.toString());
        JSONArray jArrayRecords = jsonObject.getJSONArray(JSONConstants.RECORDS);
        for (int i = 0; i < jArrayRecords.length(); i++) {
            JSONObject jsonRecord = jArrayRecords.getJSONObject(i);
            ObjectReader or = new ObjectMapper().reader().withType(
                    Country__c.class);

            try {
                attachment = or.readValue(jsonRecord.toString());
                attachments.add(attachment);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return attachments;
    }

    public static ArrayList<Contract_DWC__c> parseLeasingContractResponse(String s) {
        Gson gson = new Gson();
        ArrayList<Contract_DWC__c> contract_dwc__cs = new ArrayList<>();
        Contract_DWC__c contract_dwc__c = new Contract_DWC__c();
//        JSONObject jsonObject = null;
        try {
//            jsonObject = new JSONObject(s.toString());
            JSONArray jArrayRecords = new JSONArray(s);
            for (int i = 0; i < jArrayRecords.length(); i++) {
                contract_dwc__c = new Contract_DWC__c();
                JSONObject jsonRecord = jArrayRecords.getJSONObject(i);
//                ObjectReader or = new ObjectMapper().reader().withType(
//                        Contract_DWC__c.class);
//                try {
//                    contract_dwc__c = or.readValue(jsonRecord.toString());
//                    contract_dwc__cs.add(contract_dwc__c);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
                contract_dwc__c = gson.fromJson(jsonRecord.toString(), Contract_DWC__c.class);
                Contract_Line_Item__c contract_line_item__c = new Contract_Line_Item__c();
                ArrayList<Contract_Line_Item__c> contract_line_item__cs;
                JSONObject jsonContract_Line_Items__r = jsonRecord.getJSONObject("Contract_Line_Items__r");
                JSONArray jsonArrayRecords = jsonContract_Line_Items__r.getJSONArray(JSONConstants.RECORDS);
                contract_line_item__cs = new ArrayList<>();
                for (int j = 0; j < jsonArrayRecords.length(); j++) {
                    JSONObject json = jsonArrayRecords.getJSONObject(j);
                    contract_line_item__c = new Contract_Line_Item__c();
                    gson = new Gson();
                    contract_line_item__c = gson.fromJson(json.toString(), Contract_Line_Item__c.class);
                    JSONObject jsonInventory_Unit__r = json.getJSONObject("Inventory_Unit__r");
                    Inventory_Unit__r inventory_unit__r = new Inventory_Unit__r();
                    gson = new Gson();
                    inventory_unit__r = gson.fromJson(jsonInventory_Unit__r.toString(), Inventory_Unit__r.class);
                    JSONObject jsonProduct_Type__r = jsonInventory_Unit__r.getJSONObject("Product_Type__r");
                    Product_Type__r product_type__r = new Product_Type__r();
                    gson = new Gson();
                    product_type__r = gson.fromJson(jsonProduct_Type__r.toString(), Product_Type__r.class);
                    inventory_unit__r.setProduct_Type__r(product_type__r);
                    contract_line_item__c.setInventory_unit__r(inventory_unit__r);
                    contract_line_item__cs.add(contract_line_item__c);
                }

                contract_dwc__c.setContract_line_item__cs(contract_line_item__cs);
                JSONObject jsonQoute = jsonRecord.getJSONObject("Quote__r");
                Quote quote = new Quote();
                quote.setId(jsonQoute.getString("Id"));
                quote.setName(jsonQoute.getString("Name"));
                contract_dwc__c.setQuote(quote);
                contract_dwc__cs.add(contract_dwc__c);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return contract_dwc__cs;
    }

    public static Case parseCaseObject(String s) {
        Gson gson = new Gson();
        Case caseObject = new Case();
        try {
            JSONObject jsonObject = new JSONObject(s);
            JSONArray jArrayRecords = jsonObject.getJSONArray(JSONConstants.RECORDS);
            for (int i = 0; i < jArrayRecords.length(); i++) {
                JSONObject jsonRecord = jArrayRecords.getJSONObject(i);
                caseObject = gson.fromJson(jsonRecord.toString(), Case.class);
                Registration_Amendments__c registration_amendments__c = new Registration_Amendments__c();
                JSONObject jsonRegistrationAmendment = jsonRecord.getJSONObject("Registration_Amendment__r");
                gson = new Gson();
                registration_amendments__c = gson.fromJson(jsonRegistrationAmendment.toString(), Registration_Amendments__c.class);
                caseObject.setRegistration_amendments__c(registration_amendments__c);
                JSONObject jsonInvoice = jsonRecord.getJSONObject("Invoice__r");
                caseObject.setInvoice__c(jsonInvoice.getString("Amount__c"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return caseObject;
    }

    public static ArrayList<JobTitleAtImmigration> parseJobImmagrationObject(String s) throws JSONException {
        ArrayList<JobTitleAtImmigration> attachments = new ArrayList<JobTitleAtImmigration>();
        JobTitleAtImmigration attachment = new JobTitleAtImmigration();
        JSONObject jsonObject = new JSONObject(s.toString());
        JSONArray jArrayRecords = jsonObject.getJSONArray(JSONConstants.RECORDS);
        for (int i = 0; i < jArrayRecords.length(); i++) {
            JSONObject jsonRecord = jArrayRecords.getJSONObject(i);
            ObjectReader or = new ObjectMapper().reader().withType(
                    JobTitleAtImmigration.class);

            try {
                attachment = or.readValue(jsonRecord.toString());
                attachments.add(attachment);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return attachments;
    }

    public static Collection<? extends FreeZonePayment> parseFreeZonePaymentResponse(String s) {
        ArrayList<FreeZonePayment> freeZonePayments = new ArrayList<>();
        Gson gson = new Gson();
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(s.toString());
            JSONArray jArrayRecords = jsonObject.getJSONArray(JSONConstants.RECORDS);
            if (jArrayRecords.length() > 0) {
                for (int i = 0; i < jArrayRecords.length(); i++) {
                    JSONObject jsonObject1 = jArrayRecords.getJSONObject(i);
                    FreeZonePayment freeZonePayment = new FreeZonePayment();
                    freeZonePayment = gson.fromJson(jsonObject1.toString(), FreeZonePayment.class);
                    if (jsonObject1.getJSONObject("Request__r") != null) {
                        if (jsonObject1.getJSONObject("Request__r").toString().contains("\"Employee_Ref__r\":null")) {
                            freeZonePayment.setEmployeeName("");
                        } else {
                            if (jsonObject1.getJSONObject("Request__r").getJSONObject("Employee_Ref__r") != null) {
                                freeZonePayment.setEmployeeName(jsonObject1.getJSONObject("Request__r").getJSONObject("Employee_Ref__r").getString("Name"));
                            } else {
                                freeZonePayment.setEmployeeName("");
                            }
                        }
                    } else {
                        freeZonePayment.setEmployeeName("");
                    }

                    freeZonePayments.add(freeZonePayment);
                }
            } else {
                freeZonePayments = new ArrayList<>();
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return freeZonePayments;
    }

    public static ArrayList<EServices_Document_Checklist__c> parseEServiceDocumentChecklist(String s) throws JSONException, IOException {
        JSONObject jsonObject = new JSONObject(s.toString());
        JSONArray jArrayRecords = jsonObject.getJSONArray(JSONConstants.RECORDS);
        ArrayList<EServices_Document_Checklist__c> eServices_document_checklist__cs = new ArrayList<EServices_Document_Checklist__c>();
        EServices_Document_Checklist__c eServices_document_checklist__c;
        if (jArrayRecords.length() > 0) {
            for (int i = 0; i < jArrayRecords.length(); i++) {
                JSONObject jsonRecord = jArrayRecords.getJSONObject(i);
                ObjectReader or = new ObjectMapper().reader().withType(
                        EServices_Document_Checklist__c.class);
                eServices_document_checklist__c = or.readValue(jsonRecord.toString());
                eServices_document_checklist__cs.add(eServices_document_checklist__c);
            }
        }
        return eServices_document_checklist__cs;
    }
}