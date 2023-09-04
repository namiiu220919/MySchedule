package com.example.myschedule.fragment;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myschedule.R;
import com.example.myschedule.adapter.lichAdapter;
import com.example.myschedule.dao.lichDao;
import com.example.myschedule.model.lich;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


public class frmLichNgay extends Fragment {
    RecyclerView rcvLichNgay;
    FloatingActionButton fltAdd;
    lichDao lichDao;
    lichAdapter adapter;

    private ArrayList<lich> list = new ArrayList<>();
    EditText edtNgayThangNam,edtNgayThang,edtNDlich;
    Button btnAddLich;
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
        fltAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDiaLogAdd();
            }
        });
        return view;
    }
    public void openDiaLogAdd(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater =  getLayoutInflater();
        View view = inflater.inflate(R.layout.add_lich,null);
        // gan lay out len view
        builder.setView(view);
        Dialog dialog = builder.create();
        dialog.show();
        // anh xa
        edtNgayThangNam = view.findViewById(R.id.edtNgayThangNam);
        edtNgayThangNam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                themlich();
            }
        });
        edtNgayThang = view.findViewById(R.id.edtNgayThang);
        edtNDlich = view.findViewById(R.id.edtNDLich);
        btnAddLich = view.findViewById(R.id.btnAddLich);
        btnAddLich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ngayThangNam = edtNgayThangNam.getText().toString();
                String ngayThang = edtNgayThang.getText().toString();
                String NDlich = edtNDlich.getText().toString();
                lich lich = new lich(ngayThangNam,ngayThang,NDlich);
                if (TextUtils.isEmpty(ngayThangNam)|TextUtils.isEmpty(ngayThang)|TextUtils.isEmpty(NDlich)){
                    Toast.makeText(getActivity(), "vui lòng nhập đầy dủd thông tin", Toast.LENGTH_SHORT).show();
                }else{
                    if (lichDao.insert(lich)){
                        list.clear();
                        list.addAll(lichDao.selectAll());
                        adapter.notifyDataSetChanged();
                        dialog.dismiss();
                        Toast.makeText(getActivity(), "isnert thành công", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getActivity(), "insert thất bại", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    protected void themlich() {
        Calendar calendar = Calendar.getInstance();
        int ngay = calendar.get(calendar.DATE);
        int thang = calendar.get(calendar.MONTH);
        int nam = calendar.get(calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int i1, int i2, int i3) {
                calendar.set(i1, i2, i3);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yy");
                edtNgayThangNam.setText(simpleDateFormat.format(calendar.getTime()));
            }
        }, nam, thang, ngay);
        datePickerDialog.show();
    }
    protected void themlichNgayThang() {
        Calendar calendar = Calendar.getInstance();
        int ngay = calendar.get(calendar.DATE);
        int thang = calendar.get(calendar.MONTH);
        int nam = calendar.get(calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int i1, int i2, int i3) {
                calendar.set(i1, i2, i3);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM");
                edtNgayThangNam.setText(simpleDateFormat.format(calendar.getTime()));
            }
        }, nam, thang, ngay);
        datePickerDialog.show();
    }
}