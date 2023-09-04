package com.example.myschedule;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.myschedule.fragment.Fragmenthome;
import com.example.myschedule.fragment.fragmentmotivation;
import com.example.myschedule.fragment.frgLichThang;
import com.example.myschedule.fragment.frgPersent;
import com.example.myschedule.fragment.frgSetting;
import com.example.myschedule.fragment.frggroup3;
import com.example.myschedule.fragment.frmLichNgay;
import com.example.myschedule.fragment.frmLichTuan;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class feedback extends AppCompatActivity {
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        BottomNavigationView bottomnav;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        bottomnav = findViewById(R.id.bottomnav);
        toolbar = findViewById(R.id.toolbar);
        nav = findViewById(R.id.nav);
        drawerLayout = findViewById(R.id.drawerlayout); // Khởi tạo đối tượng drawerLayout

        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        nav.setItemIconTintList(null);
        setTitle("Lịch");

        bottomnav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.home) {
                    Fragmenthome frghome = new Fragmenthome();
                    repalceFrg(frghome);
                } else if (item.getItemId() == R.id.chat) {
                    fragmentmotivation frghome = new fragmentmotivation();
                    repalceFrg(frghome);
                } else if (item.getItemId() == R.id.group) {
                    frggroup3 frghome = new frggroup3();
                    repalceFrg(frghome);
                } else if (item.getItemId() == R.id.person) {
                    frgPersent persent = new frgPersent();
                    repalceFrg(persent);
                }
                return true;
            }
        });
        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId()== R.id.ngay){
                    frmLichNgay lichNgay = new frmLichNgay();
                    repalceFrg1(lichNgay);
                }
                if (item.getItemId()==R.id.tuan){
                    frmLichTuan lichTuan = new frmLichTuan();
                    repalceFrg1(lichTuan);
                }
                if (item.getItemId()== R.id.thang){
                    frgLichThang lichThang = new frgLichThang();
                    repalceFrg1(lichThang);
                }
                if (item.getItemId()== R.id.caidat){
                    frgSetting setting = new frgSetting();
                    repalceFrg1(setting);
                }
                return false;
            }
        });

    }

    public void repalceFrg(Fragment frg) {
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.frmnav, frg).commit();
    }
    public void repalceFrg1(Fragment frg) {
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.frmnav, frg).commit();
    }

}
