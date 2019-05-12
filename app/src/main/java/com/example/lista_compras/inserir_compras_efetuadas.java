package com.example.lista_compras;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class inserir_compras_efetuadas extends AppCompatActivity {
    private TextInputLayout inserircompras;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserir_compras_efetuadas);


        inserircompras = findViewById(R.id.textInputLayout5);
    }

    private boolean Validacao() {
        String compras = inserircompras.getEditText().getText().toString().trim();
        /*String compras2 = inserircompras.getEditText().getText().toString().trim();*/

        if (compras.isEmpty()) {
            inserircompras.setError("Por favor introduza um nome!");

            return false;
        } else {
            inserircompras.setError(null);
        }
        return true;
    }




    public void Guardar (View v) {
        if(!Validacao())
            return;
        Toast.makeText(inserir_compras_efetuadas.this, "Dados inseridos com sucesso!!!", Toast.LENGTH_SHORT).show();
        finish();
    }

    public void Cancelar (View v) {
        finish();
    }


}



