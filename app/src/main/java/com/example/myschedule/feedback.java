package com.example.myschedule;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class feedback extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        BottomNavigationView bottomnav;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
//
        bottomnav = findViewById(R.id.bottomnav);

        bottomnav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()== R.id.home){

                }
                else if(item.getItemId()==R.id.chat){

                }
                else if(item.getItemId()==R.id.group){

                }
                else if(item.getItemId()==R.id.person){

                }
                return true;
            }
        });

    }
    public void repalceFrg(Fragment frg){
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.frmnav,frg).commit();
    }

}