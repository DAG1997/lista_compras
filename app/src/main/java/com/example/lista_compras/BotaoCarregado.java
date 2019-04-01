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


    }

    private void botaoCarregado() {
        Intent intent = getIntent();
        String descricao = intent.getStringExtra("Descricao");
        Toast.makeText(this, descricao, Toast.LENGTH_SHORT).show();
    }

}
