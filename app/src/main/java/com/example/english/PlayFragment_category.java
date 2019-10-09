package com.example.english;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import static com.example.english.MainActivity.listofcategoryimage;
import static com.example.english.MainActivity.listofcategoryname;

public class PlayFragment_category extends Fragment {
    private View v;
    private String[] nameofbutton = new String[16];
private ChoosegameFragment choosegame= new ChoosegameFragment();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.play_category, container, false);

        for (int i = 0; i < 16; i++)
            nameofbutton[i] = "category" + (i + 1);
        LinearLayout[] button = new LinearLayout[16];
        for (int i = 0; i < 16; i++) {
            button[i] = v.findViewById(getResources().getIdentifier(nameofbutton[i], "id", getActivity().getPackageName()));
            final int finalI = i;
            button[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    setFragment(choosegame,true);
                    Bundle bundle = new Bundle();
                    bundle.putString("key",listofcategoryname[finalI].get(0).split("-")[1]);
                    choosegame.setArguments(bundle);
                }
            });
        }


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
