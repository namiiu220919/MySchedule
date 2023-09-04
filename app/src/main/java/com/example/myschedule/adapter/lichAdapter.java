package com.example.myschedule.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myschedule.R;
import com.example.myschedule.dao.lichDao;
import com.example.myschedule.model.lich;

import java.util.ArrayList;

public class lichAdapter extends RecyclerView.Adapter<lichAdapter.viewHolder> {
    private final Context context;
    private final ArrayList<lich> list;
    lichDao lichDao;


    public lichAdapter(Context context, ArrayList<lich> list) {
        this.context = context;
        this.list = list;
        lichDao = new lichDao(context);
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_lich_ngay,null);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.txtNgayThangNam.setText(list.get(position).getNgayThangNam());
        holder.txtNgayThang.setText(list.get(position).getNgayThang());
        holder.txtNDLichNgay.setText(list.get(position).getLichNgay());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder {
        TextView txtNgayThangNam,txtNgayThang,txtNDLichNgay;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            txtNgayThangNam = itemView.findViewById(R.id.txtNgayThangNam);
            txtNgayThang = itemView.findViewById(R.id.txtngayThang);
            txtNDLichNgay = itemView.findViewById(R.id.txtNDLichNgay);

        }
    }
}
