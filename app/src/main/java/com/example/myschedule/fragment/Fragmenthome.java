package com.example.myschedule.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;


import com.example.myschedule.R;
import com.example.myschedule.databinding.FragmentFragmenthomeBinding;
import com.example.myschedule.model.danhsachthoigian;

import java.util.ArrayList;

public class Fragmenthome extends Fragment {

    public Fragmenthome() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_fragmenthome, container, false);
        return view ;
    }
}