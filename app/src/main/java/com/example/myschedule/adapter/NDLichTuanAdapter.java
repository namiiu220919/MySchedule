package com.example.myschedule.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myschedule.R;

public class NDLichTuanAdapter extends BaseAdapter {
    private final Context context;
    private final String[] NDLichTuan;

    public NDLichTuanAdapter(Context context, String[] ndLichTuan) {
        this.context = context;
        NDLichTuan = ndLichTuan;
    }

    @Override
    public int getCount() {
        return NDLichTuan.length;
    }

    @Override
    public Object getItem(int position) {
        return NDLichTuan[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(this.context).inflate(R.layout.khungl1, parent, false);
        }

        TextView textView = (TextView)convertView.findViewById(R.id.txtNDLich);
        textView.setText(this.NDLichTuan[position]);
        return convertView;
    }
}
