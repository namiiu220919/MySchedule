package com.example.myschedule.dao;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.myschedule.database.data;
import com.example.myschedule.model.danhsachthoigian;

import java.util.ArrayList;

public class dsdao {
        private final data dbhelper;

    public dsdao(Context context) {
        dbhelper = new data(context);
    }

        public ArrayList<danhsachthoigian> selectAll(){
        ArrayList<danhsachthoigian> list = new ArrayList<>();
        SQLiteDatabase db=dbhelper.getReadableDatabase();
        try {
            Cursor cursor=db.rawQuery("select * from thoigian", null);
            if (cursor.getCount()>0){
                cursor.moveToFirst();
                while (!cursor.isAfterLast()){
                    danhsachthoigian dv= new danhsachthoigian();
                    dv.setThu(cursor.getString(0));
                    dv.setNgay(cursor.getString(1));
                    dv.setLoichuc(cursor.getString(2));
                    dv.setLoinhac(cursor.getString(3));

                    list.add(dv);
                    cursor.moveToNext();
                }
            }
        }catch (Exception e){
            Log.i(TAG,"Lỗi",e);
        }
        return list;
    }

}
