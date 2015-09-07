package utilities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.gson.Gson;

import activity.CompanyDocumentsActivity;
import activity.EmployeeListActivity;
import activity.ReportsActivity;
import cloudconcept.dwc.HomepageActivity;
import fragmentActivity.CardActivity;
import fragmentActivity.ChangeAndRemovalActivity;
import fragmentActivity.CompanyInfoActivity;
import fragmentActivity.CompanyNOC.CompanyNocActivity;
import fragmentActivity.DashboardActivity;
import fragmentActivity.LeasingShowDetailsActivity;
import fragmentActivity.MyRequestsActivity;
import fragmentActivity.NOCScreen.NocActivity;
import fragmentActivity.NameReservationActivity;
import fragmentActivity.NeedHelpActivity;
import fragmentActivity.NotificationsActivity;
import fragmentActivity.QuickAccessActivity;
import fragmentActivity.ShowDetailsActivity;
import fragmentActivity.ThankYouActivity;
import fragmentActivity.ViewStatementActivity;
import fragmentActivity.VisaActivity;
import fragmentActivity.VisasAndCardsActivity;
import model.Card_Management__c;
import model.Company_Documents__c;
import model.Contract_DWC__c;
import model.Directorship;
import model.Visa;

/**
 * Created by Abanoub on 6/14/2015.
 */
public class ActivitiesLauncher {

    private static Intent intent;

    public static void openDashboardActivity(Context applicationContext) {
        intent = new Intent(applicationContext, DashboardActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        applicationContext.startActivity(intent);

    }

    public static void openMyRequestsActivity(Context applicationContext) {
        intent = new Intent(applicationContext, MyRequestsActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        applicationContext.startActivity(intent);

    }

    public static void openNotificationsActivity(Context applicationContext) {
        intent = new Intent(applicationContext, NotificationsActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        applicationContext.startActivity(intent);
    }

    public static void openCompanyInfoActivity(Context applicationContext) {
        intent = new Intent(applicationContext, CompanyInfoActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        applicationContext.startActivity(intent);

    }

    public static void openReportsActivity(Context applicationContext) {
        intent = new Intent(applicationContext, ReportsActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        applicationContext.startActivity(intent);

    }

    public static void openNeedHelpActivity(Context applicationContext) {
        intent = new Intent(applicationContext, NeedHelpActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        applicationContext.startActivity(intent);

    }

    public static void openCompanyDocumentsActivity(Context applicationContext) {
        intent = new Intent(applicationContext, CompanyDocumentsActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        applicationContext.startActivity(intent);

    }

    public static void openQuickAccessActivity(Context applicationContext) {
        intent = new Intent(applicationContext, QuickAccessActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        applicationContext.startActivity(intent);

    }

    public static void openVisasAndCardsActivity(Context applicationContext) {
        intent = new Intent(applicationContext, VisasAndCardsActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        applicationContext.startActivity(intent);

    }

    public static void openHomePageActivity(Context applicationContext) {
        intent = new Intent(applicationContext, HomepageActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        applicationContext.startActivity(intent);
    }

    public static void openNOCActivity(Context applicationContext, String objectAsString, String ObjectType) {
        intent = new Intent(applicationContext, NocActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("objectAsString", objectAsString);
//        Visa v=new Gson().fromJson(objectAsString,Visa.class);
        intent.putExtra("ObjectType", ObjectType);
//        intent.putExtra("object",v);
        applicationContext.startActivity(intent);
    }

    public static void openShowDetailsActivity(Context applicationContext, String title, String objectAsString, String objectType) {
        intent = new Intent(applicationContext, ShowDetailsActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("objectAsString", objectAsString);
        intent.putExtra("title", objectAsString);
        intent.putExtra("objectType", objectType);
        applicationContext.startActivity(intent);
    }

    public static void openEmployeeListActivity(Context applicationContext) {
        intent = new Intent(applicationContext, EmployeeListActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        applicationContext.startActivity(intent);
    }

    public static void openThankYouActivity(Activity activity, Context context, String Message) {
        intent = new Intent(context, ThankYouActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("Message", Message);
        context.startActivity(intent);
        activity.finish();
    }

    public static void openCompanyNocActivity(Context applicationContext) {
        intent = new Intent(applicationContext, CompanyNocActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        applicationContext.startActivity(intent);
    }

    public static void openNewCardActivity(Context applicationContext, String type) {
        intent = new Intent(applicationContext, CardActivity.class);
        intent.putExtra("type", type);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        applicationContext.startActivity(intent);
    }

    public static void openCardActivity(Context context, Card_Management__c card, String type) {
        intent = new Intent(context, CardActivity.class);
        intent.putExtra("type", type);
        intent.putExtra("card",card);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }

    public static void openVisaActivity(Context context, Visa visa, String renew) {
        intent = new Intent(context, VisaActivity.class);
        intent.putExtra("type", renew);
        intent.putExtra("visa",visa);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }

    public static void openShowContractDetailsActivity(Context context, Contract_DWC__c contract_dwc__c) {
        intent = new Intent(context, LeasingShowDetailsActivity.class);
        intent.putExtra("contract", contract_dwc__c);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }

    public static void openNameReservationActivity(Context context) {
        intent = new Intent(context, NameReservationActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);

    }

    public static void openGenericChangeAndRemovalActivity(Context context, String s, Object object) {
        intent = new Intent(context, ChangeAndRemovalActivity.class);
        if (object instanceof Directorship) {
            Directorship directorship = (Directorship) object;
            Gson gson= new Gson();
            intent.putExtra("object",gson.toJson(directorship));
        }
        intent.putExtra("MethodType", s);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }

    public static void openViewStatementActivity(Context context) {
        intent = new Intent(context, ViewStatementActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }
}
