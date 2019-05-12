package com.example.lista_compras;

import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public class BdTableDinheiroGasto implements BaseColumns {
    private static final String NOME_TABELA = "NOME_TABELA";
    private static final String DATA = "Data";
    private static final String MONTANTE_GASTO = "Montante gasto";
    private SQLiteDatabase db;
    public BdTableDinheiroGasto(SQLiteDatabase db) {
        this.db = db;
    }

    public void cria() {
        db.execSQL(
                "CREATE TABLE " + NOME_TABELA + "(" +
                        _ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        DATA + " DATE NOT NULL," +
                        MONTANTE_GASTO + "NUMBER NOT NULL" +
                        ")"
        );
    }
}