package com.example.lista_compras;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class BotaoCarregado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_botao_carregado);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        botaoCarregado();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        botaoCarregado2();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        botaoCarregado3();

    }

    private void botaoCarregado() {
        Intent intent = getIntent();
        String descricao = intent.getStringExtra("Descricao");
        Toast.makeText(this, descricao, Toast.LENGTH_SHORT).show();
    }

        private void botaoCarregado2(){
            Intent intent1 = getIntent();


            String descricao2 = intent1.getStringExtra("Descricao2");
            Toast.makeText(this, descricao2, Toast.LENGTH_SHORT).show();
        }

        private void botaoCarregado3(){
            Intent intent2 = getIntent();

            String descricao3 = intent2.getStringExtra("Descricao3");
        Toast.makeText(this,descricao3, Toast.LENGTH_SHORT).show();
    }

}
