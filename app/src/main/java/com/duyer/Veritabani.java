package com.duyer;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Veritabani extends SQLiteOpenHelper {

    public Veritabani(@Nullable Context context) {
        super(context, "bayrakquiz.sqlite", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS bayraklar (bayrak_id  INT PRIMARY KEY, bayrak_ad TEXT, bayrak_resim TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS bayraklar");
        onCreate(db);

    }
}

