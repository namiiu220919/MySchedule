package com.example.myschedule.adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
        lich lich = list.get(position);
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("chú ý");
                builder.setIcon(R.drawable.baseline_warning_24);
                builder.setMessage("bạn có chắc chắn muốn xóa không");
                builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (lichDao.delete(lich.getId())){
                            list.clear();
                            list.addAll(lichDao.selectAll());
                            notifyDataSetChanged();
                            Toast.makeText(context, "xóa thành công", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(context, "xóa thất bại", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                builder.setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder {
        TextView txtNgayThangNam,txtNgayThang,txtNDLichNgay;
        Button btnDelete, btnUpDate;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            txtNgayThangNam = itemView.findViewById(R.id.txtNgayThangNam);
            txtNgayThang = itemView.findViewById(R.id.txtngayThang);
            txtNDLichNgay = itemView.findViewById(R.id.txtNDLichNgay);
            btnDelete = itemView.findViewById(R.id.btnDelete);
            btnUpDate = itemView.findViewById(R.id.btnUpdate);
        }
    }
}
