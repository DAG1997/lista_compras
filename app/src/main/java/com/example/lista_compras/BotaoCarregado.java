package com.example.lista_compras;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class BotaoCarregado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_botao_carregado);
        Button btn = (Button) findViewById(R.id.button4);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openinserir_lista_produtos();

            }
        });

        Button btn2 = (Button) findViewById(R.id.button5);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openalterar_lista_produtos();

            }
        });

        Button btn3 = (Button) findViewById(R.id.button6);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openeliminar_lista_produtos();

            }
        });
    }

    public void openinserir_lista_produtos(){
        Intent intent = new Intent(this, Inserir_lista_produtos.class);
        startActivity(intent);
    }

    public void openalterar_lista_produtos(){
        Intent intent = new Intent(this, alterar_lista_produtos.class);
        startActivity(intent);
    }

    public void openeliminar_lista_produtos(){
        Intent intent = new Intent(this, eliminar_lista_produtos.class);
        startActivity(intent);
    }




    }




