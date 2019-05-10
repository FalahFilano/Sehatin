package com.kamurapi.sehatin;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.FrameLayout;

import com.filano.sehatin.R;

public class MenuActivity extends AppCompatActivity  {

    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;

    private HomeFragment homeFragment;
    private ExploreFragment exploreFragment;
    private ProfileFragment profileFragment;
    private DetailFragment detailFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);



        mMainFrame = (FrameLayout) findViewById(R.id.mainFrame);
        mMainNav = (BottomNavigationView) findViewById(R.id.mainNav);

        homeFragment = new HomeFragment();
        exploreFragment = new ExploreFragment();
        profileFragment = new ProfileFragment();
        detailFragment = new DetailFragment();
//        mMainNav.setItemBackgroundResource(R.color.colorAccent);
//        setFragment(homeFragment);

        final Button button_mulai = (Button) findViewById(R.id.mulai_activity);

        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.navHome :
                        mMainNav.setItemBackgroundResource(R.color.colorAccent);
                        setFragment(homeFragment);
                        return true;

                    case R.id.navExplore :
                        mMainNav.setItemBackgroundResource(R.color.colorAccent);
                        setFragment(exploreFragment);
                        return true;

                    case R.id.navProfile :
                        mMainNav.setItemBackgroundResource(R.color.colorAccent);
                        setFragment(profileFragment);
                        return  true;

                    default:
                        return  false;


                }
            }
        });
    }
    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.mainFrame, fragment);
        fragmentTransaction.commit();
    }



}
