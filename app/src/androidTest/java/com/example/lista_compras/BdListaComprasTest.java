package com.example.lista_compras;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class BdListaComprasTest {
    @Before
    public void apagaBaseDados() {
        getAppContext().deleteDatabase(BdListaComprasOpenHelper.NOME_BASE_DADOS);
    }

    @Test
    public void criaBdListaCompras() {
        // Context of the app under test.
        Context appContext = getAppContext();

        BdListaComprasOpenHelper openHelper = new BdListaComprasOpenHelper(appContext);

        SQLiteDatabase db = openHelper.getReadableDatabase();

        assertTrue(db.isOpen());
    }

    private Context getAppContext() {
        return InstrumentationRegistry.getTargetContext();
    }



    private long criaListaProdutos(BdTableListaProdutos tabelaListaProdutos, int nome_produto, double quantidade) {
          ListaProdutos lista_produtos = new ListaProdutos();
        lista_produtos.setNome_produto(nome_produto);
        lista_produtos.setQuantidade(quantidade);

        long id = tabelaListaProdutos.insert(lista_produtos.getContentValues());
        assertNotEquals(-1, id);

        return id;
    }

    private Cursor getListaProdutos(BdTableListaProdutos tabelalistaprodutos) {
        return tabelalistaprodutos.query(BdTableListaProdutos.TODAS_COLUNAS, null, null, null, null, null);
    }

    private ListaProdutos getListaProdutosComID(Cursor cursor, long id) {
        ListaProdutos lista_produtos = null;

        while (cursor.moveToNext()) {
            lista_produtos = ListaProdutos.fromCursor(cursor);

            if (lista_produtos.getId() == id) {
                break;
            }
        }

        assertNotNull(lista_produtos);

        return lista_produtos;
    }

    private long criaDinheiroGasto(BdTableDinheiroGasto tabelaDinheiroGasto, double data, double montante_gasto) {
        DinheiroGasto dinheiroGasto = new DinheiroGasto();

        dinheiroGasto.setData(data);
        dinheiroGasto.setMontante_gasto(montante_gasto);


        long id = tabelaDinheiroGasto.insert(dinheiroGasto.getContentValues());
        assertNotEquals(-1, id);

        return id;
    }

    private Cursor getDinheiroGasto(BdTableDinheiroGasto tableDinheiroGasto) {
        return tableDinheiroGasto.query(BdTableDinheiroGasto.TODAS_COLUNAS, null, null, null, null, null);
    }

    private DinheiroGasto getDinheiroGastoComID(Cursor cursor, long id) {
        DinheiroGasto dinheiroGasto = null;

        while (cursor.moveToNext()) {
            dinheiroGasto = DinheiroGasto.fromCursor(cursor);

            if (dinheiroGasto.getId() == id) {
                break;
            }
        }

        assertNotNull(dinheiroGasto);

        return dinheiroGasto;
    }

    private long criaComprasEfetuadas(BdTableComprasEfetuadas tabelaComprasEfetuadas, int nome_produto, double quantidade) {

    ComprasEfetuadas comprasEfetuadas = new ComprasEfetuadas();
        comprasEfetuadas.setNome_produto(nome_produto);
        comprasEfetuadas.setQuantidade(quantidade);

    long id = tabelaComprasEfetuadas.insert(comprasEfetuadas.getContentValues());
    assertNotEquals(-1, id);

        return id;
}

    private Cursor getComprasEfetuadas(BdTableComprasEfetuadas tabelaComprasEfetuadas) {
        return tabelaComprasEfetuadas.query(BdTableComprasEfetuadas.TODAS_COLUNAS, null, null, null, null, null);
    }

    private ComprasEfetuadas getComprasEfetuadasComID(Cursor cursor, long id) {
        ComprasEfetuadas comprasEfetuadas = null;

        while (cursor.moveToNext()) {
            comprasEfetuadas = ComprasEfetuadas.fromCursor(cursor);

            if (comprasEfetuadas.getId() == id) {
                break;
            }
        }

        assertNotNull(comprasEfetuadas);

        return comprasEfetuadas;
    }
}
