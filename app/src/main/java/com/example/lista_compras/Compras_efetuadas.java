package com.example.lista_compras;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Compras_efetuadas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compras_efetuadas);
        Button btn = (Button) findViewById(R.id.button7);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openinserir_compras_efetuadas();

            }
        });

        Button btn2 = (Button) findViewById(R.id.button8);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openalterar_compras_efetuadas();

            }
        });

        Button btn3 = (Button) findViewById(R.id.button9);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openeliminar_compras_efetuadas();

            }
        });
    }

    public void openinserir_compras_efetuadas(){
        Intent intent = new Intent(this, inserir_compras_efetuadas.class);
        startActivity(intent);
    }

    public void openalterar_compras_efetuadas(){
        Intent intent = new Intent(this, alterar_compras_efetuadas.class);
        startActivity(intent);
    }

    public void openeliminar_compras_efetuadas(){
        Intent intent = new Intent(this, eliminar_compras_efetuadas.class);
        startActivity(intent);
    }




}




