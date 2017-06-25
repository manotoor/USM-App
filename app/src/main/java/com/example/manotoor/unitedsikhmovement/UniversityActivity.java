package com.example.manotoor.unitedsikhmovement;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.TableLayout;

import static android.R.drawable.ic_menu_gallery;
import static android.R.drawable.ic_menu_my_calendar;

/**
 * Created by Mano Toor on 6/19/2017.
 */

public class UniversityActivity extends FragmentActivity {

    public static final int NUM_PAGES = 3;
    private School school;

    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;
    private PagerTitleStrip mPageTitleStrip;
    private TabLayout mTabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpager_main);

        Bundle bundle = getIntent().getExtras();
        //get the bundles extras by KEY STRING, but keystring is uni_position
        if(bundle != null) {
            school = (School) bundle.getSerializable(RecyclerAdapter.PHOTO_KEY);
        }
        //getActionBar().setLogo(R.drawable.ucla_logo);

        // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);
        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mTabLayout.setupWithViewPager(mPager);
        init();
    }
    private void init(){
        mTabLayout.getTabAt(0).setIcon(R.drawable.ucla_logo);
        mTabLayout.getTabAt(1).setIcon(ic_menu_my_calendar);
        mTabLayout.getTabAt(2).setIcon(ic_menu_gallery);
    }
    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
             // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }

    /**
          * A simple pager adapter that represents 3 ScreenSlidePageFragment objects, in
          * sequence.
          */
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            //Or can copy getPageTitle to and load a new fragmentPage
            Fragment fragment = new UniversityFragment();
            Bundle args = new Bundle();
            args.putInt(UniversityFragment.ARG_SECTION_NUMBER,position+1);
            args.putSerializable(UniversityFragment.ARG_UNIVERSITY,school);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }

        @Override
        public CharSequence getPageTitle(int position) {
//            switch (position) {
//                case 0: return school.getAcry();
//                case 1: return getString(R.string.title_section2).toUpperCase();
//                case 2: return getString(R.string.title_section3).toUpperCase();
//            }
            return null;
        }

    }

}
