package com.example.lista_compras;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.test.InstrumentationRegistry;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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



    @Test
    public void testCRUD() {
        BdListaComprasOpenHelper openHelper = new BdListaComprasOpenHelper(getAppContext());
        SQLiteDatabase db = openHelper.getWritableDatabase();

        BdTableListaProdutos tabelaListaProdutos = new BdTableListaProdutos(db);

        // Teste read lista produtos (cRud)
        Cursor cursorListaProdutos = getListaProdutos(tabelaListaProdutos);
        assertEquals(0, cursorListaProdutos.getCount());

        // Teste create/read lista produtos (CRud)
        String nome_produto = "Pacotes de Arroz";
        //int quantidade = 3;

        long idPacotesArroz = criaListaProdutos(tabelaListaProdutos, nome_produto) ;//quantidade);
        cursorListaProdutos = getListaProdutos(tabelaListaProdutos);
        assertEquals(1, cursorListaProdutos.getCount());


        ListaProdutos listaProdutos = getListaProdutosComID(cursorListaProdutos ,idPacotesArroz);
        assertEquals(nome_produto, listaProdutos.getNome_produto());
        //assertEquals(nome_produto, listaProdutos.getQuantidade());


        nome_produto = "Latas de Atum";
        //quantidade = 14;
        long idPacotesAtum = criaListaProdutos(tabelaListaProdutos, nome_produto);//, quantidade);
        cursorListaProdutos = getListaProdutos(tabelaListaProdutos);
        assertEquals(2, cursorListaProdutos.getCount());

        listaProdutos = getListaProdutosComID(cursorListaProdutos, idPacotesAtum);
        assertEquals(nome_produto, listaProdutos.getNome_produto());
        //assertEquals(quantidade, listaProdutos.getQuantidade());


        // Teste read/update lista produtos (cRUd)
        nome_produto = "Carbohidratos / Pacotes de Arroz ";
        //quantidade = 7;
        listaProdutos.setNome_produto(nome_produto);
        //listaProdutos.setQuantidade(quantidade);

        int registosAlterados = tabelaListaProdutos.update(listaProdutos.getContentValues(), BdTableListaProdutos._ID + "=?", new String[]{String.valueOf(idPacotesArroz)});

        assertEquals(1, registosAlterados);



        tabelaListaProdutos.update(listaProdutos.getContentValues(), BdTableListaProdutos._ID + "=?", new String[]{String.valueOf(idPacotesArroz)});

        cursorListaProdutos = getListaProdutos(tabelaListaProdutos);

        listaProdutos = getListaProdutosComID(cursorListaProdutos, idPacotesArroz);
        assertEquals(nome_produto, listaProdutos.getNome_produto());
        //assertEquals(quantidade, listaProdutos.getQuantidade());


        // Teste read/delete lista produtos (cRuD)
        long id = criaListaProdutos(tabelaListaProdutos, "TESTE");
        cursorListaProdutos = getListaProdutos(tabelaListaProdutos);
        assertEquals(3, cursorListaProdutos.getCount());


        tabelaListaProdutos.delete(BdTableListaProdutos._ID + "=?", new String[]{String.valueOf(id)});
        cursorListaProdutos = getListaProdutos(tabelaListaProdutos);
        assertEquals(2, cursorListaProdutos.getCount());

        getListaProdutosComID(cursorListaProdutos, idPacotesArroz);
        getListaProdutosComID(cursorListaProdutos, idPacotesAtum);

        BdTableComprasEfetuadas tabelaComprasEfetuadas = new BdTableComprasEfetuadas(db);


        // Teste read Compras Efetuadas (cRud)
        Cursor cursorComprasEfetuadas = getComprasEfetuadas(tabelaComprasEfetuadas);
        assertEquals(0, cursorComprasEfetuadas.getCount());

        // Teste create/read Compras Efetuadas (CRud)

        int quantidade = 3;


        id = (long) criaComprasEfetuadas(tabelaComprasEfetuadas, quantidade,idPacotesArroz);
        cursorComprasEfetuadas = getComprasEfetuadas(tabelaComprasEfetuadas);
        assertEquals(1, cursorComprasEfetuadas.getCount());

        ComprasEfetuadas comprasEfetuadas = getComprasEfetuadasComID(cursorComprasEfetuadas, id);
        assertEquals(quantidade, comprasEfetuadas.getQuantidade());
        assertEquals(idPacotesArroz, comprasEfetuadas.getLista_produtos());


        quantidade = 14;


        id = (long) criaComprasEfetuadas(tabelaComprasEfetuadas,quantidade,idPacotesAtum);
        cursorComprasEfetuadas = getComprasEfetuadas(tabelaComprasEfetuadas);
        assertEquals(2, cursorComprasEfetuadas.getCount());

        comprasEfetuadas = getComprasEfetuadasComID(cursorComprasEfetuadas, id);
        assertEquals(quantidade, comprasEfetuadas.getQuantidade());
        assertEquals(idPacotesAtum, comprasEfetuadas.getLista_produtos());


        // Teste read/update compras efetuadas (cRUd)
        comprasEfetuadas = getComprasEfetuadasComID(cursorComprasEfetuadas, id);

        quantidade = 7;


        comprasEfetuadas.setQuantidade(quantidade);


        tabelaComprasEfetuadas.update(comprasEfetuadas.getContentValues(), BdTableComprasEfetuadas._ID + "=?", new String[]{String.valueOf(id)});

        cursorComprasEfetuadas = getComprasEfetuadas(tabelaComprasEfetuadas);

        comprasEfetuadas = (ComprasEfetuadas) getComprasEfetuadasComID(cursorComprasEfetuadas, id);
        assertEquals(quantidade, comprasEfetuadas.getQuantidade());
        assertEquals(idPacotesArroz, comprasEfetuadas.getLista_produtos());

        // Teste read/delete compras efetuadas (cRuD)
        tabelaComprasEfetuadas.delete(BdTableComprasEfetuadas._ID + "=?", new String[]{String.valueOf(id)});
        cursorComprasEfetuadas = getComprasEfetuadas(tabelaComprasEfetuadas);
        assertEquals(2, cursorComprasEfetuadas.getCount());

        BdTableDinheiroGasto tabelaDinheiroGasto = new BdTableDinheiroGasto(db);

        // Teste read dinheiro gasto (cRud)
        Cursor cursorDinheiroGasto = getDinheiroGasto(tabelaDinheiroGasto);
        assertEquals(0, cursorDinheiroGasto.getCount());

        // Teste create/read dinheiro gasto (CRud)
        String data = "26/04/2019";
        int montante_gasto = 36;

        long idDinheiro = criaDinheiroGasto(tabelaDinheiroGasto, data,montante_gasto);
        cursorDinheiroGasto = getDinheiroGasto(tabelaDinheiroGasto);
        assertEquals(1, cursorDinheiroGasto.getCount());

        DinheiroGasto dinheiroGasto =  getDinheiroGastoComID(cursorDinheiroGasto, idDinheiro);
        assertEquals(data, dinheiroGasto.getData());
        assertEquals(montante_gasto, dinheiroGasto.getMontante_gasto());


        data = "2/06/2019";
        montante_gasto = 139;
         idDinheiro = criaDinheiroGasto(tabelaDinheiroGasto, data, montante_gasto);
        cursorDinheiroGasto = getDinheiroGasto(tabelaDinheiroGasto);
        assertEquals(2, cursorDinheiroGasto.getCount());

        dinheiroGasto = getDinheiroGastoComID(cursorDinheiroGasto, idDinheiro);
        assertEquals(data, dinheiroGasto.getData());
        assertEquals(montante_gasto, dinheiroGasto.getMontante_gasto());


        // Teste read/update dinheiro gasto (cRUd)
        dinheiroGasto = getDinheiroGastoComID(cursorDinheiroGasto,id);
        data = " 2/06/2019 ";
        montante_gasto = 145;
        dinheiroGasto.setData(data);
        dinheiroGasto.setMontante_gasto(montante_gasto);


        tabelaDinheiroGasto.update(dinheiroGasto.getContentValues(), BdTableDinheiroGasto._ID + "=?", new String[]{String.valueOf(id)});

        cursorDinheiroGasto = getDinheiroGasto(tabelaDinheiroGasto);

        dinheiroGasto = getDinheiroGastoComID(cursorDinheiroGasto, id);
        assertEquals(data, dinheiroGasto.getData());
        assertEquals(montante_gasto, dinheiroGasto.getMontante_gasto());


        // Teste read/delete dinheiro gasto (cRuD)



        tabelaDinheiroGasto.delete(BdTableDinheiroGasto._ID + "=?", new String[]{String.valueOf(id)});
        cursorDinheiroGasto = getDinheiroGasto(tabelaDinheiroGasto);
        assertEquals(2, cursorDinheiroGasto.getCount());

        getDinheiroGastoComID(cursorDinheiroGasto, idDinheiro);



    }



    private long criaListaProdutos(BdTableListaProdutos tabelaListaProdutos, String nome_produto){// int quantidade) {
          ListaProdutos lista_produtos = new ListaProdutos();
        lista_produtos.setNome_produto(nome_produto);
        //lista_produtos.setQuantidade(quantidade);

        long id = tabelaListaProdutos.insert(lista_produtos.getContentValues());
        assertNotEquals(-1, id);

        return id;
    }

    private Cursor getListaProdutos(BdTableListaProdutos tabelaListaProdutos) {
        return tabelaListaProdutos.query(BdTableListaProdutos.TODAS_COLUNAS, null, null, null, null, null);
    }

    private ListaProdutos getListaProdutosComID(Cursor cursor, long id) {
        ListaProdutos lista_produtos = null;

        while (cursor.moveToNext()) {
            if (ListaProdutos.fromCursor(cursor).getId() == id) {
                lista_produtos = ListaProdutos.fromCursor(cursor);
                break;
            }
        }

        assertNotNull(lista_produtos);

        return lista_produtos;
    }

    private long criaComprasEfetuadas(BdTableComprasEfetuadas tabelaComprasEfetuadas /*String nome_produto*/, int quantidade, long idPacotesAtum) {

        ComprasEfetuadas comprasEfetuadas = new ComprasEfetuadas();
        //comprasEfetuadas.setNome_produto(nome_produto);
        comprasEfetuadas.setQuantidade(quantidade);
        comprasEfetuadas.setLista_produtos(idPacotesAtum);

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



    private long criaDinheiroGasto(BdTableDinheiroGasto tabelaDinheiroGasto, String data, int montante_gasto) {
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
}
