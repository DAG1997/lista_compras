package com.example.lista_compras;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class eliminar_dinheiro_gasto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_dinheiro_gasto);



        Button btn = (Button) findViewById(R.id.button29);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(eliminar_dinheiro_gasto.this, "Dados Eliminados com Sucesso!!!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        Button btn2 = (Button) findViewById(R.id.button30);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


}