package com.example.lista_compras;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public class BdTableDinheiroGasto implements BaseColumns {
    public static final String TABELA_DINHEIRO_GASTO = "DINHEIRO_GASTO";
    public static final String DATA = "Data";
    public static final String MONTANTE_GASTO = "Montante_gasto";

    public SQLiteDatabase db;

    public static final String[] TODAS_COLUNAS = new String[]{_ID, DATA, MONTANTE_GASTO};

    public BdTableDinheiroGasto(SQLiteDatabase db) {
        this.db = db;
    }

    public void cria() {
        db.execSQL(

                "CREATE TABLE " + TABELA_DINHEIRO_GASTO + "(" +
                        _ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        DATA + " STRING NOT NULL," +
                        MONTANTE_GASTO + " NUMBER NOT NULL" +
                        ")"
        );
    }

    public Cursor query(String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy) {
        return db.query(TABELA_DINHEIRO_GASTO, columns, selection, selectionArgs, groupBy, having, orderBy);
    }

    public long insert(ContentValues values) {
        return db.insert(TABELA_DINHEIRO_GASTO, null, values);
    }

    public int update(ContentValues values, String whereClause, String [] whereArgs) {
        return db.update(TABELA_DINHEIRO_GASTO, values, whereClause, whereArgs);
    }

    public int delete(String whereClause, String[] whereArgs) {
        return db.delete(TABELA_DINHEIRO_GASTO, whereClause, whereArgs);
    }
}




