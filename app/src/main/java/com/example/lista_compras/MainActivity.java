package com.example.lista_compras;

import android.content.Context;
import android.content.CursorLoader;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {
    private static final int ID_CURSOR_LOADER_LISTA_COMPRAS = 0;
    public static final String ID_LISTAPRODUTOS = "ID_LISTAPRODUTOS";

    private Adaptador_Lista_Compras adaptadorListaProdutos;
    private RecyclerView recyclerViewListaProdutos;
    private RecyclerView recyclerViewComprasEfetuadas;
    private Adaptador_Compras_Efetuadas adaptador_compras_efetuadas;
    private RecyclerView recyclerViewDinheiroGasto;
    private Adaptador_DinheiroGasto adaptador_dinheiro_gasto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.id.button);
        getSupportLoaderManager().initLoader(ID_CURSOR_LOADER_LISTA_COMPRAS, null, this);


        recyclerViewListaProdutos = (RecyclerView) findViewById(R.id.recyclerViewListaProdutos);
        adaptadorListaProdutos = new Adaptador_Lista_Compras(this);
        recyclerViewListaProdutos.setAdapter(adaptadorListaProdutos);
        recyclerViewListaProdutos.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewComprasEfetuadas = (RecyclerView) findViewById(R.id.recyclerViewComprasEfetuadas);
        adaptador_compras_efetuadas = new Adaptador_Compras_Efetuadas(this);
        recyclerViewComprasEfetuadas.setAdapter(adaptador_compras_efetuadas);
        recyclerViewComprasEfetuadas.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewDinheiroGasto = (RecyclerView) findViewById(R.id.recyclerViewDinheiroGasto);
        adaptador_dinheiro_gasto = new Adaptador_DinheiroGasto(this) ;
        recyclerViewDinheiroGasto.setAdapter(adaptador_dinheiro_gasto);
        recyclerViewDinheiroGasto.setLayoutManager(new LinearLayoutManager(this));





        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Lista com os produtos a adquirir", Toast.LENGTH_SHORT).show();
                openBotaoCarregado();
            }


        });

        Button btn2 = (Button) findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Lista com as compras efetuadas", Toast.LENGTH_SHORT).show();
                openCompras_efetuadas();
            }
        });

        Button btn3 = (Button) findViewById(R.id.button3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Dinheiro gasto em compras ao longo do tempo", Toast.LENGTH_SHORT).show();
                openDinheiro_gasto();
            }
        });








    }
    @Override
    protected void onResume() {
        getSupportLoaderManager().restartLoader(ID_CURSOR_LOADER_LISTA_COMPRAS, null, this);

        super.onResume();
    }

    public Menu menu;

    public void atualizaOpcoesMenu() {
        ListaProdutos listaProdutos = adaptadorListaProdutos.getListaProdutosSelecionada();
        ComprasEfetuadas comprasEfetuadas = adaptador_compras_efetuadas.getComprasEfetuadasSelecionadas();
        DinheiroGasto dinheiroGasto = adaptador_dinheiro_gasto.getDinheiroGastoSelecionado();

        /*boolean mostraAlterarEliminar = (livro != null);

        menu.findItem(R.id.action_alterar).setVisible(mostraAlterarEliminar);
        menu.findItem(R.id.action_eliminar).setVisible(mostraAlterarEliminar);*/
    }



        @Override
        public boolean onCreateOptionsMenu (Menu menu){
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

            this.menu = menu;
        return true;
    }

        @Override
        public boolean onOptionsItemSelected (MenuItem item){
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        /*} else if (id == R.id.action_inserir) {
            Intent intent = new Intent(this, InserirLivroActivity.class);
            startActivity(intent);

            return true;
        } else if (id == R.id.action_alterar) {
            Intent intent = new Intent(this, AlterarLivroActivity.class);
            intent.putExtra(ID_LIVRO, adaptadorLivros.getLivroSelecionado().getId());

            startActivity(intent);

            return true;
        } else if (id == R.id.action_eliminar) {
            Intent intent = new Intent(this, EliminarLivroActivity.class);
            intent.putExtra(ID_LIVRO, adaptadorLivros.getLivroSelecionado().getId());

            startActivity(intent);

            return true;
        }*/

        }

        return super.onOptionsItemSelected(item);
    }


    public void openBotaoCarregado(){
        Intent intent = new Intent(this,BotaoCarregado.class);
        startActivity(intent);


    }

    public void openCompras_efetuadas(){
        Intent intent = new Intent(this,Compras_efetuadas.class);
        startActivity(intent);
    }

    public void openDinheiro_gasto(){
        Intent intent = new Intent(this,Dinheiro_gasto.class);
        startActivity(intent);
    }
    /**
     * Instantiate and return a new Loader for the given ID.
     *
     * <p>This will always be called from the process's main thread.
     *
     * @param id   The ID whose loader is to be created.
     * @param args Any arguments supplied by the caller.
     * @return Return a new Loader instance that is ready to start loading.
     */
    @NonNull
    @Override
    public Loader<Cursor> onCreateLoader(int id, @Nullable Bundle args) {
        androidx.loader.content.CursorLoader cursorLoader = new androidx.loader.content.CursorLoader(this, Compras_Efetuadas_ContentProvider.ENDERECO_COMPRASEFETUADAS, BdTableComprasEfetuadas.TODAS_COLUNAS, null, null, BdTableComprasEfetuadas.QUANTIDADE
        );

        return cursorLoader;
    }
    /**
     * Called when a previously created loader has finished its load.  Note
     * that normally an application is <em>not</em> allowed to commit fragment
     * transactions while in this call, since it can happen after an
     * activity's state is saved.  See {@link FragmentManager#beginTransaction()
     * FragmentManager.openTransaction()} for further discussion on this.
     *
     * <p>This function is guaranteed to be called prior to the release of
     * the last data that was supplied for this Loader.  At this point
     * you should remove all use of the old data (since it will be released
     * soon), but should not do your own release of the data since its Loader
     * owns it and will take care of that.  The Loader will take care of
     * management of its data so you don't have to.  In particular:
     *
     * <ul>
     * <li> <p>The Loader will monitor for changes to the data, and report
     * them to you through new calls here.  You should not monitor the
     * data yourself.  For example, if the data is a {@link Cursor}
     * and you place it in a {@link CursorAdapter}, use
     * the {@link CursorAdapter#CursorAdapter(Context,
     * Cursor, int)} constructor <em>without</em> passing
     * in either {@link CursorAdapter#FLAG_AUTO_REQUERY}
     * or {@link CursorAdapter#FLAG_REGISTER_CONTENT_OBSERVER}
     * (that is, use 0 for the flags argument).  This prevents the CursorAdapter
     * from doing its own observing of the Cursor, which is not needed since
     * when a change happens you will get a new Cursor throw another call
     * here.
     * <li> The Loader will release the data once it knows the application
     * is no longer using it.  For example, if the data is
     * a {@link Cursor} from a {@link CursorLoader},
     * you should not call close() on it yourself.  If the Cursor is being placed in a
     * {@link CursorAdapter}, you should use the
     * {@link CursorAdapter#swapCursor(Cursor)}
     * method so that the old Cursor is not closed.
     * </ul>
     *
     * <p>This will always be called from the process's main thread.
     *
     * @param loader The Loader that has finished.
     * @param data   The data generated by the Loader.
     */
    @Override
    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor data) {
        adaptadorListaProdutos.setCursor(data);
        adaptador_compras_efetuadas.setCursor(data);
        adaptador_dinheiro_gasto.setCursor(data);

    }

    /**
     * Called when a previously created loader is being reset, and thus
     * making its data unavailable.  The application should at this point
     * remove any references it has to the Loader's data.
     *
     * <p>This will always be called from the process's main thread.
     *
     * @param loader The Loader that is being reset.
     */
    @Override
    public void onLoaderReset(@NonNull Loader<Cursor> loader){
        adaptadorListaProdutos.setCursor(null);
        adaptador_compras_efetuadas.setCursor(null);
        adaptador_dinheiro_gasto.setCursor(null);
    }
}
