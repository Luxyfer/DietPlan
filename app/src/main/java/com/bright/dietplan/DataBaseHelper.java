package com.bright.dietplan;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper  extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "db.db";
    public static final String TABLE_NAME = "User";

    //Nome colunas tabela "User"
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NOME";
    public static final String COL_3 = "DTNASC";
    public static final String COL_4 = "SEXO";
    public static final String COL_5 = "PESO";
    public static final String COL_6 = "GLUTEN";
    public static final String COL_7 = "LACTOSE";

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,NOME TEXT,DTNASC TEXT,SEXO TEXT, PESO INTEGER,GLUTEN INTEGER, LACTOSE INTEGER)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String nome, String dtnasc, String sexo, int peso, int gluten, int lactose){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,nome);
        contentValues.put(COL_3,dtnasc);
        contentValues.put(COL_4,sexo);
        contentValues.put(COL_5, peso);
        contentValues.put(COL_6, gluten);
        contentValues.put(COL_7, lactose);
        long result = db.insert(TABLE_NAME,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }
}
