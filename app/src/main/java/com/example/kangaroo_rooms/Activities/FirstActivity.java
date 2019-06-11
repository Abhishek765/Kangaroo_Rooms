package com.example.kangaroo_rooms.Activities;

import android.app.Activity;
import android.app.Fragment;

import android.app.FragmentTransaction;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.example.kangaroo_rooms.Adapters.ViewPagerAdapter;
import com.example.kangaroo_rooms.Fragments.BookingsFragment;
import com.example.kangaroo_rooms.Fragments.HomeFragment;
import com.example.kangaroo_rooms.Fragments.SavedHotelFragment;
import com.example.kangaroo_rooms.Fragments.YourFragment;
import com.example.kangaroo_rooms.R;

public class FirstActivity extends AppCompatActivity {

    public static BottomNavigationView bottomNavigationView;

    //This is our viewPager
    private ViewPager viewPager;

//    Fragment myFragment;
//    Fragment selectedFragment;
    MenuItem prevMenuItem;
    HomeFragment homeFragment;
    BookingsFragment bookingsFragment;
    SavedHotelFragment savedHotelFragment;
    YourFragment yourFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
//        selectedFragment = HomeFragment.newInstance();
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomnav);

        //Initializing viewPager
        viewPager = (ViewPager) findViewById(R.id.viewpager);

        bottomNavigationView.setItemIconTintList(null);

//        //Manually displaying the first fragment - one time only
//        FragmentTransaction transaction = getFragmentManager().beginTransaction();
//        transaction.replace(R.id.frame_layout, HomeFragment.newInstance(),"CURRENT_FRAGMENT");
//        transaction.commit();

        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                        selectedFragment = HomeFragment.newInstance();
                        switch (item.getItemId()) {
                            case R.id.home_menu_item:
//                                selectedFragment = HomeFragment.newInstance();
                                viewPager.setCurrentItem(0);
                                break;
                            case R.id.saved_hotel_menu_item:
//                                selectedFragment = SavedHotelFragment.newInstance();
                                viewPager.setCurrentItem(1);
                                break;
                            case R.id.bookings_menu_item:
//                                selectedFragment = BookingsFragment.newInstance();
                                viewPager.setCurrentItem(2);
                                break;
                            case R.id.you_menu_item:
//                                selectedFragment = YourFragment.newInstance();
                                viewPager.setCurrentItem(3);
                                break;
                        }
//                        myFragment = (Fragment) getFragmentManager().findFragmentByTag("CURRENT_FRAGMENT");
//                        if(!(myFragment.getClass().equals(selectedFragment.getClass())) ) {
//                            FragmentTransaction transaction = getFragmentManager().beginTransaction();
//                            transaction.replace(R.id.frame_layout, selectedFragment, "CURRENT_FRAGMENT");
//                            transaction.commit();
//                        }
                        return false;
                    }
                });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                }
                else
                {
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }
                Log.d("page", "onPageSelected: "+position);
                bottomNavigationView.getMenu().getItem(position).setChecked(true);
                prevMenuItem = bottomNavigationView.getMenu().getItem(position);

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        setupViewPager(viewPager);


    }
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        homeFragment=new HomeFragment();
        savedHotelFragment=new SavedHotelFragment();
        bookingsFragment = new BookingsFragment();
        yourFragment = new YourFragment();
        adapter.addFragment(homeFragment);
        adapter.addFragment(savedHotelFragment);
        adapter.addFragment(bookingsFragment);
        adapter.addFragment(yourFragment);
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
//        if(!((HomeFragment.newInstance()).getClass().equals(viewPager.getCurrentItem())) ) {
//            View view = FirstActivity.bottomNavigationView.findViewById(R.id.home_menu_item);
//            view.performClick();
//        }
//       else {
//
//
//        }
        if (viewPager.getCurrentItem() != 0) {
            viewPager.setCurrentItem(0);
        }else{
            finish();
        }


    }
}
