package com.deep.fitnessapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.deep.fitnessapp.HomeScreenFragments.AccountFragment;
import com.deep.fitnessapp.HomeScreenFragments.DietFragment;
import com.deep.fitnessapp.HomeScreenFragments.ExerciseFragment;
import com.deep.fitnessapp.HomeScreenFragments.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.internal.NavigationMenu;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navBar = findViewById(R.id.homePageNavBar);

        //setting view defaults
        navBar.setSelectedItemId(R.id.home);
        getSupportFragmentManager().beginTransaction().add(R.id.homePageFrameLayout,new HomeFragment()).commit();

        //setting onClick view Functions
        navBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFrag = new HomeFragment();
                switch (item.getItemId()){
                    case R.id.home:
                        selectedFrag = new HomeFragment();
                        break;
                    case R.id.exercise:
                        selectedFrag = new ExerciseFragment();
                        break;
                    case R.id.diet:
                        selectedFrag = new DietFragment();
                        break;
                    case R.id.account:
                        selectedFrag = new AccountFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().add(R.id.homePageFrameLayout,selectedFrag).commit();
                getSupportFragmentManager().beginTransaction().replace(R.id.homePageFrameLayout,selectedFrag).commit();
                return true;
            }
        });
    }
}