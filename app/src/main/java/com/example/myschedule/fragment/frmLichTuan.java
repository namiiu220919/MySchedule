package com.example.myschedule.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.myschedule.R;
import com.example.myschedule.adapter.NDLichTuanAdapter;
import com.example.myschedule.adapter.lichTuanAdapter;


public class frmLichTuan extends Fragment {
    GridView gvLichTuan;
    GridView gvNDLichTuan;
    lichTuanAdapter adapter;
    NDLichTuanAdapter adapter1;
    String[] arrayLich = new String[]{"T2", "T3", "T4", "T5", "T6", "T7", "CN"};
    String[] arrayNDlichTuan = new String[]{"den 1...", "den 1...", "den 1...", "den 1...", "den 1...", "den 1...",
            "den 1...", "7:30", "", "", "", "", "", "", "9:00", "", "", "", "", "", "", "12:00", "", "", "", "", "",
            "", "15:00", "", "", "", "", "", "", "19:00", "", "", "", "", "", "", "22:00", "", "", "", "", "", ""};
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_frm_lich_tuan, container, false);
       gvLichTuan =  view.findViewById(R.id.gvLichTuan);
       gvNDLichTuan = view.findViewById(R.id.gvNDLichTuan);
       adapter = new lichTuanAdapter(requireContext(),arrayLich);
       gvLichTuan.setAdapter(adapter);
       adapter1 = new NDLichTuanAdapter(requireContext(),arrayNDlichTuan);
       gvNDLichTuan.setAdapter(adapter1);
       return  view;
    }
}