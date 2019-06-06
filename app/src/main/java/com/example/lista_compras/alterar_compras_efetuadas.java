package com.example.lista_compras;

import android.os.Bundle;

import com.google.android.material.textfield.TextInputLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class alterar_compras_efetuadas extends AppCompatActivity {

    private TextInputLayout inserircompras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar_compras_efetuadas);


        inserircompras = findViewById(R.id.textInputLayout10);
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
        Toast.makeText(alterar_compras_efetuadas.this, "Dados inseridos com sucesso!!!", Toast.LENGTH_SHORT).show();
        finish();
    }

    public void Cancelar (View v) {
        finish();
    }


}


