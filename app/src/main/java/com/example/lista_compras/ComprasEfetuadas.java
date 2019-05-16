package com.example.lista_compras;

import android.content.ContentValues;
import android.database.Cursor;

public class ComprasEfetuadas {

    public long id;
    /*public String nome_produto;*/
    public int quantidade;

    public long lista_produtos;



   /* public String getNome_produto() {
        return nome_produto;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }*/

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public ContentValues getContentValues() {
        ContentValues valores = new ContentValues();

        /*valores.put(BdTableComprasEfetuadas.NOME_PRODUTO, nome_produto);*/
        valores.put(BdTableComprasEfetuadas.QUANTIDADE, quantidade);


        return valores;
    }

    public static ComprasEfetuadas fromCursor(Cursor cursor) {
        long id = cursor.getLong(
                cursor.getColumnIndex(BdTableComprasEfetuadas._ID)
        );

        /*String nome_produto = cursor.getString(
                cursor.getColumnIndex(BdTableComprasEfetuadas.NOME_PRODUTO)
        );*/

        int quantidade = cursor.getInt(
                cursor.getColumnIndex(BdTableComprasEfetuadas.QUANTIDADE)
        );


        ComprasEfetuadas ComprasEfetuadas = new ComprasEfetuadas();

        ComprasEfetuadas.setId(id);
        /*ComprasEfetuadas.setNome_produto(nome_produto);*/
        ComprasEfetuadas.setQuantidade(quantidade);


        return ComprasEfetuadas;

    }

    public long getLista_produtos() {
        return lista_produtos;
    }

    public void setLista_produtos(long lista_produtos) {
        this.lista_produtos = lista_produtos;
    }
}


