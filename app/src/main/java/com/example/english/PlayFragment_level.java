package com.example.english;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class PlayFragment_level extends Fragment {
    private View v;
    private ChoosegameFragment choose=new ChoosegameFragment();

    private FindimageFragment fif=new FindimageFragment();
    private ChoosewordFragment cwf=new ChoosewordFragment();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.play_level, container, false);

        Button easy=v.findViewById(R.id.easy_button);
        Button medium=v.findViewById(R.id.medium_button);
        Button hard=v.findViewById(R.id.hard_button);

        easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFragment(choose,true);
                getActivity().getActionBar().setTitle("EASY");
                Bundle bundle = new Bundle();
                bundle.putString("key","EASY" );
                fif.setArguments(bundle);
                cwf.setArguments(bundle);
            }
        });
        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFragment(choose,true);
                getActivity().getActionBar().setTitle("MEDIUM");
                Bundle bundle = new Bundle();
                bundle.putString("key","MEDIUM" );
                fif.setArguments(bundle);
                cwf.setArguments(bundle);
            }
        });
        hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFragment(choose,true);
                getActivity().getActionBar().setTitle("HARD");
                Bundle bundle = new Bundle();
                bundle.putString("key","HARD" );
                fif.setArguments(bundle);
                cwf.setArguments(bundle);
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
