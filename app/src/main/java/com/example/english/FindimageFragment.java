package com.example.english;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
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
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.Random;

import static com.example.english.MainActivity.listoflevelname;
import static com.example.english.MainActivity.listoflevelimage;
import static com.example.english.MainActivity.listofcategoryimage;
import static com.example.english.MainActivity.listofcategoryname;

public class FindimageFragment extends Fragment {
    private View v;
    private MediaPlayer mp=new MediaPlayer();
    private String[] idofbutton = {"image1", "image2", "image3", "image4"};
    private ArrayList<Integer> random = new ArrayList<>();
    static ArrayList<Integer> answerlist = new ArrayList<>();
    static int roundnumber = 0;
    static int correctans=0;

    @Nullable
    @Override
    //a general image list add all images and add all names
    // if categorylist[k].add namelist.get(i).split[1]  k++  or use templist in a method
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.play_findimage, container, false);

        random.clear();
//        if (roundnumber >= 10)
//            setFragment(new ResultFragment(), true);

        TextView roundtext = v.findViewById(R.id.roundnotext);
        roundtext.setText(roundnumber + 1 + " / " + 10);
        final Bundle bundle = this.getArguments();
        String keyword = bundle.getString("key");

        final ImageButton[] button = new ImageButton[4];

        for (int i = 0; i < 4; i++) {
            button[i] = v.findViewById(getResources().getIdentifier(idofbutton[i], "id", getActivity().getPackageName()));
        }

        TextView texthint = v.findViewById(R.id.texthint);
        if (keyword.equals("easy")||keyword.equals("medium")||keyword.equals("hard")) {
            int whichcategory = 0;
            for(int i=0;i<3;i++){
                if(listoflevelname[i].get(0).split("-")[2].equals(keyword)){
                    whichcategory=i;break;
                }
            }
            final int ran = new Random().nextInt(4);
            int ans = new Random().nextInt(listoflevelname[whichcategory].size());
            while (answerlist.contains(ans)) {
                ans = new Random().nextInt(listoflevelname[whichcategory].size());
                if (!answerlist.contains(ans)) {
                    answerlist.add(ans);
                    break;
                }
            }
            if (!answerlist.contains(ans))
                answerlist.add(ans);
            setrandomnumber(listoflevelname[whichcategory].size(), ran, ans);
            texthint.setText(listoflevelname[whichcategory].get(ans).split("-")[0]);
            for (int i = 0; i < 4; i++) {
                button[i].setBackgroundResource(listoflevelimage[whichcategory].get(random.get(i)));
            }
            button[ran].setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.M)
                @Override
                public void onClick(View view) {
                    freezebutton(button);
                    mp = MediaPlayer.create(getActivity(),R.raw.correct_sound);
                    mp.start();
                    release(mp);
                    correctans++;
                    button[ran].getBackground().setColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY);
                    button[ran].setImageResource(R.drawable.correct);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            reload(bundle,button);
                        }
                    },1000);
                    roundnumber++;
                }
            });
            for (int i = 0; i < 4; i++) {
                final int finalI = i;
                if (i != ran)
                    button[i].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            freezebutton(button);
                            mp = MediaPlayer.create(getActivity(),R.raw.wrong_sound);
                            mp.start();
                            release(mp);
                            button[finalI].setImageResource(R.drawable.wrong);
                            button[finalI].getBackground().setColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY);
                            button[ran].setImageResource(R.drawable.correct);
                            button[ran].getBackground().setColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY);
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    reload(bundle,button);
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
            final int ran = new Random().nextInt(4);
            int ans = new Random().nextInt(listofcategoryname[whichcategory].size());
            while (answerlist.contains(ans)) {
                ans = new Random().nextInt(listofcategoryname[whichcategory].size());
                if (!answerlist.contains(ans)) {
                    answerlist.add(ans);
                    break;
                }
            }
            if (!answerlist.contains(ans))
                answerlist.add(ans);
            setrandomnumber(listofcategoryname[whichcategory].size(), ran, ans);
            texthint.setText(listofcategoryname[whichcategory].get(ans).split("-")[0]);
            for (int i = 0; i < 4; i++) {
                button[i].setBackgroundResource(listofcategoryimage[whichcategory].get(random.get(i)));
//                button[i].getBackground().clearColorFilter();
            }
            button[ran].setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.M)
                @Override
                public void onClick(View view) {
                    freezebutton(button);
                    mp = MediaPlayer.create(getActivity(),R.raw.correct_sound);
                    mp.start();
                    release(mp);
                    correctans++;
                    button[ran].getBackground().setColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY);
                    button[ran].setImageResource(R.drawable.correct);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            reload(bundle,button);
                        }
                    },1000);
                    roundnumber++;
                }
            });
            for (int i = 0; i < 4; i++) {
                final int finalI = i;
                if (i != ran)
                    button[i].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            freezebutton(button);
                            mp = MediaPlayer.create(getActivity(),R.raw.wrong_sound);
                            mp.start();
                            release(mp);
                            button[finalI].setImageResource(R.drawable.wrong);
                            button[finalI].getBackground().setColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY);
                            button[ran].setImageResource(R.drawable.correct);
                            button[ran].getBackground().setColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY);
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    reload(bundle,button);
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
            fragmentTransaction.replace(R.id.findimageincrease, fragment);
//            fragmentTransaction.replace(R.id.fragment_container, fragment);
//        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void reload(Bundle bundle,ImageButton[] button) {
        if(roundnumber>9){
            bundle.putInt("correct", correctans);
            ResultFragment rf=new ResultFragment();
            rf.setArguments(bundle);
            setFragment(rf, true);
        }
        else{
        FindimageFragment newone = new FindimageFragment();
        setFragment(newone, true);
        newone.setArguments(bundle);}
        clearbutton(button);
    }

    public void setrandomnumber(int listsize, int notthislocation, int answer) {
        for (int i = 0; i < 4; i++) {
            int temp = new Random().nextInt(listsize);
            if (i != notthislocation && temp != answer) {
                if (random.contains(temp)) {
                    i--;
                } else {
                    random.add(temp);
                }
            } else if (i == notthislocation)
                random.add(answer);
            else
                i--;
        }
    }

    public void freezebutton(ImageButton[] button) {
        for (int i = 0; i < button.length; i++) {
            button[i].setClickable(false);
        }
    }
    public void clearbutton(ImageButton[] button) {
        for (int i = 0; i < button.length; i++) {
            button[i].getBackground().clearColorFilter();
        }
    }
    public void release(MediaPlayer mp){
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.release();
            }
        });
    }
}
