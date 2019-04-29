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
    /*private TextInputLayout inserircompras2;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserir_compras_efetuadas);


        inserircompras = findViewById(R.id.textInputLayout5);
        /*inserircompras = findViewById(R.id.textInputLayout6);*/
    }

    private boolean Validacao() {
        String compras = inserircompras.getEditText().getText().toString().trim();
        /*String compras2 = inserircompras2.getEditText().getText().toString().trim();*/

        if (compras.isEmpty() /*|| compras2.isEmpty()*/) {
            inserircompras.setError("Por favor introduza um nome!");
            /*inserircompras2.setError("Por favor introduza um numero de 0 a 100!");*/

            return false;
        } else {
            inserircompras.setError(null);
            /*inserircompras2.setError(null);*/
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



