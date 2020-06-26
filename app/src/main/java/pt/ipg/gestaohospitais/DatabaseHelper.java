package pt.ipg.gestaohospitais;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "doentes.db";
    public static final String TABLE_NAME = "doentes_data";
    public static final String COL1 = "ID";
    public static final String COL2 = "NOME";
    public static final String COL3 = "NUMERO_CC";
    public static final String COL4 = "IDADE";
    public static final String COL5 = "MORADA";
    public static final String COL6 = "TELEFONE";

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + " NOME TEXT, NUMERO_CC NUMBER, IDADE NUMBER, MORADA TEXT, TELEFONE TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addData(String nome, String numero_cc, String idade, String morada, String telefone){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, nome);
        contentValues.put(COL3, numero_cc);
        contentValues.put(COL4, idade);
        contentValues.put(COL5, morada);
        contentValues.put(COL6, telefone);

        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
    public Cursor getListContents(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return data;
    }
}
