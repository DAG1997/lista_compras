package com.example.lista_compras;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class eliminar_lista_produtos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_lista_produtos);

        Button btn = (Button) findViewById(R.id.button25);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(eliminar_lista_produtos.this, "Dados Eliminados com Sucesso!!!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        Button btn2 = (Button) findViewById(R.id.button26);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


}





