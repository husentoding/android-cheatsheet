package com.example.husen.bottomnavbar;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.husen.bottomnavbar.fragment_navigation.FavouriteFragment;
import com.example.husen.bottomnavbar.fragment_navigation.HomeFragment;
import com.example.husen.bottomnavbar.fragment_navigation.ProfileFragment;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView mainNav;
    private FrameLayout mainFrame;
    private HomeFragment hf = new HomeFragment();
    private ProfileFragment pf = new ProfileFragment();
    private FavouriteFragment ff = new FavouriteFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Mosen Today");
        mainNav = (BottomNavigationView) findViewById(R.id.main_navbar);
        mainFrame = (FrameLayout) findViewById(R.id.frame_main);

        setFragment(hf);
        mainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()== R.id.nav_home){
                    setFragment(hf);
                }else if(item.getItemId() == R.id.nav_favourite){
                    setFragment(ff);
                }else if(item.getItemId() == R.id.nav_profile){
                    setFragment(pf);
                }else{
                    return false;
                }
                return true;
            };
        });

    }

    private void setFragment(Fragment f){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame_main, f);
        ft.commit();
    }
}
