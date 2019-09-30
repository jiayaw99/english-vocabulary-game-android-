package com.example.english;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.Random;

import static com.example.english.MainActivity.listimageofeasy;
import static com.example.english.MainActivity.listimageofmedium;
import static com.example.english.MainActivity.listimageofhard;
import static com.example.english.MainActivity.listnameofeasy;
import static com.example.english.MainActivity.listnameofmedium;
import static com.example.english.MainActivity.listnameofhard;


public class FindimageFragment extends Fragment {
    private View v;
    private String [] idofbutton={"image1","image2","image3","image4"};
    private ArrayList<Integer> random=new ArrayList<>();
    private FindimageFragment fif=new FindimageFragment();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.play_findimage, container, false);

        Bundle bundle = this.getArguments();
        String keyword = bundle.getString("key");

        final Button[] button=new Button[4];
        TextView texthint=v.findViewById(R.id.texthint);
        for(int i=0;i<4;i++){
            button[i]=v.findViewById(getResources().getIdentifier(idofbutton[i], "id", getActivity().getPackageName()));
        }

        if (keyword.equals("EASY") ) {
            final int ran=new Random().nextInt(4);
            int ans=new Random().nextInt(listimageofeasy.size());
            setrandomnumber(listimageofeasy.size(),ran,ans);
            texthint.setText(listnameofeasy.get(ans).split("-")[0]);
            for(int i=0;i<4;i++){
                button[i].setBackgroundResource(listimageofeasy.get(random.get(i)));
            }
            button[ran].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    button[ran].setBackgroundResource(R.drawable.correct);
                    setFragment(fif,true);
                }
            });
            for(int i=0;i!=ran&&i<4;i++)
                button[i].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        button[ran].setBackgroundResource(R.drawable.wrong);
                        setFragment(fif,true);
                    }
                });
        }else if(keyword.equals("MEDIUM")){

        }else if(keyword.equals("HARD")){

        }
        else {

        }


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

    public void setrandomnumber(int listsize,int notthislocation,int answer){
        for(int i=0;i<4;i++){
            int temp=new Random().nextInt(listsize);
            if(i!=notthislocation&&temp!=answer){
                    if(random.contains(temp)){
                        i--;
                    }else {
                        random.add(temp);
                    }
            }
            else
                random.add(answer);
        }
    }
}
