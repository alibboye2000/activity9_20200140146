package com.example.classbsqlite.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.HashMap;

public class DBController extends SQLiteOpenHelper {
    public DBController( Context context) {
         //CHECK LATER
        super(context, "ProdTi",  null,  1);
    }

    @Override
    public void onCreate(SQLiteDatabase db ) {

        db.execSQL("create table teman(id integer primary key, nama text, telpon text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion) {
        db.execSQL("drop table if exists teman");
        onCreate(db);
        

    }

    public void insertData(HashMap<String,String> queryValues) {
        SQLiteDatabase basisdata = this.getWritableDatabase();
        ContentValues nilai = new ContentValues();
        nilai.put("nama", queryValues.get("nama"));
        nilai.put("telpon", queryValues.get("telpon"));
        basisdata.insert( "teman", null, nilai);
        basisdata.close();
    }
}
