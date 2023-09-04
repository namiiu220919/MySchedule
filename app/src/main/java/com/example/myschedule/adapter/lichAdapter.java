package com.example.myschedule.adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myschedule.R;
import com.example.myschedule.dao.lichDao;
import com.example.myschedule.model.lich;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class lichAdapter extends RecyclerView.Adapter<lichAdapter.viewHolder> {
    private final Context context;
    private final ArrayList<lich> list;
    lichDao lichDao;
    EditText edtUDNgayThangNam, edtUDNgayThang, edtUDNDLich;
    Button btnUD;

    public lichAdapter(Context context, ArrayList<lich> list) {
        this.context = context;
        this.list = list;
        lichDao = new lichDao(context);
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_lich_ngay, null);
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
                        if (lichDao.delete(lich.getId())) {
                            list.clear();
                            list.addAll(lichDao.selectAll());
                            notifyDataSetChanged();
                            Toast.makeText(context, "xóa thành công", Toast.LENGTH_SHORT).show();
                        } else {
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
        holder.btnUpDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDiaLongUD(lich);

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder {
        TextView txtNgayThangNam, txtNgayThang, txtNDLichNgay;
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

    public void openDiaLongUD(lich lich) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        // tao view , gan layout vao view
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view = inflater.inflate(R.layout.update_lich, null);
        builder.setView(view);
        Dialog dialog = builder.create();
        dialog.show();
        // anh xa
        edtUDNgayThangNam = view.findViewById(R.id.edtUDNgayThangNam);
        edtUDNgayThangNam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                themlich();
            }
        });
        edtUDNgayThang = view.findViewById(R.id.edtUDNgayThang);
        edtUDNDLich = view.findViewById(R.id.edtUDNDLich);
        btnUD = view.findViewById(R.id.btnUDL);
        // gan du lieu
        edtUDNgayThangNam.setText(lich.getNgayThangNam());
        edtUDNgayThang.setText(lich.getNgayThang());
        edtUDNDLich.setText(lich.getLichNgay());
        btnUD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lich.setNgayThangNam(edtUDNgayThangNam.getText().toString());
                lich.setNgayThang(edtUDNgayThang.getText().toString());
                lich.setLichNgay(edtUDNDLich.getText().toString());
                if (lichDao.update(lich)) {
                    list.clear();
                    list.addAll(lichDao.selectAll());
                    notifyDataSetChanged();
                    dialog.dismiss();
                    Toast.makeText(context, "update thành công", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "update thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    protected void themlich() {
        Calendar calendar = Calendar.getInstance();
        int ngay = calendar.get(calendar.DATE);
        int thang = calendar.get(calendar.MONTH);
        int nam = calendar.get(calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int i1, int i2, int i3) {
                calendar.set(i1, i2, i3);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yy");
                edtUDNgayThangNam.setText(simpleDateFormat.format(calendar.getTime()));
            }
        }, nam, thang, ngay);
        datePickerDialog.show();
    }
}
