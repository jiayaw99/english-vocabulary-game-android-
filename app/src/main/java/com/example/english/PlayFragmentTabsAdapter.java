package com.example.english;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PlayFragmentTabsAdapter extends FragmentStatePagerAdapter {
    private Fragment[] childFragments;
    protected Fragment category = new PlayFragment_category();
    protected Fragment level = new PlayFragment_level();
    private String[] TAB_TITLES = new String[]{"By Level","By Category"};

    public PlayFragmentTabsAdapter(FragmentManager fm) {
        super(fm);
        childFragments = new Fragment[]{level,category};
    }

    // Returns total number of pages
    @Override
    public int getCount() {
        return  childFragments.length ;
    }

    // Returns the fragment to display for that page
    @Override
    public Fragment getItem(int position) {
        return childFragments[position];
    }

    public CharSequence getPageTitle(int position) {
        return TAB_TITLES[position];
    }
}
