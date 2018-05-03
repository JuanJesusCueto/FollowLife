package com.dmsoftware.followlife.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.dmsoftware.followlife.R;
import com.dmsoftware.followlife.fragments.AppointmentFragment;
import com.dmsoftware.followlife.fragments.HomeFragment;
import com.dmsoftware.followlife.fragments.ProfileFragment;
import com.dmsoftware.followlife.fragments.RoomFragment;

public class BottomActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            return navigateAccordingTo(item.getItemId());
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.navbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_logout:
                finish();;
                System.exit(0);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private boolean navigateAccordingTo(int id) {
        try {
            FragmentManager fm = getSupportFragmentManager();
            for (int i = 0; i<fm.getBackStackEntryCount();++i) {
                fm.popBackStack();
            }
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content, getFragmentFor(id)).commit();
            return true;
        } catch (NullPointerException e) {
            e.printStackTrace();
            return false;
        }
    }

    private Fragment getFragmentFor(int id) {
        switch (id) {
            case R.id.navigation_home: return new HomeFragment();
            case R.id.navigation_room: return new RoomFragment();
            case R.id.navigation_appointment: return new AppointmentFragment();
            case R.id.navigation_profile: return new ProfileFragment();
        }
        return null;
    }
}
