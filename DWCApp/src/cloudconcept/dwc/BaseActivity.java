package cloudconcept.dwc;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.rest.RestClient;
import com.salesforce.androidsdk.ui.sfnative.SalesforceActivity;

import java.util.ArrayList;

import adapter.NavDrawerListAdapter;
import custom.BadgeButton;
import dataStorage.StoreData;
import de.hdodenhof.circleimageview.CircleImageView;
import model.NavDrawerItem;
import utilities.ActivitiesLauncher;
import utilities.Utilities;

/**
 * Created by Abanoub on 6/22/2015.
 */

public abstract class BaseActivity extends SalesforceActivity implements View.OnClickListener {

    TextView tvTitle;
    int notificationCount = 0;
    RelativeLayout tabBarHome, tabBarRequest, tabBarReport, tabBarDashboard;
    private FragmentManager fragmentManager;
    private ImageView imageBack;
    private ImageView imageMenu;
    private BadgeButton badgeNotifications;
    private DrawerLayout drawerLayout;
    protected static RestClient client;
    private Button btnTransparent;

    public DrawerLayout.DrawerListener drawerDisabledListener = new DrawerLayout.DrawerListener() {

        @Override
        public void onDrawerStateChanged(int arg0) {

        }

        @Override
        public void onDrawerSlide(View view, float arg1) {

        }

        @Override
        public void onDrawerOpened(View view) {
            drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        }

        @Override
        public void onDrawerClosed(View view) {
            drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
        }
    };
    private View.OnClickListener listenerOk1 = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            SalesforceSDKManager.getInstance().logout(BaseActivity.this);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base);
        InitializeViews();
    }

    private void InitializeViews() {
        imageBack = (ImageView) findViewById(R.id.imageBack);
        imageMenu = (ImageView) findViewById(R.id.imageMenu);
        badgeNotifications = (BadgeButton) findViewById(R.id.btnNotifications);
        badgeNotifications.setBadgeDrawable(getResources().getDrawable(
                R.drawable.notification_image3));
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        tabBarHome = (RelativeLayout) findViewById(R.id.relativeTabBarHome);
        tabBarRequest = (RelativeLayout) findViewById(R.id.relativeTabBarRequest);
        tabBarReport = (RelativeLayout) findViewById(R.id.relativeTabBarReport);
        tabBarDashboard = (RelativeLayout) findViewById(R.id.relativeTabBarDashboard);
        tabBarHome = (RelativeLayout) findViewById(R.id.relativeTabBarHome);
        btnTransparent = (Button) findViewById(R.id.btnTransparent);
        tabBarHome.setOnClickListener(this);
        tabBarRequest.setOnClickListener(this);
        tabBarReport.setOnClickListener(this);
        tabBarDashboard.setOnClickListener(this);
        ListView list = (ListView) findViewById(R.id.left_drawer);
        ArrayList<NavDrawerItem> _drawerItems = new ArrayList<NavDrawerItem>();
        String[] TITLES = getResources().getStringArray(R.array.drawer_list);
        int[] Icons = new int[]{R.drawable.slide_home, R.drawable.slide_dashboard, R.drawable.slide_myrequest, R.drawable.slide_visas_cards, R.drawable.slide_company_info, R.drawable.slide_reports, R.drawable.slide_company_documents, R.drawable.slide_need_help, R.drawable.slide_logout};
        for (int i = 0; i < TITLES.length; i++) {
            NavDrawerItem _item = new NavDrawerItem();
            _item.setTitle(TITLES[i]);
            _item.setIcon(Icons[i]);
            _drawerItems.add(_item);
        }

        LayoutInflater mInflater = (LayoutInflater)
                getApplicationContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View v = mInflater.inflate(R.layout.header, null);
        TextView tvTitle = (TextView) v.findViewById(R.id.tvProfileName);
        CircleImageView imageUser = (CircleImageView) v.findViewById(R.id.circleView);
        tvTitle.setText(new StoreData(getApplicationContext()).getUsername());
        list.addHeaderView(v);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position - 1) {
                    case 0:
                        ActivitiesLauncher.openHomePageActivity(getApplicationContext());
                        break;
                    case 1:
                        ActivitiesLauncher.openDashboardActivity(getApplicationContext());
                        break;
                    case 2:
                        ActivitiesLauncher.openMyRequestsActivity(getApplicationContext());
                        break;
                    case 3:
                        ActivitiesLauncher.openVisasAndCardsActivity(getApplicationContext());
                        break;
                    case 4:
                        ActivitiesLauncher.openCompanyInfoActivity(getApplicationContext());
                        break;
                    case 5:
                        ActivitiesLauncher.openReportsActivity(getApplicationContext());
                        break;
                    case 6:
                        ActivitiesLauncher.openCompanyDocumentsActivity(getApplicationContext());
                        break;
                    case 7:
                        ActivitiesLauncher.openNeedHelpActivity(getApplicationContext());
                        break;
                    case 8:
                        Utilities.showNiftyDialog("Log out", BaseActivity.this, listenerOk1);
                        break;
                }
            }
        });

        list.setAdapter(new NavDrawerListAdapter(getApplicationContext(), _drawerItems));
        ControlHeaderVisibillity();
    }

    @Override
    public void onResume(RestClient client) {
        this.client = client;
    }

    private void ControlHeaderVisibillity() {
        ManageBadgeNotification();
        ManageBackVisibillity();
        ManageMenuVisibillity();
        ManageNotificationsVisibillity();
        tvTitle.setText(getHeaderTitle());
        changeFragment(GetFragment());
    }

    private void ManageNotificationsVisibillity() {

        if (getNotificationVisibillity() == View.VISIBLE) {
            badgeNotifications.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ActivitiesLauncher.openNotificationsActivity(getApplicationContext());
                }
            });
        } else {
            badgeNotifications.setOnClickListener(null);
            if (getBackVisibillity() == View.INVISIBLE) {
                badgeNotifications.setVisibility(View.INVISIBLE);
            } else {
                badgeNotifications.setVisibility(View.GONE);
            }
        }
    }

    private void ManageMenuVisibillity() {
        if (getMenuVisibillity() == View.VISIBLE) {
            imageMenu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!drawerLayout.isDrawerOpen(Gravity.LEFT)) {
                        drawerLayout.openDrawer(Gravity.LEFT);
                    } else {
                        drawerLayout.closeDrawer(Gravity.LEFT);
                    }
                }
            });
            btnTransparent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!drawerLayout.isDrawerOpen(Gravity.LEFT)) {
                        drawerLayout.openDrawer(Gravity.LEFT);
                    } else {
                        drawerLayout.closeDrawer(Gravity.LEFT);
                    }
                }
            });
        } else {
            imageMenu.setOnClickListener(null);
            if (getBackVisibillity() == View.INVISIBLE) {
                imageMenu.setVisibility(View.INVISIBLE);
                drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
            } else {
                imageMenu.setVisibility(View.GONE);
                drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
            }
        }
    }

    private void ManageBackVisibillity() {

        if (getBackVisibillity() == View.VISIBLE) {
            imageBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
            btnTransparent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        } else {
            imageBack.setOnClickListener(null);
            if (getBackVisibillity() == View.INVISIBLE) {
                imageBack.setVisibility(View.INVISIBLE);
            } else {
                imageBack.setVisibility(View.GONE);
            }
        }
    }

    private void ManageBadgeNotification() {
        notificationCount = new StoreData(getApplicationContext()).getNotificationCount();
        if (notificationCount == 0) {
            badgeNotifications.hideBadge();
        } else {
            badgeNotifications.setBadgeText(notificationCount + "");
            badgeNotifications.showBadge();
        }
    }

    private void changeFragment(Fragment targetFragment) {
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.content_frame, targetFragment, getHeaderTitle())
                .commitAllowingStateLoss();
    }

    public abstract int getNotificationVisibillity();

    public abstract int getMenuVisibillity();

    public abstract int getBackVisibillity();

    public abstract String getHeaderTitle();

    public abstract Fragment GetFragment();

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(Gravity.LEFT)) {
            drawerLayout.closeDrawer(Gravity.LEFT);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onClick(View v) {
        if (v == tabBarHome) {

            ActivitiesLauncher.openHomePageActivity(getApplicationContext());

        } else if (v == tabBarRequest) {

            ActivitiesLauncher.openMyRequestsActivity(getApplicationContext());

        } else if (v == tabBarReport) {

            ActivitiesLauncher.openReportsActivity(getApplicationContext());

        } else if (v == tabBarDashboard) {

            ActivitiesLauncher.openDashboardActivity(getApplicationContext());
        }
    }
}
