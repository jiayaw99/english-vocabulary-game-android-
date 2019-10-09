package com.example.english;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.appcompat.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class PlayFragment_level extends Fragment {
    private View v;
    private ChoosegameFragment choose=new ChoosegameFragment();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.play_level, container, false);

        Button easy=v.findViewById(R.id.easy_button);
        Button medium=v.findViewById(R.id.medium_button);
        Button hard=v.findViewById(R.id.hard_button);
        final Toolbar toolbar=v.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Learning ABC");
        easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFragment(choose,true);
                Bundle bundle = new Bundle();
                bundle.putString("key","easy" );
                choose.setArguments(bundle);
            }
        });
        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFragment(choose,true);
                Bundle bundle = new Bundle();
                bundle.putString("key","medium" );
                choose.setArguments(bundle);
            }
        });
        hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFragment(choose,true);
                Bundle bundle = new Bundle();
                bundle.putString("key","hard");
                choose.setArguments(bundle);
            }
        });


        return v;
    }

    public void setFragment(Fragment fragment, boolean set) {
//        for (int i = getSupportFragmentManager().getBackStackEntryCount(); i >= 1; i--)
//            getSupportFragmentManager().popBackStack();
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
