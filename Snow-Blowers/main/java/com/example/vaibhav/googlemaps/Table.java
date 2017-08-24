package com.example.vaibhav.googlemaps;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Vaibhav on 12/10/2015.
 */
public class Table extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "student.db";
    public static final String TABLE_NAME = "Student_table";
    public static final String COL_1 = "NAME";
    public static final String COL_2 = "PHONE";

    public Table(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (" + "_id INTEGER PRIMARY KEY AUTOINCREMENT" + "," + COL_1 + " TEXT" + "," + COL_2 + " INTEGER);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST"+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String name, String phone) {
        // Middle field String surname is useless remove it if it cause error
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        //ContentValues contentValues = null;
        contentValues.put(COL_1,name);
        //Integer phone = null;
        contentValues.put(COL_2,phone);
        long result = db.insert(TABLE_NAME,null ,contentValues);
        //i have creat ContentValuses local Variables chack if it cause error
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getRetriveData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("Select * From "+TABLE_NAME,null);
        return result;

    }



}
