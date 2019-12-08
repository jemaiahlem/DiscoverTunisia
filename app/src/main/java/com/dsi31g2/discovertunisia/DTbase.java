package com.dsi31g2.discovertunisia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DTbase extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "app.db";
    public static String TABLE1 = "Hotel_table";
    public static String TABLE2 = "Resto_table";
    public static String TABLE3 = "Guide_table";

    public DTbase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE1 +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,PRICE DOUBLE,STARS INTEGER)");
        db.execSQL("create table " + TABLE2 +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,LOCATION STRING)");
        db.execSQL("create table " + TABLE3 +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,SURNAME TEXT,AGE INTEGER,NBLANG INTEGER)");
        db.execSQL(TABLE1);
        db.execSQL(TABLE2);
        db.execSQL(TABLE3);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Drop Existing Tabele
        db.execSQL("DROP TABLE IF EXISTS "+TABLE1);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE2);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE3);
        onCreate(db);
    }

    public boolean insertData(String name,String surname,String marks) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        long result = db.insert(TABLE1,null ,contentValues);
       if(result == -1)
            return false;
        else
          return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE1,null);
        return res;
    }

    public boolean updateData(String id,String name,String surname,String marks) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        db.update(TABLE1, contentValues, "ID = ?",new String[] { id });
        return true;
    }

    public Integer deleteData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE1, "ID = ?",new String[] {id});
    }
}
