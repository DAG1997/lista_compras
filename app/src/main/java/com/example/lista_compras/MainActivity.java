package com.example.lista_compras;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
        }

        return super.onOptionsItemSelected(item);
    }



    public void botaoCarregado(View view) {
        Intent intent = new Intent(this, BotaoCarregado.class);
        intent.putExtra(AppConsts.DESCRICAO, "Lista com os produtos a adquirir");
        startActivity(intent);
    }

    public void botaoCarregado2(View view) {
        Intent intent = new Intent(this, BotaoCarregado.class);
        intent.putExtra(AppConsts.DESCRICAO_2, "Lista com as compras efetuadas");
        startActivity(intent);
    }

    public void botaoCarregado3(View view) {
        Intent intent = new Intent(this, BotaoCarregado.class);
        intent.putExtra(AppConsts.DESCRICAO_3, "Dinheiro gasto em compras ao longo do tempo");
        startActivity(intent);
    }
}
