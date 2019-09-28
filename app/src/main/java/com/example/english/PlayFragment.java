package com.example.english;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class PlayFragment extends Fragment {
    private View v;
    private ViewPager vpPager;
    private PlayFragmentTabsAdapter tabsadapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_play, container, false);
        if (tabsadapter == null) init();

        vpPager = v.findViewById(R.id.viewpager);
        vpPager.setAdapter(tabsadapter);

        TabLayout tabLayout = v.findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(vpPager);

        vpPager.setOffscreenPageLimit(2);

        return v;
    }

    public void init() {
        tabsadapter = new PlayFragmentTabsAdapter(getChildFragmentManager());
    }


}
