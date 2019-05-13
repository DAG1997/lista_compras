package com.example.lista_compras;

import android.content.ContentValues;
import android.database.Cursor;

public class ComprasEfetuadas {

    public long id;
    public int nome_produto;
    public double quantidade;

    public int getNome_produto() {
        return nome_produto;
    }

    public void setNome_produto(int nome_produto) {
        this.nome_produto = nome_produto;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }



    public ContentValues getContentValues() {
        ContentValues valores = new ContentValues();

        valores.put(BdTableComprasEfetuadas.NOME_PRODUTO, nome_produto);
        valores.put(BdTableComprasEfetuadas.QUANTIDADE, quantidade);


        return valores;
    }

    public static ComprasEfetuadas fromCursor(Cursor cursor) {
        long id = cursor.getLong(
                cursor.getColumnIndex(BdTableComprasEfetuadas._ID)
        );

        int nome_produto = cursor.getInt(
                cursor.getColumnIndex(BdTableComprasEfetuadas.NOME_PRODUTO)
        );

        double quantidade = cursor.getDouble(
                cursor.getColumnIndex(BdTableComprasEfetuadas.QUANTIDADE)
        );


        ComprasEfetuadas ComprasEfetuadas = new ComprasEfetuadas();

        ComprasEfetuadas.setId(id);
        ComprasEfetuadas.setNome_produto(nome_produto);
        ComprasEfetuadas.setQuantidade(quantidade);


        return ComprasEfetuadas;

    }
}

