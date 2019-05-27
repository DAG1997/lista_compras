package com.example.lista_compras;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public class BdTableComprasEfetuadas implements BaseColumns {
    public static final String TABELA_COMPRAS_EFETUADAS = "COMPRAS_EFETUADAS";
    /*public static final String NOME_PRODUTO = "NOME PRODUTO";*/
    public static final String QUANTIDADE = "quantidade";
    public static final String CAMPO_LISTA_PRODUTOS = "Lista produtos";

    public static final String[] TODAS_COLUNAS = new String[]{_ID, QUANTIDADE, CAMPO_LISTA_PRODUTOS /*NOME_PRODUTO*/};


    public SQLiteDatabase db;


    public BdTableComprasEfetuadas(SQLiteDatabase db) {
        this.db = db;
    }

    public void cria() {
        db.execSQL(
                "CREATE TABLE " + TABELA_COMPRAS_EFETUADAS + "(" +
                        _ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        /*NOME_PRODUTO+ "TEXT NOT NULL," +*/
                        QUANTIDADE + " NUMBER NOT NULL," +
                        CAMPO_LISTA_PRODUTOS + " INTEGER NOT NULL," +
                        "FOREIGN KEY (" + CAMPO_LISTA_PRODUTOS + ") REFERENCES " + BdTableListaProdutos.TABELA_LISTA_PRODUTOS + "(" + BdTableListaProdutos._ID + ")" +
                        ")"



        );
    }


    public Cursor query(String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy) {
        return db.query(TABELA_COMPRAS_EFETUADAS, columns, selection, selectionArgs, groupBy, having, orderBy);
    }

    public long insert(ContentValues values) {
        return db.insert(TABELA_COMPRAS_EFETUADAS, null, values);
    }

    public int update(ContentValues values, String whereClause, String [] whereArgs) {
        return db.update(TABELA_COMPRAS_EFETUADAS, values, whereClause, whereArgs);
    }

    public int delete(String whereClause, String[] whereArgs) {
        return db.delete(TABELA_COMPRAS_EFETUADAS, whereClause, whereArgs);
    }
}





