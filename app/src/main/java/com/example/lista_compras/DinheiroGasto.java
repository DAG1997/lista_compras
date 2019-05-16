package com.example.lista_compras;

import android.content.ContentValues;
import android.database.Cursor;

    public class DinheiroGasto {
        private long id;
        private String data;
        private int montante_gasto;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public int getMontante_gasto() {
            return montante_gasto;
        }

        public void setMontante_gasto(int montante_gasto) {
            this.montante_gasto = montante_gasto;
        }

        public ContentValues getContentValues(){
            ContentValues valores = new ContentValues();

            valores.put(BdTableDinheiroGasto.DATA, data);
            valores.put(BdTableDinheiroGasto.MONTANTE_GASTO, montante_gasto);


            return valores;
        }

        public static DinheiroGasto fromCursor(Cursor cursor) {
            long id = cursor.getLong(
                    cursor.getColumnIndex(BdTableDinheiroGasto._ID)
            );

            String data = cursor.getString(
                    cursor.getColumnIndex(BdTableDinheiroGasto.DATA)
            );

             int montante_gasto = cursor.getInt(
                    cursor.getColumnIndex(BdTableDinheiroGasto.MONTANTE_GASTO)
            );






            DinheiroGasto dinheiroGasto = new DinheiroGasto();

            dinheiroGasto.setId(id);
            dinheiroGasto.setData(data);
            dinheiroGasto.setMontante_gasto(montante_gasto);


            return dinheiroGasto;
        }

    }


