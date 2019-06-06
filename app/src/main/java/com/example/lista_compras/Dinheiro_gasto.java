package com.example.lista_compras;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Dinheiro_gasto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dinheiro_gasto);


        Button btn = (Button) findViewById(R.id.button10);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openinserir_dinheiro_gasto();

            }
        });

        Button btn2 = (Button) findViewById(R.id.button11);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openalterar_dinheiro_gasto();

            }
        });

        Button btn3 = (Button) findViewById(R.id.button12);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openeliminar_dinheiro_gasto();

            }
        });
    }

    public void openinserir_dinheiro_gasto(){
        Intent intent = new Intent(this, inserir_dinheiro_gasto.class);
        startActivity(intent);
    }

    public void openalterar_dinheiro_gasto(){
        Intent intent = new Intent(this, alterar_dinheiro_gasto.class);
        startActivity(intent);
    }

    public void openeliminar_dinheiro_gasto(){
        Intent intent = new Intent(this, eliminar_dinheiro_gasto.class);
        startActivity(intent);
    }




}

