package com.feriramara.ukrainianapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 21.02.2018.
 */

public class SectionPageAdapter  extends FragmentPagerAdapter {

    private final List<Fragment> mFragmentsList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();

    public void addFragments(Fragment fragment, String title) {
        mFragmentsList.add(fragment);
        mFragmentTitleList.add(title);
    }


    public SectionPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentsList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentsList.size();
    }
}
