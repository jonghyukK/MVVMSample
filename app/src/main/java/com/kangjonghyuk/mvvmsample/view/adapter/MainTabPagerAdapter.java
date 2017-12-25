package com.kangjonghyuk.mvvmsample.view.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.kangjonghyuk.mvvmsample.R;
import com.kangjonghyuk.mvvmsample.view.ui.fragment.main.TabFragment1;
import com.kangjonghyuk.mvvmsample.view.ui.fragment.main.TabFragment2;
import com.kangjonghyuk.mvvmsample.view.ui.fragment.main.TabFragment3;
import com.kangjonghyuk.mvvmsample.view.ui.fragment.main.TabFragment4;

/**
 * Created by USER on 2017-12-19.
 */

public class MainTabPagerAdapter extends FragmentStatePagerAdapter {

    private static final int First = 0;
    private static final int Second = 1;
    private static final int Third = 2;
    private static final int Fours = 3;
    private static final int Five = 4;

    private static final int[] TABS = new int[]{First, Second, Third, Fours};

    private Context mContext;

    public MainTabPagerAdapter(Context context, FragmentManager fm){
        super(fm);
        this.mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        // Returning the current tabs
        switch (TABS[position]) {
            case First:
                TabFragment1 tabFragment1 = TabFragment1.newInstance("one", "Two");
                return tabFragment1;
            case Second:
                TabFragment2 tabFragment2 = TabFragment2.newInstance("one", "Two");
                return tabFragment2;
            case Third:
                TabFragment3 tabFragment3 = TabFragment3.newInstance("one", "Two");
                return tabFragment3;
            case Fours:
                TabFragment4 tabFragment4 = TabFragment4.newInstance("one", "Two");
                return tabFragment4;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return TABS.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (TABS[position]) {

            case First:
                return mContext.getResources().getString(R.string.fragment_title_1);
            case Second:
                return mContext.getResources().getString(R.string.fragment_title_2);
            case Third:
                return mContext.getResources().getString(R.string.fragment_title_3);
            case Fours:
                return mContext.getResources().getString(R.string.fragment_title_4);
        }
        return null;
    }
}
