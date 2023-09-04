package com.example.myschedule.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbHelper extends SQLiteOpenHelper {
    private static final String db_name = "QLL";
    public dbHelper(@Nullable Context context) {
        super(context, db_name,null,2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL("create table lich (id integer primary key autoincrement,ngayThangNam text,ngayThang text,lichNgay text)");
    String data ="insert into lich values(1,'10/2/2023','T7\n22','den 1ngay tat ca su chiu dung cua ban deu tro nen co y nghia')";
    db.execSQL(data);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    if (oldVersion != newVersion){
        db.execSQL("DROP TABLE IF EXISTS lich");
        onCreate(db);
        }
    }
}
