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
import static com.example.english.MainActivity.listimageofeasy;
import static com.example.english.MainActivity.listimageofmedium;
import static com.example.english.MainActivity.listimageofhard;
import static com.example.english.MainActivity.listnameofeasy;
import static com.example.english.MainActivity.listnameofmedium;
import static com.example.english.MainActivity.listnameofhard;

public class ChoosewordFragment extends Fragment {
    private View v;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.play_chooseword, container, false);




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

