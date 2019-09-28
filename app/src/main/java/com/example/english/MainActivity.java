package com.example.english;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.ActionBarDrawerToggle;
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
    private DrawerLayout drawerLayout;
    private BottomNavigationView bottomNav;
    private HomeFragment home = new HomeFragment();
    private LearnFragment learnF= new LearnFragment();
    private PlayFragment playF=new PlayFragment();
    final static ArrayList<String> listnameofeasy=new ArrayList<>();
    final static ArrayList<String> listnameofmedium=new ArrayList<>();
    final static ArrayList<String> listnameofhard=new ArrayList<>();
    final static ArrayList<File> listimageofeasy=new ArrayList<>();
    final static ArrayList<File> listimageofmedium=new ArrayList<>();
    final static ArrayList<File> listimageofhard=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.fragment_home);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, home).commit();

        File folder=new File(getPackageResourcePath()+"\\app\\src\\main\\res\\drawable");
        File [] files=folder.listFiles();
        if(files!=null)
        for(int i=0;i<files.length;i++)
            if(files[i].getName().toString().split("-").length==3) {
                if(files[i].getName().toString().split("-")[2].toLowerCase().equals("easy")){
                listimageofeasy.add(files[i]);
                listnameofeasy.add(files[i].getName());}
                else if(files[i].getName().toString().split("-")[2].toLowerCase().equals("medium")){
                    listimageofmedium.add(files[i]);
                    listnameofmedium.add(files[i].getName());}
                else{
                    listimageofhard.add(files[i]);
                    listnameofhard.add(files[i].getName());
                }
            }
        Button learn=(Button)findViewById(R.id.learn_button);
        Button play=(Button)findViewById(R.id.play_button);

        learn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            setFragment(new LearnFragment(),true);
            }
        });

        toolb = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolb);
        //getSupportActionBar().setTitle(null);

        drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolb, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


//        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
//        ViewPager viewPager = findViewById(R.id.view_pager);
//        viewPager.setAdapter(sectionsPagerAdapter);
//        TabLayout tabs = findViewById(R.id.tabs);
//        tabs.setupWithViewPager(viewPager);
//        FloatingActionButton fab = findViewById(R.id.fab);
//
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

    }

    public void setFragment(Fragment fragment, boolean set){
        for (int i = getSupportFragmentManager().getBackStackEntryCount(); i >= 1; i--)
            getSupportFragmentManager().popBackStack();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }
}