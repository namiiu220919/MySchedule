package com.example.myschedule.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

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
        TextView textView = new TextView(this.context);
        textView.setText(this.lichThang[position]);
        textView.setTextSize(15.0F);
        textView.setTextColor(-16776961);
        return textView;
    }
}
