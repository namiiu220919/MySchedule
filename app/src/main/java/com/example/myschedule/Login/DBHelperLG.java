package com.example.myschedule.Login;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelperLG extends SQLiteOpenHelper {
    public  static final String DB_NAME = "TKMK";
    public DBHelperLG(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table nguoidung(" +
                "username text primary key," +
                "password text, " +
                "hoten text" +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            db.execSQL("DROP TABLE IF EXISTS nguoidung");
            onCreate(db);
        }
    }
}
