package com.example.myschedule.database;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class data extends SQLiteOpenHelper {
    public static final String Db_name = "QLTG";
    public data(Context context) {
        super(context, Db_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String tb = "create table thoigian(thu text primary key, ngay text, loichuc text, loinhac text)";
        sqLiteDatabase.execSQL(tb);

        String data = "insert into thoigian values('Th 3','4','Đến một ngày tất cả sự chiệu đựng của bạn s...','2 lời nhắc')," +
                "('Th 4','5','Đến một ngày tất cả sự chiệu đựng của bạn s...','2 lời nhắc')," +
                "('Th 5','6','Đến một ngày tất cả sự chiệu đựng của bạn s...','2 lời nhắc')";
        sqLiteDatabase.execSQL(data);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        if (i!=i1){
            sqLiteDatabase.execSQL("drop table if exists thoigian");
            onCreate(sqLiteDatabase);
        }

    }
}
