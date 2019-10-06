package com.example.english;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolb;
    private Button back;
    private static DrawerLayout drawerLayout;
    private BottomNavigationView bottomNav;
    private HomeFragment home = new HomeFragment();
    private LearnFragment learnF = new LearnFragment();
    private PlayFragment playF = new PlayFragment();
    final static ArrayList<String> listnameofeasy = new ArrayList<>();
    final static ArrayList<String> listnameofmedium = new ArrayList<>();
    final static ArrayList<String> listnameofhard = new ArrayList<>();
    final static ArrayList<Integer> listimageofeasy = new ArrayList<>();
    final static ArrayList<Integer> listimageofmedium = new ArrayList<>();
    final static ArrayList<Integer> listimageofhard = new ArrayList<>();



//    static int currentFragment = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        listimageofeasy.add(getResources().getIdentifier("bat_animal_easy", "drawable", getPackageName()));
        listimageofeasy.add(getResources().getIdentifier("bird_animal_easy", "drawable", getPackageName()));
        listimageofeasy.add(getResources().getIdentifier("chick_animal_easy", "drawable", getPackageName()));
        listimageofeasy.add(getResources().getIdentifier("duck_animal_easy", "drawable", getPackageName()));
        listimageofeasy.add(getResources().getIdentifier("elephant_animal_easy", "drawable", getPackageName()));
        listimageofeasy.add(getResources().getIdentifier("fox_animal_easy", "drawable", getPackageName()));
        listimageofeasy.add(getResources().getIdentifier("hen_animal_easy", "drawable", getPackageName()));
        listimageofeasy.add(getResources().getIdentifier("rat_animal_easy", "drawable", getPackageName()));

        listnameofeasy.add("bat");listnameofeasy.add("bird");listnameofeasy.add("chick");listnameofeasy.add("duck");
        listnameofeasy.add("elephant");listnameofeasy.add("fox");listnameofeasy.add("hen");listnameofeasy.add("rat");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.exit);
        setContentView(R.layout.activity_main);
//        back = findViewById(R.id.back_button);
//        back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                onBackPressed();
//            }
//        });


        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        toolb = findViewById(R.id.toolbar);
        setSupportActionBar(toolb);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Learning ABC");


//        File folder = new File(getPackageResourcePath()+"src\\res");
//        getfiles(folder);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, home).commit();
//

    }

    public void setFragment(Fragment fragment, boolean set) {
//        for (int i = getSupportFragmentManager().getBackStackEntryCount(); i >= 1; i--)
//            getSupportFragmentManager().popBackStack();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @SuppressLint("WrongConstant")
    @Override
    public void onBackPressed() {
        if (home.isVisible()) {
            final AlertDialog.Builder alert = new AlertDialog.Builder(this);
            final AlertDialog dialog = alert.create();
            LayoutInflater factory = LayoutInflater.from(this);
            final View view = factory.inflate(R.layout.exit, null);
//            alert.setTitle("DO YOU WANT TO EXIT ?");
            dialog.setView(view);
//            alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialogInterface, int i) {
//                    finish();
//                    System.exit(0);
//                }
//            });
//            alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialogInterface, int i) {
//                    dialogInterface.dismiss();
//                }
//            });
            dialog.show();
            Button yesbutton = view.findViewById(R.id.yes_button);
            Button nobutton = view.findViewById(R.id.no_button);
            yesbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                    System.exit(0);
                }
            });
            nobutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.cancel();
                }
            });
        } else {
            super.onBackPressed();
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }

    public void getfiles(File folder) {
        File[] files = folder.listFiles();
        for (int i = 0; i < files.length; i++)
            if (files[i].isDirectory())
                getfiles(files[i]);
            else if (files[i].getName().toString().split("_").length == 3) {
                if (files[i].getName().toString().split("_")[2].toLowerCase().contains("easy")) {
                    listimageofeasy.add(54656);
                    listnameofeasy.add(getResources().getResourceEntryName(getResources().getIdentifier(files[i].getName(), "drawable", getPackageName())).split("_")[0]);
                } else if (files[i].getName().toString().split("-")[2].toLowerCase().contains("medium")) {
                    listimageofmedium.add(getResources().getIdentifier(files[i].getName(), "medium", getPackageName()));
                    listnameofmedium.add(files[i].getName().split("-")[0]);
                } else {
                    listimageofhard.add(getResources().getIdentifier(files[i].getName(), "hard", getPackageName()));
                    listnameofhard.add(files[i].getName().split("-")[0]);
                }
            }
    }
}