package com.example.myschedule.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class lichTuanAdapter extends BaseAdapter {
    private final Context context;
    private final String[]  lichTuan;

    public lichTuanAdapter(Context context, String[] lichTuan) {
        this.context = context;
        this.lichTuan = lichTuan;
    }

    @Override
    public int getCount() {
        return lichTuan.length;
    }

    @Override
    public Object getItem(int position) {
        return lichTuan[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView = new TextView(this.context);
        textView.setText(this.lichTuan[position]);
        textView.setTextSize(15.0F);
        textView.setTextColor(-16776961);
        return textView;
    }
}
