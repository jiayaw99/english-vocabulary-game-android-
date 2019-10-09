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
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import static com.example.english.MainActivity.listofcategoryimage;
import static com.example.english.MainActivity.listofcategoryname;
import static com.example.english.MainActivity.listoflevelname;

public class LearnDetailFragment extends Fragment {
    private View v;
private int page=1;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.learn_detail, container, false);

        final Bundle bundle = this.getArguments();
        String keyword = bundle.getString("key");
        final ImageView image=v.findViewById(R.id.learn_image);
        final TextView text=v.findViewById(R.id.learn_text);
        final Button next=v.findViewById(R.id.next);
        final Button previous=v.findViewById(R.id.previous);
        previous.setVisibility(View.INVISIBLE);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(keyword.toUpperCase());
        int whichcategory = 0;
        for(int i=0;i<16;i++){
            if(listofcategoryname[i].get(0).split("-")[1].equals(keyword)){
                whichcategory=i;break;
            }
        }

        image.setImageResource(listofcategoryimage[whichcategory].get(page-1));
        text.setText(listofcategoryname[whichcategory].get(page-1).split("-")[0]);
        final int finalWhichcategory = whichcategory;
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                page++;
                reload(finalWhichcategory,image,text,previous,next);
            }
        });
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                page--;
                reload(finalWhichcategory,image,text,previous,next);
            }
        });


        return v;
    }
    public void reload(int whichcategory,ImageView image,TextView text,Button previous,Button next)
    {
        image.setImageResource(listofcategoryimage[whichcategory].get(page-1));
        text.setText(listofcategoryname[whichcategory].get(page-1).split("-")[0]);
        if(page==1)
            previous.setVisibility(View.INVISIBLE);
        else
            previous.setVisibility(View.VISIBLE);
        if(page==listofcategoryname[whichcategory].size())
            next.setVisibility(View.INVISIBLE);
        else
            next.setVisibility(View.VISIBLE);
    }

}
