package com.example.english;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.io.File;

public class HomeFragment extends Fragment {

    private View v;
    private DrawerLayout drawerLayout;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        v = inflater.inflate(R.layout.fragment_home, container, false);

        Button learn=v.findViewById(R.id.learn_button);
        Button play=v.findViewById(R.id.play_button);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Learning ABC");
        learn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFragment(new LearnFragment(),true);
            }
        });
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFragment(new PlayFragment(),true);
            }
        });
        return v;
    }
    public void setFragment(Fragment fragment, boolean set){
//        for (int i = getActivity().getSupportFragmentManager().getBackStackEntryCount(); i >= 1; i--)
//            getActivity().getSupportFragmentManager().popBackStack();
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }


}
