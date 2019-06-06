/*package com.example.lista_compras;

import android.content.Context;
import android.content.CursorLoader;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class Inserir_Compras_Efetuadas extends AppCompatActivity  implements LoaderManager.LoaderCallbacks<Cursor> {

    private static final int ID_CURSO_LOADER_COMPRAS_EFETUADAS = 0;

    private EditText editTextQuantidade;
    private Spinner spinnerComprasEfetuadas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserir_livro);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        editTextQuantidade = (EditText) findViewById(R.id.editTextQuantidade);
        spinnerComprasEfetuadas = (Spinner) findViewById(R.id.spinnerCategorias);


        getSupportLoaderManager().initLoader(ID_CURSO_LOADER_COMPRAS_EFETUADAS, null, this);
    }

    @Override
    protected void onResume() {
        getSupportLoaderManager().restartLoader(ID_CURSO_LOADER_COMPRAS_EFETUADAS, null, this);

        super.onResume();
    }

    private void mostraComprasEfetuadasSpinner(Cursor cursorComprasEfetuadas) {
        SimpleCursorAdapter adaptadorComprasEfetuadas = new SimpleCursorAdapter(
                this,
                android.R.layout.simple_list_item_1,
                cursorComprasEfetuadas,
                new String[]{BdTableComprasEfetuadas.QUANTIDADE},
                new int[]{android.R.id.text1}
        );
        spinnerComprasEfetuadas.setAdapter(adaptadorComprasEfetuadas);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_guardar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        } else if (id == R.id.action_guardar) {
            guardar();
            return true;
        } else if (id == R.id.action_cancelar) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void guardar() {
        String quantidade = editTextQuantidade.getText().toString();

        if (quantidade.trim().isEmpty()) {
            editTextQuantidade.setError(getString(R.string.preencha_quantidade));
            return;
        }


        long idComprasEfetuadas = spinnerComprasEfetuadas.getSelectedItemId();

        // guardar os dados
        ComprasEfetuadas comprasEfetuadas = new ComprasEfetuadas();

        comprasEfetuadas.setQuantidade(quantidade);

        try {
            getContentResolver().insert(Compras_Efetuadas_ContentProvider.ENDERECO_COMPRASEFETUADAS, comprasEfetuadas.getContentValues());

            Toast.makeText(this, getString(R.string.livro_guardado_sucesso), Toast.LENGTH_SHORT).show();
            finish();
        } catch (Exception e) {
            Snackbar.make(
                    editTextQuantidade,
                    getString(R.string.erro_guardar_livro),
                    Snackbar.LENGTH_LONG)
                    .show();

            e.printStackTrace();
        }
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
  /*  @NonNull
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
   /* @Override
    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor data) {
        mostraComprasEfetuadasSpinner(data);
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
   /* @Override
    public void onLoaderReset(@NonNull Loader<Cursor> loader) {
        mostraComprasEfetuadasSpinner(null);
    }
}

*/