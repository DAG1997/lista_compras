package com.example.lista_compras;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public class BdTableListaProdutos implements BaseColumns {
    public static final String TABELA_LISTA_PRODUTOS = "LISTA_PRODUTOS";
    public static final String NOME_PRODUTO = "nome_do_produto";
    //public static final String QUANTIDADE = "QUANTIDADE";

    public static final String[] TODAS_COLUNAS = new String[]{_ID, /*QUANTIDADE,*/ NOME_PRODUTO};
    public SQLiteDatabase db;
    public BdTableListaProdutos(SQLiteDatabase db) {
        this.db = db;
    }

    public void cria() {
        db.execSQL(
                "CREATE TABLE " + TABELA_LISTA_PRODUTOS + "(" +
        _ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        NOME_PRODUTO + " TEXT NOT NULL" +
                        /*QUANTIDADE + " NUMBER NOT NULL" +*/ ")"





        );
    }

    public Cursor query(String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy) {
        return db.query(TABELA_LISTA_PRODUTOS, columns, selection, selectionArgs, groupBy, having, orderBy);
    }

    public long insert(ContentValues values) {
        return db.insert(TABELA_LISTA_PRODUTOS, null, values);
    }

    public int update(ContentValues values, String whereClause, String [] whereArgs) {
        return db.update(TABELA_LISTA_PRODUTOS, values, whereClause, whereArgs);
    }

    public int delete(String whereClause, String[] whereArgs) {
        return db.delete(TABELA_LISTA_PRODUTOS, whereClause, whereArgs);
    }
}



