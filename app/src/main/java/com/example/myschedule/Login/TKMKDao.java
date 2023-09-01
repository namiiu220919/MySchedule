package com.example.myschedule.Login;

import static android.content.ContentValues.TAG;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

public class TKMKDao {
    private DBHelperLG dBhelper;

    public TKMKDao(Context context) {
        dBhelper = new DBHelperLG(context);
    }

    public ArrayList<TKMK> selectAll() {
        ArrayList<TKMK> list = new ArrayList<>();
        SQLiteDatabase db = dBhelper.getReadableDatabase();
        try {
            Cursor cursor = db.rawQuery("select * from nguoidung", null);
            if (cursor.getCount() > 0) {
                while (!cursor.isAfterLast()) {
                    TKMK tkmk = new TKMK();

                    tkmk.setUsername(cursor.getString(0));
                    tkmk.setPassword(cursor.getString(1));
                    tkmk.setHoten(cursor.getString(2));
                    list.add(tkmk);
                    cursor.moveToNext();
                }
            }
        } catch (Exception e) {
            Log.i(TAG, "Lỗi", e);
        }
        return list;
    }
    public boolean checklogin(String username, String pass) {
        SQLiteDatabase db = dBhelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from nguoidung where username=? and password=?", new String[]{username, pass});
        int row = cursor.getCount();

        return (row > 0);
    }

    public boolean insert(TKMK tkmk) {
        SQLiteDatabase db = dBhelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", tkmk.getUsername());
        values.put("password", tkmk.getPassword());
        values.put("hoten", tkmk.getHoten());

        long row = db.insert("nguoidung", null, values);
        return (row > 0);
    }

    public boolean update(TKMK tkmk) {
        SQLiteDatabase db = dBhelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", tkmk.getUsername());
        values.put("password", tkmk.getPassword());
        values.put("hoten", tkmk.getHoten());

        long row = db.update("nguoidung", values, "password=?", new String[]{String.valueOf(tkmk.getPassword())});
        return (row > 0);
    }
}
