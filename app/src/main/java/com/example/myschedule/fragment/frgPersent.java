package com.example.myschedule.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.myschedule.R;

public class frgPersent extends Fragment {
    CheckBox chk1,chk2,chk3,chk4;
    ProgressBar progressBar;
    TextView txtKQ;
    Button btnTKTuan;
    public frgPersent() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_frg_persent, container, false);
        chk1 = view.findViewById(R.id.chk1);
        chk2 = view.findViewById(R.id.chk2);
        chk3 = view.findViewById(R.id.chk3);
        chk4 = view.findViewById(R.id.chk4);
        txtKQ = view.findViewById(R.id.txtKQ);
        progressBar = view.findViewById(R.id.progressBar);
        btnTKTuan = view.findViewById(R.id.btnTKTuan);
//        btnTKTuan.setOnClickListener(new View.OnClickListener() {
//            @SuppressLint("ResourceType")
//            @Override
//            public void onClick(View v) {
//                Fragment fragment = new frm_thong_ke_tuan();
//                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
//                FragmentTransaction transaction = fragmentManager.beginTransaction();
//                Fragment oldFragment = fragmentManager.findFragmentById(R.id.persent);
//                if (oldFragment != null) {
//                    transaction.hide(oldFragment);
//                }
//                transaction.add(R.id.thongketuan,fragment);
//                transaction.addToBackStack(null);
//                transaction.commit();
//
//            }
//        });
        chk1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tienDoLichTrinh();
            }
        });
        chk2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tienDoLichTrinh();
            }
        });
        chk3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tienDoLichTrinh();
            }
        });
        chk4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tienDoLichTrinh();
            }
        });
        return view;
    }
    public void tienDoLichTrinh() {
        int a = 25;
        int dem = 0;

        if (chk1.isChecked()) {
            dem++;
        }

        if (chk2.isChecked()) {
            dem++;
        }
        if(chk3.isChecked()){
            dem++;
        }
        if (chk4.isChecked()){
            dem++;
        }
        int current = progressBar.getProgress();
        if (progressBar.getMax() <= 100) {
            current = a * dem;
        }
        progressBar.setProgress(current);
        int percent = dem *a;
        String text = "bạn đã hoàn thành "+ percent +"% của ngày hôm nay";
        txtKQ.setText(text);
    }
}