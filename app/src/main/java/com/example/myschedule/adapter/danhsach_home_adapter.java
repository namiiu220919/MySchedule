package com.example.myschedule.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.myschedule.R;
import com.example.myschedule.dao.dsdao;
import com.example.myschedule.databinding.ItemHomeBinding;
import com.example.myschedule.model.danhsachthoigian;

import java.util.ArrayList;

public class danhsach_home_adapter extends RecyclerView.Adapter<danhsach_home_adapter.viewholder> {
    public final Context context;
    private ItemHomeBinding binding;
    public final ArrayList<danhsachthoigian> list;
    dsdao dsDao;

    public danhsach_home_adapter(Context context, ArrayList<danhsachthoigian> list) {
        this.context = context;
        this.list = list;
        dsDao = new dsdao(context);
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_home, null);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        binding = ItemHomeBinding.bind(holder.itemView);
        binding.txtthu.setText(list.get(position).getThu());
        binding.txtngay.setText(list.get(position).getNgay());
        binding.txtloichuc.setText(list.get(position).getLoichuc());
        binding.txtloinhac.setText(list.get(position).getLoinhac());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class viewholder extends RecyclerView.ViewHolder {

        public viewholder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
