package com.example.basicbankapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHandler extends SQLiteOpenHelper {
    public static final String DB_Name="Bankdb";
    public static final  int DB_VERSION=1;
    public static final String TABLE_Name="customer";
    public static final String FirstName="fn";
    public static final String LastName="ln";
    public static final String Email_ID="en";

    public DBHandler(@Nullable Context context) {
        super(context, DB_Name, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="CREATE TABLE " +TABLE_Name +"("+ FirstName + "TEXT," + LastName + "TEXT," + Email_ID + "TEXT)";
        db.execSQL(query);

    }
    public void addCustomer(String firstName,String lastName,String email_ID){
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(FirstName,firstName);
        values.put(LastName,lastName);
        values.put(Email_ID,email_ID);

        db.insert(TABLE_Name,null,values);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Name);
        onCreate(db);

    }
}
