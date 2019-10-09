package com.example.english;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
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
import static com.example.english.MainActivity.listoflevelname;
import static com.example.english.MainActivity.listoflevelimage;
import static com.example.english.MainActivity.listofcategoryimage;
import static com.example.english.MainActivity.listofcategoryname;

public class ChoosewordFragment extends Fragment {
    private View v;
    private String [] idofbutton={"word1","word2","word3","word4"};
    private ArrayList<Integer> random=new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.play_chooseword, container, false);

        random.clear();
//        if(roundnumber>0)
//            SystemClock.sleep(1000);
        if(roundnumber>=10)
            setFragment(new ResultFragment(),true);

        TextView roundtext=v.findViewById(R.id.roundnotext);
        roundtext.setText(roundnumber+1+" / "+10);
        final Bundle bundle = this.getArguments();
        String keyword = bundle.getString("key");

        final Button[] button=new Button[4];

        for(int i=0;i<4;i++){
            button[i]=v.findViewById(getResources().getIdentifier(idofbutton[i], "id", getActivity().getPackageName()));
        }

        ImageView imagehint=v.findViewById(R.id.imagehint);
        if (keyword.equals("easy")||keyword.equals("medium")||keyword.equals("hard")) {
            int whichcategory = 0;
            for(int i=0;i<3;i++){
                if(listoflevelname[i].get(0).split("-")[2].equals(keyword)){
                    whichcategory=i;break;
                }
            }
            final int ran=new Random().nextInt(4);
            int ans=new Random().nextInt(listoflevelname[whichcategory].size());
            while(answerlist.contains(ans)){
                ans=new Random().nextInt(listoflevelname[whichcategory].size());
                if(!answerlist.contains(ans)){
                    answerlist.add(ans);break;}
            }
            if(!answerlist.contains(ans))
                answerlist.add(ans);
            setrandomnumber(listoflevelname[whichcategory].size(),ran,ans);
            imagehint.setImageResource(listoflevelimage[whichcategory].get(ans));
//            imagehint.getDrawable().clearColorFilter();
            for(int i=0;i<4;i++){
                button[i].setText(listoflevelname[whichcategory].get(random.get(i)).split("-")[0]);
            }
            button[ran].setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.M)
                @Override
                public void onClick(View view) {
                    freezebutton(button);
                    button[ran].setBackgroundColor(Color.GREEN);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            reload(bundle);
                        }
                    },1000);
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
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    reload(bundle);
                                }
                            },1000);
                            roundnumber++;
                        }
                    });
            }
        } else {
            int whichcategory = 0;
            for(int i=0;i<16;i++){
                if(listofcategoryname[i].get(0).split("-")[1].equals(keyword)){
                    whichcategory=i;break;
                }
            }
            final int ran=new Random().nextInt(4);
            int ans=new Random().nextInt(listofcategoryname[whichcategory].size());
            while(answerlist.contains(ans)){
                ans=new Random().nextInt(listofcategoryname[whichcategory].size());
                if(!answerlist.contains(ans)){
                    answerlist.add(ans);break;}
            }
            if(!answerlist.contains(ans))
                answerlist.add(ans);
            setrandomnumber(listofcategoryname[whichcategory].size(),ran,ans);
            imagehint.setImageResource(listofcategoryimage[whichcategory].get(ans));
//            imagehint.getDrawable().clearColorFilter();
            for(int i=0;i<4;i++){
                button[i].setText(listofcategoryname[whichcategory].get(random.get(i)).split("-")[0]);
            }
            button[ran].setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.M)
                @Override
                public void onClick(View view) {
                    freezebutton(button);
                    button[ran].setBackgroundColor(Color.GREEN);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            reload(bundle);
                        }
                    },1000);
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
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    reload(bundle);
                                }
                            },1000);
                            roundnumber++;
                        }
                    });
            }
        }

        return v;
    }

    public void setFragment(Fragment fragment, boolean set) {
//        for (int i = getActivity().getSupportFragmentManager().getBackStackEntryCount(); i >= 1; i--)
//            getActivity().getSupportFragmentManager().popBackStack();
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        if(roundnumber<10)
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

