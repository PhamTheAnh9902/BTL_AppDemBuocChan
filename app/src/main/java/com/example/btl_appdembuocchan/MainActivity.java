package com.example.btl_appdembuocchan;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.btl_appdembuocchan.fragments.ViewPagerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    private ViewPager2 viewPager;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.view_pager);
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(3);




        // xu ly su kien
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position){
                    case 0:
                        bottomNavigationView.getMenu().findItem(R.id.kehoach).setChecked(true);break;
                    case 1:
                        bottomNavigationView.getMenu().findItem(R.id.tiendo).setChecked(true);break;
                    case 2:
                        bottomNavigationView.getMenu().findItem(R.id.batdau).setChecked(true);break;
                    case 3:
                        bottomNavigationView.getMenu().findItem(R.id.buoc).setChecked(true);break;
                    case 4:
                        bottomNavigationView.getMenu().findItem(R.id.caidat).setChecked(true);break;
                }
            }
        });

        bottomNavigationView.setOnItemReselectedListener(new NavigationBarView.OnItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.kehoach:
                        viewPager.setCurrentItem(0);break;
                    case R.id.tiendo:
                        viewPager.setCurrentItem(1);break;
                    case R.id.batdau:
                        viewPager.setCurrentItem(2);break;
                    case R.id.buoc:
                        viewPager.setCurrentItem(3);break;
                    case R.id.caidat:
                        viewPager.setCurrentItem(4);break;
                }
            }
        });
    }
}