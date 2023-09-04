package com.example.myschedule.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myschedule.R;

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
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.khungl4, null);
        TextView textView = view.findViewById(R.id.txtNDLich4);
        textView.setText(this.lichTuan[position]);
        textView.setTextSize(15.0F);
        textView.setTextColor(-16776961);

        return view;
    }
}
