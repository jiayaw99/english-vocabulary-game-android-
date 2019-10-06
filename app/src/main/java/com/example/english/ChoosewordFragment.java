package com.example.english;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.Random;

import static com.example.english.FindimageFragment.answerlist;
import static com.example.english.FindimageFragment.roundnumber;
import static com.example.english.MainActivity.listimageofeasy;
import static com.example.english.MainActivity.listimageofmedium;
import static com.example.english.MainActivity.listimageofhard;
import static com.example.english.MainActivity.listnameofeasy;
import static com.example.english.MainActivity.listnameofmedium;
import static com.example.english.MainActivity.listnameofhard;

public class ChoosewordFragment extends Fragment {
    private View v;
    private String [] idofbutton={"word1","word2","word3","word4"};
    private ArrayList<Integer> random=new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.play_chooseword, container, false);

        random.clear();
        if(roundnumber>0)
            SystemClock.sleep(1000);
        if(roundnumber==5)
            setFragment(new ResultFragment(),true);

        TextView roundtext=v.findViewById(R.id.roundnotext);
        roundtext.setText(roundnumber+1+" / "+5);
        final Bundle bundle = this.getArguments();
        String keyword = bundle.getString("key");

        final Button[] button=new Button[4];

        for(int i=0;i<4;i++){
            button[i]=v.findViewById(getResources().getIdentifier(idofbutton[i], "id", getActivity().getPackageName()));
        }

        ImageView imagehint=v.findViewById(R.id.imagehint);
        if (keyword.equals("EASY") ) {
            final int ran=new Random().nextInt(4);
            int ans=new Random().nextInt(listimageofeasy.size());
            while(answerlist.contains(ans)){
                ans=new Random().nextInt(listimageofeasy.size());
                if(!answerlist.contains(ans)){
                    answerlist.add(ans);break;}
            }
            if(!answerlist.contains(ans))
                answerlist.add(ans);
            setrandomnumber(listimageofeasy.size(),ran,ans);
            for(int i=0;i<listimageofeasy.size();i++){
                getResources().getDrawable(listimageofeasy.get(i), null).clearColorFilter();
            }
            imagehint.setImageResource(listimageofeasy.get(ans));
            for(int i=0;i<4;i++){
                button[i].setText(listnameofeasy.get(random.get(i)));
                button[i].getBackground().clearColorFilter();
            }
            button[ran].setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.M)
                @Override
                public void onClick(View view) {
                    freezebutton(button);
                    button[ran].setBackgroundColor(Color.GREEN);
                    reload(bundle);
                    roundnumber++;
                }
            });
            for(int i=0;i<4;i++) {
                final int finalI = i;
                if(i!=ran)
                    button[i].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            freezebutton(button);
                            button[finalI].setBackgroundColor(Color.RED);
                            button[ran].setBackgroundColor(Color.GREEN);
                            reload(bundle);
                            roundnumber++;
                        }
                    });
            }
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
        if(roundnumber<4)
            fragmentTransaction.replace(R.id.findwordincrease, fragment);
        else
            fragmentTransaction.replace(R.id.fragment_container, fragment);
//        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void reload(Bundle bundle){
        ChoosewordFragment newone=new ChoosewordFragment();
        setFragment(newone, true);
        newone.setArguments(bundle);
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
            else if(i==notthislocation)
                random.add(answer);
            else
                i--;
        }
    }

    public void freezebutton(Button[] button){
        for(int i=0;i<button.length;i++){
            button[i].setClickable(false);
        }
    }
}

