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

    public static final String databaseName = "allusers";
    Context context;


    public DatabaseHelper(@Nullable Context context) { // création de notre base de donnée
        super(context, "allusers" , null, 1); this.context=context;
    }


    @Override
    public void onCreate(SQLiteDatabase MyDataBase) { // création de la base de donnée
        MyDataBase.execSQL("create Table allusers(email TEXT primary key," +
                " password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDataBase, int i, int i1) { // si la table existe deja supprimer celle qui vient d'etre créer
        MyDataBase.execSQL("drop Table if exists allusers");
    }

    // Insertion de nos données, et si l'insertion se déroule correctement on retourne True.
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

// Méthode update, elle ne donné aucune erreur mais ne fonctionne pas malheureusement. Elle retourne constamment False.
    /*public Boolean storeData(String email, String mdp) {
        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("password", mdp);
        contentValues.put("email", email);


        long result = database.update("allusers", contentValues, "email=? and password=?" ,new String[]{email} );
        if (result != -1) {
            Toast.makeText(context, "Saved", Toast.LENGTH_SHORT).show();
            database.close();
            return true;
        } else {
            Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
            return false;
        }
    }*/
// méthode qui supprime une ligne de la table allusers lorsque l'email est egale a celle entrée en parametre.
    public void delete(String email){
        SQLiteDatabase database = this.getWritableDatabase();
        database.delete("allusers", "email=?", new String[]{email} );
        database.close();
    }
    //Méthode qui retourne les information d'un utilisateur.
    public Cursor getUser(){
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("Select * from allusers", null);
        return cursor;
    }
// méthode qui verifie si l'email correspond et true si elle existe.
    public Boolean checkEmail(String email){
        SQLiteDatabase MyDataBase = this.getWritableDatabase();
        Cursor cursor = MyDataBase.rawQuery("Select * From allusers where email = ?", new String[]{email});

        if (cursor.getCount() > 0){
            return true;
        }else{
            return false;
        }
    }
// comme la méthode précédente, elle retourne true si les l'email et le passeword correspond
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
