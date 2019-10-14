package com.example.english;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class ResultFragment extends Fragment {
    private View v;
    private MediaPlayer mp=new MediaPlayer();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.result, container, false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("RESULT");

        int happy=getResources().getIdentifier("happy_teacher", "drawable", getActivity().getPackageName());
        int good=getResources().getIdentifier("good_teacher", "drawable", getActivity().getPackageName());
        int sad=getResources().getIdentifier("sad_teacher", "drawable", getActivity().getPackageName());
        Bundle bundle = this.getArguments();
        int correctans = bundle.getInt("correct");
        TextView correctnum = v.findViewById(R.id.mark);
        RelativeLayout layout=v.findViewById(R.id.teacher);
        correctnum.setText((correctans*10)+" %");
        if (correctans > 7){
            mp = MediaPlayer.create(getActivity(), R.raw.excellent);
        layout.setBackgroundResource(happy);
        }
        else if (correctans > 4){
            mp = MediaPlayer.create(getActivity(), R.raw.good);
            layout.setBackgroundResource(good);
        }
        else {
            mp = MediaPlayer.create(getActivity(), R.raw.poor);
            layout.setBackgroundResource(sad);
        }
        mp.start();
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.release();
            }
        });


        return v;
    }
}
