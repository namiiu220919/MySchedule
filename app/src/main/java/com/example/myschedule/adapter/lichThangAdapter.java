package com.example.myschedule.adapter;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myschedule.R;

public class lichThangAdapter extends BaseAdapter {
    private final Context context;
    private final String[]  lichThang;

    public lichThangAdapter(Context context, String[] lichThang) {
        this.context = context;
        this.lichThang = lichThang;
    }

    @Override
    public int getCount() {
        return lichThang.length;
    }

    @Override
    public Object getItem(int position) {
        return lichThang[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.khungl4, null);
        TextView textView = view.findViewById(R.id.txtNDLich4);
        textView.setText(this.lichThang[position]);
        textView.setTextSize(15.0F);
        textView.setTextColor(-16776961);

        return view;
    }
}
