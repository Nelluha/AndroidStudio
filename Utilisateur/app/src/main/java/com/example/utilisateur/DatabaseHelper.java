package com.example.utilisateur;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.io.ByteArrayOutputStream;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String databaseName = "Signup.db";
    Context context;


    public DatabaseHelper(@Nullable Context context) {
        super(context, "Signup.db" , null, 1); this.context=context;
    }


    @Override
    public void onCreate(SQLiteDatabase MyDataBase) {
        MyDataBase.execSQL("create Table allusers(email TEXT primary key," +
                " password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDataBase, int i, int i1) {
        MyDataBase.execSQL("drop Table if exists allusers");
    }

    public Boolean insertData(String email, String password){
        SQLiteDatabase MyDataBase = this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("email", email);
        contentValues.put("password",password);

        long result = MyDataBase.insert("allusers", null, contentValues);

        if (result == -1  ){
            return false;
        } else {
            return true;
        }
    }

    /*public Boolean storeData(String email, String mdp) {
        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("password", mdp);
        contentValues.put("email", email);


        long result = database.update("allusers", contentValues, null ,new String[]{email} );
        if (result != -1) {
            Toast.makeText(context, "Saved", Toast.LENGTH_SHORT).show();
            database.close();
            return true;
        } else {
            Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
            return false;
        }

    }*/

    public void delete(String email){
        SQLiteDatabase database = this.getWritableDatabase();
        database.delete("allusers", "email=?", new String[]{email} );
        database.close();
    }
    public Cursor getUser(){
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("Select * from allusers", null);
        return cursor;
    }

    public Boolean checkEmail(String email){
        SQLiteDatabase MyDataBase = this.getWritableDatabase();
        Cursor cursor = MyDataBase.rawQuery("Select * From allusers where email = ?", new String[]{email});

        if (cursor.getCount() > 0){
            return true;
        }else{
            return false;
        }
    }

    public Boolean checkEmailPassword(String email, String password){
        SQLiteDatabase MyDataBase = this.getWritableDatabase();
        Cursor cursor = MyDataBase.rawQuery("Select * from allusers where email = ?" + "and password = ?", new String[]{email, password});

        if(cursor.getCount()>0){
            return true;
        }else{
            return false;
        }
    }

}
