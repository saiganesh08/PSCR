package com.example.pscr22;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static final String name = "login.db";

    public DBHelper(Context context) {
        super(context, "login.db",null,1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table users(username TEXT primary key, password TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop Table if exists users");

    }
    public Boolean insertData(String username,String password)
    {
        SQLiteDatabase mydb=this.getWritableDatabase();
        ContentValues contentvalues=new ContentValues();
        contentvalues.put("username",username);
        contentvalues.put("password",password);
        long result=mydb.insert("users",null,contentvalues);
        if (result == -1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    public Boolean checkUsers(String username)
    {
        SQLiteDatabase mydb=this.getWritableDatabase();
        Cursor cursor=mydb.rawQuery("Select * from users where username = ?",new String[] {username});
        if (cursor.getCount() > 0)
        {
            return true;
        }
        else
        {

            return false;
        }
    }
    public Boolean checkusernamepasswords(String username,String password)
    {
        SQLiteDatabase mydb=this.getWritableDatabase();
        Cursor cursor=mydb.rawQuery("Select * from users where username = ? and password = ?", new String[] {username,password});
        if(cursor.getCount() > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

}

