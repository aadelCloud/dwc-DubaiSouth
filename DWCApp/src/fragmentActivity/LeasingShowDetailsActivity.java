package fragmentActivity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.gc.materialdesign.views.Button;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import cloudconcept.dwc.R;
import model.Contract_DWC__c;
import utilities.Utilities;

/**
 * Created by Abanoub Wagdy on 8/31/2015.
 */
public class LeasingShowDetailsActivity extends FragmentActivity {

    Contract_DWC__c contract_dwc__c;
    private Button btnRenewContract;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_details_leasing_contract);
        btnRenewContract = (Button) findViewById(R.id.btnRenewContract);
        contract_dwc__c = (Contract_DWC__c) getIntent().getExtras().get("contract");
        Calendar cal1 = new GregorianCalendar();
        Calendar cal2 = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        Date date = null;
        try {
            date = sdf.parse(contract_dwc__c.getContract_Expiry_Date__c().toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal1.setTime(date);
        Date date2 = null;
        try {
            date2 = sdf.parse(Utilities.getCurrentTimeStamp().substring(0, 10));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal2.setTime(date2);

        int days = Utilities.daysBetween(date, date2);
        if (days <= 60) {
            btnRenewContract.setVisibility(View.VISIBLE);
            btnRenewContract.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        } else {
            btnRenewContract.setVisibility(View.GONE);
        }
    }
}
