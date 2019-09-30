package com.example.english;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.english.R;


public class ChoosegameFragment extends Fragment {
    private View v;
    private ChoosewordFragment word = new ChoosewordFragment();
    private FindimageFragment image = new FindimageFragment();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_choosegame, container, false);

        Button choose = v.findViewById(R.id.chooseword);
        Button find = v.findViewById(R.id.findimage);
        Bundle bundle = this.getArguments();
        image.setArguments(bundle);
        word.setArguments(bundle);
//        Toolbar toolb = v.findViewById(R.id.toolbar);
//        ((AppCompatActivity) getActivity()).setSupportActionBar(toolb);
//        TextView textview = (TextView)toolb.findViewById(R.id.toolbartext);
//        textview.setText(bundle.getString("key"));
//        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
        choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFragment(word, true);
            }
        });

        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFragment(image, true);
            }
        });


        return v;
    }

    public void setFragment(Fragment fragment, boolean set) {
//        for (int i = getActivity().getSupportFragmentManager().getBackStackEntryCount(); i >= 1; i--)
//            getActivity().getSupportFragmentManager().popBackStack();
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
