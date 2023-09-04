package com.example.myschedule.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.myschedule.R;
import com.example.myschedule.adapter.NDLichThangAdpater;
import com.example.myschedule.adapter.lichThangAdapter;


public class frgLichThang extends Fragment {
    GridView gvLichThang;
    GridView gvNDLichThang;
    lichThangAdapter adapter;
    NDLichThangAdpater adpater1;
    String[] arrayLich = new String[]{"T2", "T3", "T4", "T5", "T6", "T7", "CN"};
    String[] arrayNDlichTuan = new String[]{" 1\nden 1...", "2\nden 1...", "3\nden 1...", "4\nden 1...", "5\nden 1...", "6\nden 1...", "7\nden 1...",
            "8\nden 1...", "9\nden 1...", "10\nden 1...", "11\nden 1...", "12\nden 1...", "13\nden 1...", "14\nden 1...",
            "15\nden 1...", "16\nden 1...", "17\nden 1...", "18\nden 1...", "19\nden 1...", "20\nden 1...", "21\nden 1...",
            "22\nden 1...", "23\nden 1...", "24\nden 1...", "25\nden 1...", "26\nden 1...","27\nden 1...", "28\nden 1...",
            "29\nden 1...", "30\nden 1...", "1\nden 1...", "2\nden 1...", "3\nden 1...", "4\nden 1...", "5\nden 1..."};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_frg_lich_thang, container, false);
        gvLichThang = view.findViewById(R.id.gvLichThang);
        gvNDLichThang = view.findViewById(R.id.gvNDLichThang);
        adapter = new lichThangAdapter(requireContext(),arrayLich);
        gvLichThang.setAdapter(adapter);
        adpater1 = new NDLichThangAdpater(requireContext(),arrayNDlichTuan);
        gvNDLichThang.setAdapter(adpater1);
        return view;
    }
}