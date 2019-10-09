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
    final static ArrayList<String> generalnamelist = new ArrayList<>();
    final static ArrayList<Integer> generalimagelist = new ArrayList<>();
    final static ArrayList<Integer>[] listofcategoryimage = new ArrayList[16];
    final static ArrayList<String>[] listofcategoryname = new ArrayList[16];
    final static ArrayList<String> []listoflevelname = new ArrayList[3];
    final static ArrayList<Integer> []listoflevelimage = new ArrayList[3];


//    static int currentFragment = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        for(int i=0;i<16;i++)
        {
            if(i<3)
            {
                listoflevelimage[i]=new ArrayList<>();
                listoflevelname[i]=new ArrayList<>();
            }
            listofcategoryname[i]=new ArrayList();
            listofcategoryimage[i]=new ArrayList();
        }

        generalimagelist.add(getResources().getIdentifier("absorb_action_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("accuse_action_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("argue_action_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("arrive_action_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("blast_action_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("bounce_action_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("cheer_action_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("chew_action_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("claw_action_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("coast_action_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("collect_action_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("compare_action_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("connect_action_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("construct_action_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("crumple_action_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("develop_action_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("discard_action_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("dive_action_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("doubt_action_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("drift_action_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("examine_action_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("flap_action_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("float_action_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("gasp_action_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("harm_action_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("herd_action_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("infer_action_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("invent_action_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("leap_action_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("mend_action_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("observe_action_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("parade_action_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("peek_action_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("perform_action_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("play_football_action_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("prank_action_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("pull_action_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("race_action_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("reflect_action_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("revive_action_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("run_action_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("search_action_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("share_action_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("shatter_action_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("shiver_action_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("sit_action_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("travel_action_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("tremble_action_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("walk_up_action_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("whisper_action_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("bright_adjective_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("center_adjective_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("clear_adjective_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("curious_adjective_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("damp_adjective_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("dangerous_adjective_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("fresh_adjective_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("smelly_adjective_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("tiny_adjective_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("weak_adjective_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("wealthy_adjective_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("bat_animal_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("bird_animal_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("calf_animal_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("cat_animal_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("chick_animal_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("dog_animal_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("duck_animal_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("elephant_animal_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("fish_animal_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("fox_animal_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("goldfish_animal_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("hen_animal_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("insect_animal_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("lizard_animal_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("parrot_animal_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("rabbit_animal_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("rat_animal_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("seal_animal_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("brave_character_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("brilliant_character_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("careless_character_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("coward_character_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("elegant_character_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("endangered_character_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("flexible_character_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("generous_character_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("greedy_character_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("intelligent_character_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("nervous_character_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("opposite_character_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("respectful_character_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("responsible_character_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("secretive_character_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("sinister_character_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("afraid_feeling_emotion_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("annoyed_feeling_emotion_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("anxious_feeling_emotion_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("bored_feeling_emotion_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("calm_feeling_emotion_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("confused_feeling_emotion_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("curious_feeling_emotion_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("depressive_feeling_emotion_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("disappointed_feeling_emotion_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("eager_feeling_emotion_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("ecstatic_feeling_emotion_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("embarresed_feeling_emotion_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("exhausted_feeling_emotion_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("frighten_feeling_emotion_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("grumpy_feeling_emotion_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("guilty_feeling_emotion_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("happy_feeling_emotion_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("jealous_feeling_emotion_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("lonely_feeling_emotion_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("lonely_feeling_emotion_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("loving_feeling_emotion_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("nervous_feeling_emotion_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("pleasant_feeling_emotion_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("proud_feeling_emotion_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("sad_feeling_emotion_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("silly_feeling_emotion_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("surprised_feeling_emotion_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("tired_feeling_emotion_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("worried_feeling_emotion_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("apple_food_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("bun_food_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("butter_food_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("carrot_food_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("fruits_food_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("meat_food_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("muffin_food_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("pie_food_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("pizza_food_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("soup_food_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("ant_garden_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("axe_garden_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("bees_garden_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("bud_garden_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("butterfly_garden_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("hibiscus_garden_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("ladybird_garden_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("leaf_garden_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("petal_garden_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("rock_garden_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("roses_garden_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("snail_garden_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("stem_garden_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("stick_garden_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("sunflowers_garden_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("watering_can_garden_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("web_garden_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("worm_garden_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("acute_angles_math_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("balance_math_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("compare_math_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("decagon_math_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("decimal_math_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("division_math_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("dozen_math_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("five_math_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("fraction_math_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("hexagon_math_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("multiply_math_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("nonagon_math_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("obtuse_angle_math_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("octagon_math_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("pentagon_math_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("quadrilateral_math_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("quarter_math_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("right_angle_math_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("stack_math_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("astronomy_object_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("award_object_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("banner_object_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("board_object_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("branch_object_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("cage_object_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("clock_object_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("cup_object_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("earth_object_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("gavel_object_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("gift_object_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("hat_object_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("instrument_object_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("invitation_card_object_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("luxury_object_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("motor_object_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("mug_object_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("net_object_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("notice_object_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("oil_tank_object_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("pan_object_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("pellets_object_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("planet_object_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("rack_object_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("socks_object_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("soil_object_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("telescope_object_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("army_people_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("baby_people_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("boy_people_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("brain_people_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("bride_people_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("bridegroom_people_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("chemist_people_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("civil_engineer_people_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("couple_people_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("dentist_people_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("doctor_people_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("enemy_people_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("girl_people_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("judge_people_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("lawyer_people_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("leader_people_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("marine_people_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("patient_people_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("pharmacist_people_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("scholar_people_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("surgeon_people_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("team_people_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("uncle_people_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("beach_place_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("cliff_place_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("factory_place_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("fair_place_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("farm_place_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("field_place_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("hill_place_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("island_place_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("mountain_place_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("ocean_place_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("passage_place_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("school_place_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("shelter_place_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("stream_place_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("tower_place_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("universe_place_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("village_place_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("yard_place_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("art_room_school_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("canteen_school_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("classroom_school_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("computer_lab_school_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("field_school_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("garden_school_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("library_school_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("office_school_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("school_hall_school_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("school_shop_school_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("toilet_school_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("cheep____cheep_sound_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("chirp____chirp_sound_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("dub____dub_sound_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("kring____kring_sound_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("oo____oo_sound_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("rr____rr_sound_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("shh____sound_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("ss____ss_sound_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("vroom____vroom_sound_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("waa_waa__sound_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("wow_sound_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("zz____zz_sound_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("bidet_toiletries_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("conditioner_toiletries_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("electric_razor_toiletries_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("facial_wash_toiletries_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("floss_toiletries_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("loofah_toiletries_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("mouthwash_toiletries_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("shampoo_toiletries_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("shower_curtain_toiletries_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("shower_gel_toiletries_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("soap_toiletries_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("toothbrush_toiletries_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("toothpaste_toiletries_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("towel_rack_toiletries_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("allen_key_set_tools_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("batteries_tools_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("bike_pump_tools_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("bulldog_clip_tools_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("headphones_tools_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("nail_clipper_tools_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("paper_tools_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("pencil_tools_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("power_board_tools_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("remote_control_tools_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("screwdriver_set_tools_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("travel_adapter_tools_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("wrapping_paper_tools_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("accident_other_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("attention_other_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("birdcage_other_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("bus_other_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("climate_other_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("crowd_other_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("dawn_other_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("doghouse_other_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("evening_other_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("feast_other_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("fishbowl_other_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("flood_other_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("gap_other_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("good_afternoon_other_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("good_evening_other_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("good_morning_other_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("good_night_other_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("goodbye_other_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("gravity_other_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("hello_other_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("hemisphere_other_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("hi_other_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("idea_other_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("left_other_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("march_other_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("moon_other_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("rain_other_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("rattan_basket_other_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("right_other_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("scar_other_hard", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("shine_other_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("skill_other_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("snowy_other_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("sun_other_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("sunny_other_medium", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("truck_other_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("under_other_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("up_other_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("wind_other_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("windy_other_easy", "drawable", getPackageName()));
        generalimagelist.add(getResources().getIdentifier("zig_zag_other_medium", "drawable", getPackageName()));


        generalnamelist.add("absorb-action-hard");
        generalnamelist.add("accuse-action-hard");
        generalnamelist.add("argue-action-hard");
        generalnamelist.add("arrive-action-medium");
        generalnamelist.add("blast-action-medium");
        generalnamelist.add("bounce-action-medium");
        generalnamelist.add("cheer-action-medium");
        generalnamelist.add("chew-action-medium");
        generalnamelist.add("claw-action-medium");
        generalnamelist.add("coast-action-hard");
        generalnamelist.add("collect-action-medium");
        generalnamelist.add("compare-action-hard");
        generalnamelist.add("connect-action-medium");
        generalnamelist.add("construct-action-hard");
        generalnamelist.add("crumple-action-hard");
        generalnamelist.add("develop-action-hard");
        generalnamelist.add("discard-action-medium");
        generalnamelist.add("dive-action-medium");
        generalnamelist.add("doubt-action-medium");
        generalnamelist.add("drift-action-hard");
        generalnamelist.add("examine-action-hard");
        generalnamelist.add("flap-action-medium");
        generalnamelist.add("float-action-medium");
        generalnamelist.add("gasp-action-hard");
        generalnamelist.add("harm-action-medium");
        generalnamelist.add("herd-action-medium");
        generalnamelist.add("infer-action-hard");
        generalnamelist.add("invent-action-medium");
        generalnamelist.add("leap-action-medium");
        generalnamelist.add("mend-action-hard");
        generalnamelist.add("observe-action-hard");
        generalnamelist.add("parade-action-medium");
        generalnamelist.add("peek-action-hard");
        generalnamelist.add("perform-action-hard");
        generalnamelist.add("play football-action-easy");
        generalnamelist.add("prank-action-hard");
        generalnamelist.add("pull-action-easy");
        generalnamelist.add("race-action-easy");
        generalnamelist.add("reflect-action-medium");
        generalnamelist.add("revive-action-hard");
        generalnamelist.add("run-action-easy");
        generalnamelist.add("search-action-medium");
        generalnamelist.add("share-action-medium");
        generalnamelist.add("shatter-action-hard");
        generalnamelist.add("shiver-action-medium");
        generalnamelist.add("sit-action-easy");
        generalnamelist.add("travel-action-medium");
        generalnamelist.add("tremble-action-medium");
        generalnamelist.add("walk up-action-easy");
        generalnamelist.add("whisper-action-medium");
        generalnamelist.add("bright-adjective-medium");
        generalnamelist.add("center-adjective-medium");
        generalnamelist.add("clear-adjective-medium");
        generalnamelist.add("curious-adjective-medium");
        generalnamelist.add("damp-adjective-medium");
        generalnamelist.add("dangerous-adjective-medium");
        generalnamelist.add("fresh-adjective-medium");
        generalnamelist.add("smelly-adjective-easy");
        generalnamelist.add("tiny-adjective-medium");
        generalnamelist.add("weak-adjective-medium");
        generalnamelist.add("wealthy-adjective-medium");
        generalnamelist.add("bat-animal-easy");
        generalnamelist.add("bird-animal-easy");
        generalnamelist.add("calf-animal-medium");
        generalnamelist.add("cat-animal-easy");
        generalnamelist.add("chick-animal-easy");
        generalnamelist.add("dog-animal-easy");
        generalnamelist.add("duck-animal-easy");
        generalnamelist.add("elephant-animal-easy");
        generalnamelist.add("fish-animal-easy");
        generalnamelist.add("fox-animal-easy");
        generalnamelist.add("goldfish-animal-easy");
        generalnamelist.add("hen-animal-easy");
        generalnamelist.add("insect-animal-medium");
        generalnamelist.add("lizard-animal-medium");
        generalnamelist.add("parrot-animal-easy");
        generalnamelist.add("rabbit-animal-easy");
        generalnamelist.add("rat-animal-easy");
        generalnamelist.add("seal-animal-medium");
        generalnamelist.add("brave-character-medium");
        generalnamelist.add("brilliant-character-hard");
        generalnamelist.add("careless-character-hard");
        generalnamelist.add("coward-character-hard");
        generalnamelist.add("elegant-character-hard");
        generalnamelist.add("endangered-character-hard");
        generalnamelist.add("flexible-character-hard");
        generalnamelist.add("generous-character-hard");
        generalnamelist.add("greedy-character-medium");
        generalnamelist.add("intelligent-character-hard");
        generalnamelist.add("nervous-character-medium");
        generalnamelist.add("opposite-character-hard");
        generalnamelist.add("respectful-character-hard");
        generalnamelist.add("responsible-character-hard");
        generalnamelist.add("secretive-character-hard");
        generalnamelist.add("sinister-character-hard");
        generalnamelist.add("afraid-feeling&emotion-hard");
        generalnamelist.add("annoyed-feeling&emotion-hard");
        generalnamelist.add("anxious-feeling&emotion-hard");
        generalnamelist.add("bored-feeling&emotion-hard");
        generalnamelist.add("calm-feeling&emotion-medium");
        generalnamelist.add("confused-feeling&emotion-hard");
        generalnamelist.add("curious-feeling&emotion-hard");
        generalnamelist.add("depressive-feeling&emotion-hard");
        generalnamelist.add("disappointed-feeling&emotion-hard");
        generalnamelist.add("eager-feeling&emotion-hard");
        generalnamelist.add("ecstatic-feeling&emotion-hard");
        generalnamelist.add("embarresed-feeling&emotion-hard");
        generalnamelist.add("exhausted-feeling&emotion-hard");
        generalnamelist.add("frighten-feeling&emotion-medium");
        generalnamelist.add("grumpy-feeling&emotion-hard");
        generalnamelist.add("guilty-feeling&emotion-hard");
        generalnamelist.add("happy-feeling&emotion-easy");
        generalnamelist.add("jealous-feeling&emotion-hard");
        generalnamelist.add("lonely-feeling&emotion-hard");
        generalnamelist.add("lonely-feeling&emotion-medium");
        generalnamelist.add("loving-feeling&emotion-hard");
        generalnamelist.add("nervous-feeling&emotion-hard");
        generalnamelist.add("pleasant-feeling&emotion-hard");
        generalnamelist.add("proud-feeling&emotion-hard");
        generalnamelist.add("sad-feeling&emotion-easy");
        generalnamelist.add("silly-feeling&emotion-hard");
        generalnamelist.add("surprised-feeling&emotion-hard");
        generalnamelist.add("tired-feeling&emotion-hard");
        generalnamelist.add("worried-feeling&emotion-hard");
        generalnamelist.add("apple-food-easy");
        generalnamelist.add("bun-food-easy");
        generalnamelist.add("butter-food-easy");
        generalnamelist.add("carrot-food-easy");
        generalnamelist.add("fruits-food-easy");
        generalnamelist.add("meat-food-easy");
        generalnamelist.add("muffin-food-easy");
        generalnamelist.add("pie-food-easy");
        generalnamelist.add("pizza-food-easy");
        generalnamelist.add("soup-food-easy");
        generalnamelist.add("ant-garden-easy");
        generalnamelist.add("axe-garden-easy");
        generalnamelist.add("bees-garden-easy");
        generalnamelist.add("bud-garden-easy");
        generalnamelist.add("butterfly-garden-easy");
        generalnamelist.add("hibiscus-garden-easy");
        generalnamelist.add("ladybird-garden-easy");
        generalnamelist.add("leaf-garden-easy");
        generalnamelist.add("petal-garden-easy");
        generalnamelist.add("rock-garden-easy");
        generalnamelist.add("roses-garden-easy");
        generalnamelist.add("snail-garden-easy");
        generalnamelist.add("stem-garden-easy");
        generalnamelist.add("stick-garden-easy");
        generalnamelist.add("sunflowers-garden-easy");
        generalnamelist.add("watering can-garden-easy");
        generalnamelist.add("web-garden-easy");
        generalnamelist.add("worm-garden-easy");
        generalnamelist.add("acute angles-math-hard");
        generalnamelist.add("balance-math-medium");
        generalnamelist.add("compare-math-hard");
        generalnamelist.add("decagon-math-hard");
        generalnamelist.add("decimal-math-hard");
        generalnamelist.add("division-math-hard");
        generalnamelist.add("dozen-math-medium");
        generalnamelist.add("five-math-easy");
        generalnamelist.add("fraction-math-hard");
        generalnamelist.add("hexagon-math-hard");
        generalnamelist.add("multiply-math-hard");
        generalnamelist.add("nonagon-math-hard");
        generalnamelist.add("obtuse angle-math-hard");
        generalnamelist.add("octagon-math-hard");
        generalnamelist.add("pentagon-math-hard");
        generalnamelist.add("quadrilateral-math-hard");
        generalnamelist.add("quarter-math-hard");
        generalnamelist.add("right angle-math-hard");
        generalnamelist.add("stack-math-medium");
        generalnamelist.add("astronomy-object-medium");
        generalnamelist.add("award-object-medium");
        generalnamelist.add("banner-object-medium");
        generalnamelist.add("board-object-medium");
        generalnamelist.add("branch-object-medium");
        generalnamelist.add("cage-object-medium");
        generalnamelist.add("clock-object-easy");
        generalnamelist.add("cup-object-easy");
        generalnamelist.add("earth-object-medium");
        generalnamelist.add("gavel-object-hard");
        generalnamelist.add("gift-object-medium");
        generalnamelist.add("hat-object-easy");
        generalnamelist.add("instrument-object-medium");
        generalnamelist.add("invitation card-object-medium");
        generalnamelist.add("luxury-object-medium");
        generalnamelist.add("motor-object-medium");
        generalnamelist.add("mug-object-easy");
        generalnamelist.add("net-object-medium");
        generalnamelist.add("notice-object-medium");
        generalnamelist.add("oil tank-object-medium");
        generalnamelist.add("pan-object-easy");
        generalnamelist.add("pellets-object-easy");
        generalnamelist.add("planet-object-medium");
        generalnamelist.add("rack-object-easy");
        generalnamelist.add("socks-object-easy");
        generalnamelist.add("soil-object-medium");
        generalnamelist.add("telescope-object-medium");
        generalnamelist.add("army-people-hard");
        generalnamelist.add("baby-people-easy");
        generalnamelist.add("boy-people-easy");
        generalnamelist.add("brain-people-medium");
        generalnamelist.add("bride-people-hard");
        generalnamelist.add("bridegroom-people-hard");
        generalnamelist.add("chemist-people-hard");
        generalnamelist.add("civil engineer-people-hard");
        generalnamelist.add("couple-people-medium");
        generalnamelist.add("dentist-people-hard");
        generalnamelist.add("doctor-people-hard");
        generalnamelist.add("enemy-people-medium");
        generalnamelist.add("girl-people-easy");
        generalnamelist.add("judge-people-hard");
        generalnamelist.add("lawyer-people-hard");
        generalnamelist.add("leader-people-medium");
        generalnamelist.add("marine-people-hard");
        generalnamelist.add("patient-people-hard");
        generalnamelist.add("pharmacist-people-hard");
        generalnamelist.add("scholar-people-medium");
        generalnamelist.add("surgeon-people-hard");
        generalnamelist.add("team-people-medium");
        generalnamelist.add("uncle-people-easy");
        generalnamelist.add("beach-place-medium");
        generalnamelist.add("cliff-place-medium");
        generalnamelist.add("factory-place-medium");
        generalnamelist.add("fair-place-medium");
        generalnamelist.add("farm-place-medium");
        generalnamelist.add("field-place-medium");
        generalnamelist.add("hill-place-easy");
        generalnamelist.add("island-place-medium");
        generalnamelist.add("mountain-place-medium");
        generalnamelist.add("ocean-place-medium");
        generalnamelist.add("passage-place-hard");
        generalnamelist.add("school-place-easy");
        generalnamelist.add("shelter-place-medium");
        generalnamelist.add("stream-place-medium");
        generalnamelist.add("tower-place-medium");
        generalnamelist.add("universe-place-hard");
        generalnamelist.add("village-place-medium");
        generalnamelist.add("yard-place-medium");
        generalnamelist.add("art room-school-easy");
        generalnamelist.add("canteen-school-easy");
        generalnamelist.add("classroom-school-easy");
        generalnamelist.add("computer lab-school-easy");
        generalnamelist.add("field-school-easy");
        generalnamelist.add("garden-school-easy");
        generalnamelist.add("library-school-easy");
        generalnamelist.add("office-school-easy");
        generalnamelist.add("school hall-school-easy");
        generalnamelist.add("school shop-school-easy");
        generalnamelist.add("toilet-school-easy");
        generalnamelist.add("cheep... cheep-sound-easy");
        generalnamelist.add("chirp... chirp-sound-easy");
        generalnamelist.add("dub... dub-sound-easy");
        generalnamelist.add("kring... kring-sound-easy");
        generalnamelist.add("oo... oo-sound-easy");
        generalnamelist.add("rr... rr-sound-easy");
        generalnamelist.add("shh...-sound-easy");
        generalnamelist.add("ss... ss-sound-easy");
        generalnamelist.add("vroom... vroom-sound-easy");
        generalnamelist.add("waa!waa!-sound-easy");
        generalnamelist.add("wow-sound-easy");
        generalnamelist.add("zz... zz-sound-easy");
        generalnamelist.add("bidet-toiletries-hard");
        generalnamelist.add("conditioner-toiletries-hard");
        generalnamelist.add("electric razor-toiletries-hard");
        generalnamelist.add("facial wash-toiletries-hard");
        generalnamelist.add("floss-toiletries-hard");
        generalnamelist.add("loofah-toiletries-hard");
        generalnamelist.add("mouthwash-toiletries-hard");
        generalnamelist.add("shampoo-toiletries-easy");
        generalnamelist.add("shower curtain-toiletries-hard");
        generalnamelist.add("shower gel-toiletries-hard");
        generalnamelist.add("soap-toiletries-easy");
        generalnamelist.add("toothbrush-toiletries-easy");
        generalnamelist.add("toothpaste-toiletries-easy");
        generalnamelist.add("towel rack-toiletries-hard");
        generalnamelist.add("allen key set-tools-hard");
        generalnamelist.add("batteries-tools-hard");
        generalnamelist.add("bike pump-tools-hard");
        generalnamelist.add("bulldog clip-tools-hard");
        generalnamelist.add("headphones-tools-hard");
        generalnamelist.add("nail clipper-tools-hard");
        generalnamelist.add("paper-tools-easy");
        generalnamelist.add("pencil-tools-easy");
        generalnamelist.add("power board-tools-hard");
        generalnamelist.add("remote control-tools-hard");
        generalnamelist.add("screwdriver set-tools-hard");
        generalnamelist.add("travel adapter-tools-hard");
        generalnamelist.add("wrapping paper-tools-hard");
        generalnamelist.add("accident-other-medium");
        generalnamelist.add("attention-other-medium");
        generalnamelist.add("birdcage-other-easy");
        generalnamelist.add("bus-other-easy");
        generalnamelist.add("climate-other-medium");
        generalnamelist.add("crowd-other-medium");
        generalnamelist.add("dawn-other-hard");
        generalnamelist.add("doghouse-other-easy");
        generalnamelist.add("evening-other-medium");
        generalnamelist.add("feast-other-medium");
        generalnamelist.add("fishbowl-other-easy");
        generalnamelist.add("flood-other-medium");
        generalnamelist.add("gap-other-medium");
        generalnamelist.add("good afternoon-other-easy");
        generalnamelist.add("good evening-other-easy");
        generalnamelist.add("good morning-other-easy");
        generalnamelist.add("good night-other-easy");
        generalnamelist.add("goodbye-other-easy");
        generalnamelist.add("gravity-other-medium");
        generalnamelist.add("hello-other-easy");
        generalnamelist.add("hemisphere-other-hard");
        generalnamelist.add("hi-other-easy");
        generalnamelist.add("idea-other-medium");
        generalnamelist.add("left-other-easy");
        generalnamelist.add("march-other-medium");
        generalnamelist.add("moon-other-easy");
        generalnamelist.add("rain-other-easy");
        generalnamelist.add("rattan basket-other-easy");
        generalnamelist.add("right-other-easy");
        generalnamelist.add("scar-other-hard");
        generalnamelist.add("shine-other-medium");
        generalnamelist.add("skill-other-medium");
        generalnamelist.add("snowy-other-easy");
        generalnamelist.add("sun-other-easy");
        generalnamelist.add("sunny-other-medium");
        generalnamelist.add("truck-other-easy");
        generalnamelist.add("under-other-easy");
        generalnamelist.add("up-other-easy");
        generalnamelist.add("wind-other-easy");
        generalnamelist.add("windy-other-easy");
        generalnamelist.add("zig zag-other-medium");

        for (int k = 0; k < 16; k++) {
            for (int i = 0; i < generalnamelist.size(); i++) {
                if(listofcategoryimage[k].size()==0){
                    Boolean canadd=true;
                    for(int p=0;p<k;p++){
                    if(listofcategoryname[p].get(0).toString().contains(generalnamelist.get(i).split("-")[1])){
                        canadd=false;break;}
                    }
                    if(canadd){
                    listofcategoryname[k].add(generalnamelist.get(i));
                    listofcategoryimage[k].add(generalimagelist.get(i));}
                }
                else if(listofcategoryname[k].get(0).toString().contains(generalnamelist.get(i).split("-")[1])){
                 listofcategoryname[k].add(generalnamelist.get(i));
                    listofcategoryimage[k].add(generalimagelist.get(i));
                }

            }
        }
//                listimageofeasy.add(getResources().getIdentifier("bat_animal_easy", "drawable", getPackageName()));
//        listimageofeasy.add(getResources().getIdentifier("bird_animal_easy", "drawable", getPackageName()));
//        listimageofeasy.add(getResources().getIdentifier("chick_animal_easy", "drawable", getPackageName()));
//        listimageofeasy.add(getResources().getIdentifier("duck_animal_easy", "drawable", getPackageName()));
//        listimageofeasy.add(getResources().getIdentifier("elephant_animal_easy", "drawable", getPackageName()));
//        listimageofeasy.add(getResources().getIdentifier("fox_animal_easy", "drawable", getPackageName()));
//        listimageofeasy.add(getResources().getIdentifier("hen_animal_easy", "drawable", getPackageName()));
//        listimageofeasy.add(getResources().getIdentifier("rat_animal_easy", "drawable", getPackageName()));
//
//        listnameofeasy.add("bat");listnameofeasy.add("bird");listnameofeasy.add("chick");listnameofeasy.add("duck");
//        listnameofeasy.add("elephant");listnameofeasy.add("fox");listnameofeasy.add("hen");listnameofeasy.add("rat");

        for(int i=0;i<generalnamelist.size();i++){
            if(generalnamelist.get(i).split("-")[2].equals("easy")){
                listoflevelname[0].add(generalnamelist.get(i));
                listoflevelimage[0].add(generalimagelist.get(i));
            }else if(generalnamelist.get(i).split("-")[2].equals("medium")){
                listoflevelname[1].add(generalnamelist.get(i));
                listoflevelimage[1].add(generalimagelist.get(i));
            }else{
                listoflevelname[2].add(generalnamelist.get(i));
                listoflevelimage[2].add(generalimagelist.get(i));
            }
        }

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

//    public void getfiles(File folder) {
//        File[] files = folder.listFiles();
//        for (int i = 0; i < files.length; i++)
//            if (files[i].isDirectory())
//                getfiles(files[i]);
//            else if (files[i].getName().toString().split("_").length == 3) {
//                if (files[i].getName().toString().split("_")[2].toLowerCase().contains("easy")) {
//                    listimageofeasy.add(54656);
//                    listnameofeasy.add(getResources().getResourceEntryName(getResources().getIdentifier(files[i].getName(), "drawable", getPackageName())).split("_")[0]);
//                } else if (files[i].getName().toString().split("-")[2].toLowerCase().contains("medium")) {
//                    listimageofmedium.add(getResources().getIdentifier(files[i].getName(), "medium", getPackageName()));
//                    listnameofmedium.add(files[i].getName().split("-")[0]);
//                } else {
//                    listimageofhard.add(getResources().getIdentifier(files[i].getName(), "hard", getPackageName()));
//                    listnameofhard.add(files[i].getName().split("-")[0]);
//                }
//            }
//   }
}