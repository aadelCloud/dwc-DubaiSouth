package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import cloudconcept.dwc.R;
import utilities.ActivitiesLauncher;

/**
 * Created by Bibo on 7/21/2015.
 */
public class QuickAccessFragment extends Fragment {

    ImageView imageCompanyNOc, imageEmployeeNOC, imageNewCard;
    TextView tvCompanyNOC, tvEmployeeNOC, tvNewCard;

    public static QuickAccessFragment newInstance() {
        QuickAccessFragment fragment = new QuickAccessFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.quick_access, container, false);
        InitializeViews(view);
        return view;
    }

    private void InitializeViews(View view) {
        imageCompanyNOc = (ImageView) view.findViewById(R.id.imageCompanyNOC);
        imageEmployeeNOC = (ImageView) view.findViewById(R.id.imageEmpoyeeNOC);
        imageNewCard = (ImageView) view.findViewById(R.id.imageNewCard);
        tvCompanyNOC = (TextView) view.findViewById(R.id.tvCompanyNOC);
        tvEmployeeNOC = (TextView) view.findViewById(R.id.tvEmployeeNOC);
        tvNewCard = (TextView) view.findViewById(R.id.tvNewCard);

        imageCompanyNOc.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                PerformCompanyNOCAction();
            }
        });

        tvCompanyNOC.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                PerformCompanyNOCAction();
            }
        });

        imageEmployeeNOC.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                PerformEmployeeNOCAction();
            }
        });

        tvEmployeeNOC.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                PerformEmployeeNOCAction();
            }
        });

        imageNewCard.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ActivitiesLauncher.openNewCardActivity(getActivity().getApplicationContext(), "1");
            }
        });

        tvNewCard.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ActivitiesLauncher.openNewCardActivity(getActivity().getApplicationContext(), "1");
            }
        });
    }

    private void PerformEmployeeNOCAction() {
        ActivitiesLauncher.openEmployeeListActivity(getActivity().getApplicationContext());
    }

    private void PerformCompanyNOCAction() {
        ActivitiesLauncher.openCompanyNocActivity(getActivity().getApplicationContext());
    }
}
