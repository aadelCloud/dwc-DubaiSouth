package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cloudconcept.dwc.R;

/**
 * Created by Bibo on 7/22/2015.
 */
public class ReportsFragment extends Fragment {

    public static Fragment newInstance(String reports) {
        ReportsFragment fragment = new ReportsFragment();
        Bundle bundle = new Bundle();
        bundle.putString("text", reports);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.reports, container, false);
        return view;
    }
}
