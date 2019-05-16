package com.example.lista_compras;

import android.content.ContentValues;
import android.database.Cursor;

public class ListaProdutos {

    private long id;
    private String nome_produto;
    /*private int quantidade;*/

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome_produto() {
        return nome_produto;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

   /*public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }*/

    public ContentValues getContentValues() {
        ContentValues valores = new ContentValues();

        valores.put(BdTableListaProdutos.NOME_PRODUTO, nome_produto);
        /*valores.put(BdTableListaProdutos.QUANTIDADE, quantidade);*/


        return valores;
    }

    public static ListaProdutos fromCursor(Cursor cursor) {
        long id = cursor.getLong(
                cursor.getColumnIndex(BdTableListaProdutos._ID)
        );

        String nome_produto = cursor.getString(
                cursor.getColumnIndex(BdTableListaProdutos.NOME_PRODUTO)
        );

        /*int quantidade = cursor.getInt(
                cursor.getColumnIndex(BdTableListaProdutos.QUANTIDADE)
        );*/


        ListaProdutos listaProdutos = new ListaProdutos();

        listaProdutos.setId(id);
        listaProdutos.setNome_produto(nome_produto);
        /*listaProdutos.setQuantidade(quantidade);*/


        return listaProdutos;

    }
}

