package com.example.lista_compras;

import android.content.ContentValues;
import android.database.Cursor;

    public class DinheiroGasto {
        private long id;
        private double data;
        private double montante_gasto;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public double getData() {
            return data;
        }

        public void setData(double data) {
            this.data = data;
        }

        public double getMontante_gasto() {
            return montante_gasto;
        }

        public void setMontante_gasto(double montante_gasto) {
            this.montante_gasto = montante_gasto;
        }

        public ContentValues getContentValues() {
            ContentValues valores = new ContentValues();

            valores.put(BdTableDinheiroGasto.DATA, data);
            valores.put(BdTableDinheiroGasto.MONTANTE_GASTO, montante_gasto);


            return valores;
        }

        public static DinheiroGasto fromCursor(Cursor cursor) {
            long id = cursor.getLong(
                    cursor.getColumnIndex(BdTableDinheiroGasto._ID)
            );

            double data = cursor.getDouble(
                    cursor.getColumnIndex(BdTableDinheiroGasto.DATA)
            );

             double montante_gasto = cursor.getDouble(
                    cursor.getColumnIndex(BdTableDinheiroGasto.MONTANTE_GASTO)
            );


            DinheiroGasto dinheiroGasto = new DinheiroGasto();

            dinheiroGasto.setId(id);
            dinheiroGasto.setData(data);
            dinheiroGasto.setMontante_gasto(montante_gasto);


            return dinheiroGasto;
        }
    }


