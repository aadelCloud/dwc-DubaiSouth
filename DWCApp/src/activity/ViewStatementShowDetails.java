package activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

import cloudconcept.dwc.R;
import model.FreeZonePayment;
import utilities.Utilities;

/**
 * Created by Abanoub Wagdy on 9/8/2015.
 */
public class ViewStatementShowDetails extends Activity {

    ImageView imageShowDetails, imageBack;
    TextView tvEmployeeName, tvAmount, tvBalance, tvDate, tvStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_details_view_statement);
        imageShowDetails = (ImageView) findViewById(R.id.imageShowDetails);
        imageBack = (ImageView) findViewById(R.id.imageBack);
        tvEmployeeName = (TextView) findViewById(R.id.tvEmployeeName);
        tvAmount = (TextView) findViewById(R.id.tvAmount);
        tvBalance = (TextView) findViewById(R.id.tvBalance);
        tvDate = (TextView) findViewById(R.id.tvDate);
        tvStatus = (TextView) findViewById(R.id.tvStatus);
        Gson gson = new Gson();
        FreeZonePayment freeZonePayment = gson.fromJson(getIntent().getExtras().getString("str"), FreeZonePayment.class);
        if(freeZonePayment.getEffectOnAccount().equals("Debit")){
            imageShowDetails.setImageResource(R.drawable.payment_debit);
            tvAmount.setText(Utilities.stringNotNull(freeZonePayment.getDebitAmount()) + " AED.");
            tvBalance.setText("");
        }else{
            imageShowDetails.setImageResource(R.drawable.payment_credit);
            tvAmount.setText(Utilities.stringNotNull(freeZonePayment.getCreditAmount()) + " AED.");
            tvBalance.setText(Utilities.stringNotNull(freeZonePayment.getClosingBalance()));
        }

        imageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        tvEmployeeName.setText(Utilities.stringNotNull(freeZonePayment.getEmployeeName()));

        tvDate.setText(!Utilities.stringNotNull(freeZonePayment.getCreatedDate()).equals("") ? Utilities.stringNotNull(freeZonePayment.getCreatedDate()).substring(0, 10) : "");
        tvStatus.setText(Utilities.stringNotNull(freeZonePayment.getStatus()));
    }
}
