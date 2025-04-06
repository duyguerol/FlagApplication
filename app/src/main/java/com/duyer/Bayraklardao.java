package com.duyer;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class Bayraklardao {

    public ArrayList<Bayraklar> rastgele5Getir(Veritabani vt) {
        ArrayList<Bayraklar> bayraklarArrayList = new ArrayList<>();
        SQLiteDatabase db = vt.getReadableDatabase();

        try (Cursor c = db.rawQuery("SELECT * FROM bayraklar ORDER BY RANDOM() LIMIT 5", null)) {
            while (c.moveToNext()) {
                Bayraklar b = new Bayraklar(
                        c.getInt(c.getColumnIndexOrThrow("bayrak_id")),
                        c.getString(c.getColumnIndexOrThrow("bayrak_ad")),
                        c.getString(c.getColumnIndexOrThrow("bayrak_resim"))
                );
                bayraklarArrayList.add(b);
            }
        }

        return bayraklarArrayList;
    }

    public ArrayList<Bayraklar> rastgele3YanlisSecenekGetir(Veritabani vt, int bayrak_id) {
        ArrayList<Bayraklar> bayraklarArrayList = new ArrayList<>();
        SQLiteDatabase db = vt.getReadableDatabase();

        try (Cursor c = db.rawQuery("SELECT * FROM bayraklar WHERE bayrak_id != ? ORDER BY RANDOM() LIMIT 3", new String[]{String.valueOf(bayrak_id)})) {
            while (c.moveToNext()) {
                Bayraklar b = new Bayraklar(
                        c.getInt(c.getColumnIndexOrThrow("bayrak_id")),
                        c.getString(c.getColumnIndexOrThrow("bayrak_ad")),
                        c.getString(c.getColumnIndexOrThrow("bayrak_resim"))
                );
                bayraklarArrayList.add(b);
            }
        }

        return bayraklarArrayList;
    }




}

