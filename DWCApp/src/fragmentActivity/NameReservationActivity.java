package fragmentActivity;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import cloudconcept.dwc.BaseActivity;
import cloudconcept.dwc.R;
import fragment.Cards.NewCard.MainNewCardFragment;
import fragment.NameReservationFragment;

/**
 * Created by Abanoub Wagdy on 8/31/2015.
 */
public class NameReservationActivity extends FragmentActivity{

    private String choice1Text,choice2Text,choice3Text;
    private android.support.v4.app.FragmentManager fragmentManager;
    private String caseNumber;

    public String getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }

    public String getChoice1Text() {
        return choice1Text;
    }

    public String getChoice2Text() {
        return choice2Text;
    }

    public String getChoice3Text() {
        return choice3Text;
    }

    public void setChoice1Text(String choice1Text) {
        this.choice1Text = choice1Text;
    }

    public void setChoice2Text(String choice2Text) {
        this.choice2Text = choice2Text;
    }

    public void setChoice3Text(String choice3Text) {
        this.choice3Text = choice3Text;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_card);
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.content_frame, NameReservationFragment.newInstance("NewCard"))
                .commit();
    }
}
