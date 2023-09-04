package com.example.myschedule.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myschedule.R;
import com.example.myschedule.adapter.lichAdapter;
import com.example.myschedule.dao.lichDao;
import com.example.myschedule.model.lich;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class frmLichNgay extends Fragment {
    RecyclerView rcvLichNgay;
    FloatingActionButton fltAdd;
    lichDao lichDao;
    lichAdapter adapter;
    private ArrayList<lich> list = new ArrayList<>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_frm_lich_ngay, container, false);
        rcvLichNgay = view.findViewById(R.id.rcvLichNgay);
        fltAdd = view.findViewById(R.id.fltAdd);
        lichDao = new lichDao(requireContext());
        list = lichDao.selectAll();
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext());
        rcvLichNgay.setLayoutManager(layoutManager);
        adapter = new lichAdapter(requireContext(),list);
        rcvLichNgay.setAdapter(adapter);
        return view;
    }
}