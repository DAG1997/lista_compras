package com.example.lista_compras;

import android.content.ContentValues;
import android.database.Cursor;

public class ListaProdutos {

    private long id;
    private int nome_produto;
    private double quantidade;

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

        valores.put(BdTableListaProdutos.NOME_PRODUTO, nome_produto);
        valores.put(BdTableListaProdutos.QUANTIDADE, quantidade);


        return valores;
    }

    public static ListaProdutos fromCursor(Cursor cursor) {
        long id = cursor.getLong(
                cursor.getColumnIndex(BdTableListaProdutos._ID)
        );

        int nome_produto = cursor.getInt(
                cursor.getColumnIndex(BdTableListaProdutos.NOME_PRODUTO)
        );

        double quantidade = cursor.getDouble(
                cursor.getColumnIndex(BdTableListaProdutos.QUANTIDADE)
        );


        ListaProdutos listaProdutos = new ListaProdutos();

        listaProdutos.setId(id);
        listaProdutos.setNome_produto(nome_produto);
        listaProdutos.setQuantidade(quantidade);


        return listaProdutos;

    }
}

