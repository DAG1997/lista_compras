package com.example.lista_compras;

import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public class BdTableListaProdutos implements BaseColumns {
    private static final String NOME_TABELA = "NOME_TABELA";
    private static final String NOME_PRODUTO = "NOME_PRODUTO";
    private static final String QUANTIDADE = "QUANTIDADE";
    private SQLiteDatabase db;
    public BdTableListaProdutos(SQLiteDatabase db) {
        this.db = db;
    }

    public void cria() {
        db.execSQL(
                "CREATE TABLE " + NOME_TABELA + "(" +
        _ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        NOME_PRODUTO + " TEXT NOT NULL," +
                        QUANTIDADE + " NUMBER NOT NULL," + ")"





        );
    }
}

