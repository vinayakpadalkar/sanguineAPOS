package com.example.apos.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import com.example.apos.fragments.clsShowReservationList;
import com.example.apos.fragments.clsTableReservation;


public class clsTableReservationViewPageAdapter extends FragmentStatePagerAdapter {

    private CharSequence Titles[]; // This will Store the Titles of the Tabs which are Going to be passed when clsDirectBillerViewPagerAdapter is created
    private int NumbOfTabs; // Store the number of tabs, this will also be passed when the clsDirectBillerViewPagerAdapter is created
    private ViewPager mViewPager;
    private Context mContext;

    // Build a Constructor and assign the passed Values to appropriate values in the class
    public clsTableReservationViewPageAdapter (FragmentManager fm, CharSequence mTitles[], int mNumbOfTabsumb, ViewPager viewPager) {
        super(fm);

        this.Titles = mTitles;
        this.NumbOfTabs = mNumbOfTabsumb;
        this.mViewPager = viewPager;

    }

    //This method return the fragment for the every position in the View Pager
    @Override
    public Fragment getItem(int position)
    {

        switch (position)
        {
            case 0:
                clsTableReservation tabTableReservation = clsTableReservation.getInstance();
                return tabTableReservation;

            case 1:
                clsShowReservationList tabReservationList = clsShowReservationList.getInstance();
                return tabReservationList;

        }
        return  null;

    }

    // This method return the titles for the Tabs in the Tab Strip

    @Override
    public CharSequence getPageTitle(int position) {
        return Titles[position];
    }

    // This method return the Number of tabs for the tabs Strip

    @Override
    public int getCount() {
        return NumbOfTabs;
    }
}



